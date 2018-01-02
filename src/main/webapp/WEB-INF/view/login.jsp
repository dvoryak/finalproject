<%@include file="components/_header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<style>
    body {
        background-color:#fff;
        -webkit-font-smoothing: antialiased;
        font: normal 14px Roboto,arial,sans-serif;
    }

    .container {
        padding: 25px;
        position: fixed;
    }

    .form-login {
        background-color: #EDEDED;
        padding-top: 10px;
        padding-bottom: 20px;
        padding-left: 20px;
        padding-right: 20px;
        border-radius: 15px;
        border-color:#d2d2d2;
        border-width: 5px;
        box-shadow:0 1px 0 #cfcfcf;
    }

    h4 {
        border:0 solid #fff;
        border-bottom-width:1px;
        padding-bottom:10px;
        text-align: center;
    }

    .form-control {
        border-radius: 10px;
    }

    .wrapper {
        text-align: center;
    }
</style>

<body>

<%@include file="components/_i18n.jsp" %>

<%@include file="components/_navbar.jsp" %>


<div class="container-fluid">
    <div class="row">
        <div class="col-md-offset-5 col-md-3">
            <div class="form-login">
                <h4><fmt:message key="welcome" bundle="${bundle}" /></h4>
                <input type="text" id="userName" class="form-control input-sm chat-input" placeholder="<fmt:message key="user.login" bundle="${bundle}"/>" />
                </br>
                <input type="text" id="userPassword" class="form-control input-sm chat-input" placeholder="<fmt:message key="user.password" bundle="${bundle}"/>" />
                </br>
                <div class="wrapper">
            <span class="group-btn">
                <a href="#" class="btn btn-primary btn-md"><fmt:message key="front.logIn" bundle="${bundle}" /> <i class="fa fa-sign-in"></i></a>
            </span>
                </div>
            </div>

        </div>
    </div>
</div>

<%@include file="components/_footer.jsp"%>
