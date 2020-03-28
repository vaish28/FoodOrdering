<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<form action="regcheck.jsp" method="post">

<table border="0">
<tr><th>Register page</th></tr>
<tr><td>User Name </td>
<td><input type="text" name="username"  placeholder="enter name"></td></tr>
<tr><td>Company Name</td>
<td><input type="text" name="cmp" placeholder="enter company name"></td></tr>
<tr><td>Address</td>
<td><input type="text" name="addr" placeholder="Enter address"></td></tr>
<tr><td>Contact no</td>
<td><input type=number" name="tele" placeholder="enter contact number"></td></tr>
<tr><td>Password</td>
<td><input type="password" name="pwd" placeholder="Enter password"></td></tr>


</table>
<input type="submit" value="submit">
</form>

</center>
</body>
</html>
