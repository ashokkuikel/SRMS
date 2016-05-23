<%-- 
    Document   : marksEntry
    Created on : Dec 12, 2015, 9:22:00 AM
    Author     : Yuba Raj Kalathoki
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-style">
            <form method="post" action="./marksEntryServlet">
                <label><span>&nbsp;</span>
                    <errorMessage><span class="errorMessage"> ${successMessage}</span></errorMessage>
                </label>
                <fieldset>
                    <legend>Marks Entry Panel</legend>
                    <label for="rollNo">
                        <span>Student<span class="required">*</span></span>
                        <select name="studentId">
                            <option value="0">Select</option>
                            <c:forEach items="${studentItem}" var="student">
                                <option value="${student.studentId}">${student.studentName}</option>
                            </c:forEach>
                        </select>
                        <errorMessage><span class="radio-login-style"> ${rollNumberRequired}</span></errorMessage>
                    </label>
                    <div id="subjectDiv">
                        <label for="subject">
                            <span>Subject<span class="required">*</span></span>
                            <select name="subjectId">
                                <option value="Select">Select</option>
                                <c:forEach items="${subjectList}" var="subject">
                                    <option value="${subject.id}">${subject.subjectName}</option>
                                </c:forEach>
                            </select>
                            <errorMessage><span class="radio-login-style"> ${genderRequired}</span></errorMessage>
                        </label>
                    </div>
                    <label for="marks">
                        <span>Marks <span class="required">*</span></span>
                        <input class="input-field" type="text" name="marks" autocomplete="off" value="${marks}"/>
                        <errorMessage> ${marksRequired}</errorMessage>
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
