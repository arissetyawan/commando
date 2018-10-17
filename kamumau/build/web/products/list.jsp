<%-- 
    Document   : list
    Created on : Oct 17, 2018, 11:28:37 AM
    Author     : fredd
--%>

<%@include file= "/layouts/header.jsp" %>

<main style="margin-top:7%;margin-bottom:7%;">
    <div class="container">
        <div class="row">
            <button class="btn btn-primary">My Products</button> &nbsp;            
            <button class="btn btn-danger">My Products</button>
        </div>
        <br>
        <table class="table table-striped">
            <thead>
              <tr>
                 <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Stock</th>
                <th scope="col">Update At</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">3</th>
                <td>Laptop Apple 12 Inc</td>
                <td>12.000.000</td>
                <td>10</td>
                <td>Sep 3 2018</td>
                <td>Detail</td>
              </tr>
              <tr>
                <th scope="row">1</th>
                <td>Mouse X-Gen</td>
                <td>900.000</td>
                <td>100</td>
                <td>Sep 3 2018</td>
                <td>Detail</td>
              </tr>
            </tbody>
          </table>
    </div>
</main>

<%@include file= "/layouts/footer.html" %>
