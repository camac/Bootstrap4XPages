package org.openntf.xsp.bootstrap.designer.tooling.panels.querybuilder;

import org.eclipse.swt.widgets.Composite;

public class QueryBuilderFiltersPanel extends AbstractTreeNodePanel {

	public QueryBuilderFiltersPanel(Composite parent, int style) {

		super(parent, new TreeNodePanelDescriptor("queryBuilder", null, "filters"),
				style);

	}

	@Override
	protected String getLinkAttributeDescription() {
		return "Add Filters to the QueryBuilder";
	}

}
