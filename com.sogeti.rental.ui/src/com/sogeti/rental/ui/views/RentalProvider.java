package com.sogeti.rental.ui.views;

import java.util.Collection;

import org.eclipse.jface.resource.ImageRegistry;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.rental.ui.RentalUIConstants;
import com.sogeti.rental.ui.RentalUiActivator;

public class RentalProvider extends LabelProvider implements ITreeContentProvider, IColorProvider, RentalUIConstants {

	
	public RentalProvider(){
		super();
		
	}
	
	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		
		if (inputElement instanceof Collection<?>)
			return ((Collection<?>) inputElement).toArray();
		
		return null; //RentalCoreActivator.getAgency().;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		if (parentElement instanceof RentalAgency){
			RentalAgency a = (RentalAgency)parentElement;
			return new Node[]{
					new Node(Node.CUSTOMERS, a),
					new Node(Node.LOCATIONS, a),
					new Node(Node.OBJETS, a)					
			};
		}else if (parentElement instanceof Node)
			return ((Node)parentElement).getChildren();
		
		return null;
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		if ((element instanceof Node)||(element instanceof RentalAgency))
			return true;
		
		return false;
	}

	@Override
	public String getText(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof RentalAgency)
			return ((RentalAgency) element).getName();
		else if (element instanceof Customer)
			return ((Customer) element).getDisplayName();
		else if (element instanceof Node)
			return ((Node)element).label;
		else if (element instanceof RentalObject)
			return ((RentalObject) element).getName();
		
		return super.getText(element);
	}
	
	class Node {
		
		private static final String CUSTOMERS = "CUSTOMERS";
		private static final String LOCATIONS = "LOCATIONS";
		private static final String OBJETS = "OBJETS";
		public String label;
		public RentalAgency agency;
		public Node(String label, RentalAgency agency) {
			super();
			this.label = label;
			this.agency = agency;
		}
		
		public Object[] getChildren(){
			if (label == CUSTOMERS)
				return agency.getCustomers().toArray();
			else if (label == LOCATIONS)
				return agency.getRentals().toArray();
			else if (label == OBJETS)
				return agency.getObjectsToRent().toArray();
			
			return null;
		}
		
	}

	@Override
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		if (element instanceof RentalAgency)
			return Display.getCurrent().getSystemColor(SWT.COLOR_BLACK);
		else if (element instanceof Customer)
			return Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
		else if (element instanceof Node)
			return Display.getCurrent().getSystemColor(SWT.COLOR_RED);
		else if (element instanceof RentalObject)
			return Display.getCurrent().getSystemColor(SWT.COLOR_GREEN);
		return null;
	}

	@Override
	public Image getImage(Object element) {
		// TODO Auto-generated method stub
		
		
		ImageRegistry reg = RentalUiActivator.getDefault().getImageRegistry();
		if (element instanceof RentalAgency)
			return reg.get(IMG_AGENCY);
		else if (element instanceof Customer)
			return reg.get(IMG_CUSTOMER);
		else if (element instanceof Rental)
			return reg.get(IMG_RENTAL);
		else if (element instanceof RentalObject)
			return reg.get(IMG_OBJECT);

		return super.getImage(element);
	}

	
	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return null;
	};
}
