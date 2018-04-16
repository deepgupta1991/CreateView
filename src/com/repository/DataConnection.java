package com.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Set;
import java.util.TreeSet;
import com.bean.AddBean;


public class DataConnection {
	
	Connection co=null;
	public DataConnection() {
		// TODO Auto-generated constructor stub
		try {
			Class.forName("com.mysql.jdbc.Driver");
			co=DriverManager.getConnection("jdbc:mysql://awsdemodb.cqbibeemzdez.us-east-2.rds.amazonaws.com:3306/webhostdb","deepdb","mysqlroot");
			
		} catch (ClassNotFoundException e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String AddToDB(AddBean addbean) throws Exception{
		try {
			PreparedStatement ps=co.prepareStatement("insert into stb_details values(?,?,?,?,?)");
			ps.setString(1, addbean.getA1());
			ps.setString(2, addbean.getA2());
			ps.setString(3, addbean.getA3());
			ps.setString(4, addbean.getA4());
			ps.setString(5, addbean.getA5());
			ps.executeUpdate();
			co.commit();
			return "Successful";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Failed";
		}
	}

	public AddBean getSearch(String search) throws Exception{
		// TODO Auto-generated method stub
		AddBean addBean=null;
		try {
			PreparedStatement ps=co.prepareStatement("select * from stb_details where id=?");
			ps.setString(1, search);
			ResultSet rs=ps.executeQuery();
			addBean=new AddBean();
			while(rs.next()){
			addBean.setA1(rs.getString(1));
			addBean.setA2(rs.getString(2));
			addBean.setA3(rs.getString(3));
			addBean.setA4(rs.getString(4));
			addBean.setA5(rs.getString(5));
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return addBean ;
	}
	
	public Set<String> getAjaxSearch(String search){
		Set<String> tree=null;
		try {
			tree=new TreeSet<>();
			co.setAutoCommit(false);
			PreparedStatement ps=co.prepareStatement("Select id from stb_details where id like ? || '%'");
			ps.setString(1,search);
			ResultSet rs=ps.executeQuery();
			while( rs.next() ){
				tree.add(rs.getString(1));
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return tree;
		
	}
	
	

}
