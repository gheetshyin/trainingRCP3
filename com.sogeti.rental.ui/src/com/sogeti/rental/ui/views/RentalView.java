package com.sogeti.rental.ui.views;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.ISelectionListener;
import org.eclipse.ui.IViewSite;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.PartInitException;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.Rental;
import com.sogeti.rental.core.RentalCoreActivator;

public class RentalView extends ViewPart implements ISelectionListener {

	private Label rentedObjectLabel;
	private Label lLoueur;
	private Group grpDatesDeLocation;
	private Label lblDuValue;
	private Label lblAuValue;

	public RentalView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new GridLayout(1,false));
		
		Group infoGroup = new Group(parent, SWT.NONE);
		infoGroup.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
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
		
		grpDatesDeLocation = new Group(parent, SWT.NONE);
		grpDatesDeLocation.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false, 1, 1));
		grpDatesDeLocation.setText("Dates de location");
		grpDatesDeLocation.setLayout(new GridLayout(2, false));
		
		Label lblDu = new Label(grpDatesDeLocation, SWT.NONE);
		lblDu.setSize(20, 15);
		lblDu.setText("du: ");
		
		lblDuValue = new Label(grpDatesDeLocation, SWT.NONE);
		lblDuValue.setText("New Label");
		
		Label lblAu = new Label(grpDatesDeLocation, SWT.NONE);
		lblAu.setText("au: ");
		
		lblAuValue = new Label(grpDatesDeLocation, SWT.NONE);
		lblAuValue.setText("New Label");
		
		setRental(RentalCoreActivator.getAgency().getRentals().get(0));

	}

	public void setRental(Rental rental) {
		rentedObjectLabel.setText(rental.getRentedObject().getName());
		lLoueur.setText(rental.getCustomer().getDisplayName());
		lblDuValue.setText(rental.getStartDate().toString());
		lblAuValue.setText(rental.getEndDate().toString());
		
	}
	@Override
	public void setFocus() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void init(IViewSite site) throws PartInitException {
		// TODO Auto-generated method stub
		super.init(site);
		site.getPage().addSelectionListener(this);
	}
	
	@Override
	public void dispose() {
		// TODO Auto-generated method stub
		super.dispose();
		getSite().getPage().removeSelectionListener(this);
	}
	
	@Override
	public void selectionChanged(IWorkbenchPart part, ISelection selection) {
		// TODO Auto-generated method stub
		if (selection instanceof IStructuredSelection)
		{
			Object selected = ((IStructuredSelection) selection).getFirstElement();
			if (selected instanceof Rental){
				setRental((Rental) selected);
			}
			
				
		}
	}
}
