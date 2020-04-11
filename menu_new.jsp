<%@page import="javax.swing.*" %>
<%@page import="java.awt.*" %>
<%@page import="com.DB" %>
<%@page import="java.sql.*"%>
<%@page import="java.util.*"%>
<%@page import="javax.swing.table.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<style>
	
	.tab-2{margin-left: 50px}
	.tab-2 input{display: block;margin-bottom: 20px}
</style>
</head>
 <body bgcolor=aqua>

<form action="menu_newcheck.jsp" name="menu" id="menu" method="post"  onsubmit="return validateForm();">

<script>
	
	function onClick()
	{
		HttpSession sess=request.getSession(false);
		var c=parseInt(sess.getAttribute("clicks").toString());
		document.getElementById("clicks").innerHTML = c
		if(c==2)
		{
			window.location.href = "menu_newcheck.jsp";
		}
	}
	
	
</script>
<script>
window.onload = function(){
    var form = document.getElementById("menu");
    form.onsubmit = function(){
        var inputs = form.getElementsByTagName("input"), input = null, flag = true;
        for(var i = 0, len = inputs.length; i < len; i++) {
            input = inputs[i];
            if(!input.value) {
                flag = false;
                input.focus();
                alert("Please fill all the inputs");
				clicks=clicks-1;
                break;
            }
        }
        return(flag);
    };
};
</script>
	<table border="1" align="center" >
	<tr bgcolor=pink>
	<th>Day</th>
	<th>Gravy</th>
	<th>Dryveg</th>
	<th>Chapati</th>
	<th>Sides</th>
	<th>Rice</th>
	<th>Special</th>
	</tr>
	<%
		ResultSet rs=null;
		Connection con=DB.conc();
		Statement stmt=con.createStatement();
		HttpSession sess = request.getSession(false);
		
		int pno=Integer.parseInt(sess.getAttribute("pno2").toString());
		String qry = "select * from menu where pno="+pno;
		rs = stmt.executeQuery(qry);
		while(rs.next())
		{
		%>
		<tr bgcolor=pink>
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
		%>
	
	</table>
	
	<div class="tab-2" align="left">
Day<input type="text" name="day" id="day">
Gravy<input type="text" name="gravy" id="gravy">
Dry_veg<input type="text" name="dryveg" id="dryveg">
Chapati<input type="text" name="chapati" id="chapati">
Sides<input type="text" name="sides" id="sides">
Rice <input type="text" name="rice" id="rice">
Special<input type="text" name="special" id="special">

 <button onClick="onClick()">Add</button>
<p>Clicks: <a id="clicks">0</a></p>
</div>
</div>
</form>

		</body>
</html>