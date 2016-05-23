<%-- 
    Document   : editSubject
    Created on : Jan 20, 2016, 11:36:11 PM
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
            <form method="post" action="./editSubjectServlet">
                <label><span>&nbsp;</span>
                    <errorMessage><span class="errorMessage"> ${successMessage}</span></errorMessage>
                </label>
                <fieldset>
                    <legend>Subject Modification</legend>
                    <input type="hidden" name="id" value="${subjectDto.id}">
                    <label for="course">
                        <span>Course</span>
                        <input class="input-field" type="text" name="course" autocomplete="off" value="${subjectDto.courseName}" readonly="true" title="Read only value"/>
                    </label>
                    <label for="subjectName">
                        <span>Subject Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="subjectName" autocomplete="off" value="${subjectDto.subjectName}"/>
                        <errorMessage> ${subjectNameRequired}</errorMessage>
                    </label>
                    <label for="fullMarks">
                        <span>Full Marks <span class="required">*</span></span>
                        <input class="input-field" type="text" name="fullMarks" autocomplete="off" value="${subjectDto.fullMarks}"/>
                        <errorMessage> ${fullMarksRequired}</errorMessage>
                    </label>
                    <label for="passMarks">
                        <span>Pass Marks <span class="required">*</span></span>
                        <input class="input-field" type="text" name="passMarks" autocomplete="off" value="${subjectDto.passMarks}"/>
                        <errorMessage> ${passMarksRequired}</errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <errorMessage><span class="errorMessage"> ${errorMessage}</span></errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <input type="submit" value="Edit" />
                    </label>
                </fieldset>
            </form>
        </div>
    </body>
</html>
