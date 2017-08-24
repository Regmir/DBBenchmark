<%-- 
    Document   : result
    Created on : 10.08.2017, 11:45:36
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
<title>Result</title>
<body>
<header>
    <h1>Result</h1>
</header>

<!--
    span - тег, в котором указали цвет.
-->
<!--<span style="color: #dc143c; ">${query} : </span> ${number}
<br/>
Average: ${Avg}
<br/>
Min: ${Min}
<br/>
Max: ${Max}
<br/>
Total: ${Total}-->
<br/>
<table>
            <tr>
                <th>Type</th><th>Number</th>
                <th>Avg</th><th>Min</th>
                <th>Max</th><th>Total</th>
            </tr>
                <tr>
                    <td>${query}</td>
                    <td>${number}</td>
                    <td>${Avg}</td>
                    <td>${Min}</td>
                    <td>${Max}</td>
                    <td>${Total}</td>
                </tr>
</table>
<br/>
<a href="index.htm">Back to main</a>
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
    body {background:url(web/WEB-INF/images/background39.png);}
    header {font-family: 'Montserrat', sans-serif;}
    a {
    text-decoration: none;
    outline: none;
    display: inline-block;
    width: 140px;
    height: 45px;
    line-height: 45px;
    border-radius: 45px;
    margin: 1px;
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
