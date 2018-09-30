/**
 * 权限管理
 */
$(document).ready(function() {
	initRightTable();
	initRightTree();
	adjustHeight();
});
function initRightTable() {
	$('#tb_rightInfo').bootstrapTable({
		url : '../right/getRightByCode.do',
		method : 'get', // 请求方式（*）
		striped : true, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		sortOrder : "asc", // 排序方式
		queryParams : '',// 传递参数（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		strictSearch : true,
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		height : 200, // 行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
		uniqueId : "ID", // 每一行的唯一标识，一般为主键列
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		columns : [ {
			field : 'rightName',
			title : '菜单名称'
		}, {
			field : 'url',
			title : '菜单地址'
		}, {
			field : 'reporturl',
			title : '报表地址'
		} ]
	});
}
function initRightTree() {
	$.ajax({
		type : "Post",
		url : "../right/getRight.do",
		dataType : "json",
		success : function(result) {
			handleMenuData(result);// 删除子节点
			//changeMenuColor(result);// 改变节点颜色
			$('#rightTree').treeview({
				data : result, // 数据源
				highlightSelected : true, // 是否高亮选中
				expandIcon : 'glyphicon glyphicon-menu-down',// 可展开的节点图标
				collapseIcon : 'glyphicon glyphicon-menu-up',// 可收起的节点图标
				/*showCheckbox : true,*/
				nodeIcon : '', // 节点上的图标
				emptyIcon : '', // 没有子节点的节点图标
				levels : 3,
				showBorder : true,
				onNodeSelected : function(event, data) {//节点选择时触发
					$('#rightTree').treeview('checkNode', [ data.nodeId]);
					queryInfo(data.rightCode);
				},
				onNodeUnselected : function(event,data){//节点取消选择时触发
					$('#rightTree').treeview('uncheckNode', [ data.nodeId]);
				},
				//节点复选框打勾时触发
				onNodeChecked : function(event,data){
					if (typeof(data.nodes)!=="undefined") {
						checkSonNodes(data.nodes);
					}
				},
				//节点复选框 取消打勾时触发
				onNodeUnchecked(event,data){
					if (typeof(data.nodes)!=='undefined') {
						uncheckSonNodes(data.nodes);
					}
				}
			});
		},
		error : function() {
			alert('权限菜单加载失败');
		}
	});
}
function queryInfo(rightCode) {
	$('#tb_rightInfo').bootstrapTable("refresh", {
		query : {
			"rightCode" : rightCode
		},
		silent : true
	});
}
// 新增
function openAddWin() {
	cleanRightForm();
	var selected = $('#rightTree').treeview('getSelected');
	if (selected.length == 0) {
		$('#parentCode').val("0");
		$('#parentName').val("根节点");
	} else {
		$('#parentCode').val(selected[0].rightCode);
		$('#parentName').val(selected[0].text);
	}
	$('#addMenuWin').modal();
}
// 修改
function openEditWin() {
	var selectNode = $('#rightTree').treeview('getSelected');
	if (selectNode.length == 0) {
		toastr.warning('请选择一个节点');
		return;
	}
	cleanRightForm();
	console.log(selectNode[0]);
	$('#rightid').val(selectNode[0].id);
	$('#rightName').val(selectNode[0].text);
	$('#pinyin').val(selectNode[0].pinyin);
	$('#right_url').val(selectNode[0].href);
	$('#right_reporturl').val(selectNode[0].reporturl);
	$('#rightCode').val(selectNode[0].rightCode);
	$('#parentCode').val(selectNode[0].parentCode);
	$('#rightIcon').val(selectNode[0].icon);
	$('#addMenuWin').modal();
}
// 删除
function deleteMenu() {
	var selectNode = $('#rightTree').treeview('getSelected');
	if (selectNode.length == 0) {
		toastr.warning('请选择一个节点');
		return;
	}
	Ewin.confirm({message : "确认要删除选择的节点以及子节点吗？"}).on(function(e) {
		if (!e) {return;}
		var id = selectNode[0].rightCode;
		var data = JSON.stringify({rightId:selectNode[0].rightCode});
		$.ajax({
			type : "POST",
			url : "../right/deleteRight.do",
			data : {rightId :id},
			async : false,
			dataType : "text",
			success : function(data) {
				var res = JSON.parse(data);
				if (res.code==0) {
					toastr.success('删除成功');
					initRightTree();
				} else {
					toastr.error("删除失败" + res.msg);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常：" + errorThrown);
			}
		});
	});
}
// 提交表单
function submitForm() {
	var data = JSON.stringify($("#addMenuForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../right/addRight.do",
		data : data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			var res = JSON.parse(data);	
			if (res.code==0) {
				toastr.success("提交成功");
				$('#addMenuWin').modal('hide');
				/*initRightTree();*/
				cleanRightForm();
			} else {
				toastr.error("提交失败" + res.message);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}
// 为拼音字段赋值
function getPinyin(text) {
	var at = pinyin.getFullChars(text);
	$('#pinyin').val(at);
}
function cleanRightForm() {
	$('#id').val('');
	$('#rightName').val('');
	$('#pinyin').val('');
	$('#right_url').val('');
	$('#right_reporturl').val('');
	$('#rightCode').val('');
	$('#rightIcon').val('');
}
//页面加载完毕后  调整本页面panel高度
function adjustHeight(){
	var h = $('.contentPanel').height();
	$(".rightMenuPanel").height(h);
	$(".leftMenuPanel").height(h);
}
//选中节点时，如果还有子节点 也一并选中
function checkSonNodes(nodes){
	for (var i = 0; i < nodes.length; i++) {
		$('#rightTree').treeview('checkNode', [nodes[i].nodeId,{ silent: true }]);
		if (typeof(nodes[i].nodes)!='undefined') {
			checkSonNodes(nodes[i].nodes);
		}
	}
}
//取消选中节点时 如果有子节点  也一并取消选中
function uncheckSonNodes(nodes){
	for (var i = 0; i < nodes.length; i++) {
		$('#rightTree').treeview('uncheckNode', [nodes[i].nodeId,{ silent: true }]);
		if (typeof(nodes[i].nodes)!='undefined') {
			uncheckSonNodes(nodes[i].nodes);
		}
	}
}