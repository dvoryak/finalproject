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
                <li class="active"><a href="#home" >Home</a></li>
                <li><a href="/?command=login_page" ><fmt:message key="front.logIn" bundle="${bundle}"/></a></li>
                <li><a href="/?command=register_page"><fmt:message key="front.register" bundle="${bundle}"/></a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right" >
                <li><a href="/?command=logout"><fmt:message key="front.logOut" bundle="${bundle}"/></a></li>
            </ul>
        </div>
    </div>
</nav>