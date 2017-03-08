package com.sogeti.rental.ui.views;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.ui.part.ViewPart;

import com.opcoach.training.rental.RentalAgency;
import com.sogeti.rental.core.RentalCoreActivator;

public class AgencyView extends ViewPart {

	public AgencyView() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createPartControl(Composite parent) {
		// TODO Auto-generated method stub
		TreeViewer tv = new TreeViewer(parent);
		RentalProvider rp = new RentalProvider();
		
		tv.setContentProvider(rp);
		tv.setLabelProvider(rp);
		
		Collection<RentalAgency> agencies = new ArrayList<>();
		agencies.add(RentalCoreActivator.getAgency());
		tv.setInput(agencies);
		
		tv.expandAll();
	}

	@Override
	public void setFocus() {
		// TODO Auto-generated method stub

	}

}
