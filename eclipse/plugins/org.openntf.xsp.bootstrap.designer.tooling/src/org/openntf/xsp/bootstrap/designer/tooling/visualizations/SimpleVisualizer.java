package org.openntf.xsp.bootstrap.designer.tooling.visualizations;

import org.w3c.dom.Node;

import com.ibm.designer.domino.constants.XSPAttributeNames;
import com.ibm.designer.domino.constants.XSPTagNames;
import com.ibm.xsp.extlib.designer.tooling.visualizations.AbstractCommonControlVisualizer;
import com.ibm.xsp.registry.FacesRegistry;

public class SimpleVisualizer extends AbstractCommonControlVisualizer {

// @formatter:off
/**
 * This class generates the following source
 * 
 *  <?xml version="1.0" encoding="UTF-8"?>
 *  <xp:view xmlns:xp="http://www.ibm.com/xsp/core">
 * 
 *
 *      <xp:span style="background-color:#E2E2E2;width:98%">
 *      </xp:span>
 * 
 *   </xp:view>
 *
 */
	// @formatter:on

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

		Tag spanTag = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_SPAN);
		spanTag.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "background-color:#E2E2E2;width:98%"); // $NON-NLS-1$
		spanTag.addTextChild("SIMPLE VISUALIZER TO IMPROVE DESIGNER PERFORMANCE");
		// Add Toolbar Facet

		strBuilder.append(spanTag.toString());

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
