 <%@page import="java.sql.*" %>
<%@page import="com.DB" %>


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">



<html> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">



  

<head> 

    <title> 

         Menu and Quantity 

    </title> 

</head> 

  

<body> 



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

Connection con=DB.conc();

Statement stmt=con.createStatement();
HttpSession sess = request.getSession(false);

int pno=Integer.parseInt(sess.getAttribute("pno").toString());
String qry = "select * from menu where pno="+pno;

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



	<p>

		

		Enter the quantity of tiffin

	</p>

	<form name="frmQ" action="quantitycheck.jsp">

		<label for="quantity">Quantity:</label>

		<input type="text" name="quantity"><br>

		<br>

		<input type="radio" name="tiffin" value="Single Tiffin">Single Tiffin



    <input type="radio" name="tiffin" value="Monthly Tiffin">Monthly Tiffin

    <button type="submit">PLACE ORDER</button>

    

	</form>

	  

    <br> 

     



  </body> 

</html>