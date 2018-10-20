<%-- 
    Document   : add
    Created on : Oct 17, 2018, 11:49:36 AM
    Author     : alibudi
--%>

<link href="/WEB-INF/stylesheets/jumbotron.css" rel="stylesheet">

<%@include file= "/layouts/header.jsp" %>

<main role="main">
<div class="container">
    <div class="content-wrapper">
        <section class="content-header">
    <h1>
      Category
      <small>Add Category</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href=""><i class="fa fa-map-marker"></i> Add Category</a></li>
      <!--<li class="active">aktif</li>-->
    </ol>
  </section>        
 <section class="content container-fluid">

    <div class="col-md-6">
      <div class="box box-danger">
          <div class="box-header with-border">
            <h3 class="box-title">Add Category</h3>

            <div class="box-tools pull-right">
            </div>
          </div>
  <form action="/kamumau/people?action=create" method="post"> 
  <%@include file= "form.html" %>
  </form>
      </div>
    </div>
 </section>
  <hr>
</div>
</div> <!-- /container -->

</main>

<%@include file= "/layouts/footer.html" %>
