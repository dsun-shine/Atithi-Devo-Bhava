package com.ADB.client;

import com.ADB.shared.Profile;
import com.ADB.shared.RegisterHost;
import com.ADB.shared.RegisterVisitor;
import com.ADB.shared.Room;
import com.google.gwt.user.client.rpc.AsyncCallback;

/**
 * The async counterpart of <code>GreetingService</code>.
 */
public interface GreetingServiceAsync {
	void Search(String city, AsyncCallback<Profile[]> callback) throws IllegalArgumentException;
	void EditProfile(String username, AsyncCallback<Profile> callback) throws IllegalArgumentException;
	void EditRoom(String username, AsyncCallback<Room> callback) throws IllegalArgumentException;
	void inserthost(RegisterHost h, AsyncCallback<String> callback) throws IllegalArgumentException;
	void showDetails(String user, AsyncCallback<Room> callback) throws IllegalArgumentException;
	void insertvis(RegisterVisitor h, AsyncCallback<String> callback) throws IllegalArgumentException;
	void LoginVis(String s1,String s2 ,AsyncCallback<String> callback) throws IllegalArgumentException;
	void LoginHost(String s1,String s2 ,AsyncCallback<String> callback) throws IllegalArgumentException;
	void inserthostpro(Profile p, AsyncCallback<String> callback) throws IllegalArgumentException;
	void insertroom(Room r1, AsyncCallback<String> callback) throws IllegalArgumentException;
	void updatepro(Profile h, String p, AsyncCallback<String> asyncCallback);
	void updateroom(Room h, String p, AsyncCallback<String> asyncCallback);
}