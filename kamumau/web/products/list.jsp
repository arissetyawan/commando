<%-- 
    Document   : list
    Created on : Oct 17, 2018, 11:28:37 AM
    Author     : fredd
--%>

<%@include file= "/layouts/header.jsp" %>

<main style="margin-top:7%;margin-bottom:7%;">
    <div class="container">
        <h4 style="background-color: yellow;">
            <c:out value='${message}' />
        </h4>
        <div class="row">
            <a href="products?action=new" class="btn btn-success">
                <i class="fa fa-plus"></i> Add Product
            </a>&nbsp;
            <a href="products?action=list" class="btn btn-primary">
                My Products
            </a> &nbsp;            
            <a href="products?action=list&stock=out" class="btn btn-danger">
                Out of Stock Products
            </a>
        </div>
        <br>
        <table class="table table-bordered table-striped table-hover">
            <thead>
              <tr>
                 <th scope="col">ID</th>
                <th scope="col">Name</th>
                <th scope="col">Price</th>
                <th scope="col">Stock</th>
                <th scope="col">Updated At</th>
                <th scope="col">Actions</th>
              </tr>
            </thead>
            <tbody>
                <c:if test="${empty products}">
                    <tr>
                        <td colspan="6" class="text-center">
                            <i>Tidak Ada Data</i>
                        </td>
                    </tr>
                </c:if>
              <c:forEach var="products" items="${products}">
                  <tr>
                    <td scope="row">${products.id}</td>
                    <td>${products.name}</td>
                    <td>${products.price}</td>
                    <td>${products.stock}</td>
                    <td>${products.updated_at}</td>
                    <td class="text-center">
                        <a href="products?action=edit&id=<c:out value='${products.getId()}' />" 
                           class="btn btn-info btn-sm">
                            <i class="fa fa-eye"></i> Detail
                        </a>
                    </td>
                  </tr>
              </c:forEach>
            </tbody>
          </table>
    </div>
</main>

<%@include file= "/layouts/footer.html" %>
