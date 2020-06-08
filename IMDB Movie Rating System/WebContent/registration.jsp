<!DOCTYPE html>
<html>
<head>

	<title>REGISTRATION</title>
		<link rel="stylesheet" type="text/css" href="rthomecss.css">
</head>
<body>
	<form action="./Registration" method="post">
		<h1>REGISTER</h1>
		<center>
		<table>
			<tr>
				<td><b>USERNAME:</b></td>
				<td><input type="text" name="username" placeholder="USERNAME" required></td>
			</tr>
			<tr>
				<td><b>PASSWORD:</b></td>
				<td><input type="password" name="password" placeholder="PASSWORD" pattern=".{6,10}" required title="enter 6 to 10 characters" ></td>

			</tr>
			<tr>
				<td><b>EMAIL:	</b></td>
				<td><input type="email" name="email" placeholder="EMAIL" required></td>
			</tr>
			<tr><td><button>submit</button></td></tr>




		</table>
</center>
	</form>
	<!-- Add icon library -->
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</body>
</html>