package org.openntf.xsp.bootstrap.designer.tooling.visualizations.wizard;

import org.w3c.dom.Node;

import com.ibm.designer.domino.constants.XSPAttributeNames;
import com.ibm.designer.domino.constants.XSPTagNames;
import com.ibm.xsp.extlib.designer.tooling.constants.IExtLibAttrNames;
import com.ibm.xsp.extlib.designer.tooling.visualizations.AbstractCommonControlVisualizer;
import com.ibm.xsp.registry.FacesRegistry;


public class WizardStepVisualizer extends AbstractCommonControlVisualizer {

    private static final String TITLE_BAR_TEXT = "Title Bar"; // $NLX-WidgetContainerVisualizer.TitleBar-1$
    private static final String TITLE_MENU_IMAGE_NAME = "SectionMenu12.png"; // $NON-NLS-1$
	
	@Override
	public String getXSPMarkupForControl(Node nodeToVisualize,
			IVisualizationCallback callback, FacesRegistry registry) {
		StringBuilder strBuilder = new StringBuilder();

		String titleBarTextVarName = "titleBarTextVar"; // $NON-NLS-1$
//		strBuilder.append(generateFunctionToGetAttributeValue(
//				IExtLibAttrNames.EXT_LIB_ATTR_TITLE_BAR_TEXT, TITLE_BAR_TEXT,
//				titleBarTextVarName));

		strBuilder.append(generateFunctionToGetAttributeValue(
				"title", TITLE_BAR_TEXT,
				titleBarTextVarName));

		
		Tag tableTag = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE);
		tableTag.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"background-color:rgb(189,206,255);width:100%"); // $NON-NLS-1$

		Tag firstRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		tableTag.addChildTag(firstRow);

		Tag firstRowFirstCell = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_TABLE_CELL);
		firstRowFirstCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"border:none"); // $NON-NLS-1$
		firstRow.addChildTag(firstRowFirstCell);

		Tag firstRowFirstCellSpan = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_SPAN);
		firstRowFirstCellSpan.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"font-weight:bold;color:rgb(91,91,91)"); // $NON-NLS-1$
		firstRowFirstCellSpan.addJSVarTextChild(titleBarTextVarName);
		firstRowFirstCell.addChildTag(firstRowFirstCellSpan);

		Tag firstRowSecondCell = new Tag(XP_PREFIX,
				XSPTagNames.XSP_TAG_TABLE_CELL);
		firstRowSecondCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"border:none;width:20%"); // $NON-NLS-1$
		firstRow.addChildTag(firstRowSecondCell);

		firstRowSecondCell.addTextChild("Step 1");
		
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

		strBuilder.append(tableTag.toString());
		strBuilder.append(LINE_DELIMITER);

		return strBuilder.toString();
	}

	@Override
	public boolean isStaticMarkup() {
		return false;
		// TODO Change this to true before release (once all good
	}

}
