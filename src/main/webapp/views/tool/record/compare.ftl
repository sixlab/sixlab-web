<!doctype html>
<html>
<@c.head />

<title>Sixlab Tools</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/tool/record/compare", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${resPath}/res/css/tool/record/compare.css" type="text/css">

<body>
<@c.header />
<@c.frame id="trc" class="trc">

<div style="margin: 50px 0;">

    <div class="pure-g table-header">
        <div class="pure-u-1-3">
            <div class="table-header-cell">#</div>
        </div>
        <div class="pure-u-1-3">
            <div class="table-header-cell">${date1?string("yyyy-MM-dd HH:mm:ss")}</div>
        </div>
        <div class="pure-u-1-3">
            <div class="table-header-cell">${date2?string("yyyy-MM-dd HH:mm:ss")}</div>
        </div>
    </div>
    <#list itemList as item>
        <div class="pure-g table-row">
            <div class="pure-u-1-3 table-left">
                <div class="table-cell">
                    <h2>${item.itemName}</h2>
                    ${item.remark}
                </div>
            </div>
            <div class="pure-u-1-3 table-center">
                <div class="table-cell">${date1List[item_index].itemName}</div>
            </div>
            <div class="pure-u-1-3 table-right">
                <div class="table-cell">${date2List[item_index].itemName}</div>
            </div>
        </div>
    </#list>
</div>

</@c.frame>
<@c.footer />
</body>
</html>