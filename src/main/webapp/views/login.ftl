<!doctype html>
<html>
<@c.head tip=1/>

<title>登录</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/login", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${resPath}/res/css/login.css" type="text/css">

<body>
<@c.header />
<@c.frame id="login" class="login">

<div class="container">
    <form id="frm" class="form-signin">

        <div class="form-group">
            <label class="control-label" for="username">用户名</label>
            <input type="text" id="username" class="form-control" name="username"
                   placeholder="用户名" required autofocus>
        </div>

        <div class="form-group">
            <label class="control-label" for="password">密码</label>
            <input type="password" id="password" class="form-control" name="password"
                   placeholder="密码" required>
        </div>

        <button class="btn btn-lg btn-info btn-block login-btn" type="button">登录</button>
    </form>
</div>
</@c.frame>
<@c.footer />
</body>
</html>