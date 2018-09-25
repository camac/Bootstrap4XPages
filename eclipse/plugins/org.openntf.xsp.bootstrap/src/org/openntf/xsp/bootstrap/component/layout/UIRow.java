package org.openntf.xsp.bootstrap.component.layout;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import com.ibm.xsp.component.UIPanelEx;
import com.ibm.xsp.extlib.util.ExtLibUtil;
import com.ibm.xsp.util.TypedUtil;

public class UIRow extends UIPanelEx {

	private Boolean autoColumn = false;

	private String verticalAlign = null;

	public UIRow() {
		super();

	}

	@Override
	public String getStyleClass() {

		String parent = super.getStyleClass();

		return ExtLibUtil.concatStyleClasses("row", parent);

	}

	@Override
	public void encodeBegin(FacesContext context) throws IOException {

		super.encodeBegin(context);

		if (autoColumn) {

			context.getResponseWriter().startElement("div", null);
			context.getResponseWriter().writeAttribute("class", "col-md-12", null);

		}

	}

	@Override
	public void encodeEnd(FacesContext context) throws IOException {

		if (autoColumn) {
			context.getResponseWriter().endElement("div");
		}

		super.encodeEnd(context);
	}

	@Override
	public void initAfterContents(FacesContext context) throws FacesException {

		super.initAfterContents(context);

		List<UIComponent> kids = TypedUtil.getChildren(this);

		List<UIColumn> cols = new ArrayList<UIColumn>();

		int totalMediumSpecified = 0;

		for (UIComponent comp : kids) {
			if (comp instanceof UIColumn) {

				UIColumn col = (UIColumn) comp;

				if (col.getColumns() != null) {
					totalMediumSpecified += col.getColumns();
				} else {
					cols.add(col);
				}

			}
		}

		// If No Columns we will render
		autoColumn = (cols.size() == 0 && totalMediumSpecified == 0);

		if (autoColumn || cols.isEmpty())
			return;

		int remaining = 12 - totalMediumSpecified;

		Integer colGuess = remaining / cols.size();

		// Integer colGuess = null;
		//
		// switch (cols.size()) {
		// case 1:
		// colGuess = 12;
		// break;
		// case 2:
		// colGuess = 6;
		// break;
		// case 3:
		// colGuess = 4;
		// break;
		// case 4:
		// colGuess = 3;
		// break;
		// case 6:
		// colGuess = 2;
		// break;
		// case 12:
		// colGuess = 1;
		// break;
		//
		// default:
		// break;
		// }

		if (colGuess != null) {
			for (UIColumn uiColumn : cols) {
				uiColumn.setGuessCol(colGuess);
			}
		}

	}

	public String getVerticalAlign() {

		if (this.verticalAlign != null) {
			return this.verticalAlign;
		}

		ValueBinding vb = getValueBinding("verticalAlign");

		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;

	}

	public void setVerticalAlign(String verticalAlign) {
		this.verticalAlign = verticalAlign;
	}

	@Override
	public void restoreState(FacesContext context, Object state) {

		Object[] values = (Object[]) state;

		super.restoreState(context, values[0]);
		autoColumn = (Boolean) values[1];
		verticalAlign = (String) values[2];

	}

	@Override
	public Object saveState(FacesContext context) {

		Object[] values = new Object[3];

		values[0] = super.saveState(context);
		values[1] = autoColumn;
		values[2] = verticalAlign;

		return values;

	}

}
