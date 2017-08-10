<%-- 
    Document   : menu
    Created on : 10.08.2017, 11:05:36
    Author     : Acer
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<title>Menu</title>
<body>
<h1>Menu</h1>
<form method="post" action="/Benchmark/Action.htm">
    <p><b>Query type:</b><Br>
    <input type="radio" name="query" value="Create">Create<Br>
    <input type="radio" name="query" value="Read">Read<Br>
    <input type="radio" name="query" value="Update">Update<Br>
    <input type="radio" name="query" value="Delete">Delete<Br>
    <label for="author">Number:</label>
    <input type="number" id="num" name="number"/>
    <input type="submit" value="send"/>
</form>
</body>
</html>