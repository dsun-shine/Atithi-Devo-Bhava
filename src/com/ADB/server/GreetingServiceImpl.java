package com.ADB.server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.ADB.client.GreetingService;
import com.ADB.shared.Profile;
import com.ADB.shared.RegisterHost;
import com.ADB.shared.RegisterVisitor;
import com.ADB.shared.Room;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

/**
 * The server-side implementation of the RPC service.
 */
public class GreetingServiceImpl extends RemoteServiceServlet implements GreetingService {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
    Profile p[]=new Profile[10];
    Room r=null;
    int i;
    String ss="NO";
	public void init() {

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/atithidevobhava?autoReconnect=true&useSSL=false", "root",
					"1234");
			

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Profile[] Search(String city) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		try {
			st = con.prepareStatement("select * from HostPro where city=?");
			st.setString(1, city);
			rs = st.executeQuery();
			i=0;
			   while(rs.next()) {
				p[i]=new Profile();
				p[i].setName(rs.getString("name"));
				p[i].setAdhar(rs.getString("adhar"));
				p[i].setMobile(rs.getString("mobile"));
				p[i].setCity(rs.getString("city"));
				p[i].setAddress(rs.getString("address"));
				p[i].setUsername(rs.getString("username"));
				i++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println(e.getMessage());
		}
		return p;
	}
	@Override
	public Profile EditProfile(String username) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Profile q=new Profile();
		init();
		try {
			st = con.prepareStatement("select * from HostPro where username=?");
			st.setString(1, username);
			rs = st.executeQuery();
			   if(rs.next()) {
				q.setName(rs.getString("name"));
				q.setAdhar(rs.getString("adhar"));
				q.setMobile(rs.getString("mobile"));
				q.setCity(rs.getString("city"));
				q.setAddress(rs.getString("address"));
				q.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println(e.getMessage());
		}
		return q;
	}

	@Override
	public String inserthost(RegisterHost h) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		int k=0;
		try {
			st=con.prepareStatement("insert into RegHost values(?,?,?,?,?)");
			st.setString(1, h.getName());
			st.setString(2, h.getUname());
			st.setString(3, h.getPass());
			st.setString(4, h.getEid());
			st.setString(5, h.getMobile());
			k=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(k!=0)
			ss="OK";
		return ss;
	}

	@Override
	public Room showDetails(String user) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		try {
			st=con.prepareStatement("select * from room where username=?");
			st.setString(1, user);
			rs=st.executeQuery();
			if(rs.next())
			{
				r=new Room();
				r.setBed(rs.getString("bed"));
				r.setService(rs.getString("service"));
				r.setWifi(rs.getString("wifi"));
				r.setPrice(rs.getString("price"));
				r.setAC(rs.getString("AC"));
				r.setPerson(rs.getString("person"));
				r.setUsername(rs.getString("username"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return r;
	}

	@Override
	public String insertvis(RegisterVisitor h) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		int k=0;
		try {
			System.out.println("Dolly");
			st=con.prepareStatement("insert into regVis values(?,?,?,?)");
			st.setString(1, h.getName());
			st.setString(2, h.getUname());
			st.setString(3, h.getPass());
			st.setString(4, h.getEid());
			k=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(k!=0)
			ss="OK";
		return ss;
	}

	@Override
	public String LoginVis(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		try {
			st=con.prepareStatement("select * from regvis where uname=? and pass=?");
			st.setString(1, s1);
			st.setString(2, s2);
			rs=st.executeQuery();
			if (rs.next()) {
				ss = "Yes";
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return ss;

	}

	@Override
	public String inserthostpro(Profile p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		int k=0;
		try {
			System.out.println("Dolly");
			st=con.prepareStatement("insert into HostPro values(?,?,?,?,?,?)");
			st.setString(1, p.getName());
			st.setString(2, p.getUsername());
			st.setString(3, p.getMobile());
			st.setString(4, p.getAdhar());
			st.setString(5, p.getAddress());
			st.setString(6, p.getCity());
			k=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(k!=0)
			ss="OK";
		return ss;
	}

	@Override
	public String LoginHost(String s1, String s2) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		try {
			st=con.prepareStatement("select * from reghost where uname=? and pass=?");
			st.setString(1, s1);
			st.setString(2, s2);
			rs=st.executeQuery();
			if (rs.next()) {
				ss = "Yes";
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return ss;
	}

	@Override
	public String insertroom(Room r1) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		int k=0;
		try {
			System.out.println("Dolly");
			st=con.prepareStatement("insert into room values(?,?,?,?,?,?,?)");
			st.setString(1, r1.getBed());
			st.setString(2, r1.getService());
			st.setString(3, r1.getWifi());
			st.setString(4, r1.getPrice());
			st.setString(5, r1.getAC());
			st.setString(6, r1.getPerson());
			st.setString(7, r1.getUsername());
			k=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(k!=0)
			ss="OK";
		return ss;
	}

	@Override
	public String updatepro(Profile h, String p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		int k=0;
		try {
			System.out.println("Dolly");
			st=con.prepareStatement("update HostPro set name=?,username=?,mobile=?,adhar=?,address=?,city=? where username=?");
			st.setString(1, h.getName());
			st.setString(2, h.getUsername());
			st.setString(3, h.getMobile());
			st.setString(4, h.getAdhar());
			st.setString(5, h.getAddress());
			st.setString(6, h.getCity());
			st.setString(7, p);
			k=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(k!=0)
			ss="OK";
		return ss;
	}

	@Override
	public Room EditRoom(String username) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		Room q=new Room();
		init();
		try {
			st = con.prepareStatement("select * from Room where username=?");
			st.setString(1, username);
			rs = st.executeQuery();
			   if(rs.next()) {
				q.setPrice(rs.getString("price"));
				q.setPerson(rs.getString("person"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

			System.out.println(e.getMessage());
		}
		return q;
	}

	@Override
	public String updateroom(Room h, String p) throws IllegalArgumentException {
		// TODO Auto-generated method stub
		init();
		int k=0;
		try {
			System.out.println("Dolly");
			st=con.prepareStatement("update Room set bed=?,service=?,wifi=?,price=?,AC=?,person=? where username=?");
			st.setString(1, h.getBed());
			st.setString(2, h.getService());
			st.setString(3, h.getWifi());
			st.setString(4, h.getPrice());
			st.setString(5, h.getAC());
			st.setString(6, h.getPerson());
			st.setString(7, p);
			k=st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(k!=0)
			ss="OK";
		return ss;
	}

}
