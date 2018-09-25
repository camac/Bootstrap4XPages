package org.openntf.xsp.bootstrap.designer.tooling.visualizations.containers;

import org.w3c.dom.Node;

import com.ibm.designer.domino.constants.XSPAttributeNames;
import com.ibm.designer.domino.constants.XSPTagNames;
import com.ibm.xsp.extlib.designer.tooling.visualizations.AbstractCommonControlVisualizer;
import com.ibm.xsp.registry.FacesRegistry;

public class BootstrapColumnVisualizer extends AbstractCommonControlVisualizer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.designer.domino.xsp.api.visual.AbstractVisualizationFactory#
	 * getXSPMarkupForControl(org.w3c.dom.Node,
	 * com.ibm.designer.domino.xsp.api.visual.AbstractVisualizationFactory.
	 * IVisualizationCallback, com.ibm.xsp.registry.FacesRegistry)
	 */
	@Override
	public String getXSPMarkupForControl(Node nodeToVisualize, IVisualizationCallback callback,
			FacesRegistry registry) {

		StringBuilder strBuilder = new StringBuilder();

		Tag cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "background-color:#E2E2E2;width:98%"); // $NON-NLS-1$

		Tag contentAreaCallbackTag = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_CALLBACK);
		cell.addChildTag(contentAreaCallbackTag);

		strBuilder.append(cell.toString());
		strBuilder.append(LINE_DELIMITER);

		return strBuilder.toString();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.ibm.xsp.extlib.designer.tooling.visualizations.
	 * AbstractCommonControlVisualizer#isStaticMarkup()
	 */
	@Override
	public boolean isStaticMarkup() {
		return true;
	}
}