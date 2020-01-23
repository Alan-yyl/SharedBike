$("#btn_logout").click(function () {
    sessionStorage.removeItem("userInfo");
    localStorage.removeItem("access-token");
    location.href = "login.html";
});
function hideAdmin() {
    $("li>a[href='admin.html']").parent().remove();
}
var info = sessionStorage.getItem("userInfo");
var loginUser = JSON.parse(info);
if (info!=null&&info!=""){
    $("li>a[href='login.html']").parent().css("display","none");
    loginUser = JSON.parse(info);
    if (loginUser.permission!==1){
        //已登陆但不是管理员
        hideAdmin();
    }
}else {
    //未登陆
    hideAdmin();
}
//ajax全局事件
function onSend(event,xhr,settings){
    xhr.setRequestHeader("Authorization",localStorage.getItem("access-token"))
}
$(document).ajaxSend(onSend);

