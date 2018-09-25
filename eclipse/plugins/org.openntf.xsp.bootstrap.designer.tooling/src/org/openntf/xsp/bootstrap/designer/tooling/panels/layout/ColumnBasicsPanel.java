package org.openntf.xsp.bootstrap.designer.tooling.panels.layout;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.ibm.designer.ide.xsp.components.api.panels.XSPBasicsPanel;

public class ColumnBasicsPanel extends XSPBasicsPanel {

	public ColumnBasicsPanel(Composite parent, int style) {
		super(parent, style);

	}

	@Override
	protected void createVisible() {

		int cols = getNumGroupBoxColumns();

		// Set whether Container is Fluid
		GridData data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("fluid", String.valueOf(true),
				null, false, "Fluid Layout (Full Width Container)", data);

		super.createVisible();
	}

	@Override
	protected void createGroupBoxContents(Group arg0) {

		int cols = getNumGroupBoxColumns();

		GridData data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("fluid", String.valueOf(true),
				null, false, "Fluid Layout (Full Width Container)", data);

	}

	@Override
	protected String getGroupTitle() {
		return "Display Options";
	}

}
