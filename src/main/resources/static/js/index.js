/**
 * 
 */
$(function(){
	var judgeUrl="/test/user/judgeusername";
	var registerUrl="/test/user";
	
	
	$("#username").blur(function(e){
		var username=$("#username").val();
		$.get(judgeUrl,{"username":username},function(date){
			var success=date.success;
			if(success){
				//可以注册
			}else{
				//用户名重复
				alert("用户名重复请重新输入用户名")
				var username=$("#username").val("");
			}
		})
	})
	//给id为ajaxSubmit的按钮提交表单
    $("#ajaxSubmit").click(function(){
        $("#ajaxForm").ajaxSubmit({
            success:function (data) {
            	var success=data.success;
            	var errMsg=data.errMsg;
            	if(success){
            		alert("注册成功");
            		window.location.href='http://localhost:8080/test/login';
            	}else{
            		alert("注册失败"+errMsg);
            		window.location.href='http://localhost:8080/test/register';
            	}
            }
        });
    })
})
