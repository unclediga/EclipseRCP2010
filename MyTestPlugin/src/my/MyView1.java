package my;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.ui.part.ViewPart;

public class MyView1 extends ViewPart {

	public static final String ID = "my.views.view1";

	private Label label;
	public MyView1() {
		super();
		System.out.println("Create view");
	}

	@Override
	public void createPartControl(Composite parent) {
		parent.setLayout(new FillLayout());
		label = new Label(parent, SWT.NONE);
		label.setText("My Label!!!");
	}

	@Override
	public void setFocus() {
		label.setFocus();
	}

}
