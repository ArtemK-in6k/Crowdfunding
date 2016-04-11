<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<div class="row">
    <div class="col-md-3">
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
    <h3 class="text-success text-center">Search result</h3>

    <h2 class="text-center text-warning">Sorry, but no results were found</h2>
</div>
