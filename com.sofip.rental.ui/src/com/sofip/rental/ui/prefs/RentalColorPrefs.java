package com.sofip.rental.ui.prefs;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sofip.rental.ui.RentalUIActivator;
import com.sofip.rental.ui.RentalUIConstants;

public class RentalColorPrefs extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage, RentalUIConstants {

	public RentalColorPrefs() {
		super(GRID);
		setPreferenceStore(RentalUIActivator.getDefault().getPreferenceStore());
		setDescription("Demo preference page");
	}


	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		addField(new ColorFieldEditor(PREF_COLOR_CUSTOMERS, "cust", getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_COLOR_RENTAL, "rental", getFieldEditorParent()));
		addField(new ColorFieldEditor(PREF_COLOR_OBJECT, "object", getFieldEditorParent()));
	}

}
