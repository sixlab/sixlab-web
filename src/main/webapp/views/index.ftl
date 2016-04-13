<!doctype html>
<html>
<@c.head />

<title>Sixlab|六楼的雨</title>
<script type="text/javascript">
    require(["main"], function () {
        require(["js/index", "bootstrap"]);
    });
</script>
<link rel="stylesheet" href="${Application["resPath"]}/res/css/index.css?v=${Application["resVersion"]}" type="text/css">

<body>
<@c.header />
<@c.frame class="s-img-bg">
<div class="s-img-bg-trans">
    <div class="index-content text-center">
        <div class="hello">生命由时间构成</div>
        <div class="link"><a href="http://blog.sixlab.cn/" title="去看博客"><i class="iconfont" id="icon-link">&#xe716;</i></a></div>
    </div>
</div>
</@c.frame>
<@c.footer />
</body>
</html>