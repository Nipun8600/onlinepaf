package com.paf.ShipmentPaf;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;




public class ShipmentRepository 
{
	List<Shipment> shipments;
	
	Connection con = null;
	
	public ShipmentRepository()
	{
		String url = "jdbc:mysql://localhost:3306/pafdb";
		String username = "root";
		String password = "";
		try {
		
			Class.forName("com.mysql.jdbc.Driver");
		con = DriverManager.getConnection(url,username,password);
		
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		
		//shipments = new ArrayList<>();
		
		//Shipment s1 = new Shipment();
		//s1.setShipId(1);
		//s1.setDate("20-May-2019");
		//s1.setDestination("Galle");
		
		//Shipment s2 = new Shipment();
		//s2.setShipId(2);
		//s2.setDate("20-May-2019");
		//s2.setDestination("Gampaha");
		
		//shipments.add(s1);
		//shipments.add(s2);
	}
	
	public List<Shipment> getShipments()
	{
		List<Shipment> shipments = new ArrayList<>();
		String sql = "select * from shipment";
		
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			while(rs.next())
			{
				Shipment s = new Shipment();
				s.setShipId(rs.getInt(1));
				s.setDate(rs.getString(2));
				s.setDestination(rs.getString(3));
				
				shipments.add(s);
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		return shipments;
	}
	

	public Shipment getShipment(int id)
	{
		
		String sql = "select * from shipment where shippingid="+id;
		Shipment s = new Shipment();
		try 
		{
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			if(rs.next())
			{
				
				s.setShipId(rs.getInt(1));
				s.setDate(rs.getString(2));
				s.setDestination(rs.getString(3));
				
				
			}
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		
		return s;
		
		
		
		
		
		
		
		
		
		//for(Shipment s : shipments)
		//{
		//	if(s.getShipId()==id)
		//		return s;
		//}
		
		//return new Shipment();
	}

	public void create(Shipment s1) {
		
		String sql = "insert into shipment values(?,?,?)";
		
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, s1.getShipId());
			st.setString(2, s1.getDate());
			st.setString(3, s1.getDestination());
			st.executeUpdate();
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		
		
		
		// TODO Auto-generated method stub
		//shipments.add(s1);
	}
	
	
public void update(Shipment s1) {
		
		String sql = "update shipment set date=?, destination=? where shippingid=?";
		
		try 
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(3, s1.getShipId());
			st.setString(1, s1.getDate());
			st.setString(2, s1.getDestination());
			st.executeUpdate();
			
		}
		catch(Exception e) 
		{
			System.out.println(e);
		}
		
		
		
		
		// TODO Auto-generated method stub
		//shipments.add(s1);
	}

public void delete(int id) {
	
	String sql = "delete from shipment where shippingid=?";
	
	try 
	{
		PreparedStatement st = con.prepareStatement(sql);
		
		st.setInt(1, id);
		st.executeUpdate();
		
	}
	catch(Exception e) 
	{
		System.out.println(e);
	}
	
	
	
	
	
	
	
	// TODO Auto-generated method stub
	
}
	
}
