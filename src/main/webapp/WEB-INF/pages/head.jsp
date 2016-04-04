<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="navbar-inverse navbar-custom" role="navigation">

    <div class="collapse navbar-collapse" style="background-color: palegoldenrod" id="bs-example-navbar-collapse-1">
            <div class="navbar-header navbar-left navbar">
                <a class="navbar-brand text-left" style="line-height: 40px" href="/">Crowdfunding</a>
            </div>

        <form class="navbar-form navbar-right" style="line-height: 50px" role="search" action="/search" method="post">
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

