<%@page import="cn.lxtkj.model.StuInfo"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<jsp:include page="islogin.jsp"></jsp:include>
<body>
	<%
		List stus = (List) session.getAttribute("stus");
		// out.print(stus.size());  
		Iterator iter = stus.iterator();
	%>
	<table>
		<tr>
			<td>id</td>
			<td>昵称</td>
			<td>真实姓名</td>
			<td>性别</td>
			<td>出生日期</td>
			<td>所在专业</td>
			<td>所选课程</td>
			<td>兴趣</td>
			<td>备注</td>
			<td></td>
		</tr>
		<%
			int i = 0;
			while (iter.hasNext()) {
				StuInfo student = (StuInfo) iter.next();
		%>
		<tr <%if (i % 2 == 0) {%> bgcolor="#F0F8FF" <%}%>>
			<td><%=student.getId()%></td>
			<td><%=student.getNicheng()%></td>
			<td><%=student.getTruename()%></td>
			<td>
				<%
					if (student.getXb() == 1)
							out.print("男");
						else
							out.print("女");
				%>
			</td>
			<td><%=student.getCsrq()%></td>
			<td><%=student.getZy()%></td>
			<td><%=student.getKcs()%></td>
			<td><%=student.getXqs()%></td>
			<td><%=student.getBz()%></td>
			<td><a href="student/DeleteStuServlet?id=<%=student.getId()%>">删除</a></td>
		</tr>
		<%
			i++;
			}
		%>

	</table>
</body>
</html>