package com.sofip.rental.ui;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUIActivator extends AbstractUIPlugin implements RentalUIConstants {

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sofip.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUIActivator plugin;
	
	/**
	 * The constructor
	 */
	public RentalUIActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		displayViewExtensions();
	}

	
	
	private void displayViewExtensions() {
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		for (IConfigurationElement e : reg.getConfigurationElementsFor("org.eclipse.ui.views"))
		{
			if (e.getName().equals("view")) {
			System.out.println("Vue : " + e.getAttribute("name") + " - Plug-in : " + e.getNamespaceIdentifier());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#stop(org.osgi.framework.BundleContext)
	 */
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		super.stop(context);
	}

	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RentalUIActivator getDefault() {
		return plugin;
	}
	
	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		
		super.initializeImageRegistry(reg);
		
		Bundle b = FrameworkUtil.getBundle(getClass());
		
		reg.put(IMG_CUSTOMERS, ImageDescriptor.createFromURL(b.getEntry(IMG_CUSTOMERS)));
		reg.put(IMG_LOCATIONS, ImageDescriptor.createFromURL(b.getEntry(IMG_LOCATIONS)));
		reg.put(IMG_OBJECTS, ImageDescriptor.createFromURL(b.getEntry(IMG_OBJECTS)));
	}

}
