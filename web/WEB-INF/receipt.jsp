<%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-11
  Time: 오후 5:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri ="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<html>
<head>
    <title>Title</title>
</head>
<div align="center">
    <h1>영수증</h1>
&nbsp;${orderNum}번 손님 주문하신 내역입니다.<br/>
    <c:set var="result" value="${0}"/>
&nbsp;메뉴이름&nbsp;&nbsp;수량&nbsp;&nbsp;단가&nbsp;총합
    <c:forEach items="${orderList}" var="list">
    <li>
        ${list.mname} : ${list.mct} * ${list.mprice} = ${list.total}
    </li>
    <c:set var="result" value="${list.total + result}"/>
    </c:forEach>
<hr/>
<h2>진짜 총합: ${result}원</h2>
</div>
</body>
</html>
