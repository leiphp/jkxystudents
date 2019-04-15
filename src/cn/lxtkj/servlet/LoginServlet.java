package cn.lxtkj.servlet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lxtkj.model.UserTable;
import cn.lxtkj.service.UserService;

public class LoginServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) {

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserTable user = new UserTable();
		user.setUsername(username);
		user.setPassword(password);

		try {
			if (new UserService().valiUser(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				response.sendRedirect("../main.jsp");
			}else {
				response.sendRedirect("../index.jsp");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void doGet(HttpServletRequest request, HttpServletResponse response){
		doPost(request,response);
	}
}
