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
        position: static;
        align-content: center;
    }

    .form-register {
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

<%@include file="components/_i18n.jsp"%>
<%@include file="components/_navbar.jsp" %>

<div class="container form-register wrapper" >
    <form>
        <div class="input-gr">
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="user.fname" bundle="${bundle}"/></span>
                <input type="text" name="firstName" class="form-control"
                       placeholder="<fmt:message key="user.firstName.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="user.lname" bundle="${bundle}"/></span>
                <input type="text" name="lastName" class="form-control"
                       placeholder="<fmt:message key="user.lastName.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="user.login" bundle="${bundle}"/></span>
                <input type="text" name="login" class="form-control"
                       placeholder="<fmt:message key="user.login.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="user.password" bundle="${bundle}"/></span>
                <input type="text" name="password" class="form-control"
                       placeholder="<fmt:message key="user.password.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon" ><fmt:message key="user.email" bundle="${bundle}"/></span>
                <input type="text" name="email" class="form-control"
                       placeholder="<fmt:message key="user.phone.hint" bundle="${bundle}"/>"/>
            </div>
            <br>
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="user.phone" bundle="${bundle}"/></span>
                <input type="text" name="phone" class="form-control"
                       placeholder="<fmt:message key="user.email.hint" bundle="${bundle}"/>"/>
            </div>
            <br>

            <button type="submit" class="btn btn-success"><fmt:message key="front.register" bundle="${bundle}"/></button>

        </div>
    </form>
</div>


<%@include file="components/_footer.jsp"%>