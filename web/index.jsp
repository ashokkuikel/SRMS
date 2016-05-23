<%-- 
    Document   : index
    Created on : Sep 16, 2015, 12:18:31 PM
    Author     : Yubaraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Language" content="English" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/form.css" media="screen" />
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css" media="screen" />
    </head>
    <body>
        <div  class="login-form">
            <jsp:include page="pages/login.jsp" />
        </div>
    </body>
</html>