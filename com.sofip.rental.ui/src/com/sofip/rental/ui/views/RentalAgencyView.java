package com.sofip.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sofip.rental.core.RentalCoreActivator;

public class RentalAgencyView extends ViewPart {

	public RentalAgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		TreeViewer tv = new TreeViewer(parent);
		Tree tree = tv.getTree();
		tv.setContentProvider(new AgencyTreeContentProvider());
		tv.setLabelProvider(new AgencyLabelProvider());
		
		Collection<RentalAgency> agencies = new ArrayList<RentalAgency>();
		agencies.add(RentalCoreActivator.getAgency());
		tv.setInput(agencies);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
