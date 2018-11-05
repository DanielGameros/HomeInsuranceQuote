<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Location</title>
<script type="text/javascript">
	function validate(form) {
		var locationForm = document.forms["location"];

		if (locationForm["addressLine1"].value == "") {
			alert("Please enter Address Line 1");
			return false;
		}
		if (locationForm["city"].value == "") {
			alert("Please enter City");
			return false;
		}
		if (locationForm["state"].value == "") {
			alert("Please enter State");
			return false;
		}
		if (locationForm["zip"].value == "") {
			alert("Please enter Zip");
			return false;
		}
		return true;
	}
	window.history.forward();
	function noBack() {
		window.history.forward();
	}
</script>
</head>
<body onload="noBack();" onunload="">
	<%@include file="header.jsp"%>
	<hr />
	<h1 align="left">Home Location</h1>
	<div align="right">
		<a href="logout.jsp">Logout</a>
	</div>
	<form name="location" action="location" method="post">
		<div align="center" style="width: 800px; margin: 0 auto;">
			<table>
				<tr>
					<td>Residence Type</td>
					<td><select name="residenceType">
							<option value="Single-Family Home">Single-Family Home</option>
							<option value="Condo">Condo</option>
							<option value="Townhouse">Townhouse</option>
							<option value="Rowhouse">Rowhouse</option>
							<option value="Duplex">Duplex</option>
							<option value="Apartment">Apartment</option>
					</select></td>
				</tr>
				<tr>
					<td>Address Line 1</td>
					<td><input name="addressLine1" type="text" /></td>
				</tr>
				<tr>
					<td>Address Line 2</td>
					<td><input name="addressLine2" type="text" /></td>
				</tr>
				<tr>
					<td>City</td>
					<td><input name="city" type="text" /></td>
				</tr>
				<tr>
					<td>State</td>
					<td><select name="state">
							<option value="AL">AL</option>
							<option value="AK">AK</option>
							<option value="AR">AR</option>
							<option value="AZ">AZ</option>
							<option value="CA">CA</option>
							<option value="CO">CO</option>
							<option value="CT">CT</option>
							<option value="DC">DC</option>
							<option value="DE">DE</option>
							<option value="FL">FL</option>
							<option value="GA">GA</option>
							<option value="HI">HI</option>
							<option value="IA">IA</option>
							<option value="ID">ID</option>
							<option value="IL">IL</option>
							<option value="IN">IN</option>
							<option value="KS">KS</option>
							<option value="KY">KY</option>
							<option value="LA">LA</option>
							<option value="MA">MA</option>
							<option value="MD">MD</option>
							<option value="ME">ME</option>
							<option value="MI">MI</option>
							<option value="MN">MN</option>
							<option value="MO">MO</option>
							<option value="MS">MS</option>
							<option value="MT">MT</option>
							<option value="NC">NC</option>
							<option value="NE">NE</option>
							<option value="NH">NH</option>
							<option value="NJ">NJ</option>
							<option value="NM">NM</option>
							<option value="NV">NV</option>
							<option value="NY">NY</option>
							<option value="ND">ND</option>
							<option value="OH">OH</option>
							<option value="OK">OK</option>
							<option value="OR">OR</option>
							<option value="PA">PA</option>
							<option value="RI">RI</option>
							<option value="SC">SC</option>
							<option value="SD">SD</option>
							<option value="TN">TN</option>
							<option value="TX">TX</option>
							<option value="UT">UT</option>
							<option value="VT">VT</option>
							<option value="VA">VA</option>
							<option value="WA">WA</option>
							<option value="WI">WI</option>
							<option value="WV">WV</option>
							<option value="WY">WY</option>
					</select>
					</td>
				</tr>
				<tr>
					<td>Zip</td>
					<td><input name="zip" type="text" /></td>
				</tr>
				<tr>
					<td>Residence Use</td>
					<td><select name="residenceUse">
							<option value="Primary">Primary</option>
							<option value="Secondary">Secondary</option>
							<option value="Rental Property">Rental Property</option>
					</select></td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="Submit"
						value="Continue" onclick="return validate(this);" /></td>
				</tr>
			</table>
		</div>
	</form>
	<hr />
	<script type="text/javascript">
		document.getElementById("loc").src = "images/tick.jpg";
		document.getElementById("Location").className = "header1";
	</script>
</body>
</html>