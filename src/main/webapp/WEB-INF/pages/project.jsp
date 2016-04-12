<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <div class="row">

        <div class="col-sm-8 col-md-8">
            <div class="thumbnail" style="margin-top: 15px">

                <img class="img-responsive" src="${project.image}" alt="placeholder image"
                     style="width: 500px; height: 500px;"/>
                <div class="caption">
                    <h3 class="text-success text-center">${project.nameProject}</h3>
                    <p class="text-center">This project was created
                        : ${project.dateFormat()}</p>
                    <p class="text-center">by ${project.user.firstName} ${project.user.lastName}</p>
                    <p class="text-center">$${project.donate_amount} pledged of $${project.needAmount} goal</p>
                    <div class="progress">
                        <div class="progress-bar progress-bar-success progress-bar-striped" role="progressbar"
                             aria-valuenow="${project.percendDonate()}" aria-valuemin="0"
                             aria-valuemax="100" style="width:${project.percendDonate()}%"/>
                    </div>
                </div>
                <form class="text-center" action="/projects/${project.id}/donate"
                      method="GET">
                    <input hidden name="projectId" value="${projectId}">
                    <input class="btn btn-success" type="submit" value="Donate"/>
                </form>
            </div>
            <div class="text-center">
                ${project.aboutProject}
            </div>
        </div>
    </div>
    <c:forEach items="${donates}" var="donate">
        <div class="col-sm-4 col-md-3" style="float: right; clear: right; margin-top: 15px">
            <div class="thumbnail">
                <p>Donate : $${donate.amount}</p>
                <p>Full Name : ${donate.user.fullName()} </p>
                <p>Email : ${donate.user.email} </p>
                <p>Date : ${donate.dateFormat()}</p>
            </div>
        </div>
    </c:forEach>
