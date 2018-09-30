/**
 * 角色管理
 */
$(document).ready(function() {
	initRoleTable();
	adjustHeight();
});
/**
 * 初始化角色表格
 */
function initRoleTable() {
	$('#tb_roleInfo').bootstrapTable({
		url : '../role/getRolesByPage.do',
		method : 'get', // 请求方式（*）
		striped : false, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		queryParams : function(params) {
			return {
				start : params.offset,
				limit : params.limit,
			};
		},// 传递参数（*）
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		pagination : true,//启用分页
		sidePagination : "server",//分页方式：client客户端分页，server服务端分页（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 10, // 每页的记录行数（*）
		checkboxHeader : false,//不在列头显示checkbox,
		singleSelect : true,
		columns : [ {
			checkbox : true
		}, {
			field : 'roleName',
			title : '角色名称'
		}, {
			field : 'roleDescription',
			title : '角色描述'
		} ],
		onClickRow : function(row, tr) {
			initRoleTrees(row.id);
		}
	});
}
/**
 * 打开角新增窗口
 */
function openAddRoleWin() {
	cleanForm();
	$('#addRoleWin').modal();
}
/**
 * 打开角色编辑窗口
 */
function openEditRoleWin() {
	var row = $('#tb_roleInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个角色');
		return;
	}
	$('#id').val(row[0].id);
	$('#roleName').val(row[0].roleName);
	$('#roleDescription').val(row[0].roleDescription);
	$('#addRoleWin').modal();
}
/**
 * 删除角色
 */
