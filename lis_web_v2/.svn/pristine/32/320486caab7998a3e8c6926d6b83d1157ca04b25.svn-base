$(function() {
	var ruleId = '';
	// 1.初始化Table
	var oTableLeft = new TableLeftInit();
	var oTableRightTop = new TableRightTopInit();
	var oTableRightDown = new TableRightDownInit();
	oTableLeft.Init();
	oTableRightTop.Init();
	oTableRightDown.Init();

	// 2.初始化Button的点击事件
	var oButtonInit = new ButtonInit();
	oButtonInit.Init();

	$("#form_barcodeRule_data").bootstrapValidator({
		live : 'enabled',// 验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
		excluded : [ ':disabled', ':hidden', ':not(:visible)' ],// 排除无需验证的控件，比如被禁用的或者被隐藏的
		submitButtons : '#button-submit-bcRule',// 指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
		message : '验证不通过',// 好像从来没出现过
		feedbackIcons : {// 根据验证结果显示的各种图标
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			ruleName : {
				validators : {
					notEmpty : {// 检测非空,radio也可用
						message : '条码规则不能为空'
					}
				}
			},
			priority : {
				validators : {
					notEmpty : {
						message : '优先级别不能为空'
					}
				}
			},
			barcodeNum : {
				validators : {
					notEmpty : {
						message : '条码数量不能为空'
					}
				}
			},
			prinNum : {
				validators : {
					notEmpty : {
						message : '打印张数不能为空'
					}
				}
			}
		}
	});
	$('#button-shutdown-bcRule').click(function() {// 关闭模态框，重置数据
		$('#ruleName').val('');
		$('#insepctionCategory').val('');
		$('#priority').val('');
		$('#barcodeNum').val('');
		$('#prinNum').val('');
		$('#para').val('');
		$('#condition').val('');
		$("#form_barcodeRule_data").data("bootstrapValidator").resetForm();
	});
	$('#btn_add_bcRule').click(function() {// 新增打开模态框，重置数据
		$('#ruleName').val('');
		$('#insepctionCategory').val('');
		$('#priority').val('');
		$('#barcodeNum').val('');
		$('#prinNum').val('');
		$('#para').val('');
		$('#condition').val('');
		$("#form_barcodeRule_data").data("bootstrapValidator").resetForm();
	});
	$("#button-submit-bcRule").click(
			function() {// 非submit按钮点击后进行验证，如果是submit则无需此句直接验证
				$("#form_barcodeRule_data").bootstrapValidator('validate');// 提交验证
				if ($("#form_barcodeRule_data").data('bootstrapValidator')
						.isValid()) {// 获取验证结果，如果成功，执行下面代码
					var bcRule = JSON.stringify($("#form_barcodeRule_data")
							.serializeObject())
					$.ajax({
						// 几个参数需要注意一下
						type : "POST",// 方法类型
						dataType : "text",// 预期服务器返回的数据类型
						url : "../bcrule/saveBcRule.do",// url
						async : true,
						data : bcRule,
						contentType : 'application/json;charset=utf-8',
						success : function(data) {
							$('#barcodeRuleModal').modal('hide');
							toastr.success('保存成功');
							$("#form_barcodeRule_data").data("bootstrapValidator").resetForm();
							$("#tb_barcodeRule").bootstrapTable('refresh');
						},
						error : function() {
							toastr.error('Error');
						}
					});
				}
			});
	adjustHeight();
});
var TableRightTopInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tb_barcodeRuleCon').bootstrapTable({
			url : '../bcrule/getConbyRuleid.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			// toolbar : '#toolbar-hosp', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			nlyInfoPagination : true,
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : oTableInit.queryParams,// 传递参数（*）
			sidePagination : "client", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : false,
			showColumns : false, // 是否显示所有的列
			showRefresh : false, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showToggle : false, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			singleSelect : true,
			responseHandler : function(res) {
				var len = res.length;
				for (var i = 0; i < len; i++) {
					res[i].index = i;
				}
				return res;
			},
			columns : [ {
				checkbox : true
			}, {
				field : 'lisInspecContainer.id',
				title : '容器名称(<font color="red">单击可进行编辑</font>)',
				editable : {
					type : 'select',
					title : '容器',
					source : function() {
						var result = [];
						$.ajax({
							url : '../container/getAllContainer.do',
							async : false,
							type : "post",
							dataType : "json",// 预期服务器返回的数据类型
							data : {},
							success : function(data, status) {
								$.each(data, function(key, value) {
									result.push({
										value : value.id,
										text : value.name
									});
								});
							}
						});
						return result;
					}
				}
			}, {
				field : 'lisInspecContainer.name',
				title : '名称',
				visible : false,
			}, {
				field : 'lisInspecContainer.color',
				title : '颜色'
			}, {
				field : 'lisInspecContainer.code',
				title : '代码'
			}, {
				field : 'lisInspecContainer.remark',
				title : '备注'
			} ],
			onEditableSave : function(field, row, oldValue, $el) {
				var id = row["lisInspecContainer.id"];
				var index = row.index;
				$.ajax({
					url : '../container/getContainerById.do',
					async : false,
					type : "post",
					data : {
						'id' : id
					},
					dataType : "json",// 预期服务器返回的数据类型
					success : function(data, status) {
						row.lisInspecContainer.id = data.id;
						row.lisInspecContainer.name = data.name;
						row.lisInspecContainer.color = data.color;
						row.lisInspecContainer.code = data.code;
						row.lisInspecContainer.remark = data.remark;
						$('#tb_barcodeRuleCon').bootstrapTable('updateRow', {
							index : index,
							row : row
						});
					}
				});
				var rows = JSON.stringify(row);
				$.ajax({
					url : '../bcrule/saveBcRuleContainer.do',
					async : false,
					type : "post",
					data : rows,
					dataType : "text",// 预期服务器返回的数据类型
					contentType : 'application/json;charset=utf-8',
					success : function(data, status) {
						var res = JSON.parse(data);
						if (res.code == 0) {
							toastr.success('保存成功');
						} else {
							toastr.error('保存失败', res.message);
						}
					}
				});
			},
		});
	};

	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		// limit : params.limit, // 页面大小
		// start : params.offset, // 页码
		// hosName : params.search
		};
		return temp;
	};
	return oTableInit;
};
var TableRightDownInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tb_barcodeRuleItem').bootstrapTable({
			url : '../bcrule/getItembyRuleid.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			// toolbar : '#toolbar-hosp', // 工具按钮用哪个容器
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			nlyInfoPagination : true,
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : oTableInit.queryParams,// 传递参数（*）
			sidePagination : "client", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : false,
			showColumns : false, // 是否显示所有的列
			showRefresh : false, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showToggle : false, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			singleSelect : true,
			responseHandler : function(res) {
				var len = res.length;
				for (var i = 0; i < len; i++) {
					res[i].index = i;
				}
				return res;
			},
			columns : [ {
				checkbox : true
			}, {
				field : 'lisRequestionItem.id',
				title : '项目名称(<font color="red">单击可进行编辑</font>)',
				editable : {
					type : 'select',
					title : '项目',
					source : function() {
						var result = [];
						$.ajax({
							url : '../item/getAllItem.do',
							async : false,
							type : "post",
							dataType : "json",// 预期服务器返回的数据类型
							data : {},
							success : function(data, status) {
								$.each(data, function(key, value) {
									result.push({
										value : value.id,
										text : value.requestionName
									});
								});
							}
						});
						return result;
					}
				}
			}, {
				field : 'lisRequestionItem.charge',
				title : '价格'
			}, {
				field : 'lisRequestionItem.sampleName',
				title : '标本'
			}, {
				field : 'lisRequestionItem.container',
				title : '所需容器'
			}, {
				field : 'lisRequestionItem.isUse',
				title : '状态'
			} ],
			onEditableSave : function(field, row, oldValue, $el) {
				var id = row["lisRequestionItem.id"];
				var index = row.index;
				$.ajax({
					url : '../item/getItemById.do',
					async : false,
					type : "post",
					data : {
						'id' : id
					},
					dataType : "json",// 预期服务器返回的数据类型
					success : function(data, status) {
						row.lisRequestionItem.id = data.id;
						row.lisRequestionItem.requestionName = data.requestionName;
						row.lisRequestionItem.charge = data.charge;
						row.lisRequestionItem.sampleName =data.sampleName;
						$('#tb_barcodeRuleItem').bootstrapTable('updateRow', {
							index : index,
							row : row
						});
					}
				});
				var rows = JSON.stringify(row);
				$.ajax({
					url : '../bcrule/saveBcRuleItem.do',
					async : false,
					type : "post",
					data : rows,
					dataType : "text",// 预期服务器返回的数据类型
					contentType : 'application/json;charset=utf-8',
					success : function(data, status) {
						var res = JSON.parse(data);
						if (res.code == 0) {
							toastr.success('保存成功');
						} else {
							toastr.error('保存失败', res.message);
						}
					}
				});
			},
		});
	};

	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		// ruleId : params.search
		};
		return temp;
	};
	return oTableInit;
};
var TableLeftInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tb_barcodeRule').bootstrapTable(
				{
					url : '../bcrule/queryInspRule.do', // 请求后台的URL（*）
					method : 'get', // 请求方式（*）
					//toolbar : '#toolbar-hosp', // 工具按钮用哪个容器
					striped : true, // 是否显示行间隔色
					cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
					onlyInfoPagination : true,
					pagination : true, // 是否显示分页（*）
					sortable : false, // 是否启用排序
					sortOrder : "asc", // 排序方式
					queryParams : oTableInit.queryParams,// 传递参数（*）
					sidePagination : "client", // 分页方式：client客户端分页，server服务端分页（*）
					search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
					strictSearch : false,
					showColumns : false, // 是否显示所有的列
					showRefresh : false, // 是否显示刷新按钮
					minimumCountColumns : 2, // 最少允许的列数
					clickToSelect : true, // 是否启用点击选中行
					//height : 572, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
					uniqueId : "id", // 每一行的唯一标识，一般为主键列
					showToggle : false, // 是否显示详细视图和列表视图的切换按钮
					cardView : false, // 是否显示详细视图
					detailView : false, // 是否显示父子表
					singleSelect : true,
					columns : [ {
						checkbox : true
					}, {
						field : 'ruleName',
						title : '规则名称'
					}, {
						field : 'insepctionCategory',
						title : '检验类别'
					}, {
						field : 'priority',
						title : '优先级别'
					}, {
						field : 'barcodeNum',
						title : '条码数量'
					}, {
						field : 'para',
						title : '参数条件'
					}, {
						field : 'prinNum',
						title : '打印张数'
					}, {
						field : 'condition',
						title : '适合条件'
					} ],
					onClickRow : function(row, obj) {
						ruleId = row.id;
						refreshTable();
					},
					onDblClickRow : function(row, obj) {// 双击进行编辑
						$.ajax({
							type : "get",
							url : "../bcrule/getBcRuleByID.do",
							async : true,
							data : {
								'id' : row.id
							},
							dataType : "json",// 预期服务器返回的数据类型
							contentType : 'application/json;charset=utf-8',
							success : function(data, status) {
								if (status == "success") {
									$('#id-bcRule').val(data.id);
									$('#ruleName').val(data.ruleName);
									$('#insepctionCategory').val(
											data.insepctionCategory);
									$('#priority').val(data.priority);
									$('#barcodeNum').val(data.barcodeNum);
									$('#prinNum').val(data.prinNum);
									$('#para').val(data.para);
									$('#condition').val(data.condition);
								}
							},
							error : function() {
								toastr.error('Error');
							},
							complete : function() {
								$('#btn_edit_bcRule').attr('data-target', '');
							}
						});
						$('#barcodeRuleModal').modal('show');
					}
				});
	};

	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
		// limit : params.limit, // 页面大小
		// start : params.offset, // 页码
		// hosName : params.search
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
		$('#btn_edit_bcRule').on("click", function() {
			var a = $("#tb_barcodeRule").bootstrapTable('getSelections');
			if (a.length <= 0 || a.length > 1) {
				toastr.warning('每次只能编辑一条数据,请选择有效数据,亲');
				return;
			}
			$('#btn_edit_bcRule').attr('data-target', '#barcodeRuleModal');
			$.ajax({
				type : "get",
				url : "../bcrule/getBcRuleByID.do",
				async : true,
				data : {
					'id' : a[0].id
				},
				dataType : "json",// 预期服务器返回的数据类型
				contentType : 'application/json;charset=utf-8',
				success : function(data, status) {
					if (status == "success") {
						$('#id-bcRule').val(data.id);
						$('#ruleName').val(data.ruleName);
						$('#insepctionCategory').val(data.insepctionCategory);
						$('#priority').val(data.priority);
						$('#barcodeNum').val(data.barcodeNum);
						$('#prinNum').val(data.prinNum);
						$('#para').val(data.para);
						$('#condition').val(data.condition);
					}
				},
				error : function() {
					toastr.error('Error');
				},
				complete : function() {
					$('#btn_edit_bcRule').attr('data-target', '');
				}
			});

		});
		$('#btn_delete_bcRule').on("click", function() {// 删除按钮
			var a = $("#tb_barcodeRule").bootstrapTable('getSelections');
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
					url : "../bcrule/delBcRule.do",
					async : true,
					data : JSON.stringify(names),
					dataType : "text",// 预期服务器返回的数据类型
					contentType : 'application/json;charset=utf-8',
					success : function(data, status) {
						if (status == "success") {
							toastr.success('提交数据成功');
							$("#tb_barcodeRule").bootstrapTable('refresh');
							refreshTable();
						}
					},
					error : function() {
						toastr.error('Error');
						refreshTable();
					},
					complete : function() {
						toastr.info('删除成功');
					}

				});
			});
		});
	};

	return oInit;
};
// 添加规则容器 按钮
function addRuleCon() {
	var ruleData =  $('#tb_barcodeRule').bootstrapTable('getSelections');
	if (ruleData.length==0) {
		toastr.warning('请选择一个规则');
	}
	var allData = $('#tb_barcodeRuleCon').bootstrapTable('getData');
	var length = allData.length;
	if (length==0) {
		var lastIndex = -1;
	}else{
		var lastIndex = allData[length - 1].index;
	}
	var lisInspecContainer = {
		id : ''
	};
	var lisWebBarcodeRule = {
		id : ruleId
	};
	var row = {
		'id' : '',
		'enable' : '',
		'useNumber' : '',
		'lisInspecContainer' : lisInspecContainer,
		'lisWebBarcodeRule' : lisWebBarcodeRule,
		index : lastIndex + 1
	};
	$('#tb_barcodeRuleCon').bootstrapTable('insertRow', {
		index : length,
		row : row
	});
}
//删除容器
function deleteRuleCon() {
	var a = $("#tb_barcodeRuleCon").bootstrapTable('getSelections');
	if (a.length <= 0) {
		toastr.warning('请选择有效数据');
		return;
	}
	Ewin.confirm({
		message : "确认要删除选择的数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
		$.ajax({
			type : "post",
			url : "../bcrule/delBcRuleCon.do",
			async : true,
			data : JSON.stringify(a[0]),
			dataType : "text",// 预期服务器返回的数据类型
			contentType : 'application/json;charset=utf-8',
			success : function(data, status) {
				var res = JSON.parse(data);
				if (res.code == 0) {
					toastr.success('删除成功');
					refreshTable();
				} else {
					toastr.error('删除失败', res.msg);
				}
			},
			error : function() {
				toastr.error('Error');
			}
		});
	});
}
// 添加规则项目  按钮
function addRuleItem() {
	var ruleData =  $('#tb_barcodeRule').bootstrapTable('getSelections');
	if (ruleData.length==0) {
		toastr.warning('请选择一个规则');
	}
	var allData = $('#tb_barcodeRuleItem').bootstrapTable('getData');
	var length = allData.length;
	
	if (length==0) {
		var lastIndex = -1;
	}else{
		var lastIndex = allData[length - 1].index;
	}
	var lisRequestionItem = {
		id : ''
	};
	var lisWebBarcodeRule = {
		id : ruleId
	};
	var row = {
		'id' : '',
		'lisRequestionItem' : lisRequestionItem,
		'lisWebBarcodeRule' : lisWebBarcodeRule,
		index : lastIndex + 1
	};
	$('#tb_barcodeRuleItem').bootstrapTable('insertRow', {
		index : length,
		row : row
	});
}
//删除项目
function deleteRuleItem() {
	var a = $("#tb_barcodeRuleItem").bootstrapTable('getSelections');
	if (a.length <= 0) {
		toastr.warning('请选择有效数据');
		return;
	}
	Ewin.confirm({
		message : "确认要删除选择的数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
		$.ajax({
			type : "post",
			url : "../bcrule/delBcRuleItem.do",
			async : true,
			data : JSON.stringify(a[0]),
			dataType : "text",// 预期服务器返回的数据类型
			contentType : 'application/json;charset=utf-8',
			success : function(data, status) {
				var res = JSON.parse(data);
				if (res.code == 0) {
					toastr.success('删除成功');
					refreshTable();
				} else {
					toastr.error('删除失败', res.msg);
				}
			},
			error : function() {
				toastr.error('Error');
			}
		});
	});
}
// 刷新表格
function refreshTable() {
	var optItem = {
		url : "../bcrule/getItembyRuleid.do",
		silent : true,
		query : {
			ruleId : ruleId
		}
	};
	var optCon = {
		url : "../bcrule/getConbyRuleid.do",
		silent : true,
		query : {
			ruleId : ruleId
		}
	};
	$('#tb_barcodeRuleCon').bootstrapTable('refresh', optCon);// 刷新容器表
	$('#tb_barcodeRuleItem').bootstrapTable('refresh', optItem);// 刷新项目表
}
//页面加载完毕后  调整本页面panel高度
function adjustHeight(){
	var h = $('.contentPanel').height();
	$(".rightTwoPanel").height(h);
	$(".leftRulePanel").height(h);
}