package com.sogeti.rental.ui;

import org.eclipse.jface.viewers.IColorProvider;

public class Palette {
	private String id, name;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public IColorProvider getProvider() {
		return provider;
	}

	public void setProvider(IColorProvider provider) {
		this.provider = provider;
	}

	private IColorProvider provider;

}
