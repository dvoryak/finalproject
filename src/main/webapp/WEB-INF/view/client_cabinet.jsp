<%@page pageEncoding="UTF-8" %>
<%@include file="components/_header.jsp" %>

<style>
    .cab-navbar {
        align-content: center;
        text-align: center;
        background-color: grey;
        border-color: grey;
        font-size: 15px;
    }

    table {
        width: 100%;
        align-content: center;
        text-align: center;
    }

    .table a {
        color: crimson;
    }

    tr,td,th {
        align-content: center;
        text-align: center;
    }

</style>

<div class="list">
    <div class="container">
        <table id="table">
            <tr class="el">
                <th>№</th>
                <th>ID</th>
                <th>Date</th>
                <th>Institute name</th>
            </tr>
        </table>
    </div>
</div>


<script type="text/javascript" charset="UTF-8">
    document.onload(getList("unchecked"));

    function getList(name) {
        $.get('/?command=ajax', {status: name}, function (data) {
            $('td').remove();
            var data = $.parseJSON(data);
            for (var i = 0; i < data.length; i++) {
                $("#table")
                    .append('<tr class="el"> <td>' + (i + 1)+ ' </td>' +
                        '<td>' + data[i].id + '</td>' +
                        '<td>' + data[i].date + '</td>' +
                        '<td>' + data[i].institute + '</td>' +
                        '<td><a href="/?command=edit_page&id=' + data[i].id +'"> Edit </a></td>' +
                        '<td><a href="/?command=view_page&id=' + data[i].id +'"> View </a></td>' +
                        '</tr>')
            }

        });
    }

</script>


<%@include file="components/_footer.jsp" %>
