/**
 * 分类管理
 */
$(document).ready(function() {
	initLogicTypeTable();
	selectLogicalNameToId("logicalGroupForType");
	selectLogicalNameToId("logicalGroupAddSelect");
	var dbRowTypeId;
	//弹出添加判断的模态框时记录项目id
	var judgeItemId;
	//打开添加对应项目对应类型的判断时保存类型id
	var openModalTypeId;
	//禁用相关按钮
	$("#logicalJudgeButton").attr({"disabled":"disabled"});
	$("#logicalAddTypeButton").attr({"disabled":"disabled"});
	$("#logicalIsOpenButton").attr({"disabled":"disabled"});
});

/**
 * 初始化逻辑判断类型表格
 */
function initLogicTypeTable() {
	$('#tb_logicalTypeInfo').bootstrapTable({
		url : '../LOType/getLOTypeInfo.do',
		method : 'get', // 请求方式（*）
		striped : false, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		queryParams : function(params) {
			return {
				start : params.offset,
				limit : params.limit,
				groupId:String($("#logicalGroupForType").val())
			};
		},// 传递参数（*）
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		pagination : true,//启用分页
		sidePagination : "server",//分页方式：client客户端分页，server服务端分页（*）
		pageList : [ 5, 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 5, // 每页的记录行数（*）
		checkboxHeader : false,//不在列头显示checkbox,
		singleSelect : true,
		columns : [ {
			checkbox : true
		}, {
			title: '序号',//标题  
			formatter: function (value, row, index) {
					return index+1;
			}
		} ,{
			field : 'ID',
			title : '类型id',
			visible:false
		}, {
			field : 'TYPE_NAME',
			title : '类型'
		} , {
			field : 'DEV_NAME',
			title : '组名'
		} , {
			field : 'GROUP_ID',
			title : '组id',
			visible: false
		} ,{
			field : 'IS_OPEN',
			title : '是否开启',
			formatter : function(value, row, index) {
				if (value == '1') {
					return "<span style='color:green;'>是</span>";
				} else if (value == '0') {
					return "<span style='color:red;'>否</span>";
				} 
				return value;
			}
		} , {
			field : 'REMARK',
			title : '说明'
		}],
		onClickRow : function(row, tr) {	
			if(row.IS_OPEN=='0'){
				toastr.warning('此类型未开启！');
				$("#tb_beforeAddLogicalInfo").bootstrapTable('destroy'); 
				$("#tb_addedLogicalItemInfo").bootstrapTable('destroy'); 
				$("#tb_judgeLogicalInfo").bootstrapTable('destroy'); 
				//禁用相关按钮
				$("#logicalJudgeButton").attr({"disabled":"disabled"});
				$("#logicalAddTypeButton").attr({"disabled":"disabled"});
				$("#logicalIsOpenButton").attr({"disabled":"disabled"});
				return;
			}
			$("#tb_judgeLogicalInfo").bootstrapTable('destroy'); 
			$("#logicalJudgeButton").removeAttr("disabled");//将按钮可用
			$("#logicalAddTypeButton").removeAttr("disabled");//将按钮可用
			//双击后设置未添加项目表格的标题
			$("#logicalBeforeAddTableName").text("未添加到<"+row.TYPE_NAME+">类型的项目");
			//双击类型行获取当前行类型id
			dbRowTypeId=row.ID;
			//双击表格列初始化未添加分类项目表格通过分类ID和分组ID
			initLogicBeforeAddItemTable(row.ID,row.GROUP_ID);
			//双击表格列初始化已添加的分类项目表格
			initLogicAddedItemTable(dbRowTypeId,row.GROUP_ID);
			
		}
	});
}

/**
 * 根据双击类型行，初始化为添加类型的该分组项目
 */
function initLogicBeforeAddItemTable(typeId,groupId){
	//重复调用初始化表格时需要销毁表格才能再次初始化
	$("#tb_beforeAddLogicalInfo").bootstrapTable('destroy'); 
	$('#tb_beforeAddLogicalInfo').bootstrapTable({
		url : '../LOType/getLOItemNotAdd.do',
		method : 'get', // 请求方式（*）
		striped : false, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		queryParams : function(params) {
			return {
				start : params.offset,
				limit : params.limit,
				groupId : groupId,
				typeId : typeId
			};
		},// 传递参数（*）
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		pagination : true,//启用分页
		sidePagination : "server",//分页方式：client客户端分页，server服务端分页（*）
		pageList : [ 5, 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 5, // 每页的记录行数（*）
		checkboxHeader : false,//不在列头显示checkbox,
		columns : [ {
			checkbox : true
		}, {
			title: '序号',//标题  
			formatter: function (value, row, index) {
					return index+1;
			}
		} ,{
			field : 'TYPE_ID',
			title : '类型id',
			visible:false
		}, {
			field : 'ID',
			title : '项目Id',
			visible:false
		}, {
			field : 'ITEM_CODE',
			title : '项目编号'
		} ,{
			field : 'ITEM_NAME',
			title : '项目名'
		} , {
			field : 'ITEM_NAME_CN',
			title : '项目中文名'
		} , {
			field : 'DEV_NAME',
			title : '组名'
		}]
	});
}
/**
 * 添加项目到类型后初始化以添加类型的项目
 */
function initLogicAddedItemTable(typeId,groupId){
	//重复调用初始化表格时需要销毁表格才能再次初始化
	$("#tb_addedLogicalItemInfo").bootstrapTable('destroy'); 
	$('#tb_addedLogicalItemInfo').bootstrapTable({
		url : '../LOJudge/getLOItemAdded.do',
		method : 'get', // 请求方式（*）
		striped : false, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		queryParams : function(params) {
			return {
				start : params.offset,
				limit : params.limit,
				typeId : typeId,
				groupId : groupId
			};
		},// 传递参数（*）
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		pagination : true,//启用分页
		sidePagination : "server",//分页方式：client客户端分页，server服务端分页（*）
		pageList : [ 5, 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 5, // 每页的记录行数（*）
		checkboxHeader : false,//不在列头显示checkbox,
		singleSelect : true,
		columns : [ {
			checkbox : true
		}, {
			title: '序号',//标题  
			formatter: function (value, row, index) {
					return index+1;
			}
		} , {
			field : 'ID',
			title : '项目Id',
			visible:false
		},  {
			field : 'TYPE_ID',
			title : '类型id',
			visible:false
		},  {
			field : 'TYPE_MARK',
			title : '标记是否该项目是否添加判断',
			visible:false
		}, {
			field : 'ITEM_CODE',
			title : '项目编号'
		} ,{
			field : 'ITEM_NAME',
			title : '项目名'
		} , {
			field : 'ITEM_NAME_CN',
			title : '项目中文名'
		} , {
			field : 'TYPE_NAME',
			title : '类型'
		}],
		onClickRow : function(row, tr) {	
			$("#tb_judgeLogicalInfo").bootstrapTable('destroy'); 
			$("#logicalIsOpenButton").removeAttr("disabled");//将按钮可用
			initLogicJudgeTable(row.ID,row.TYPE_ID);
			//初始化后根据相应的类型隐藏一些不需要展示的列
			if(row.TYPE_NAME=='逻辑运算符'){
				$('#tb_judgeLogicalInfo').bootstrapTable('hideColumn', 'LOGICAL_OPERATION_TYPE');
			    $('#tb_judgeLogicalInfo').bootstrapTable('hideColumn', 'IS_OPEN_LOT');
			}
			if(row.TYPE_NAME=='逻辑运算类型'){
				$('#tb_judgeLogicalInfo').bootstrapTable('hideColumn', 'LOGICAL_OPERATOR');
			    $('#tb_judgeLogicalInfo').bootstrapTable('hideColumn', 'IS_OPNE_LO');
			}
		}
	});
	//用于获取标本名字 ， 后台传来的是数组对象  ，需转换为json对象。 liushijun
    $.ajax({
        url : '../LOType/getLOTypeSampleInfo.do',
        type : 'GET',
        async : false,
        success : function(data) {
            if(data){                 
                var obj = [];
                for(var i=0,len=data.length;i<len;i++){
                    var sample = {};
                    sample.name = data[i];
                    obj.push(sample);
                }
                var programme_sel=[];
                programme_sel.push('<option value="" selected>请选择</option>')
                for(var i=0,len=obj.length;i<len;i++){
                    programme_sel.push('<option value="'+ obj[i].name +'">'+ obj[i].name +'</option>')
                }
                $("#logicalSampleName").html(programme_sel.join(' '));
                $("#logicalLimitSampleName").html(programme_sel.join(' '));
                // 缺一不可    加载bootstrap下拉框时必须。
                $('#logicalSampleName').selectpicker('refresh');  
                $('#logicalSampleName').selectpicker('render');  
                // 缺一不可    加载bootstrap下拉框时必须。
                $('#logicalLimitSampleName').selectpicker('refresh');  
                $('#logicalLimitSampleName').selectpicker('render'); 
            }
        },
        error : function() {
            alert('查询异常');
        }
    });
}

/**
 * 初始化判断数据表格
 */
function initLogicJudgeTable(itemDevId,typeId){
	//重复调用初始化表格时需要销毁表格才能再次初始化
	$("#tb_judgeLogicalInfo").bootstrapTable('destroy'); 
	$('#tb_judgeLogicalInfo').bootstrapTable({
		url : '../LOJudge/getLOJudgeData.do',
		method : 'get', // 请求方式（*）
		striped : false, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		queryParams : function(params) {
			return {
				start : params.offset,
				limit : params.limit,
				itemId : itemDevId,
				typeId : typeId
			};
		},// 传递参数（*）
		minimumCountColumns : 2, // 最少允许的列数
		clickToSelect : true, // 是否启用点击选中行
		uniqueId : "id", // 每一行的唯一标识，一般为主键列
		cardView : false, // 是否显示详细视图
		detailView : false, // 是否显示父子表
		pagination : true,//启用分页
		sidePagination : "server",//分页方式：client客户端分页，server服务端分页（*）
		pageList : [ 5, 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
		pageNumber : 1, // 初始化加载第一页，默认第一页
		pageSize : 5, // 每页的记录行数（*）
		checkboxHeader : false,//不在列头显示checkbox,
		singleSelect    : false,// 单选checkbox
		columns : [ {
			checkbox : true
		}, {
			title: '序号',//标题  
			formatter: function (value, row, index) {
					return index+1;
			}
		} ,{
			field : 'ID',
			title : '判断规则id',
			visible:false
		}, {
			field : 'ITEM_DEV_ID',
			title : '项目Id',
			visible:false
		}, {
			field : 'ITEM_NAME',
			title : '项目名称'
		} ,{
			field : 'LOGICAL_OPERATOR',
			title : '逻辑运算符'
		} ,{
			field : 'LOGICAL_OPERATION_TYPE',
			title : '逻辑运算类型'
		} ,{
			field : 'IS_OPNE_LO',
			title : '是否启用逻辑运算符',
			formatter : function(value, row, index) {
				if (value == '1') {
					return "<span style='color:green;'>是</span>";
				} else if (value == '0') {
					return "<span style='color:red;'>否</span>";
				} 
				return value;
			}
		} ,{
			field : 'IS_OPEN_LOT',
			title : '是否启用逻辑运算类型',
			formatter : function(value, row, index) {
				if (value == '1') {
					return "<span style='color:green;'>是</span>";
				} else if (value == '0') {
					return "<span style='color:red;'>否</span>";
				}
				return value;
			}
		}]
	});
}
/**
* 用于查询和存储的select 
*/
function selectLogicalNameToId(idData){
   $.ajax({
        url : '../itemdev/getEquipmentNameAndId.do',
        type : 'GET',
        async : false,
        success : function(data) {
            if(data){                 
                var obj = [];
                for(var i=0,len=data.length;i<len;i++){
                    var equipment = {};
                    equipment.name = data[i].DEV_NAME;
                    equipment.id = data[i].ID;
                    obj.push(equipment);
                }
                var programme_sel=[];
                programme_sel.push('<option value="" selected>--请选择--</option>')
                for(var i=0,len=obj.length;i<len;i++){
                	var devId=obj[i].id;
                    programme_sel.push('<option value="'+ devId +'">'+ obj[i].name +'</option>')
                }
                var a=String("\#"+idData);
                $(a).html(programme_sel.join(' '));
             // 缺一不可    加载bootstrap下拉框时必须。
                $(a).selectpicker('refresh');  
                $(a).selectpicker('render');  
            }
        },
        error : function() {
            alert('查询异常');
        }
    });
}

//下拉框改变时刷新表格让下拉框加载到数据
$("#logicalGroupForType").change(function() {
       $("#tb_logicalTypeInfo").bootstrapTable('refresh');
});

/**
 * 清空历史判断类型模态框
 */
function cleanLogicalTypeForm() {
	$('#typeIdLO').val('');
	$('#logicalTypeTextSelect').val('');
	$("#logicalGroupAddSelect").val('');
	$("#logicalGroupAddSelect").selectpicker('refresh');
	$("#logicalTypeTextSelect").selectpicker('refresh');
	$('#remarkTypeLO').val('');
	$('#isOpenTypeLO1').prop('checked', 'checked');

}

/**
 * 清空逻辑运算符模态框
 */
function cleanLOForm() {
	$('#lOId').val('');
	$('#logicalOperator').val('');
	$('#isOpenLO0').prop('checked', 'checked');
}
/**
 * 清空逻辑判断类型模态框
 */
function cleanLOTForm() {
	$('#lOTId').val('');
	$('#logicalOperatorType').val('');
	$('#isOpenLOT0').prop('checked', 'checked');
}

/**
 * 清空编辑后逻辑运算符模态框
 */
function cleanEditLOForm() {
	$('#onlyLOId').val('');
	$('#editLogicalOperator').val('');
	$('#editIsOpenLO0').prop('checked', 'checked');
}
/**
 * 清空编辑后逻辑判断类型模态框
 */
function cleanEditLOTForm() {
	$('#onlyLOTId').val('');
	$('#editLogicalOperatorType').val('');
	$('#editIsOpenLOT0').prop('checked', 'checked');
}
/**
 * 打开类型新增窗口
 */
function openLogicalAddType() {
	cleanLogicalTypeForm();
	$('#addLogicalTypeWin').modal();
}

/**
 * 打开类型编辑窗口
 */
function openLogicalEditType() {
	var row = $('#tb_logicalTypeInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个类型');
		return;
	}
	$('#typeIdLO').val(row[0].ID);
	$('#logicalTypeTextSelect').val(row[0].TYPE_NAME);
	$("#logicalGroupAddSelect").val(row[0].GROUP_ID);
	$("#logicalGroupAddSelect").selectpicker('refresh');
	$("#logicalTypeTextSelect").selectpicker('refresh');
	$('#remarkTypeLO').val(row[0].REMARK);
	if (row[0].IS_OPEN == "1") {
		$('#isOpenTypeLO1').prop('checked', 'checked');
	}
	if (row[0].IS_OPEN == "0") {
		$('#isOpenTypeLO0').prop('checked', 'checked');
	}
	$('#addLogicalTypeWin').modal();
}

/**
 * 提交历史判断类型表单
 */
function submitLogicalTypeForm() {
	var data = JSON.stringify($("#addLogicalTypeForm").serializeObject());
	console.log(data);
	$.ajax({
		type : "POST",
		url : "../LOType/addLOTypeInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#addLogicalTypeWin').modal('hide');
				cleanLogicalTypeForm();
				refreshLogicalTypeTable();
			} else {
				toastr.error("提交失败，该分组的类型已存在！");
				$('#addLogicalTypeWin').modal('hide');
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}

/**
 * 刷新类型表格
 */
function refreshLogicalTypeTable() {
	//刷新类型表格
	$("#tb_logicalTypeInfo").bootstrapTable('refresh');
}
/**
 * 刷新规则表格
 */
function refreshLogicalJudgeTable() {
	//刷新类型表格
	$("#tb_judgeLogicalInfo").bootstrapTable('refresh');
}
/**
 * 刷新已添加类型项目表格
 */
function refreshLogicalAddedTable() {
	//刷新类型表格
	$("#tb_addedLogicalItemInfo").bootstrapTable('refresh');
}
/**
 * 刷新未添加项目表格
 */
function refreshLogicalBeforeAddTable() {
	$("#tb_beforeAddLogicalInfo").bootstrapTable('refresh');
}

/**
 * 删除类型
 */
function deleteLogicalType(){
	var typeRow = $('#tb_logicalTypeInfo').bootstrapTable('getSelections');
	if (typeRow.length <= 0) {
		toastr.warning('请选择需要删除的类型！');
		return;
	}
	//存储选中的类型Id和项目id
	var typeIdList = [];
	for (var i = 0; i < typeRow.length; i++) {
		typeIdList.push({
			id : typeRow[i].ID
		});
	}	
	Ewin.confirm({
		message : "确认要删除这些数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
	//json字符串转为对象
		typeIdList=JSON.stringify(typeIdList);
		//把对象传到后台修改状态。
		$.ajax({
			type : "POST",
			url : "../LOType/deleteLOTType.do",
			data :typeIdList,
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("删除类型成功！");
					refreshLogicalTypeTable();
					$("#tb_beforeAddLogicalInfo").bootstrapTable('destroy'); 
					$("#tb_addedLogicalItemInfo").bootstrapTable('destroy'); 
					$("#tb_judgeLogicalInfo").bootstrapTable('destroy'); 
				} else {
					toastr.error("删除失败！");
					refreshLogicalTypeTable();
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
}

/**
 *用于点击是否启用按钮修改类型的启用状态。
 */
function isOpenLogicalType(){
	var row = $('#tb_logicalTypeInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择需要改变状态的类型！');
		return;
	}
	//拿到选中的列的数据，取得需要构成后台对象的数据，拼成json字符串，
	var dataOpenState={
		"id" : row[0].ID,
		"groupId" : row[0].GROUP_ID,
		"isOpenTypeLO" : row[0].IS_OPEN,
		"isDelete" : row[0].IS_DELETE,
		"remarkTypeLO" : row[0].REMARK,
		"typeName" : row[0].TYPE_NAME
	};
	//json字符串转为对象
	dataOpenState=JSON.stringify(dataOpenState);
	//把对象传到后台修改状态。
	$.ajax({
		type : "POST",
		url : "../LOType/exchangeLOTypeIsOpen.do",
		data :dataOpenState,
		async : false,
		dataType : "text",
		contentType : "application/json;charset=utf-8",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("修改开启状态成功！");
				refreshLogicalTypeTable();
			} else {
				toastr.error("修改失败！");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}
/**
 *用于点击是否启用按钮修改判断规则的启用状态。
 */
function isOpenLogicalJudge(){
	var row = $('#tb_judgeLogicalInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择需要改变状态的规则！');
		return;
	}
	//把对象传到后台修改状态。
	$.ajax({
		type : "get",
		url : "../LOJudge/exchangeLOJudgeIsOpen.do",
		data :{
			"id" : row[0].ID
		},
		async : false,
		dataType : "text",
		contentType : "application/json;charset=utf-8",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("修改开启状态成功！");
				refreshLogicalJudgeTable();
			} else {
				toastr.error("修改开启状态失败,请先维护规则！");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}

/**
 * 批量选中项目添加到分类中
 */
function addLogicalTypeForItem(){
	var itemRow = $('#tb_beforeAddLogicalInfo').bootstrapTable('getSelections');
	if (itemRow.length <= 0) {
		toastr.warning('请选择需要添加到分类的项目！');
		return;
	}
	//存储选中的类型Id和项目id
	var itemIdList = [];
	for (var i = 0; i < itemRow.length; i++) {
		itemIdList.push({
			itemDevId : itemRow[i].ID,
			typeId : dbRowTypeId
		});
	}	
	Ewin.confirm({
		message : "确认要添加选择的数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
	//json字符串转为对象
		itemIdList=JSON.stringify(itemIdList);
		//把对象传到后台修改状态。
		$.ajax({
			type : "POST",
			url : "../LOJudge/addLOItemToType.do",
			data :itemIdList,
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("添加项目成功！");
					refreshLogicalBeforeAddTable();
					//双击后设置未添加项目表格的标题
					initLogicAddedItemTable(dbRowTypeId,itemRow[0].DEVID);
				} else {
					toastr.error("添加失败！");
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
}

/**
 * 为项目添加判断规则的模态框
 */
function AddLogicalJudgeForItem(){
	var addedItemRow = $('#tb_addedLogicalItemInfo').bootstrapTable('getSelections');
	if (addedItemRow.length <= 0) {
		toastr.warning('请选择需要添加规则的项目！');
		return;
	}
	//用于设置模态框要设置项目的id
	$('#lOId').val(addedItemRow[0].ID);
	$('#lOTId').val(addedItemRow[0].ID);
	
	judgeItemId=addedItemRow[0].ID;
		
	//用于判断调用哪个模态框
	if(addedItemRow[0].TYPE_NAME=='逻辑运算符'){
		itemSelectDataFun();
		$('#lOTypeId').val(addedItemRow[0].TYPE_ID);
		$('#lOTypeMark').val(addedItemRow[0].TYPE_MARK);
		openModalTypeId=addedItemRow[0].TYPE_ID;
		$("#isOpenLO1").prop('checked', 'checked');
		$('#addLOWin').modal();
		/*$("#yuHuoSelect").attr("disabled","disabled"); */
	}
	if(addedItemRow[0].TYPE_NAME=='逻辑运算类型'){
		$('#lOTTypeId').val(addedItemRow[0].TYPE_ID);
		$('#lOTTypeMark').val(addedItemRow[0].TYPE_MARK);
		openModalTypeId=addedItemRow[0].TYPE_ID;
		$("#isOpenTypeLO1").prop('checked', 'checked');
		$('#addLOTWin').modal();
		
	}
}

/**
 * 逻辑运算符模态框的提交
 */
function submitLOForm(){
	var modelData = JSON.stringify($("#addLOForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../LOJudge/addLOInfo.do",
		data :modelData,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#addLOWin').modal('hide');
				cleanLOForm();
				initLogicJudgeTable(judgeItemId,openModalTypeId);
				$('#tb_judgeLogicalInfo').bootstrapTable('hideColumn', 'IS_OPEN_LOT');
			    $('#tb_judgeLogicalInfo').bootstrapTable('hideColumn', 'LOGICAL_OPERATION_TYPE');
			} else {
				toastr.error("提交失败");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}

/**
 * 逻辑判断类型模态框提交
 */
function submitLOTForm(){
	var data = JSON.stringify($("#addLOTForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../LOJudge/addLOInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#addLOTWin').modal('hide');
				cleanLOTForm();
				initLogicJudgeTable(judgeItemId,openModalTypeId);
				//用于隐藏某些列
				$('#tb_judgeLogicalInfo').bootstrapTable('hideColumn', 'LOGICAL_OPERATOR');
			    $('#tb_judgeLogicalInfo').bootstrapTable('hideColumn', 'IS_OPNE_LO');
			} else {
				toastr.error("提交失败");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}

/**
 * 初始化select
*/
$("#yuHuoSelect").selectpicker({});
$("#operatorSelect").selectpicker({});
$("#itemLogicalSelect").selectpicker({});

/**
 * 加载项目名称下拉框
 */
function itemSelectDataFun(){
    $.ajax({
        url : '../itemdev/getItemName.do',
        type : 'GET',
        async : false,
        success : function(data) {
            if(data){                 
                var obj = [];
                for(var i=0,len=data.length;i<len;i++){
                    var equipment = {};
                    equipment.name = data[i];
                    obj.push(equipment);
                }
                var programme_sel=[];
                programme_sel.push('<option value="" selected>请选择</option>')
                for(var i=0,len=obj.length;i<len;i++){
                    programme_sel.push('<option value="'+ obj[i].name +'">'+ obj[i].name +'</option>')
                }
                $("#itemSelectData").html(programme_sel.join(' '));
             // 缺一不可    加载bootstrap下拉框时必须。
                $('#itemSelectData').selectpicker('refresh');  
                $('#itemSelectData').selectpicker('render');  
            }
        },
        error : function() {
            alert('查询异常');
        }
    });
}

/**
 * 加载项目名称下拉框
 */
function itemSelectDataForJudgeFun(){
    $.ajax({
        url : '../itemdev/getItemName.do',
        type : 'GET',
        async : false,
        success : function(data) {
            if(data){                 
                var obj = [];
                for(var i=0,len=data.length;i<len;i++){
                    var equipment = {};
                    equipment.name = data[i];
                    obj.push(equipment);
                }
                var programme_sel=[];
                programme_sel.push('<option value="" selected>请选择</option>')
                for(var i=0,len=obj.length;i<len;i++){
                    programme_sel.push('<option value="'+ obj[i].name +'">'+ obj[i].name +'</option>')
                }
                $("#itemSelectDataForJudge").html(programme_sel.join(' '));
             // 缺一不可    加载bootstrap下拉框时必须。
                $('#itemSelectDataForJudge').selectpicker('refresh');  
                $('#itemSelectDataForJudge').selectpicker('render');  
            }
        },
        error : function() {
            alert('查询异常');
        }
    });
}
/**
 * 删除当前类型所添加的项目
 */
$('#logicalJudgeDeleteButton').on("click", function() {// 删除按钮
	var a = $("#tb_addedLogicalItemInfo").bootstrapTable('getSelections');
	if (a.length <= 0) {
		toastr.warning('请选择有效数据');
		return;
	}
	deleteItem={
			typeId : a[0].TYPE_ID,
			itemId : a[0].ID
		}
	Ewin.confirm({
		message : "确认要删除选择的数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
		$.ajax({
			type : "get",
			url : "../LOJudge/deleteLOAddedItem.do",
			async : true,
			data : deleteItem,
			dataType : "text",// 预期服务器返回的数据类型
			contentType : 'application/json;charset=utf-8',
			success : function(data, status) {
				if (status == "success") {
					$("#tb_beforeAddLogicalInfo").bootstrapTable('refresh');
					$("#tb_addedLogicalItemInfo").bootstrapTable('refresh');
					$("#tb_judgeLogicalInfo").bootstrapTable('destroy'); 
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
});

/**
 * 打开修改判断规则的模态框
 */
$('#logicalEditButton').on("click", function() {
	var editItemRow = $('#tb_judgeLogicalInfo').bootstrapTable('getSelections');
	if (editItemRow.length <= 0) {
		toastr.warning('请选择需要修改的判断规则！');
		return;
	}
	if(editItemRow[0].IS_OPNE_LO==null&&editItemRow[0].IS_OPEN_LOT==null){
		toastr.warning('请先维护规则再进行修改！');
		return;
	}
	//用于判断调用哪个模态框
	if(editItemRow[0].IS_OPNE_LO!=null){
		itemSelectDataForJudgeFun();
		$('#editLogicalOperator').val(editItemRow[0].LOGICAL_OPERATOR);
		$('#onlyLOId').val(editItemRow[0].ID);
		if (editItemRow[0].IS_OPNE_LO == "1") {
			$('#editIsOpenLO1').prop('checked', 'checked');
		}
		if (editItemRow[0].IS_OPNE_LO == "0") {
			$('#editIsOpenLO0').prop('checked', 'checked');
		}
		$('#editLOWin').modal();
	}
	if(editItemRow[0].IS_OPEN_LOT!=null){
		$('#editLogicalOperatorType').val(editItemRow[0].LOGICAL_OPERATION_TYPE);
		$('#onlyLOTId').val(editItemRow[0].ID);
		if (editItemRow[0].IS_OPEN_LOT == "1") {
			$('#editIsOpenLOT1').prop('checked', 'checked');
		}
		if (editItemRow[0].IS_OPEN_LOT == "0") {
			$('#editIsOpenLOT0').prop('checked', 'checked');
		}
		$('#editLOTWin').modal();
	}
});

/**
 * 百分比模态框修改后提交
 */
function submitEditLOForm(){
	var data = JSON.stringify($("#editLOForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../LOJudge/editLOInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#editLOWin').modal('hide');
				cleanEditLOForm();
				$("#tb_judgeLogicalInfo").bootstrapTable('refresh');
			} else {
				toastr.error("提交失败");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}
/**
 * 绝对值模态框修改后的提交
 */
function submitEditLOTForm(){
	var modelData = JSON.stringify($("#editLOTForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../LOJudge/editLOInfo.do",
		data :modelData,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#editLOTWin').modal('hide');
				cleanEditLOTForm();
				$("#tb_judgeLogicalInfo").bootstrapTable('refresh');
			} else {
				toastr.error("提交失败" );
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}

/**
 * 删除规则数据
 */
$('#histDeleteJudgeButton').on("click", function() {
	var judgeRow = $('#tb_judgeHistInfo').bootstrapTable('getSelections');
	console.log(judgeRow);
	if (judgeRow.length <= 0) {
		toastr.warning('请选择需要删除的规则！');
		return;
	}
	//存储选中的类型Id和项目id
	var judgeIdList = [];
	for (var i = 0; i < judgeRow.length; i++) {
		judgeIdList.push({
			id : judgeRow[i].ID
		});
	}	
	Ewin.confirm({
		message : "确认要删除这些数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
	//json字符串转为对象
		judgeIdList=JSON.stringify(judgeIdList);
		//把对象传到后台修改状态。
		$.ajax({
			type : "POST",
			url : "../historyDataJudge/deleteHistJudge.do",
			data :judgeIdList,
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("删除规则成功！");
					refreshHistJudgeTable();
					$("#tb_beforeAddHistInfo").bootstrapTable('refresh');
					$("#tb_addedHistItemInfo").bootstrapTable('refresh');
				} else {
					toastr.error("删除失败！");
					refreshHistJudgeTable();
					$("#tb_beforeAddHistInfo").bootstrapTable('refresh');
					$("#tb_addedHistItemInfo").bootstrapTable('refresh');
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
});

/**
 * 删除规则数据
 */
$('#logicalDeleteButton').on("click", function() {
	var judgeRow = $('#tb_judgeLogicalInfo').bootstrapTable('getSelections');
	if (judgeRow.length <= 0) {
		toastr.warning('请选择需要删除的规则！');
		return;
	}
	//存储选中的类型Id和项目id
	var judgeIdList = [];
	for (var i = 0; i < judgeRow.length; i++) {
		judgeIdList.push({
			id : judgeRow[i].ID
		});
	}	
	Ewin.confirm({
		message : "确认要删除这些数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
	//json字符串转为对象
		judgeIdList=JSON.stringify(judgeIdList);
		//把对象传到后台修改状态。
		$.ajax({
			type : "POST",
			url : "../LOJudge/deleteLOJudge.do",
			data :judgeIdList,
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("删除规则成功！");
					refreshLogicalJudgeTable();
					$("#tb_beforeAddLogicalInfo").bootstrapTable('refresh');
					$("#tb_addedLogicalItemInfo").bootstrapTable('refresh');
				} else {
					toastr.error("删除失败！");
					refreshLogicalJudgeTable();
					$("#tb_beforeAddLogicalInfo").bootstrapTable('refresh');
					$("#tb_addedLogicalItemInfo").bootstrapTable('refresh');
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
});