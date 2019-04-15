package cn.lxtkj.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.lxtkj.service.StuInfoService;

public class QueryAllStuServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public QueryAllStuServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String osid = request.getParameter("osid");
		List stus = new StuInfoService().queryAllStu();
		HttpSession session = request.getSession();
		session.setAttribute("stus", stus);
		if (osid.equals("query"))
			response.sendRedirect("../displaystuinfo.jsp");
		else if (osid.equals("modify"))
			response.sendRedirect("../modifystuinfo.jsp");
		else
			response.sendRedirect("../deletestuinfo.jsp");
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
