<%-- 
    Document   : userRegister
    Created on : Dec 12, 2015, 9:09:41 AM
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
            <form method="post" action="./userRegisterServlet">
                <label><span>&nbsp;</span>
                    <errorMessage><span class="errorMessage"> ${successMessage}</span></errorMessage>
                </label>
                <fieldset>
                    <legend>User Registration</legend>
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
