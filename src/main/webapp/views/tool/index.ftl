<!doctype html>
<html>
<@c.head />

<title>Sixlab Tools</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/tool/index", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${Application["resPath"]}/res/css/tool/index.css?v=${Application["resVersion"]}" type="text/css">

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

<div>
    <#if username>
    <div>
        <div><a href="/tool/record/" title="record" target="_blank" class="l-tool-link l-tool-link-login">record</a></div>
        <div><a href="/tool/movie/" title="movie" target="_blank" class="l-tool-link l-tool-link-login">movie</a></div>
        <div><a href="/tool/show/" title="show" target="_blank" class="l-tool-link l-tool-link-login">show</a></div>
        <div><a href="/tool/plan/" title="plan" target="_blank" class="l-tool-link l-tool-link-login">plan</a></div>
    </div>
    </#if>
    <div>
        <div><a href="/tool/record/" title="Record" target="_blank" class="l-tool-link l-tool-link-public">record</a></div>
        <div><a href="/tool/record/" title="Record" target="_blank" class="l-tool-link l-tool-link-public">record</a></div>
    </div>
</div>

</@c.frame>
<@c.footer />
</body>
</html>