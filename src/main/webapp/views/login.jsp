<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

    <!-- Дополнение к теме -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

    <!-- Последняя компиляция и сжатый JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>

    <title>Hello, world!</title>
</head>
<body>

<nav class="navbar navbar-default">
    <div class="row">
        <div class="col-sm-1 col-md-1 col-lg-1">
            <div class="navbar-header"  >
                <a class="navbar-brand" href="#">
                    Dvoryak
                </a>
            </div>
        </div>

        <div class="col-sm-10 col-md-10 col-lg-10">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home</a></li>
                <li><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
                <li><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages</a></li>
                <li><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings</a></li>
            </ul>
        </div>

        <div class="col-sm-1 col-md-1 col-lg-1">
            <button type="button" class="btn btn-default navbar-btn"> Register </button>
        </div>
    </div>
</nav>


<div class="container">
    <form action="/" method="post">
        Name: <input type="text" name="name" /> Password:<input
            type="password" name="password" /> <input type="submit"
                                                      value="Login" />
    </form>
</div>

</body>

</html>
