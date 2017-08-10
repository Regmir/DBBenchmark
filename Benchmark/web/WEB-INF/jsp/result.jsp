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
<h1>Result</h1>
<!--
    span - тег, в котором указали цвет.
-->
<span style="color: #dc143c; ">${query} : </span> ${number}
<br/>
Average: ${Avg}
<br/>
Min: ${Min}
<br/>
Max: ${Max}
<br/>
Total: ${Total}
<br/>
<a href="index.htm"> << Back to home</a>
</body>
</html>
