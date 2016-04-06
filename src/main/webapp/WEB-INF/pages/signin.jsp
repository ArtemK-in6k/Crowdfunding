<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>


    <script src="https://code.jquery.com/jquery-1.12.0.min.js"></script>
    <script src="https://code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
          integrity="sha384-1q8mTJOASx8j1Au+a5WDVnPi2lkFfwwEAa8hDDdjZlpLegxhjVME1fgjWPGmkzs7" crossorigin="anonymous">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap-theme.min.css"
          integrity="sha384-fLW2N01lMqjakBkx3l/M9EahuwpSfeNvV63J5ezn3uZzapT0u7EYsXMjQV+0En5r" crossorigin="anonymous">
    <link rel="stylesheet"
          href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.10.0/css/bootstrap-select.min.css">

    <spring:url value="/resources/css/form.css" var="form"/>
    <link href="${form}" type="text/css" rel="stylesheet"/>

    <spring:url value="/resources/css/signin.css" var="signin"/>
    <link href="${signin}" type="text/css" rel="stylesheet"/>

    <spring:url value="resources/js/signin.js" var="signinJS"/>
    <script src="${signinJS}"></script>

    <spring:url value="resources/js/valid.js" var="validJS"/>
    <script src="${validJS}"></script>



    <title>Title</title>
</head>
<body>

<div class="container">

    <div class="row">
        <div class="col-xs-12 col-sm-8 col-md-6 col-sm-offset-2 col-md-offset-3">
            <form name="form" role="form" action="/register" method="post" onsubmit="return isValid()">
                <h2>Please Sign Up
                    <small>It's free and always will be.</small>
                </h2>

                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="first_name" id="first_name" class="form-control input-lg"
                                   placeholder="First Name" tabindex="1" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="text" name="last_name" id="last_name" class="form-control input-lg"
                                   placeholder="Last Name" tabindex="2" required>
                        </div>
                    </div>
                </div>
                <div class="form-group">
                    <input type="text" name="display_name" id="display_name" class="form-control input-lg"
                           placeholder="Display Name" tabindex="3" required>
                </div>
                <div class="form-group">
                    <input type="email" name="email" id="email" class="form-control input-lg"
                           placeholder="Email Address" tabindex="4" required>
                </div>
                <div class="row">
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password" id="password" class="form-control input-lg"
                                   placeholder="Password" tabindex="5" required>
                        </div>
                    </div>
                    <div class="col-xs-12 col-sm-6 col-md-6">
                        <div class="form-group">
                            <input type="password" name="password_confirmation" id="password_confirmation"
                                   class="form-control input-lg" placeholder="Confirm Password" tabindex="6" required>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="col-xs-4 col-sm-3 col-md-3">
					<span class="button-checkbox">
						<button type="button" class="btn" data-color="info" tabindex="7">I Agree</button>
                        <input type="checkbox" name="t_and_c" id="t_and_c" class="hidden" value="1" required>
					</span>
                    </div>
                    <div class="col-xs-8 col-sm-9 col-md-9">
                        By clicking <strong class="label label-primary">Register</strong>, you agree to the
                        <a href="#" data-toggle="modal" data-target="#t_and_c_m">
                            Terms and Conditions</a> set out by this site, including our Cookie Use.
                    </div>
                </div>

                <hr class="colorgraph">
                <div class="row">
                    <div class="col-xs-12 col-md-6">
                        <input type="submit" value="Register" class="btn btn-primary btn-block btn-lg" tabindex="7">
                    </div>

                    <div class="col-xs-12 col-md-6">
                        <a href="/sign-in" class="btn btn-success btn-block btn-lg">SignIn</a>
                    </div>
                </div>
                <input type="hidden"
                       name="${_csrf.parameterName}"
                       value="${_csrf.token}"/>
            </form>
        </div>
    </div>
    <!-- Modal -->
    <div class="modal fade" id="t_and_c_m" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog modal-lg">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h4 class="modal-title" id="myModalLabel">Terms & Conditions</h4>
                </div>
                <div class="modal-body">
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam
                        nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus
                        ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam
                        nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus
                        ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam
                        nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus
                        ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam
                        nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus
                        ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam
                        nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus
                        ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam
                        nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus
                        ipsa porro delectus quidem dolorem ad.</p>
                    <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique, itaque, modi, aliquam
                        nostrum at sapiente consequuntur natus odio reiciendis perferendis rem nisi tempore possimus
                        ipsa porro delectus quidem dolorem ad.</p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-primary" data-dismiss="modal">I Agree</button>
                </div>
            </div><!-- /.modal-content -->
        </div><!-- /.modal-dialog -->
    </div><!-- /.modal -->
</div>

</body>
</html>
