package com.ADB.client;

import com.ADB.shared.RegisterHost;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class RegHost2 extends Composite {

	private static RegHost2UiBinder uiBinder = GWT.create(RegHost2UiBinder.class);

	interface RegHost2UiBinder extends UiBinder<Widget, RegHost2> {
	}

	@UiField
	MaterialTextBox t1;
	
	@UiField
	MaterialTextBox t2;
	
	@UiField
	MaterialTextBox t3;
	
	@UiField
	MaterialTextBox t4;
	
	@UiField
	MaterialTextBox t5;
	
	@UiField
	MaterialButton b1;
	
	public RegHost2() {
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
		RegisterHost h=new RegisterHost();
		h.setName(t1.getText());
		h.setUname(t2.getText());
		h.setEid(t3.getText());
		h.setPass(t4.getText());
		h.setMobile(t5.getText());
		a1.inserthost(h , new AsyncCallback<String>() {
			
			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
                if(result.equals("OK"))
                {
                	History.newItem("bb");
            		MySpace.getInstance().koifunction();
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
