<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>LoginPage</title>
<style>
.errors
{
color:red;
font-weight:bold;
}
</style>
</head>
<body>
 <div align="center">
        <h1>Login</h1>
        <form:form action="saveEmployee" method="post" commandName="employee">
        <div class="container">
        <div class="jumbotron">
        <table >
            <form:hidden path="id"/>
            <tr>
               <td><label> <strong>UserName</strong>
				</label></td>
                <td><form:input path="name" /></td><td><form:errors path="name" class="errors"></form:errors></td>
            </tr>
            <tr>
                <td><label> <strong>Password:</td>
                <td><form:password path="password" /></td><td><form:errors path="password" class="errors"></form:errors></td>
            </tr>
           
            <tr>
                <td colspan="2" align="center"><input type="submit" class="btn btn-success" value="Save"></td>
            </tr>
        </table>
        </div>
        </div>
        </form:form>
    </div>
</body>
</html>