package org.openntf.xsp.bootstrap.designer.tooling.panels.applicationlayout;

import org.eclipse.swt.widgets.Composite;

import com.ibm.xsp.extlib.designer.tooling.panels.AbstractTreeNodePanel;
import com.ibm.xsp.extlib.designer.tooling.panels.TreeNodePanelDescriptor;

public class ApplicationLayoutSiteMapNodes extends AbstractTreeNodePanel {

	public ApplicationLayoutSiteMapNodes(Composite parent,
			TreeNodePanelDescriptor descriptor, int style) {
		super(parent, TreeNodePanelDescriptor.createConfig("siteMapNodes"),
				style);

	}

	@Override
	protected String getLinkAttributeDescription() {
		return "This is the Applications Site Map, used to determine current section and sub menu";
	}

}