function deleteRole() {
	var row = $('#tb_roleInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个角色');
		return;
	}
	Ewin.confirm({message : "确认要删除选择的角色？"}).on(function(e) {
		if (!e) {
			return;
		}
		var data = JSON.stringify(row);
		$.ajax({
			type : "POST",
			url : "../role/delRoles.do",
			data : data,
			async : false,
			dataType : "text",
			contentType : "application/json",
			success : function(data) {
				var res = JSON.parse(data);
				if (res.code == 0) {
					toastr.success("删除成功");
					refreshRoleTable();
				} else {
					toastr.error("删除失败" + res.message);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
}
/**
 * 提交表单
 */
function submitRoleForm() {
	var data = JSON.stringify($("#addRoleForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../role/saveRole.do",
		data : data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			var res = JSON.parse(data);
			if (res.code == 0) {
				toastr.success("提交成功");
				$('#addRoleWin').modal('hide');
				refreshRoleTable();
			} else {
				toastr.error("提交失败" + res.message);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}
function cleanForm() {
	$('#id').val('');
	$('#roleName').val('');
	$('#roleDescription').val('');
}
function refreshRoleTable() {
	$('#tb_roleInfo').bootstrapTable("refresh", {
		silent : true
	});
}
/**
 * 初始化树
 * @param roldId
 */
function initRoleTrees(roldId) {
//	查询当前角色已有的角色列表
	$.ajax({
		type : "Post",
		url : "../role/getRoleRights.do",
		data: {rId:roldId},
		dataType : "json",
		success : function(result) {
			handleMenuData(result);// 删除子节点
			/*changeMenuColor(result);// 改变节点颜色*/
			$('#haveRightTree').treeview({
				data : result, // 数据源
				highlightSelected : true, // 是否高亮选中
				expandIcon : 'glyphicon glyphicon-chevron-down',// 可展开的节点图标
				collapseIcon : 'glyphicon glyphicon-chevron-up',// 可收起的节点图标
				nodeIcon : '', // 节点上的图标
				emptyIcon : '', // 没有子节点的节点图标
				levels : 3,
				multiSelect : false, // 多选
				showBorder : false,
				showCheckbox : true,
				showIcon : false,
				onNodeSelected : function(event, data) {//节点选择时触发
					$('#haveRightTree').treeview('checkNode', [ data.nodeId]);
				},
				onNodeUnselected : function(event,data){//节点取消选择时触发
					$('#haveRightTree').treeview('uncheckNode', [ data.nodeId]);
				},
				onNodeChecked : function(event,data){//节点复选框打勾时触发
					if (typeof(data.nodes)!='undefined') {
						checkSonNodes(data.nodes,'haveRightTree');
					}
				},
				onNodeUnchecked(event,data){//节点复选框 取消打勾时触发
					if (typeof(data.nodes)!='undefined') {
						uncheckSonNodes(data.nodes,'haveRightTree');
					}
				}
			});
		},
		error : function() {
			alert('权限菜单加载失败');
		}
	});
	//	查询当前角色没有的权限列表
	$.ajax({
		type : "Post",
		url : "../right/getRight.do",
		data:{rId:roldId},
		dataType : "json",
		success : function(result) {
			handleMenuData(result);// 删除子节点
			/*changeMenuColor(result);*/// 改变节点颜色
			$('#notHaveRightTree').treeview({
				data : result, // 数据源
				highlightSelected : true, // 是否高亮选中
				expandIcon : 'glyphicon glyphicon-chevron-down',// 可展开的节点图标
				collapseIcon : 'glyphicon glyphicon-chevron-up',// 可收起的节点图标
				nodeIcon : '', // 节点上的图标
				emptyIcon : '', // 没有子节点的节点图标
				levels : 3,
				multiSelect : false, // 多选
				showBorder : false,
				showCheckbox : true,
				showIcon : false,
				onNodeSelected : function(event, data) {//节点选择时触发
					$('#notHaveRightTree').treeview('checkNode', [ data.nodeId]);
				},
				onNodeUnselected : function(event,data){//节点取消选择时触发
					$('#notHaveRightTree').treeview('uncheckNode', [ data.nodeId]);
				},
				onNodeChecked : function(event,data){//节点复选框打勾时触发
					if (typeof(data.nodes)!='undefined') {
						checkSonNodes(data.nodes,'notHaveRightTree');
					}
				},
				onNodeUnchecked(event,data){//节点复选框 取消打勾时触发
					if (typeof(data.nodes)!='undefined') {
						uncheckSonNodes(data.nodes,'notHaveRightTree');
					}
				}
			});
		},
		error : function() {
			alert('权限菜单加载失败');
		}
	});
}
/**
 * 删除角色的权限
 */
function deleteRoleRight(){
	var row = $('#tb_roleInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个角色');
		return;
	}
	var selectNode = $('#haveRightTree').treeview('getSelected');
	if (selectNode.length == 0) {
		toastr.warning('请选择要删除的权限节点');
		return;
	}
	Ewin.confirm({message : "确认要删除选择权限？"}).on(function(e) {
		if (!e) {return;}
		var rightId = createSonRightId(selectNode);//拼成ID
		//去掉第一位的逗号
		if (rightId.substr(0,1)==',') rightId=rightId.substr(1);
		$.ajax({
			type : "Post",
			url : "../role/deleteRoleRights.do",
			data : {roleId:row[0].id,rightId:rightId},
			dataType : "text",
			success : function(data) {
				var res = JSON.parse(data);
				if (res.code == 0) {
					toastr.success("删除成功");
					initRoleTrees(row[0].id);
				} else {
					toastr.error("删除失败" + res.message);
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
}
/**
 * 根据选择的节点 遍历子节点 拼成id字符串  用逗号隔开
 */
function createSonRightId(selectNode){
	var ids = '';
	for (var i = 0; i < selectNode.length; i++) {
		ids+=","+selectNode[i].id;
		if (typeof(selectNode[i].nodes)!="undefined") {
			ids+=createSonRightId(selectNode[i].nodes)
		}
	}
	return ids;
}
/**
 * 遍历父节点，若不存在已分配权限里  则拼接成字符串
 */
function createFatherId(selectNode){
	var ids = '';
	var parentNode = $('#notHaveRightTree').treeview('getParent',selectNode);
	var pNodeId = parentNode.id;
	if (typeof(pNodeId)!='undefined') {
		ids+=","+pNodeId;
		if (typeof(parentNode.nodeId)!='undefined') {
			ids += createFatherId(parentNode.nodeId);
		}
	}
	return ids;
}
/**
 * 新增角色权限
 */
function addRoleRight(){
	var row = $('#tb_roleInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个角色');
		return;
	}
	var selectNode = $('#notHaveRightTree').treeview('getSelected');
	console.debug(selectNode);
	if (selectNode.length == 0) {
		toastr.warning('请选择要添加的权限节点');
		return;
	}
	var sonids = createSonRightId(selectNode);
	var fatherids = createFatherId(selectNode[0].nodeId);
	var ids = fatherids+sonids;
	//去掉第一位的逗号
	if (ids.substr(0,1)==',') ids=ids.substr(1);
	$.ajax({
		type : "Post",
		url : "../role/saveRoleRights.do",
		data : {roleId:row[0].id,rts:ids},
		dataType : "text",
		success : function(data) {
			var res = JSON.parse(data);
			if (res.code == 0) {
				toastr.success("添加成功");
				initRoleTrees(row[0].id);
			} else {
				toastr.error("添加失败" + res.message);
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}
function refreshRoleRightTree(){
	var row = $('#tb_roleInfo').bootstrapTable('getSelections');
	initRoleTrees(row[0].id);
}
function adjustHeight(){
	var h = $('.contentPanel').height();
	$(".rightRolePanel").height(h);
	$(".leftRolePanel").height(h);
	$(".middleRolePanel").height(h);
}
//选中节点时，如果还有子节点 也一并选中
function checkSonNodes(nodes,treeName){
	for (var i = 0; i < nodes.length; i++) {
		$('#'+treeName).treeview('checkNode', [nodes[i].nodeId,{ silent: true }]);
		if (typeof(nodes[i].nodes)!='undefined') {
			checkSonNodes(nodes[i].nodes);
		}
	}
}
//取消选中节点时 如果有子节点  也一并取消选中
function uncheckSonNodes(nodes,treeName){
	for (var i = 0; i < nodes.length; i++) {
		$('#'+treeName).treeview('uncheckNode', [nodes[i].nodeId,{ silent: true }]);
		if (typeof(nodes[i].nodes)!='undefined') {
			uncheckSonNodes(nodes[i].nodes);
		}
	}
}