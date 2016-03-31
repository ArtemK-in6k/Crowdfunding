<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="navbar-inverse navbar-custom" role="navigation">

    <div class="navbar-header text-left">
        <a class="navbar-brand text-center" href="/">Crowdfunding</a>
    </div>

    <div class="collapse navbar-collapse" style="background-color: palegoldenrod" id="bs-example-navbar-collapse-1">
        <div class="container">
            <div class="navbar-header navbar-right navbar">

            </div>
        </div>
        <form class="navbar-form navbar-right" role="search" action="/search" method="post">
            <div class="form-group">
                <input id="search" name="search" type="text" class="form-control" placeholder="Search">
                <select class="selectpicker" name="select">
                    <option value="project">by project name</option>
                    <option value="user">by user name</option>
                </select>
            </div>
            <button type="submit" class="btn btn-default">Search</button>
        </form>

    </div>


</nav>

