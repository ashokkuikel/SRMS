<%-- 
    Document   : viewSubject
    Created on : Jan 8, 2016, 12:40:40 PM
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
                    <th class="details-header" colspan="7"> Subject List</th>
                </tr>
                <tr>
                    <th>S.N.</th>
                    <th>Subject Name</th>
                    <th>Full Marks</th>
                    <th>Pass Marks</th>
                    <th>Course</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${subjectDtoList}" var="subject" varStatus="loop">
                    <tr class="${loop.index %2 == 0 ? 'even' : 'odd'}">
                        <td>${loop.index+1}</td>
                        <td>${subject.subjectName}</td>
                        <td>${subject.fullMarks}</td>
                        <td>${subject.passMarks}</td>
                        <td>${subject.courseName}</td>
                        <td><c:out value="${subject.status eq 'A' ? 'Active' : 'Blocked'}"/></td>
                        <td>
                            <a href="
                               <c:url value="/editSubjectAction">
                                   <c:param name="id" value="${subject.id}"/>
                               </c:url>">
                                <c:out value="Edit"/>
                            </a>
                            <a href="<c:url value="/blockSubjectServlet">
                                   <c:param name="id" value="${subject.id}"/>
                                   <c:param name="status" value="${subject.status}"/>
                               </c:url>">
                                <c:out value="${subject.status eq 'A' ? 'Block' : 'Activate'}"/>
                            </a>
                            <a href="<c:url value="/deleteSubjectServlet">
                                   <c:param name="id" value="${subject.id}"/>
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
