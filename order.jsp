<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order</title>
</head>
<body>
<center>
	<h2><center>Pending Orders</h2>
<table border="1" align="center">
<tr bgcolor="green">
<th><h4>provider number</h4></th>
<th><h4>Customer id</h4></th>
<th><h4>Customer Name</h4></th>
</tr>

<% 
	HttpSession sess=request.getSession(false);
	int provno = Integer.parseInt(sess.getAttribute("pno1").toString());
	Connection con=DB.conc();
	String str="select * from provcust where pno="+provno;
	ResultSet rs=null;
	Statement stmt=con.createStatement();
	rs=stmt.executeQuery(str);
	while(rs.next())
	{
		int regno=rs.getInt(1);
		int pno=rs.getInt(2);
		String name=rs.getString(3);
	%>
	
	<tr>
	<td>pno</td>
	<td>regno</td>
	<td>name</td>
	</tr>
	<%
	}
%>
	</center>
</table>
<form name="disp" action="ordercheck.jsp">
<button  style="background-color: green;color: white;width: 200px;height: 50px">Dispatched Order</button><br><br>
</form>
		
</body>
</html>
