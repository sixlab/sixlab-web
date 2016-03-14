require.config({
    paths: {
        "darktooltip": "darktooltip/js/jquery.darktooltip.min.js",
        "jquery": "jquery/jquery.min",
        "jquery.form": "jquery.form/jquery.form.min",
        "jquery.sortable": "jquery.sortable/jquery-sortable-min",
        "jquery.validate": "jquery.validate/jquery.validate.min",
        "js.cookie": "js.cookie/src/js.cookie.js",
        "juicer": "juicer/juicer.min",
        "toastr": "toastr/toastr.min.js",
        "jquery.webui-popover": "webui-popover/src/jquery.webui-popover.js"
    },
    shim: {
        "darktooltip": ["jquery"],
        "jquery.sortable": ["jquery"],
        "juicer": {exports: "juicer"},
        "jquery.webui-popover": ["jquery"]
    }
});

window.contextPath = "/";

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
//require(['jquery','underscore'], function ($,underscore) {
//    alert($().jquery);
//});
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