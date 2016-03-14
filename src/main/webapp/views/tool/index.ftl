<!doctype html>
<html>
<@c.head js="tool/index">
<title>首页</title>
<meta charset="utf-8">
</@c.head>
<body>

<div style="width: 200px;margin: 0 auto;">
    <#if username>
        <a class="pure-button" href="/add/tool">添加</a>
    <#else>
        <a class="pure-button" href="/login">登录</a>
    </#if>
</div>

<div class="pure-g" style="margin-top: 100px;">
    <div class="pure-u-1-3 pure-u-md-1-4"></div>
    <div class="pure-u-1-3 pure-u-md-1-2">
    <#if username>
        <@MetaInfo type="link" flag="1" class="l-tool-link-login" />
    </#if>
        <@MetaInfo type="link" flag="0" class="l-tool-link" />
    </div>
    <div class="pure-u-1-3 pure-u-md-1-4"></div>
</div>
</body>
</html>