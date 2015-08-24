package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hand.dao.CustomerDao;
import com.hand.dao.Imp.CustomerDaoImp;
import com.hand.dao.Imp.GetConnetion;
import com.hand.entity.Customer;
import java.util.Date;


/**
 * Servlet implementation class AddServlet
 */
public class AddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;       
	private CustomerDao csDao = new CustomerDaoImp();
	
    public AddServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("========doPost执行========");
		System.out.println();
		int store_id=1;
		int active=1;
		
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String create_date=format.format(date); 
		
		
		String first_name = req.getParameter("first_name");		
		String last_name = req.getParameter("last_name");
        String address = req.getParameter("address");
        String email =req.getParameter("email");
        String last_update =req.getParameter("last_update");	
        System.out.println(first_name);
        Connection conn = null;

    	conn = GetConnetion.getConnection();
    	String sql = "select address_id from address where address=address";
    	ResultSet rs = null;
		int address_id = 0;
		try {
			PreparedStatement ps1 = conn.prepareCall(sql);
			rs = ps1.executeQuery(sql); 
			while(rs.next()){
				address_id = (int) rs.getLong("address_id");
			}

			
			System.out.println(address_id);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
		Customer cst = new Customer();
	    cst.setAddress(address);
	
	    cst.setEmail(email);
	    cst.setFirst_name(first_name);
	    cst.setLast_name(last_name);
	    cst.setLastUpdatetime(last_update);	   
	    cst.setActive(active);
	    cst.setCreate_date(create_date);
	    cst.setStore_id(store_id);
	    cst.setAddress_id(address_id);
		
	
//		Connection conn =GetConnetion.getConnection();
		try {   			
			csDao.save(conn, cst);
			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
		try {
			rs.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}	

}
