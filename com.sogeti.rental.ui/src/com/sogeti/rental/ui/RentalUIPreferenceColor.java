package com.sogeti.rental.ui;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

public class RentalUIPreferenceColor extends FieldEditorPreferencePage implements IWorkbenchPreferencePage {

	public static final String PREF_COLOR_OBJECT = "COLOR_OBJECT";
	public static final String PREF_COLOR_RENTAL = "COLOR_RENTAL";
	public static final String PREF_COLOR_CUSTOMER = "COLOR_CUSTOMER";

	public RentalUIPreferenceColor() {
				setPreferenceStore(RentalUiActivator.getDefault().getPreferenceStore());
				setDescription("COULEURS");	}

	

	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		addField( new ColorFieldEditor(PREF_COLOR_CUSTOMER, "Customer :", getFieldEditorParent()));
		addField( new ColorFieldEditor(PREF_COLOR_RENTAL, "Rental :", getFieldEditorParent()));
		addField( new ColorFieldEditor(PREF_COLOR_OBJECT, "Objets :", getFieldEditorParent()));

	}

}
