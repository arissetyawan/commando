<%-- 
    Document   : search
    Created on : Oct 18, 2018, 9:25:19 AM
    Author     : fredd
--%>

<%@include file= "/layouts/header.jsp" %>

<main style="margin-top:7%;margin-bottom:7%;">
    <div class="container">
        <h3>Products</h3><br>
        <div class="row">
            <c:forEach var="products" items="${products}">
                <div class="col-sm-4" style="margin-bottom:20px;">
                    <div class="card">
                        <div class="card-body">
                            <h5 class="card-title">${products.name}</h5>
                            <p class="card-text">
                                Category : 
                            </p>
                          <a href="#" class="card-link">Rp ${products.price}</a>
                          <a href="#" class="btn btn-success btn-sm float-right">
                              <i class="fa fa-shopping-cart"></i> 
                              Buy
                          </a>
                        </div>
                    </div>
                </div>
            </c:forEach>
        </div>
    </div>
</main>

<%@include file= "/layouts/footer.html" %>