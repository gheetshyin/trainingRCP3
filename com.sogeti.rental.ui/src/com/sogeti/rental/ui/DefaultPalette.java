package com.sogeti.rental.ui;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.rental.ui.views.RentalProvider.Node;

public class DefaultPalette implements IColorProvider {

	public DefaultPalette() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof RentalAgency)
			return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
		else if (element instanceof Customer)
			return getAColor( RentalUiActivator.getDefault().getPreferenceStore().getString(RentalUIPreferenceColor.PREF_COLOR_CUSTOMER));
		else if (element instanceof Node)
			return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		else if (element instanceof RentalObject)
			return getAColor( RentalUiActivator.getDefault().getPreferenceStore().getString(RentalUIPreferenceColor.PREF_COLOR_OBJECT));
		else if (element instanceof Rental)
			return getAColor( RentalUiActivator.getDefault().getPreferenceStore().getString(RentalUIPreferenceColor.PREF_COLOR_RENTAL));
		return null;
	}
	
	private Color getAColor(String rgbKey){
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		
		Color col = colorRegistry.get(rgbKey);
		if (col == null){
			colorRegistry.put(rgbKey, StringConverter.asRGB(rgbKey));
			col = colorRegistry.get(rgbKey);
		}
		
		return col;
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

}
