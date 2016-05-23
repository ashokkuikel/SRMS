<%-- 
    Document   : editUser
    Created on : Jan 17, 2016, 1:58:23 PM
    Author     : Yuba Raj Kalathoki
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit User</title>
    </head>
    <body>
        <div class="form-style">
            <form method="post" action="./editUserServlet">
                <label><span>&nbsp;</span>
                    <errorMessage><span class="errorMessage"> ${successMessage}</span></errorMessage>
                </label>
                <fieldset>
                    <input type="hidden" name="id" value="${userDto.id}">
                    <legend>User Modification</legend>
                    <label for="firstName">
                        <span>Username</span>
                        <input class="input-field" type="text" name="firstName" autocomplete="off" value="${userDto.username}" readonly="true" title="Read only value"/>
                    </label>
                    <label for="firstName">
                        <span>First Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="firstName" autocomplete="off" value="${userDto.firstName}"/>
                        <errorMessage> ${firstNameRequired}</errorMessage>
                    </label>
                    <label for="middleName">
                        <span>Middle Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="middleName" autocomplete="off" value="${userDto.middleName}"/>
                        <errorMessage> ${middleNameRequired}</errorMessage>
                    </label>
                    <label for="lastName">
                        <span>Last Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="lastName" autocomplete="off" value="${userDto.lastName}"/>
                        <errorMessage> ${lastNameRequired}</errorMessage>
                    </label>
                    <label for="mobileNumber">
                        <span>Mobile No. <span class="required">*</span></span>
                        <input class="input-field" type="text" name="mobileNumber" autocomplete="off" value="${userDto.mobileNumber}"/>
                        <errorMessage> ${mobileNumberRequired}</errorMessage>
                    </label>
                    <label for="email">
                        <span>Email <span class="required">*</span></span>
                        <input class="input-field" type="text" name="email" autocomplete="off" value="${userDto.email}"/>
                        <errorMessage> ${emailRequired}</errorMessage>
                    </label>
                    <label for="address">
                        <span>Address <span class="required">*</span></span>
                        <input class="input-field" type="text" name="address" autocomplete="off" value="${userDto.address}"/>
                        <errorMessage> ${addressRequired}</errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <errorMessage><span class="errorMessage"> ${errorMessage}</span></errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <input type="submit" value="Modify" title="Click to modify user" />
                        <!--<input type="submit" value="Cancel" title="Click to cancel your modification"  />-->
                        
                    </label>
                </fieldset>
            </form>
        </div>
    </body>
</html>
