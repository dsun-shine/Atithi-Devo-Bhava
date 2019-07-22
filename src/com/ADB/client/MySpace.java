package com.ADB.client;


import com.ADB.shared.Room;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.RootPanel;

public class MySpace {

	static MySpace me=null;
	RegHost2 rh=null;
	LoginHost2 lh=null;
	DashBoard db=null;
	RegVis rv=null;
	LoginVis2 lv=null;
	Booking b=null;
	Detail dd=null;
	private MySpace()
	{
	}
	static MySpace getInstance() {
		if(me==null)
			me=new MySpace();
		return me;
	}
	public void koifunction() {
		if(History.getToken().equals("aa"))
		{
			RootPanel.get("t2").clear();
			RootPanel.get("t3").clear();
			RootPanel.get("t2").add(getReghost());
		}
		else if(History.getToken().equals("bb"))
		{
			RootPanel.get("t2").clear();
			RootPanel.get("t3").clear();
			RootPanel.get("t2").add(getLoginhost());
		}
		else if(History.getToken().equals("cc"))
		{
			RootPanel.get("t2").clear();
			RootPanel.get("t2").add(getdashboard());
		}
		else if(History.getToken().equals("dd"))
		{
			RootPanel.get("t2").clear();
			RootPanel.get("t3").clear();
			RootPanel.get("t2").add(getregvis());
		}
		else if(History.getToken().equals("ee"))
		{
			RootPanel.get("t2").clear();
			RootPanel.get("t3").clear();
			RootPanel.get("t2").add(getloginvis());
		}
		else if(History.getToken().equals("ff"))
		{
			RootPanel.get("t2").clear();
			RootPanel.get("t3").clear();
			RootPanel.get("t2").add(getbooking());
		}
		
	}
	public void koifunction2(Room r) {
		if(History.getToken().equals("gg"))
		{
			RootPanel.get("t3").clear();
			RootPanel.get("t3").add(getDetail(r));
		}
	}
	Detail getDetail(Room r)
	{
		if(dd==null)
			dd=new Detail(r);
		return dd;
	}
	RegHost2 getReghost()
	{
		if(rh==null)
			rh=new RegHost2();
		return rh;
	}
	LoginHost2 getLoginhost()
	{
		if(lh==null)
			lh=new LoginHost2();
		return lh;
	}
	DashBoard getdashboard()
	{
		if(db==null)
			db=new DashBoard();
		return db;	
	}
	RegVis getregvis()
	{
		if(rv==null)
			rv=new RegVis();
		return rv;
	}
	LoginVis2 getloginvis()
	{
		if(lv==null)
			lv=new LoginVis2();
		return lv;
	}
	Booking getbooking()
	{
		if(b==null)
			b=new Booking();
		return b;
	}
}
