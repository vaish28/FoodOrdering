<!DOCTYPE html>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB"%>

<html>
<head>
<title>BILL</title>
</head>
<body>
	<p><strong>BILL</strong></p>
	<p>---------------------------------</p>
	<script type="text/javascript">
		var dt = new Date();
		var year = dt.getYear();
		if (year < 1000) {
			year = year + 1900;
		}
		var myDay = dt.getDay();
		var daym = dt.getDate();
		var month = dt.getMonth();
		// Array of days. 
		var weekday = [ 'Sunday', 'Monday', 'Tuesday', 'Wednesday', 'Thursday',
				'Friday', 'Saturday' ];
		var montharr = [ 'January', 'February', 'March', 'April', 'May',
				'June', 'July', 'August', 'September', 'October', 'November',
				'December' ];
		document.write(daym);
		document.write(montharr[month]);
		document.write(year);
		document.write("<br/>");
		document.write(weekday[myDay]);
	</script>

	<p>----------------------------------</p>


	<table border="1" cellpadding="5" cellspacing="5">

		<th>Provider</th>
		<th>Item name</th>
		<th>Quantity</th>
		<th>Cost / Item</th>
		<th>Sub Amount</th>

		<%
			String driverName = "com.mysql.jdbc.Driver";
			String connectionUrl = "jdbc:mysql://localhost/Dabewala";
			try {
				Class.forName(driverName);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			Statement stmt = null;
			ResultSet rs = null;
			Connection con = DB.conc();
			stmt = con.createStatement();
			HttpSession sess=request.getSession(false);
			//String provno = sess.getAttribute("pno").toString();
			int provno=1;
			//int choice = Integer.parseInt(request.getAttribute("tiff").toString());
			
			String choice=sess.getAttribute("tiff").toString();
			int quantity = Integer.parseInt(sess.getAttribute("quant").toString());
			String q;
			String tiff = "none";
			if (choice.compareTo("Single Tiffin")==0) {
				q = "select business , scost from provdetails where pno =" + provno;
				tiff = "Single tiffin";
			} else {
				q = "select business , mcost from provdetails where pno =" + provno;
				tiff = "Monthly tiffin";
			}
			rs = stmt.executeQuery(q);
			double final=0;
			final = 10 * quantity;
			while (rs.next()) {

				double price = rs.getDouble(2);
				double sub = price * quantity;
				final = final + sub;
		%>
		<tr>
			<td><%=rs.getString(1)%></td>
			<td><%=tiff%></td>
			<td><%=quantity%></td>
			<td><%=price%></td>
			<td><%=sub%></td>




		</tr>
		<%
			}
		%>




	</table>




	</table>
<table border="1" cellspacing="5" cellpadding="5">
	<tr>
		<td width="470">Service charges / Item</td>
		<td width="80">10</td>
		
	</tr>
	<tr>
		<td><strong>Total Amount</strong></td>
		<td><strong><%=final%></strong></td>
	</tr>
</table>
<p align="center"><strong>THANK YOU!</strong></p>

<p ><strong>How would you rate this provider?</strong></p>


<form name="rate" action="rating.jsp">
<input type="radio" name="rating" value="1">1
<input type="radio" name="rating" value="2">2
<input type="radio" name="rating" value="3">3
<input type="radio" name="rating" value="4">4
<input type="radio" name="rating" value="5">5
<br>
<br>
<button type="submit" style="background-color: blue;color: white;">Rate Now!</button>
</form>



</body>
</html>
