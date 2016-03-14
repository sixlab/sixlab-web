define(["jquery", "jquery.form", "jquery.validate"], function ($) {

    $(document).ready(function () {
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

        $(document).off("click", "tt");
        $(document).on("click", "tt", function () {

        });
    });
});