/*******************************************************************************
 * Copyright (c) 2001, 2004 IBM Corporation and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *     IBM Corporation - initial API and implementation
 *******************************************************************************/
package org.eclipse.datatools.connectivity.sqm.core.ui.explorer.providers.content.virtual;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.eclipse.core.runtime.IAdaptable;
import org.eclipse.core.runtime.Platform;
import org.eclipse.datatools.connectivity.sqm.core.containment.ContainmentService;
import org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode;
import org.eclipse.datatools.connectivity.sqm.internal.core.RDBCorePlugin;
import org.eclipse.datatools.connectivity.sqm.internal.core.connection.ConnectionInfo;
import org.eclipse.datatools.connectivity.sqm.internal.core.connection.DatabaseConnectionRegistry;
import org.eclipse.datatools.modelbase.sql.schema.Database;
import org.eclipse.datatools.modelbase.sql.schema.SQLObject;
import org.eclipse.emf.ecore.EClass;


/**
 * @author ljulien
 */
public abstract class VirtualNode implements IVirtualNode, IAdaptable
{
	private String name;
	private String displayName;
	private Object parent;
	private List children = new LinkedList ();
	
	public VirtualNode (String name, String displayName, Object parent)
	{
		this.name = name;
		this.displayName = displayName;
		this.parent = parent;
		if (parent != null && parent instanceof IVirtualNode)
		{
		    ((IVirtualNode)parent).addChildren(this);
		}
	}
	
	/**
	 * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#getName()
	 */
	public String getName()
	{
		return this.name;
	}

	/**
	 * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#getDisplayName()
	 */
	public String getDisplayName()
	{
		return this.displayName != null? this.displayName : this.name;
	}

    /**
     * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#getParent()
     */
    public Object getParent()
    {
        return parent;
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#getChildren()
     */
    protected List getChildren()
    {
        return children;
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#hasChildren()
     */
    public boolean hasChildren()
    {
        return !children.isEmpty();
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#getChildrenArray()
     */
    public Object[] getChildrenArray()
    {
        return children.toArray(new Object [children.size()]);
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#addChildren(java.lang.Object)
     */
    public void addChildren(Object child)
    {
        if (!children.contains(child))
        {
            children.add(child);
        }
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#removeChildren(java.lang.Object)
     */
    public void removeChildren(Object child)
    {
        if (children.contains(child))
        {
            children.remove(child);
        }
    }

    /**
     * Will remove all the children include in the Children collection
     */
    public void removeAllChildren ()
    {
        children.removeAll(children);
    }
    
    /**
     * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#supports(org.eclipse.emf.ecore.EClass)
     */
    public boolean supports(EClass type)
    {
        return false;
    }

    /**
     * @see org.eclipse.datatools.connectivity.sqm.core.ui.explorer.virtual.IVirtualNode#addChildren(java.util.Collection)
     */
    public void addChildren(Collection collection)
    {
        children.removeAll(children);
        children.addAll(collection);
    }

	public ConnectionInfo getParentConnection() {
		return DatabaseConnectionRegistry.getInstance().getConnectionForDatabase(getDatabase());
	}
	
	protected SQLObject getParentSQLObject() {
		Object parent = this;
		while (parent != null
				&& !(parent instanceof SQLObject)
				&& !((parent = ((IVirtualNode) parent).getParent()) instanceof SQLObject))
			;
		return parent instanceof SQLObject ? (SQLObject) parent : null;
	}
	
	protected Database getDatabase() {
	    ContainmentService containment = RDBCorePlugin.getDefault()
				.getContainmentService();
		SQLObject sqlObject = getParentSQLObject();
		while (sqlObject != null
				&& !(sqlObject instanceof Database)
				&& !((sqlObject = (SQLObject) containment
						.getContainer(sqlObject)) instanceof Database))
			;
		return sqlObject instanceof Database ? (Database) sqlObject : null;
	}

	public Object getAdapter(Class adapter) {
		if (adapter.isInstance(this)) {
			return this;
		}
		return Platform.getAdapterManager().getAdapter(this,adapter);
	}
	
}