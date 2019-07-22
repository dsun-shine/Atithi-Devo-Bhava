package com.ADB.client;

import com.ADB.shared.Profile;
import com.ADB.shared.Room;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.logical.shared.CloseEvent;
import com.google.gwt.event.logical.shared.CloseHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;

import gwt.material.design.client.constants.Color;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardAction;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialCardImage;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialImage;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialLink;
import gwt.material.design.client.ui.MaterialNavBar;
import gwt.material.design.client.ui.MaterialRow;
import gwt.material.design.client.ui.MaterialSearch;

public class Booking extends Composite {

	private static BookingUiBinder uiBinder = GWT.create(BookingUiBinder.class);

	interface BookingUiBinder extends UiBinder<Widget, Booking> {
	}

	GreetingServiceAsync b = GWT.create(GreetingService.class);
	MaterialLabel m2,m3,m4,m5;
	MaterialButton mb1[]=new MaterialButton[10];
	MaterialButton mb2[]=new MaterialButton[10];
	int j;
	@UiField
	MaterialSearch txtSearch;

	@UiField
	MaterialLink btnSearch;

	@UiField
	MaterialNavBar navBar;

	@UiField
	MaterialNavBar navBarSearch;

	public Booking() {
		initWidget(uiBinder.createAndBindUi(this));
		txtSearch.addOpenHandler(openEvent -> {
			navBar.setVisible(false);
			navBarSearch.setVisible(true);
		});
		txtSearch.addCloseHandler(new CloseHandler<String>() {
			@Override
			public void onClose(CloseEvent<String> event) {
				// TODO Auto-generated method stub
				navBar.setVisible(true);
				navBarSearch.setVisible(false);
			}
		});
	}

	@UiHandler("btnSearch")
	void onSearch(ClickEvent e) {
		txtSearch.open();
	}

	@UiHandler("txtSearch")
	void onKeyUp(KeyUpEvent event) {
		// check for ENTER and trigger save
		if (event.getNativeEvent().getKeyCode() == 13) {
			RootPanel.get("t3").clear();
			b.Search(txtSearch.getText(), new AsyncCallback<Profile[]>() {

				@Override
				public void onFailure(Throwable caught) {
					// TODO Auto-generated method stub
					caught.printStackTrace();
					Window.alert("pass");

				}

				
				@Override
				public void onSuccess(Profile[] result) {
					// TODO Auto-generated method stub
					for(j=0;j<result.length;j++)
					{
						String s1=result[j].getUsername();
						
						MaterialColumn mcolumn1=new MaterialColumn();
						MaterialColumn mcolumn2=new MaterialColumn();
						MaterialRow mr=new MaterialRow(); 
						MaterialCard mc2=new MaterialCard(); 
						mc2.setMarginLeft(170);
						mc2.setMarginRight(140);
						MaterialCardImage mcm=new MaterialCardImage();
						MaterialImage mi=new MaterialImage("data:image/jpeg;base64,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");
						
						MaterialCardContent mcc2=new MaterialCardContent();
						m3=new MaterialLabel(result[j].getName()); 
						m3.setFontSize("1.9em");
						m2=new MaterialLabel(result[j].getAddress());
						m4=new  MaterialLabel("contact:"+result[j].getMobile());
					    m5=new  MaterialLabel(result[j].getCity());
						MaterialCardAction mca=new MaterialCardAction(); 
						mb1[j]=new MaterialButton("BOOK");
					    mb2[j]=new MaterialButton("View Details");
					    mb2[j].setBackgroundColor(Color.BLUE_ACCENT_1);
					    mb2[j].setTextColor(Color.BLACK);
					    mcc2.add(m3);
					    mcc2.add(m2); mcc2.add(m4); mcc2.add(m5); mcm.add(mi); mca.add(mb1[j]); mca.add(mb2[j]);
								  mc2.add(mcm); mc2.add(mcc2); mc2.add(mca); mcolumn1.add(mcm);
								  mcolumn2.add(mcc2); mcolumn2.add(mca); mr.add(mcolumn1); mr.add(mcolumn2);
							 mc2.add(mr); RootPanel.get("t3").add(mc2);
		           
						mb1[j].addClickHandler(new ClickHandler() {
							
							@Override
							public void onClick(ClickEvent event) {
								// TODO Auto-generated method stub
								DashBoard dd=new DashBoard();
								dd.request();
							}
						});	 
						mb2[j].addClickHandler(new ClickHandler() {
							public void onClick(ClickEvent e)
							{
								b.showDetails(s1,new AsyncCallback<Room>() {

									@Override
									public void onFailure(Throwable caught) {
										// TODO Auto-generated method stub
										Window.alert("fail");
									}

									@Override
									public void onSuccess(Room result) {
										// TODO Auto-generated method stub
										/*
										History.newItem("gg");
										MySpace.getInstance().koifunction2(result);
										*/
										Detail dd=new Detail(result);
										RootPanel.get("t3").clear();
										RootPanel.get("t3").add(dd);
									}
									
								});
							}
							
						});	
					}
				}
			});
		}
	}
}
