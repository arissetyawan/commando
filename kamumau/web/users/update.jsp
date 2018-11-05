<%@include file= "/layouts/navbar_logged_in.jsp" %>

<main style="margin-top:7%;margin-bottom:5%;">
    <div class="container">
        <div class="row">
            <div class="col-sm-8">
                <div class="card">
                    <div class="card-header">My Profile</div>
                    <div class="card-body">
                        <form action="/kamumau/people?action=update&id=<c:out value='${person.getId()}' />" method="post">

                            <%@include file= "update.html" %>

                        </form>

                    </div>
                </div>
            </div>

        </div>
    </div>
</main>

<%@include file= "/layouts/footer.html" %>