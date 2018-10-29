<%-- 
    Document   : edit
    Created on : Oct 17, 2018, 11:09:56 AM
    Author     : fredd
--%>

<%@include file= "/layouts/header.jsp" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
  <style><%@include file="/orders/style.css"%></style>
<html>
    
    <body>
        
      <hr style="color: black; padding: 1px;">
    <br>
     <div class="tab">
  <button class="tablinks" onclick="openCity(event, 'Incoming')" id="defaultOpen">Detailed Orders</button>
     </div>
    <div style="height: 20%;" id="Incoming" class="tabcontent">
    <hr> 
    <div>
<table style="position:relative;" class="highlight">
        <thead>
          <tr>
               
          <th style=" border-right:1px solid #bbb;" data-field="id">ID</th>
              <th style=" border-right:1px solid #bbb;" data-field="no">Name</th>
              <th style=" border-right:1px solid #bbb;" data-field="name">Price</th>
              <th style="width: 20%; border-right:1px solid #bbb;" data-field="address">QTY</th>
              <th style=" border-right:1px solid #bbb;" data-field="address">Total</th>
              <th style=" border-right:1px solid #bbb;" data-field="action">Action</th>
          </tr>
        </thead>
 <c:forEach var="orders" items="${orders}">
                                <tr>
     <td><c:out value="${orders.id}" /></td>
 <td><c:out value="${orders.name}" /></td>
 <td><c:out value="${orders.price}" /></td>
 <td><c:out value="${orders.QTY}" /></td>
 <td><c:out value="${orders.QTY * orders.price}"/></td>
 
 

                    <td style="text-align: center;">       
                        <a style="color: red;" href="orders?action=delete&id=<c:out value='${orders.getNo()}' />" onclick="return confirm('Are you sure?')" ><i style="position:absolute;top:50%;left:90%;font-size:30px;" class="material-icons">delete</i></a>                                          
                    </td>  
            </tr>
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

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
    </body>
    
    
</html>


<%@include file= "/layouts/footer.html" %>