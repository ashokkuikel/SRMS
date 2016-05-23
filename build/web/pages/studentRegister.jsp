<%-- 
    Document   : studentRegister
    Created on : Oct 1, 2015, 5:21:41 PM
    Author     : Yuba Raj Kalathoki
--%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="form-style">
            <form method="post" action="./studentRegisterServlet">
                <label><span>&nbsp;</span>
                    <errorMessage><span class="errorMessage"> ${successMessage}</span></errorMessage>
                </label>
                <fieldset>
                    <legend>Student Registration</legend>
                    <label for="firstName">
                        <span>First Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="firstName" autocomplete="off" value="${firstName}"/>
                        <errorMessage> ${firstNameRequired}</errorMessage>
                    </label>
                    <label for="middleName">
                        <span>Middle Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="middleName" autocomplete="off" value="${middleName}"/>
                        <errorMessage> ${middleNameRequired}</errorMessage>
                    </label>
                    <label for="lastName">
                        <span>Last Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="lastName" autocomplete="off" value="${lastName}"/>
                        <errorMessage> ${lastNameRequired}</errorMessage>
                    </label>
                    <label for="mobileNumber">
                        <span>Mobile No. <span class="required">*</span></span>
                        <input class="input-field" type="text" name="mobileNumber" autocomplete="off" value="${mobileNumber}"/>
                        <errorMessage> ${mobileNumberRequired}</errorMessage>
                    </label>
                    <label for="email">
                        <span>Email <span class="required">*</span></span>
                        <input class="input-field" type="text" name="email" autocomplete="off" value="${email}"/>
                        <errorMessage> ${emailRequired}</errorMessage>
                    </label>
                    <label for="address">
                        <span>Address <span class="required">*</span></span>
                        <input class="input-field" type="text" name="address" autocomplete="off" value="${address}"/>
                        <errorMessage> ${addressRequired}</errorMessage>
                    </label>
                    <label for="dateOfBirth">
                        <span>Date of Birth <span class="required">*</span></span>
                        <input class="input-field" type="text" name="dob" autocomplete="off" value="${dateOfBirth}"/>
                        <errorMessage> ${dateOfBirthRequired}</errorMessage>
                    </label>
                    <label for="gender">
                        <span>Gender<span class="required">*</span></span>
                        <input class="input-field"  type="radio" name="gender" value="MALE">Male<span></span>
                        <input class="input-field"  type="radio" name="gender" value="FEMALE">Female
                        <input class="input-field"  type="radio" name="gender" value="OTHER">Other
                        <errorMessage><span class="radio-login-style"> ${genderRequired}</span></errorMessage>
                    </label>
                    <label for="course">
                        <span>Course<span class="required">*</span></span>
                        <select name="course">
                            <option value="Select">Select</option>
                            <c:forEach items="${courseList}" var="course">
                                <option value="${course.courseName}">${course.courseName}</option>
                            </c:forEach>
                        </select>
                        <errorMessage><span class="radio-login-style"> ${genderRequired}</span></errorMessage>
                    </label>
                    <label for="semester">
                        <span>Semester <span class="required">*</span></span>
                        <input class="input-field" type="text" name="semester" autocomplete="off" value="${semester}"/>
                        <errorMessage> ${semesterRequired}</errorMessage>
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
