package org.eclipsercp.hyperbola;

import org.eclipse.jface.action.CoolBarManager;
import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IToolBarManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class ApplicationActionBarAdvisor extends ActionBarAdvisor {
	
	private IWorkbenchAction exitAction;
	private IWorkbenchAction aboutAction;
	private AddContactAction addContactAction;

    public ApplicationActionBarAdvisor(IActionBarConfigurer configurer) {
        super(configurer);
    }

    protected void makeActions(IWorkbenchWindow window) {
    	exitAction = ActionFactory.QUIT.create(window);
    	register(exitAction);
    	aboutAction = ActionFactory.ABOUT.create(window);
    	register(aboutAction);
    	addContactAction = new AddContactAction(window);
    	register(addContactAction);
    }

    protected void fillMenuBar(IMenuManager menuBar) {
    	MenuManager hyperbolaMenu = new MenuManager("&Hyperbola","hyperbola");
    	hyperbolaMenu.add(exitAction);
    	hyperbolaMenu.add(addContactAction);
//    	hyperbolaMenu.add(new GroupMarker("other-actions"));
//    	hyperbolaMenu.appendToGroup("other-actions", aboutAction);
    	
    	MenuManager aboutMenu = new MenuManager("&Help","help");
    	aboutMenu.add(aboutAction);
    	menuBar.add(hyperbolaMenu);
    	menuBar.add(aboutMenu);
    }

    @Override
    protected void fillCoolBar(ICoolBarManager coolBar) {
    	IToolBarManager toolbar = new ToolBarManager(coolBar.getStyle());
    	coolBar.add(toolbar);
    	toolbar.add(addContactAction);

    }
}
