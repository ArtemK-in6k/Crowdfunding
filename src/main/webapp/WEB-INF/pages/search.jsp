<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>

<div class="row">

    <h4 class="text-success text-center">Search result for : ${search}</h4>
    <div class="col-md-12">
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
