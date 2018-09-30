/**
 * 容器信息维护
 */
$(document).ready(function() {
	initContainerTable();
	$("#form_addcontainer_data").bootstrapValidator({
		live : 'enabled',// 验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
		excluded : [ ':disabled', ':hidden', ':not(:visible)' ],// 排除无需验证的控件，比如被禁用的或者被隐藏的
		submitButtons : '#button-submit-container',//
		// 指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
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
						message : '容器名称不能为空'
					}
				}
			},
			color:{
				validators : {
					notEmpty : {// 检测非空,radio也可用
						message : '容器颜色不能为空'
					}
				}
			}
		}
	});
});
function initContainerTable() {
	$('#tb_container').bootstrapTable({
		url : '../container/getContainerByPage.do',
		toolbar: '#toolbar_container',
		method : 'get', // 请求方式（*）
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		queryParams : function(params) {
			return {
				start : params.offset,
				limit : params.limit,
				name: params.search,
			};
		},// 传递参数（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pagination : true, // 是否显示分页（*）
		sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "ID", // 每一行的唯一标识，一般为主键列
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
		singleSelect:true,
		columns : [{
			checkbox : true
		}, {
			field : 'code',
			title : '容器编码'
		}, {
			field : 'name',
			title : '名称'
		}, {
			field : 'color',
			title : '颜色'
		} , {
			field : 'remark',
			title : '备注'
		}]
	});
}
//提交容器表单
function submitContainerForm() {
	$("#form_addcontainer_data").bootstrapValidator("validate");
	if ($("#form_addcontainer_data").data("bootstrapValidator").isValid()) {
		var data = JSON.stringify($("#form_addcontainer_data").serializeObject());
		$.ajax({
			type : "POST",
			url : "../container/saveOrUpdateContainer.do",
			data : data,
			async : false,
			dataType : "text",
			contentType : "application/json",
			success : function(data) {
				var res = JSON.parse(data);
				if (res.code == 0) {
					toastr.success("提交成功");
					$('#addContainerModal').modal('hide');
					$("#form_addcontainer_data").data("bootstrapValidator").resetForm();
					$('#tb_container').bootstrapTable("refresh", {
						silent : true
					});
				} else {
					toastr.error("提交失败:" + res.msg);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	}else{
		return;
	}
}
// 编辑容器信息
function editContainerForm(){
	var row = $('#tb_container').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个容器进行编辑');
		return;
	}
	$('#id').val(row[0].id);
	$('#name').val(row[0].name);
	$('#color').val(row[0].color);
	$('#code').val(row[0].code);
	$('#remark').val(row[0].remark);
	$('#addContainerModal').modal();
}
//删除容器
function deleteContainer(){
	var row = $('#tb_container').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个容器进行删除');
		return;
	}
	Ewin.confirm({message : "确认要删除选择的容器？"}).on(function(e) {
		if (!e) {
			return;
		}
		var data = JSON.stringify(row);
		$.ajax({
			type : "POST",
			url : "../container/delCons.do",
			data : data,
			async : false,
			dataType : "text",
			contentType : "application/json",
			success : function(data) {
				var res = JSON.parse(data);
				if (res.code == 0) {
					toastr.success("删除成功");
					$('#tb_container').bootstrapTable("refresh", {
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
function cleanContainerForm(){
	$('#container_id').val('');
	$('#container_name').val('');
	$('#container_color').val('');
	$('#container_code').val('');
	$('#container_remark').val('');
	$("#form_addcontainer_data").data("bootstrapValidator").resetForm();
}