<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
</head>
<body>
쇼핑 검색<br/>
<form action="/shop" method="GET">
    <input type="text" name="searchWord" placeholder="검색어"/>
    <input type="submit" value="검색">
</form>
</body>
</html>