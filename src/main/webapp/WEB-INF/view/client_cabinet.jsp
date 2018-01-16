<%@include file="components/_header.jsp" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>

<div class="list">
    <div class="container">
        <table id="table">
            <tr class="el">
                <th>№</th>
                <th><fmt:message key="front.id" bundle="${bundle}"/> </th>
                <th><fmt:message key="front.payer" bundle="${bundle}"/></th>
                <th><fmt:message key="front.date" bundle="${bundle}"/></th>
                <th><fmt:message key="front.institute" bundle="${bundle}"/></th>
            </tr>
        </table>
    </div>
</div>

<div class="empty-list container">
    <h2><fmt:message key="front.emptyList" bundle="${bundle}"/></h2>
</div>


<script type="text/javascript" charset="UTF-8">
    document.onload(getList("unchecked"));

    function getList(name) {
        $.get('/?command=ajax', {status: name}, function (data) {
            $('td').remove();
            var data = $.parseJSON(data);
            if(data.length == 0) {
                $(".list").css("visibility","hidden");
                $(".empty-list").css("visibility","visible");
            } else {
                $(".empty-list").css("visibility","hidden");
            }
            for (var i = 0; i < data.length; i++) {
                $(".list").css("visibility","visible");
                $("#table")
                    .append('<tr class="el"> <td>' + (i + 1)+ ' </td>' +
                        '<td>' + data[i].id + '</td>' +
                        '<td>' + data[i].payer.firstName + ' ' + data[i].payer.lastName + '</td>' +
                        '<td>' + data[i].date + '</td>' +
                        '<td>' + data[i].institute + '</td>' +
                        '<td><a href="/?command=edit_page&id=' + data[i].id +'"> <fmt:message key='front.edit' bundle='${bundle}'/> </a></td>' +
                        '<td><a href="/?command=view_page&id=' + data[i].id +'"> <fmt:message key='front.view' bundle='${bundle}'/> </a></td>' +
                        '</tr>')
            }
        });
    }

</script>


<%@include file="components/_footer.jsp" %>
