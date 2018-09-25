package org.openntf.xsp.bootstrap.designer.tooling.visualizations.querybuilder;

import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ibm.commons.util.StringUtil;
import com.ibm.designer.domino.constants.XSPAttributeNames;
import com.ibm.designer.domino.constants.XSPTagNames;
import com.ibm.xsp.extlib.designer.tooling.visualizations.AbstractCommonControlVisualizer;
import com.ibm.xsp.registry.FacesRegistry;

//@formatter:off
/*
<?xml version="1.0" encoding="UTF-8"?>
<xp:view xmlns:xp="http://www.ibm.com/xsp/core">

	<xp:table style="border-color:rgb(255,128,0);border-style:solid;border-width:thin;">
		<xp:tr>
			<xp:td style="background-color:rgb(255,255,128)">QueryBuilder:</xp:td>
			<xp:td style="background-color:rgb(255,255,128);font-weight:bold">QUERYBUILDER ID</xp:td>
		</xp:tr>
		<xp:tr>
			<xp:td style="color:rgb(128,128,128)">FILTER ID</xp:td>
			<xp:td>FILTER LABEL</xp:td>
		</xp:tr>
	</xp:table>

</xp:view>

*/
//@formatter:on

public class QueryBuilderVisualizer extends AbstractCommonControlVisualizer {
	
	@Override
	public boolean isStaticMarkup() {
		return false;
	}

	@Override
	public String getXSPMarkupForControl(Node arg0,
			IVisualizationCallback arg1, FacesRegistry arg2) {

		StringBuilder strBuilder = new StringBuilder();

		Tag table = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE);
		table.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"border-color:rgb(255,128,0);border-style:solid;border-width:thin;"); // $NON-NLS-1$

		Tag row = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		table.addChildTag(row);

		// Cell 1
		Tag cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "background-color:rgb(255,255,128)"); // $NON-NLS-1$
		cell.addTextChild("QueryBuilder: ");
		row.addChildTag(cell);

		// Cell 2
		cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"background-color:rgb(255,255,128);font-weight:bold"); // $NON-NLS-1$
		cell.addTextChild("id to go here");
		row.addChildTag(cell);


		// Inner column table
		NodeList nl = arg0.getChildNodes();

		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element el = (Element) nl.item(i);
					if (el.getNodeName().contains("filters")) {

						NodeList cl = el.getChildNodes();

						if (cl != null && cl.getLength() > 0) {
							for (int j = 0; j < cl.getLength(); j++) {
								if (cl.item(j).getNodeType() == Node.ELEMENT_NODE) {
									Element cel = (Element) cl.item(j);

									if (cel.getNodeName().contains("queryBuilderFilter")) {

										// Row
										row = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
										table.addChildTag(row);
										
										// Field Id Cell										
										String fieldId = cel
												.getAttribute("fieldId");

										Tag colCell = new Tag(XP_PREFIX,
												XSPTagNames.XSP_TAG_TABLE_CELL);
										colCell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "color:rgb(128,128,128)"); // $NON-NLS-1$

										if (StringUtil.isEmpty(fieldId)) {
											colCell.addTextChild("{fieldId}");
										} else {
											colCell.addTextChild(fieldId);
										}										
										row.addChildTag(colCell);
										
										// Field Label Cell
										colCell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
										
										String fieldLabel = cel.getAttribute("label");
										
										if (StringUtil.isEmpty(fieldLabel)) {
											colCell.addTextChild("{label}");
										} else {
											colCell.addTextChild(fieldLabel);
										}

										row.addChildTag(colCell);

										
									}

								}
							}
						}

					}
				}
			}
		}

		strBuilder.append(table.toString());
		strBuilder.append(LINE_DELIMITER);

		return strBuilder.toString();
	}
}
