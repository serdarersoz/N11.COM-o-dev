<%--
  Created by IntelliJ IDEA.
  User: serdar
  Date: 21.10.2015
  Time: 15:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Bilgileri güncelle</title>

  <link rel="stylesheet" href="/resources/style.css" />

</head>
<body>

<form action="/update" method="get"  >

  <input type="text" name="facebook" placeholder="Facebook adresinizi giriniz" />
  <input type="text" name="twitter" placeholder="Twitter adresinizi giriniz" />
  <input type="text" name="instagram" placeholder="Instagram adresinizi giriniz" />

  <input type="hidden" name="target"  value="save-social">

  <input type="submit" value="Gönder" />
</form>

<form action="/update" method="get"  >

  <input type="date" name="birthdate" placeholder="Doğum tarihinizi giriniz" />
  <input type="text" name="education" placeholder="Eğitim bilgilerinizi giriniz" />
  <input type="text" name="experience" placeholder="İş tecrübelerinizi giriniz" />
  <input type="hidden" name="target"  value="save-resume">

  <input type="submit" value="Gönder" />



</form>


<h3>${message}</h3>

</body>
</html>
