package com.sogeti.rental.ui;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class MochePalette implements IColorProvider {

	public MochePalette() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		return Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return Display.getCurrent().getSystemColor(SWT.COLOR_YELLOW);
	}

}
