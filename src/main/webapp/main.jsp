<%@ taglib prefix="ex" uri="WEB-INF/custom.tld"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en" lang="en">

<head>

    <title>Main</title>
    <script type="text/javascript" src="js/jquery-3.2.0.min.js"></script>
    <script src="js/bootstrap.js" type="text/javascript"></script>
    <script type="text/javascript" src="js/SPA_JS.js"></script>
    <script type="text/javascript" src="js/main/main.js"></script>
    <script src="js/formScript.js" type="text/javascript"></script>
    <script type="text/javascript" src=js/formScript.js></script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="Content-Style-Type" content="text/css" />
    <link rel="stylesheet" href="bootstrap/bootstrap.css">
    <link rel="stylesheet" href="css/styleSignIn.css">
    <link href="css/style.css" rel="stylesheet" type="text/css" />
    <link href="css/layout.css" rel="stylesheet" type="text/css" />
    <script src="js/maxheight.js" type="text/javascript"></script>

    <!--[if lt IE 7]>
    <link href="ie_style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="ie_png.js"></script>
    <script type="text/javascript">
        ie_png.fix('.png, #header .row-2, #header .nav li a, #content, .gallery li');
    </script>
    <![endif]-->

    <%--<link type="text/css" href="css/gallery/bottom.css" rel="stylesheet" />

    <script type="text/javascript" src="js/gallery/jquery.js"></script>
    <script type="text/javascript" src="js/gallery/pikachoose-min.js"></script>--%>



</head>
<body class="contentMain" onload="new ElementMaxHeight();">
<div id="main">
    <ex:GetDate/>
    <div class="dropdown">
        <div class="dropbtn">RU</div>
        <div class="dropdown-content">
            <a onclick='changeLocale("ru")'>RU</a>
            <a onclick='changeLocale("en")'>EN</a>
        </div>
    </div>
    <c:set var="data" value="${data}"/>


    <div id="header">
        <div class="row-1">
            <div class="wrapper">
                <div class="logo">
                    <h1><a id="hotelName" href="main.jsp">${data.hotelName}</a></h1>
                    <strong id="luxury">${data.luxury}</strong>
                </div>
                <div>
                    <div class="phones">
                        +375(29)179-07-46
                        <br>
                        <div id="idAdminRef" style="display: none">
                            <a id="admin" href="/servlet?page=admin.jsp&action=ADMIN_START&locale=ru&localePage=admin">${data.admin}</a>
                        </div>
                        <div id="idPersonalAreaRef" style="display: none">
                            <a id="personalArea" href="#personalInfo">${data.personalArea}</a>
                        </div>
                    </div>

                </div>
            </div>
        </div>
        <div class="row-2">
            <div class="indent">
                <div class="header-box">
                    <div class="inner">
                        <ul class="nav">
                            <li><a id="mainRefHeader" href="#contentMain" class="current">${data.mainRefHeader}</a></li>
                            <li><a id="servicesHeader" href="#contentServices" id="idServicesA">${data.servicesHeader}</a></li>
                            <li><a id="galleryHeader" href="#contentGallery">${data.galleryHeader}</a></li>
                            <li><a id="testimonialsHeader" href="#contentTestimonials">${data.testimonialsHeader}</a></li>
                            <li><a id="idBookingAHeader">${data.idBookingAHeader}</a></li>
                            <li><a id="singinHeader" href="#entry" click="" >${data.singinHeader}</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <div id="content">
        <section id=contentMain class="container" src="/templates/pages/main/contentMain.html"></section>
        <section id=contentBooking class="container" src="/templates/pages/booking/contentBooking.html"></section>
        <section id=contentGallery class="container" src="/templates/pages/gallery/contentGallery.html"></section>
        <section id=contentServices class="container" src="/templates/pages/services/contentServices.html"></section>
        <section id=entry class="container" src="/templates/pages/signin/entry.html"></section>
        <section id=contentTestimonials class="container" src="/templates/pages/testimonials/contentTestimonials.html"></section>
        <section id=personalInfo class="container" src="/templates/pages/signin/personalInfo.html"></section>
    </div>
    <div id="footer" style="width: 976px;margin: auto">
        <ul class="nav nav-pills" style="align:center;">
            <li><a id="mainRef" href="#contentMain" class="current">${data.mainRef}</a></li>
            <li><a id="services" href="#contentServices">${data.services}</a></li>
            <li><a id="testimonials" href="#contentTestimonials">${data.testimonials}</a></li>
            <li><a id="booking" href="#contentBooking">${data.booking}</a></li>
            <li><a id="singin" href="#entry">${data.singin}</a></li>
        </ul>
        <div class="wrapper">
            <div class="fleft" id="rights">${data.rights}</div>
        </div>
    </div>
</div>
</body>
</html>