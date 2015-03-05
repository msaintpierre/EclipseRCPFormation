package com.sofip.rental.ui.views;

import java.text.SimpleDateFormat;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sofip.rental.core.RentalCoreActivator;

public class RentalPropertyView extends ViewPart {
	
	private Label rentedObjectLabel, customerNameLabel;
	private Group grpDatesDeLocation;
	private Label lblDateDu;
	private Label lblDateau;

	public RentalPropertyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1, false));
		
		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		
		infoGroup.setText("Information");
		infoGroup.setLayout(new GridLayout(2, false));
		
		rentedObjectLabel = new Label(infoGroup, SWT.BORDER);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjectLabel.setLayoutData(gd);
		
		Label loueA = new Label(infoGroup, SWT.NONE);
		loueA.setText("Loué à : ");
		
		customerNameLabel = new Label(infoGroup, SWT.BORDER);
		
		grpDatesDeLocation = new Group(parent, SWT.NONE);
		grpDatesDeLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpDatesDeLocation.setText("Dates de location");
		grpDatesDeLocation.setLayout(new GridLayout(2, false));
		
		Label lblDu = new Label(grpDatesDeLocation, SWT.NONE);
		lblDu.setBounds(0, 0, 62, 17);
		lblDu.setText("du :");
		
		lblDateDu = new Label(grpDatesDeLocation, SWT.BORDER);
		
		Label lblAu = new Label(grpDatesDeLocation, SWT.NONE);
		lblAu.setText("au :");
		
		lblDateau = new Label(grpDatesDeLocation, SWT.BORDER);
		
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));
		
	}
	
	public void setRental(Rental r) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		rentedObjectLabel.setText(r.getRentedObject().getName());
		customerNameLabel.setText(r.getCustomer().getDisplayName());
		lblDateDu.setText(df.format(r.getStartDate()));
		lblDateau.setText(df.format(r.getEndDate()));
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}
}
