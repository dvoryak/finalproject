<%@include file="_header.jsp"%>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<body>

<c:set var="language" scope="session" value="${param.lang}"/>
<fmt:setLocale value="${sessionScope.language}"/>
<fmt:setBundle basename="/i18n/message" var="bundle" scope="session"/>

<%@include file="_navbar.jsp"%>

<div class="container">
    <form action="/" method="post">
        Name: <input type="text" name="name" /> Password:<input
            type="password" name="password" /> <input type="submit"
                                                      value="Login" />
    </form>
</div>

</body>

</html>
