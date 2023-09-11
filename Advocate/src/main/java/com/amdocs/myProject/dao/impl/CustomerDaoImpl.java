package com.amdocs.myProject.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.amdocs.myProject.daoo.CustomerDao;
import com.amdocs.myProject.entity.Customer;
import com.amdocs.myProject.util.DButil;


public class CustomerDaoImpl implements CustomerDao {
		
		
		private static final String INSERT_CUSTOMER="insert into customers (firstname, lastname, phnumber, emailid) values(?,?,?,?)";

		private  Connection connection=DButil.getConnection();
		
		@Override
		public boolean add(Customer customer) throws SQLException {
			PreparedStatement ps=connection.prepareStatement(INSERT_CUSTOMER);
			// Set The value
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getphno());
			ps.setString(4, customer.getEmail());
			
			//ps.setDouble(3, employee.get());
			//Execute Statement
			int executeUpdate = ps.executeUpdate();
			ps.close();
			if(executeUpdate>0) {
				return true;
			}
			return false;
		}

		@Override
		public int update(Customer customer) throws SQLException {
			Connection connection=DButil.getConnection();
			String UPDATE_CUSTOMER="update customers set firstname=?, lastname=?, phnumber=?, emailid=? where id=?";
			PreparedStatement ps=connection.prepareStatement(UPDATE_CUSTOMER);
			// Set The value
			ps.setString(1, customer.getFirstName());
			ps.setString(2, customer.getLastName());
			ps.setString(3, customer.getphno());
			ps.setString(4, customer.getEmail());
			ps.setInt(5, customer.getId());
			//ps.setDouble(3, employee.get());
			//Execute Statement
			int result = ps.executeUpdate();
			ps.close();
			return result;
					
		}

		@Override
		public int delete(Customer customer) throws SQLException {
			Connection connection=DButil.getConnection();
			String DELETE_CUSTOMER="delete from customers where id=?";
			PreparedStatement ps=connection.prepareStatement(DELETE_CUSTOMER);
			// Set The value
			ps.setInt(1, customer.getId());
			//ps.setDouble(3, employee.get());
			//Execute Statement
			int result = ps.executeUpdate();
			ps.close();
			return result;
		}
		//@Override
		//public Customer get(int id) throws SQLException {
			// TODO Auto-generated method stub
		//	return null;
		
        
		@Override
		public int addapp(int custid, int advid) throws SQLException {
			Connection connection=DButil.getConnection();
			String ADD_APPOINTMENT="insert into appointmentsch (custid,advocateid) values (?,?)";
			PreparedStatement ps=connection.prepareStatement(ADD_APPOINTMENT);
			// Set The value
			ps.setInt(1, custid);
			ps.setInt(2, advid);
			//ps.setDouble(3, employee.get());
			//Execute Statement
			int result = ps.executeUpdate();
			ps.close();
			return result;
		}

		@Override
		public int updateapp(int custid, int advid) throws SQLException {
			Connection connection=DButil.getConnection();
			String UPDATE_APPOINTMENT="update appointmentsch set advocateid=? where custid=?";
			PreparedStatement ps=connection.prepareStatement(UPDATE_APPOINTMENT);
			// Set The value
			ps.setInt(1, advid);
			ps.setInt(2, custid);
			//ps.setDouble(3, employee.get());
			//Execute Statement
			int result = ps.executeUpdate();
			ps.close();
			return result;
		}

		@Override
		public int deleteapp(int custid, int advid) throws SQLException {
			Connection connection=DButil.getConnection();
			String DELETE_APPOINTMENT="delete from appointmentsch where custid=? and advocateid=?";
			PreparedStatement ps=connection.prepareStatement(DELETE_APPOINTMENT);
			// Set The value
			ps.setInt(1, custid);
			ps.setInt(2, advid);
			//ps.setDouble(3, employee.get());
			//Execute Statement
			int result = ps.executeUpdate();
			ps.close();
			return result;
		}

		@Override
		public void showdetails(int custid) throws SQLException {
			Connection connection=DButil.getConnection();
			String SHOW_APPOINTMENT="select c.firstname as customer_firstname,"
					+ "c.lastname as customer_lastname,"
					+ "a.firstname as advocate_firstname, a.lastname as advocate_lastname "
					+ "from appointmentsch ap inner join customers c on ap.custid=c.id "
					+ "inner join advocates a on ap.advocateid=a.id where ap.custid=?" ;
			
			 PreparedStatement ps=connection.prepareStatement(SHOW_APPOINTMENT);
			// Set The value
			ps.setInt(1, custid);
			//ps.setInt(2, advid);
			//ps.setDouble(3, employee.get());
			//Execute Statement
			ResultSet result = ps.executeQuery();
			//System.out.println("before !!");
			while(result.next()) {
				//int customerid=result.getInt(custid);
				String customerFirstname= result.getString("customer_firstname");
				String customerLastname= result.getString("customer_lastname");
				String advocateFirstname= result.getString("advocate_firstname");
				String advocateLastname= result.getString("advocate_lastname");
				System.out.println(" Customername:" + customerFirstname
						+" "+ customerLastname + " Advocate:"+advocateFirstname+" "+advocateLastname);
					}
			ps.close();
			
			
		}

		@Override
		public void showAlldetails() throws SQLException {
			Connection connection=DButil.getConnection();
			String SHOW_ALL_APPOINTMENT="select c.id as customer_id,c.firstname as customer_firstname,"
					+ "c.lastname as customer_lastname,"
					+ "a.firstname as advocate_firstname, a.lastname as advocate_lastname "
					+ "from appointmentsch ap inner join customers c on ap.custid=c.id "
					+ "inner join advocates a on ap.advocateid=a.id";
			PreparedStatement ps=connection.prepareStatement(SHOW_ALL_APPOINTMENT);
			// Set The value
			//ps.setInt(1, custid);
			//ps.setInt(2, advid);
			//ps.setDouble(3, employee.get());
			//Execute Statement
			ResultSet result = ps.executeQuery();
			//System.out.println("before !!");
			while(result.next()) {
				//int customerid=result.getInt(custid);
				String customerFirstname= result.getString("customer_firstname");
				String customerLastname= result.getString("customer_lastname");
				String advocateFirstname= result.getString("advocate_firstname");
				String advocateLastname= result.getString("advocate_lastname");
				System.out.println(" Customername:" + customerFirstname
						+" "+ customerLastname + " Advocate:"+advocateFirstname+" "+advocateLastname);
					}
			ps.close();
			
			
			
		}

}

