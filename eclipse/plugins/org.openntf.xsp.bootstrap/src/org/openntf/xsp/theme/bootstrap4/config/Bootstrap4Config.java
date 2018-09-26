/*
 * © Copyright IBM Corp. 2015
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
/*
* Author: Brian Gleeson (brian.gleeson@ie.ibm.com)
* Date: 28 Oct 2015
* Bootstrap4Config.java
*/
package org.openntf.xsp.theme.bootstrap4.config;

import org.openntf.xsp.bootstrap.library.BootstrapFragment;

/**
 *
 * @author Brian Gleeson (brian.gleeson@ie.ibm.com)
 */
public class Bootstrap4Config extends BootstrapFragment {
	public Bootstrap4Config() {
	}

	@Override
	public String[] getXspConfigFiles(String[] files) {
		return concat(files, new String[] { 
				"org/openntf/xsp/theme/bootstrap4/config/bootstrap4.xsp-config" // $NON-NLS-1$
		});
	}

	@Override
	public String[] getFacesConfigFiles(String[] files) {
		return concat(files, new String[] { 
				"org/openntf/xsp/theme/bootstrap4/config/bootstrap4-faces-config.xml" // $NON-NLS-1$
		});
	}
}
