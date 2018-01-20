<%@include file="components/_header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<%@taglib prefix="ctg" uri="customtags" %>

<div style="text-align: right">
    <ctg:custom-tag/>
</div>


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
                        <fmt:message key="front.isInspector" bundle="${bundle}"/> <input type="checkbox" name="isInspector" value="true"/><br>
                        <input name="command" value="login" type="hidden">
                        <span class="group-btn">
                             <button type="submit" class="btn btn-success"><fmt:message key="front.logIn" bundle="${bundle}"/></button>
                        </span>
                    </div>
                </form>
            </div>
            <c:if test="${error == 'true'}">
                <h5 style="color: red; text-align: center"><fmt:message key="client.wrong.input" bundle="${bundle}"/></h5>
            </c:if>
        </div>
    </div>
</div>

<%@include file="components/_footer.jsp" %>
