<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<!DOCTYPE html>
<html lang="zh-CN">
<head data='${pageContext.request.contextPath}'>
    <base href="<%=basePath%>">
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/redis.css">
    <script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/js/jqPaginator.js"></script>
    <script src="${pageContext.request.contextPath}/js/redis_list.js"></script>
    <script src="${pageContext.request.contextPath}/js/Globals.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){

              $.jqPaginator('#pagination',{
                totalPages: 100,
                visiblePages: 5,
                currentPage: 1,
                onPageChange: function (num, type) {
                    page = num;
                    if(type =='change'){
                       load_redis_list();
                    }
                }
              });
            load_redis_list();
        });
    </script>
</head>
<body data='${pageContext.request.contextPath}'>
<div class="wraaper">
<div class="well">利用Redis缓存实例</div>
    <div class="explain_box">
        <div class="explain_link">ID</div>
        <div class="explain_link">NAME</div>
        <div class="explain_link">null</div>
        <div class="explain_link">null</div>
        <div class="explain_link product_operation">操作</div>
    </div>
    <div id="redisContent"></div>
    <ul id="pagination" class="pagination"></ul>
    <div class="oper_box">共<span class="product_length_number"></span>条记录</div>
</div>
</body>
</html>