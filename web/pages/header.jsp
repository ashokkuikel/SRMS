<%-- 
    Document   : header
    Created on : Sep 17, 2015, 12:22:39 PM
    Author     : Yubaraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <div>
            <div class="left">
                <h1><a href="#">SRMS</a></h1>
                <h2>Student Registration Management System</h2>
            </div>
            <div class="right-user">
                <div>
                    <label>Welcome: ${fullName}</label>
                </div>
                <div>
                    <label><a href="./logoutServlet">Logout</a></label>
                </div>
            </div>
        </div>
    </body>
</html>
