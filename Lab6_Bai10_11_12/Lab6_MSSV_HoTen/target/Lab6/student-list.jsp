<%@ page contentType="text/html;charset=UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Danh sách sinh viên</title>
    <style>
        body { font-family:Arial; width:90%; margin:30px auto; }
        table { width:100%; border-collapse:collapse; }
        th,td { border:1px solid #bbb; padding:10px; text-align:left; }
        th { background:#1f5b8f; color:white; }
        a { text-decoration:none; margin-right:15px; }
    </style>
</head>
<body>
<h2>DANH SÁCH SINH VIÊN</h2>

<p>
   <a href="${pageContext.request.contextPath}/dashboard">Dashboard</a>
    <a href="${pageContext.request.contextPath}/student-form.jsp">+ Thêm sinh viên</a>
</p>

<table>
    <tr>
        <th>Mã SV</th>
        <th>Họ tên</th>
        <th>Lớp</th>
        <th>Điểm</th>
    </tr>
    <c:forEach var="s" items="${applicationScope.studentStore.students}">
        <tr>
            <td>${s.id}</td>
            <td>${s.name}</td>
            <td>${s.className}</td>
            <td>${s.score}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
