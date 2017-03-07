package com.sogeti.rental.ui.views;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;

public class RentalView extends ViewPart {

	private Label rentedObjectLabel;
	private Label lLoueur;

	public RentalView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,false));
		
		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setText("Information");
		infoGroup.setLayout(new GridLayout(2, false));
		
		rentedObjectLabel = new Label(infoGroup, SWT.BORDER);
		GridData gd = new GridData();
		gd.horizontalSpan = 2;
		gd.horizontalAlignment = SWT.FILL;
		rentedObjectLabel.setLayoutData(gd);
		
		Label lLouerA = new Label(infoGroup,SWT.BORDER);
		lLouerA.setText("Loué à :");
		GridData gd1 = new GridData();
		gd1.horizontalSpan = 1;
		gd1.horizontalAlignment = SWT.FILL;
		lLouerA.setLayoutData(gd1);
		
		lLoueur = new Label(infoGroup, SWT.BORDER);
		GridData gd2 = new GridData();
		gd2.horizontalSpan = 1;
		gd2.horizontalAlignment = SWT.FILL;
		lLoueur.setLayoutData(gd2);
		
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));

	}

	public void setRental(Rental rental) {
		rentedObjectLabel.setText(rental.getRentedObject().getName());
		lLoueur.setText(rental.getCustomer().getDisplayName());
		
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}

}
