package com.ADB.client;

import com.ADB.shared.Profile;
import com.ADB.client.LoginHost2;
import com.ADB.shared.Room;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import gwt.material.design.client.ui.MaterialButton;
import gwt.material.design.client.ui.MaterialCard;
import gwt.material.design.client.ui.MaterialCardAction;
import gwt.material.design.client.ui.MaterialCardContent;
import gwt.material.design.client.ui.MaterialColumn;
import gwt.material.design.client.ui.MaterialLabel;
import gwt.material.design.client.ui.MaterialRadioButton;
import gwt.material.design.client.ui.MaterialTextBox;

public class DashBoard extends Composite {

	private static DashBoardUiBinder uiBinder = GWT.create(DashBoardUiBinder.class);

	interface DashBoardUiBinder extends UiBinder<Widget, DashBoard> {
	}

	MaterialTextBox m1,m2,m3,m4,m5,m6,m7,m8,m9;
	MaterialRadioButton mrb1[]=new MaterialRadioButton[12];
	MaterialRadioButton mrb2[]=new MaterialRadioButton[12];
	MaterialLabel label[]=new MaterialLabel[6];
	MaterialCard mc=null;
	MaterialCardContent mcc=null;
	MaterialCardAction mca=null;
	MaterialButton b1;
	Room r1=new Room();
	@UiField
	MaterialColumn req;
	
	@UiField
	MaterialButton t1;
	
	@UiField
	MaterialButton t2;
	
	@UiField
	MaterialButton t3;
	
	@UiField
	MaterialButton t4;
	
	@UiField
	MaterialButton t5;
	
	public DashBoard() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	public void request()
	{
		
	}

