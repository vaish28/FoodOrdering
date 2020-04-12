<%@page import="java.sql.*">
<%@page import=" com.DB">
<%@page import="javax.swing.JOptionPane" %>
<%

	Connection con=DB.conc();
	Statement stmt=con.createStatement();
	HttpSession sess=request.getSession(false);
	int provno=sess.getAttribute("pno");
	int regno=request.getParameter("custid");
	String str="delete from provcust where regno = "+regno+" and pno = "+provno 
	ResultSet rs=null;
	rs=stmt.executeUpdate(str);
	if(rs.next()!=false)
	{
		JOptionPane.showMessageDialog(null,"success");
		response.sendRedirect("order.jsp");
	}
	else
	{
		JOptionPane.showMessageDialog(null,"failed");
		response.sendRedirect("order.jsp");
	}

%>
