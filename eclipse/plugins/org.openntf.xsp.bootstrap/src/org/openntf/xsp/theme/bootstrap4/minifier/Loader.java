/*
 * � Copyright IBM Corp. 2015
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at:
 * 
 * http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or 
 * implied. See the License for the specific language governing 
 * permissions and limitations under the License.
 */
package org.openntf.xsp.theme.bootstrap4.minifier;

import java.net.URL;

import javax.servlet.http.HttpServletRequest;

import org.openntf.xsp.theme.bootstrap4.plugin.Activator;
import org.osgi.framework.Bundle;

import com.ibm.commons.util.DoubleMap;
import com.ibm.xsp.extlib.minifier.ExtLibLoaderExtension;
import com.ibm.xsp.extlib.resources.ExtlibResourceProvider;
import com.ibm.xsp.extlib.util.ExtLibUtil;

public class Loader extends ExtLibLoaderExtension {

	public Loader() {}

	@Override
	public Bundle getOSGiBundle() {
		return Activator.instance.getBundle();
	}

	// ========================================================
	// Handling Dojo
	// ========================================================

	@Override
	public void loadDojoShortcuts(DoubleMap<String, String> aliases, DoubleMap<String, String> prefixes) {
		// / ALIASES
		if (aliases != null) {
			// CAREFULLY MAKE SURE THAT THERE IS NO CONFLICT WITH ANOTHER
			// LIBRARY
		}

		// / PREFIXES
		if (prefixes != null) {
			// CAREFULLY MAKE SURE THAT THERE IS NO CONFLICT WITH ANOTHER
			// LIBRARY
		}
	}

	// ========================================================
	// Handling CSS
	// ========================================================

	@Override
	public void loadCSSShortcuts(DoubleMap<String, String> aliases, DoubleMap<String, String> prefixes) {
		// / ALIASES
		if (aliases != null) {
			// CAREFULLY MAKE SURE THAT THERE IS NO CONFLICT WITH ANOTHER
			// LIBRARY
			//aliases.put("@Ea","/.ibmxspres/.extlib/css/tagcloud.css"); //$NON-NLS-1$ //$NON-NLS-2$
		}

		// / PREFIXES
		if (prefixes != null) {
			// CAREFULLY MAKE SURE THAT THERE IS NO CONFLICT WITH ANOTHER
			// LIBRARY
			prefixes.put("4B4a", "/.ibmxspres/.extlib/responsive/bootstrap4"); //$NON-NLS-1$ //$NON-NLS-2$
			prefixes.put("4B4b", "/.ibmxspres/.extlib/responsive/bootstrap4/js"); //$NON-NLS-1$ //$NON-NLS-2$
			prefixes.put("4B4c", "/.ibmxspres/.extlib/responsive/bootstrap4/css"); //$NON-NLS-1$ //$NON-NLS-2$

//			prefixes.put("4Dba", "/.ibmxspres/.extlib/responsive/dijit/dbootstrap-0.1.1"); //$NON-NLS-1$ //$NON-NLS-2$
//			prefixes.put("4Dbb", "/.ibmxspres/.extlib/responsive/dijit/dbootstrap-0.1.1/theme"); //$NON-NLS-1$ //$NON-NLS-2$
//			prefixes.put("4Dbc", "/.ibmxspres/.extlib/responsive/dijit/dbootstrap-0.1.1/theme/dbootstrap"); //$NON-NLS-1$ //$NON-NLS-2$

//			prefixes.put("4JQa", "/.ibmxspres/.extlib/responsive/jquery"); //$NON-NLS-1$ //$NON-NLS-2$

			prefixes.put("4XPa", "/.ibmxspres/.extlib/responsive/xpages"); //$NON-NLS-1$ //$NON-NLS-2$
			prefixes.put("4XPb", "/.ibmxspres/.extlib/responsive/xpages/css"); //$NON-NLS-1$ //$NON-NLS-2$
//			prefixes.put("4XPc", "/.ibmxspres/.extlib/responsive/xpages/img"); //$NON-NLS-1$ //$NON-NLS-2$
			prefixes.put("4XPd", "/.ibmxspres/.extlib/responsive/xpages/js"); //$NON-NLS-1$ //$NON-NLS-2$
		}
	}

	// ========================================================
	// Serving resources
	// ========================================================

	@Override
	public URL getResourceURL(HttpServletRequest request, String name) {
		if (name.startsWith("responsive")) { //$NON-NLS-1$
			String path = ExtlibResourceProvider.BUNDLE_RES_PATH_EXTLIB + name;
			return ExtLibUtil.getResourceURL(Activator.instance.getBundle(), path);
		}
		return null;
	}
}
