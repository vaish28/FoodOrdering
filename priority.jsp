
<%
class Provider 
{
	int id;
	String name;
	String service;
	int rating;
	Provider()
	{		rating=0;
			id=0;
	}
}
class RatingComparator implements Comparator<Provider>
{
	public int compare(Provider p1,Provider p2)
	{
		if(p1.rating<p2.rating)
		{
			return 1;
		}
		else if(p1.rating>p2.rating)
		{
			return -1;
		}
		else
		{
			return 0;
		}
	}
}


try{
ResultSet rs=null;
Connection con=DB.conc();
Statement stmt=con.createStatement();
String qry = "select pno,name,business,rating from provdetails";
rs = stmt.executeQuery(qry);
while(rs.next())
{
	Provider pro=new Provider();
	p.comparator();
	pro.id=rs.getInt(1);
	pro.name=rs.getString(2);
	pro.service=rs.getString(3);
	pro.rating=rs.getInt(4);
	p.add(pro);
}
while(!p.isEmpty())
{
	Provider p1=new Provider();
	p1=p.remove();
	System.out.println(p1.id+"\t\t"+p1.name+"\t"+p1.service+"\t\t"+p1.rating);
	}
%>
<tr bgcolor=pink>
<td><%=p1.id%></td>
<td><%=p1.name%></td>
<td><%=p1.service%></td>
<td><%=p1.rating%></td>
</tr>

<%
}
}
catch(Exception ex)
{
System.out.println(ex);
}
%>
