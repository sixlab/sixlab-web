<!doctype html>
<html>
<@c.head>
<title>Sixlab|六楼的雨</title>
<meta charset="utf-8">
</@c.head>
<body>

<#if username>
<div>已登录，${username}</div>
<#else>
<a class="pure-button" href="${request.contextPath}/login">登录</a>
</#if>
<a class="pure-button" href="${request.contextPath}/tool/">工具</a>

</body>
</html>