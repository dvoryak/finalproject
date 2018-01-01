<nav class="navbar navbar-default">
    <div class="row">
        <div class="col-sm-1 col-md-1 col-lg-1">
            <div class="navbar-header"  >
                <a class="navbar-brand" href="#">
                    Dvoryak
                </a>
            </div>
        </div>

        <div class="col-sm-9 col-md-9 col-lg-9">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#home" >Home</a></li>
                <li><a href="#profile" >Profile</a></li>
                <li><a href="#messages">Messages</a></li>
                <li><a href="#settings">Settings</a></li>
            </ul>
        </div>

        <div class="col-sm-2 col-md-2 col-lg-2">
            <form action="/views/login.jsp" method="POST" style="margin-top: 7px; margin-bottom: 0">
                <select name="lang" class="input-medium bfh-languages" data-language="en">
                    <option value="en">English</option>
                    <option value="ua">Ukraine</option>
                </select>
                <input type="submit" value="Change">
            </form>
            <button type="button" class="btn btn-default navbar-btn"><fmt:message key="front.register" bundle="${bundle}"/></button>
        </div>
    </div>
</nav>