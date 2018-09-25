package org.openntf.xsp.bootstrap.component.layout;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.component.UIPanelEx;
import com.ibm.xsp.extlib.util.ExtLibUtil;

public class UIColumn extends UIPanelEx {

	private Integer guessCol = null;

	// Defaults for Medium Columns, use styleClass for specific layouts
	private Integer columns = null;

	private Object lg = null;
	private Object sm = null;
	private Object md = null;
	private Object xs = null;
	
	private String align = null;

	public UIColumn() {
		super();
	}

	private Integer getEffectiveColumns() {
		if (getColumns() != null) {
			return getColumns();
		} else if (getGuessCol() != null) {
			return getGuessCol();
		}

		return 12;
	}

	@Override
	public String getStyleClass() {

		String styleClass = super.getStyleClass();

		styleClass = ExtLibUtil.concatStyleClasses(styleClass, "col-md-" + getEffectiveColumns());

		String align = getAlign();

		if (StringUtil.equals(align, "left")) {
			styleClass = ExtLibUtil.concatStyleClasses(styleClass, "text-left");
		} else if (StringUtil.equals(align, "right")) {
			styleClass = ExtLibUtil.concatStyleClasses(styleClass, "text-right");
		} else if (StringUtil.equals(align, "center")) {
			styleClass = ExtLibUtil.concatStyleClasses(styleClass, "text-center");
		}

		return styleClass;

	}

	public Integer getGuessCol() {
		return guessCol;
	}

	public void setGuessCol(Integer guessCol) {
		this.guessCol = guessCol;
	}

	public Integer getColumns() {

		if (this.columns != null) {
			return this.columns;
		}

		ValueBinding vb = getValueBinding("columns");

		if (vb != null) {
			return (Integer) vb.getValue(getFacesContext());
		}

		return null;

	}

	public void setColumns(Integer columns) {
		this.columns = columns;
	}

	public String getAlign() {

		if (this.align != null) {
			return this.align;
		}

		ValueBinding vb = getValueBinding("align");

		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;

	}

	public void setAlign(String align) {
		this.align = align;
	}

	@Override
	public void restoreState(FacesContext context, Object state) {

		Object[] values = (Object[]) state;

		super.restoreState(context, values[0]);

		guessCol = (Integer) values[1];
		columns = (Integer) values[2];
		align = (String) values[3];

	}

	@Override
	public Object saveState(FacesContext context) {

		Object[] values = new Object[4];

		values[0] = super.saveState(context);
		values[1] = guessCol;
		values[2] = columns;
		values[3] = align;

		return values;

	}

}
