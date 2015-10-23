<%--
  Created by IntelliJ IDEA.
  User: serdar
  Date: 21.10.2015
  Time: 19:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>

  <link rel="stylesheet" href="/resources/style.css" />

</head>
<body>


<h2> Serdar ERSÖZ </h2>

<img src="https://scontent-ams2-1.xx.fbcdn.net/hphotos-xfp1/l/t31.0-8/p960x960/10549065_10152788590433850_5472645626452194207_o.jpg" width="250px" height="auto" />


<div >

  <div>
    <span>Doğum Tarihi : </span>
    <span>${info["birthdate"]}</span>
  </div>
  <div>
    <span>Eğitim : </span>
    <span>${info["education"]}</span>
  </div>
  <div>
    <span>Tecrübeler : </span>
    <span>${info["experience"]}</span>
  </div>


</div>
</body>
</html>
