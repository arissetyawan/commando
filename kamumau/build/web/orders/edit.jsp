<%-- 
    Document   : list
    Created on : Oct 17, 2018, 11:28:37 AM
    Author     : ilyas
--%>

<%@page import="model.Order"%>
<%@include file="/layouts/header.jsp" %>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <title>Detailed Order</title>
  <style><%@include file="/orders/style.css"%></style>
<html>
    <body>
        <%
    String myVar= Order.csname;
%>       
 <hr style="color: black; padding: 1px;">
    <form action="orders?action=user" method="POST">
        <select class="user" name="user">
           <option>choose user</option>
           <option value="1">User 1</option>
           <option value="2" >User 2</option>
           <option value="3" >User 3</option>
       </select>
        <button type="submit" name="user2">ok</button>
    </form> <p style="position:absolute;top:10%; left:2%;font-family: Courier; font-size: 13px;">
        welcome : <c:out value="<%=myVar%>" /></p>
     <c:set var="test" value='${cs_name}' />



 <script>
     if('${test}'==="")
     {}
     else
     {
         alert('<c:out value='${cs_name}'/>')
         window.location.href = "orders?action=list";         
     }
 </script>
         
  
     <div class="tab">
         <button class="tablinks"  onclick="openCity(event, 'Incoming')" id="defaultOpen">Order Detail</button>
</div>
    <div style="height: 20%;" id="Complete" class="tabcontent">
    <hr> 
    <div>
        
<table style="position:relative;" class="highlight">
        <thead>
            <tr >
          <th style=" border-right:1px solid #bbb;" data-field="id">ID</th>
              <th style=" border-right:1px solid #bbb;" data-field="no">No.</th>
              <th style=" border-right:1px solid #bbb;" data-field="name">Buyer ID</th>
              <th style=" border-right:1px solid #bbb;" data-field="date">Created At</th>
              <th style=" border-right:1px solid #bbb;" data-field="status">Status</th>
              <th style=" width: 25%;border-right:1px solid #bbb;" colspan="2" data-field="action">Action</th>
          </tr>
          </tr>
        </thead>
 <c:forEach var="orders" items="${orders}">
            <tr>
 <td><c:out value="${orders.id}" /></td>
 <td><c:out value="${orders.no}" /></td>
 <td><c:out value="${orders.byid}" /></td>
 <td><c:out value="${orders.created_at}" /></td>
 <td><c:out value="${orders.status}" /></td>

<td style="text-align: center;"  >
  <a   href="orders?action=edit&no=<c:out value='${orders.getNo()}' />"><i class="material-icons">visibility</i></a>
</td>
 <td style="text-align: center;">       
 <a style="color: red;" href="orders?action=delete&no=<c:out value='${orders.getNo()}' />" onclick="return confirm('Are you sure?')" ><i class="material-icons">delete</i></a>                                          
</td>  
            </tr>
         </c:forEach>
      </table>
</div>
</div>

<div id="Incoming" class="tabcontent" >
<div>
    <hr>
     <a style="color:black; position: absolute; text-align: left; font-size: 22px; left:5px;" 
        href="orders?action=list"><i style="color: black; font-size: 30px;" class="material-icons">home</i><b>HOME</b></a>
    <br>
<table style="position:relative" class="highlight">

        <thead>
          <tr >

          <th style=" border-right:1px solid #bbb;" data-field="id">ID</th>
              <th style=" border-right:1px solid #bbb;" data-field="no">No.</th>
              <th style=" border-right:1px solid #bbb;" data-field="name">Buyer name</th>
              <th style=" border-right:1px solid #bbb;" data-field="date">Created At</th>
              <th style=" border-right:1px solid #bbb;" data-field="status">Status</th>
              <th style=" width: 25%;border-right:1px solid #bbb;" colspan="2" data-field="action">Action</th>
          </tr>
        </thead>
        <% int a=1; %>
              <c:forEach var="orders" items="${orders}">
                 
                                <tr>
         <td><c:out value='<%=a%>' /></td>
 <td><c:out value="${orders.no}" /></td>
 <td><c:out value="${orders.name}" /></td>
 <td><c:out value="${orders.created_at}" /></td>
 <td><c:out value="${orders.status}" /></td>

<td style="text-align: center;"  >
<a href="orders?action=updatein&no=<c:out value='${orders.getNo()}' />">change status</a>
</td>
 <td style="text-align: center; ">       
     <a style="color: red; " href="orders?action=delete&no=<c:out value='${orders.getNo()}' />" onclick="return confirm('Are you sure?')" ><i style="position: relative;" class="material-icons">delete</i></a>                                          
</td>  
</tr> <% a++; %>
         </c:forEach>
                
                  
      </table>
</div>
</div>





 
       
        <script>
function openCity(evt, cityName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(cityName).style.display = "block";
    evt.currentTarget.className += " active";
}
                 function Redirect(Url){
            document.location.href = Url;
        }
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
<button style="visibility: hidden;" name="list" onclick="Redirect('orders?Action=list')"> </button>
<button style="visibility: hidden;" name="complete" onclick="Redirect('orders?Action=complete')"> </button>
<button style="visibility: hidden;" name="cart" onclick="Redirect('orders?Action=cart')"> </button>

    </body>
    
</html>

<%@include file= "/layouts/footer.html" %>
