<%-- 
    Document   : add
    Created on : Nov 5, 2018, 11:24:10 AM
    Author     : ilyas
--%>


<%@include file="/layouts/header.jsp" %>
<link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <title>Tambah Data</title>
  <style><%@include file="/orders/style.css"%></style>
<html>
  
  
        <title>JSP Page</title>

    <body>
        <hr>
        <br>
        <br>
            <h5 style="margin: auto;
    width: 57%;padding: 10px;" > Input Order </h5>
    <br>   
    <div style="   margin: auto;
    width: 60%;
">
       
        <form action="orders?action=create" method="POST" style="margin: auto;
    width: 57%;
    border: 4px solid lime;
    padding: 10px; text-align: left;">
    <span>input id seller</span>
    <input style="margin-left: 24px;" name='id_seller'>
    <br>
    <br>
    <span>choose product</span>
    <select style="margin-left: 10px;" name="product">
    <option>---product---</option>       
    <option name="mouse" value='1'>mouse</option>
    <option name="lampu" value='2'>lampu</option>
    <option name="indomie" value='3'>indomie</option>
    </select>            
    <br>
    <br>
    <span>input qty</span>
    <input style="margin-left: 55px;" name='qty'>
            <br>
        <br>
        <button style="margin-left:40%;" type="submit" name="submit">simpan</button>
            </form>
        </div>
  </body>
</html>


<%@include file= "/layouts/footer.html" %>