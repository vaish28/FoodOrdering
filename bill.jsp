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
	<p>BILL</p>
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
			//String provno = request.getAttribute("pno").toString();
			int provno=2;
			int choice = Integer.parseInt(session.getAttribute("tiff").toString());
			int quantity = Integer.parseInt(session.getAttribute("quant").toString());

			String q;
			String tiff = "none";
			if (choice == 1) {
				q = "select business , scost from provdetails where pno =" + provno;
				tiff = "Single tiffin";

			} else {
				q = "select business , mcost from provdetails where pno =" + provno;
				tiff = "Multiple tiffin";

			}

			rs = stmt.executeQuery(q);

			while (rs.next()) {

				double price = rs.getDouble(2);
				double sub = price * quantity;
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

</body>
</html>
