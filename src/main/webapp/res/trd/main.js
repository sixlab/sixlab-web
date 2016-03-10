require.config({
    paths: {
        "jquery": "jquery/jquery.min",
        "jquery.form": "jquery.form.min",
        "jquery.validate": "jquery.validate.min",
        "jquery.validate": "jquery.validate.min"
    },
    shim: {
        "juicer/juicer.min": {
            exports: "juicer"
        },
        "jquery.sortable/jquery-sortable-min": {
            deps: ["jquery"],
            exports:"jQuery.fn.sortable"
        }
    }
});

function required(location){
    require("../js/"+location);
}


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
//        "jquery.form":["jquery"]
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