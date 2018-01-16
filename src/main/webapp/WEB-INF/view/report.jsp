<%@include file="components/_header.jsp" %>
<%@page pageEncoding="UTF-8" %>


<div class="container form-report report-wrapper" >
    <form action="/" method="post">
        <div class="input-gr register-wrapper report-form">
            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="payer.firstName" bundle="${bundle}"/></span>
                <input type="text" name="firstName" class="form-control"/>
            </div>
            <br>

            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="payer.lastName" bundle="${bundle}"/></span>
                <input type="text" name="lastName" class="form-control"/>
            </div>
            <br>

            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="payer.middleName" bundle="${bundle}"/></span>
                <input type="text" name="middleName" class="form-control"/>
            </div>
            <br>

            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="payer.phone" bundle="${bundle}"/></span>
                <input type="text" name="phone" class="form-control"/>
            </div>
            <br>

            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="payer.passport" bundle="${bundle}"/></span>
                <input type="text" name="passport" class="form-control"/>
            </div>
            <br>


            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="payer.city" bundle="${bundle}"/></span>
                <input type="text" name="city" class="form-control"/>
            </div>
            <br>

            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="payer.street" bundle="${bundle}"/></span>
                <input type="text" name="street" class="form-control"/>
            </div>
            <br>

            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="payer.home" bundle="${bundle}"/></span>
                <input type="text" name="home" class="form-control"/>
            </div>
            <br>

            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="report.institute" bundle="${bundle}"/></span>
                <input type="text" name="institute" class="form-control"/>
            </div>
            <br>

            <div class="input-group input-group-lg">
                <span class="input-group-addon"><fmt:message key="report.employeeNum" bundle="${bundle}"/></span>
                <input type="text" name="employeeNum" class="form-control"/>
            </div>
            <br>

            <div class='input-group input-group-lg'>
                <span class='input-group-addon'><fmt:message key='report.date' bundle='${bundle}'/></span>
                <input type='text' name='date' class='form-control'/>
            </div>
            <br>


            <div class='activity'>
                <span class='input-group-addon'></span>
                <div class='input-group input-group-lg'>
                    <span class='input-group-addon'><fmt:message key='acivities.name' bundle='${bundle}'/></span>
                    <input type='text' name='name' class='form-control'/>
                </div>
                <br>
                <div class='input-group input-group-lg'>
                    <span class='input-group-addon'><fmt:message key='activities.text' bundle='${bundle}'/></span>
                    <input type='text' name='text' class='form-control'/>
                </div>
                <br>
            </div>

            <input name="command" value="create_report" type="hidden"/>
            </div>
            <div class="rep">
                <a name="addActivity" href="#" onclick="addActivity()"> <fmt:message key="report.addActivity" bundle="${bundle}"/> </a>
            </div>
            <br>
            <button type="submit" class="btn btn-success"><fmt:message key="front.done" bundle="${bundle}"/></button>
    </form>
</div>

<script>
    function addActivity() {
        $(".report-form").append(" <div class='activity'>\n" +
            "                <span class='input-group-addon'></span>\n" +
            "                <div class='input-group input-group-lg'>\n" +
            "                    <span class='input-group-addon'><fmt:message key='acivities.name' bundle='${bundle}'/></span>\n" +
            "                    <input type='text' name='name' class='form-control'/>\n" +
            "                </div>\n" +
            "                <br>\n" +
            "                <div class='input-group input-group-lg'>\n" +
            "                    <span class='input-group-addon'><fmt:message key='activities.text' bundle='${bundle}'/></span>\n" +
            "                    <input type='text' name='text' class='form-control'/>\n" +
            "                </div>\n" +
            "                <br>\n" +
            "            </div>");
    }
</script>


<%@include file="components/_footer.jsp" %>