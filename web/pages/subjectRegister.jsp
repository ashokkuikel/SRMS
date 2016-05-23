<%-- 
    Document   : subjectRegister
    Created on : Jan 7, 2016, 6:29:47 PM
    Author     : Yuba Raj Kalathoki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-style">
            <form method="post" action="./subjectRegisterServlet">
                <label><span>&nbsp;</span>
                    <errorMessage><span class="errorMessage"> ${successMessage}</span></errorMessage>
                </label>
                <fieldset>
                    <legend>Subject Registration</legend>
                    <label for="course">
                        <span>Course<span class="required">*</span></span>
                        <select name="course">
                            <option value="Select">Select</option>
                            <c:forEach items="${courseList}" var="course">
                                <option value="${course.courseName}">${course.courseName}</option>
                            </c:forEach>
                        </select>
                        <errorMessage><span class="radio-login-style"> ${courseRequired}</span></errorMessage>
                    </label>
                    <label for="subjectName">
                        <span>Subject Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="subjectName" autocomplete="off" value="${subjectName}"/>
                        <errorMessage> ${subjectNameRequired}</errorMessage>
                    </label>
                    <label for="fullMarks">
                        <span>Full Marks <span class="required">*</span></span>
                        <input class="input-field" type="text" name="fullMarks" autocomplete="off" value="${fullMarks}"/>
                        <errorMessage> ${fullMarksRequired}</errorMessage>
                    </label>
                    <label for="passMarks">
                        <span>Pass Marks <span class="required">*</span></span>
                        <input class="input-field" type="text" name="passMarks" autocomplete="off" value="${passMarks}"/>
                        <errorMessage> ${passMarksRequired}</errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <errorMessage><span class="errorMessage"> ${errorMessage}</span></errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <input type="submit" value="Register" />
                    </label>
                </fieldset>
            </form>
        </div>
    </body>
</html>
