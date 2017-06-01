<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<fmt:setLocale value="ru"/>
<fmt:setBundle basename="hotel.localization.pagecontent" var="lang"/>

<html>
<head>
    <title>лолкек</title>
    <link href="css/style.css" rel="stylesheet" type="text/css" />
</head>
<script>
    function changeLocale(locale) {
        alert("Locale: " + locale);
        $.ajax({
            type: 'POST',
            url: '/servlet?locale='+locale+"&page=index.jsp",
            success: function (result) {
                alert("Запрос вернулся!")
                alert(result);
                alert(result.toString());
            }});
    }
</script>
<body>
<c:set var="data22" value="${data2}"/>
<div class="dropdown">
    <div class="dropbtn">RU</div>
    <div class="dropdown-content">
        <a onclick='changeLocale("RU")'>RU</a>
        <a onclick='changeLocale("EN")'>EN</a>
    </div>
</div>
<br>
<em>${data22}</em>
<em>${data22}</em>
</body>
</html>