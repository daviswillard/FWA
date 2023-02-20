<%--
  Created by IntelliJ IDEA.
  User: kamil
  Date: 20.02.2023
  Time: 09:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="user" scope="session" type="edu.school21.cinema.models.User"/>
<html>
<head>
  <title>FWA</title>
  <link rel="stylesheet" href="/css/profile.css">
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Oswald:wght@200;400&family=Sawarabi+Gothic&display=swap" rel="stylesheet">
</head>
<body>
<h1 class="title">Мой профиль</h1>
<div class="content">
  <div class="left_block">
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
      <input type="file" name="file" style="display:none;" />
      <button id="button" name="button" value="Upload" onclick="submit()">Upload</button>
    </form>
  </div>

  <div class="right_block">
    <div class="info">
      <p>${user.firstName} ${user.lastName}</p>
      <p>${user.phoneNumber}</p>
    </div>
    <table class="authentications">
        <tr>
          <th>Date</th>
          <th>Time</th>
          <th>IP</th>
        </tr>
      <tbody>
        <c:forEach var="login" items="${user.logins}">
          <tr>
            <td><fmt:formatDate value="${login.loginTime}" pattern="MMMM dd, yyyy"/></td>
            <td><fmt:formatDate value="${login.loginTime}" pattern="HH:mm"/></td>
            <td><c:out value="${login.ipAddress}"/></td>
          </tr>
        </c:forEach>
      </tbody>
    </table>
    <table class="images">
      <tr>
        <th>Filename</th>
        <th>Size</th>
        <th>MIME</th>
      </tr>
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
          <td><c:out value="${image.mime}"/></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</div>
</body>
</html>
