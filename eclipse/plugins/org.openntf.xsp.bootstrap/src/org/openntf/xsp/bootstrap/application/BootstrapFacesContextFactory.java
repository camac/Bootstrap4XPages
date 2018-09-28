package org.openntf.xsp.bootstrap.application;

import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.context.FacesContextFactory;
import javax.faces.lifecycle.Lifecycle;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ibm.commons.util.StringUtil;
import com.ibm.xsp.FacesExceptionEx;
import com.ibm.xsp.adapter.IAdapterManager;
import com.ibm.xsp.application.ApplicationEx;
import com.ibm.xsp.context.FacesContextFactoryImpl;
import com.ibm.xsp.util.Delegation;

/**
 * 
 * Work here is heavily derived from Sven Hasselbach's ThemeSwitchingContext
 * http://hasselba.ch/blog/?p=1414
 *
 */
public class BootstrapFacesContextFactory extends FacesContextFactoryImpl {

	private FacesContextFactory _delegate;

	private Boolean enabled = null;

	public static final String XSPPROP_ENABLED = "xsp.bootstrap.facescontextfactory.enabled";

	public BootstrapFacesContextFactory() {
		super();

		try {
			this._delegate = ((FacesContextFactory) Delegation.getImplementation("faces-context-factory"));
		} catch (Exception e) {
			throw new FacesExceptionEx(e);
		}

	}

	public BootstrapFacesContextFactory(FacesContextFactory delegate) {
		super(delegate);
		this._delegate = delegate;
	}

	@Override
	public FacesContext getFacesContext(Object servletContext, Object request, Object response, Lifecycle lifecycle)
			throws FacesException {

		if (enabled == null) {
			String prop = ApplicationEx.getInstance().getApplicationProperty(XSPPROP_ENABLED, "true");
			enabled = StringUtil.isTrueValue(prop);
		}

		if (enabled) {

			if (!(response instanceof HttpServletResponse)) {

				HttpServletResponse resp = null;

				IAdapterManager localObject1 = (IAdapterManager) ((ServletContext) servletContext)
						.getAttribute("adapter");
				if (localObject1 != null) {
					resp = (HttpServletResponse) ((IAdapterManager) localObject1).loadAdapter(response,
							HttpServletResponse.class.getName());
					if (resp != null) {
						response = resp;
					}
				}
			}

			if (!(request instanceof HttpServletRequest)) {

				HttpServletRequest req = null;

				IAdapterManager adapter = (IAdapterManager) ((ServletContext) servletContext).getAttribute("adapter");
				if (adapter != null) {
					req = (HttpServletRequest) ((IAdapterManager) adapter).loadAdapter(request,
							HttpServletRequest.class.getName());
					if (req != null) {
						request = req;
					}
				}
			}

			FacesContext facesContext = this._delegate.getFacesContext(servletContext, request, response, lifecycle);

			return new BootstrapFacesContext(facesContext);
		} else {
			return this._delegate.getFacesContext(servletContext, request, response, lifecycle);
		}
	}

}
