<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<nav class="navbar-inverse navbar-custom" role="navigation">

    <div class="navbar-header">
        <a class="navbar-brand" href="/">Online-Shop</a>
    </div>

    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <div class="container">
            <div class="navbar-header navbar-right navbar">
                <form class="right-arrow-button" action="/buy" method="GET">
                    <button class="btn btn-primary" type="submit">
                        ShoppingCart <span class="badge"><%=session.getAttribute("amount")%></span>
                    </button>
                </form>
            </div>
        </div>
    </div>
</nav>
