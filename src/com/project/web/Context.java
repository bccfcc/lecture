package com.project.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cont")
public class Context extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset:UTF-8");
		PrintWriter out = resp.getWriter();
		
		int x_;
		int y_;
		
		ServletContext application = req.getServletContext();
	
		String x = req.getParameter("x");
		String operator= req.getParameter("operator");
		
		if(operator.equals("=")) {
			if(x != null && !x.equals(" ") && !x.equals("") ) {
				x_ = Integer.parseInt(x);
				y_ = Integer.parseInt((String) application.getAttribute("value"));
				System.out.println(y_);
				
				String op = (String) application.getAttribute("op");
				
				
				if(op.equals("+")) {
					out.println(x_+y_);
				}else if (op.equals("-")) {
					out.println(x_-y_);
				}
			}
			
		}else {
			
			application.setAttribute("value", x);
			application.setAttribute("op", operator);		
		}
		

		System.out.println(x + " "+operator);

	}
}
