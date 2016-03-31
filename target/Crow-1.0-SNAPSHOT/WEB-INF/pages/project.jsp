<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Project ${project.nameProject}</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>

<jsp:include page="head.jsp"/>
<div class="container" >
    <div class="row">
        <div class="col-sm-8 col-md-8" >
            <div class="thumbnail">
                <img class="img-thumbnail text-center" src="${project.image}" alt="placeholder image" style="width: 600px; height: 300px;"/>
                <div class="caption">
                    <h3 class="text-success text-center">${project.nameProject}</h3>
                    <p class="text-center">${project.donate_amount} pledged of ${project.needAmount} goal</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
                             aria-valuenow="${project.donate_amount/project.needAmount*100}" aria-valuemin="0"
                             aria-valuemax="100" style="width:${project.donate_amount/project.needAmount*100}%"/>
                    </div>
                    <span/>
                </div>
                <form class="text-center" action="/categories/${project.category.id}/projects/${project.id}/donate"
                      method="POST">
                    <input hidden name="projectId" value="${project.id}">
                    <input class="btn btn-success" type="submit" value="Donate"/>
                </form>
            </div>
            <div class="text-center">
                ${project.aboutProject}
            </div>
        </div>
    </div>
    <c:forEach items="${donates}" var="donate">
    <div class="col-sm-4 col-md-4" style="float: right; clear: right">
        <div class="thumbnail">
            <p>Donate : ${donate.amount}</p>
            <p>First Name : ${donate.user.firstName} </p>
            <p>Last Name : ${donate.user.lastName} </p>
            <p>email : ${donate.user.email} </p>
            <p>Date : ${donate.date.date}-${donate.date.month + 1}-${donate.date.year + 1900} </p>
        </div>
    </div>
    </c:forEach>
</div>

</div>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
</body>
</html>
