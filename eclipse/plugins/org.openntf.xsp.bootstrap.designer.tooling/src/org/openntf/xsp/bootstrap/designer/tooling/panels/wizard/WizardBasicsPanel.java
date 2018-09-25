package org.openntf.xsp.bootstrap.designer.tooling.panels.wizard;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.ibm.designer.ide.xsp.components.api.panels.XSPBasicsPanel;

public class WizardBasicsPanel extends XSPBasicsPanel {

	public WizardBasicsPanel(Composite parent, int style) {
		super(parent, style);
	}
	
	@Override
	protected void createVisible() {
		
		int cols = getNumGroupBoxColumns();

		createLabel("Wizard Title", null);
		createDCTextComputed("titleBarText",
				createControlGDFill(getNumLeftColumns() - 1));

		// Set whether to open on Double Click
		GridData data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("partialEvents", String.valueOf(true), null,
				false, "Use Partial Refresh/Execution", data);

		super.createVisible();
	}
	
	@Override
	protected void createGroupBoxContents(Group arg0) {

		int cols = getNumGroupBoxColumns();

		GridData data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("showStatusBar", String.valueOf(true),
				null, false, "Show Status Bar", data);

		data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("showStepTitle", String.valueOf(true), null,
				false, "Show Step Title", data);

		data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("showButtonBar", String.valueOf(true), null,
				false, "Show Button Bar", data);


	}

	@Override
	protected String getGroupTitle() {
		return "Display Options";
	}
}
