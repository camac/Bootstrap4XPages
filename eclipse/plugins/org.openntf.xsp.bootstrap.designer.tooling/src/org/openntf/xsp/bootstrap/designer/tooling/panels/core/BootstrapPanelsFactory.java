package org.openntf.xsp.bootstrap.designer.tooling.panels.core;

import org.eclipse.swt.widgets.Composite;
import org.openntf.xsp.bootstrap.designer.tooling.panels.applicationlayout.ApplicationLayoutSiteMapNodes;
import org.openntf.xsp.bootstrap.designer.tooling.panels.datatables.DataTablesBasicsPanel;
import org.openntf.xsp.bootstrap.designer.tooling.panels.datatables.DataTablesColumnsPanel;
import org.openntf.xsp.bootstrap.designer.tooling.panels.jqgrid.JqGridBasicsPanel;
import org.openntf.xsp.bootstrap.designer.tooling.panels.jqgrid.JqGridColumnsPanel;
import org.openntf.xsp.bootstrap.designer.tooling.panels.layout.ColumnBasicsPanel;
import org.openntf.xsp.bootstrap.designer.tooling.panels.layout.ContainerBasicsPanel;
import org.openntf.xsp.bootstrap.designer.tooling.panels.querybuilder.QueryBuilderBasicsPanel;
import org.openntf.xsp.bootstrap.designer.tooling.panels.querybuilder.QueryBuilderFiltersPanel;
import org.openntf.xsp.bootstrap.designer.tooling.panels.wizard.WizardBasicsPanel;
import org.openntf.xsp.bootstrap.designer.tooling.panels.wizard.WizardStepBasicsPanel;

import com.ibm.commons.util.StringUtil;
import com.ibm.designer.domino.xsp.api.panels.AbstractPanelsFactory;
import com.ibm.designer.domino.xsp.api.panels.XPagesPanelDescriptor;

public class BootstrapPanelsFactory extends AbstractPanelsFactory implements
		BootstrapPanelIds {

	@Override
	protected Class<? extends Composite> getPanelControlClass(
			XPagesPanelDescriptor xfacesPanelDescriptor) {

		if (xfacesPanelDescriptor != null) {

			String id = xfacesPanelDescriptor.getId();

			if (StringUtil.equals(id, COLUMN_BASICS_PANEL)) {
				return ColumnBasicsPanel.class;
			}
			
			if (StringUtil.equals(id, CONTAINER_BASICS_PANEL)) {
				return ContainerBasicsPanel.class;
			}

//			if (StringUtil.equals(id, JQGRID_COLUMNS_PANEL)) {
//				return JqGridColumnsPanel.class;
//			}
//			
//			if (StringUtil.equals(id, DATATABLES_BASICS_PANEL)) {
//				return DataTablesBasicsPanel.class;
//			}
//			
//			if (StringUtil.equals(id, DATATABLES_COLUMNS_PANEL)) {
//				return DataTablesColumnsPanel.class;
//			}
//
//			if (StringUtil.equals(id, WIZARD_BASICS_PANEL)) {
//				return WizardBasicsPanel.class;
//			}
//
//			if (StringUtil.equals(id, WIZARDSTEP_BASICS_PANEL)) {
//				return WizardStepBasicsPanel.class;
//			}
//
//			if (StringUtil.equals(id, APP_LAYOUT_SITEMAP_NODES)) {
//				return ApplicationLayoutSiteMapNodes.class;
//			}
//			
//			if (StringUtil.equals(id, QUERYBUILDER_BASICS_PANEL)) {
//				return QueryBuilderBasicsPanel.class;
//			}
//			
//			if (StringUtil.equals(id, QUERYBUILDER_FILTERS_PANEL)) {
//				return QueryBuilderFiltersPanel.class;
//			}

		}

		return null;
	}

}
