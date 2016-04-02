<!doctype html>
<html>
<@c.head />

<title>Sixlab Tools</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/tool/record/compare", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${Application["resPath"]}/res/css/tool/record/compare.css" type="text/css">

<body>
<@c.header />
<@c.frame id="trc" class="trc">

<div>
    <a href="choose">选择时间</a>
</div>
<div>
    <a href="edit">编辑检查项</a>
</div>
<div>
    <a href="record">录入</a>
</div>

</@c.frame>
<@c.footer />
</body>
</html>