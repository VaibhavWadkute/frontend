<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="style.css" rel="stylesheet" type="text/css">
<title>Registration Page</title>
</head>
<body>
    <form action="register" method="post">
       
       <pre>
          User Id    :  <input type="number" name="id" /><br>
	      Username   :  <input type="text" name="username" /><br>
	      Phone      :  <input type="number" name="phone" /><br>
	      Email      :  <input type="email" name="email" /><br>
	      Address    :  <input type="textarea" name="address" /><br>
	      Reg_date   :  <input type="text" name="reg_date" /><br>
	      Password   :  <input type="password" name="password" /><br>
	      Image      :  <input type="text" name="image" /><br>
	                  <input type="submit" value="Sign Up" /><br>
     </pre>
     </form>
</body>
</html>