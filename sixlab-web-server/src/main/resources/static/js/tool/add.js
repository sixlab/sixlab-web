define(["jquery", "jquery.form", "jquery.validate"], function ($) {

    $(document).ready(function () {
        var validator = $("#frm").validate({
            submitHandler: function (form) {
                $(form).ajaxSubmit({
                    dataType: "json",
                    type: "post",
                    success: function (data) {
                        if (data.success) {
                            location.href = contextPath+"/tool/";
                        }else{
                            alert(data);
                            console.log(data);
                        }
                    },
                    error:function(data){
                        alert(data);
                        console.log(data);
                    }
                });
            }
        });

        $("#username,#password").bind("keyup", function (e) {
            if (e.keyCode == 13) {
                $(".login-btn").trigger("click");
            }
        });

        $(document).off("click", ".login-btn");
        $(document).on("click", ".login-btn", function () {
            var check = validator.form();
            if (!check) {
                validator.focusInvalid();
                return false;
            }
            $("#frm").submit();
        });
    });
});