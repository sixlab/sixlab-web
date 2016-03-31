<!doctype html>
<html>
<@c.head />

<title>Sixlab Tools</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/tool/index", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${resPath}/res/css/tool/index.css" type="text/css">

<body>
<@c.header />
<@c.frame id="ti" class="ti">

<div style="width: 200px;margin: 0 auto;">
    <#if username>
        <a class="pure-button" href="${request.contextPath}/tool/add">添加</a>
    <#else>
        <a class="pure-button" href="${request.contextPath}/login">登录</a>
    </#if>
</div>

<div class="pure-g" style="margin-top: 100px;">
    <div class="pure-u-1-3 pure-u-md-1-4"></div>
    <div class="pure-u-1-3 pure-u-md-1-2 links">
    <#if username>
        <@MetaInfo type="links" flag="1" class="l-tool-link-login" />
    </#if>
        <@MetaInfo type="links" flag="0" class="l-tool-link" />
    </div>
    <div class="pure-u-1-3 pure-u-md-1-4"></div>
</div>

</@c.frame>
<@c.footer />
</body>
</html>