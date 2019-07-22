package com.ADB.server;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ADB.client.GreetingService;
import com.ADB.client.GreetingServiceAsync;
import com.ADB.client.LoginHost2;
import com.ADB.client.MySpace;
import com.ADB.shared.RegisterHost;
import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.rpc.AsyncCallback;

public class RegisHost extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest req,HttpServletResponse res) throws IOException,ServerException
	{
		RegisterHost r= new RegisterHost();
		r.setName(req.getParameter("t1"));
		r.setUname(req.getParameter("t2"));
		r.setEid(req.getParameter("t3"));
		r.setPass(req.getParameter("t4"));
		GreetingServiceAsync a1 = GWT.create(GreetingService.class);
		a1.inserthost(r,new AsyncCallback<String>() {

			@Override
			public void onFailure(Throwable caught) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onSuccess(String result) {
				// TODO Auto-generated method stub
				if(result.equals("OK"))
                {
					LoginHost2 lh=new LoginHost2();
					/*
                	History.newItem("bb");
            		MySpace.getInstance().koifunction();
            		*/
                }
			}
			
		});
	}
}
