var page = 1,rows=8;
function createRedisContent(redisContent) {
	var html='<div class="content_box">'
        +'<div class="content_link">'+redisContent.id+'</div>'
        +'<div class="content_link">'+redisContent.content+'</div>'
        +'<div class="content_link">null</div>'
        +'<div class="content_link">null</div>'
        +'<div class="content_link product_operation">'
        +'<span onclick="edit_club(' + 0 + ')">编辑</span>&nbsp;&nbsp;'
        +'<span onclick="edit_del(' + 0 + ')">删除</span>'
        +'</div>'
        +'</div>'
        return html;
}

function load_redis_list() {
    console.log("hello");
    $.ajax({
        type: 'POST',
        url: getPath() + '/redis_list',
        async: false,
        data: {page: page, pageSize: rows},
        datatype: 'json',
        success: function (data) {
            console.log(data);
            if (data.result == 1) {
                $(".product_length_number").html(data.data.count);
                var html = "";
                var count = data.data.count;
                for (var i = 0; i < data.data.redisContents.length; i++) {
                    var redisContent = data.data.redisContents[i];
                    html += createRedisContent(redisContent.rediscontent);
                }
                $("#redisContent").html(html);
                //这里是分页的插件
                $('#pagination').jqPaginator('option', {
                    totalPages: (Math.ceil(count / rows) < 1 ? 1 : Math.ceil(count / rows)),
                    currentPage: page
                });
            } else {
                alert(data.msg);
            }
        }
    });
    $(".content_box:even").css("background", "#A9A87E");//隔行变色
}

