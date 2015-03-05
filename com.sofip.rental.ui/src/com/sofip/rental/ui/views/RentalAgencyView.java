package com.sofip.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Tree;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sofip.rental.core.RentalCoreActivator;
import com.sofip.rental.ui.RentalUIActivator;

public class RentalAgencyView extends ViewPart implements IPropertyChangeListener {

	private TreeViewer tv;

	public RentalAgencyView() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		super.init(site);
		RentalUIActivator.getDefault().getPreferenceStore().addPropertyChangeListener(this);
	}

	@Override
	public void createPartControl(Composite parent) {
		tv = new TreeViewer(parent);
		Tree tree = tv.getTree();
		tv.setContentProvider(new AgencyTreeContentProvider());
		tv.setLabelProvider(new AgencyLabelProvider());
		
		Collection<RentalAgency> agencies = new ArrayList<RentalAgency>();
		agencies.add(RentalCoreActivator.getAgency());
		tv.setInput(agencies);
		getSite().setSelectionProvider(tv);
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

	@Override
	public void propertyChange(PropertyChangeEvent event) {
		tv.refresh();
	}

	@Override
	public void dispose() {
		super.dispose();
		RentalUIActivator.getDefault().getPreferenceStore().removePropertyChangeListener(this);
	}
}
