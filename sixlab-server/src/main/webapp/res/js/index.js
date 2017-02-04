// define(["jquery"], function ($) {
    $(document).ready(function () {
        console.log("finish");

        $(document).off("click", ".go2blog");
        $(document).on("click", ".go2blog", function () {
            location.href = "https://blog.sixlab.cn/";
        });

        function showPost(postInfo){
            var posts = postInfo.posts;
            show(posts[0]);
            var i = 1;
            var len = posts.length;
            setInterval(function () {
                i=i+1;
                if(i>=len){
                    i = 0;
                }
                show(posts[i]);
            },2000);
        }

        function show(post) {
            var title = post.title;
            var url = post.url;
            var date = post.date;
            $(".meetup-info span a").closest("span").html('<a href="'+url+'">'+ title+'</a> ｜ '+date);
            $(".meetup-info-mobile .info-title a").attr("href", url);
            $(".meetup-info-mobile .info-title a").text(title);
            $(".meetup-info-mobile .time span").text(date);
        }

        $.ajax({
            url:"https://blog.sixlab.cn/api/get_recent_posts/?callback=showPosts&count=3",
            dataType:"jsonp",
            success:function(func){

            }
        });
    });
// });