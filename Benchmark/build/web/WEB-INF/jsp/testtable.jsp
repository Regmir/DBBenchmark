<%-- 
    Document   : testtable
    Created on : 30.07.2017, 14:57:15
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Table Data</title>
    </head>
    <body>
        <h1>Data List</h1>
        <table>
            <tr>
                <th>ID</th><th>Data</th>
            </tr>
            <c:forEach var="data" items="${data}">
                <tr>
                    <td>
                        <c:out value="${data.getId()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.getRandomdata()}"></c:out>
                    </td>
                </tr>>
            </c:forEach>
        </table>
    </body>
</html>
