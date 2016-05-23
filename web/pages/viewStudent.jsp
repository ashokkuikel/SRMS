<%-- 
    Document   : viewStudent
    Created on : Jan 8, 2016, 2:01:22 AM
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
        <table>
            <thead>
                <tr>
                    <th class="details-header" colspan="9"> Student List</th>
                </tr>
                <tr>
                    <th>S.N.</th>
                    <th>Full Name</th>
                    <th>Mobile Number</th>
                    <th>Email Address</th>
                    <th>Address</th>
                    <th>Course</th>
                    <th>Semester</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${studentList}" var="student" varStatus="loop">
                    <tr class="${loop.index %2 == 0 ? 'even' : 'odd'}">
                        <td>${loop.index+1}</td>
                        <td>${student.fullName}</td>
                        <td>${student.mobileNumber}</td>
                        <td>${student.email}</td>
                        <td>${student.address}</td>
                        <td>${student.course}</td>
                        <td>${student.semester}</td>
                        <td><c:out value="${student.status eq 'A' ? 'Active' : 'Blocked'}"/></td>
                        <td>
                            <a href="
                               <c:url value="/editStudentAction">
                                   <c:param name="id" value="${student.id}"/>
                               </c:url>">
                                <c:out value="Edit"/>
                            </a>
                            <a href="<c:url value="/blockStudentServlet">
                                   <c:param name="id" value="${student.id}"/>
                                   <c:param name="status" value="${student.status}"/>
                               </c:url>">
                                <c:out value="${student.status eq 'A' ? 'Block' : 'Activate'}"/>
                            </a>
                            <a href="<c:url value="/deleteStudentServlet">
                                   <c:param name="id" value="${student.id}"/>
                               </c:url>">
                                <c:out value="Delete"/>
                            </a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </body>
</html>
