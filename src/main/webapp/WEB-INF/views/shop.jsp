<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit</title>
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
<h2>쇼핑 검색 결과: 질의어 - ${searchWord}</h2>

<c:forEach var="item" items="${shop.channel.item}">
    <div>${item.title}</div>
    <div>
        <img src=${item.imageUrl} />
    </div>
    <div>${item.priceMin} 원 ~ ${item.priceMax} 원</div>
    <c:forEach var="blog" items="${item.blogs.channel.item}">
        <div>
            ${blog.title}
        </div>
    </c:forEach>
    <div class="fb-like" data-href=${item.link} data-layout="button_count" data-action="like" data-size="small" data-show-faces="true" data-share="true"></div>
    <div>
        <div class="fb-comments" data-href=${item.link} data-numposts="1"></div>
    </div>
</c:forEach>
</body>
</html>