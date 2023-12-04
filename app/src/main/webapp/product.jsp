<%--@elvariable id="product" type="tigi.servlet.model.SanPham"--%>
<%--@elvariable id="form_method" type="java.lang.String"--%>
<%--@elvariable id="notify" type="java.lang.String"--%>
<%--@elvariable id="form_action" type="java.lang.String"--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>product</title>
  <link
    href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
    rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
    crossorigin="anonymous">
</head>
<body>

<jsp:include page="header.jsp"/>

<span class="alert">
  ${notify}
</span>

<div>
  <form action="${form_action}" method="${form_method}">
    <div class="form-control">
      <c:if test="${form_action.contains('/update')}">
        <input type="hidden" name="id" value="${product.id}">
      </c:if>
    </div>
    <div class="form-group">
      <label for="ma" class="form-label">ma</label>
      <input value="${product.ma}" id="ma" name="ma" class="form-control" type="text">
    </div>
    <div class="form-group">
      <label for="ten" class="form-label">ten</label>
      <input value="${product.ten}" id="ten" name="ten" class="form-control" type="text">
    </div>
    <div class="form-group">
      <button type="submit" class="form-control btn btn-primary">${form_action.contains('/update') ? 'update' : 'add'}</button>
    </div>
  </form>
</div>

<div class="row">
  <button class="btn btn-primary">
    <a href="/product">add new product</a>
  </button>
</div>

<div>
  <table>
    <thead>
    <tr>
      <th>ma san pham</th>
      <th>ten san pham</th>
    </tr>
    </thead>
    <tbody>
    <%--@elvariable id="products" type="java.util.List<tigi.servlet.model.SanPham>"--%>
    <c:forEach var="i" items="${products}">
      <tr>
        <td>${i.ma}</td>
        <td>${i.ten}</td>
        <td>
          <button class="btn btn-primary">
            <a class="link" href="/product/detail?id=${i.id}">detail</a>
          </button>
          <button class="btn btn-primary">
            <a class="link" href="/product/update?id=${i.id}">update</a>
          </button>
          <button class="btn btn-primary">
            <a class="link" href="/product/delete?id=${i.id}">delete</a>
          </button>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
