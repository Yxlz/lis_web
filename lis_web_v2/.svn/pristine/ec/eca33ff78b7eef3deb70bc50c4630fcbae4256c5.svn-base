/*
 * 用户登录
 */

Ext.ns("App");

App.LoginWin = function() {
	return {
		show: function() {
			if(!this.win) {
				this.win = this.getWin();
			}
			this.win.show();
		},
		
		getWin: function() {
			var form = this.getForm();
			var win = new Ext.Window({
				title: "用户登录",
				width: 400,
				height: 250,
				plain: true,
				resizable: false,
				closable: false,
				//draggable: true,
				//frame: true,
				layout: "fit",
				border: false,
				modal: true,
				items: [form]
			});
			this.form = form;
			return win;
		},
		
		getForm: function() {
			var form = new Ext.form.FormPanel({
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
					html: "<img src='../../statics/img/logo.png' class='login-logo' />"
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
						this.submit();
					}
				}, {
					text: "重置",
					scope: this,   
					handler: function() {
						form.getForm().findField("username").setValue("");
						form.getForm().findField("password").setValue("");
					}
				}]
			});
			return form;
		},
		
		submit: function() {
			if(this.form.getForm().isValid()) {
				Ext.Ajax.request({ 
                    url : '../../login/login.do',  
                    waitMsg : '登录中,请稍后......',  
                    waitTitle : '登录',  
                    params : this.form.getForm().getValues(),  
                    method : 'POST',  
                    success : function(resp) {//成功后要做的事情 
                    	var data = Ext.decode(resp.responseText);
                    	if(data.code==0){
                    		window.location.href="../../views/main.html";
                    	}else{
                    		Ext.MessageBox.alert("信息提示",data.msg); 
                    	}
                    },                                                                                                                 
                    failure : function(data, options) {
                    	Ext.MessageBox.alert("信息提示","系统异常，请重试！"); 
                    }
                });
			}
		},
		register: function(){
			window.location.href="../../views/login/register.html";
		}
	};
}();