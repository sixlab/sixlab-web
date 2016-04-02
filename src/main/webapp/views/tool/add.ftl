<!doctype html>
<html>
<@c.head />

<title>添加工具</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/tool/add", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${Application["resPath"]}/res/css/tool/add.css" type="text/css">

<body>
<@c.header />
<@c.frame id="ta" class="ta">

<div class="pure-g" style="margin-top: 100px;">
    <div class="pure-u-1-3 pure-u-md-2-5"></div>
    <div class="pure-u-1-3 pure-u-md-1-5">
        <form id="frm" method="post" action="${request.contextPath}/tool/add" class="pure-form pure-form-stacked">
            <fieldset>
                <div class="pure-u-1">
                    <label for="name">名字</label>
                    <input id="name" name="name" type="text" required
                           placeholder="名字">
                </div>
                <div class="pure-u-1">
                    <label for="link">链接</label>
                    <input id="link" name="link" type="text" required
                           placeholder="名字">
                </div>
                <div class="pure-u-1">
                    <label for="title">标题</label>
                    <input id="title" name="title" type="text" required
                           placeholder="标题">
                </div>
                <label for="hasLogin" class="pure-checkbox">
                    <input id="hasLogin" type="checkbox" name="hasLogin" value="1">
                    需要登录
                </label>
            </fieldset>
            <button type="button" class="pure-button login-btn pure-button-primary">登录</button>
            <a href="${request.contextPath}/tool/" type="button" class="pure-button">取消</a>
        </form>
    </div>
    <div class="pure-u-1-3 pure-u-md-2-5"></div>
</div>

</@c.frame>
<@c.footer />
</body>
</html>