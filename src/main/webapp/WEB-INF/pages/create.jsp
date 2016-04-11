<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<style>
    .fig {
        text-align: center;
    }
</style>

<div class="row">
    <div class="col-md-4">
        <nav class="navmenu navmenu-default" role="navigation">
            <div>
                <h4 class="text-success" style="text-indent: 60px">Categories</h4>
                <ul class="nav navmenu-nav" style="width: 200px">
                    <c:forEach items="${categories}" var="category">
                        <li>
                            <a style="background-color: lightsteelblue" href="/categories/${category.id}/"
                               class="list-group-item">${category.title}</a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </nav>
    </div>
    <div class="col-md-4">
        <div class="text-center fig">

            <img src="${project.image}" alt="" style="width: 400px; height: 400px;">
            <h2>Thank you for creation ${project.nameProject}</h2>

            <form action="/" method="get">
                <input class="btn btn-success" type="submit" value="Go to the main page"/>

            </form>
        </div>
    </div>
</div>
