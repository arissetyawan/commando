<%-- 
    Document   : navbar_not_logged_in.jsp
    Created on : Oct 11, 2018, 7:35:36 PM
    Author     : x201
--%>

<nav class="navbar navbar-expand-md navbar-dark fixed-top bg-dark">
  <a class="navbar-brand" href="#">KamuMau</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>

  <div class="collapse navbar-collapse" id="navbarsExampleDefault">
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home</a>
      </li>
      <li class="nav-item dropdown active">
        <a class="nav-link dropdown-toggle" href="#" id="dropdown01" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories</a>
        <div class="dropdown-menu" aria-labelledby="dropdown01">
          <a class="dropdown-item" href="categories/list.jsp">Data Category</a>
          <a class="dropdown-item" href="categories/add.jsp">Add category</a>
          <a class="dropdown-item" href="categories/edit.jsp">Edit category</a>
        </div>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="/kamumau/products">Products</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Sign In</a>
      </li>
      <li class="nav-item active">
        <a class="nav-link" href="#">Sign Up</a>
      </li>
    </ul>
    <form class="form-inline my-2 my-lg-0" method="post" action="/kamumau/products?action=search">
      <input name="key" class="form-control mr-sm-2" type="text" placeholder="Search Products..." aria-label="Search Products...">
      <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
    </form>
  </div>
</nav>