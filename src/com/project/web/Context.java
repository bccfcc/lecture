package com.project.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/cont")
public class Context extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset:UTF-8");
		PrintWriter out = resp.getWriter();
		
		Cookie[] cookies = req.getCookies();
	
		
//		ServletContext application = req.getServletContext();
//		HttpSession session = req.getSession();
	
		String x = req.getParameter("x");
		String operator= req.getParameter("operator");
		
		if(operator.equals("=")) {
			if(x != null && !x.equals(" ") && !x.equals("") ) {
				int x_=0;
				int y_=0;
				String op=null;
		
				
				x_ = Integer.parseInt(x);
				
				for(Cookie c : cookies) {
					if(c.getName().equals("value")) {
						y_=Integer.parseInt(c.getValue());
						break;
					}
				}

//				y_ = Integer.parseInt((String) session.getAttribute("value"));
//				String op = (String) session.getAttribute("op");
				
//				y_ = Integer.parseInt((String) application.getAttribute("value"));
//				String op = (String) application.getAttribute("op");

				System.out.println(y_);
				

				
				for(Cookie c: cookies) {
					if(c.getName().equals("op")) {
						op = c.getValue();
						break;
					}
				}
				
				if(op.equals("+")) {
					out.println(x_+y_);
				}else if (op.equals("-")) {
					out.println(x_-y_);
				}
			}
			
		}else {
			
			Cookie valueCookie = new Cookie("value", String.valueOf(x));
			Cookie opCookie = new Cookie("op", operator);
			resp.addCookie(valueCookie);
			resp.addCookie(opCookie);
			
//			application.setAttribute("value", x);
//			application.setAttribute("op", operator);	
//			
//			session.setAttribute("value", x);
//			session.setAttribute("op", operator);		
		}
		

		System.out.println(x + " "+operator);

	}
}
