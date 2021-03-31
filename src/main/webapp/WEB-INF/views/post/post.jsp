<%@ page contentType="text/html;charset=UTF-8" %>
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

    <title>Форум об отдыхе</title>
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
                   href='<c:url value="/logout"/> '> <c:out value="${username}"/> | Выйти
                </a>
            </li>
        </ul>
    </div>
</div>

<div class="container">
    <br>
    <div class="row">
        <div class="container border border-primary rounded">
            <p><strong>Тема:</strong> <c:out value="${post.name}"/></p>
            <p><strong>Автор:</strong> <c:out value="${post.author.username}"/></p>
            <p><strong>Описание:</strong> <c:out value="${post.description}"/></p>
            <p><strong>Дата создания:</strong> <c:out value="${post.formattedDateTime()}"/></p>
            <c:if test="${post.author.username == username}">
                <div class="row mb-3">
                    <div class="col-md-2">
                        <a href="<c:url value='/post/edit/${post.id}'/>" class="btn btn-outline-primary"
                           role="button">Редактировать</a>
                    </div>
                    <div class="col-md-10">
                        <a href="<c:url value='/post/delete/${post.id}'/>" class="btn btn-outline-primary"
                           role="button">Удалить</a>
                    </div>

                </div>
            </c:if>
        </div>
    </div>
    <div class="row mt-2">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <span>Комментарии </span>
                <c:if test="${post.comments.size() != 0}">
                    <c:out value="${post.comments.size()}"/>
                </c:if>
            </div>
            <div class="card-body mb-2">
                <u><a href="<c:url value='/comment/new/${post.id}'/>"> Добавить комментарий </a></u>
            </div>
            <c:forEach items="${post.comments}" var="comment">
                <div class="ml-3 mb-1">
                    <img src="<c:url value='/resources/img/user.svg'/>" width="30px"
                         height="30px" alt="user_icon"/>
                    <span class="lead ml-1">
                                    <c:out value="${comment.author.username}"/>
                                </span>
                    <span class="text-muted ml-3">
                                    <c:out value="${comment.formattedDateTime()}"/>
                                </span>
                    <p><span class="ml-5"><c:out value="${comment.message}"/></span></p>
                </div>
            </c:forEach>
        </div>
    </div>
</div>
<br>

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