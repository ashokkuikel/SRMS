<%-- 
    Document   : viewResult
    Created on : Jan 8, 2016, 1:23:58 PM
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
        <div class="resultDisplay">
            <form id="searchbox" action="" class="searchForm">
                <input id="search" type="text" name="rollNo" placeholder="Type roll number">
                <input id="submit" type="submit" value="View">
            </form>
            <c:if test="${!empty resultList}">
                <div id="rm" class="markSheet">
                    <div class="resultInfo">
                        <label>Student Name : ${studentName}</label>
                        <label>Roll No. : ${rollNo}</label>
                        <label>Course : ${course}</label>
                        <a href="
                               <c:url value="/printResultServlet">
                                   <c:param name="rollNo" value="${rollNo}"/>
                               </c:url>">
                                <c:out value="print"/>
                            </a>

                        <table class="marks">
                            <thead>
                                <tr>
                                    <th>S.N.</th>
                                    <th>Subject Name</th>
                                    <th>Full Marks</th>
                                    <th>Pass Marks</th>
                                    <th>Obtained Marks</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${resultList}" var="result" varStatus="loop">
                                    <tr class="${loop.index %2 == 0 ? 'even' : 'odd'}">
                                        <td>${loop.index+1}</td>
                                        <td>${result.subjectName}</td>
                                        <td>${result.fullMarks}</td>
                                        <td>${result.passMarks}</td>
                                        <td>${result.marksValue}</td>
                                        <td>${result.result}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                        <div class="marksFooter">
                            <label>Total Marks : ${totalMarks}</label>
                            <label>Percent : ${percent}</label>
                            <label>Result: ${result}</label>
                        </div>
                    </div>
                </div>
            </c:if>
        </div>
    </body>
</html>
