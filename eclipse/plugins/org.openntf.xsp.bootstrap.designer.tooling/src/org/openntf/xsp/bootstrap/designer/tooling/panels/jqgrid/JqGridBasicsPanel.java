package org.openntf.xsp.bootstrap.designer.tooling.panels.jqgrid;

import java.util.HashMap;

import org.eclipse.jface.layout.GridDataFactory;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import com.ibm.commons.iloader.node.lookups.api.StringLookup;
import com.ibm.commons.swt.SWTLayoutUtils;
import com.ibm.commons.swt.data.controls.DCCompositeCombo;
import com.ibm.designer.domino.ide.resources.project.IDominoDesignerProject;
import com.ibm.designer.domino.ui.dialog.DesignElementUtil;
import com.ibm.designer.ide.xsp.components.api.panels.XSPBasicsPanel;

public class JqGridBasicsPanel extends XSPBasicsPanel {

	private static final String LABEL_COMBOBOX_DEFAULT = "Use page default";
	private static final String LABEL_COMBOBOX_SAME_WIN = "Open in same window and tab";
	private static final String LABEL_COMBOBOX_NEW_WIN = "Open new window or tab";

	private static HashMap<String, String> winBehaveTooltipMap = new HashMap<String, String>();

	static {
		winBehaveTooltipMap.put("", LABEL_COMBOBOX_DEFAULT);
		winBehaveTooltipMap.put("_self", LABEL_COMBOBOX_SAME_WIN);
		winBehaveTooltipMap.put("_blank", LABEL_COMBOBOX_NEW_WIN);
	}

	public JqGridBasicsPanel(Composite parent, int style) {
		super(parent, style);

	}

	@Override
	protected void createVisible() {

		int cols = getNumGroupBoxColumns();

		createLabel("Caption", null);
		createDCTextComputed("caption",
				createControlGDFill(getNumLeftColumns() - 1));

		createLabel("Open Records using Page:", null);
		DCCompositeCombo pagecombo = new DCCompositeCombo(getCurrentParent(),
				4, "jqgrid.pageName.id");
		pagecombo.setFirstBlankLine(true);
		pagecombo.setFirstLineTitle("Not Set");
		pagecombo.setLookup(DesignElementUtil
				.getXPageLookup((IDominoDesignerProject) getExtraData()
						.getDesignerProject()));
		pagecombo.setAttributeName("pageName");
		GridData localgriddata = SWTLayoutUtils.createGDFillHorizontal();
		localgriddata.horizontalSpan = 4;
		pagecombo.setLayoutData(localgriddata);

		// Add the Page target

		createLabel("Window Behaviour for opening records",
				GridDataFactory.copyData(localgriddata),
				getLabelToolTipText("target"));

		String[] test_VALS = { "_self", "_blank" };
		String[] test_LABELS = { LABEL_COMBOBOX_SAME_WIN,
				LABEL_COMBOBOX_NEW_WIN };

		DCCompositeCombo o = createComboComputed("target", new StringLookup(
				test_VALS, test_LABELS),
				GridDataFactory.copyData(localgriddata), true, true);

		o.setFirstLineTitle(LABEL_COMBOBOX_DEFAULT);

		// Set whether to open on Double Click
		GridData data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("openOnDoubleClick", String.valueOf(true),
				null, false, "Open Record when Row is Double Clicked", data);

		super.createVisible();
	}

	@Override
	protected void createGroupBoxContents(Group arg0) {

		int cols = getNumGroupBoxColumns();

		GridData data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("showFilterToolbar", String.valueOf(true),
				null, false, "Show Filter Toolbar", data);

		data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("showPager", String.valueOf(true), null,
				false, "Show Pager", data);

		data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("showUnreadMarks", String.valueOf(true), null,
				false, "Show Unread Marks", data);

		data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("multiselect", String.valueOf(true), null,
				false, "Allow Multiple Selection", data);

		data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("loadOnce", String.valueOf(true), null, false,
				"Load Once (Data)", data);

		data = createControlGDNoWidth(cols);
		createDCCheckboxComputed("addJQueryResources", String.valueOf(true),
				null, false, "Add JQuery Resources", data);

	}

	@Override
	protected String getGroupTitle() {
		return "Display Options";
	}

}
