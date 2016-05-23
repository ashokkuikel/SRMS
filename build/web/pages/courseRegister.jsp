<%-- 
    Document   : courseRegister
    Created on : Dec 30, 2015, 4:42:52 AM
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
        <div class="form-style">
            <form method="post" action="./courseRegisterServlet">
                <label><span>&nbsp;</span>
                    <errorMessage><span class="errorMessage"> ${successMessage}</span></errorMessage>
                </label>
                <fieldset>
                    <legend>Course Registration</legend>
                    <label for="courseName">
                        <span>Course Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="courseName" autocomplete="off" value="${courseName}"/>
                        <errorMessage> ${courseNameRequired}</errorMessage>
                    </label>
                    <label for="courseDescription">
                        <span>Course Description <span class="required">*</span></span>
                        <textarea class="input-field" type="text" name="courseDescription" value="${courseDescription}"></textarea>
                        <errorMessage> ${courseDescriptionRequired}</errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <input type="submit" value="Register" />
                    </label>
                </fieldset>
            </form>
        </div>
    </body>
</html>
