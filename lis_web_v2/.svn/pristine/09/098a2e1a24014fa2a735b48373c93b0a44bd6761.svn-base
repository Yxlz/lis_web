$(function(){login.init();})
var login = {
   init:function(){
	   login.initBody();
	   $("#cancelBl").click(function(){
		   $("#username").val("");
		   $("#password").val("");
	   })
	   $("#loginBl").click(function(){
		   login.doLogin();
	   })
	   
	   //键盘事件
		document.onkeydown=function(event){
	        var e = event || window.event || arguments.callee.caller.arguments[0];
	        if(e && e.keyCode==13){ // 按enter键登录
	        	var uname = $("#username").val();
	        	var passwd = $("#password").val();
	        	if(uname==""){
	        		$("#username").focus();
	        		return false;
	        	}
	        	if(passwd==""){
	        		$("#password").focus();
	        		return false;
	        	}
	        	login.doLogin();
	        }
	    }; 
   },
   initBody:function(){
	   var height = $(window).height();
	   var width = $(window).width();
	   $("#mainBody").width(width);
	   $("#mainBody").height(height);
	   $("#bgIcon").width(width);
	   $("#bgIcon").height(height);
	   $("#bgIcon").css("minHeight",645);
	   $(".login-field").css("top",$(document).height()/2-200);
	   $(".login-field").css("left",width/2-200);
   },
   doLogin:function(){
	   var uname = $("#username").val();
		var passwd = $("#password").val();
		if(uname==""){
			toastr.warning('请输入用户名！');
			return false;
		}
		if(passwd==""){
			toastr.warning('请输入密码！');
			return false;
		}
		$.ajax({
			url : "../../login/login.do",
			data : {
				username:uname,
				password:passwd
			},
			type : 'post',
			cache : false,
			async: true,
			dataType : 'json',
			success : function(data) {
				if(data.code==0){
            		window.location.href="../../views/main.html";
            	}else{
            		toastr.error(data.msg);
            	}
			},
			error : function() {
				toastr.error("系统异常，请重试！");
			}
		});
		return false;
   }
}