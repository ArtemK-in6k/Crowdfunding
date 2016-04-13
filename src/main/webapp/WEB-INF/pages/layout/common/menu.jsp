<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!-- Navigation -->
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div class="navbar-header">

            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand logo-img" rel="home" title="Crowdfunding">
            </a>
            <a class="navbar-brand title-text" href="/">Crowdfunding</a>
        </div>
        <div class="">
            <form class="form-inline pull-right search-box-form" role="search" action="/search"
                  method="post">
                <div class="form-group">
                    <input id="search" name="search" type="text" class="form-control" placeholder="Search" required>
                    <select class="selectpicker" name="select">
                        <option value="project">by project name</option>
                        <option value="user">by full name</option>
                    </select>
                    <button type="submit" class="btn btn-default">Search</button>
                    <input type="hidden" name="${_csrf.parameterName}"
                           value="${_csrf.token}"/>
                    <a class="btn btn-default" href="/logout">Logout</a>
                </div>
            </form>
        </div>
    </div>
</nav>
