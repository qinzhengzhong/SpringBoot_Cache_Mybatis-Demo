<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Navbar组件</title>
    <link rel="stylesheet" href="/plugins/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="/build/css/doc.css" media="all">
</head>

<body>
<div class="kit-doc">
    <blockquote class="layui-elem-quote">Tab组件是基于<a href="http://www.layui.com/doc/element/tab.html" target="_blank">layui选项卡</a>
        封装的组件，配合
        <a href="navbar.ftl">Navbar组件</a>能完成多开页面的操作
    </blockquote>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote">可用的方法</a></legend>
        </fieldset>
    </div>
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="200">
            <col width="150">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>名称</th>
            <th>参数</th>
            <th>返回值</th>
            <th>描述</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>set(options)</td>
            <td><a href="#options">options</a>/object</td>
            <td>this/object</td>
            <td>配置一些全局参数,返回当前tab对象，以便于链式调用
                <p>Example:</p>
                <pre class="layui-code">
tab.set({
    elem:'#container'
});</pre>
            </td>
        </tr>
        <tr>
            <td>render()</td>
            <td>null</td>
            <td>void</td>
            <td>渲染tab选项卡到页面</td>
        </tr>
        <tr>
            <td>tabAdd(params)</td>
            <td>params/object</td>
            <td>void</td>
            <td>添加一个选项卡
                <p>Example:</p>
                <pre class="layui-code">
tab.tabAdd({
    icon:'fa-user',
    id:'11',
    title:'新选项卡',
    url:'newtab.html'
});</pre>
                与navbar配合着用
                <p>Example:</p>
                <pre class="layui-code">
navbar.bind(function(data) {//bind方法为navbar组件提供的方法
    tab.tabAdd(data);
});</pre>
            </td>
        </tr>
        </tbody>
    </table>
    <div class="kit-doc-title">
        <fieldset>
            <legend><a name="blockquote" id="options">options参数说明</a></legend>
        </fieldset>
    </div>
    <table class="layui-table">
        <colgroup>
            <col width="150">
            <col width="150">
            <col width="150">
            <col>
        </colgroup>
        <thead>
        <tr>
            <th>名称</th>
            <th>类型</th>
            <td>默认值</td>
            <th>描述</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>elem</td>
            <td>string</td>
            <td>#container</td>
            <td>容器DOM，支持id选择器和类选择器</td>
        </tr>
        <tr>
            <td>mainUrl</td>
            <td>string</td>
            <td>main.html</td>
            <td>控制面板的链接</td>
        </tr>
        <tr>
            <td>onSwitch</td>
            <td>function</td>
            <td>undefined</td>
            <td>选择卡切换时将触发该事件<br/> 示例:
                <pre class="layui-code">
tab.set({
    onSwitch: function(data) { //选项卡切换时触发
        //console.log(data.layId); //lay-id值
        //console.log(data.index); //得到当前Tab的所在下标
        //console.log(data.elem); //得到当前的Tab大容器
}});                        </pre>
            </td>
        </tr>
        <tr>
            <td>closeBefore</td>
            <td>function</td>
            <td>undefined</td>
            <td>关闭选项卡之前触发该事件<br/> 示例:
                <pre class="layui-code">
tab.set({
    closeBefore: function(data) { //关闭选项卡之前触发
        // console.log(data);
        // console.log(data.icon); //显示的图标
        // console.log(data.id); //lay-id
        // console.log(data.title); //显示的标题
        // console.log(data.url); //跳转的地址
        return true; //返回true则关闭
}});                        </pre>
            </td>
        </tr>
        </tbody>
    </table>
    <blockquote class="layui-elem-quote">这个文档就先写到这里吧，后面新增了再补充啦。</blockquote>
</div>
<script src="/plugins/layui/layui.js"></script>
<script src="/build/js/app.js"></script>
<script src="/build/js/tab.js"></script>
<script src="/build/js/nprogress.js"></script>
</body>

</html>