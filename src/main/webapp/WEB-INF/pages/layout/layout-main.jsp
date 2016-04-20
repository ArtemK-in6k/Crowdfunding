<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>

<!DOCTYPE html>
<html ng-app="crowdfundingApp">
<head>
    <tiles:insertAttribute name="header"/>
    <link href="<c:url value="/resources/css/main.css" />" rel="stylesheet" type="text/css">
</head>
<body>
<div class="container">

    <div id="body">
        <div class="row">
            <tiles:insertAttribute name="menu"/>
            <div class="col-lg-12 body-wrapper ">
                <div class="col-lg-12">
                    <tiles:insertAttribute name="body"/>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>