package com.ADB.client;

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

public class LoginHost2 extends Composite  {

	private static LoginHost2UiBinder uiBinder = GWT.create(LoginHost2UiBinder.class);

	interface LoginHost2UiBinder extends UiBinder<Widget, LoginHost2> {
	}

	public LoginHost2() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	static String s1;
	String s2;
	GreetingServiceAsync a3 = GWT.create(GreetingService.class);
	
	@UiField
	MaterialTextBox t1;
	
	@UiField
	MaterialTextBox t2;
	
	@UiField
	MaterialButton b1;
	
	@UiHandler("b1")
	public void onClick(ClickEvent e)
	{
		if(t1.getText()=="" && t2.getText()=="")
		{
			Window.alert("Please enter your emailid and password");
		}
		else
		{
		s1=t1.getText();
		s2=t2.getText();
		a3.LoginHost(s1, s2, new AsyncCallback<String>(){

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				Window.alert("pgl ho gya h");
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("Yes"))
				{
					History.newItem("cc");
					MySpace.getInstance().koifunction();
				}
				else
					Window.alert("INVALID");
			}
			
		});
		}
	}

}
