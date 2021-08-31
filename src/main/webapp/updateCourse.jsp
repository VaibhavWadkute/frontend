<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
   <form action="updateCourse" method="post">
    <pre>
		Course Id   :<input type="number" name="id" /><br>
		Name        :<input type="text" name="name" /> <br>
		Description :<input type="text" name="description" /><br>
		Course Fee  :<input type="number" name="fee" /><br>
		Resource    :<input type="text" name="resource" /><br>
		
		            <input type="submit" value="Update" /><br>
	</pre>
	</form>
</body>
</html>