<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="r" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
${message}

<r:hasPermission name="bookmanager:book:query">
     查询
</r:hasPermission>
<r:hasPermission name="bookmanager:book:add">
     新增
</r:hasPermission>
<r:hasPermission name="bookmanager:book:update">
     修改
</r:hasPermission>

<h1>删除</h1>
<form action="/ssmshiro/register/del" method="post">
    用户编号：<input type="text" name="userid"/><br/>
    <input type="submit" value="删除"/>
</form>

<br>

<h1>修改</h1>
<form action="/ssmshiro/register/upd" method="post">
    请修改账号：<input type="text" value="${selusr.username}" name="username"/><br/>
    请修改密码：<input type="password" value="${selusr.password}" name="password"/><br/>
    <input type="submit" value="修改"/>
</form>

<br>

<h1>注册</h1>
<form action="/ssmshiro/register/register" method="post">

    账号：<input type="text" name="username"/><br/>
    密码：<input type="password" name="password"/><br/>
    <input type="submit"/>

</form>


</body>
</html>
