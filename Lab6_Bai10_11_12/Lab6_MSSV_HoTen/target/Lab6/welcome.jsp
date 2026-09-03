<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard</title>
    <style>
        body { font-family:Arial; margin:0; background:#f4f6f8; }
        .header { background:#1f5b8f; color:white; padding:20px 40px; }
        .container { width:90%; max-width:1000px; margin:30px auto; }
        .cards { display:flex; gap:20px; flex-wrap:wrap; }
        .card { background:white; padding:25px; border-radius:10px;
                min-width:220px; box-shadow:0 2px 8px #ccc; }
        .number { font-size:32px; font-weight:bold; }
        a { text-decoration:none; color:#1f5b8f; }
        .btn { display:inline-block; padding:10px 15px; background:#1f5b8f;
               color:white; border-radius:5px; margin-top:15px; }
    </style>
</head>
<body>
<div class="header">
    <h1>Dashboard quản lý sinh viên</h1>
    Xin chào: <b>${sessionScope.username}</b>
</div>

<div class="container">
    <div class="cards">
        <div class="card">
            <h3>Tên người dùng</h3>
            <div>${sessionScope.username}</div>
        </div>

        <div class="card">
            <h3>Tổng số sinh viên</h3>
            <div class="number">${totalStudents}</div>
        </div>

        <div class="card">
            <h3>Thời gian đăng nhập</h3>
            <div>${sessionScope.loginTime}</div>
        </div>
    </div>

    <h2>Số sinh viên theo lớp</h2>
    <div class="card">
        <c:forEach var="item" items="${studentsByClass}">
            <p><b>${item.key}</b>: ${item.value} sinh viên</p>
        </c:forEach>
    </div>

    <a class="btn" href="${pageContext.request.contextPath}/students">
        Quản lý sinh viên
    </a>
    <a class="btn" href="${pageContext.request.contextPath}/logout">
        Đăng xuất
    </a>
</div>
</body>
</html>
