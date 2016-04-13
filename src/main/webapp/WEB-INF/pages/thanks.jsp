<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

    <div class="row">
        <div class="text-center" style="margin-top: 5cm">
            <h2>Thank you for your donation to the ${project.nameProject}</h2>
            <img src="http://www.onetip.net/wp-content/uploads/2014/07/thanks-sms-for-friends.jpg" alt="sorry">
            <form action="/" method="GET" style="margin-top: 2cm">
                <input class="btn btn-success" type="submit" value="Go to the main page"/>
            </form>
        </div>
    </div>
