<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>쇼핑 검색 결과</title>
    <link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div id="fb-root"></div>
<script>(function(d, s, id) {
    var js, fjs = d.getElementsByTagName(s)[0];
    if (d.getElementById(id)) return;
    js = d.createElement(s); js.id = id;
    js.src = "//connect.facebook.net/ko_KR/sdk.js#xfbml=1&version=v2.8&appId=1802383730049027";
    fjs.parentNode.insertBefore(js, fjs);
}(document, 'script', 'facebook-jssdk'));</script>
<div class="row">
    <div class="col-md-6 col-md-offset-3">

        <div class="page-header">
            <h1>쇼핑 검색 결과: 질의어 - ${searchWord}</h1>
        </div>

        <c:forEach var="item" items="${shop.channel.item}">
            <div>${item.title}</div>
            <div>
                <img src=${item.imageUrl} />
            </div>
            <div>${item.priceMin} 원 ~ ${item.priceMax} 원</div>
            <c:forEach var="blog" items="${item.blogs.channel.item}">
                <div>
                    <c:out value="${blog.title}" escapeXml="false" />
                </div>
            </c:forEach>
            <div class="fb-like" data-href=${item.link} data-layout="button_count" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>
            <div>
                <div class="fb-comments" data-href=${item.link} data-numposts="1"></div>
            </div>
        </c:forEach>
    </div>
</div>
</body>
</html>