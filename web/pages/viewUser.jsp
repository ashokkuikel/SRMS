<%-- 
    Document   : viewUser
    Created on : Jan 8, 2016, 12:56:28 AM
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
        <a href="./userRecordDumpServlet">Dump Record</a>
        <table>
            <thead>
                <tr>
                    <th class="details-header" colspan="9"> User List</th>
                </tr>
                <tr>
                    <th>S.N.</th>
                    <th>Full Name</th>
                    <th>Mobile Number</th>
                    <th>Email Address</th>
                    <th>Address</th>
                    <th>Username</th>
                    <th>Last Login</th>
                    <th>Status</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${userList}" var="user" varStatus="loop">
                    <tr class="${loop.index %2 == 0 ? 'even' : 'odd'}">
                        <td><c:out value="${loop.index+1}"/></td>
                        <td><c:out value="${user.fullName}"/></td>
                        <td><c:out value="${user.mobileNumber}"/></td>
                        <td><c:out value="${user.email}"/></td>
                        <td><c:out value="${user.address}"/></td>
                        <td><c:out value="${user.username}"/></td>
                        <td><c:out value="${user.lastLogin}"/></td>
                        <td><c:out value="${user.status eq 'A' ? 'Active' : 'Blocked'}"/></td>
                        <td>
                            <a href="
                               <c:url value="/editUserAction">
                                   <c:param name="userId" value="${user.id}"/>
                               </c:url>">
                                <c:out value="Edit"/>
                            </a>
                            <a href="<c:url value="/blockUserServlet">
                                   <c:param name="userId" value="${user.id}"/>
                                   <c:param name="status" value="${user.status}"/>
                               </c:url>">
                                <c:out value="${user.status eq 'A' ? 'Block' : 'Activate'}"/>
                            </a>
                            <a href="<c:url value="/deleteUserServlet">
                                   <c:param name="userId" value="${user.id}"/>
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
