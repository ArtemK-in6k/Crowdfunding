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
<div class="container">
    <div class="row">
            <div class="col-sm-8 col-md-8">
                <div class="thumbnail">
                    <img class="img-thumbnail text-center" src="http://dummyimage.com/600x300/000000/fff" alt="placeholder image"/>
                    <div class="caption">
                        <p class="lead text-center">Donate amount: ${project.donate_amount}</p>
                        <p class="lead text-center">Need amount: ${project.needAmount}</p>
                        <form class="text-center" action="/categories/${project.category.id}/projects/${project.id}/donate" method="POST">
                            <input hidden name="projectId" value="${project.id}">
                            <input class="btn btn-success" type="submit" value="Donate"/>
                        </form>
                    </div>
                    <div class="text-center">
                        ${project.aboutProject}
                    </div>
                </div>
            </div>
            <%--<c:forEach >--%>
                <%--<div class="col-sm-4 col-md-4">--%>
                <%--</div>--%>
            <%--</c:forEach>--%>
    </div>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
</body>
</html>
