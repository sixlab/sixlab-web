<!doctype html>
<html>
<@c.head />

<title>Sixlab Tools</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/tool/record/edit", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${resPath}/res/css/tool/record/edit.css" type="text/css">

<body>
<@c.header />
<@c.frame id="tre" class="tre">

<div style="margin: 50px 0;">

    <div class="pure-g">
        <div class="pure-u-11-24">
            <div class="table-header-cell">启用</div>
        </div>
        <div class="pure-u-1-12">
            <div class="table-header-cell">#</div>
        </div>
        <div class="pure-u-11-24">
            <div class="table-header-cell">禁用</div>
        </div>
    </div>
    <#if (itemSize>0)>
    <#list 0..itemSize as t>
        <div class="pure-g table-row">
            <div class="pure-u-11-24 table-left">
                <#if enableItems[t]>
                    <div class="table-cell">
                        <h2>${enableItems[t].itemName}</h2>
                    ${enableItems[t].remark}
                    </div>

                    <button type="button" item-id="${enableItems[t].id}"
                            class="pure-button enable-btn pure-button-primary">禁用</button>
                </#if>
            </div>
            <div class="pure-u-1-12 table-center">

            </div>
            <div class="pure-u-11-24 table-right">
                <#if delItems[t]>
                    <div class="table-cell">
                        <h2>${delItems[t].itemName}</h2>
                    ${delItems[t].remark}
                    </div>

                    <button type="button" item-id="${delItems[t].id}"
                            class="pure-button del-btn pure-button-primary">启用</button>
                </#if>
            </div>
        </div>
    </#list>
    </#if>
</div>

</@c.frame>
<@c.footer />
</body>
</html>