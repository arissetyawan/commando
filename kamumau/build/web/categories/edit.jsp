<%-- 
    Document   : edit
    Created on : Oct 17, 2018, 8:39:20 PM
    Author     : alibudi
--%>

<%@page language= "java" contentType="text/html; charset=UTF-8" pageEncoding="UTF8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@include file= "/layouts/header.jsp" %>
<div class="container">
    <div class="content-wrapper">
        <section class="content-header">
    <h1>
      Category
      <small>Edit Category</small>
    </h1>
    <ol class="breadcrumb">
      <li><a href=""><i class="fa fa-map-marker"></i> Edit Category</a></li>
      <!--<li class="active">aktif</li>-->
    </ol>
  </section> 
 <section class="content container-fluid">
<div class="col-md-6">
      <div class="box box-danger">
          <div class="box-header with-border">
            <h3 class="box-title">Edit Category</h3>

            <div class="box-tools pull-right">
            </div>
          </div>
        <form action="/jsp/category?action=update&id=<c:out value='${category.getId()}' />" method="post"> 
        <%@include file= "editt.html" %>
        </form>
        <br>
        <p>System will reject removal for any category or product whitch already
            have an order/products It means your code has to find to all orders 
            and all products at the first before removal</p>
 </div>
    </div>
 </section>
    </div>
</div>