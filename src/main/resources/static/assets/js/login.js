
// 登录系统
$("#loginButton").on("click",function(){
    var userName=$("#userName").val();
    var pwd=$("#possword").val();
    if(userName=='' || pwd ==''){
        alert("请输入邮用户名或密码！");
        return;
    }
    $.ajax({
        type: 'POST',
        dataType: 'json',
        url: "/allan/checkLogin",
        data: {
            userName: userName,
            pwd:pwd
        },
        success:function(){
            alert("欢迎登录");
        }
    });
});