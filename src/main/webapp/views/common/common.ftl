<#ftl strip_whitespace=true>

<#macro head js="">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta name="renderer" content="webkit" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <link rel="stylesheet" href="${request.contextPath}/res/trd/pure/pure-min.css" type="text/css">
    <link rel="stylesheet" href="${request.contextPath}/res/trd/pure/grids-responsive-min.css"
          type="text/css">
    <script data-main="${request.contextPath}/res/trd/main" src="${request.contextPath}/res/trd/require.min.js"></script>

    <#if js>
        <#assign require="" />
        <#list js?split(",") as name>
            <#assign require=require+"'../js/" />
            <#assign require=require+name />
            <#if js?split(",")?size-1!=name_index>
                <#assign require=require+"'," />
            <#else>
                <#assign require=require+"'" />
            </#if>
        </#list>
        <script type="text/javascript">
            require([${require}]);
        </script>
    </#if>
    <#nested/>
</head>
</#macro>