package com.sogeti.rental.ui;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

public class HelloWorld extends AbstractHandler implements IHandler {

	public HelloWorld() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		IWorkbenchWindow window;
		window = HandlerUtil.getActiveWorkbenchWindow(event);
		MessageDialog.openInformation(window.getShell(), "PluginID", "Hello World!");

		return null;
}

}
