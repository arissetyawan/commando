<%-- 
    Document   : list
    Created on : Oct 11, 2018, 8:27:04 PM
    Author     : x201
--%>
<link href="/WEB-INF/stylesheets/login.css" rel="stylesheet">
<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

<%@include file= "/layouts/header.jsp" %>
   
    <br />      
    <br />      
    <br />      
    <br />      
    <br />      
    <br />      
    <br />      
    <br />      
    <h1 class="h3 mb-3 font-weight-normal"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;Welcome, see you again !</h1>
    &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<% out.println("Hallo User... your id: " + session.getAttribute("current_user")); %>
    <br />      
    <br />      
    <br />      
    <br />      
    <br />      
    <br />      
    <br />      
    <br />  
    
<%@include file= "/layouts/footer.html" %>