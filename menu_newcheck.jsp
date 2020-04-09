<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%

	String day=request.getParameter("day")	
String gravy=request.getParameter("gravy");
	String dry_veg=request.getParameter("dryveg");
	String chapati=request.getParameter("chapati");
	String sides=request.getParameter("sides");
	String rice=request.getParameter("rice");
	String special=request.getParameter("special");
	JOptionPane.showMessageDialog(null,"Done!");
%>




</body>
</html>
