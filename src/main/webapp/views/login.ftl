<!doctype html>
<html>
<@c.head js="login">
<title>登录</title>
<meta charset="utf-8">
</@c.head>
<body>

<div class="pure-g" style="margin-top: 100px;">
    <div class="pure-u-1-3 pure-u-md-2-5"></div>
    <div class="pure-u-1-3 pure-u-md-1-5">
        <form id="frm" method="post" action="${request.request}/login" class="pure-form pure-form-stacked">
            <fieldset>
                <legend>登录</legend>
                <div class="pure-u-1">
                    <label for="username">用户名</label>
                    <input id="username" name="username" type="text" required
                           placeholder="用户名">
                </div>
                <div class="pure-u-1">
                    <label for="password">密码</label>
                    <input id="password" name="password" type="password" required
                           placeholder="密码">
                </div>
            </fieldset>
            <button type="button" class="pure-button login-btn pure-button-primary">登录</button>
            <a href="${request.contextPath}/" type="button" class="pure-button">取消</a>
        </form>
    </div>
    <div class="pure-u-1-3 pure-u-md-2-5"></div>
</div>
</body>
</html>