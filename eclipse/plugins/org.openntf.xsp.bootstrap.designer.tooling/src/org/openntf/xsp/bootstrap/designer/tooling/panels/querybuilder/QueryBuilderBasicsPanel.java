package org.openntf.xsp.bootstrap.designer.tooling.panels.querybuilder;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.ibm.designer.ide.xsp.components.api.panels.XSPBasicsPanel;

public class QueryBuilderBasicsPanel extends XSPBasicsPanel {

	public QueryBuilderBasicsPanel(Composite parent, int style) {
		super(parent, style);
	}

	@Override
	protected void createGroupBoxContents(Group arg0) {

		int cols = getNumGroupBoxColumns();

		GridData data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("allowEmpty", String.valueOf(true),
				null, false, "Allow Empty Rules", data);

		data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("allowGroups", String.valueOf(true), null,
				false, "Allow Groups", data);

	}

	@Override
	protected String getGroupTitle() {
		return "Options";
	}

}
