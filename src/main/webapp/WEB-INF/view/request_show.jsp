<%@page pageEncoding="UTF-8" %>
<%@include file="components/_header.jsp"%>

<div class="container-fluid" style="text-align: center">
    <h5>Requests</h5>
    <c:forEach items="${sessionScope.requests}" var="req" >
        <span> ID : ${req.id} </span>
        <span> TEXT : ${req.text} </span>
        <br>
    </c:forEach>
</div>

<%@include file="components/_footer.jsp"%>

