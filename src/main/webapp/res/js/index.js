define(function () {
    var $ = require(["jquery"]);
    require("jquery.form");
    require("jquery.validate");

    $("#frm").validate({
        submitHandler: function (form) {
            $(form).ajaxSubmit({
                data: "post",
                dataType: "json",
                success: function (data) {
                    if (data.success == "1") {
                        location.href = "index";
                    }
                }
            });
        }
    });

    $(document).off("click", "");
    $(document).on("click", "", function () {

    });
});