<%--
  Created by IntelliJ IDEA.
  User: RyuSiHo
  Date: 2016. 12. 6.
  Time: AM 9:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<html>
<head>
    <title></title>
</head>
<body>
합성된 음성 데이터<br/>
<audio controls="controls">
    <source src="/resources/audio/${filename}" type="audio/mp3"/>
</audio>


</body>
</html>

