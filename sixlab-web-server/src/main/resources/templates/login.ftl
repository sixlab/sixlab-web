<!doctype html>
<html lang="zh-CN">
<head>
    <title>Spring Security Example </title>
</head>
<body>
<#if (RequestParameters.error)??>
<div>
    Invalid username and password.
</div>
</#if>
<#if (RequestParameters.logout)??>
<div>
    You have been logged out.
</div>
</#if>
<form action="/login" method="post">
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    <div><label> User Name : <input type="text" name="username" /> </label></div>
    <div><label> Password: <input type="password" name="password" /> </label></div>
    <div><input type="submit" value="Sign In" /></div>
</form>
</body>
</html>