package org.openntf.xsp.bootstrap.renderkit.html_extended.extlib.containers;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import org.openntf.xsp.bootstrap.component.container.UIJumbotron;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.renderkit.html_basic.PanelRenderer;

public class BootstrapJumbotronRenderer extends PanelRenderer {

	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {

		super.encodeBegin(context, component);

		if (component instanceof UIJumbotron) {

			UIJumbotron tron = (UIJumbotron) component;

			String heading = tron.getHeading();
			String subHeading = tron.getSubHeading();

			ResponseWriter w = context.getResponseWriter();

			if (tron.isFluid()) {
				w.startElement("div", null);
				w.writeAttribute("class", "container", null);
			}

			if (StringUtil.isNotEmpty(heading)) {
				w.startElement("h1", null);
				w.writeAttribute("class", "display-4", null);
				w.write(heading);
				w.endElement("h1");
			}

			if (StringUtil.isNotEmpty(subHeading)) {
				w.startElement("p", null);
				w.writeAttribute("class", "lead", null);
				w.write(subHeading);
				w.endElement("p");
			}
			
			if (!tron.getChildren().isEmpty()) {
				w.startElement("hr", null);
				w.writeAttribute("class", "my-4", null);
				w.endElement("hr");
			}

		}

	}

	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {

		if (component instanceof UIJumbotron) {

			UIJumbotron tron = (UIJumbotron) component;

			ResponseWriter w = context.getResponseWriter();
			
			if (tron.isFluid()) {
				w.endElement("div");
			}
		}

		super.encodeEnd(context, component);
	}

}
