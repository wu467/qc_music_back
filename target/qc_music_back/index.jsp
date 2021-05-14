<!--index.jsp中-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>test</title>
</head>
<body>
<a href="/notice/findAllNotice">查询所有系统通知</a>

<h1>添加通知信息</h1>
<form action="/notice/insertNotice" method="post" enctype="application/x-www-form-urlencoded;charset=utf-8">
    <input type="text" name="content"/><br/>
    <span>是否展示notice  </span>
    <input type="radio" name="showNotice" value="true"/> <span>是</span>
    <input type="radio" name="showNotice" value="false"/> <span>否</span>
    <input type="submit" value="提交"/>
</form>

<a href="/notice/delNotice">删除系统通知</a>

<h1>用户注册</h1>
<form action="/user/register" method="post" enctype="application/x-www-form-urlencoded;charset=utf-8">
    <span>用户名</span> <input type="text" name="name"/><br/>
    <span>邮箱</span> <input type="email" name="email"/> <br/>
    <span>密码</span> <input type="password" name="password"/> <br/>
    <span>确认密码</span> <input type="password" name="checkPassword"/> <br/>
<input type="submit" value="注册">
</form>

<h1>用户登录</h1>
<form action="/user/login" method="post" enctype="application/x-www-form-urlencoded;charset=utf-8">
    <span>用户名</span> <input type="text" name="name"/><br/>
    <span>密码</span> <input type="password" name="password"/> <br/>
    <span>是否为管理员  </span>
    <input type="radio" name="userRole" value="true"/> <span>是</span>
    <input type="radio" name="userRole" value="false"/> <span>否</span> <br/>
    <input type="submit" value="登录"> <br/>
</form>

<br/>
<a href="/songs/allFavoriteSong">返回所有收藏歌曲</a> <br/>

<a href="/songs/favoriteSong">测试收藏歌曲</a> <br/>

<a href="/songs/cancelFavoriteSong">取消收藏歌曲</a> <br/>


<br/><br/>
<h1>收藏歌曲</h1>
<form action="/songs/favoriteSong" method="post" enctype="application/x-www-form-urlencoded;charset=utf-8">
    <span>用户id</span> <input type="number" name="userId"/><br/>
    <span>歌曲id</span> <input type="text" name="songMid"/> <br/>
    <input type="submit" value="提交"/>
</form>


</body>
</html>
