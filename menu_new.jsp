
<%@page import="javax.swing.JOptionPane"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
.tab-2 {
	margin-left: 50px
}

.tab-2 input {
	display: block;
	margin-bottom: 20px
}
</style>
</head>
<body bgcolor="lightgreen">
	<div class="container">
		<div class="tab tab-2"">
			<table id="table" border="1" width="50" height="50">
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


		<table align="right">

			<tr>
				<td>
					<form action="menu_newcheck.jsp" method="post">

						<table border="0">
							<tr>
								<th>Menu Page</th>
							</tr>
							<tr>
								<td>DAY</td>
								<td><input type="text" name="day"></td>
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

						<button onclick="addHtmlTableRow();">Add</button>
						<button onclick="editselectrow();">Edit</button>
						<button>Remove</button>
					</form>
				</td>
			</tr>
		</table>

	</div>



	</p>
	<script>
		var rIndex, table = document.getElementById("table");
		
		function addHtmlTableRow() {
			//get table by id
			var newRow = table.insertRow(-1, table.length), //create new rows
			//cretae new cells
			cell1 = newRow.insertCell(0), cell2 = newRow.insertCell(1), cell3 = newRow
					.insertCell(2), cell4 = newRow.insertCell(3), cell5 = newRow
					.insertCell(4), cell6 = newRow.insertCell(5), cell7 = newRow
					.insertCell(6),
			//get value from input text and set values into row cell's
			day=request.getAttribute("day");
			/*day = document.getElementById("day").value,*/ gravy = document
					.getElementById("gravy name").value, dryveg = document
					.getElementById("dry_veg name").value, chapati = document
					.getElementById("Chapati name").value, sides = document
					.getElementById("Sides name").value, rice = document
					.getElementById("Rice name").value, special = document
					.getElementById("Special name").value;

			cell1.innerHTML = day;
			cell2.innerHTML = gravy;
			cell3.innerHTML = dryveg;
			cell4.innerHTML = chapati;
			cell5.innerHTML = sides;
			cell6.innerHTML = rice;
			cell7.innerHTML = special;
			selectedRowToInput();
		}
		function selectedRowToInput() {

			for (var i = 1; i < table.rows.length; i++) {
				table.rows[i].onclick = function() {
					rIndex = this.rowIndex;
					request.getAttribute("day").value=this.cells[0].innerHTML;
					//document.getElementById("day").value = this.cells[0].innerHTML;
					document.getElementById("gravy name").value = this.cells[1].innerHTML;
					document.getElementById("dry_veg name").value = this.cells[2].innerHTML;
					document.getElementById("Chapati name").value = this.cells[3].innerHTML;
					document.getElementById("Sides name").value = this.cells[4].innerHTML;
					document.getElementById("Rice name").value = this.cells[5].innerHTML;
					document.getElementById("Special name").value = this.cells[6].innerHTML;

				};
			}

		}
		selectedRowToInput();
		function editselectrow() {
			var //day = document.getElementById("day").value,
			gravy = document.getElementById("gravy name").value, 
			dryveg = document.getElementById("dry_veg name").value,
			chapati = document.getElementById("Chapati name").value, 
			sides = document.getElementById("Sides name").value, 
			rice = document.getElementById("Rice name").value, 
			special = document.getElementById("Special name").value;

			//table.rows[rIndex].cells[0].innerHTML = day;
			table.rows[rIndex].cells[1].innerHTML = gravy;
			table.rows[rIndex].cells[2].innerHTML = dryveg;
			table.rows[rIndex].cells[3].innerHTML = chapati;
			table.rows[rIndex].cells[4].innerHTML = sides;
			table.rows[rIndex].cells[5].innerHTML = rice;
			table.rows[rIndex].cells[6].innerHTML = special;
		}
	</script>
</body>
</html>