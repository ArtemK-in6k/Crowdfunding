<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

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
    <div class="col-md-5">
        <form id="forma" class="form-horizontal " action='/create' method="POST">
            <input hidden name="categoryId" value="${category.id}">
            <fieldset class="form-group">
                <div id="legend">
                    <legend class="text-center text-success">Create project</legend>
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
                        <input type="text" id="needAmount" name="needAmount" placeholder="Funding goal in $"
                               class="form-control"
                               required>
                    </div>
                </fieldset>

                <fieldset class="form-group">
                    <!-- Telephone-->
                    <div class="controls">
                        <input type="text" id="projectName" name="projectName" placeholder="Project title"
                               class="form-control"
                               required>
                    </div>
                </fieldset>

                <fieldset class="form-group">
                    <!-- Telephone-->
                    <div class="controls">
                            <textarea id="aboutProject" name="aboutProject" class="form-control" rows="10" cols="100"
                                      form="forma"
                                      placeholder="Enter here project description..."
                                      style="resize: none" required></textarea>
                    </div>
                </fieldset>

                <fieldset class="form-group">
                    <!-- Telephone-->
                    <div class="controls">
                        <input type="text" id="image" name="image" placeholder="URL image"
                               class="form-control"
                               required>
                    </div>
                </fieldset>

                <fieldset class="form-group">
                    <div class="form-group text-center" style="margin-top: 1cm">
                        <!-- Button -->
                        <div class="controls">
                            <button class="btn btn-success">Create</button>
                        </div>
                    </div>
                </fieldset>
            </fieldset>
            <input type="hidden" name="${_csrf.parameterName}"
                   value="${_csrf.token}"/>
        </form>
    </div>
</div>

