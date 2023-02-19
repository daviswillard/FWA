<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FWA</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400&family=Sawarabi+Gothic&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sign_in.css">
</head>
<body>
<form name="sign_in" method="post" action="http://localhost:8080/signIn">
    <h1 class="title">FWA</h1>
    <div class="fields">
        <input class="field" type="text" name="phone" placeholder="Телефон" required>
        <input class="field" type="password" name="password" placeholder="Пароль" required>
    </div>
    <input class="button" type="submit" value="Войти">
</form>
</body>
</html>