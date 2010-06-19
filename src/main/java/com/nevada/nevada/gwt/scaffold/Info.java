package com.nevada.nevada.gwt.scaffold;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class Info extends Composite {

	private static InfoUiBinder uiBinder = GWT.create(InfoUiBinder.class);

	interface InfoUiBinder extends UiBinder<Widget, Info> {
	}

	public Info() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}
