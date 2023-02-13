<%--
  Created by IntelliJ IDEA.
  User: kamil
  Date: 03.02.2023
  Time: 19:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Cinema</title>
</head>
<body>

    <div class="form">

        <h1>Вход в систему</h1>
        <form method="post" action="http://localhost:8080/signIn">

            <label for="phoneNumber">Номер телефона</label><br>
            <input id="phoneNumber" type="text" required size="12" name="phoneNumber"><br>

            <label for="password">Пароль</label><br>
            <input id="password" type="password" required placeholder="password" name="password"><br><br>
            <input class="button" type="submit" value="Войти">

        </form>

    </div>

</body>
</html>
