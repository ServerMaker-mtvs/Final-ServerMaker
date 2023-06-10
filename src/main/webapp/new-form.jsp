<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 2023-06-09
  Time: 오후 1:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>ServerMaker-Final</h1>
    <form action="regist" method="post">
        <label>이름 : </label>
        <input type="text" name="memberName">
        <br>
        <br>
        <label>아이디 : </label>
        <input type="text" name="memberId">
        <br>
        <br>
        <label>비밀번호 : </label>
        <input type="password" name="memberPwd1">
        <br>
        <br>
        <label>비밀번호 확인 : </label>
        <input type="password" name="memberPwd2">
        <br>
        <br>
        <label>생년월일 : </label>
        <input type="date" name="memberBirth">
        <br>
        <br>
        <button type="submit">회원가입</button>
    </form>
</body>
</html>
