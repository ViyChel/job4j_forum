<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
          integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>Форум о главном</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-end">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/"/>'>Главная</a>
            </li>
            <li class="nav-item">
                <a class="nav-link"
                   href='<c:url value="/logout"/> '> <c:out value="${user.username}"/> | Выйти
                </a>
            </li>
        </ul>
    </div>
</div>

<div class="container">
    <br>
    <div class="row">
        <div class="container border border-primary rounded">
            <p><b>Тема:</b> <c:out value="${post.name}"/></p>
            <p><b>Автор:</b> <c:out value="${post.author.username}"/></p>
            <p><b>Описание:</b> <c:out value="${post.description}"/></p>
            <p><b>Дата создания:</b> <c:out value="${post.formattedDateTime()}"/></p>
        </div>
        <div class="card-body mt-1">
            <a href="<c:url value='/post/edit/${post.id}'/>" class="btn btn-outline-primary"
               role="button">Редактировать</a>
        </div>
        <div class="card-body mt-1">
            <a href="<c:url value='/post/delete/${post.id}'/>" class="btn btn-outline-primary" role="button">Удалить</a>
        </div>
        <div class="card-body mt-1">
            <a href="<c:url value='/comment/new/${post.id}'/>" class="btn btn-outline-primary" role="button">Добавить
                комментарий</a>
        </div>
        <c:forEach items="${comments}" var="comment">
            <c:if test="${comment.post.id == post.id}">
                <div class="container border border-primary rounded mt-1">
                    <p><b>Автор:</b> <c:out value="${comment.author.username}"/></p>
                    <p><b>Дата создания:</b> <c:out value="${comment.formattedDateTime()}"/></p>
                    <p><b>Комментарий:</b> <c:out value="${comment.message}"/></p>
                </div>
            </c:if>
        </c:forEach>
    </div>
    <br>
</div>

<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"
        integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI"
        crossorigin="anonymous"></script>

</body>
</html>