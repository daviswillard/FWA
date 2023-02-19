<%--
  Created by IntelliJ IDEA.
  User: kamil
  Date: 19.02.2023
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
  };
</script>
<body>
<h1 class="title">Мой профиль</h1>
<div class="content">
  <div class="left_block">
    <img alt="kisa" src="/images/kisa.jpeg" class="pic">
    <form method="post" action="http://localhost:8080/images">
      <input type="file" id="file" style="display:none;" />
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
