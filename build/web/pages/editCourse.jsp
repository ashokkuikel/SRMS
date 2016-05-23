<%-- 
    Document   : editCourse
    Created on : Jan 19, 2016, 10:46:05 PM
    Author     : Yuba Raj Kalathoki
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-style">
            <form method="post" action="./editCourseServlet">
                <label><span>&nbsp;</span>
                    <errorMessage><span class="errorMessage"> ${successMessage}</span></errorMessage>
                </label>
                <fieldset>
                    <input type="hidden" name="id" value="${courseDto.id}">
                    <legend>Course Modification</legend>
                    <label for="courseName">
                        <span>Course Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="courseName" autocomplete="off" value="${courseDto.courseName}"/>
                        <errorMessage> ${courseNameRequired}</errorMessage>
                    </label>
                    <label for="courseDescription">
                        <span>Course Description <span class="required">*</span></span>
                        <textarea class="input-field" type="text" name="courseDescription" >${courseDto.courseDescription}</textarea>
                        <errorMessage> ${courseDescriptionRequired}</errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <input type="submit" value="Modify" />
                    </label>
                </fieldset>
            </form>
        </div>
    </body>
</html>
