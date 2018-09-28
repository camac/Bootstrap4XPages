package org.openntf.xsp.bootstrap.component.container;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import com.ibm.xsp.component.UIPanelEx;
import com.ibm.xsp.extlib.util.ExtLibUtil;

public class UIJumbotron extends UIPanelEx {

	private String heading;
	private String subHeading;

	private static final String RENDERER_TYPE = "org.openntf.xsp.bootstrap.renderkit.html_extended.extlib.containers.BootstrapJumbotronRenderer";
	
	private Boolean fluid;

	public UIJumbotron() {

		setRendererType(RENDERER_TYPE);
		
	}

	@Override
	public String getStyleClass() {

		String styleClass = super.getStyleClass();

		if (isFluid()) {
			styleClass = ExtLibUtil.concatStyleClasses(styleClass, "jumbotron jumbotron-fluid");
		} else {
			styleClass = ExtLibUtil.concatStyleClasses(styleClass, "jumbotron");
		}

		return styleClass;

	}

	public String getHeading() {

		if (this.heading != null) {
			return this.heading;
		}

		ValueBinding vb = getValueBinding("heading");

		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;

	}

	public void setHeading(String heading) {
		this.heading = heading;
	}

	public String getSubHeading() {

		if (this.subHeading != null) {
			return this.subHeading;
		}

		ValueBinding vb = getValueBinding("subHeading");

		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;

	}

	public void setSubHeading(String subHeading) {
		this.subHeading = subHeading;
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
	public void restoreState(FacesContext context, Object state) {

		Object[] values = (Object[]) state;

		super.restoreState(context, values[0]);

		fluid = (Boolean) values[1];
		heading = (String) values[2];
		subHeading = (String) values[3];

	}

	@Override
	public Object saveState(FacesContext context) {

		Object[] values = new Object[4];

		values[0] = super.saveState(context);
		values[1] = fluid;
		values[2] = heading;
		values[3] = subHeading;

		return values;

	}

}
