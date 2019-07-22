package com.ADB.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class RoomDetail extends Composite{

	private static RoomDetailUiBinder uiBinder = GWT.create(RoomDetailUiBinder.class);

	interface RoomDetailUiBinder extends UiBinder<Widget, RoomDetail> {
	}

	public RoomDetail() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	
}
