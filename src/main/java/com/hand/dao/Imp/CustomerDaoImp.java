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
		
		
		
		String insertSql = "insert into film(title,description,language_id,"
				+ "rental_duration,rental_rate,replacement_cost,last_update) values(?,?,?,?,?,?,?)";
		PreparedStatement ps = conn.prepareStatement(insertSql);	
		
	
		ps.execute();
		System.out.println("添加成功");
		
	}

	public void update(Connection conn, Customer cst) throws SQLException {
//		System.out.println(film.getLanguage());
//		String rental_duration="6";
//		String rental_rate="1.00";
//		String replacement_cost="20.00";
//		String last_update="2015-8-16 ";
		
		String insertSql = "update film set title=?,description=?,language_id=? where film_id = ?";
		PreparedStatement ps = conn.prepareStatement(insertSql);	
		
		ps.setString(1, cst.getAddress());
		

			
		ps.execute();
		System.out.println("更新成功");
		
	}

	public void delete(Connection conn, Customer cs) throws SQLException {
		String insertSql = "delete from film where customer_id=?";
		PreparedStatement ps = conn.prepareStatement(insertSql);	
		
		ps.setLong(1,cs.getCustomer_id());			
		ps.execute();
		System.out.println("删除成功");
		
		
	}

	



}
