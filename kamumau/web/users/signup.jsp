<%-- 
    Document   : signup
    Created on : Oct 20, 2018, 7:40:55 PM
    Author     : Bagus
--%>

<%@include file= "/layouts/header.jsp" %>

<h4><c:out value='${message}' /></h4>
<main style="margin-top:7%;margin-bottom:5%;">
    <div class="container">
        <div class="row">
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-header">Please Sign Up</div>
                    <div class="card-body">
                        <form action="/kamumau/users?action=create" method="post">

                            <%@include file= "form.html" %>
                        </form>

                    </div>
                </div>
            </div>

        </div>
    </div>
</main>

<%@include file= "/layouts/footer.html" %>

<script>
    $('#password, #retype').on('keyup', function check() {
        if ($('#password').val() == $('#retype').val()) {
            $('#retype').html('Matching').css('color', 'green');
        } else
            $('#retype').html('Not Matching').css('color', 'red');
    });
</script>

<!--<script>
        function check(){
                if($("#password").val()==$("#retype").val()){
                        return true;
                        }else{
                        echo "<script>alert('password is not the same');history.go(-1)</script>";			

                        }
        

        }
</script> -->