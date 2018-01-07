<%@page pageEncoding="UTF-8" %>
<%@include file="components/_header.jsp" %>
<%@include file="components/_i18n.jsp" %>
<%@include file="components/_navbar.jsp" %>

<style>
    .text-tz-wrapper {
        font-size: 20px;
    }
</style>
<div class="text-tz-wrapper container">
    <p> Система Подачи Отчетов в Налоговую. Физ./Юр.лицо (далее
        Пользователь) регистрируется. Подает отчет (XML/JSON/Форма).
        Налоговый Инспектор принимает/отклоняет отчет (указывая причину
        отказа). Пользователь может просмотреть все поданные отчеты, причины
        отказа и изменять их если того потребовал Инспектор. Пользователь может
        отправлять запрос на замену Инспектора в случае неудовлетворения.
    </p>
</div>
<%@include file="components/_footer.jsp" %>
