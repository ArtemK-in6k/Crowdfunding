<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <div class="row">
        <div class="col-md-3">
            <nav class="navmenu navmenu-default" role="navigation">
                <div>
                    <h4 class="text-success" style="text-indent: 60px">Categories</h4>
                    <ul class="nav navmenu-nav">
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
        <div class="col-md-4 text-center" style="margin-top: 5cm">
            <h2>Thank you for your donation to the ${project.nameProject}</h2>
            <img src="http://www.onetip.net/wp-content/uploads/2014/07/thanks-sms-for-friends.jpg" alt="sorry">
            <form action="/" method="GET" style="margin-top: 2cm">
                <input class="btn btn-success" type="submit" value="Go to the main page"/>
            </form>
        </div>
    </div>
