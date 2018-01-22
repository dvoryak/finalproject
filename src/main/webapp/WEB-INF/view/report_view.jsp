<%@page pageEncoding="UTF-8" %>
<%@include file="components/_header.jsp" %>

<div class="container">
    <div class="view-wrap">
        <span><fmt:message key="payer.firstName" bundle="${bundle}"/>  : ${sessionScope.report.payer.firstName}</span>
        <br>
        <span> <fmt:message key="payer.lastName" bundle="${bundle}"/>  : ${sessionScope.report.payer.lastName} </span>
        <br>
        <span><fmt:message key="payer.middleName" bundle="${bundle}"/> : ${sessionScope.report.payer.middleName}</span>
        <br>
        <span> <fmt:message key="payer.passport" bundle="${bundle}"/>  : ${sessionScope.report.payer.passport}</span>
        <br>
        <span> <fmt:message key="client.phone" bundle="${bundle}"/> : ${sessionScope.report.payer.phone}</span>
        <br>
        <span>  <fmt:message key="payer.city" bundle="${bundle}"/> : ${sessionScope.report.payer.city}  </span>
        <br>
        <span>  <fmt:message key="payer.street" bundle="${bundle}"/> : ${sessionScope.report.payer.street}  </span>
        <br>
        <span><fmt:message key="payer.home" bundle="${bundle}"/> : ${sessionScope.report.payer.home}</span>
        <br>
        <span><fmt:message key="report.date" bundle="${bundle}"/> : ${sessionScope.report.date}</span>
        <br>
        <span>  <fmt:message key="report.employeeNum" bundle="${bundle}"/> : ${sessionScope.report.employeeNumber}</span>
        <br>
        <span><fmt:message key="report.institute" bundle="${bundle}"/> : ${sessionScope.report.institute}</span>
        <br>
        <span><fmt:message key="front.activities" bundle="${bundle}"/>  </span>
        <br>
        <c:forEach items="${sessionScope.report.activities}" var="item">
            <span><fmt:message key="acivities.name" bundle="${bundle}"/> : ${item.name} </span>
            <br>
            <span><fmt:message key="activities.text" bundle="${bundle}"/> : ${item.text} </span>
            <br>
        </c:forEach>
        <br>
        <span><fmt:message key="front.message" bundle="${bundle}"/> : ${sessionScope.report.message}</span>
        <br>
    </div>
</div>

<%@include file="components/_footer.jsp" %>