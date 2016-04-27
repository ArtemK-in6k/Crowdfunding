<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--<div class="navigation col-sm-12 col-md-12 col-lg-12">
    <a class="btn btn-sm btn-default" href="/control/projects">My Projects</a>
    <a class="btn btn-sm btn-default" href="/control/donates">My Donates</a>
    <a class="btn btn-sm btn-default" href="/control/settings">Settings</a>
</div>--%>

<ul class="navigation nav nav-pills nav-stacked">
    <li><a class="" href="/control/projects">My Projects</a></li>
    <li><a class="" href="/control/donates">My Donations</a></li>
    <li><a class="" href="/control/settings">Settings</a></li>
</ul>
<script type="text/javascript">
    $(function(){
        function getLocationLvlPath(url) {
            var pathArray = url.split( '/' );
            var secondLevelLocation = pathArray[2];
            return secondLevelLocation;
        }
        $('.navigation a').each(function(){
            var navigationPath = $(this).attr('href');
            var n = getLocationLvlPath(navigationPath)
            var u = getLocationLvlPath(window.location.pathname);
            if (n == u) {
                $(this).parent().addClass('active');
            }
        });
    });
</script>


