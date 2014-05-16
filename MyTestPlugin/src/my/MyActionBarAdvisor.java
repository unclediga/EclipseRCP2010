package my;

import org.eclipse.jface.action.ICoolBarManager;
import org.eclipse.jface.action.IMenuManager;
import org.eclipse.jface.action.IStatusLineManager;
import org.eclipse.jface.action.MenuManager;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.actions.ActionFactory;
import org.eclipse.ui.actions.ActionFactory.IWorkbenchAction;
import org.eclipse.ui.application.ActionBarAdvisor;
import org.eclipse.ui.application.IActionBarConfigurer;

public class MyActionBarAdvisor extends ActionBarAdvisor {

	private IWorkbenchAction exitAction;

	public MyActionBarAdvisor(IActionBarConfigurer configurer) {
		super(configurer);
	}

	@Override
	protected void fillMenuBar(IMenuManager menuBar) {
		MenuManager menuManager = new MenuManager("MyApp");
		menuManager.add(exitAction);
	}
	
	

	@Override
	protected void fillCoolBar(ICoolBarManager coolBar) {
	}

	@Override
	protected void fillStatusLine(IStatusLineManager statusLine) {
	}

	@Override
	protected void makeActions(IWorkbenchWindow window) {
		
		exitAction = ActionFactory.QUIT.create(window);
		
	}
	
	
	

}
