<%@ page import="org.zerock.web.dao.MenuDAO" %>
<%@ page import="org.zerock.web.domain.MenuVO" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: 5CLASS-184
  Date: 2018-09-10
  Time: 오후 2:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  MenuDAO dao = new MenuDAO();
  List<MenuVO> menuVOList = dao.getList();
%>


<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>

  <form action="test" method="post">

  <% for(MenuVO vo : menuVOList){ %>

  <h1><%=vo.getMname()%></h1>

  <img src="img/<%=vo.getImg()%>">

  <h1><%=vo.getPrice()%></h1>

  <label>주문수량</label>
  <select class="form-control" name="mct">
    <option value="<%=vo.getMno()%>_0" selected>0</option>
    <option value="<%=vo.getMno()%>_1">1</option>
    <option value="<%=vo.getMno()%>_2">2</option>
    <option value="<%=vo.getMno()%>_3">3</option>
    <option value="<%=vo.getMno()%>_4">4</option>
    <option value="<%=vo.getMno()%>_5">5</option>
  </select>

  <%}%>
    <button>주문하기</button>
  </form>

  </body>
</html>
