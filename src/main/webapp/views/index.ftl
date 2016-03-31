<!doctype html>
<html>
<@c.head />

<title>Sixlab|六楼的雨</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/index", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${resPath}/res/css/index.css" type="text/css">

<body>
<@c.header />
<@c.frame id="index" class="index">
<div class="index-content text-center">
    <div class="hello">欢迎<i class="iconfont">&#xe64b;</i>光临</div>
    <div class="link"><a href="http://blog.sixlab.cn/">去看看博客<i class="iconfont">&#xe681;</i></a></div>
</div>
</@c.frame>
<@c.footer />
</body>
</html>