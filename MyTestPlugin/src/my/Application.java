package my;

import org.eclipse.equinox.app.IApplication;
import org.eclipse.equinox.app.IApplicationContext;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.application.WorkbenchAdvisor;

public class Application implements IApplication {
	
	public static final String PLUGIN_ID = "my.test.app";

	@Override
	public Object start(IApplicationContext context) throws Exception {
		
		System.out.println("START!!");
		Display display = PlatformUI.createDisplay();
		try {
			int returnCode = PlatformUI.createAndRunWorkbench(display, new MyWorkbenchAdvisor() {
				
				@Override
				public String getInitialWindowPerspectiveId() {
					return null;
				}
			});
			if(returnCode == PlatformUI.RETURN_RESTART){
				return IApplication.EXIT_RESTART;
			};
			
			return IApplication.EXIT_OK;
		} finally {
			if(display != null)
				display.dispose();
		}
	}

	@Override
	public void stop() {
		System.out.println("STOP:(((");
		
		final IWorkbench workbench = PlatformUI.getWorkbench();
		if(workbench == null)	return;
		final Display display = workbench.getDisplay();
		display.syncExec(new Runnable() {
			
			@Override
			public void run() {
				if(!display.isDisposed())
					workbench.close();
			}
		});
		
		
		
		
		
	}

}
