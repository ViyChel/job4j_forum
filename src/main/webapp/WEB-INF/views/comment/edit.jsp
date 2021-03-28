<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css"
      integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<title>Форум о главном</title>
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
<div class="container mt-3">
    <div class="row">
        <div class="card" style="width: 100%">
            <div class="card-header">
                <c:choose>
                    <c:when test="${comment.id == 0}">
                        Новый комментарий
                    </c:when>
                    <c:otherwise>
                        Редактирование комментария
                    </c:otherwise>
                </c:choose>
            </div>
            <div class="card-body">
                <form action="<c:url value='/comment/create'/>" method="post">
                    <input type="hidden" value="${comment.id}" name="commentId">
                    <input type="hidden" value="${post.id}" name="postId">
                    <div class="form-group">
                        <label>Тема поста:</label>
                        <input type="text" class="form-control" name="name" value="${post.name}" readonly>
                    </div>
                    <div class="form-group">
                        <label>Автор:</label>
                        <input type="text" class="form-control" name="username" value="${post.author.username}"
                               readonly>
                    </div>
                    <div class="form-group">
                        <label>Комментарий:</label>
                        <textarea name="text" class="form-control" placeholder="Введите текст комментария" cols="100"
                                  rows="5" required>${comment.message}</textarea>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="btn btn-primary">Сохранить</button>
                    </div>
                </form>
            </div>
        </div>
    </div>
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