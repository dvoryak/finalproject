<%@page pageEncoding="UTF-8" %>
<%@include file="components/_header.jsp" %>

<style>
    .view-wrap {
        text-align: left;
    }

    .view-wrap span {
        font-size: 21px;
        text-align: left;
    }
</style>

<div class="container">
    <div class="view-wrap">
        <span><fmt:message key="payeer.firstName" bundle="${bundle}"/>  : ${sessionScope.report.payer.firstName}</span>
        <br>
        <span> <fmt:message key="payeer.lastName" bundle="${bundle}"/>  : ${sessionScope.report.payer.lastName} </span>
        <br>
        <span><fmt:message key="payeer.middleName" bundle="${bundle}"/> : ${sessionScope.report.payer.middleName}</span>
        <br>
        <span> <fmt:message key="payeer.passport" bundle="${bundle}"/>  : ${sessionScope.report.payer.passport}</span>
        <br>
        <span> <fmt:message key="client.phone" bundle="${bundle}"/> : ${sessionScope.report.payer.phone}</span>
        <br>
        <span>  <fmt:message key="payer.city" bundle="${bundle}"/> : : ${sessionScope.report.payer.city}  </span>
        <br>
        <span>  <fmt:message key="payeer.street" bundle="${bundle}"/> : : ${sessionScope.report.payer.street}  </span>
        <br>
        <span><fmt:message key="payeer.home" bundle="${bundle}"/> : ${sessionScope.report.payer.home}</span>
        <br>
        <span><fmt:message key="report.date" bundle="${bundle}"/> : ${sessionScope.report.date}</span>
        <br>
        <span>  <fmt:message key="report.employeeNum" bundle="${bundle}"/> : ${sessionScope.report.employeeNumber}</span>
        <br>
        <span><fmt:message key="report.institute" bundle="${bundle}"/> : ${sessionScope.report.institute}</span>
        <br>
        <span> Activities : </span>
        <br>
        <c:forEach items="${sessionScope.report.activities}" var="item">
            <span><fmt:message key="acivities.name" bundle="${bundle}"/> : ${item.name} </span>
            <br>
            <span><fmt:message key="activities.text" bundle="${bundle}"/> : ${item.text} </span>
            <br>
        </c:forEach>
    </div>
</div>

<%@include file="components/_footer.jsp" %>