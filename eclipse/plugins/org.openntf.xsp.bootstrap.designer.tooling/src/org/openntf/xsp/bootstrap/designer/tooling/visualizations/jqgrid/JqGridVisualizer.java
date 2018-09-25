package org.openntf.xsp.bootstrap.designer.tooling.visualizations.jqgrid;

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
	<xp:table style="border-color:rgb(128,128,128);border-style:solid;border-width:thin;width:100%">
		<xp:tr>
			<xp:td rowspan="2" style="width:100px">
				<xp:image url="/jord/designer/markup/jqgrid/jqgridlogo.png" id="image1"></xp:image>
			</xp:td>
			<xp:td style="font-weight:bold; width: 100px;">Caption:</xp:td>
			<xp:td>
				<xp:text escape="true" id="computedField1" value="<%= 
				this.caption ? this.caption:'{caption}' 
				%>"></xp:text>
			</xp:td>
		</xp:tr>

		<xp:tr>
			<xp:td style="font-weight:bold">URL:</xp:td>
			<xp:td>
				<xp:text escape="true" id="computedField2" value="<%= 
				'{url}'
				%>"></xp:text>
			</xp:td>
		</xp:tr>
		<xp:tr>
			<xp:td colspan="3" style="font-weight:bold;background-color:rgb(226,232,254)" align="center">Columns</xp:td>
		</xp:tr>
		<xp:tr>
			<xp:td colspan="3">
				<xp:table style="width:100%">
					<xp:tr>
						<% for (var x = 0; x < 5; x++) { %>
						<xp:td>
							<xp:text escape="true" value="<%= ' TODO' %>"></xp:text>
						</xp:td>
						<% } %>
					</xp:tr>
				</xp:table>
			</xp:td>
		</xp:tr>
	</xp:table>
</xp:view>
*/
//@formatter:on

public class JqGridVisualizer extends AbstractCommonControlVisualizer {

	private static final String DEFAULT_GRID_CAPTION = "Caption";

	private static final String URL_JQGRID_LOGO = "/jord/designer/markup/jqgrid/jqgridlogo.png";

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
				"border-color:rgb(128,128,128);border-style:solid;border-width:thin;width:100%"); // $NON-NLS-1$

		Tag row = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		table.addChildTag(row);

		// Cell 1
		Tag cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_ROWSPAN, "2");
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "width:100px"); // $NON-NLS-1$
		row.addChildTag(cell);

		Tag img = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_IMAGE);
		img.addAttribute(XSPAttributeNames.XSP_ATTR_URL, URL_JQGRID_LOGO);
		img.addAttribute(XSPAttributeNames.XSP_ATTR_ID, "image1");
		cell.addChildTag(img);

		// Cell 2
		cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"font-weight:bold; width: 100px;"); // $NON-NLS-1$
		cell.addTextChild("Caption:");
		row.addChildTag(cell);

		// Cell 3
		cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		// cell.addJSVarTextChild(" this.caption ? this.caption:'{caption}' ");
		row.addChildTag(cell);

		// Row 2
		row = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		table.addChildTag(row);

		// R2 C2
		cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "font-weight:bold;"); // $NON-NLS-1$
		cell.addTextChild("URL:");
		row.addChildTag(cell);

		// R2 C3
		cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		// cell.addJSVarTextChild(" '{url}' ");
		row.addChildTag(cell);

		// Row 3
		row = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		table.addChildTag(row);

		cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_COLSPAN, "3");
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE,
				"font-weight:bold;background-color:rgb(226,232,254)");
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_ALIGN, "center");
		cell.addTextChild("Columns");
		row.addChildTag(cell);

		// Row 4
		row = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		table.addChildTag(row);

		cell = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_CELL);
		cell.addAttribute(XSPAttributeNames.XSP_ATTR_COLSPAN, "3");
		row.addChildTag(cell);

		// Inner column table
		Tag colTable = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE);
		colTable.addAttribute(XSPAttributeNames.XSP_ATTR_STYLE, "width: 100%");
		cell.addChildTag(colTable);

		Tag colRow = new Tag(XP_PREFIX, XSPTagNames.XSP_TAG_TABLE_ROW);
		colTable.addChildTag(colRow);

		NodeList nl = arg0.getChildNodes();

		if (nl != null && nl.getLength() > 0) {
			for (int i = 0; i < nl.getLength(); i++) {
				if (nl.item(i).getNodeType() == Node.ELEMENT_NODE) {
					Element el = (Element) nl.item(i);
					if (el.getNodeName().contains("columns")) {

						NodeList cl = el.getChildNodes();

						if (cl != null && cl.getLength() > 0) {
							for (int j = 0; j < cl.getLength(); j++) {
								if (cl.item(j).getNodeType() == Node.ELEMENT_NODE) {
									Element cel = (Element) cl.item(j);

									if (cel.getNodeName().contains("jqColumn")) {

										String colName = cel
												.getAttribute("name");

										Tag colCell = new Tag(XP_PREFIX,
												XSPTagNames.XSP_TAG_TABLE_CELL);

										if (StringUtil.isEmpty(colName)) {
											colCell.addTextChild("{columnName}");
										} else {
											colCell.addTextChild(colName);
										}
										colRow.addChildTag(colCell);
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
