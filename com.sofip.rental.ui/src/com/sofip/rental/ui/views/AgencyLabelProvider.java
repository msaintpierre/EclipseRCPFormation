package com.sofip.rental.ui.views;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sofip.rental.ui.RentalUIActivator;
import com.sofip.rental.ui.RentalUIConstants;
import com.sofip.rental.ui.views.AgencyTreeContentProvider.AgencyNode;

public class AgencyLabelProvider extends LabelProvider implements IColorProvider, RentalUIConstants {
	@Override
	public String getText(Object element) {
		if (element instanceof RentalAgency) {
			return ((RentalAgency) element).getName();
		} else if (element instanceof Customer) {
			return ((Customer) element).getDisplayName();
		} else if (element instanceof RentalObject) {
			return ((RentalObject)element).getName();
		}
		return super.getText(element);
	}

	@Override
	public Color getForeground(Object element) {
		if (element instanceof Customer) {
			return Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
		} else if (element instanceof RentalObject) {
			return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		} else if (element instanceof AgencyNode) {
			return Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW);
		}
		return null;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public Image getImage(Object element) {
		ImageRegistry reg = RentalUIActivator.getDefault().getImageRegistry();
		if (element instanceof Customer) {
			return reg.get(IMG_CUSTOMERS);
		} else if (element instanceof RentalObject) {
			return reg.get(IMG_OBJECTS);
		} else if (element instanceof RentalAgency) {
			return reg.get(IMG_LOCATIONS);
		}
		return super.getImage(element);
	}

}
