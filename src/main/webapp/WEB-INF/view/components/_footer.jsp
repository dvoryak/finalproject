<%@page pageEncoding="UTF-8" %>

<style>
    ul.my-footer li {
        display: inline;
        color: #2f2f2f;
        margin-right: 5px;
        padding: 21px;
        align-content: center;
    }
    .my-footer a {
        color: #f2f2f2;
    }
    .my-footer a:hover, a:focus {
        color: coral;
        text-decoration: none;
        outline: 0;
    }
    .container {
        text-align: center;
    }
</style>

<div class="container">
    <div class="navbar navbar-default navbar-fixed-bottom">
        <ul class="my-footer">
            <li><a href="/?command=LANGUAGE_CHANGE&lang=en" > English </a></li>
            <li><a href="/?command=LANGUAGE_CHANGE&lang=ua" > Українська </a></li>
            <li><a href="/?command=LANGUAGE_CHANGE&lang=ru" > Русский </a></li>
        </ul>
    </div>
</div>

<c:set var="langf" value="${cookie.lang.value}" scope="session"/>
<fmt:setLocale value="${empty sessionScope.langf ? 'en' : sessionScope.langf}"/>
<fmt:setBundle basename="/i18n/message" var="bundle" scope="session"/>
</body>