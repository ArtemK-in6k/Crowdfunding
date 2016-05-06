<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Navigation -->
<script src="<c:url value="/resources/angular/search/SearchCtrl.js" />"></script>
<nav class="navbar navbar-default" role="navigation">
    <div class="container">
        <div ng-controller="SearchController" class="navbar-header">
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
            <div class="form-inline pull-right search-box-form">
                <div class="form-group">
                    <div class="padded-row form-group">
                        <angucomplete class="form-group"
                                      id="projects"
                                      placeholder="Search projects"
                                      pause="200"
                                      selectedobject="selectedObject"
                                      url="/search?search="
                                      titlefield="nameProject"
                                      imagefield="image"
                                      minlength="2"
                                      inputclass="form-control form-control-small"/>
                    </div>
                    <div id="dropdown-button" class="dropdown form-group">
                        <button class="btn btn-default dropdown-toggle form-group" type="button"
                                data-toggle="dropdown">${userBean.firstName } ${userBean.lastName}
                            <span class="caret"></span></button>
                        <ul class="dropdown-menu">
                            <li><a href="/control">Dashboard</a></li>
                            <li><a href="/logout">Logout</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
</nav>
