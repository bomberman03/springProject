<%--
  Created by IntelliJ IDEA.
  User: RyuSiHo
  Date: 2016. 12. 6.
  Time: AM 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>기계 앵커</title>
</head>
<body>
네이버 뉴스 검색 API + 음성합성 API<br/>
<form action="/machine_anchor" method="GET">
    <input type="text" name="searchWord" placeholder="검색어" required/></br>
    <input type="submit" value="검색">
</form>
</body>
</html>