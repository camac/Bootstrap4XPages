package org.openntf.xsp.bootstrap.designer.tooling.visualizations.wizard;

import org.eclipse.core.runtime.Path;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.eclipse.wst.xml.core.internal.document.ElementImpl;
import org.eclipse.wst.xml.core.internal.provisional.document.IDOMElement;

import com.ibm.commons.util.StringUtil;
import com.ibm.designer.domino.constants.XSPAttributeNames;
import com.ibm.designer.domino.constants.XSPTagNames;
import com.ibm.xsp.extlib.designer.tooling.constants.IExtLibAttrNames;
import com.ibm.xsp.extlib.designer.tooling.visualizations.AbstractCommonControlVisualizer;
import com.ibm.xsp.registry.FacesRegistry;

/**
 * This class generates the following source
 * 
 * <?xml version="1.0" encoding="UTF-8"?> <xp:view
 * xmlns:xp="http://www.ibm.com/xsp/core">
 * 
 * <% var titleBarTextVar=this.titleBarText; if(null==titleBarTextVar ||
 * titleBarTextVar==""){ titleBarTextVar="Title Bar"; } %>
 *
 * <xp:table style="background-color:#E2E2E2;width:98%"> <xp:tr> <xp:td
 * style="border:none"> <xp:span
 * style="font-weight:bold;color:rgb(91,91,91)"><%=titleBarTextVar%></xp:span>
 * </xp:td> <xp:td style="border:none;width:5%"> <xp:image
 * url="/extlib/designer/markup/extensionlibrary/SectionMenu12.png"> </xp:image>
 * </xp:td> </xp:tr> <xp:tr> <xp:td colspan="2"
 * style="background-color:rgb(255,255,255);border:none">
 * <xp:callback></xp:callback> </xp:td> </xp:tr> </xp:table>
 * 
 * </xp:view>
 *
 */

public class WizardVisualizer extends AbstractCommonControlVisualizer {

	private static final String JORD_IMAGES_LOCATION = "/jord/designer/markup";
	private static final String WIZARD_IMAGES_SUBFOLDER = "wizard";

	private static final String TITLE_BAR_TEXT = "Title Bar"; // $NLX-WidgetContainerVisualizer.TitleBar-1$
	private static final String WIZARD_IMAGE_NAME = "wizardicon24x24.png"; // $NON-NLS-1$

