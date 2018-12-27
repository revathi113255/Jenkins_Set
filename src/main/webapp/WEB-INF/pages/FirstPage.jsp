<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<h1>Quiz</h1>
	
 <form:form action="SecondPage" modelAttribute="question" >
  
 
  <% int i = 0;
  int j=0;
boolean flag;
  %> 
    
   <core:forEach var="questionPaperCommand" items="${listEmployee}" begin="3" end="5"><br/><br/>
    
          
       <core:out value="${questionPaperCommand.qid}"></core:out>
          <core:out value="."></core:out>
     <input type="hidden"  value="${questionPaperCommand.qid}" name="quesNum" />   <core:out value="${questionPaperCommand.question_text}"></core:out><br/>
     
    <input type="radio"   id="option1" name="option${questionPaperCommand.qid}" value="${questionPaperCommand.option1}">
  <core:out value="${i}"></core:out>
        <core:out  value="${questionPaperCommand.option1}"></core:out><br/>
     <input type="radio"  id="option2" name="option${questionPaperCommand.qid}" value="${questionPaperCommand.option2}">
        <core:out value="${questionPaperCommand.option2}"></core:out><br/>
      
        <input type="radio"   id="option3" name="option${questionPaperCommand.qid}" value="${questionPaperCommand.option3}">
        <core:out value="${questionPaperCommand.option3}"></core:out><br/>
       
        <input type="radio"  id="option4" name="option${questionPaperCommand.qid}" value="${questionPaperCommand.option4}">
        <core:out value="${questionPaperCommand.option4}"></core:out><br/>
      
     <% i++;
     j++;
    
     %> 
  
        </core:forEach> 
        <input type="submit" value="Next"/>
        </form:form>  
           <br/>

</body>
</html>