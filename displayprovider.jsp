<%@page import="java.sql.*"%>
<%@page import="com.DB" %>

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
<td>business</td>


</tr>


<%
try{
ResultSet rs=null;
Connection con=DB.conc();
Statement stmt=con.createStatement();
String qry = "select pno,name,business from provdetails";
rs = stmt.executeQuery(qry);
while(rs.next())
{
%>
<tr bgcolor=pink>
<td><%=rs.getString(1)%></td>
<td><%=rs.getString(2)%></td>
<td><%=rs.getString(3) %></td>
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
  
  
  <p>Enter pno for the provider selection</p>
	<form name="frmQ" action="displayprovidercheck.jsp">
		<input type="text" name="pno1">
		<button type="submit">Select provider number</button>

	</form>

</body>
</html>