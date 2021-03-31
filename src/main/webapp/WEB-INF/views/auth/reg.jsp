<%@page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <!-- Required meta tags -->
    <link rel="shortcut icon" type="image/png" href="favicon.ico"/>
    <!-- Bootstrap CSS -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js" type="text/javascript"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <!-- Custom CSS -->
    <link type="text/css" rel="stylesheet" href="<c:url value='/resources/css/style.css'/>"/>
    <title>Форум об отдыхе</title>
</head>
<body>
<div class="container">
    <div class="row justify-content-end">
        <ul class="nav">
            <li class="nav-item">
                <a class="nav-link" href='<c:url value="/"/>'>Главная</a>
            </li>
        </ul>
    </div>
</div>
<div class="container">
    <br>
    <div class="card bg-light">
        <article class="card-body mx-auto" style="max-width: 400px;">
            <h4 class="card-title mt-3 text-center">Регистрация</h4>
            <form action='<c:url value="/reg" />' method="post">
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <em class="fa fa-user"></em> </span>
                    </div>
                    <c:choose>
                        <c:when test="${nameError != null}">
                            <input name="username" class="form-control form-control-my" placeholder="${nameError}"
                                   type="text" required>
                        </c:when>
                        <c:otherwise>
                            <input name="username" class="form-control" placeholder="Имя" type="text" required>
                        </c:otherwise>
                    </c:choose>
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <em class="fa fa-envelope"></em> </span>
                    </div>
                    <c:choose>
                        <c:when test="${emailError != null}">
                            <input name="email" class="form-control form-control-my" placeholder="${emailError}"
                                   type="text" required>
                        </c:when>
                        <c:otherwise>
                            <input name="email" class="form-control" placeholder="Email" type="email" required>
                        </c:otherwise>
                    </c:choose>
                </div> <!-- form-group// -->
                <div class="form-group input-group">
                    <div class="input-group-prepend">
                        <span class="input-group-text"> <em class="fa fa-lock"></em> </span>
                    </div>
                    <input name="password" id="password" class="form-control" placeholder="Введите пароль"
                           type="password" required>
                </div> <!-- form-group// -->
                <div class="form-group">
                    <button type="submit" class="btn btn-primary btn-block"> Создать</button>
                </div> <!-- form-group// -->
                <p class="text-center">У вас есть аккаунт? <a href='<c:url value="/login"/>'> Войти</a></p>
            </form>
        </article>
    </div> <!-- card.// -->

</div>
<!--container end.//-->
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
        integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
        crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js"
        integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
        crossorigin="anonymous"></script>
</body>
</html>
