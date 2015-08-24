<%@page import="java.sql.SQLException"%>
<%@page import="com.hand.dao.Imp.GetConnetion"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>customer客户管理 </title>
 <link href="bootstrap.min.css" rel="stylesheet" type="text/css">
    <script src="jquery-2.1.1.min.js"></script>
    <script src="bootstrap.min.js"></script>
    <link href="mycss.css" rel="stylesheet" type="text/css">
    <script type="text/javascript" src="my.js"></script>
</head>
<body>
<%
		Connection conn;
		conn = GetConnetion.getConnection();
	    /* String sql="select   c.first_name,c.last_name,a.address,c.email,c.customer_id,c.last_update FROM customer c, address a WHERE 
	    		c.address_id=a.address_id "; */  
      String sql ="select c.customer_id,c.first_name,a.address,c.last_name , c.email, c.last_update from customer c, address a WHERE "
      +"c.address_id = a.address_id ORDER BY customer_id  DESC LIMIT 12  ";	
		PreparedStatement ps1 = conn.prepareCall(sql);
		ResultSet rs = ps1.executeQuery(sql);//执行sql语句
	%>
<div class="container1">

   <div class="content">
   <div><pre> <span>客户管理</span>                     <a href="addCustomer.jsp" id="add" style="font-size: 18px;">新建</a></pre></div>
 
   <hr>
   <div>
      <table style="boder:2px solid">
      <%
			if (request.getAttribute("return_uri") != null) {
		%>
		<input type="hidden" name="return_uri"
			value="<%=request.getAttribute("return_uri")%>">
		<%
			}
		%>
		<tr>
			<td colspan="7" align="left" >客户列表</td>
		</tr>
		<tr>
		    <td>操作</td>
			<td>First Name</td>
			<td>Last Name</td>
			<td>Address</td>
			<td>Email</td>
			<td>Customer_id</td>
			<td>LastUpdate</td>
		</tr>

		<%
			while (rs.next()) {
		%>
		<tr>
		    <td><a id="modify" href="updateCustomer.jsp?customer_id=<%=rs.getLong(1)%>&first_name=<%=rs.getString("first_name")%>&last_name=<%=rs.getString("last_name")%>
			&email=<%=rs.getString("email")%>&address=<%=rs.getString("address")%>&last_update=<%=rs.getString("last_update")%> ">编辑</a>
			<a id="delte"href="<%=request.getContextPath()%>/deleteServlet?customer_id=<%=rs.getLong("customer_id")%> ">删除</a>
			</td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(5)%></td>
			<td><%=rs.getString(4)%></td>
			<td><%=rs.getLong(1)%></td>
			<td><%=rs.getString(6)%></td>
			
		</tr>

		<%
			}
		%>
		<%
		try{
			if(rs!=null)
				rs.close();
			if(conn!=null)
				conn.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		%>


	</table>
</div>
</div>

</div>  

</body>
</html>