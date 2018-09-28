package org.openntf.xsp.bootstrap.component.extended;

import javax.faces.context.FacesContext;
import javax.faces.el.ValueBinding;

import org.openntf.xsp.bootstrap.component.layout.FormGridFriendly;

import com.ibm.xsp.component.xp.XspInputText;



public class BxInputText extends XspInputText implements FormGridFriendly {

	private String label;
	private String help;

	@Override
	public String getLabel() {

		if (this.label != null) {
			return this.label;
		}

		ValueBinding vb = getValueBinding("label");

		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;

	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public String getHelp() {

		if (this.help != null) {
			return this.help;
		}

		ValueBinding vb = getValueBinding("help");

		if (vb != null) {
			return (String) vb.getValue(getFacesContext());
		}

		return null;

	}

	public void setHelp(String help) {
		this.help = help;
	}

	@Override
	public void restoreState(FacesContext context, Object state) {

		Object[] values = (Object[]) state;

		super.restoreState(context, values[0]);

		label = (String) values[1];
		help = (String) values[2];

	}

	@Override
	public Object saveState(FacesContext context) {

		Object[] values = new Object[3];

		values[0] = super.saveState(context);
		values[1] = label;
		values[2] = help;

		return values;

	}

}
