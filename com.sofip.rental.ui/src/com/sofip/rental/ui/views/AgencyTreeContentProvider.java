package com.sofip.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.viewers.IContentProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.Viewer;

import com.opcoach.training.rental.RentalAgency;
import com.sofip.rental.ui.RentalUIConstants;

public class AgencyTreeContentProvider implements IContentProvider,
		ITreeContentProvider, RentalUIConstants {

	@Override
	public Object[] getElements(Object inputElement) {
		if (inputElement instanceof Collection<?>) {
			return ((Collection<?>) inputElement).toArray();
		}
		return null;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		if (parentElement instanceof RentalAgency) {
			RentalAgency a = (RentalAgency) parentElement;
			return new AgencyNode[] { new AgencyNode(a, NODE_CUSTOMERS),
					new AgencyNode(a, NODE_LOCATIONS),
					new AgencyNode(a, NODE_OBJECTS) };
		} else if (parentElement instanceof AgencyNode) {
			return ((AgencyNode) parentElement).getChildren();
		}
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		if (element instanceof RentalAgency || element instanceof AgencyNode) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	class AgencyNode {

		private RentalAgency agency;
		private String name;

		public AgencyNode(RentalAgency agency, String name) {
			super();
			this.agency = agency;
			this.name = name;
		}

		public Object[] getChildren() {
			if (name == NODE_CUSTOMERS) {
				return agency.getCustomers().toArray();
			} else if (name == NODE_LOCATIONS) {
				return agency.getRentals().toArray();
			} else if (name == NODE_OBJECTS) {
				return agency.getObjectsToRent().toArray();
			}
			return null;
		}

		@Override
		public String toString() {
			return name;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result
					+ ((agency == null) ? 0 : agency.hashCode());
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			AgencyNode other = (AgencyNode) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (agency == null) {
				if (other.agency != null)
					return false;
			} else if (!agency.equals(other.agency))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private AgencyTreeContentProvider getOuterType() {
			return AgencyTreeContentProvider.this;
		}
	}
}
