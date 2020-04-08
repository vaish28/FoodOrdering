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

	String day=request.getParameter("day");
	request.setAttribute("day",day);	
String gravy=request.getParameter("gravy name");
	String dry_veg=request.getParameter("dry_veg name");
	String chapati=request.getParameter("Chapati name");
	String sides=request.getParameter("Sides name");
	String rice=request.getParameter("Rice name");
	String special=request.getParameter("Special name");
	JOptionPane.showMessageDialog(null,"Done!");
%>




</body>
</html>