<%@include file="components/_header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<style>
    body {
        background-color: #fff;
        -webkit-font-smoothing: antialiased;
        font: normal 14px Roboto, arial, sans-serif;
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
        border-color: #d2d2d2;
        border-width: 5px;
        box-shadow: 0 1px 0 #cfcfcf;
    }

    h4 {
        border: 0 solid #fff;
        border-bottom-width: 1px;
        padding-bottom: 10px;
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
                <form action="/" method="post">
                    <h4><fmt:message key="welcome" bundle="${bundle}"/></h4>
                    <input type="text" name="login" class="form-control input-sm chat-input"
                           placeholder="<fmt:message key="client.login" bundle="${bundle}"/>"/>
                    </br>
                    <input type="password" name="password" class="form-control input-sm chat-input"
                           placeholder="<fmt:message key="client.password" bundle="${bundle}"/>"/>
                    </br>
                    <div class="wrapper">
                        I'm an inspector <input type="checkbox" name="isInspector" value="true"/><br>
                        <input name="command" value="login" type="hidden">
                        <span class="group-btn">
                             <button type="submit" class="btn btn-success"><fmt:message key="front.logIn" bundle="${bundle}"/></button>
                        </span>
                    </div>
                </form>
            </div>
        </div>
    </div>
</div>

<%@include file="components/_footer.jsp" %>
