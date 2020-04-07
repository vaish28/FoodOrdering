<%@page import="java.sql.*" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor=aqua>

<table border="1" >
<tr bgcolor=pink>
<td>pno</td>
<td>day</td>
<td>gravy</td>
<td>dryveg</td>
<td>chapati</td>
<td>sides</td>
<td>rice</td>
<td>special</td>
</tr>

<%
try{
ResultSet rs=null;

Class.forName("com.mysql.jdbc.Driver");

String url=("jdbc:mysql://localhost:3306/dabewa1");



Connection con=DriverManager.getConnection(url,"root","user123456");

Statement stmt=con.createStatement();

String qry = "select * from menu";

rs = stmt.executeQuery(qry);

while(rs.next())
{
%>
<tr bgcolor=pink>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3)%></td>
<td><%=rs.getString(4)%></td>
<td><%=rs.getString(5)%></td>
<td><%=rs.getString(6)%></td>

<td><%=rs.getString(7)%></td>
<td><%=rs.getString(8)%></td>
</tr>

<%
}


}
catch(Exception ex)
{
System.out.println(ex);

}


%>

</table>
</body>
</html>