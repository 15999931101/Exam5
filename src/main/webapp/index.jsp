<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="bootstrap.min.css" type="text/css" rel="stylesheet">
<script src="bootstrap.min.js"></script>
<script src="jquery-2.1.1.min.js"></script>
<link href="style1.css" type="text/css" rel="stylesheet">
</head>
<body>


	<%
		String flag = "";
		Object obj = session.getAttribute("flag");
		if (obj != null) {
			flag = obj.toString();
		}
		if (flag.equals("login_success")) {
	%>
	<%-- <%-- <a href="<%=request.getContextPath()%>/LogoutServlet">退出</a><br/><br/> --%>
	


	<%
		} else {
	%>
	<%-- <a href="<%=request.getContextPath()%>/login.jsp">登录</a><br/><!--  --><br/> --%>
	<%
		}
	%>
	<div class="container">
		<div class="header">
			<h1>8837</h1>
		</div>

		<div style="float: left; width: 30%;">
			<div class="btn-group">
				<button type="button" class="btn btn-info ">Customer管理</button>
				<button type="button" class="btn btn-info dropdown-toggle"
					data-toggle="dropdown">
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="customer.jsp">customer管理</a></li>

				</ul>
			</div>
			<div class="btn-group">
				<button type="button" class="btn btn-info ">Film管理</button>
				<button type="button" class="btn btn-info dropdown-toggle"
					data-toggle="dropdown">
					<span class="caret"></span>
				</button>
				<ul class="dropdown-menu" role="menu">
					<li><a href="Film.jsp">customer管理</a></li>

				</ul>
			</div>
		</div>


	</div>
</body>
</html>
