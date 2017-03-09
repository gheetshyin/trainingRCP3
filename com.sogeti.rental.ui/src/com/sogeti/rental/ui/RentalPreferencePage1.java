package com.sogeti.rental.ui;

import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class RentalPreferencePage1 extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public RentalPreferencePage1() {
		// TODO Auto-generated constructor stub
		setPreferenceStore(RentalUiActivator.getDefault().getPreferenceStore());
		setDescription("Rental Preferences");
	}

	public RentalPreferencePage1(int style) {
		super(style);
		// TODO Auto-generated constructor stub
	}

	public RentalPreferencePage1(String title, int style) {
		super(title, style);
		// TODO Auto-generated constructor stub
	}

	public RentalPreferencePage1(String title, ImageDescriptor image, int style) {
		super(title, image, style);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub

	}

}
