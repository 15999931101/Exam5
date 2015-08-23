<%@page import="com.hand.dao.Imp.GetConnetion"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		Connection conn;
		conn = GetConnetion.getConnection();
		String sql = "SELECT f.film_id,f.title,f.description,l.name  FROM  film f,LANGUAGE l  WHERE f.language_id=l.language_id";
		PreparedStatement ps1 = conn.prepareCall(sql);
		ResultSet rs = ps1.executeQuery(sql);//执行sql语句
	%>
	<table>
		<tr>
			<td colspan="4" align="center" bgcolor="#E7899"><a
				href="index.jsp">返回主页面</a></td>
		</tr>
		<tr>
			<td>film_id</td>
			<td>film</td>
			<td>description</td>
			<td>language</td>
		</tr>

		<%
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getLong(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getString(4)%></td>
			<td><a
				href="modify.jsp?film_id=<%=rs.getLong(1)%>&title=<%=rs.getString(2)%>&description=<%=rs.getString(3)%>
			&language=<%=rs.getString(4)%> ">修改</a></td>
		</tr>

		<%
			}
		%>


	</table>

</body>
</html>