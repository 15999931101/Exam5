package com.hand.dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.CustomerDao;
import com.hand.dao.FilmDao;
import com.hand.entity.Customer;
import com.hand.entity.Film;



public class CustomerDaoImp implements CustomerDao {
    

	public ResultSet get(Connection conn) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("SELECT f.film_id,f.title,f.description,l.name  FROM  film f,LANGUAGE l  WHERE f.language_id=l.language_id ");

	 
		return ps.executeQuery();
		
	}

	public void save(Connection conn, Customer cst) throws SQLException {
		
		
		
		String insertSql = "insert into customer(store_id,first_name,last_name,"
				+ "email,address_id,active,create_date,last_update) values(?,?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insertSql);	
		ps.setLong(1, cst.getStore_id());
		ps.setString(2, cst.getFirst_name());
		ps.setString(3, cst.getLast_name());
		ps.setString(4,cst.getEmail());
		ps.setLong(5,cst.getAddress_id());
		ps.setLong(6,cst.getActive());
		ps.setString(7,cst.getCreate_date());
		ps.setString(8,cst.getLastUpdatetime());
	
		ps.execute();
		System.out.println("添加成功");
		if( ps != null) 
	        ps.close(); 		
	    if(conn!= null) 
	        conn.close(); 
		
	}

	public void update(Connection conn, Customer cst) throws SQLException {
//		System.out.println(film.getLanguage());
//		String rental_duration="6";
//		String rental_rate="1.00";
//		String replacement_cost="20.00";
//		String last_update="2015-8-16 ";
		System.out.println(cst.getStore_id()+"\t"+cst.getFirst_name()+"\t"+cst.getCustomer_id()+cst.getCreate_date()+"\t"+cst.getLastUpdatetime());
//		String insertSql = "update customer set store_id=?,first_name=?,last_name=?,"
//				+ "email=?,address_id=？,active=?,create_date=?,last_update=? where customer_id="+cst.getCustomer_id();
	    String sql="UPDATE customer SET store_id=?,first_name=?,last_name=?,email=?,address_id=?,active=?,create_date=?,last_update=? WHERE customer_id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);	
		
		ps.setLong(1, cst.getStore_id());
		ps.setString(2,cst.getFirst_name());
		ps.setString(3, cst.getLast_name());
		ps.setString(4,cst.getEmail());
		ps.setLong(5,cst.getAddress_id());
		ps.setLong(6,cst.getActive());
		ps.setString(7,cst.getCreate_date());
		ps.setString(8,cst.getLastUpdatetime());	
	    ps.setLong(9, cst.getCustomer_id());
		ps.execute();
		System.out.println("更新成功");
		if( ps != null) 
	        ps.close(); 		
	    if(conn!= null) 
	     conn.close(); 
		
	}

	public void delete(Connection conn, Customer cs) throws SQLException {
		
			System.out.println("删除成功");
		String sql = "DELETE FROM payment WHERE customer_id=?";
		PreparedStatement preparedStatement = conn.prepareCall(sql);
		preparedStatement.setInt(1, cs.getCustomer_id());
		preparedStatement.execute();
		sql = "DELETE FROM rental WHERE customer_id=?";
		preparedStatement = conn.prepareCall(sql);
		preparedStatement.setInt(1, cs.getCustomer_id());
		preparedStatement.execute();
		sql = "DELETE FROM customer WHERE customer_id=?";
		preparedStatement = conn.prepareCall(sql);
		preparedStatement.setInt(1, cs.getCustomer_id());
		preparedStatement.execute();
		preparedStatement.close();
		
	}

	



}
