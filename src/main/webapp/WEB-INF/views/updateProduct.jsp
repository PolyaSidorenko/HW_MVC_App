<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Редактировать товар</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-4">
<h1>Редактировать товар</h1>

<form action="${pageContext.request.contextPath}/update" method="post">
  <input type="hidden" name="id" value="${product.id}" />
  <div class="mb-3">
    <label class="form-label">Название:</label>
    <input type="text" class="form-control" name="name" value="${product.name}" required />
  </div>
  <div class="mb-3">
    <label class="form-label">Цена:</label>
    <input type="number" class="form-control" name="price" value="${product.price}" required />
  </div>
  <div class="mb-3">
    <label class="form-label">Количество:</label>
    <input type="number" class="form-control" name="quantity" value="${product.quantity}" required />
  </div>
  <button type="submit" class="btn btn-success">Сохранить</button>
  <a href="/products" class="btn btn-secondary">Отмена</a>
</form>
</body>
</html>