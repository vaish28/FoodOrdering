<%@page import="java.sql.*"%>
<%@page import="com.DB" %>
<%@page import="javax.swing.JOptionPane" %>
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

	String tele=request.getParameter("tele");
	Connection con=DB.conc();
	String str="select pno from  provdetails where telno="+tele;
	ResultSet rs=null;
	Statement stmt=con.createStatement();
	rs=stmt.executeQuery(str);
	
	if(rs.next()!=false)
	{
		JOptionPane.showMessageDialog(null,"success");
		response.sendRedirect("index.html");
	}
	
	else
	{
		rs.beforeFirst();
		JOptionPane.showMessageDialog(null,"failed");
		response.sendRedirect("reg.jsp");
	}
		
%>
</body>
</html>