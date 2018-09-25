package org.openntf.xsp.bootstrap.designer.tooling.panels.datatables;

import org.eclipse.swt.widgets.Composite;

public class DataTablesColumnsPanel extends AbstractTreeNodePanel {

	public DataTablesColumnsPanel(Composite parent, int style) {

		super(parent, new TreeNodePanelDescriptor("dataTables", null, "columns"),
				style);

	}

	@Override
	protected String getLinkAttributeDescription() {
		return "Add Columns to the DataTable";
	}

}
