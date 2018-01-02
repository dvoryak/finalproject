<c:set var="lang" value="${cookie.lang.value}" scope="session"/>
<fmt:setLocale value="${empty sessionScope.lang ? 'en' : sessionScope.lang}"/>
<fmt:setBundle basename="/i18n/message" var="bundle" scope="session"/>