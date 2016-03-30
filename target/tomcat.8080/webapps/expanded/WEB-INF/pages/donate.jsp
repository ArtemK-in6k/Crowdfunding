<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Crowdfunding</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <!-- Optional theme -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
</head>
<body>

<div class="text-center">
    <form class="form-horizontal " action='/thanks' method="POST">
        <input hidden name="projectId" value="${project.id}">
        <fieldset>
            <div id="legend">
                <legend class="">Donation</legend>
            </div>
            <div class="control-group">
                <!-- FirstName -->
                <label class="control-label" for="firstname">Firstname</label>
                <div class="controls">
                    <input type="text" id="firstname" name="firstname" placeholder="" class="input-xlarge">
                    <p class="help-block">Please provide your firstname</p>
                </div>
            </div>

            <div class="control-group">
                <!-- LastName -->
                <label class="control-label" for="lastname">Lastname</label>
                <div class="controls">
                    <input type="text" id="lastname" name="lastname" placeholder="" class="input-xlarge">
                    <p class="help-block">Please provide your lastname</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Telephone-->
                <label class="control-label" for="email">Email</label>
                <div class="controls">
                    <input type="text" id="email" name="email" placeholder="" class="input-xlarge">
                    <p class="help-block">Please provide your email</p>
                </div>
            </div>

            <div class="control-group">
                <!-- Telephone-->
                <label class="control-label" for="donate">Enter your donate</label>
                <div class="controls">
                    <input type="text" id="donate" name="donate" placeholder="" class="input-xlarge">
                </div>
            </div>


            <div class="control-group">
                <!-- Button -->
                <div class="controls">
                    <button class="btn btn-success">Continue</button>
                </div>
            </div>
        </fieldset>
    </form>
</div>

<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"
        integrity="sha384-0mSbJDEHialfmuBBQP6A4Qrprq5OVfW37PRR3j5ELqxss1yVqOtnepnHVP9aJ7xS"
        crossorigin="anonymous"></script>
</body>
</html>