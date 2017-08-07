<%-- 
    Document   : hello
    Created on : 05.08.2017, 16:21:33
    Author     : Acer
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head><title>Simple jsp page</title></head>
  <body>
  Hello <%= request.getAttribute("name")%>
  </body>
</html>
