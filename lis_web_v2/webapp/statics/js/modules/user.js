$(function() {
	initData();
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

	// 2.初始化Button的点击事件
	var oButtonInit = new ButtonInit();
	oButtonInit.Init();
	
	$("#form_addUser_data").bootstrapValidator({  
        live: 'enabled',//验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证  
        excluded: [':disabled', ':hidden', ':not(:visible)'],//排除无需验证的控件，比如被禁用的或者被隐藏的  
        submitButtons: '#button-submit',//指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面  
        message: '验证不通过',//好像从来没出现过  
        feedbackIcons: {//根据验证结果显示的各种图标  
            valid: 'glyphicon glyphicon-ok',  
            invalid: 'glyphicon glyphicon-remove',  
            validating: 'glyphicon glyphicon-refresh'  
        },  
        fields: {  
        	usernameCn: {  
                validators: {  
                    notEmpty: {//检测非空,radio也可用  
                        message: '用户名不能为空'  
                    },  
                    stringLength: {//检测长度  
                        min: 2,  
                        max: 12,  
                        message: '长度必须在4-12个字符之间'  
                    }/* ,  
                    regexp: {//正则验证  
                        regexp: /^[a-zA-Z0-9_\.]+$/,  
                        message: '所输入的字符不符要求'  
                    },  
                    remote: {//将内容发送至指定页面验证，返回验证结果，比如查询用户名是否存在  
                        url: '指定页面',  
                        message: 'The username is not available'  
                    },  
                    different: {//与指定文本框比较内容相同  
                        field: '指定文本框name',  
                        message: '不能与指定文本框内容相同'  
                    },  
                    emailAddress: {//验证email地址  
                        message: '不是正确的email地址'  
                    },  
                    identical: {//与指定控件内容比较是否相同，比如两次密码不一致  
                        field: 'confirmPassword',//指定控件name  
                        message: '输入的内容不一致'  
                    },  
                    date: {//验证指定的日期格式  
                        format: 'YYYY/MM/DD',  
                        message: '日期格式不正确'  
                    },  
                    choice: {//check控件选择的数量  
                        min: 2,  
                        max: 4,  
                        message: '必须选择2-4个选项'  
                    }   */
                }  
            },
            username: {
                validators: {
                    notEmpty: {
                        message: '账号不能为空'
                    }
                }
            }  
        }  
    });  
    $("#button-submit").click(function () {//非submit按钮点击后进行验证，如果是submit则无需此句直接验证  
        $("#form_addUser_data").bootstrapValidator('validate');//提交验证  
        if ($("#form_addUser_data").data('bootstrapValidator').isValid()) {//获取验证结果，如果成功，执行下面代码  
        	var user = {
        			"id" : $('#id').val(),
        			"hisId" : $('#username').val(),
        			"password" : $('#username').val(),//hisId和密码默认为和账号相同
        			"enabled" : $('input[name="enabled"]:checked').val(),
        			"permissions" : $('input[name="permissions"]:checked').val(),
        			"username" : $('#username').val(),
        			"usernameCn" : $('#usernameCn').val(),
        			"lisInspecDepartment" : {
        				"id" : $('#lisInspecDepartment').val()
        			},
        			"lisInspecRole" : {
        				"id" : $('#lisInspecRole').val()
        			}
        		};
        		$.ajax({
        			// 几个参数需要注意一下
        			type : "POST",// 方法类型
        			dataType : "text",// 预期服务器返回的数据类型
        			url : "../user/saveUser.do",// url
        			async : true,
        			// data:JSON.stringify($('#form_addUser_data').serializeObject()),
        			data : JSON.stringify(user),
        			contentType : 'application/json;charset=utf-8',
        			success : function(data) {
        				$('#addUserModal').modal('hide');
        				toastr.success('保存成功');
        				$("#tb_user").bootstrapTable('refresh');
        				
        			},
        			error : function() {
        				toastr.error('Error');
        			} ,
        			complete : function() {
        				$('#usernameCn').val('');
        				$('#username').val('');
        			} 
        		}); 
        }  
    }); 
    adjustHeight();
});

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		//initData();
		$('#tb_user').bootstrapTable({
			url : '../user/getUsers.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			toolbar : '#toolbar', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : oTableInit.queryParams,// 传递参数（*）
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
			search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			//height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'usernameCn',
				title : '姓名'
			}, {
				field : 'username',
				title : '账号'
			}, {
				field : 'lisInspecDepartment.departName',
				title : '部门'
			},{
				field : 'lisInspecRole.roleName',
				title : '角色'
			}, {
				field : 'hisId',
				title : 'HISID'
			}, {
				field : 'enabled',
				title : '状态',
				align :"center",
				formatter:function(value,row,index){
					if (value == '0') {
						return "<span style='color:green;'>启用</span>";
					} else if (value == '1') {
						return "<span style='color:red;'>禁用</span>";
					}
					return value;
				}
			}, {
				field : 'permissions',
				title : '审核权',
				align :"center",
				formatter:function(value,row,index){
					if (value == '1') {
						return "<span style='color:green;'>拥有</span>";
					} else if (value == '0') {
						return "<span style='color:gray;'>无</span>";
					}
					return value;
				}
			},/* {
				field : 'devCodes',
				title : '设备',
			},*/ ]
		});
	};

	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit : params.limit, // 页面大小
			start : params.offset, // 页码
			userName : params.search
		};
		return temp;
	};
	return oTableInit;
};

