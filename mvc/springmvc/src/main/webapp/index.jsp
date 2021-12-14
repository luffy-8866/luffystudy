<html>

<head>
    <title>标题</title>
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta name="keywords" content="关键字">
    <meta name="description" content="内容描述">

    <script type="text/javascript" src="/js/jquery.min.js">
    </script>

    <script>
        $(function () {
            $("#ajaxBtn").bind("click",function () {
                $.ajax({
                    url: '/demo/handle3',
                    type: 'POST',
                    data: '{"id":"1","name":"张龙飞"}',
                    contentType: 'application/json;charset=utf-8',
                    success: function (data) {
                        alert(data);
                    }
                })
            })
        })

    </script>
</head>
<body>
<h2>Hello World!</h2>

<div>
    <h2>ajax 交互</h2>
    <fieldset>
        <input type="button" id="ajaxBtn" value="ajax提交"/>

    </fieldset>
</div>

<div>

    <h2> 文件上传</h2>
    <fieldset>
        <form method="post" enctype="multipart/form-data" action="/demo/upload">
            <input type="file" name="upload"/>
            <input type="submit" value="上传"/>
        </form>

    </fieldset>

</body>
</html>
