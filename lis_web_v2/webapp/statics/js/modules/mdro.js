$(function() {
	// initData();
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

	// 2.初始化Button的点击事件
	var oButtonInit = new ButtonInit();
	oButtonInit.Init();

	$("#form_addMdro_data").bootstrapValidator({
		live : 'enabled',// 验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
		excluded : [ ':disabled', ':hidden', ':not(:visible)' ],// 排除无需验证的控件，比如被禁用的或者被隐藏的
		submitButtons : '#button-submit-mdro',// 指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
		message : '验证不通过',// 好像从来没出现过
		feedbackIcons : {// 根据验证结果显示的各种图标
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			mdroName : {
				validators : {
					notEmpty : {// 检测非空,radio也可用
						message : '耐药菌名称不能为空'
					},
					stringLength : {// 检测长度
						min : 2,
						max : 12,
						message : '长度必须在1-12个字符之间'
					}
				}
			},
			mdroCode : {
				validators : {
					notEmpty : {
						message : '耐药菌代码不能为空'
					}
				}
			},
			mdroSuggestion : {
				validators : {
					notEmpty : {
						message : '耐药菌治疗指导意见不能为空'
					}
				}
			}
		}
	});
	$("#button-submit-mdro").click(function() {// 非submit按钮点击后进行验证，如果是submit则无需此句直接验证

		$("#form_addMdro_data").bootstrapValidator('validate');// 提交验证
		if ($("#form_addMdro_data").data('bootstrapValidator').isValid()) {// 获取验证结果，如果成功，执行下面代码
			var mdro = {
				"id" : $('#id').val(),
				"mdroName" : $('#mdroName').val(),
				"mdroCode" : $('#mdroCode').val(),
				"mdroSuggestion" : $('#mdroSuggestion').val()
			};
			$.ajax({
				// 几个参数需要注意一下
				type : "POST",// 方法类型
				dataType : "text",// 预期服务器返回的数据类型
				url : "../mdro/saveMdro.do",// url
				async : true,
				// data:JSON.stringify($('#form_addUser_data').serializeObject()),
				data : JSON.stringify(mdro),
				contentType : 'application/json;charset=utf-8',
				success : function(data) {
					$('#addMdroModal').modal('hide');
					toastr.success('保存成功');
					$("#tb_mdro").bootstrapTable('refresh');

				},
				error : function() {
					toastr.error('Error');
				},
				complete : function() {
					$('#mdroName').val('');
					$('#mdroCode').val('');
					$('#mdroSuggestion').val('');
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
		// initData();
		$('#tb_mdro').bootstrapTable({
			url : '../mdro/getMdros.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			toolbar : '#toolbarMdro', // 工具按钮用哪个容器
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
			// height : 500, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'mdroName',
				title : '耐药菌名称'
			}, {
				field : 'mdroCode',
				title : '耐药菌代码'
			}, {
				field : 'mdroSuggestion',
				title : '临床治疗指导意见'
			}, {
				field : 'operate',
				title : '操作',
				align : 'center',
				width : 100,
				events : operateEvents,
				formatter : operateFormatter
			} ]
		});

		//表格数据加载完成后对感染指导意见加超链接
//		$('#tb_mdro')
//				.on(
//						'load-success.bs.table',
//						function() {
//							var tableId = document.getElementById("tb_mdro");
//							var str = "";
//							var strHtml = "";
//							for (var i = 1; i < tableId.rows.length; i++) {
//								str = tableId.rows[i].cells[3].innerText;
//								strHtml = "<a href='#' data-toggle='popover' title='Example popover'>"
//										+ str + "</a>";
//								$('#tb_mdro').find("tr").eq(i).find("td").eq(3)
//										.text('');
//								$('#tb_mdro').find("tr").eq(i).find("td").eq(3)
//										.text(strHtml);
//							}
//
//							console.log($('#tb_mdro').bootstrapTable(
//									'getOptions').totalRows);
//						});
	};

	function operateFormatter(value, row, index) {
		return [ '<button type="button" class="RoleOfdetail btn btn-primary  btn-sm" style="margin-right:15px;">查看详情</button>' ]
				.join('');
	}
	
	window.operateEvents = {
		'click .RoleOfdetail' : function(e, value, row, index) {
			var mdroCode = document.getElementById("tb_mdro").rows[index+1].cells[2].innerText;
			$.ajax({
				// 几个参数需要注意一下
				type : "POST",// 方法类型
				dataType : "html",// 预期服务器返回的数据类型
				url : "../mdro/getMdro.do",// url
				async : true,
				// data:JSON.stringify($('#form_addUser_data').serializeObject()),
				data : {"mdroCode":mdroCode},
				contentType : 'application/x-www-form-urlencoded',
				success : function(data) {
					var ow = window.open();
			        ow.document.write(data);
			        ow.document.clear();
				},
				error : function() {
					toastr.error('Error');
				},
				complete : function() {
				}
			});
		}
	};
	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit : params.limit, // 页面大小
			start : params.offset, // 页码
			mdroCode : params.search
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

function delMdro() {
	var a = $("#tb_mdro").bootstrapTable('getSelections');
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
			url : "../mdro/delMdro.do",
			async : true,
			data : JSON.stringify(names),
			dataType : "text",// 预期服务器返回的数据类型
			contentType : 'application/json;charset=utf-8',
			success : function(data, status) {
				if (status == "success") {
					toastr.success('提交数据成功');
					$("#tb_mdro").bootstrapTable('refresh');
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
function openEditMdroWin() {
	var row = $('#tb_mdro').bootstrapTable('getSelections');
	// console.log(row);
	if (row.length == 0) {
		toastr.warning('请选择一个编辑用户');
		return;
	} else if (row.length > 1) {
		toastr.warning('亲,你多选啦');
		return;
	} else {
		// initData();
		$('#id2').val(row[0].id);
		$('#mdroName2').val(row[0].mdroName);
		$('#mdroCode2').val(row[0].mdroCode);
		$('#mdroSuggestion2').val(row[0].mdroSuggestion);

		$('#updateMdroModal').modal('show');
	}

}
// 修改
function updateMdroSubmit() {
	var edit = $("#tb_mdro").bootstrapTable('getSelections');
	var user = {
		"id" : $('#id2').val(),
		"mdroName" : $('#mdroName2').val(),
		"mdroCode" : $('#mdroCode2').val(),
		"mdroSuggestion" : $('#mdroSuggestion2').val()
	};
	$.ajax({
		type : "post",
		url : "../mdro/updateMdro.do",
		async : true,
		data : JSON.stringify(user),
		dataType : "text",// 预期服务器返回的数据类型
		contentType : 'application/json;charset=utf-8',
		success : function(data, status) {
			if (status == "success") {
				// toastr.success('提交数据成功');
				$("#tb_mdro").bootstrapTable('refresh');
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
// 页面加载完成后调整高度
function adjustHeight() {
	var h = $('.contentPanel').height();// main.html中的元素
	$(".mdroPanel").height(h);
}