<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<div class="row">
    <div class="col-lg-7 col-lg-offset-2">
        <fieldset class="text-center">
            <form class="form-horizontal" action='/thanks' method="POST">
                <input hidden name="projectId" value="${projectId}">
                <fieldset class="form-group">
                    <div id="legend">
                        <legend class="text-success">Donation</legend>
                    </div>
                    <fieldset class="form-group">
                        <!-- FirstName -->
                        <div class="controls">
                            <input type="text" id="firstname" name="firstname" placeholder="Firstname"
                                   class="form-control"
                                   required>
                        </div>
                    </fieldset>

                    <fieldset class="form-group">
                        <!-- LastName -->
                        <div class="controls">
                            <input type="text" id="lastname" name="lastname" placeholder="Lastname" class="form-control"
                                   required>
                        </div>
                    </fieldset>

                    <fieldset class="form-group">
                        <!-- Telephone-->
                        <div class="controls">
                            <input type="email" id="email" name="email" placeholder="Email" class="form-control"
                                   required>
                        </div>
                    </fieldset>

                    <fieldset class="form-group">
                        <!-- Telephone-->
                        <div class="controls">
                            <input type="text" id="donate" name="donate" placeholder="Sum for donate"
                                   class="form-control" required>
                        </div>
                    </fieldset>

                    <fieldset class="form-group">
                        <!-- Button -->
                        <div class="controls" style="margin-top: 1cm">
                            <button class="btn btn-success">Continue</button>
                        </div>
                    </fieldset>
                </fieldset>
                <input type="hidden" name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
        </fieldset>
    </div>
</div>