<!DOCTYPE html>
<html>
<head>
    <title>所有的用户</title>
</head>
<body>
<h1>所有的用户 - ${username}</h1>
<table>
    <tr>
        <th>NAME</th>
        <th>pwd</th>
    </tr>
    <tr>
        <#--<list users as user>-->
            <#--<td>${user.username}</td>-->
            <#--<td>${user.password}</td>-->
        <#--</list>-->
    </tr>
    <#--<tr th:each="user : ${users}">-->
        <#--<td th:text="${user.username}">Onions</td>-->
        <#--<td th:text="${user.password}">2.41</td>-->
    <#--</tr>-->
</table>
</body>
</html>