<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

<!DOCTYPE html>
<html>

<head></head>
<body>
    <div class="header" style="background: blanchedalmond; text-align: center" >
        <h1>ServerMaker</h1>
    </div>
    <div class="body" style="text-align: center; background: antiquewhite">
        <form action="new-form">
            <button type="submit"><a href="new-form.jsp" style="text-decoration: none">회원가입</a></button>
        </form>
        <br>
        <form action="members" method="get">
            <button>회원목록</button>
        </form>
    </div>
    <div class="footer" style="background: black; text-align: center; margin-bottom: 0%">
        <h3>footer</h3>
    </div>
</body>
</html>