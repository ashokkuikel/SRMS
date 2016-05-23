<%-- 
    Document   : viewCourse
    Created on : Jan 8, 2016, 1:41:59 AM
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
                    <th class="details-header" colspan="5"> Course List</th>
                </tr>
                <tr>
                    <th>S.N.</th>
                    <th>Course Name</th>
                    <th>Course Description</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${courseDtoList}" var="course" varStatus="loop">
                    <tr class="${loop.index %2 == 0 ? 'even' : 'odd'}">
                        <td><c:out value="${loop.index+1}"/></td>
                        <td>${course.courseName}</td>
                        <td>${course.courseDescription}</td>
                        <td><c:out value="${course.status eq 'A' ? 'Active' : 'Blocked'}"/></td>
                        <td>
                            <a href="
                               <c:url value="/editCourseAction">
                                   <c:param name="id" value="${course.id}"/>
                               </c:url>">
                                <c:out value="Edit"/>
                            </a>
                            <a href="<c:url value="/blockCourseServlet">
                                   <c:param name="id" value="${course.id}"/>
                                   <c:param name="status" value="${course.status}"/>
                               </c:url>">
                                <c:out value="${course.status eq 'A' ? 'Block' : 'Activate'}"/>
                            </a>
                            <a href="<c:url value="/deleteCourseServlet">
                                   <c:param name="id" value="${course.id}"/>
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
