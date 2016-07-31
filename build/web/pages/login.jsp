<%-- 
    Document   : login
    Created on : Sep 16, 2015, 12:19:41 PM
    Author     : Yubaraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="Content-Language" content="English" />
    </head>
    <body>
        <div class="form-style">
            <form method="post" action="./loginServlet">
                <fieldset>
                    <legend>Login</legend>
                    <label for="username">
                        <span>Name <span class="required">*</span></span>
                        <input class="input-field" type="text" name="username" autocomplete="off" value="${username}"/>
                        <errorMessage> ${usernameRequired}</errorMessage>
                    </label>
                    <label for="password">
                        <span>Password <span class="required">*</span></span>
                        <input class="input-field" type="password" name="password" autocomplete="off" value="${password}"/>
                        <errorMessage> ${passwordRequired}</errorMessage>
                    </label>
                    <label for="userType">
                        <span>User Type<span class="required">*</span></span>
                        <input class="input-field"  type="radio" name="userType" value="SUPER_USER">Super User<span></span>
                        <input class="input-field"  type="radio" name="userType" value="APP_USER">Application User
                        <errorMessage><span class="radio-login-style"> ${userTypeRequired}</span></errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <errorMessage><span class="errorMessage"> ${errorMessage}</span></errorMessage>
                    </label>
                    <label><span>&nbsp;</span>
                        <input type="submit" value="Login" />
                    </label>
                </fieldset>
            </form>
        </div>
    </body>
</html>
