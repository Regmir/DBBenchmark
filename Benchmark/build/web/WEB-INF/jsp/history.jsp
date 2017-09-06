<%-- 
    Document   : history
    Created on : 30.08.2017, 14:24:43
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
            <header>
        <h1>History</h1>
        </header>
    <body>      
        <table>
            <tr>
                <th>Type</th><th>Number</th><th>Avg, MilSec</th><th>Min, MilSec</th>
                <th>Max, MilSec</th><th>Total, MilSec</th><th>Date</th><th>Custom Query</th>
                <th>User</th>
            </tr>
            <c:forEach var="data" items="${data}">
                <tr>
                    <td>
                        <c:out value="${data.getType()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.getNumber()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.getAvg()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.getMin()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.getMax()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.getTotal()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.getDate()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.getCustomQuery()}"></c:out>
                    </td>
                    <td>
                        <c:out value="${data.getDbusername()}"></c:out>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <a href="index.htm">Back</a>
    </body>
    <style>
    header {font-family: 'Montserrat', sans-serif;}
    table {
font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
font-size: 14px;
border-radius: 10px;
border-spacing: 0;
text-align: center;
}
th {
background: #2ee59d;
color: black;
/*text-shadow: 0 1px 1px #2D2020;*/
padding: 10px 20px;
}
th, td {
border-style: solid;
border-width: 0 1px 1px 0;
border-color: white;
}
th:first-child, td:first-child {
text-align: left;
}
th:first-child {
border-top-left-radius: 10px;
}
th:last-child {
border-top-right-radius: 10px;
border-right: none;
}
td {
padding: 10px 20px;
background: #95cbee;
}
tr:last-child td:first-child {
border-radius: 0 0 0 10px;
}
tr:last-child td:last-child {
border-radius: 0 0 10px 0;
}
tr td:last-child {
border-right: none;
}
    a {
    text-decoration: none;
    outline: none;
    display: inline-block;
    width: 140px;
    height: 45px;
    line-height: 45px;
    border-radius: 45px;
    font-family: 'Montserrat', sans-serif;
    font-size: 11px;
    text-transform: uppercase;
    text-align: center;
    letter-spacing: 3px;
    font-weight: 600;
    color: #524f4e;
    background: white;
    box-shadow: 0 8px 15px rgba(0,0,0,.1);
    transition: .3s;
    }
    a:hover {
    background: #2EE59D;
    box-shadow: 0 15px 20px rgba(46,229,157,.4);
    color: white;
    transform: translateY(-7px);
    }
</style>
</html>
