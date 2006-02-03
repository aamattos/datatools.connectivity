/**
 *************************************************************************
 * Copyright (c) 2005, 2006 Actuate Corporation.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *  Actuate Corporation  - initial API and implementation
 *  
 *************************************************************************
 *
 * $Id: DesignSessionRequestImpl.java,v 1.1 2005/12/29 04:17:54 lchan Exp $
 */
package org.eclipse.datatools.connectivity.oda.design.impl;

import org.eclipse.datatools.connectivity.oda.design.DataAccessDesign;
import org.eclipse.datatools.connectivity.oda.design.DataSourceDesign;
import org.eclipse.datatools.connectivity.oda.design.DesignFactory;
import org.eclipse.datatools.connectivity.oda.design.DesignPackage;
import org.eclipse.datatools.connectivity.oda.design.DesignSessionRequest;
import org.eclipse.datatools.connectivity.oda.design.DesignerState;
import org.eclipse.datatools.connectivity.oda.design.Locale;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Session Request</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.eclipse.datatools.connectivity.oda.design.impl.DesignSessionRequestImpl#getDataAccessDesign <em>Data Access Design</em>}</li>
 *   <li>{@link org.eclipse.datatools.connectivity.oda.design.impl.DesignSessionRequestImpl#isEditable <em>Editable</em>}</li>
 *   <li>{@link org.eclipse.datatools.connectivity.oda.design.impl.DesignSessionRequestImpl#getSessionLocale <em>Session Locale</em>}</li>
 *   <li>{@link org.eclipse.datatools.connectivity.oda.design.impl.DesignSessionRequestImpl#getDesignerState <em>Designer State</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DesignSessionRequestImpl extends EObjectImpl implements DesignSessionRequest
{
    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public static final String copyright = "Copyright (c) 2005, 2006 Actuate Corporation"; //$NON-NLS-1$

    /**
     * The cached value of the '{@link #getDataAccessDesign() <em>Data Access Design</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDataAccessDesign()
     * @generated
     * @ordered
     */
    protected DataAccessDesign m_dataAccessDesign = null;

    /**
     * The default value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected static final boolean EDITABLE_EDEFAULT = true;

    /**
     * The cached value of the '{@link #isEditable() <em>Editable</em>}' attribute.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #isEditable()
     * @generated
     * @ordered
     */
    protected boolean m_editable = EDITABLE_EDEFAULT;

    /**
     * This is true if the Editable attribute has been set.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     * @ordered
     */
    protected boolean m_editableESet = false;

    /**
     * The cached value of the '{@link #getSessionLocale() <em>Session Locale</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getSessionLocale()
     * @generated
     * @ordered
     */
    protected Locale m_sessionLocale = null;

    /**
     * The cached value of the '{@link #getDesignerState() <em>Designer State</em>}' containment reference.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see #getDesignerState()
     * @generated
     * @ordered
     */
    protected DesignerState m_designerState = null;

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected DesignSessionRequestImpl()
    {
        super();
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    protected EClass eStaticClass()
    {
        return DesignPackage.eINSTANCE.getDesignSessionRequest();
    }

    /* (non-Javadoc)
     * @see org.eclipse.datatools.connectivity.oda.design.DesignSessionRequest#setNewDataAccessDesign(org.eclipse.datatools.connectivity.oda.design.DataSourceDesign)
     */
    public void setNewDataAccessDesign( DataSourceDesign dataSourceDesign )
    {
        DataAccessDesign newAccessDesign =
            DesignFactory.eINSTANCE.createDataAccessDesign();
        newAccessDesign.setNewDataSetDesign( dataSourceDesign );
        
        setDataAccessDesign( newAccessDesign );
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DataAccessDesign getDataAccessDesign()
    {
        return m_dataAccessDesign;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDataAccessDesign( DataAccessDesign newDataAccessDesign, NotificationChain msgs )
    {
        DataAccessDesign oldDataAccessDesign = m_dataAccessDesign;
        m_dataAccessDesign = newDataAccessDesign;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DesignPackage.DESIGN_SESSION_REQUEST__DATA_ACCESS_DESIGN, oldDataAccessDesign, newDataAccessDesign);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDataAccessDesign( DataAccessDesign newDataAccessDesign )
    {
        if (newDataAccessDesign != m_dataAccessDesign)
        {
            NotificationChain msgs = null;
            if (m_dataAccessDesign != null)
                msgs = ((InternalEObject)m_dataAccessDesign).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DesignPackage.DESIGN_SESSION_REQUEST__DATA_ACCESS_DESIGN, null, msgs);
            if (newDataAccessDesign != null)
                msgs = ((InternalEObject)newDataAccessDesign).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DesignPackage.DESIGN_SESSION_REQUEST__DATA_ACCESS_DESIGN, null, msgs);
            msgs = basicSetDataAccessDesign(newDataAccessDesign, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.DESIGN_SESSION_REQUEST__DATA_ACCESS_DESIGN, newDataAccessDesign, newDataAccessDesign));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isEditable()
    {
        return m_editable;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setEditable( boolean newEditable )
    {
        boolean oldEditable = m_editable;
        m_editable = newEditable;
        boolean oldEditableESet = m_editableESet;
        m_editableESet = true;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.DESIGN_SESSION_REQUEST__EDITABLE, oldEditable, m_editable, !oldEditableESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void unsetEditable()
    {
        boolean oldEditable = m_editable;
        boolean oldEditableESet = m_editableESet;
        m_editable = EDITABLE_EDEFAULT;
        m_editableESet = false;
        if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.UNSET, DesignPackage.DESIGN_SESSION_REQUEST__EDITABLE, oldEditable, EDITABLE_EDEFAULT, oldEditableESet));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean isSetEditable()
    {
        return m_editableESet;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Locale getSessionLocale()
    {
        return m_sessionLocale;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetSessionLocale( Locale newSessionLocale, NotificationChain msgs )
    {
        Locale oldSessionLocale = m_sessionLocale;
        m_sessionLocale = newSessionLocale;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DesignPackage.DESIGN_SESSION_REQUEST__SESSION_LOCALE, oldSessionLocale, newSessionLocale);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setSessionLocale( Locale newSessionLocale )
    {
        if (newSessionLocale != m_sessionLocale)
        {
            NotificationChain msgs = null;
            if (m_sessionLocale != null)
                msgs = ((InternalEObject)m_sessionLocale).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DesignPackage.DESIGN_SESSION_REQUEST__SESSION_LOCALE, null, msgs);
            if (newSessionLocale != null)
                msgs = ((InternalEObject)newSessionLocale).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DesignPackage.DESIGN_SESSION_REQUEST__SESSION_LOCALE, null, msgs);
            msgs = basicSetSessionLocale(newSessionLocale, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.DESIGN_SESSION_REQUEST__SESSION_LOCALE, newSessionLocale, newSessionLocale));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public DesignerState getDesignerState()
    {
        return m_designerState;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain basicSetDesignerState( DesignerState newDesignerState, NotificationChain msgs )
    {
        DesignerState oldDesignerState = m_designerState;
        m_designerState = newDesignerState;
        if (eNotificationRequired())
        {
            ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, DesignPackage.DESIGN_SESSION_REQUEST__DESIGNER_STATE, oldDesignerState, newDesignerState);
            if (msgs == null) msgs = notification; else msgs.add(notification);
        }
        return msgs;
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void setDesignerState( DesignerState newDesignerState )
    {
        if (newDesignerState != m_designerState)
        {
            NotificationChain msgs = null;
            if (m_designerState != null)
                msgs = ((InternalEObject)m_designerState).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - DesignPackage.DESIGN_SESSION_REQUEST__DESIGNER_STATE, null, msgs);
            if (newDesignerState != null)
                msgs = ((InternalEObject)newDesignerState).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - DesignPackage.DESIGN_SESSION_REQUEST__DESIGNER_STATE, null, msgs);
            msgs = basicSetDesignerState(newDesignerState, msgs);
            if (msgs != null) msgs.dispatch();
        }
        else if (eNotificationRequired())
            eNotify(new ENotificationImpl(this, Notification.SET, DesignPackage.DESIGN_SESSION_REQUEST__DESIGNER_STATE, newDesignerState, newDesignerState));
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public NotificationChain eInverseRemove( InternalEObject otherEnd, int featureID, Class baseClass, NotificationChain msgs )
    {
        if (featureID >= 0)
        {
            switch (eDerivedStructuralFeatureID(featureID, baseClass))
            {
                case DesignPackage.DESIGN_SESSION_REQUEST__DATA_ACCESS_DESIGN:
                    return basicSetDataAccessDesign(null, msgs);
                case DesignPackage.DESIGN_SESSION_REQUEST__SESSION_LOCALE:
                    return basicSetSessionLocale(null, msgs);
                case DesignPackage.DESIGN_SESSION_REQUEST__DESIGNER_STATE:
                    return basicSetDesignerState(null, msgs);
                default:
                    return eDynamicInverseRemove(otherEnd, featureID, baseClass, msgs);
            }
        }
        return eBasicSetContainer(null, featureID, msgs);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public Object eGet( EStructuralFeature eFeature, boolean resolve )
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case DesignPackage.DESIGN_SESSION_REQUEST__DATA_ACCESS_DESIGN:
                return getDataAccessDesign();
            case DesignPackage.DESIGN_SESSION_REQUEST__EDITABLE:
                return isEditable() ? Boolean.TRUE : Boolean.FALSE;
            case DesignPackage.DESIGN_SESSION_REQUEST__SESSION_LOCALE:
                return getSessionLocale();
            case DesignPackage.DESIGN_SESSION_REQUEST__DESIGNER_STATE:
                return getDesignerState();
        }
        return eDynamicGet(eFeature, resolve);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eSet( EStructuralFeature eFeature, Object newValue )
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case DesignPackage.DESIGN_SESSION_REQUEST__DATA_ACCESS_DESIGN:
                setDataAccessDesign((DataAccessDesign)newValue);
                return;
            case DesignPackage.DESIGN_SESSION_REQUEST__EDITABLE:
                setEditable(((Boolean)newValue).booleanValue());
                return;
            case DesignPackage.DESIGN_SESSION_REQUEST__SESSION_LOCALE:
                setSessionLocale((Locale)newValue);
                return;
            case DesignPackage.DESIGN_SESSION_REQUEST__DESIGNER_STATE:
                setDesignerState((DesignerState)newValue);
                return;
        }
        eDynamicSet(eFeature, newValue);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public void eUnset( EStructuralFeature eFeature )
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case DesignPackage.DESIGN_SESSION_REQUEST__DATA_ACCESS_DESIGN:
                setDataAccessDesign((DataAccessDesign)null);
                return;
            case DesignPackage.DESIGN_SESSION_REQUEST__EDITABLE:
                unsetEditable();
                return;
            case DesignPackage.DESIGN_SESSION_REQUEST__SESSION_LOCALE:
                setSessionLocale((Locale)null);
                return;
            case DesignPackage.DESIGN_SESSION_REQUEST__DESIGNER_STATE:
                setDesignerState((DesignerState)null);
                return;
        }
        eDynamicUnset(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public boolean eIsSet( EStructuralFeature eFeature )
    {
        switch (eDerivedStructuralFeatureID(eFeature))
        {
            case DesignPackage.DESIGN_SESSION_REQUEST__DATA_ACCESS_DESIGN:
                return m_dataAccessDesign != null;
            case DesignPackage.DESIGN_SESSION_REQUEST__EDITABLE:
                return isSetEditable();
            case DesignPackage.DESIGN_SESSION_REQUEST__SESSION_LOCALE:
                return m_sessionLocale != null;
            case DesignPackage.DESIGN_SESSION_REQUEST__DESIGNER_STATE:
                return m_designerState != null;
        }
        return eDynamicIsSet(eFeature);
    }

    /**
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    public String toString()
    {
        if ( eIsProxy() ) return super.toString();

        StringBuffer result = new StringBuffer(super.toString());
        result.append(" (editable: "); //$NON-NLS-1$
        if (m_editableESet) result.append(m_editable); else result.append("<unset>"); //$NON-NLS-1$
        result.append(')');
        return result.toString();
    }

} //DesignSessionRequestImpl
