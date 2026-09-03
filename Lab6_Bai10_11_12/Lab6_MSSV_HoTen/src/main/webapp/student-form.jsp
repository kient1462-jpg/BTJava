<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Thêm sinh viên</title>
    <style>
        body { font-family:Arial; width:500px; margin:40px auto; }
        input { width:100%; box-sizing:border-box; padding:9px; margin:7px 0 15px; }
        button { padding:10px 20px; background:#1f5b8f; color:white; border:0; }
        .error { color:red; }
    </style>
</head>
<body>
<h2>THÊM SINH VIÊN</h2>

<% if (request.getAttribute("error") != null) { %>
    <p class="error">${error}</p>
<% } %>

<form action="${pageContext.request.contextPath}/students" method="post">
    <label>Mã sinh viên</label>
    <input type="text" name="id" required>

    <label>Họ tên</label>
    <input type="text" name="name" required>

    <label>Lớp</label>
    <input type="text" name="className" required>

    <label>Điểm</label>
    <input type="number" name="score" min="0" max="10" step="0.1" required>

    <button type="submit">Lưu</button>
</form>
</body>
</html>
