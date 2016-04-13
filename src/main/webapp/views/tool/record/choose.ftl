<!doctype html>
<html>
<@c.head />

<title>Sixlab Tools</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/tool/record/choose", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${Application["resPath"]}/res/css/tool/record/choose.css?v=${Application["resVersion"]}" type="text/css">

<body>
<@c.header />
<@c.frame id="trc" class="trc">

<div style="margin: 50px;">
    <form id="frm" class="pure-form pure-form-stacked" action="compare" method="post">
        <fieldset>
            <legend>111</legend>
            <div class="pure-g">
                <#list valList as item>
                    <div class="pure-u-1-2 pure-u-sm-1-3 pure-u-md-1-4 pure-u-lg-1-5 pure-u-xl-1-6">
                        <label for="terms_${item_index}" class="pure-checkbox">
                            <input id="terms_${item_index}" type="checkbox" name="selectTime"
                                   class="time-check required"
                                   value="${item.recordDate?string("yyyy-MM-dd HH:mm:ss")}">${item.recordDate?string("yyyy-MM-dd HH:mm:ss")}
                        </label>
                    </div>
                </#list>
            </div>
            <button type="button" class="pure-button submitBtn pure-button-primary">比较</button>
        </fieldset>
    </form>
</div>

</@c.frame>
<@c.footer />
</body>
</html>