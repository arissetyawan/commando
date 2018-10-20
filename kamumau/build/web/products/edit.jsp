<%-- 
    Document   : edit
    Created on : Oct 17, 2018, 11:09:56 AM
    Author     : fredd
--%>

<%@include file= "/layouts/header.jsp" %>

<main style="margin-top:7%;margin-bottom:7%;">
    <div class="container">
        <h4><c:out value='${message}' /></h4>
        <div class="row">
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-header">Editing Product</div>
                    <div class="card-body">
                        <form method="post" 
                              action="/kamumau/products?action=update&id=<c:out value='${product.getId()}' />">
                        <div class="form-group row">
                          <label for="category" class="col-sm-2 col-form-label">
                              Category
                          </label>
                          <div class="col-sm-10">
                              <select class="form-control" name="category">
                                  <option value="">Please select categories</option>
                                  <option value="1"
                                        <c:if test="${product.getCategory_id() == 1}">
                                           selected
                                        </c:if>>
                                    1
                                  </option>
                                  <option value="2"
                                        <c:if test="${product.getCategory_id() == 2}">
                                           selected
                                        </c:if>>
                                    2
                                  </option>
                                  <option value="3"
                                        <c:if test="${product.getCategory_id() == 3}">
                                           selected
                                        </c:if>>
                                    3
                                  </option>
                              </select>
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="name" class="col-sm-2 col-form-label">
                              Name
                          </label>
                          <div class="col-sm-10">
                            <input type="text" class="form-control" id="name" 
                                   name="name" placeholder="Input Your Name"
                                   value="<c:out value='${product.getName()}' />">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="price" class="col-sm-2 col-form-label">
                              Price
                          </label>
                          <div class="col-sm-10">
                            <input type="number" class="form-control" id="price" 
                                   name="price" placeholder="0"
                                   value="<c:out value='${product.getPrice()}' />">
                          </div>
                        </div>
                        <div class="form-group row">
                          <label for="stock" class="col-sm-2 col-form-label">
                              Stock
                          </label>
                          <div class="col-sm-10">
                            <input type="number" class="form-control" id="stock" 
                                   name="stock" placeholder="0"
                                   value="<c:out value='${product.getStock()}' />">
                          </div>
                        </div>
                        <div class="form-group row">
                          <div class="col-sm-10 offset-sm-2">
                            <button type="submit" class="btn btn-success">
                                Update
                            </button> &nbsp;
                            <a href="javascript:void(0)" class="btn btn-danger">
                                Hapus ?
                            </a>
                          </div>
                        </div>
                      </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<%@include file= "/layouts/footer.html" %>