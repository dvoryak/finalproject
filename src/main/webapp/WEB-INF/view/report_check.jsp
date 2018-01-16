<%@include file="components/_header.jsp"%>
<%@page pageEncoding="UTF-8" %>

<div class="container">
    <div class="view-wrap">
        <span name="id"> id : ${param.id}</span>
        <br>
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
        <span>  <fmt:message key="payer.city" bundle="${bundle}"/> : : ${sessionScope.report.payer.city}  </span>
        <br>
        <span>  <fmt:message key="payer.street" bundle="${bundle}"/> : : ${sessionScope.report.payer.street}  </span>
        <br>
        <span><fmt:message key="payer.home" bundle="${bundle}"/> : ${sessionScope.report.payer.home}</span>
        <br>
        <span><fmt:message key="report.date" bundle="${bundle}"/> : ${sessionScope.report.date}</span>
        <br>
        <span>  <fmt:message key="report.employeeNum"
                             bundle="${bundle}"/> : ${sessionScope.report.employeeNumber}</span>
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
        <br>
    </div>
</div>

<form method="post" action="/">
    <div class="container-fluid check-form">
        <textarea rows="5" name="message">
        </textarea>
        <br>
        <input type="hidden" name="id" value="${param.id}">
        <input type="hidden" name="command" value="report_check">
        <button class="btn btn-success" value="OK" type="submit" name="status"> Accept</button>
        <button class="btn btn-danger" value="FAILED" type="submit" name="status"> Decline</button>
    </div>
</form>



<%@include file="components/_footer.jsp"%>