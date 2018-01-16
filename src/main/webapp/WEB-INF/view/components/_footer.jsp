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
            <li><a href="/${page}?command=LANGUAGE_CHANGE&lang=en&page=${page}" > English </a></li>
            <li><a href="/${page}?command=LANGUAGE_CHANGE&lang=ua&page=${page}" > Українська </a></li>
            <li><a href="/${page}?command=LANGUAGE_CHANGE&lang=ru&page=${page}" > Русский </a></li>
        </ul>
    </div>
</div>

<c:set var="lang" value="${cookie.lang.value}" scope="session"/>
<fmt:setLocale value="${empty sessionScope.lang ? 'en' : sessionScope.lang}"/>
<fmt:setBundle basename="/i18n/message" var="bundle" scope="session"/>
</body>