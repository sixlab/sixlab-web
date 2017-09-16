/**
 * Copyright (c) 2017 Sixlab. All rights reserved.
 *
 * Under the GPLv3(AKA GNU GENERAL PUBLIC LICENSE Version 3).
 * see http://www.gnu.org/licenses/gpl-3.0-standalone.html
 *
 * For more information, please see
 * https://sixlab.cn/
 *
 * @time: 2017
 * @author: Patrick <root@sixlab.cn>
 */
function showPost(postInfo) {
    console.log(postInfo);
    var posts = postInfo.posts;
    show(posts[0]);
    var i = 1;
    var len = posts.length;
    setInterval(function () {
        console.log(i);
        i = i + 1;
        if (i >= len) {
            i = 0;
        }
        show(posts[i]);
    }, 5000);
}

function show(post) {
    var title = post.title;
    var url = post.url;
    var date = post.date.substring(0, 10);
    $(".post-info-link").attr("href", url);
    $(".post-info-link").text(title);
    $(".post-info-date").text(date);
    $(".post-info-all").html("<a href = '" + url + "' >" + title + " </a> ｜ " + date);
}