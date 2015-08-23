package com.hand.dao.Imp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.hand.dao.UserDao;
import com.hand.entity.User;


public class UserDaoImp implements UserDao {
    

	public ResultSet get(Connection conn, User user) throws SQLException {
		
		PreparedStatement ps = conn.prepareStatement("select * from customer where first_name=? ");
		
		ps.setString(1, user.getName());
	
		return ps.executeQuery();
		
	}
}
