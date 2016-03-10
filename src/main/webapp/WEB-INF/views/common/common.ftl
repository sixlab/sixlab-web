<#ftl strip_whitespace=true>

<#macro page>
<!doctype html>
<html>
<#nested/>
</html>
</#macro>

<#macro head lib js>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <meta name="renderer" content="webkit"/>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
        <link rel="stylesheet" href="${request.contextPath}/res/trd/pure/pure.min.css" type="text/css">
        <script data-main="main" src="${request.contextPath}/res/trd/require.min.js"></script>
    <#list lib?split(",") as alias>
        <@lib alias=alias />
    </#list>

    <#if js?length!=0>
        <script type="text/javascript">
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
            require([${require}]);
        </script>
    </#if>
        <#nested/>
    </head>
</#macro>

<#macro lib alias>
    <#if alias=="">
        <link rel="stylesheet" href="css/darktooltip.css" type="text/css">
        <script src="js/jquery.darktooltip.js" type="text/javascript"></script>
    <#elseif alias=="">
    <#elseif alias=="">
    <#elseif alias=="">
    <#elseif alias=="">
    <#elseif alias=="">
    <#elseif alias=="">
    <#elseif alias=="">
    </#if>
</#macro>