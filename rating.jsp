<!DOCTYPE html>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.DB"%>
<html>
<head>
	<title></title>
</head>
<body>

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
			String radioRate = request.getParameter("rating");
			int rat = Integer.parseInt(radioRate);
			HttpSession sess=request.getSession(false);
			//int provno = Integer.parseInt(sess.getAttribute("pno").toString());
			String q = "update provdetails set rating = "+rat+" where pno=1";
			stmt.executeUpdate(q);
	%>

</body>
</html>