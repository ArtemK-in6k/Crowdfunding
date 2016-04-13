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
        <div class="text-center fig">

            <img src="${project.image}" alt="" style="width: 400px; height: 400px;">
            <h2>Thank you for creation ${project.nameProject}</h2>

            <form action="/" method="get">
                <input class="btn btn-success" type="submit" value="Go to the main page"/>

            </form>
        </div>
</div>
