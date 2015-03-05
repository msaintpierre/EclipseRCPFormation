package com.sofip.rental.ui.prefs;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.graphics.RGB;

import com.sofip.rental.ui.RentalUIActivator;
import com.sofip.rental.ui.RentalUIConstants;

public class RentalUIPrefInitializer extends AbstractPreferenceInitializer implements RentalUIConstants {

	public RentalUIPrefInitializer() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore store = RentalUIActivator.getDefault().getPreferenceStore();
		store.setDefault(PREF_COLOR_CUSTOMERS, StringConverter.asString(new RGB(143, 87, 33)));
		store.setDefault(PREF_COLOR_RENTAL, StringConverter.asString(new RGB(143, 0, 134)));
		store.setDefault(PREF_COLOR_OBJECT, StringConverter.asString(new RGB(27, 89, 22)));
	}

}
