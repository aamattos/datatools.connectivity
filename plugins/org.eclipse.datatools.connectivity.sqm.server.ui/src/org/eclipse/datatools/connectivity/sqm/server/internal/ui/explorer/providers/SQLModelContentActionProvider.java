/*******************************************************************************
 * Copyright (c) 2006 Sybase, Inc.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    rcernich - initial API and implementation
 *******************************************************************************/ 
package org.eclipse.datatools.connectivity.sqm.server.internal.ui.explorer.providers;

import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.Separator;
import org.eclipse.jface.viewers.StructuredViewer;
import org.eclipse.ui.IActionBars;
import org.eclipse.ui.IMemento;
import org.eclipse.ui.IViewPart;
import org.eclipse.ui.actions.ActionContext;
import org.eclipse.ui.dialogs.PropertyDialogAction;
import org.eclipse.ui.navigator.ICommonActionProvider;
import org.eclipse.ui.navigator.INavigatorContentService;


public class SQLModelContentActionProvider implements ICommonActionProvider {
	
	private PropertyDialogAction mPropertiesAction;

	public SQLModelContentActionProvider() {
		super();
	}

	public void init(String anExtensionId, IViewPart aViewPart,
			INavigatorContentService aContentService,
			StructuredViewer aStructuredViewer) {
		mPropertiesAction = new PropertyDialogAction(aViewPart.getViewSite()
				.getShell(), aViewPart.getViewSite().getSelectionProvider());
	}

	public void dispose() {
	}

	public void setActionContext(ActionContext aContext) {
	}

	public boolean fillContextMenu(IMenuManager aMenu) {
		aMenu.add(new Separator("additions"));
		aMenu.add(mPropertiesAction);
		return true;
	}

	public boolean fillActionBars(IActionBars theActionBars) {
		return false;
	}

	public void restoreState(IMemento aMemento) {
	}

	public void saveState(IMemento aMemento) {
	}

}
