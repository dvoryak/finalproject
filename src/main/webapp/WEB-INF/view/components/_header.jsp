<!doctype html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page contentType="text/html" pageEncoding="UTF-8" %>

<html lang="en" >
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


    <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.2.0/jquery.min.js"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
          integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
          crossorigin="anonymous">

    <!-- Дополнение к теме -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
          integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
          crossorigin="anonymous">

    <!-- Последняя компиляция и сжатый JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"
            integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa"
            crossorigin="anonymous"></script>

    <link rel="stylesheet" href="../style.css">


    <title></title>
</head>
<body>
<c:set var="lang" value="${cookie.lang.value}" scope="session"/>
<fmt:setLocale value="${empty sessionScope.lang ? 'en' : sessionScope.lang}"/>
<fmt:setBundle basename="/i18n/message" var="bundle" scope="session"/>

<style>
    body{
        background-color: #f2f2f2;
        color: #555;
    }
    a:hover, a:focus {
        color: coral;
        text-decoration: none;
        outline: 0;
    }
    a{
        color: aqua;
    }

    .navbar {
        font-weight: 800;
        font-size: 14px;
        padding-top: 15px;
        padding-bottom: 15px;
        background: #2d2d2d;
        border-color: #2d2d2d;
    }

</style>

<nav class="navbar navbar-default">
    <div class="row container-fluid">
        <div class="col-sm-1 col-md-1 col-lg-1">
            <div class="navbar-header"  >
                <a class="navbar-brand" href="#">
                    Dvoryak
                </a>
            </div>
        </div>

        <div class="col-sm-11 col-md-11 col-lg-11">
            <ul class="nav navbar-nav">
                <li class="dropdown">
                    <a href="/cabinet?command=client_cabinet" data-toggle="dropdown" class="dropdown-toggle">
                        <fmt:message key="front.cabinet" bundle="${bundle}"/>
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="/cabinet?command=client_cabinet" > <fmt:message key="front.cabinet" bundle="${bundle}"/></a></li>
                        <li><a href="#" onclick="getList('ok')" >Ok</a></li>
                        <li><a href="#" onclick="getList('failed')">Failed</a></li>
                        <li><a href="#" onclick="getList('unchecked')">Unchecked</a></li>
                        <li class="divider"></li>
                        <li><a href="/add?command=report_page">Add reports</a></li>
                    </ul>
                </li>
                <li><a href="/login?command=login_page" ><fmt:message key="front.logIn" bundle="${bundle}"/></a></li>
                <li><a href="/register?command=register_page"><fmt:message key="front.register" bundle="${bundle}"/></a></li>
                <li><a href="/?command=about_us"><fmt:message key="front.site" bundle="${bundle}"/></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" >
                <c:if test="${sessionScope.user != null}">
                    <li><a><fmt:message key="front.signedAs" bundle="${bundle}"/>  ${sessionScope.user.firstName} ${sessionScope.user.lastName}</a></li>
                </c:if>
                <li><a href="/logout?command=logout"><fmt:message key="front.logOut" bundle="${bundle}"/></a></li>
            </ul>
        </div>
    </div>
</nav>