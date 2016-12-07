<%--
  Created by IntelliJ IDEA.
  User: hwangsanghyeok
  Date: 06/12/2016
  Time: 9:54 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>

<head>
    <meta charset="utf-8">
    <title>Abandom API Example</title>


    <%--도, 광역시 json 파일--%>
    <script id="province" type="application/json" src="/resources/data/province.json"></script>
    <script type="text/javascript" src="/resources/scripts/jquery-3.1.1.min.js"></script>

</head>
<body>
<input type="date" id="startDate"><br>
<input type="date" id="endDate"><br>
<button type="button" id="searchBtn">조회</button>
<div id="abandonList">
</div>

</body>
</html>

<script>

    //search Button click method
    $("#searchBtn").click(function () {
        //get date from input
        var startDate = new Date(document.getElementById("startDate").value);

        var endDate = new Date(document.getElementById("endDate").value);

        var startYYYY = startDate.getUTCFullYear().toString();
        var startMM = convertNum(startDate.getUTCMonth(), "MM");
        var startDD = convertNum(startDate.getUTCDate());

        var endYYYY = endDate.getUTCFullYear().toString();
        var endMM = convertNum(endDate.getUTCMonth(), "MM");
        var endDD = convertNum(endDate.getUTCDate());

        startDate = startYYYY + startMM + startDD;
        endDate = endYYYY + endMM + endDD;

//        console.log(startDate);
//        console.log(endDate);


        //ajax call
        $.ajax({
            url: "abandonment"
            + "?bgnde=" + startDate
            + "&endde=" + endDate,
            type: "GET",
            dataType: "JSON",
            success: function (data) {
                console.log(data.response.body);
                $('#abandonList').empty();

                for (var i = 0; i < data.response.body.items.item.length; i++) {
                    $('#abandonList').append(
                            $("<li>"
                            + "접수일 : " + data.response.body.items.item[i].happenDt + "<br>"
                            + "품종 : " + data.response.body.items.item[i].kindCd + "<br>"
                            + "보호장소 : " + data.response.body.items.item[i].careAddr + ' '
                            + data.response.body.items.item[i].careNm+"<br>"
                            + "<a href='" + data.response.body.items.item[i].popfile + "'>"
                            + "<img src='" + data.response.body.items.item[i].filename + "'>"
                            + "</a>"
                            + "</li>")
                    );
                }
            },
            error: function () {
                alert("Error~!");
            }

        });
    });


    function convertNum(num, desc) {
        if (desc == "MM") {
            num++;
        }


        if (num < 10) {
            return "0" + num;
        } else {
            return num;
        }
    }
</script>