	public void init1() {
		mc=new MaterialCard();
		mc.setMarginLeft(320);
		mc.setMarginRight(300);
		mcc=new MaterialCardContent();
		mca=new MaterialCardAction();
		m1=new MaterialTextBox();
		m2=new MaterialTextBox();
		m3=new MaterialTextBox();
		m4=new MaterialTextBox();
		m5=new MaterialTextBox();
		m6=new MaterialTextBox();
		b1=new MaterialButton("");
		b1.setWidth("100%");
		mca.add(b1);
		mcc.add(m1);
		mcc.add(m2);
		mcc.add(m3);
		mcc.add(m4);
		mcc.add(m5);
		mcc.add(m6);
		mc.add(mcc);
		mc.add(mca);
		RootPanel.get("t3").clear();
		RootPanel.get("t3").add(mc);
	}
	public void init2() {
		
		String s[]=new String[] {"what do you provide to the tourist kitchen or food?","WIFI","AC"};
		String s1[]=new String[] {"Kitchen","Free WIFI","AC"};
		String s2[]=new String[] {"Fooding","NO Wifi","NON AC"};
		RootPanel.get("t3").clear();
		MaterialCard mc=new MaterialCard();
		mc.setMarginLeft(320);
		mc.setMarginRight(300);
		MaterialCardContent mcc=new MaterialCardContent();
		MaterialCardAction mca=new MaterialCardAction();
		for(int i=0;i<3;i++)
		{
		label[i]=new MaterialLabel((i+1)+". "+s[i]);
		label[i].setFontSize("1.5em");
		mrb1[i]=new MaterialRadioButton("service"+i,s1[i]);
		mrb2[i]=new MaterialRadioButton("service"+i,s2[i]);
		mcc.add(label[i]);
		mcc.add(mrb1[i]);
		mcc.add(mrb2[i]);
		mc.add(mcc);
		}
		m7=new MaterialTextBox();
		m7.setLabel("price per room/night");
		m8=new MaterialTextBox();
		m8.setLabel("No.of person can stay in a room");
		m9=new MaterialTextBox();
		m9.setLabel("Username");
		MaterialButton b1=new MaterialButton("submit");
        b1.setWidth("100%");
		mcc.add(m7);
		mcc.add(m8);
		mcc.add(m9);
		mcc.add(b1);
		RootPanel.get("t3").add(mc);
	}
	public void init3() {
		MaterialCard c1=new MaterialCard();
		c1.setMarginLeft(320);
		c1.setMarginRight(300);
		MaterialCardContent c2=new MaterialCardContent();
		final FormPanel form = new FormPanel();
	    form.setAction("http://127.0.0.1:8888/adb/upload");
	    form.setEncoding(FormPanel.ENCODING_MULTIPART);
	    form.setMethod(FormPanel.METHOD_POST);
	    VerticalPanel panel = new VerticalPanel();
	    form.setWidget(panel);
	    FileUpload upload = new FileUpload();
	    upload.setName("uploadFormElement");
	    panel.add(upload);
	    panel.add(new Button("Submit", new ClickHandler() {
		      public void onClick(ClickEvent event) {
		        form.submit();
		      }
		    }));
		    form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {
		      public void onSubmitComplete(SubmitCompleteEvent event) {
		        Window.alert(event.getResults());
		      }
		    });
            c2.add(form);
            c1.add(c2);
            RootPanel.get("t3").clear();
		    RootPanel.get("t3").add(c1);
	}
	GreetingServiceAsync a1 = GWT.create(GreetingService.class);
	
	
	@UiHandler("t3")
	public void onClick2(ClickEvent e)
	{
		String p=LoginHost2.s1;
		a1.EditProfile(p , new AsyncCallback<Profile>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Profile result) {
				// TODO Auto-generated method stub
				init1();
				m1.setLabel("Full Name");
				m2.setLabel("UserName");
				m3.setLabel("Mobile");
				m4.setLabel("Adhar no.");
				m5.setLabel("Address");
				m6.setLabel("City");
				m1.setText(result.getName());
				m2.setText(result.getUsername());
				m3.setText(result.getMobile());
				m4.setText(result.getAdhar());
				m5.setText(result.getAddress());
				m6.setText(result.getCity());
				b1.setText("Edit");
				b1.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						Profile h=new Profile();
						h.setName(m1.getText());
						h.setUsername(m2.getText());
						h.setMobile(m3.getText());
						h.setAdhar(m4.getText());
						h.setAddress(m5.getText());
						h.setCity(m6.getText());
						a1.updatepro(h ,p, new AsyncCallback<String>() {
							
							@Override
							public void onSuccess(String result) {
								// TODO Auto-generated method stub
				                if(result.equals("OK"))
				                {
				                	Window.alert("Your Profile is Suceessfully Updated");
				                }
							}

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
				                Window.alert("pass");
							}
						});

					}
					
				});
			}

			
			
		});
		
	}
	@UiHandler("t5")
	public void onClick7(ClickEvent e)
	{
		init3();
	}
	@UiHandler("t1")
	public void onClick(ClickEvent e)
	{
		init1();
		m1.setLabel("Full Name");
		m2.setLabel("UserName");
		m3.setLabel("Mobile");
		m4.setLabel("Adhar no.");
		m5.setLabel("Address");
		m6.setLabel("City");
		b1.setText("Submit");
		
		b1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				Profile h=new Profile();
				h.setName(m1.getText());
				h.setUsername(m2.getText());
				h.setMobile(m3.getText());
				h.setAdhar(m4.getText());
				h.setAddress(m5.getText());
				h.setCity(m6.getText());
				a1.inserthostpro(h , new AsyncCallback<String>() {
					
					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
		                if(result.equals("OK"))
		                {
		                	Window.alert("Your Profile is Suceessfully Submited");
		                }
					}

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
		                Window.alert("pass");
					}
				});

			}
			
		});
	}
	
	@SuppressWarnings("deprecation")
	@UiHandler("t2")
	public void onClick1(ClickEvent e)
	{
		init3();
		init2();
		b1.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				// TODO Auto-generated method stub
				if(mrb1[0].isChecked())
					r1.setService(mrb1[0].getText());
				if(mrb2[0].isChecked())
					r1.setService(mrb2[0].getText());
				if(mrb1[1].isChecked())
					r1.setWifi(mrb1[1].getText());
				if(mrb2[1].isChecked())
					r1.setWifi(mrb2[1].getText());
				if(mrb1[2].isChecked())
					r1.setAC(mrb1[2].getText());
				if(mrb2[2].isChecked())
					r1.setAC(mrb2[2].getText());
				r1.setPrice(m7.getText());
				r1.setPerson(m8.getText());
				r1.setUsername(m9.getText());
				a1.insertroom(r1 , new AsyncCallback<String>() {

					@Override
					public void onFailure(Throwable caught) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void onSuccess(String result) {
						// TODO Auto-generated method stub
						 if(result.equals("OK"))
			                {
			                	Window.alert("Done");
			                }
					}
					
				});
			}
			
		});
	}
	@UiHandler("t4")
	public void onClick4(ClickEvent e) {
		String p=LoginHost2.s1;
		a1.EditRoom(p , new AsyncCallback<Room>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(Room result) {
				// TODO Auto-generated method stub
				init2();
				m7.setText(result.getPrice());
				m8.setText(result.getPerson());
				b1.setText("Edit");
				b1.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						// TODO Auto-generated method stub
						Room r1=new Room();
						if(mrb1[0].isChecked())
							r1.setService(mrb1[0].getText());
						if(mrb2[0].isChecked())
							r1.setService(mrb2[0].getText());
						if(mrb1[1].isChecked())
							r1.setWifi(mrb1[1].getText());
						if(mrb2[1].isChecked())
							r1.setWifi(mrb2[1].getText());
						if(mrb1[2].isChecked())
							r1.setAC(mrb1[2].getText());
						if(mrb2[2].isChecked())
							r1.setAC(mrb2[2].getText());
						r1.setPrice(m7.getText());
						r1.setPerson(m8.getText());
						a1.updateroom(r1 ,p, new AsyncCallback<String>() {
							
							@Override
							public void onSuccess(String result) {
								// TODO Auto-generated method stub
				                if(result.equals("OK"))
				                {
				                	Window.alert("Your Room is Suceessfully Updated");
				                }
							}

							@Override
							public void onFailure(Throwable caught) {
								// TODO Auto-generated method stub
				                Window.alert("pass");
							}
						});

					}
					
				});
	}
		});
	}
}
