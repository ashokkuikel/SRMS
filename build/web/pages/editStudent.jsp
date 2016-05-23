<%-- 
    Document   : editStudent
    Created on : Jan 20, 2016, 6:34:10 PM
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
            <form method="post" action="./editStudentServlet">
                <label><span>&nbsp;</span>
                    <errorMessage><span class="errorMessage"> ${successMessage}</span></errorMessage>
                </label>
                <fieldset>
                    <legend>Student Modification</legend>
                    <input type="hidden" name="id" value="${studentDto.id}">
                    <label for="course">
                        <span>Course</span>
                        <input class="input-field" type="text" name="course" autocomplete="off" value="${studentDto.course}" readonly="true" title="Read only value"/>
                    </label>
                    
                    <label for="firstName">
                        <span>First Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="firstName" autocomplete="off" value="${studentDto.firstName}"/>
                        <errorMessage> ${firstNameRequired}</errorMessage>
                    </label>
                    <label for="middleName">
                        <span>Middle Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="middleName" autocomplete="off" value="${studentDto.middleName}"/>
                        <errorMessage> ${middleNameRequired}</errorMessage>
                    </label>
                    <label for="lastName">
                        <span>Last Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="lastName" autocomplete="off" value="${studentDto.lastName}"/>
                        <errorMessage> ${lastNameRequired}</errorMessage>
                    </label>
                    <label for="mobileNumber">
                        <span>Mobile No. <span class="required">*</span></span>
                        <input class="input-field" type="text" name="mobileNumber" autocomplete="off" value="${studentDto.mobileNumber}"/>
                        <errorMessage> ${mobileNumberRequired}</errorMessage>
                    </label>
                    <label for="email">
                        <span>Email <span class="required">*</span></span>
                        <input class="input-field" type="text" name="email" autocomplete="off" value="${studentDto.email}"/>
                        <errorMessage> ${emailRequired}</errorMessage>
                    </label>
                    <label for="address">
                        <span>Address <span class="required">*</span></span>
                        <input class="input-field" type="text" name="address" autocomplete="off" value="${studentDto.address}"/>
                        <errorMessage> ${addressRequired}</errorMessage>
                    </label>
                    <label for="semester">
                        <span>Semester <span class="required">*</span></span>
                        <input class="input-field" type="text" name="semester" autocomplete="off" value="${studentDto.semester}"/>
                        <errorMessage> ${semesterRequired}</errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <errorMessage><span class="errorMessage"> ${errorMessage}</span></errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <input type="submit" value="Modify" />
                    </label>
                </fieldset>
            </form>
        </div>
    </body>
</html>
