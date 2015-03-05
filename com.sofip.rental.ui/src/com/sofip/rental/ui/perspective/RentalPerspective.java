package com.sofip.rental.ui.perspective;

import org.eclipse.ui.IPageLayout;
import org.eclipse.ui.IPerspectiveFactory;

public class RentalPerspective implements IPerspectiveFactory {

	@Override
	public void createInitialLayout(IPageLayout layout) {
		layout.setEditorAreaVisible(false);
		// TODO Auto-generated method stub

		layout.addView("com.sofip.rental.ui.rentalAgencyView", IPageLayout.LEFT, 0.5f, IPageLayout.ID_EDITOR_AREA);
		layout.addView("com.sofip.rental.ui.rentalPropertyView", IPageLayout.RIGHT, 0.5f, IPageLayout.ID_EDITOR_AREA);
	}

}
