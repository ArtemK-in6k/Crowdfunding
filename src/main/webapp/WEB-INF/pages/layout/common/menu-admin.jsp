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
            <a class="navbar-brand" href="/admin">Crowdfunding</a>
        </div>

        <div class="">
            <ul class="nav nav-tabs pull-right">
                <li role="presentation" class="active"><a href="/admin">Projects</a></li>
                <li role="presentation"><a href="/logout">Logout</a></li>
            </ul>
        </div>

    </div>
    <!-- /.container -->
</nav>