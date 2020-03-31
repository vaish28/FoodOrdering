<%@page import="javax.swing.*" %>
<%@page import="java.awt.*" %>
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
<body>
<div class="container">
<div class="tab tab-2"">
<table id="table" border="1">
<tr>
<th>Day:</th>
<th>Gravy:</th>
<th>Dry_veg:</th>
<th>Chapati</th>
<th>Sides:</th>
<th>Rice:</th>
<th>Special:</th>
</tr>
</table>
</div>
<div class="tab-2" align="center" >
Day<input type="text" name="day" id="day">
Gravy<input type="text" name="gravy" id="gravy">
Dry_veg<input type="text" name="dryveg" id="dryveg">
Chapati<input type="text" name="chapati" id="chapati">
Sides<input type="text" name="sides" id="sides">
Rice <input type="text" name="rice" id="rice">
Special<input type="text" name="special" id="special">


<button onclick="addHtmlTableRow();">Add</button>
<button>Edit</button>
<button>Remove	</button>
</div>
</div>
 
 <script>
 
	 function addHtmlTableRow()
	 {
		 //get table by id
		 var table=document.getElementById("table"),
			 newRow=table.insertRow(table.length),	//create new rows
			 //cretae new cells
			 cell1=newRow.insertCell(0),
			 cell2=newRow.insertCell(1),
			 cell3=newRow.insertCell(2),
			 cell4=newRow.insertCell(3),
			 cell5=newRow.insertCell(4),
			 cell6=newRow.insertCell(5),
			 cell6=newRow.insertCell(6),
			 //get value from input text and set values into row cell's
			 day=document.getElementById("day").value,
			 gravy=document.getElementById("gravy").value,
			 dryveg=document.getElementById("dryveg").value,
			 chapati=document.getElementById("chapati").value,
			 sides=document.getElementById("sides").value,
			 rice=document.getElementById("rice").value,
			 special=document.getElementById("special").value;
		 
		cell1.innerHTML=day;
		 cell2.innerHTML=gravy;
		 cell3.innerHTML=dryveg;
		 cell4.innerHTML=chapati;
		 cell5.innerHTML=sides;
		 cell6.innerHTML=rice;
		 cell7.innerHTML=special;
	 }
 </script>
</body>
</html>
