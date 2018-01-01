<%@include file="_header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<body>

<fmt:setBundle basename="/i18n/message" var="bundle" scope="session"/>
<%@include file="_navbar.jsp" %>

<div class="container" >
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


</body>

</html>