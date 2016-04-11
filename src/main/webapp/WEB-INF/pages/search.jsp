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
    <h3 class="text-success text-center">Search result for : ${search}</h3>
    <div class="col-md-8">
        <c:forEach items="${projectlist}" var="project">
            <div class="col-sm-6 col-md-6">
                <div class="thumbnail">
                    <a href="/projects/${project.id}">
                        <img class="img-responsive" src="${project.image}" alt="placeholder image"
                             style="width: 200px; height: 200px;"/>
                    </a>
                    <div class="caption text-center">
                        <a href="/projects/${project.id}">
                            <p class="lead">${project.nameProject}</p>
                        </a>
                        <div class="progress">
                            <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
                                 aria-valuenow="${project.donate_amount/project.needAmount*100}" aria-valuemin="0"
                                 aria-valuemax="100"
                                 style="width:${project.donate_amount/project.needAmount*100}%">
                            </div>
                        </div>
                    </div>
                    <p class="text-center">$${project.donate_amount} pledged of $${project.needAmount} goal</p>
                    <p class="text-center">This project was created
                        : ${project.date.date}-${project.date.month + 1}-${project.date.year + 1900}</p>
                    <p class="text-center">by ${project.user.firstName} ${project.user.lastName}</p>
                </div>
            </div>
        </c:forEach>
    </div>
</div>
