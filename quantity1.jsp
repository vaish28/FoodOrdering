<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<%

     String radioButton = request.getParameter("tiffin");

     String quantVal = request.getParameter("quantity");

     //request.setAttribute("quant",quantVal);
		//localStorage.setItem("quant",quantVal);
		session.setAttribute("quant",quantVal);
     //request.setAttribute("tiff",radioButton);
	session.setAttribute("quant",quantVal);
     //request.setAttribute("pno",2);
     session.setAttribute("quant",quantVal);
     response.sendRedirect("bill.jsp");
     %>


</body>
</html>
