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
        <div class="nav navbar-header navbar-right nav-pills">
            <form class="form-inline pull-right search-box-form" role="search" action="/search"
                  method="post">
                <div class="form-group">
                    <input id="search" name="search" type="text" class="form-control" placeholder="Search project"
                           required>
                    <input hidden name="select" value="project">
                    <button type="submit" class="btn btn-default">Search</button>
                    <div id="dropdown-button" class="dropdown form-group">
                        <button class="btn btn-default dropdown-toggle form-group" type="button"
                                data-toggle="dropdown">${userBean.firstName } ${userBean.lastName}
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="/control/projects">My projects</a></li>
                            <li><a href="/control/donates">My donates</a></li>
                            <li><a href="/logout">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </form>
        </div>
    </div>
</nav>
