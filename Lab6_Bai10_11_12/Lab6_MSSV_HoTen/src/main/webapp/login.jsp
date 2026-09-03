<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Đăng nhập - Lab 6</title>
    <style>
        body { font-family: Arial; background:#f3f6fa; }
        .box { width:360px; margin:80px auto; padding:30px; background:white;
               border-radius:10px; box-shadow:0 2px 12px #bbb; }
        input { width:100%; box-sizing:border-box; padding:10px; margin:8px 0; }
        button { width:100%; padding:10px; background:#1f5b8f; color:white;
                 border:0; cursor:pointer; }
        .error { color:red; }
    </style>
</head>
<body>
<div class="box">
    <h2>ĐĂNG NHẬP</h2>
    <% if (request.getAttribute("error") != null) { %>
        <p class="error">${error}</p>
    <% } %>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label>Tài khoản</label>
        <input type="text" name="username" required>

        <label>Mật khẩu</label>
        <input type="password" name="password" required>

        <button type="submit">Đăng nhập</button>
    </form>
    <p><b>Tài khoản mẫu:</b> admin / admin123</p>
</div>
</body>
</html>
