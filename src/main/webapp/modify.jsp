<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import ="java.sql.DriverManager" %>
<%@page import ="java.sql.PreparedStatement" %>
<%@page import ="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<form action="<%=request.getContextPath()%>/updateServlet" method="post">
		<table border="1" cellpadding="5" cellspacing="0" bgcolor="silver"
			align="center" width="500">
			<tr>
			<td colspan="4" align="center" bgcolor="#E7899"><a href="index.jsp">返回主页面</a></td>
		   </tr>
		   
			<tr>
				<td colspan="2" align="center" bgcolor="#E7899">更新电影表记录</td>
			</tr>
			<tr style="">
				<td>film_id</td>
				<td width="300"><input type="text" name="film_id" value="<%=request.getParameter("film_id") %>"></td>
			</tr>
			<tr>
				<td>title</td>
				<td width="300"><input type="text" name="title" value="<%=request.getParameter("title") %>"></td>
			</tr>
			<tr>
				<td>description</td>
				<td width="300"><input type="text" name="description" value="<%=request.getParameter("description") %>"></td>
			</tr>
			<tr >
				<td>language</td>
				<td width="300"><input type="text" name="language" value="<%=request.getParameter("language") %>"></td>
				
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" name="添加">
					<input type="reset" name="重置"></td>
			</tr>

		</table>


	</form>
</body>
</html>