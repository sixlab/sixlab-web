require.config({
    baseUrl: "js",
    paths: {
        "jquery": ["http://libs.baidu.com/jquery/2.0.3/jquery", "jquery.min"],
        "a": "js/a"
    },
    shim: {
        "underscore": {
            exports: "_"
        },
        "jquery.form":{
            deps : ["jquery"],
            exports : "jForm"
        },
        "jquery.form":["jquery"]
    }
})

require(['jquery','underscore'], function ($,underscore) {
    alert($().jquery);
});

define(['myLib'], function (myLib) {
    function foo() {
        myLib.doSomething();
    }

    return {
        foo: foo
    };
});