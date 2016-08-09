<#ftl strip_whitespace=true>

<#macro head tip="" pop="" dark="" alert=1>
<head>
    <script type="text/javascript">
        resPath = "${Application["resPath"]}" + "/";
        resVersion = "${Application["resVersion"]}";
    </script>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">

    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />

    <link rel="stylesheet"
          href="${Application["resPath"]}/res/trd/bootstrap/css/bootstrap.min.css?v=${Application["resVersion"]}"
          type="text/css">
    <link rel="stylesheet"
          href="${Application["resPath"]}/res/trd/bootstrap/css/bootstrap-theme.min.css?v=${Application["resVersion"]}"
          type="text/css">

    <#if tip!=''>
        <link rel="stylesheet"
              href="${Application["resPath"]}/res/trd/toastr/toastr.min.css?v=${Application["resVersion"]}"
              type="text/css">
    </#if>
    <#if pop!=''>
        <link rel="stylesheet"
              href="${Application["resPath"]}/res/trd/webui-popover/dist/jquery.webui-popover.min.css?v=${Application["resVersion"]}"
              type="text/css">
    </#if>

    <#if dark!=''>
        <link rel="stylesheet"
              href="${Application["resPath"]}/res/trd/darktooltip/css/darktooltip.min.css?v=${Application["resVersion"]}"
              type="text/css">
    </#if>

    <#if alert!=''>
        <link rel="stylesheet"
              href="${Application["resPath"]}/res/trd/sweetalert/sweetalert.css?v=${Application["resVersion"]}"
              type="text/css">
    </#if>
    <link rel="stylesheet"
          href="${Application["resPath"]}/res/css/common.css?v=${Application["resVersion"]}"
          type="text/css">

    <script data-main="${Application["resPath"]}/res/main"
            src="${Application["resPath"]}/res/require.min.js?v=${Application["resVersion"]}"></script>

</head>
</#macro>

<#macro frame id="common" class="common">
<div id="${id}" class="${class} content-container">
    <#nested/>
</div>
<script>
    var _hmt = _hmt || [];
    (function () {
        var hm = document.createElement("script");
        hm.src = "//hm.baidu.com/hm.js?ed5f857e539c56779c12c9427b7cfd41";
        var s = document.getElementsByTagName("script")[0];
        s.parentNode.insertBefore(hm, s);
    })();
</script>
</#macro>

<#macro header>
<header>
    <a href="/" style="color: hsla(0,0%,100%,.6); line-height: 4em;" class="text-pointer">六楼实验室</a>
    <nav class="header-nav">
        <#--<a class="nav-item" href="/app/">APP</a>-->
        <#--<a class="nav-item" href="/tool/">工具箱</a>-->
        <#--<a class="nav-item" href="/lab/">实验室</a>-->
        <#--<a class="nav-item" href="/doc/">技术文档</a>-->
        <#--<a class="nav-item" href="/tutorial/">入门教程</a>-->
        <a class="nav-item" href="http://blog.sixlab.cn">博客</a>
        <#--<a class="nav-item" href="/i/">关于我</a>-->
    </nav>
</header>
</#macro>

<#macro footer>
<footer>
    <nav class="footer-nav">
        <span>
            <a rel="nofollow" target="_blank" href="/login">©</a> 2015 六楼实验室
            <a rel="nofollow" target="_blank" href="http://www.miitbeian.gov.cn/">豫ICP备15033629号</a> | 由
            <a rel="nofollow" target="_blank" href="http://www.aliyun.com/">阿里云</a> 强力驱动
            <a id="logout-url" target="_blank" href="/logout"></a>
        </span>
    </nav>
</footer>
</#macro>