<%@page pageEncoding="UTF-8" %>
<style>
    ul.my-footer li {
        display: inline;
        color: #2f2f2f;
        margin-right: 5px;
        padding: 3px;
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