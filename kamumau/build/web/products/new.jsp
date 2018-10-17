<%-- 
    Document   : new
    Created on : Oct 17, 2018, 10:27:09 AM
    Author     : fredd
--%>

<%@include file= "/layouts/header.jsp" %>

<main style="margin-top:7%;margin-bottom:7%;">
    <div class="container">
        <div class="col-sm-8">
            <div class="card">
                <div class="card-header">Add New Product</div>
                <div class="card-body">
                    <form>
                    <div class="form-group row">
                      <label for="category" class="col-sm-2 col-form-label">
                          Category
                      </label>
                      <div class="col-sm-10">
                          <select class="form-control">
                              <option value="">Please select categories</option>
                          </select>
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="name" class="col-sm-2 col-form-label">
                          Name
                      </label>
                      <div class="col-sm-10">
                        <input type="text" class="form-control" id="name" 
                               name="name" placeholder="Input Your Name">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="price" class="col-sm-2 col-form-label">
                          Price
                      </label>
                      <div class="col-sm-10">
                        <input type="number" class="form-control" id="price" 
                               name="price" placeholder="0">
                      </div>
                    </div>
                    <div class="form-group row">
                      <label for="stock" class="col-sm-2 col-form-label">
                          Stock
                      </label>
                      <div class="col-sm-10">
                        <input type="number" class="form-control" id="stock" 
                               name="stock" placeholder="0">
                      </div>
                    </div>
                    <div class="form-group row">
                      <div class="col-sm-10 offset-sm-2">
                        <button type="submit" class="btn btn-success">
                            Save
                        </button>
                      </div>
                    </div>
                  </form>
                </div>
            </div>
        </div>
    </div>
</main>

<%@include file= "/layouts/footer.html" %>
