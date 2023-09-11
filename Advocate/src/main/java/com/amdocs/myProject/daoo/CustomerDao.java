package com.amdocs.myProject.daoo;
import java.sql.SQLException;

import com.amdocs.myProject.entity.Customer;

public interface CustomerDao {
    boolean add(Customer customer) throws SQLException ;
    int update(Customer customer) throws SQLException;
    int delete(Customer customer) throws SQLException;
    int addapp(int custid, int advid) throws SQLException;
    int updateapp(int custid, int advid) throws SQLException;
    int deleteapp(int custid, int advid) throws SQLException;
    //Customer get(int id) throws SQLException;
	void showdetails(int custid) throws SQLException;
	void showAlldetails() throws SQLException;
    
}
