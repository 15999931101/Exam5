package com.hand.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.hand.dao.CustomerDao;
import com.hand.dao.Imp.CustomerDaoImp;
import com.hand.dao.Imp.GetConnetion;
import com.hand.entity.Customer;


/**
 * Servlet implementation class updateServlet
 */
public class updateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	private CustomerDao csDao = new CustomerDaoImp();
	
    public updateServlet() {
        super();
    
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("========doPost执行========");
		System.out.println();
		
		int customer_id = Integer.parseInt(req.getParameter("customer_id"));
		String first_name = req.getParameter("first_name");
		String last_name = req.getParameter("last_name");
        String address = req.getParameter("address");
        String email =req.getParameter("email");
        String last_update =req.getParameter("last_update");
        
        
		
		
		
		
	
		Customer cst = new Customer();
	    cst.setAddress(address);
	    cst.setCustomer_id(customer_id);
	    cst.setEmail(email);
	    cst.setFirst_name(first_name);
	    cst.setLast_name(last_name);
	    cst.setLastUpdatetime(last_update);	        
		
	
		Connection conn =GetConnetion.getConnection();
		try {   
			
			csDao.update(conn, cst);

			
		} catch (SQLException e) {
		
			e.printStackTrace();
		}
		
		req.getRequestDispatcher("index.jsp").forward(req, resp);
	}	
	
}
