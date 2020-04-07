<%@page import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor=aqua>

<table border="1" >
<tr bgcolor=pink>
<td>pno</td>
<td>name</td>
<td>Business name</td>
<td>Telephone Number</td>
<td>Address</td>
<td>Category</td>
<td>Single cost</td>
<td>Monthly cost</td>
<td>rating</td>

</tr>


<%
try{
ResultSet rs=null;

Class.forName("com.mysql.jdbc.Driver");

String url=("jdbc:mysql://localhost:3306/dabewala");



Connection con=DriverManager.getConnection(url,"root","user123456");

Statement stmt=con.createStatement();

String qry = "select * from provdetails";

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
<td><%=rs.getString(9)%></td>
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

