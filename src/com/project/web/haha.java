package com.project.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/hello")
public class haha extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setCharacterEncoding("UTF-8");
		resp.setContentType("text/html; charset:UTF-8");
		PrintWriter out = resp.getWriter();
		
		int cnt;
		String cnt_ = req.getParameter("cnt");
		
		if(null != cnt_ && !cnt_.equals("") &&  !cnt_.equals("0")) {
			cnt= Integer.parseInt(req.getParameter("cnt"));
			for(int i =0; i<cnt;i++) {
				out.println(i+ " : ¾È³ç <br>");
			}
		}else {
			out.println(" : ¾øÀ½ <br>");
		}
		
	}

}
