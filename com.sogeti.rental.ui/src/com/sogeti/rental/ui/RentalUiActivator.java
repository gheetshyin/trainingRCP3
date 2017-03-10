package com.sogeti.rental.ui;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.framework.FrameworkUtil;

/**
 * The activator class controls the plug-in life cycle
 */
public class RentalUiActivator extends AbstractUIPlugin implements RentalUIConstants {

	public Map<String, Palette> getPaletteManager() {
		return paletteManager;
	}

	// The plug-in ID
	public static final String PLUGIN_ID = "com.sogeti.rental.ui"; //$NON-NLS-1$

	// The shared instance
	private static RentalUiActivator plugin;
	
	private Map<String, Palette> paletteManager = new HashMap<>();
	
	/**
	 * The constructor
	 */
	public RentalUiActivator() {
	}

	/*
	 * (non-Javadoc)
	 * @see org.eclipse.ui.plugin.AbstractUIPlugin#start(org.osgi.framework.BundleContext)
	 */
	public void start(BundleContext context) throws Exception {
		super.start(context);
		plugin = this;
		
		IExtensionRegistry reg = Platform.getExtensionRegistry();
		for (IConfigurationElement e : reg.getConfigurationElementsFor("com.sogeti.rental.ui.palette")){
			
			Palette pal = new Palette();
			pal.setId(e.getAttribute("id"));
			pal.setName(e.getAttribute("name"));
			pal.setProvider((IColorProvider) e.createExecutableExtension("class"));
			
			paletteManager.put(pal.getId(), pal);
			
			String txtText = "plugin : " + e.getNamespaceIdentifier() + "\t pal : " + e.getAttribute("name");
				System.out.println(txtText);
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

	@Override
	protected void initializeImageRegistry(ImageRegistry reg) {
		// TODO Auto-generated method stub
		super.initializeImageRegistry(reg);
		Bundle b = FrameworkUtil.getBundle(this.getClass());
		
		reg.put(IMG_CUSTOMER, ImageDescriptor.createFromURL(b.getEntry(IMG_CUSTOMER)));
		reg.put(IMG_AGENCY, ImageDescriptor.createFromURL(b.getEntry(IMG_AGENCY)));
		reg.put(IMG_OBJECT, ImageDescriptor.createFromURL(b.getEntry(IMG_OBJECT)));
		reg.put(IMG_RENTAL, ImageDescriptor.createFromURL(b.getEntry(IMG_RENTAL)));
	}
	/**
	 * Returns the shared instance
	 *
	 * @return the shared instance
	 */
	public static RentalUiActivator getDefault() {
		return plugin;
	}

	/**
	 * Returns an image descriptor for the image file at the given
	 * plug-in relative path
	 *
	 * @param path the path
	 * @return the image descriptor
	 */
	public static ImageDescriptor getImageDescriptor(String path) {
		return imageDescriptorFromPlugin(PLUGIN_ID, path);
	}
}
