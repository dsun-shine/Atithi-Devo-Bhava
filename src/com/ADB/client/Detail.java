package com.ADB.client;

import com.ADB.shared.Room;
import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialLabel;

public class Detail extends Composite{

	private static DetailUiBinder uiBinder = GWT.create(DetailUiBinder.class);

	interface DetailUiBinder extends UiBinder<Widget, Detail> {
	}

	@UiField
	MaterialLabel t1;
	
	@UiField
	MaterialLabel t2;
	
	@UiField
	MaterialLabel t3;
	
	@UiField
	MaterialLabel t4;
	
	@UiField
	MaterialLabel t5;
	
	@UiField
	MaterialLabel t6;
	
	public Detail(Room r)
	{
		initWidget(uiBinder.createAndBindUi(this));
		t1.setText(r.getService());
		t2.setText(r.getWifi());
		t3.setText("Rs."+r.getPrice()+" per room/night");
		t4.setText(r.getAC());
		t5.setText("only "+r.getPerson()+" person can stay in a room");
	}
	
}
