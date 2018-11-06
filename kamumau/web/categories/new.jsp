<%-- 
    Document   : new
    Created on : Oct 31, 2018, 3:46:47 PM
    Author     : alibudi
--%>

<%@include file= "/layouts/header.jsp" %>

<main style="margin-top:7%;margin-bottom:7%;">
    <div class="container">
        <h4><c:out value='${message}' /></h4>
        <div class="col-sm-8">
            <div class="card">
                <div class="card-header">Add New Category</div>
                <div class="card-body">
                    <form method="post" action="/kamumau/categories?action=create">
                    <div class="form-group row">
                      <label for="category" class="col-sm-2 col-form-label">
                          Category
                      </label>
                      <div class="col-sm-10">
                          <select class="form-control" name="category">
                                <option>Programmer</option>  
                                <option>Marketting</option>  
                                <option>Consultant</option>  
                                <option>Designer</option>  
                                <option>Project Manager</option>  
                                <option>Analyst</option>  
                                <option>Other</option>  
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