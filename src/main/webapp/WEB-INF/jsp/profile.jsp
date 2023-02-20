<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%--
  Created by IntelliJ IDEA.
  User: kamil
  Date: 19.02.2023
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>FWA</title>
  <link rel="stylesheet" href="/css/profile.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400&family=Sawarabi+Gothic&display=swap" rel="stylesheet">
</head>
<script>
  function thisFileUpload() {
    document.getElementById("file").click();
  }
</script>
<body>
<h1 class="title">Мой профиль</h1>
<div class="content">
  <div class="left_block">
    <img alt="kisa" src="/images/kisa.jpeg" class="pic">
    <form method="post" action="http://localhost:8080/images">
      <input type="file" id="file" accept="image/png, image/jpeg" style="display:none;" />
      <button id="button" name="button" value="Upload" onclick="thisFileUpload();">Upload</button>
    </form>
  </div>

  <div class="right_block">
    <div class="info">
      <p>Юлия Куликова</p>
      <p>89196361742</p>
    </div>
    <table class="authentications">
      <tr>
        <th>Date</th>
        <th>Time</th>
        <th>IP</th>
      </tr>
      <tr>
        <td>Alfreds Futterkiste</td>
        <td>Maria Anders</td>
        <td>Germany</td>
      </tr>
      <tr>
        <td>Centro comercial Moctezuma</td>
        <td>Francisco Chang</td>
        <td>Mexico</td>
      </tr>
    </table>
    <table class="images">
      <tr>
        <th>Filename</th>
        <th>Size</th>
        <th>MIME</th>
      </tr>
      <tr>
        <td>Alfreds Futterkiste</td>
        <td>Maria Anders</td>
        <td>Germany</td>
      </tr>
      <tr>
        <td>Centro comercial Moctezuma</td>
        <td>Francisco Chang</td>
        <td>Mexico</td>
      </tr>
    </table>
  </div>
</div>
</body>
</html>
--%>
<jsp:useBean id="user" scope="session" type="edu.school21.cinema.models.User"/>
<html>
<head>
  <title>$Title$</title>
  <style><%@include file="/css/index.css"%></style>
</head>
<body>
<div class="head">
  <div class="block1">
    <img class="image" alt="Avatar"
      <c:choose>
        <c:when test="${user.images.size() > 0}">
         src="<c:out value="data:${user.images.get(user.images.size() - 1).mime};base64,${sessionScope.img}"/>"/>
        </c:when>
        <c:otherwise>
          src="/"/>
        </c:otherwise>
      </c:choose>
    <form method="post" action="/profile" enctype="multipart/form-data">
      <div class="upload">
        <label>
          <input type="file" name="file" accept="image/png, image/jpeg"><br/>
          <input type="submit" value="Upload">
        </label>
      </div>
    </form>
  </div>
  <div class="block2">
    <h1>${user.firstName} ${user.lastName}</h1>
    <p>Phone: ${user.phoneNumber}</p>
    <table class="table">
      <thead >
      <tr>
        <th style="text-align:left">Дата</th>
        <th style="text-align:left">Время</th>
        <th style="text-align:left">IP</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach var="login" items="${user.logins}">
        <tr>
          <td>
            <fmt:formatDate value="${login.loginTime}" pattern="MMMM dd, yyyy"/>
          </td>
          <td>
            <fmt:formatDate value="${login.loginTime}" pattern="HH:mm"/>
          </td>
          <td>
            <c:out value="${login.ipAddress}"/>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</div>
<div class="middle">
  <table class="table2">
    <thead>
    <tr>
      <th style="text-align: left">Название файла</th>
      <th style="text-align: left">Размер</th>
      <th style="text-align: left">MIME</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="image" items="${user.images}">
      <tr>
        <td>
          <a href="image/<c:out value="${image.uniqueName}"/>" target="_blank">
            <c:out value="${image.realName}"/>
          </a>
        </td>
        <td>
          <c:set var="size" value="${image.size / 1000}"/>
          <c:choose>
            <c:when test="${size >= 1000}">
              <fmt:formatNumber value="${size / 1000}" pattern="0.0"/> MB
            </c:when>
            <c:otherwise>
              <fmt:formatNumber value="${size}" pattern="0"/> KB
            </c:otherwise>
          </c:choose>
        </td>
        <td>
          <c:out value="${image.mime}"/>
        </td>
      </tr>
    </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>
