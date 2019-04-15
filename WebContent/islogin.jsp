<%@page import="cn.lxtkj.model.UserTable" %>
<%@page import="cn.lxtkj.service.UserService" %>
<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
UserTable user =(UserTable) session.getAttribute("user");
if(user==null){
%>
	<jsp:forward page="index.jsp"></jsp:forward>
<% }
%>
