/*
 * © Copyright IBM Corp. 2010, 2012
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

package org.openntf.xsp.bootstrap.themes;

import java.io.InputStream;

import com.ibm.xsp.stylekit.StyleKitFactory;


/**
 * Bootstrap theme Factory.
 * 
 * @author Philippe Riand
 */
public class BootswatchStyleKitFactory implements StyleKitFactory {
	
	public BootswatchStyleKitFactory() {
	}
	
	@Override
	public InputStream getThemeAsStream(String themeId, int scope) {
		if(scope==StyleKitFactory.STYLEKIT_GLOBAL) {
            
			String folderPath = "org/openntf/xsp/bootstrap/themes"; //$NON-NLS-1$

			if(themeId.equals("bootswatch_amelia")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_amelia.theme"); //$NON-NLS-1$
			}
			
			if(themeId.equals("bootswatch_cerulean")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_cerulean.theme"); //$NON-NLS-1$
			}

			if(themeId.equals("bootswatch_cosmo")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_cosmo.theme"); //$NON-NLS-1$
			}

			if(themeId.equals("bootswatch_cupid")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_cupid.theme"); //$NON-NLS-1$
			}
			
			if(themeId.equals("bootswatch_cyborg")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_cyborg.theme"); //$NON-NLS-1$
			}
			
			if(themeId.equals("bootswatch_flatly")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_flatly.theme"); //$NON-NLS-1$
			}

			if(themeId.equals("bootswatch_journal")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_journal.theme"); //$NON-NLS-1$
			}

			if(themeId.equals("bootswatch_lumen")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_lumen.theme"); //$NON-NLS-1$
			}
			
			if(themeId.equals("bootswatch_readable")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_readable.theme"); //$NON-NLS-1$
			}
			
			if(themeId.equals("bootswatch_simplex")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_simplex.theme"); //$NON-NLS-1$
			}

			if(themeId.equals("bootswatch_slate")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_slate.theme"); //$NON-NLS-1$
			}

			if(themeId.equals("bootswatch_spacelab")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_spacelab.theme"); //$NON-NLS-1$
			}
			
			if(themeId.equals("bootswatch_superhero")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_superhero.theme"); //$NON-NLS-1$
			}
			
			if(themeId.equals("bootswatch_united")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_united.theme"); //$NON-NLS-1$
			}

			if(themeId.equals("bootswatch_yeti")){ //$NON-NLS-1$
                return getThemeFromBundle(folderPath+"/bootswatch_yeti.theme"); //$NON-NLS-1$
			}
			
		}
		return null;
	}

	@Override
	public InputStream getThemeFragmentAsStream(String themeId, int scope) {
		return null;
	}

	private InputStream getThemeFromBundle(final String fileName) {
		ClassLoader cl = getClass().getClassLoader();
		return cl.getResourceAsStream(fileName);
   }
}