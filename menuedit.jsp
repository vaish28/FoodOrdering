<%@page import="java.sql.*" %>
<%@page import="com.DB" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>

<body bgcolor=aqua>

<table border="1" id="table">
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
<form action="menueditcheck.jsp">
<div class="tab-2" align="center">
pno<input type="text" name="pno" id="pno">
<br><br>
Day<input type="text" name="day" id="day">
<br><br>
Gravy<input type="text" name="gravy" id="gravy">
<br><br>
Dry_veg<input type="text" name="dryveg" id="dryveg">
<br><br>
Chapati<input type="text" name="chapati" id="chapati">
<br><br>
Sides<input type="text" name="sides" id="sides">
<br><br>
Rice <input type="text" name="rice" id="rice">
<br><br>
Special<input type="text" name="special" id="special">
 <br><br>
<button onclick="editselectrow();">Edit</button>

</div>

</form>
<script>
function selectedRowToInput()
	 {
		 
		 for(var i=1;i<table.rows.length;i++)
			 {
			 	table.rows[i].onclick=function()
			 	{
			 		rIndex=this.rowIndex;
			 		document.getElementById("pno").value=this.cells[0].innerHTML;
			 		document.getElementById("day").value=this.cells[1].innerHTML;
			 		document.getElementById("gravy").value=this.cells[2].innerHTML;
			 		document.getElementById("dryveg").value=this.cells[3].innerHTML;
			 		document.getElementById("chapati").value=this.cells[4].innerHTML;
			 		document.getElementById("sides").value=this.cells[5].innerHTML;
			 		document.getElementById("rice").value=this.cells[6].innerHTML;
			 		document.getElementById("special").value=this.cells[7].innerHTML;
			 		
			 	};
		 	}
		 
	}
	 selectedRowToInput();
	 function editselectrow()
	 {
		 var day=document.getElementById("day").value,
		 gravy=document.getElementById("gravy").value,
		 dryveg=document.getElementById("dryveg").value,
	 	chapati=document.getElementById("chapati").value,
	 	sides=document.getElementById("sides").value,
	 	rice=	document.getElementById("rice").value,
	 		special=document.getElementById("special").value;
	 		
		/*table.rows[rIndex].cells[0].innerHTML = day;
		table.rows[rIndex].cells[1].innerHTML = gravy;
		table.rows[rIndex].cells[2].innerHTML = dryveg;
		table.rows[rIndex].cells[3].innerHTML = chapati;
		table.rows[rIndex].cells[4].innerHTML = sides;
		table.rows[rIndex].cells[5].innerHTML = rice;
		table.rows[rIndex].cells[6].innerHTML = special;
		*/
	 }
	 
 </script>

</body>
</html>
