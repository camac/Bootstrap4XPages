package org.openntf.xsp.bootstrap.designer.tooling.panels.jqgrid;

import org.eclipse.swt.widgets.Composite;

public class JqGridColumnsPanel extends AbstractTreeNodePanel {

	public JqGridColumnsPanel(Composite parent, int style) {

		super(parent, new TreeNodePanelDescriptor("jqGrid", null, "columns"),
				style);

	}

	@Override
	protected String getLinkAttributeDescription() {
		return "Add Columns to the JqGrid";
	}

}
