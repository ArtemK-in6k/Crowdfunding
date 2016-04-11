<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Navigation -->
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <!-- navbar-brand is hidden on larger screens, but visible when the menu is collapsed -->
            <a class="navbar-brand" href="/">Crowdfunding</a>
        </div>
        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="">
            <form class="form-inline pull-right" style="line-height: 50px" role="search" action="/search"
                  method="post">
                <div class="form-group">
                    <input id="search" name="search" type="text" class="form-control" placeholder="Search">
                    <select class="selectpicker" name="select">
                        <option value="project">by project name</option>
                        <option value="user">by full name</option>
                    </select>
                    <button type="submit" class="btn btn-default">Search</button>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                </div>
                <a class="btn btn-default" href="/logout">Logout</a>
            </form>
        </div>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container -->
</nav>
