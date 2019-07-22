package com.ADB.client;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import gwt.material.design.client.ui.MaterialContainer;
import gwt.material.design.client.ui.MaterialHeader;
import gwt.material.design.client.ui.MaterialLink;

public class Home2 extends Composite {

	private static Home2UiBinder uiBinder = GWT.create(Home2UiBinder.class);

	interface Home2UiBinder extends UiBinder<Widget, Home2> {
		
	}
	
	@UiField
	MaterialHeader header;
	
    @UiField
    MaterialLink l1;
    
    @UiField
    MaterialLink l2;
    
    @UiField
    MaterialLink l3;
    
    @UiField
    MaterialLink l4;
    
    @UiField
    MaterialLink l5;
    
    @UiField
    MaterialLink l6;
    
    @UiField
    MaterialLink l7;
    
    @UiField
    MaterialContainer mc;
     
   
	public Home2() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@UiHandler("l4")
	void onClick(ClickEvent e)
	{
		
		History.newItem("aa");
		MySpace.getInstance().koifunction();
	}
	
	@UiHandler("l3")
	void onClick1(ClickEvent e)
	{
		History.newItem("dd");
		MySpace.getInstance().koifunction();
	}
	@UiHandler("l1")
	void onClick2(ClickEvent e)
	{
		History.newItem("ee");
		MySpace.getInstance().koifunction();
		
	}
	
	@UiHandler("l5")
	void onClick3(ClickEvent e)
	{
		History.newItem("ff");
		MySpace.getInstance().koifunction();
	}
	@UiHandler("l2")
	void onClick4(ClickEvent e)
	{
		History.newItem("bb");
		MySpace.getInstance().koifunction();
	}
}
