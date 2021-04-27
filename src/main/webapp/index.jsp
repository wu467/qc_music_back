<!--index.jsp中-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<a href="/notice/findAllNotice">查询所有系统通知</a>

<form action="/notice/insertNotice" method="post" enctype="application/x-www-form-urlencoded;charset=utf-8">
    <input type="text" name="content"/><br/>
    <span>是否展示notice  </span>
    <input type="radio" name="showNotice" value="true"/> <span>是</span>
    <input type="radio" name="showNotice" value="false"/> <span>否</span>
    <input type="submit" value="提交"/>
</form>

    <a href="/notice/delNotice">删除系统通知</a>

<form action="/user/register" method="post" enctype="application/x-www-form-urlencoded;charset=utf-8">
    <input type="text" name="name"/><br/>
    <input type="email" name="email"/> <br/>
    <input type="password" name="password"/> <br/>
    <input type="password" name="checkPassword"/>
    <input type="submit" value="注册">
</form>

<form action="/user/login" method="post" enctype="application/x-www-form-urlencoded;charset=utf-8">
    <input type="text" name="name"/><br/>
    <input type="password" name="password"/> <br/>
    <span>是否为管理员  </span>
    <input type="radio" name="userRole" value="true"/> <span>是</span>
    <input type="radio" name="userRole" value="false"/> <span>否</span>
    <input type="submit" value="登录"> <br/>
</form>

<br/>
<a href="/songs/favoriteSong">测试收藏歌曲</a>




</body>
</html>
