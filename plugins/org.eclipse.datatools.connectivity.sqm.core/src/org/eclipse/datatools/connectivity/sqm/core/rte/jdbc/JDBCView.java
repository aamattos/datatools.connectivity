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
package org.eclipse.datatools.connectivity.sqm.core.rte.jdbc;

import java.lang.ref.SoftReference;
import java.sql.Connection;

import org.eclipse.datatools.connectivity.sqm.core.rte.ICatalogObject;
import org.eclipse.datatools.connectivity.sqm.core.rte.RefreshManager;
import org.eclipse.datatools.connectivity.sqm.loader.JDBCTableColumnLoader;
import org.eclipse.datatools.connectivity.sqm.loader.JDBCTableIndexLoader;
import org.eclipse.datatools.connectivity.sqm.loader.JDBCTableSuperTableLoader;
import org.eclipse.datatools.modelbase.sql.schema.Database;
import org.eclipse.datatools.modelbase.sql.tables.SQLTablesPackage;
import org.eclipse.datatools.modelbase.sql.tables.Table;
import org.eclipse.datatools.modelbase.sql.tables.impl.ViewTableImpl;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EStructuralFeature;


public class JDBCView extends ViewTableImpl implements ICatalogObject {

	public Database getCatalogDatabase() {
		return getSchema().getCatalog().getDatabase();
	}

	public Connection getConnection() {
		Database db = getCatalogDatabase();
		if (db instanceof ICatalogObject) {
			return ((ICatalogObject) db).getConnection();
		}
		return null;
	}

	public void refresh() {
		synchronized (columnsLoaded) {
			if (columnsLoaded.booleanValue()) {
				columnsLoaded = Boolean.FALSE;
				getColumnLoader().clearColumns(super.getColumns());
			}
		}
		synchronized (indexesLoaded) {
			if (indexesLoaded.booleanValue()) {
				indexesLoaded = Boolean.FALSE;
				getIndexLoader().clearIndexes(super.getIndex());
			}
		}
		synchronized (supertableLoaded) {
			if (supertableLoaded.booleanValue()) {
				supertableLoaded = Boolean.FALSE;
				setSupertable(null);
			}
		}

		RefreshManager.getInstance().referesh(this);
	}

	public EList getColumns(){
		synchronized (columnsLoaded) {
			if (!columnsLoaded.booleanValue())
				loadColumns();
		}
		return super.getColumns();
	}

	protected JDBCTableColumnLoader createColumnLoader() {
		return new JDBCTableColumnLoader(this);
	}

	protected final JDBCTableColumnLoader getColumnLoader() {
		if (columnLoaderRef == null || columnLoaderRef.get() == null) {
			columnLoaderRef = new SoftReference(createColumnLoader());
		}
		return (JDBCTableColumnLoader) columnLoaderRef.get();
	}

	private void loadColumns() {
		try {
			super.getColumns().addAll(getColumnLoader().loadColumns());
			columnsLoaded = Boolean.TRUE;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

	public EList getIndex() {
		synchronized (indexesLoaded) {
			if (!indexesLoaded.booleanValue())
				loadIndexes();
		}
		return super.getIndex();
	}

	protected JDBCTableIndexLoader createIndexLoader() {
		return new JDBCTableIndexLoader(this);
	}

	protected final JDBCTableIndexLoader getIndexLoader() {
		if (indexLoaderRef == null || indexLoaderRef.get() == null) {
			indexLoaderRef = new SoftReference(createIndexLoader());
		}
		return (JDBCTableIndexLoader) indexLoaderRef.get();
	}

	private void loadIndexes() {
		try {
			super.getIndex().addAll(getIndexLoader().loadIndexes());
			indexesLoaded = Boolean.TRUE;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public Table getSupertable() {
		synchronized (supertableLoaded) {
			if (!supertableLoaded.booleanValue())
				loadSupertable();
		}
		return super.getSupertable();
	}

	protected JDBCTableSuperTableLoader createSupertableLoader() {
		return new JDBCTableSuperTableLoader(this);
	}

	protected final JDBCTableSuperTableLoader getSupertableLoader() {
		if (supertableLoaderRef == null || supertableLoaderRef.get() == null) {
			supertableLoaderRef = new SoftReference(createSupertableLoader());
		}
		return (JDBCTableSuperTableLoader) supertableLoaderRef.get();
	}

	private void loadSupertable() {
		try {
			setSupertable(getSupertableLoader().loadSuperTable());
			supertableLoaded = Boolean.TRUE;
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean eIsSet(EStructuralFeature eFeature) {
		switch (eDerivedStructuralFeatureID(eFeature)) {
		case SQLTablesPackage.VIEW_TABLE__COLUMNS:
			getColumns();
			break;
		case SQLTablesPackage.VIEW_TABLE__INDEX:
			getIndex();
			break;
		case SQLTablesPackage.VIEW_TABLE__SUPERTABLE:
			getSupertable();
			break;
		}
 
		return super.eIsSet(eFeature);
	}
	
	private Boolean columnsLoaded = Boolean.FALSE;
	private SoftReference columnLoaderRef;
	private Boolean indexesLoaded = Boolean.FALSE;
	private SoftReference indexLoaderRef;
	private Boolean supertableLoaded = Boolean.FALSE;
	private SoftReference supertableLoaderRef;
}