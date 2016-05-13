<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="ROOT" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>test-oauth2-google</title>

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css"
          integrity="sha512-dTfge/zgoMYpP7QbHy4gWMEGsbsdZeCXz7irItjcC3sPUFtf0kuFbDz/ixG7ArTxmDjLXDmezHubeNikyKGVyQ=="
          crossorigin="anonymous">
</head>
<body data-spy="scroll" data-target="#home-left-navbar" data-offset="100">

<nav class="navbar navbar-inverse navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#header-navbar-collapse" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <span>test-oauth2-google</span>
            </a>
        </div>

        <div id="header-navbar-collapse" class="collapse navbar-collapse">
            <ul class="nav navbar-nav navbar-right">
                <li><a href="${ROOT}">Log In</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="row">
        <br/><br/>
        <div class="page-header">
            <h2>You have successfully logged out!</h2>
        </div>

        <p class="lead">Your Google access token is revoked, session is invalidated and authentication object is
            cleared.</p>
    </div>
</div>

<div class="container">
    <div class="row">
        <br/><br/>
        <div class="page-header">
            <h2>Welcome ${profile.givenName}!</h2>
        </div>

        <table width="600px">
            <tr>
                <th width="20%">ID</th>
                <td width="80%">${profile.id}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${profile.email}</td>
            </tr>
            <tr>
                <th>Verified Email</th>
                <td>${profile.verifiedEmail}</td>
            </tr>
            <tr>
                <th>Name</th>
                <td>${profile.name}</td>
            </tr>
            <tr>
                <th>Given Name</th>
                <td>${profile.givenName}</td>
            </tr>
            <tr>
                <th>Family Name</th>
                <td>${profile.familyName}</td>
            </tr>
            <tr>
                <th>Link</th>
                <td><a href="${profile.link}">${profile.link}</a></td>
            </tr>
            <tr>
                <th>Picture</th>
                <td><img src="${profile.picture}"></td>
            </tr>
            <tr>
                <th>Gender</th>
                <td>${profile.gender}</td>
            </tr>
            <tr>
                <th>Locale</th>
                <td>${profile.locale}</td>
            </tr>
            <tr>
                <th>Hosted Domain</th>
                <td>${profile.hd}</td>
            </tr>
        </table>
    </div>
</div>

</body>
</html>
