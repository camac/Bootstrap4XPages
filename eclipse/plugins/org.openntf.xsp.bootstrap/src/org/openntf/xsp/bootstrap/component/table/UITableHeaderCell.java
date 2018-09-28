package org.openntf.xsp.bootstrap.component.table;

import com.ibm.xsp.component.xp.XspTableCell;

public class UITableHeaderCell extends XspTableCell {

	public static final String RENDERER_TYPE = "org.openntf.xsp.bootstrap.TableHeaderCell";

	public UITableHeaderCell() {
		super();
		setRendererType(RENDERER_TYPE);
	}

}
