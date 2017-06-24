window.contextPath = "";

require.config({
    baseUrl: "",
    urlArgs: "v=" + resVersion,
    paths: {
        "main": "main",
        "bootstrap": "trd/bootstrap/js/bootstrap.min",
        "darktooltip": "trd/darktooltip/js/jquery.darktooltip.min",
        "jquery": "trd/jquery/jquery.min",
        "jquery.form": "trd/jquery.form/jquery.form.min",
        "jquery.sortable": "trd/jquery.sortable/jquery-sortable-min",
        "jquery.validate": "trd/jquery.validate/jquery.validate.min",
        "js.cookie": "trd/js.cookie/js.cookie",
        "juicer": "trd/juicer/juicer.min",
        "sweetalert": "trd/sweetalert/sweetalert.min",
        "toastr": "trd/toastr/toastr.min",
        "jquery.webui-popover": "trd/webui-popover/dist/jquery.webui-popover.min"
    },
    shim: {
        "jquery": ["main"],
        "bootstrap": ["jquery"],
        "darktooltip": ["jquery"],
        "jquery.sortable": ["jquery"],
        "jquery.webui-popover": ["jquery"],
        "juicer": {exports: "jquery"}
    }
});

require(["jquery", "js.cookie"], function ($, Cookie) {
    $(document).ready(function () {
        var username = Cookie.get("username");
        if (username) {
            $("#logout-url").text(username);
        }
    });
});

// require(["jquery"], function ($) {
//     $(document).ready(function () {
//         var sectionHeight = 0;
//
//         function setSectionSize() {
//             sectionHeight = $(window).height();
//             sectionHeight < 400 ? sectionHeight = 400 : '';
//             sectionHeight > 1000 ? sectionHeight = 1000 : '';
//             $(".s-section").height(sectionHeight);
//         }
//
//         $(window).scroll(function () {
//             var scrollTop = $(window).scrollTop();
//
//             if (scrollTop <= 0) {
//                 $("#s-top-navbar").addClass("s-nav-default-height");
//                 $("#s-top-navbar").removeClass("s-theme-color");
//             } else {
//                 $("#s-top-navbar").addClass("s-theme-color");
//                 $("#s-top-navbar").removeClass("s-nav-default-height");
//             }
//
//             if (scrollTop > 0 && scrollTop <= sectionHeight) {
//
//             } else if (scrollTop > sectionHeight && scrollTop <= sectionHeight * 2) {
//
//             }
//         });
//
//         $(window).resize(function () {
//             setSectionSize();
//         });
//
//         +function () {
//             setSectionSize();
//         }();
//     });
// });

//require.config({
//    baseUrl: "js",
//    paths: {
//        "jquery": ["http://libs.baidu.com/jquery/2.0.3/jquery", "jquery.min"],
//        "a": "js/a"
//    },
//    shim: {
//        "underscore": {
//            exports: "_"
//        },
//        "jquery.form":{
//            deps : ["jquery"],
//            exports : "jForm"
//        },
//        "jquery.form":["jquery"],
//        "jquery.sortable": {
//            deps: ["jquery"],
//            exports:"jQuery.fn.sortable"
//        }
//    }
//})
//
//define(['myLib'], function (myLib) {
//    function foo() {
//        myLib.doSomething();
//    }
//
//    return {
//        foo: foo
//    };
//});