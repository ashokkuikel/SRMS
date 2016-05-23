<%-- 
    Document   : menu
    Created on : Sep 17, 2015, 12:27:53 PM
    Author     : Yubaraj
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <body>
        <ul>
            <li><a href="./welcomeAction">Home</a>
            </li>
            <li><a href="#">Register</a>
                <ul class="submenu">
                    <li><a href="./userRegisterAction">User</a></li>
                    <li><a href="./courseRegisterAction">Course</a></li>
                    <li><a href="./studentRegisterAction">Student</a></li>
                    <li><a href="./subjectRegisterAction">Subject</a></li>
                    <li><a href="./marksEntryAction">Marks</a></li>
                </ul>
            </li>
            <li><a href="#">View</a>
                <ul class="submenu">
                    <li><a href="./viewUserServlet">User</a></li>
                    <li><a href="./viewCourseServlet">Course</a></li>
                    <li><a href="./viewStudentServlet">Student</a></li>
                    <li><a href="./viewSubjectServlet">Subject</a></li>
                    <li><a href="./viewResultServlet">Result</a></li>
                </ul>
            </li>
            <li><a href="#">Help</a>
                <ul class="submenu">
                    <li><a href="./userManualServlet">User Manual</a></li>
                    <li><a href="#">About</a></li>
                </ul>
            </li>
        </ul>
    </body>
</html>
