package cn.lxtkj.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.lxtkj.model.StuInfo;
import cn.lxtkj.service.StuInfoService;

/**
 * Servlet implementation class InputStuInfoServlet
 */
@WebServlet("/InputStuInfoServlet")
public class InputStuInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InputStuInfoServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String nicheng=request.getParameter("nicheng");
		String truename=request.getParameter("truename");
		Byte xb=Byte.parseByte(request.getParameter("xb"));
		String csrq=request.getParameter("csrq");
		String zy=request.getParameter("zy");
		String kcs[]=request.getParameterValues("kc");
		String xqs[]=request.getParameterValues("xq");
		String bz=request.getParameter("bz");
		StuInfo stu = new StuInfo();
		stu.setNicheng(nicheng);
		stu.setTruename(truename);
		stu.setCsrq(csrq);
		if(csrq.equals(""))
			stu.setCsrq(null);
		if(kcs!=null)
		stu.setKc(kcs);
		if(xqs!=null)
		stu.setXq(xqs);
		stu.setBz(bz);
		stu.setZy(zy);
		stu.setXb(xb);
		if(new StuInfoService().addStu(stu)) {
			response.sendRedirect("../inputStuInfo_success.jsp");
		}else {
			response.sendRedirect("../inputStuInfo.jsp");
		}
		
	}

}
