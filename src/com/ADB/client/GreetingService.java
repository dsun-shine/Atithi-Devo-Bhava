package com.ADB.client;

import com.ADB.shared.Profile;
import com.ADB.shared.RegisterHost;
import com.ADB.shared.RegisterVisitor;
import com.ADB.shared.Room;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

/**
 * The client-side stub for the RPC service.
 */
@RemoteServiceRelativePath("greet")
public interface GreetingService extends RemoteService {
	Profile[] Search(String city) throws IllegalArgumentException;
	Profile EditProfile(String username) throws IllegalArgumentException;
	Room EditRoom(String username) throws IllegalArgumentException;
	Room showDetails(String user) throws IllegalArgumentException;
	String inserthost(RegisterHost h) throws IllegalArgumentException;
	String insertvis(RegisterVisitor h) throws IllegalArgumentException;
	String LoginVis(String s1,String s2) throws IllegalArgumentException;
	String LoginHost(String s1,String s2) throws IllegalArgumentException;
	String inserthostpro(Profile p) throws IllegalArgumentException;
	String insertroom(Room r1) throws IllegalArgumentException;
	String updatepro(Profile h,String p) throws IllegalArgumentException;
	String updateroom(Room h,String p) throws IllegalArgumentException;
}
