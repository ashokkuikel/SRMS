<%-- 
    Document   : userManual
    Created on : Jan 23, 2016, 8:23:58 AM
    Author     : Yuba Raj Kalathoki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        
        <div>
            <object data="${pageContext.request.contextPath}/files/SRMS-DraftReport.pdf" type="application/pdf" class="user-manual" >
                alt:<a href="${pageContext.request.contextPath}/files/SRMS-DraftReport.pdf">User Manual</a>
            </object>
        </div>
        
    </body>
</html>
