package com.sogeti.rental.rcp;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.IAction;
import org.eclipse.ui.actions.ActionFactory;

public class ActionBarAdvisorRCP extends ActionBarAdvisor {
	private IAction quitAction;
	private IAction preferencesAction;

	public ActionBarAdvisorRCP(IActionBarConfigurer configurer) {
		super(configurer);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		// TODO Auto-generated method stub
		super.fillMenuBar(menuBar);
		
		MenuManager menuFile = new MenuManager("New MenuManager");
		menuFile.setVisible(true);
		menuFile.setMenuText("File");
		menuBar.add(menuFile);
		menuFile.add(quitAction);
		
		MenuManager menuWindows = new MenuManager("New MenuManager");
		menuWindows.setVisible(true);
		menuWindows.setMenuText("Windows");
		menuBar.add(menuWindows);
		menuWindows.add(preferencesAction);
		
		
	}
	
	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
		// TODO Auto-generated method stub
		super.fillCoolBar(coolBar);
	}
	
	@Override
	public void fillActionBars(int flags) {
		// TODO Auto-generated method stub
		super.fillActionBars(flags);
	}
	
	@Override
	protected void makeActions(IWorkbenchWindow window) {
		// TODO Auto-generated method stub
		super.makeActions(window);
		{
			quitAction = ActionFactory.QUIT.create(window);
			register(quitAction);
		}
		{
			preferencesAction = ActionFactory.PREFERENCES.create(window);
			register(preferencesAction);
		}
	}
}
