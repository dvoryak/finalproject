<%@include file="components/_header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<style>
    body {
        background-color:#fff;
        -webkit-font-smoothing: antialiased;
        font: normal 14px Roboto,arial,sans-serif;
    }

    .container {
        padding: 25px;
        position: static;
        align-content: center;
    }

    .form-register {
        width: 37%;
        margin-left: auto;
        margin-right: auto;
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


    .form-control {
        border-radius: 10px;
    }

    .wrapper {
        text-align: center;
    }



</style>

<body>

<div class="container form-register wrapper" >
    <form action="/" method="post">
        <div class="input-gr register-wrapper">
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.fname" bundle="${bundle}"/></span>
                <input type="text" name="firstName" class="form-control"
                       placeholder="<fmt:message key="client.firstName.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.lname" bundle="${bundle}"/></span>
                <input type="text" name="lastName" class="form-control"
                       placeholder="<fmt:message key="client.lastName.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.login" bundle="${bundle}"/></span>
                <input type="text" name="login" class="form-control"
                       placeholder="<fmt:message key="client.login.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.password" bundle="${bundle}"/></span>
                <input type="text" name="password" class="form-control"
                       placeholder="<fmt:message key="client.password.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon" ><fmt:message key="client.email" bundle="${bundle}"/></span>
                <input type="text" name="email" class="form-control"
                       placeholder="<fmt:message key="client.email.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="client.phone" bundle="${bundle}"/></span>
                <input type="text" name="phone" class="form-control"
                       placeholder="<fmt:message key="client.phone.hint" bundle="${bundle}"/>"/>
            </div>
            <br>

            <input name="command" value="register" type="hidden"/>

            <button type="submit" class="btn btn-success"><fmt:message key="front.register" bundle="${bundle}"/></button>

        </div>
    </form>
</div>


<%@include file="components/_footer.jsp"%>