	@Override
	public String getXSPMarkupForControl(Node nodeToVisualize,
			IVisualizationCallback callback, FacesRegistry registry) {

		StringBuilder strBuilder = new StringBuilder();

		String titleBarTextVarName = "titleBarTextVar"; // $NON-NLS-1$
		strBuilder.append(generateFunctionToGetAttributeValue(
				IExtLibAttrNames.EXT_LIB_ATTR_TITLE_BAR_TEXT, TITLE_BAR_TEXT,
				titleBarTextVarName));

		Tag tableTag = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE);
		tableTag.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"border-color:rgb(120,76,242);border-style: solid; width:98%"); // $NON-NLS-1$

		Tag firstRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		tableTag.addChildTag(firstRow);

		Tag firstRowImageCell = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_TABLE_CELL);
		firstRowImageCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"border:none;width:5%"); // $NON-NLS-1$
		firstRow.addChildTag(firstRowImageCell);

		Tag imageTag = createImageTagObj(WIZARD_IMAGE_NAME,
				WIZARD_IMAGES_SUBFOLDER);
		firstRowImageCell.addChildTag(imageTag);

		Tag firstRowTitleCell = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_TABLE_CELL);
		firstRowTitleCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"border:none"); // $NON-NLS-1$
		firstRow.addChildTag(firstRowTitleCell);

		Tag firstRowFirstCellSpan = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_SPAN);
		firstRowFirstCellSpan.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"font-weight:bold;color:rgb(0,0,0)"); // $NON-NLS-1$
		firstRowFirstCellSpan.addJSVarTextChild(titleBarTextVarName);
		firstRowTitleCell.addChildTag(firstRowFirstCellSpan);

		// Start Invitation Facet Row
		Tag inviteHeaderRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		tableTag.addChildTag(inviteHeaderRow);

		Tag inviteHeaderCell = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_TABLE_CELL);
		inviteHeaderCell.addAttribute(XSPAttributeNames.XSP_ATTR_COLSPAN, "2");
		inviteHeaderCell.addAttribute(XSPAttributeNames.XSP_ATTR_ALIGN,
				"center");
		inviteHeaderCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"background-color: rgb(120,76,242)");
		inviteHeaderRow.addChildTag(inviteHeaderCell);

		Tag inviteRowHeaderCellSpan = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_SPAN);
		inviteRowHeaderCellSpan.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"font-weight:bold;color:rgb(255,255,255)"); // $NON-NLS-1$
		inviteRowHeaderCellSpan.addTextChild("Invitation Facet (Optional)");
		inviteHeaderCell.addChildTag(inviteRowHeaderCellSpan);

		Tag inviteRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		tableTag.addChildTag(inviteRow);

		Tag inviteRowCell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		inviteRowCell.addAttribute(XSPAttributeNames.XSP_ATTR_COLSPAN, "2");
		inviteRow.addChildTag(inviteRowCell);

		Tag inviteFacetCallbackTag = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_CALLBACK);
		inviteFacetCallbackTag.addAttribute("facetName", "invitation");
		inviteRowCell.addChildTag(inviteFacetCallbackTag);
		// End Finish Facet Row

		// Start Steps Rows

		Tag stepsHeaderRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		tableTag.addChildTag(stepsHeaderRow);

		Tag stepsHeaderCell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		stepsHeaderCell.addAttribute(XSPAttributeNames.XSP_ATTR_COLSPAN, "2");
		stepsHeaderCell
				.addAttribute(XSPAttributeNames.XSP_ATTR_ALIGN, "center");
		stepsHeaderCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"background-color: rgb(120,76,242)");

		stepsHeaderRow.addChildTag(stepsHeaderCell);

		Tag stepsRowHeaderCellSpan = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_SPAN);
		stepsRowHeaderCellSpan.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"font-weight:bold;color:rgb(255,255,255)"); // $NON-NLS-1$
		stepsRowHeaderCellSpan.addTextChild("Wizard Steps");
		stepsHeaderCell.addChildTag(stepsRowHeaderCellSpan);

		createSummaryTag(tableTag, nodeToVisualize, callback, registry);

		Tag secondRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		tableTag.addChildTag(secondRow);

		Tag secondRowCell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		secondRowCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"background-color:rgb(255,255,255);border:none"); // $NON-NLS-1$
		secondRowCell.addAttribute(XSPAttributeNames.XSP_ATTR_COLSPAN, "2");
		secondRow.addChildTag(secondRowCell);

		Tag contentAreaCallbackTag = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_CALLBACK);
		secondRowCell.addChildTag(contentAreaCallbackTag);
		// End Wizard Steps

		// Start Finish facet Row

		Tag finishHeaderRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		tableTag.addChildTag(finishHeaderRow);

		Tag finishHeaderCell = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_TABLE_CELL);
		finishHeaderCell.addAttribute(XSPAttributeNames.XSP_ATTR_COLSPAN, "2");
		finishHeaderCell.addAttribute(XSPAttributeNames.XSP_ATTR_ALIGN,
				"center");
		finishHeaderCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"background-color: rgb(120,76,242)");

		finishHeaderRow.addChildTag(finishHeaderCell);

		Tag finishRowHeaderCellSpan = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_SPAN);
		finishRowHeaderCellSpan.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"font-weight:bold;color:rgb(255,255,255)"); // $NON-NLS-1$
		finishRowHeaderCellSpan.addTextChild("Finish Facet (Optional)");
		finishHeaderCell.addChildTag(finishRowHeaderCellSpan);

		Tag thirdRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		tableTag.addChildTag(thirdRow);

		Tag thirdRowCell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		thirdRowCell.addAttribute(XSPAttributeNames.XSP_ATTR_COLSPAN, "2");
		thirdRow.addChildTag(thirdRowCell);

		Tag finishFacetCallbackTag = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_CALLBACK);
		finishFacetCallbackTag.addAttribute("facetName", "finish");
		thirdRowCell.addChildTag(finishFacetCallbackTag);
		// End Finish Facet Row

		strBuilder.append(tableTag.toString());
		strBuilder.append(LINE_DELIMITER);

		return strBuilder.toString();

	}

	protected void createSummaryTag(Tag tableTag, Node nodeToVisualize,
			IVisualizationCallback callback, FacesRegistry registry) {

		Node o = nodeToVisualize.getAttributes().getNamedItem("showStatusBar");
		if (o == null)
			return;
		if (!StringUtil.equals("true", o.getNodeValue()))
			return;

		Tag row = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);

		tableTag.addChildTag(row);

		Tag cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_COLSPAN, "2");
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"background-color: rgb(225,225,225)");
		row.addChildTag(cell);

		Node node = nodeToVisualize.getFirstChild();

		while (node != null) {

			String tag = node.getNodeName();

			if (StringUtil.equals("jord:wizardStep", tag)) {

				Node titleNode = node.getAttributes().getNamedItem("title");

				String title = "WizardStep";

				if (titleNode != null) {
					title = titleNode.getNodeValue();
				} else {

					Node childnode = node.getFirstChild();

					while (childnode != null) {
						if (StringUtil.equals("jord:this.title",
								childnode.getNodeName())) {
							
							Node cdata = childnode.getFirstChild();
							if (cdata != null) {
								title = cdata.getNodeValue();								
							}
							childnode = null;
						} else {
							childnode = childnode.getNextSibling();
						}
					}

				}

				if (title.length() > 47) {
					title = title.substring(0, 46) + "...";
				}
				
				Tag span = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_SPAN);
				span.addTextChild(title);
				cell.addChildTag(span);

			}

			node = node.getNextSibling();

		}

	}

	@Override
	public boolean isStaticMarkup() {
		return false;
	}

	protected Tag createImageTagObj(String imageName, String imageSubFolder) {
		Tag imageTag = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_IMAGE);
		imageTag.addAttribute(XSPAttributeNames.XSP_ATTR_URL,
				getURLForImage(imageName, imageSubFolder));
		return imageTag;
	}

	/**
	 * Generate the OS specific path to the image given an imageName and
	 * subFolder of extlib/designer/markup
	 * 
	 * @param imageName
	 * @param imageSubFolder
	 * @return
	 */
	private String getURLForImage(String imageName, String imageSubFolder) {
		return JORD_IMAGES_LOCATION + Path.SEPARATOR + imageSubFolder
				+ Path.SEPARATOR + imageName;
	}

}
