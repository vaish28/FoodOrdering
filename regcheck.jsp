<%@page import="java.sql.*"%>
<%@page import="com.DB" %>
<%@page import="javax.swing.JOptionPane" %>
<%@  page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
String username=request.getParameter("username");
String cmp=request.getParameter("cmp");
String tele=request.getParameter("tele");
//int t=Integer.valueOf(tele);
String pwd=request.getParameter("pwd");
String addr=request.getParameter("addr");

Connection con=DB.conc();
String str="pno,'"+username+"','"+cmp+"',"+tele+",'"+addr+"','Veg',34,567,3";
Statement stmt=con.createStatement();
int r=stmt.executeUpdate("insert into provdetails "+"values("+str+")");
if(r!=0)
{
	JOptionPane.showMessageDialog(null,"success");
	response.sendRedirect("index.html");
}
else
{
	JOptionPane.showMessageDialog(null,"failed");
	response.sendRedirect("reg.jsp");
}
%>
</body>
</html>
