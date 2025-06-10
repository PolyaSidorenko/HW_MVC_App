<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Все товары</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet"/>
</head>
<body class="container mt-4">
<h1>Список товаров</h1>

<a href="/create" class="btn btn-primary mb-3">Добавить товар</a>

<table class="table text-center align-middle table-bordered table-striped">
    <thead>
    <tr>
        <th style="width: 10%;">Количество</th>
        <th style="width: 40%;">Название</th>
        <th style="width: 20%;">Цена</th>
        <th style="width: 30%;">Действия</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${products}" var="product">
        <tr>
            <td>${product.quantity}</td>
            <td>${product.name}</td>
            <td>${product.price}</td>
            <td>
                <form action="/delete/${product.id}" method="get" style="display:inline;">
                    <button class="btn btn-danger btn-sm" type="submit">Удалить</button>
                </form>
                <a href="/edit/${product.id}" class="btn btn-primary btn-sm">Редактировать</a>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>