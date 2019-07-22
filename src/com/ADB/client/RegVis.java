package com.ADB.client;

import com.ADB.shared.RegisterHost;
import com.ADB.shared.RegisterVisitor;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class RegVis extends Composite  {

	private static RegVisUiBinder uiBinder = GWT.create(RegVisUiBinder.class);

	interface RegVisUiBinder extends UiBinder<Widget, RegVis> {
	}

	@UiField
	MaterialButton b1;
	
	@UiField
	MaterialTextBox t1;
	
	@UiField
	MaterialTextBox t2;
	
	@UiField
	MaterialTextBox t3;
	
	@UiField
	MaterialTextBox t4;
	public RegVis() {
		initWidget(uiBinder.createAndBindUi(this));
		
	}
	
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	
	@UiHandler("b1")
	void onClick(ClickEvent e)
	{
		if(t1.getText()=="" || t2.getText()=="" || t3.getText()=="" || t4.getText()=="")
		{
			Window.alert("All Fields Must Be Filled");
		}
		else
		{
		RegisterVisitor h=new RegisterVisitor();
		h.setName(t1.getText());
		h.setUname(t2.getText());
		h.setEid(t3.getText());
		h.setPass(t4.getText());
		a1.insertvis(h , new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
                if(result.equals("OK"))
                {
                	History.newItem("ee");
            		MySpace.getInstance().koifunction();
                }
                else
                {
                	Window.alert("All Fields should be fill");
                }
			}

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
                Window.alert("pass");
			}
		});
		}
	}
}