var ButtonInit = function() {
	var oInit = new Object();
	var postdata = {};

	oInit.Init = function() {
		// 初始化页面上面的按钮事件
	};

	return oInit;
};

function initData() {
	$.ajax({
		type : "get",
		url : "../dept/getDepts.do",
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		// data : JSON.stringify({'url_name':url_name}),
		timeout : 1000,
		cache : false,
		success : function(data) {
			var h = "";
			$.each(data, function(key, value) {// 拼接option
				// console.log(value);
				h += "<option value='" + value.id + "'>" + value.departName
						+ "</option>";
			})
			$("#lisInspecDepartment").append(h);// append 添加进去并展示
			$("#lisInspecDepartment1").append(h);// append 添加进去并展示
		}
	})
	$.ajax({
		type : "get",
		url : "../role/getRoles.do",
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		// data : JSON.stringify({'url_name':url_name}),
		timeout : 1000,
		cache : false,
		success : function(data) {
			var h = "";
			$.each(data, function(key, value) {// 拼接option
				// console.log(value);
				h += "<option value='" + value.id + "'>" + value.roleName
						+ "</option>";
			})
			$("#lisInspecRole").append(h);// append 添加进去并展示
			$("#lisInspecRole1").append(h);// append 添加进去并展示
		}
	})
}



function delUser() {
	var a = $("#tb_user").bootstrapTable('getSelections');
	if (a.length <= 0) {
		toastr.warning('请选择有效数据');
		return;
	}
	var names = [];
	for (var i = 0; i < a.length; i++) {
		names.push({
			id : a[i].id
		});
	}

	Ewin.confirm({
		message : "确认要删除选择的数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
		$.ajax({
			type : "post",
			url : "../user/delUser.do",
			async : true,
			data : JSON.stringify(names),
			dataType : "text",// 预期服务器返回的数据类型
			contentType : 'application/json;charset=utf-8',
			success : function(data, status) {
				if (status == "success") {
					toastr.success('提交数据成功');
					$("#tb_user").bootstrapTable('refresh');
				}
			},
			error : function() {
				toastr.error('Error');
			},
			complete : function() {
				toastr.info('删除成功');
			}

		});
	});

}

/**
 * 打开角色编辑窗口
 */
function openEditUserWin() {
	var row = $('#tb_user').bootstrapTable('getSelections');
	//console.log(row);
	if (row.length == 0) {
		toastr.warning('请选择一个编辑用户');
		return;
	}else{
		//initData();
		$('#id1').val(row[0].id);
		$('#hisId1').val(row[0].hisId);
		$('#usernameCn1').val(row[0].usernameCn);
		$('#username1').val(row[0].username);
		//$("#lisInspecDepartment1").find("option[value='"+row[0].lisInspecDepartment.id+"']").attr("selected",true); 
		$("#lisInspecDepartment1").val(row[0].lisInspecDepartment.id);
		console.log(row[0].lisInspecDepartment.id);
		$('#lisInspecRole1').find("option[value='"+row[0].lisInspecRole.id+"']").attr("selected",true); 
		var enabled=row[0].enabled;
		if(parseInt(enabled)==0){
			$('#enabledTure').attr("checked","checked");
		}else{
			$('#enabledFalse').attr("checked","checked");
		}
		var permissions=row[0].permissions;
		if(parseInt(permissions)==1){
			$('#permissionsTure').attr("checked","checked");
		}else{
			$('#permissionsFalse').attr("checked","checked");
		}
		$('#updateUserModal').modal('show');
	}
	
}
//修改
function updateUserSubmit(){
	var edit = $("#tb_user").bootstrapTable('getSelections');
	var user = {
			"id" : $('#id1').val(),
			"hisId" : $('#hisId1').val(),
			"enabled" : $('input[name="enabled1"]:checked').val(),//状态 
			"permissions" : $('input[name="permissions1"]:checked').val(),//审核权限
			"username" : $('#username1').val(),
			"usernameCn" : $('#usernameCn1').val(),
			"lisInspecDepartment" : {
				"id" : $('#lisInspecDepartment1').val()
			},
			"lisInspecRole" : {
				"id" : $('#lisInspecRole1').val()
			}
		};
	$.ajax({
		type : "post",
		url : "../user/updateUser.do",
		async : true,
		data : JSON.stringify(user),
		dataType : "text",// 预期服务器返回的数据类型
		contentType : 'application/json;charset=utf-8',
		success : function(data, status) {
			if (status == "success") {
				//toastr.success('提交数据成功');
				$("#tb_user").bootstrapTable('refresh');
			}
		},
		error : function() {
			toastr.error('Error');
		},
		complete : function() {
			toastr.info('修改数据成功');
		}

	});
}
//页面加载完成后调整高度
function adjustHeight(){
	var h = $('.contentPanel').height();//main.html中的元素
	$(".userPanel").height(h);
}