<!doctype html>
<html>

<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <title>管理系统(FreeMarker模板)</title>
    <meta name="description" content="这是一个 index 页面"/>
    <meta name="keywords" content="index"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <meta name="renderer" content="webkit"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link rel="icon" type="image/png" href="assets/i/favicon.png"/>
    <link rel="apple-touch-icon-precomposed" href="assets/i/app-icon72x72@2x.png"/>
    <meta name="apple-mobile-web-app-title" content="Amaze UI"/>
    <link rel="stylesheet" href="assets/css/amazeui.min.css"/>
    <link rel="stylesheet" href="assets/css/admin.css"/>
    <link rel="stylesheet" href="assets/css/app.css"/>
    <!--<script src="http://www.jq22.com/jquery/jquery-2.1.1.js"></script>-->
    <!--<script src="assets/js/amazeui.min.js"></script>-->
    <!--<script src="assets/js/app.js"></script>-->
    <script src="assets/js/jquery.form.js"></script>
    <script src="assets/js/jquery.min.js"></script>
    <script src="assets/js/login.js"></script>
</head>

<body data-type="login">

<div class="am-g myapp-login">
    <div class="myapp-login-logo-block  tpl-login-max">
        <div class="myapp-login-logo-text">
            <div class="myapp-login-logo-text">
                欧冠报名系统<span> 登录</span> <i class="am-icon-skyatlas"></i>

            </div>
        </div>

        <div class="login-font">
            <i> </i>
            <span> </span>
        </div>
        <div class="am-u-sm-10 login-am-center">
            <form class="am-form login" id="loginForm" action="/allan/checkLogin" onsubmit="retrun check(this)" method="post">
                <fieldset>
                    <div class="am-form-group">
                        <input type="email" class="" id="userName" name="userName" placeholder="输入用户名"/>
                    </div>
                    <div class="am-form-group">
                        <input type="password" class="" id="possword" name="possword" placeholder="输入密码"/>
                    </div>
                    <p>
                        <font size="14px" color="red">
                           <#if msg??>${msg}</#if>
                       </font>
                    </p>
                    <p>
                        <button type="submit" class="am-btn am-btn-default">登录</button>
                    </p>
                </fieldset>
            </form>
        </div>
    </div>
</div>
</body>

</html>