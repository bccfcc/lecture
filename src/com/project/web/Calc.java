package com.project.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/calc")
public class Calc extends HttpServlet {
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset=UTF-8");
		int x_;
		int y_;
		PrintWriter out = resp.getWriter();
		String x = req.getParameter("x");
		String y = req.getParameter("y");
		String operator= req.getParameter("operator");
		
		System.out.println(x +" "+y  + " "+operator);
		
		if(x != null && !x.equals(" ") && !x.equals("") && y !=null && !y.equals(" ") && !y.equals("") ) {
			x_ = Integer.parseInt(x);
			y_ = Integer.parseInt(y);
			
			if(operator.equals("µ¡¼À")) {
				out.println(x_ + y_);
			}else {
				out.println(x_ - y_);
			}
			
			
		}else {
			out.println(".°è»êºÒ°¡");
		}
		

	}

}
