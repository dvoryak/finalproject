<%@page pageEncoding="UTF-8" %>
<%@include file="components/_header.jsp" %>
<%@include file="components/_i18n.jsp" %>
<%@include file="components/_navbar.jsp" %>

<style>
    .cab-navbar {
        align-content: center;
        text-align: center;
        background-color: grey;
        border-color: grey;
        font-size: 15px;
    }

</style>
<div class="cab-navbar">
    <nav class="navbar cab-navbar">
        <div class="container-fluid row">
            <div class="navbar-header">
            </div>
            <div class="collapse navbar-collapse" id="navbar-main">
                <div class="col-sm-4 col-md-4 col-lg-4">
                    <a href="#">Active</a>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-4">
                    <a href="#">Not Active</a>
                </div>
                <div class="col-sm-4 col-md-4 col-lg-4">
                    <a href="#">Unchecked</a>
                </div>
            </div>
        </div>
    </nav>
</div>


<%@include file="components/_footer.jsp" %>
