<html>
<head>
<title>Airline</title>
</head>
<body>
<div>
<h1>Register</h1>
<form action="Register" method="post">
<table>
<tr><td>First Name: </td><td><input type="text" name="firstname"></td></tr>
<tr><td>Last Name: </td><td><input type="text" name="lastname"></td></tr>
<tr><td>Address: </td><td><input type="text" name="address"></td></tr>
<tr><td>City: </td><td><input type="text" name="city"></td></tr>
<tr><td>State: </td><td><input type="text" name="state"></td></tr>
<tr><td>Country: </td><td><input type="text" name="country"></td></tr>
<tr><td>Gender: </td><td><input type="text" name="gender"></td></tr>
<tr><td>Contactno: </td><td><input type="text" name="contactno"></td></tr>
<tr><td>Email_id: </td><td><input type="text" name="email_id"></td></tr>
<tr><td>Password: </td><td><input type="text" name="password" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" title="Must contain atleast one number,one uppercase,lowercase and atleast 8 characters" required></td></tr>



<tr><td></td><td><input type="submit" value="register"></td></tr>
</table>
</form>
</div>



<div>
<h1>Login</h1>
<form action="Login" method="post">
<table>
<tr><td>Email_id:</td><td><input type="text" name="email_id"></td></tr>
<tr><td>Password:</td><td><input type="text" name="password"></td></tr>
<tr><td></td><td><input type="submit" value="login"></td></tr>
</table>
</form>
</div>
</body>
</html>
