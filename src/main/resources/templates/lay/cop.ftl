<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Navbar组件</title>
    <link rel="stylesheet" href="/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" type="text/css" href="http://www.jq22.com/jquery/font-awesome.4.6.0.css">
</head>

<body style="margin:15px;">
<a href="javascript:;" class="layui-btn" data-title="编辑一" data-url="edit1.html" data-icon="fa-edit" data-id="1"><i
        class="fa fa-edit" aria-hidden="true"></i> 编辑一</a>
<a href="javascript:;" class="layui-btn" data-title="编辑二" data-url="edit2.html" data-icon="fa-edit" data-id="2"><i
        class="fa fa-edit" aria-hidden="true"></i> 编辑二</a>

<script src="/plugins/layui/layui.js"></script>
<script src="/build/js/app.js"></script>
<script src="/build/js/nprogress.js"></script>
<script>
    layui.use(['layer'], function () {
        var layer = layui.layer,
                $ = layui.jquery;

        var tab = parent.tab;

        $('a').off('click').on('click', function () {
            var _that = $(this),
                    _data = {
                        title: _that.data('title'),
                        icon: _that.data('icon'),
                        id: _that.data('id'),
                        url: _that.data('url')
                    };
            tab.tabAdd(_data);
        });
    });
</script>
</body>

</html>