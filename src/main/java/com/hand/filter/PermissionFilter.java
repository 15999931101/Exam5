package com.hand.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 	FileName: LoginFilter.java
 *	desc: 一个用于执行登陆验证的过滤器.
 *	Date: 2015/01/21
 *	Copyright: www.jikexueyuan.com
 *	MyBlog: blog.darkmi.com
 *  @author darkmi
 *
 */
public class PermissionFilter implements Filter {

	public void init(FilterConfig filterConfig) throws ServletException {
	System.out.println("============Permission拦截器==========");
	
	}

	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("权限校验过滤器 { ");
		// 将ServletRequest转换为HttpServletRequest      
		HttpServletRequest request = (HttpServletRequest) servletRequest;
		HttpServletResponse response = (HttpServletResponse) servletResponse;
		//getServletPath():不仅可以获取servlet的名字还可以获取到向servlet提交url
		String servletPath = request.getServletPath();
		System.out.println("Servlet Path ==> " + servletPath);

		// 获取HttpSession中的信息   
		HttpSession session = request.getSession();
		String flag = (String) session.getAttribute("flag");
		System.out.println(flag);

		//权限校验
		if (servletPath != null
				&& (servletPath.equals("/login.jsp") || servletPath.equals("/LoginServlet") || servletPath
						.equals("/index.jsp"))) {
			chain.doFilter(servletRequest, servletResponse);
		} else {
			//访问非登录页面时
			if (flag != null && flag.equals("login_success")) {
				chain.doFilter(servletRequest, servletResponse);
			} else if (flag != null && flag.equals("login_error")) {
				request.setAttribute("msg", "登陆失败，请重新登录!<br/>");
				request.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg", "您尚未登陆！<br/>");
				request.setAttribute("return_uri", servletPath);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.forward(request, response);
			}
		}
		System.out.println("权限校验过滤器 } ");
	}


	public void destroy() {
	}

}
