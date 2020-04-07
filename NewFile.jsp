<%@page import="javax.swing.JOptionPane"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body bgcolor="lightgreen">
	<table align="right">

		<tr>
			<td>
				<form action="NewFilecheck.jsp" method="post">

					<table border="0">
						<tr>
							<th>Menu Page</th>
						</tr>
						<tr>
							<td>Gravy</td>
							<td><input type="text" name="gravy name" value=""
								placeholder="enter gravy name"></td>
						</tr>
						<tr>
							<td>Dry_veg</td>
							<td><input type="text" name="dry_veg name" value=""
								placeholder="enter dry veg name"></td>
						</tr>
						<tr>
							<td>Chapati</td>
							<td><input type="text" name="Chapati name" value=""
								placeholder="enter chapati type"></td>
						</tr>
						<tr>
							<td>Sides</td>
							<td><input type="text" name="Sides name" value=""
								placeholder="enter sides"></td>
						</tr>
						<tr>
							<td>Rice</td>
							<td><input type="text" name="Rice name" value=""
								placeholder="enter rice type"></td>
						</tr>
						<tr>
							<td>Special</td>
							<td><input type="text" name="Special name" value=""
								placeholder="enter special menu"></td>
						</tr>

					</table>
					<input type="submit" value="submit">
				</form>
			</td>
		</tr>
	</table>
</body>
</html>