define(["jquery", "toastr", "sweetalert","bootstrap", "jquery.form", "jquery.validate"], function ($, toastr,swl) {

        function loginError(msg) {
            toastr.options.closeButton = true;
            toastr.options.onHidden = function () {
            };
            toastr.error(msg, {timeOut: 2000});
        }

        $(document).ready(function () {
            var validator = $("#frm").validate({
                submitHandler: function (form) {
                    $(form).ajaxSubmit({
                        dataType: "json",
                        type: "post",
                        success: function (data) {

                            if (data.success) {
                                swal({
                                    title: "提示",
                                    text: "登陆成功",
                                    type: "success",
                                    closeOnConfirm: false
                                }, function () {
                                    location.href = contextPath + "/";
                                });
                            } else {
                                if(data.code===1){
                                    loginError(data.message);
                                }else{
                                    loginError("服务器异常");
                                }
                                $(".login-btn").prop("disabled", false);
                                console.log(data);
                            }
                        },
                        error: function (data) {
                            $(".login-btn").prop("disabled", false);
                            loginError("服务器异常");
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
                $(this).prop("disabled", true);
                $("#frm").submit();
            });
        });
    });