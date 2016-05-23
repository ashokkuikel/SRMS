<%-- 
    Document   : mainContent
    Created on : Sep 17, 2015, 12:33:31 PM
    Author     : Yubaraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <title>Zurelsoft</title>
        <meta http-equiv="Content-Language" content="English" />
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css" media="screen" />
    </head>
    <body>
        <div id="wrap">
            <div id="top"> </div>
            <div id="header">
                <jsp:include page="header.jsp"/>
            </div>
            <div id="menu">
                <jsp:include page="menu.jsp"/>
            </div>
            <div id="content">
                
                <jsp:include page="${content}" />
                
<!--                <div class="left"> 
                    <%--<jsp:include page="${content}" />--%>
                </div>-->
<!--                <div class="right"> 
                    <%--<jsp:include page="rightContent.jsp"/>--%>
                </div>-->
                <div style="clear: both;"> </div>
            </div>
            <div id="bottom"> </div>
            <div id="footer">
                <jsp:include page="footer.jsp"/>
            </div>
        </div>
    </body>
</html>