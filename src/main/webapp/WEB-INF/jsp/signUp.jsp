<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>FWA</title>
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/sign_up.css">
</head>
<script>
</script>
<body>
<form name="registration" method="post" action="http://localhost:8080/signUp">
    <h1 class="title">FWA</h1>

    <div class="fields">
        <input class="field" type="text" name="first_name" placeholder="Имя" required>
        <input class="field" type="text" name="last_name" placeholder="Фамилия" required>
        <input class="field" type="text" name="phone" placeholder="Телефон" required>
        <input class="field" type="password" id="password" name="password" placeholder="Пароль" required>
        <input class="field" type="password" id="confirm_password" name="password" placeholder="Повторите пароль" required>
    </div>

    <input class="button" type="submit" value="Зарегистрироваться">

</form>
</body>
</html>