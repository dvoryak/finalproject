<%@ page import="dao.PullTest" %>
<%@page contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title> Test</title>
</head>
<body>
<%
    PullTest pullTest = new PullTest();
    String userName = pullTest.getUserName();
    out.println(userName);
%>
</body>

</html>
