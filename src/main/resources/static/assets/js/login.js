
/**
 * 登录校验
 */
function check() {
    var userName=$("#userName").val();
    var pwd=$("#possword").val();
    if(userName=='' || pwd ==''){
        alert("请输入邮用户名或密码！");
        return false;
    }
    return true;

}
