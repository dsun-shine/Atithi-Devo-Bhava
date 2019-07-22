package com.ADB.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class ADB implements EntryPoint {
	public void onModuleLoad() {
	History.addValueChangeHandler(new ValueChangeHandler<String>() {

		@Override
		public void onValueChange(ValueChangeEvent<String> event) {
			// TODO Auto-generated method stub
			MySpace.getInstance().koifunction();
		}
	    	
    });
	Home2 b=new Home2();
	RootPanel.get("t1").add(b);
	}
}
