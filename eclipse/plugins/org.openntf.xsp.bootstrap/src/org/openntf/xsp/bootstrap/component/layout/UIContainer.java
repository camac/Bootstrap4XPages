package org.openntf.xsp.bootstrap.component.layout;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.component.UIPanelEx;
import com.ibm.xsp.extlib.util.ExtLibUtil;

public class UIContainer extends UIPanelEx {

	private Boolean fluid = null;

	public UIContainer() {
		super();
	}

	public Boolean isFluid() {

		if (this.fluid != null) {
			return this.fluid;
		}

		ValueBinding vb = getValueBinding("fluid");

		if (vb != null) {
			return (Boolean) vb.getValue(getFacesContext());
		}

		return false;

	}

	public void setFluid(Boolean fluid) {
		this.fluid = fluid;
	}

	@Override
	public String getStyleClass() {

		String styleClass = super.getStyleClass();

		if (isFluid()) {
			styleClass = ExtLibUtil.concatStyleClasses(styleClass, "container-fluid");
		} else {
			styleClass = ExtLibUtil.concatStyleClasses(styleClass, "container");
		}

		return styleClass;

	}

	@Override
	public void restoreState(FacesContext context, Object state) {

		Object[] values = (Object[]) state;

		super.restoreState(context, values[0]);
		fluid = (Boolean) values[1];

	}

	@Override
	public Object saveState(FacesContext context) {

		Object[] values = new Object[2];

		values[0] = super.saveState(context);
		values[1] = fluid;

		return values;

	}

}
