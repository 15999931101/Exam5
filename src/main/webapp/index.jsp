<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>主页面</title>
<link href="bootstrap.min.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="jquery-2.1.1.min.js"></script>
<script type="text/javascript" src="bootstrap.min.js"></script>
<link href="style1.css" type="text/css" rel="stylesheet">
<script type="text/javascript" src="my.js"></script>
</head>
<body>


	
	<div class="container" style="">
		<div  class="header" style="padding:0px;font-style: normal ;color:#473299;height: 60px;position:relative;">
			<div style="position: absolute;left:10px;"><h1 >8837 林立鹏</h1></div>
			<div style="position: absolute;right:10px;">
			<%
		String flag = "";
		Object obj = session.getAttribute("flag");
		if (obj != null) {
			flag = obj.toString();
		}
		if (flag.equals("login_success")) {
	%>
	<a href="<%=request.getContextPath()%>/LogoutServlet">退出</a><br/><br/>



	<%
		} else {
	%>
	<a href="<%=request.getContextPath()%>/login.jsp">登录</a><br/><!--  --><br/>
	<%
		}
	%>
			</div> 
		</div>
		
		<div class="content" >
			<div class="col-sm-2" id="left1">
				<div class="btn-group" >
					<button type="button" class="btn btn-default  btn-sm ">Customer管理</button>
					<button type="button" class="btn btn-default  btn-sm dropdown-toggle"
						data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="customer.jsp">customer管理</a></li>
					</ul>
				</div>
				<br>

				<div class="btn-group" id="left2">
					<button type="button" class="btn btn-default btn-sm ">F i l m管理</button>
					<button type="button" class="btn btn-default btn-sm dropdown-toggle"
						data-toggle="dropdown">
						<span class="caret"></span>
					</button>
					<ul class="dropdown-menu" role="menu">
						<li><a href="customer.jsp">Film</a></li>
					</ul>
				</div>
			</div>

			<div style=" border-left: 1px solid gray; "  class="col-sm-10" id="right">
			
		
			</div>

		</div>
	</div>

	
</body>
</html>
