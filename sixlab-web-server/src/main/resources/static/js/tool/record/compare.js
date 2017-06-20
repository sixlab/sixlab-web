define(["jquery", "jquery.form", "jquery.validate"], function ($) {

    $(document).ready(function () {

        $(document).off("click", ".submitBtn");
        $(document).on("click", ".submitBtn", function () {
            var $time = $(".time-check:checked");
            if($time.length==2){
                var date1 = $($time[0]).val();
                var date2 = $($time[1]).val();
                location.href = "compare/" + date1 + "/" + date2;
            }else{
                alert("请选择两个时间");
            }
        });
    });
});