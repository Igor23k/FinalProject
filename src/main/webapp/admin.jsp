<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

    <title>Admin</title>
    <script>
        <%@include file ="/js/jquery-3.2.0.min.js"%>
        <%@include file="/js/admin.js"%>
        <%@include file="/js/bootstrap.min.js"%>
    </script>
    <style>
        <%@include file="/bootstrap/bootstrap.min.css"%>
        <%@include file="/css/admin.css"%>
    </style>
    <script type="text/javascript">
        function Click() {
            document.getElementById("idHrefAdmin").click();
        }
    </script>
</head>
    <body>

        <div class="container" style="padding-left: 0px;margin-left: 0px;width: 100%">
            <div class="row" style="width: 100%;position: relative">
                <div class="col-lg-3" style="width:15%;">
                    <table class="table table-hover table-bordered">
                        <tbody>
                            <c:forEach var="item" items="${items}">
                                <tr><td><input type="text" style="width: 100%" disabled="disabled" value="${item}" class="head"/></td></tr>
                            </c:forEach>
                        </tbody>
                    </table>
                    <br>
                    <button type="button" style="width: 100%" onclick="Click()" class="btn btn-primary">Сайт
                        <a id="idHrefAdmin" href="http://localhost:8080/servlet?rights=4&page=main.jsp&locale=ru&localePage=contentMain"></a>
                    </button>
                </div>
                <div class="col-lg-12" style="float: right;width: 85%;">
                    <table class="table table-bordered table-hover" id="tableHotel" style="border-right: none; border-bottom: none">
                    </table>
                </div>
            </div>
        </div>
        <div id="myModalUpdate" class="modal fade"></div>
        <div id="myModalAdd" class="modal fade"></div>
        <div id="modalWindow"></div>
        <a href="/servlet?action=CREATE_DOC&docname=reservation_voucher&id=11&localePage=contentMain&rights=4">Электронный ваучер на проживание</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=reservation_confirm&id=12&locale=ru&localePage=contentMain&rights=4">Подтверждение брони</a></br>
        <a  href="/servlet?action=CREATE_DOC&docname=room_document&id=2&locale=ru&localePage=contentMain&rights=4">Информация о номере</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=user_document&id=2&locale=ru&localePage=contentMain&rights=4">Информация о пользователе</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=room_type_document&id=2&locale=ru&localePage=contentMain&rights=4">Информация о типе номера</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=room_report&type=by_month&year=2017&id=2&locale=ru&localePage=contentMain&rights=4">Отчет по комнатам по месяцам</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=room_report&type=by_quarter&year=2017&id=2&locale=ru&localePage=contentMain&rights=4">Отчет по комнатам по кварталам</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=financial_report&type=by_month&year=2017&id=2&locale=ru&localePage=contentMain&rights=4">Годовой отчет по месяцам</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=financial_report&type=by_quarter&year=2017&id=2&locale=ru&localePage=contentMain&rights=4">Годовой отчет по кварталам</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=reservation_report&id=13&locale=ru&localePage=contentMain&rights=4">Брони пользователя</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=entity_csv_report&entity=room&locale=ru&localePage=contentMain&rights=4">Отчет по комнатам</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=entity_csv_report&entity=room_type&locale=ru&localePage=contentMain&rights=4">Отчет по типам комнат</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=entity_csv_report&entity=user&locale=ru&localePage=contentMain&rights=4">Отчет по пользователям</a></br>
        <a href="/servlet?action=CREATE_DOC&docname=entity_csv_report&entity=role&locale=ru&localePage=contentMain&rights=4">Отчет по ролям</a></br>
    </body>
</html>
