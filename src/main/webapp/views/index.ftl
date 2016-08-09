<!doctype html>
<html>
<head>
<@c.head />
    <title>Sixlab|六楼的雨</title>
    <script type="text/javascript">
        require(["main"], function () {
            require(["js/index"]);
        });
    </script>
    <link href="${Application["resPath"]}/res/css/index.css?v=${Application["resVersion"]}"
          rel="stylesheet" type="text/css">
</head>
<body>
<@c.header />
<main>
    <section id="hero" style="background-image: url(/res/img/road.jpg)"
             class="hero background-cover">
        <div class="container">
            <div class="title">千里之行，始于足下</div>
            <div class="holder" style="height: 96px;">
                <#--<div class="holder-item"><img src="./images/discuss.svg">-->
                    <#--<div class="item-title">专业讨论</div>-->
                <#--</div>-->
                <#--<div class="holder-item"><img src="./images/edge.svg">-->
                    <#--<div class="item-title">前沿内容</div>-->
                <#--</div>-->
                <#--<div class="holder-item"><img src="./images/free.svg">-->
                    <#--<div class="item-title">完全免费</div>-->
                <#--</div>-->
            </div>
            <div class="meetup-info-mobile">
                <div class="info-title">最近文章: <a href="http://blog.sixlab.cn/archives/475">HTML5的Notification使用</a></div>
                <span class="time"><span>2016年3月21日</span></span>
            </div>
            <div class="last-meetup">
                <div class="meetup-info"><span class="info-title">最近文章</span><span><a href="http://blog.sixlab.cn/archives/475">HTML5的Notification使用</a> ｜ 2016年3月21日</span>
                </div>
                <button class="meetup-btn btn-blue go2blog">进入博客</button></div>
        </div>
    </section>
</main>
<@c.footer />
</body>
</html>