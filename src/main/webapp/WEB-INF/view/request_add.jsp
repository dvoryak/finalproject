<%@page pageEncoding="UTF-8" %>
<%@include file="components/_header.jsp"%>

<div class="req-add-form container">
    <form method="post" action="/">
        <input type="hidden" name="command" value="request_add">
        <textarea name="text" rows="8"> </textarea>
        <br>
        <button type="submit" class="btn btn-success"><fmt:message key="front.done" bundle="${bundle}"/></button>
    </form>
</div>

<%@include file="components/_footer.jsp"%>
