<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
  <title>Создание товара</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-4">
<h1>Добавить товар</h1>

<form:form method="post" modelAttribute="product" action="/save">
  <div class="mb-3">
    <form:label path="name">Название:</form:label>
    <form:input path="name" cssClass="form-control"/>
  </div>

  <div class="mb-3">
    <form:label path="price">Цена:</form:label>
    <form:input path="price" cssClass="form-control"/>
  </div>

  <button type="submit" class="btn btn-success">Сохранить</button>
  <a href="/products" class="btn btn-secondary">Отмена</a>
</form:form>
</body>
</html>