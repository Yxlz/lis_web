/**
 * 如果未登陆，则弹出登陆框进行登录，然后再发送ajax请求
 * @param url 请求路径
 * @param params 请求参数
 * @param success 请求成功后的操作
 * @param method 请求方式，默认post
 * @param failure 请求失败操作
 */
function commAjax(params){
	Ext.Ajax.request({
		url : "../login/islogin.do",
		method : "POST",
		success : function(resp,options) {
			var data = Ext.decode(resp.responseText);
			//已登录
			if(data.code==0){
			   sendAjax(params);
			}else{//未登录
				openLoginWin(params);
			}
        },                                                                                                                 
        failure : function(data, options) {
        	//操作失败
        	Ext.MessageBox.alert("信息提示","系统错误，请重试!"); 
        }
	});
}

/**
 * 发送ajax请求
 * 
 * @param url 请求路径
 * @param params 请求参数
 * @param success 请求成功后的操作
 * @param method 请求方式，默认post
 * @param failure 请求失败操作
 */
function sendAjax(params){
	Ext.Ajax.request({
		url : params.url,
		params : params.params,
		method : params.method==undefined?"POST":"GET",
		scope : this,
		success : function(resp,options) {
            if(!params.success) return;
            try {
            	var data = Ext.decode(resp.responseText);
            	//这里将返回信息解析成了json对象，不需要使用者再次进行手动解析
                if(data&&data.code==3){
    				Ext.Msg.alert("错误", data.msg);
    				return;
    			}
			} catch (e) {}
			//params.success(data, resp, options);
            params.success(resp, options);
        },                                                                                                                 
        failure : function(data, options) {
        	//操作失败
        	if(params.failure) params.failure(data, options);
        }
	});
}

/**
 * 弹出登陆窗口
 */
function openLoginWin(params){
	var form = new Ext.form.FormPanel({
		id:"loginWinForm",
		labelWidth: 70,
		buttonAlign: "center",
		bodyStyle: "padding:10px;",
		frame: true,
		defaultType: "textfield",
		defaults: {
			allowBlank: false,
			anchor: "98%",
			enableKeyEvents: false
		},
		items: [{
			xtype: "displayfield",
			hideLabel: true,
			html: "<img src='../statics/img/logo.png' class='login-logo' />"
		}, {
			name: "username",
			fieldLabel: "用户名",
			value: "admin"
		}, {
			inputType: "password",
			name: "password",
			fieldLabel: "密码",
			value: "123456"
		}],
		buttons: [{
			text: "登录",
			scope: this,
			handler: function() {
				doLogin(params);
			}
		}, {
			text: "重置",
			scope: this,
			handler: function() {
				form.reset();
			}
		}]
	});
	var win = new Ext.Window({
		id:"loginWin",
		title: "用户登录",
		width: 400,
		height: 250,
		plain: true,
		draggable: true,
		resizable: false,
		closable: false,
		layout: "fit",
		border: false,
		modal: true,
		items: [form]
	});
	win.show();
}

//登陆
function doLogin(params){
	if(Ext.getCmp("loginWinForm").getForm().isValid()) {
		Ext.Ajax.request({ 
            url : '../login/login.do',  
            waitMsg : '登录中,请稍后......',  
            waitTitle : '登录',  
            params : Ext.getCmp("loginWinForm").getForm().getValues(),  
            method : 'POST',  
            success : function(resp) {//成功后要做的事情 
            	var data = Ext.decode(resp.responseText);
            	if(data.code==0){
            		Ext.getCmp("loginWin").close();
            		//登录成功后自动提交ajax请求
            		sendAjax(params);
            	}else{
            		Ext.MessageBox.alert("信息提示",data.msg); 
            	}
            },                                                                                                                 
            failure : function(data, options) {
            	Ext.MessageBox.alert("信息提示","系统错误，请重试!"); 
            }
        });
	}
}
/**
 * 获取当前登录用户账号
 * 
 * @param params
 */
function getAccount(){
	var user = "";
	Ext.Ajax.request({ 
        url : '../login/userAccount.do',  
        method : 'POST',  
        async : false,
        success : function(resp) {//成功后要做的事情 
        	user = resp.responseText;
        },                                                                                                                 
        failure : function(data, options) {
        	Ext.MessageBox.alert("信息提示","系统错误，请重试!"); 
        }
    });
	
	return user;
}

/**
 * 获取当前登录用户名
 * 
 * @param params
 */
function getLoguser(){
	var user = "";
	Ext.Ajax.request({ 
        url : '../login/loguser.do',  
        method : 'POST',  
        async : false,
        success : function(resp) {//成功后要做的事情 
        	user = resp.responseText;
        },                                                                                                                 
        failure : function(data, options) {
        	Ext.MessageBox.alert("信息提示","系统错误，请重试!"); 
        }
    });
	
	return user;
}
/**
 * 获取当前登录用户组织信息
 * 
 * @param params
 */
function getOrgname(){
	var orgname = "";
	Ext.Ajax.request({ 
        url : '../login/orgname.do',  
        method : 'POST',
        
        async : false,
        success : function(resp) {//成功后要做的事情 
        	orgname = resp.responseText;
        },                                                                                                                 
        failure : function(data, options) {
        	Ext.MessageBox.alert("信息提示","系统错误，请重试!"); 
        }
    });
	
	return orgname;
}

