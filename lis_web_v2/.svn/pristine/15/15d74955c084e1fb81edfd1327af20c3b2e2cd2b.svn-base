/**
 * 检验项目维护
 */
$(document).ready(function() {
	initTypeTable();
	initItemTable();
	initSelectData();
	adjustHeight();
	initValidate();
	//bootstrap-select 初始化
	$(".selectpicker").selectpicker({  
       noneSelectedText : '请选择'//默认显示内容  
    });  
	$('.selectpicker').selectpicker('render');  
	$('.selectpicker').selectpicker('refresh');  
});
function initTypeTable() {
	$('#tb_inspecType').bootstrapTable({
		url : '../inspecType/getAllType.do',
		method : 'get', // 请求方式（*）
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 25, // 每页的记录行数（*）
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		showToggle : false, // 是否显示详细视图和列表视图的切换按钮
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		singleSelect : true,
		columns : [ {
			checkbox : true
		}, {
			field : 'name',
			title : '项目类别	',
			halign : 'center',
			align : 'center'
		}],
		onCheck : function(row, tr) {
			var data = $('#tb_inspecType').bootstrapTable('getSelections');
			var inspecName = '';
			if (data.length != 0) {
				inspecName = data[0].name;
			}
			$('#tb_inspecItem').bootstrapTable('refresh', {
				silent : true,
				query : {
					inspecName : inspecName,
					requestionName : ''
				}
			});
		},
		onUncheck : function(row, tr) {
			$('#tb_inspecItem').bootstrapTable('refresh', {
				silent : true,
				query : {
					inspecName : '',
					requestionName : ''
				}
			});
		}
	});
}
function initItemTable() {
	$('#tb_inspecItem').bootstrapTable({
		url : '../item/getItemByPage.do',
		method : 'get', // 请求方式（*）
		striped : true, // 是否显示行间隔色
		toolbar : '#toolbar_inspecItem',
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		pagination : true, // 是否显示分页（*）
		sortable : true, // 是否启用排序
		search : true,
		sortOrder : "asc", // 排序方式
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		queryParams : function(params) {
			var data = $('#tb_inspecType').bootstrapTable('getSelections');
			var inspecName = '';
			if (data.length != 0) {
				inspecName = data[0].name;
			}
			return {
				start : params.offset,
				limit : params.limit,
				requestionName : params.search,
				inspecName : inspecName
			};
		},// 传递参数（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		showToggle : false, // 是否显示详细视图和列表视图的切换按钮
		cardView : false, // 是否显示详细视图
		singleSelect : true,
		detailView : false, // 是否显示父子表
		columns : [ {
			checkbox : true
		}, {
			field : 'requestionName',
			title : '项目名	',

		}, {
			field : 'customCode',
			title : '助记码',

		}, {
			field : 'inspecName',
			title : '检验类别',

		}, {
			field : 'sampleName',
			title : '标本',

		}, {
			field : 'container',
			title : '容器',

		}, {
			field : 'charge',
			title : '价格',

		}, {
			field : 'requestionCode',
			title : '编码',
			visible : false,
		} ]
	});
}
//初始化表单验证插件
function initValidate(){
	//检验类型表单
	$("#form_addItemType_data").bootstrapValidator({
		live : 'enabled',// 验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
		excluded : [ ':disabled', ':hidden', ':not(:visible)' ],// 排除无需验证的控件，比如被禁用的或者被隐藏的
		message : '验证不通过',// 好像从来没出现过
		feedbackIcons : {// 根据验证结果显示的各种图标
			valid : 'glyphicon glyphicon-ok',
			invalid : 'glyphicon glyphicon-remove',
			validating : 'glyphicon glyphicon-refresh'
		},
		fields : {
			name : {
				validators : {
					notEmpty : {// 检测非空,radio也可用
						message : '名称不能为空'
					}
				}
			},
		}
	});
}
// 加载下拉框的数据
function initSelectData() {
	$.ajax({
		type : "get",
		url : "../container/getAllContainer.do",
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		// data : JSON.stringify({'url_name':url_name}),
		timeout : 1000,
		cache : false,
		success : function(data) {
			var h = "";
			$.each(data, function(key, value) {// 拼接option
				// console.log(value);
				h += "<option value='" + value.name + "'>" + value.name
						+ "</option>";
			})
			$("#item_containerName").append(h);// append 添加进去并展示
			$("#item_containerName").selectpicker('refresh');  
		}
	});
	$.ajax({
		type : "get",
		url : "../inspecType/getAllType.do",
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		// data : JSON.stringify({'url_name':url_name}),
		timeout : 1000,
		cache : false,
		success : function(data) {
			var h = "";
			$.each(data, function(key, value) {// 拼接option
				// console.log(value);
				h += "<option value='" + value.name + "'>" + value.name
						+ "</option>";
			})
			$("#item_inspecName").append(h);// append 添加进去并展示
			$("#item_inspecName").selectpicker('refresh');  
		}
	})
	$.ajax({
		type : "get",
		url : "../inspecType/getSampleType.do",
		contentType : "application/json; charset=UTF-8",
		dataType : "json",
		// data : JSON.stringify({'url_name':url_name}),
		timeout : 1000,
		cache : false,
		success : function(data) {
			//console.log(data.length);
			var h = "";
			for (var i = 0; i < data.length; i++) {
				h += "<option value='" + data[i] + "'>" + data[i]
				+ "</option>";
			}
			$("#item_sampleName").append(h);// append 添加进去并展示
			$("#item_sampleName").selectpicker('refresh'); 
		}
	})
}
// 编辑检验类别
function EditType() {
	var row = $('#tb_inspecType').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个检验类别进行编辑');
		return;
	}
	$('#type_id').val(row[0].id);
	$('#type_name').val(row[0].name);
	$('#type_code').val(row[0].code);
	$('#type_remark').val(row[0].remark);
	$('#addItemTypeModal').modal();
}
// 删除检验类别
function deleteType() {
	var row = $('#tb_inspecType').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个检验类别进行删除');
		return;
	}
	Ewin.confirm({
		message : "确认要删除选择的检验类别？"
	}).on(function(e) {
		if (!e) {
			return;
		}
		var data = JSON.stringify(row);
		$.ajax({
			type : "POST",
			url : "../inspecType/deleteType.do",
			data : data,
			async : false,
			dataType : "text",
			contentType : "application/json",
			success : function(data) {
				var res = JSON.parse(data);
				if (res.code == 0) {
					toastr.success("删除成功");
					$('#tb_inspecType').bootstrapTable("refresh", {
						silent : true
					});
				} else {
					toastr.error("删除失败:" + res.msg);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
}
// 提交检验类别表单
function submitItemTypeForm() {
	$("#form_addItemType_data").bootstrapValidator('validate');// 提交验证
	if ($("#form_addItemType_data").data('bootstrapValidator').isValid()) {// 获取验证结果，如果成功，执行下面代码
		var data = JSON.stringify($("#form_addItemType_data").serializeObject());
		$.ajax({
			type : "POST",
			url : "../inspecType/saveOrUpdateType.do",
			data : data,
			async : false,
			dataType : "text",
			contentType : "application/json",
			success : function(data) {
				var res = JSON.parse(data);
				if (res.code == 0) {
					toastr.success("提交成功");
					$('#addItemTypeModal').modal('hide');
					$('#tb_inspecType').bootstrapTable("refresh", {
						silent : true
					});
					$("#form_addItemType_data").data("bootstrapValidator").resetForm();
				} else {
					toastr.error("提交失败:" + res.msg);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	}
}
//编辑检验项目
function editItem() {
	var row = $('#tb_inspecItem').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个检验类别进行编辑');
		return;
	}
	//为表单赋值 并打开窗口
	$('#item_id').val(row[0].id);
	$('#item_requestionCode').val(row[0].requestionCode);
	$('#item_requestionName').val(row[0].requestionName);
	$('#item_customCode').val(row[0].customCode);
	$('#item_chargeWard').val(row[0].chargeWard);
	$('#item_charge').val(row[0].charge);
	$('#item_packageFlag').selectpicker('val',row[0].packageFlag);//设置下拉框默认选中
	$('#item_inspecName').selectpicker('val',row[0].inspecName);//设置下拉框默认选中
	$('#item_containerName').selectpicker('val',row[0].container);//设置下拉框默认选中
	$('#item_sampleName').selectpicker('val',row[0].sampleName);//设置下拉框默认选中
	$('#item_isTakeout').selectpicker('val',row[0].isTakeout);//设置下拉框默认选中
	$('#item_discount').val(row[0].discount);
	$('#item_clinicalMeaning').val(row[0].clinicalMeaning);
	$('#item_collectRequest').val(row[0].collectRequest);
	$('#addItemModal').modal();
}
// 提交检验项目表单
function submitItemForm() {
	var item_requestionName =  $("#item_requestionName").val();
	var item_inspecName =  $("#item_inspecName").val();
	if (item_requestionName==""||item_requestionName.trim()=="") {
		alert('项目名称不能为空');
		return;
	}else if(item_inspecName==""|| item_inspecName.trim()==""){
		alert('检验类型不能为空');
		return;
	}
	var data = JSON.stringify($("#form_addItem_data").serializeObject());
	$.ajax({
		type : "POST",
		url : "../item/saveOrUpdateItem.do",
		data : data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			var res = JSON.parse(data);
			if (res.code == 0) {
				toastr.success("提交成功");
				$('#tb_inspecItem').bootstrapTable("refresh", {
					silent : true,
					requestionName : '',
					inspecName : '',
				});
			} else {
				toastr.error("提交失败:" + res.msg);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}
// 删除检验项目
function deleteItem() {
	var row = $('#tb_inspecItem').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个检验项目进行删除');
		return;
	}
	Ewin.confirm({
		message : "确认要删除选择的检验项目？"
	}).on(function(e) {
		if (!e) {
			return;
		}
		var data = JSON.stringify(row);
		$.ajax({
			type : "POST",
			url : "../item/deleteItem.do",
			data : data,
			async : false,
			dataType : "text",
			contentType : "application/json",
			success : function(data) {
				var res = JSON.parse(data);
				if (res.code == 0) {
					toastr.success("删除成功");
					$('#tb_inspecItem').bootstrapTable("refresh", {
						silent : true
					});
				} else {
					toastr.error("删除失败:" + res.msg);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
}
// 重置表单
function cleanTypeForm() {
	$('#type_id').val('');
	$('#type_name').val('');
	$('#type_code').val('');
	$('#type_remark').val('');
	$("#form_addItemType_data").data("bootstrapValidator").resetForm();
}
// 页面加载完毕后 调整本页面panel高度
function adjustHeight() {
	var h = $('.contentPanel').height();
	$(".rightItemPanel").height(h);
	$(".leftTypePanel").height(h);
}
