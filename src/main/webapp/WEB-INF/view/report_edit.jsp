<%@page pageEncoding="UTF-8" %>
<%@include file="components/_header.jsp" %>

<div class="container">
    <div class="edit-wrap">
        <form action="/" method="post">
            <input type="hidden" name="command" value="report_edit">
            <c:set var="report" scope="request" value="${report}"/>
            <span><fmt:message key="payer.firstName" bundle="${bundle}"/>  :
            <input name="firstName" type="text"  placeholder="${sessionScope.report.payer.firstName}"/>  </span>
            <br>
            <span> <fmt:message key="payer.lastName" bundle="${bundle}"/>  :
        <input name="lastName" type="text" placeholder="${sessionScope.report.payer.lastName}"/></span>
            <br>
            <span><fmt:message key="payer.middleName" bundle="${bundle}"/> :
        <input name="middleName" type="text" placeholder="${sessionScope.report.payer.middleName}"/></span>
            <br>
            <span> <fmt:message key="payer.passport" bundle="${bundle}"/>  :
        <input name="passport" type="text" placeholder="${sessionScope.report.payer.passport}"/></span>
            <br>
            <span> <fmt:message key="payer.phone" bundle="${bundle}"/> :
        <input name="phone" type="text" placeholder="${sessionScope.report.payer.phone}"/></span>
            <br>
            <span>  <fmt:message key="payer.city" bundle="${bundle}"/> :
        <input name="city" type="text" placeholder="${sessionScope.report.payer.city} "/></span>
            <br>
            <span>  <fmt:message key="payer.street" bundle="${bundle}"/> :
        <input name="street" type="text" placeholder="${sessionScope.report.payer.street}"/></span>
            <br>
            <span><fmt:message key="payer.home" bundle="${bundle}"/> :
        <input name="home" type="text" placeholder="${sessionScope.report.payer.home}"/></span>
            <br>
            <span><fmt:message key="report.date" bundle="${bundle}"/> :
        <input name="date" type="text" placeholder="${sessionScope.report.date}"/></span>
            <br>
            <span>  <fmt:message key="report.employeeNum" bundle="${bundle}"/> :
        <input name="employeeNumber" type="text" placeholder="${sessionScope.report.employeeNumber}"/> </span>
            <br>
            <span><fmt:message key="report.institute" bundle="${bundle}"/> :
        <input name="institute" type="text" placeholder="${sessionScope.report.institute}" size="30"/></span>
            <br>
            <span> <fmt:message key="front.activities" bundle="${bundle}"/> : </span>
            <br>

            <c:forEach items="${sessionScope.report.activities}" var="item">
            <span><fmt:message key="acivities.name" bundle="${bundle}"/> :
            <input name="name" type="text" placeholder="${item.name}"/></span>
                <br>
                <span><fmt:message key="activities.text" bundle="${bundle}"/> :
            <input name="text" type="text" placeholder="${item.text} "/></span>
                <br>
            </c:forEach>

            <input type="hidden" name="id" value="${param.id}">
            <button type="submit" class="btn btn-success"><fmt:message key="front.done" bundle="${bundle}"/></button>
        </form>
    </div>
</div>

</br>
<%@include file="components/_footer.jsp" %>