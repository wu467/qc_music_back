<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 2021/4/23
  Time: 9:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>成功</title>
</head>
<body>
<h3>测试成功</h3>

<h3>查询所有系统通知</h3>
<c:forEach items="${list}" var="notice">
    ${notice.id}
    ${notice.content}
    ${"   "}
</c:forEach>

</body>
</html>

