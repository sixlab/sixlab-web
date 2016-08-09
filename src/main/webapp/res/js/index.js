define(["jquery"], function ($) {
    $(document).ready(function () {
        console.log("finish");

        $(document).off("click", ".go2blog");
        $(document).on("click", ".go2blog", function () {
            location.href = "http://blog.sixlab.cn/";
        })
    });
});