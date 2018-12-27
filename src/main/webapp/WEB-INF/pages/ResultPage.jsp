<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<a href="Pdf">Result In PDF</a>
 <table align="center" >
 <h2 align="center" >Assessment Result </h2>
   <% int i=0;
     %>
  
  <tr>
    <td colspan="2" ><core:out value="--------------------------------------"></core:out></td>   
  </tr>
  <tr>
    <td><core:out value="Result"></core:out></td>   
  </tr>
  <tr>
    <td colspan="2">
    <core:out value="Total Question : "></core:out>
        <core:out value="${totalQuestion}"></core:out>
        
    </td>   
  </tr>
   <tr>
    <td colspan="2" >
       <core:out value="Number of right answer : "></core:out>
       <core:out value="${rightAnswer}"></core:out>
   </td>   
  </tr>
  <tr>
    <td colspan="2" >
      <core:out value="Number of wrong answer : "></core:out>
      <core:out value="${wrongAnswer}"></core:out>
    </td>   
  </tr>
</table>
ii
</body>
</html>