/**
 * 分类管理
 */
$(document).ready(function() {
	initHistTypeTable();
	selectHistNameToId("histGroupForType");
	selectHistNameToId("histGroupAddSelect");
	var dbRowTypeId;
	//弹出添加判断的模态框时记录项目id
	var judgeItemId;
	//打开添加对应项目对应类型的判断时保存类型id
	var openModalTypeId;
	//禁用相关按钮
	$("#histJudgeButton").attr({"disabled":"disabled"});
	$("#histAddTypeButton").attr({"disabled":"disabled"});
	$("#histIsOpenButton").attr({"disabled":"disabled"});
});

/**
 * 初始化历史判断类型表格
 */
function initHistTypeTable() {
	$('#tb_histTypeInfo').bootstrapTable({
		url : '../historyDataType/getHistTypeInfo.do',
		method : 'get', // 请求方式（*）
		striped : false, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		queryParams : function(params) {
			return {
				start : params.offset,
				limit : params.limit,
				groupId:String($("#histGroupForType").val())
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
				$("#tb_beforeAddHistInfo").bootstrapTable('destroy'); 
				$("#tb_addedHistItemInfo").bootstrapTable('destroy'); 
				$("#tb_judgeHistInfo").bootstrapTable('destroy'); 
				//禁用相关按钮
				$("#histJudgeButton").attr({"disabled":"disabled"});
				$("#histAddTypeButton").attr({"disabled":"disabled"});
				$("#histIsOpenButton").attr({"disabled":"disabled"});
				return;
			}
			$("#tb_judgeHistInfo").bootstrapTable('destroy'); 
			$("#histJudgeButton").removeAttr("disabled");//将按钮可用
			$("#histAddTypeButton").removeAttr("disabled");//将按钮可用
			//双击后设置未添加项目表格的标题
			$("#histBeforeAddTableName").text("未添加到<"+row.TYPE_NAME+">类型的项目");
			//双击类型行获取当前行类型id
			dbRowTypeId=row.ID;
			//双击表格列初始化未添加分类项目表格通过分类ID和分组ID
			initHistBeforeAddItemTable(row.ID,row.GROUP_ID);
			//双击表格列初始化已添加的分类项目表格
			initHistAddedItemTable(dbRowTypeId,row.GROUP_ID);
			
		}
	});
}

/**
 * 根据双击类型行，初始化为添加类型的该分组项目
 */
function initHistBeforeAddItemTable(typeId,groupId){
	//重复调用初始化表格时需要销毁表格才能再次初始化
	$("#tb_beforeAddHistInfo").bootstrapTable('destroy'); 
	$('#tb_beforeAddHistInfo').bootstrapTable({
		url : '../historyDataType/getHistItemNotAdd.do',
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
function initHistAddedItemTable(typeId,groupId){
	//重复调用初始化表格时需要销毁表格才能再次初始化
	$("#tb_addedHistItemInfo").bootstrapTable('destroy'); 
	$('#tb_addedHistItemInfo').bootstrapTable({
		url : '../historyDataJudge/getHistItemAdded.do',
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
			$("#tb_judgeHistInfo").bootstrapTable('destroy'); 
			$("#histIsOpenButton").removeAttr("disabled");//将按钮可用
			initHistJudgeTable(row.ID,row.TYPE_ID);
			//初始化后根据相应的类型隐藏一些不需要展示的列
			if(row.TYPE_NAME=='绝对值'){
				$('#tb_judgeHistInfo').bootstrapTable('hideColumn', 'PER');
			    $('#tb_judgeHistInfo').bootstrapTable('hideColumn', 'PERCENT_IS_OPNE');
			}
			if(row.TYPE_NAME=='百分比'){
				$('#tb_judgeHistInfo').bootstrapTable('hideColumn', 'ABS');
			    $('#tb_judgeHistInfo').bootstrapTable('hideColumn', 'ABSOLUTE_IS_OPEN');
			}
		}
	});
	//用于获取标本名字 ， 后台传来的是数组对象  ，需转换为json对象。 liushijun
    $.ajax({
        url : '../historyDataType/getHistSampleInfo.do',
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
                $("#histSampleName").html(programme_sel.join(' '));
                $("#histLimitSampleName").html(programme_sel.join(' '));
                // 缺一不可    加载bootstrap下拉框时必须。
                $('#histSampleName').selectpicker('refresh');  
                $('#histSampleName').selectpicker('render');  
                // 缺一不可    加载bootstrap下拉框时必须。
                $('#histLimitSampleName').selectpicker('refresh');  
                $('#histLimitSampleName').selectpicker('render'); 
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
function initHistJudgeTable(itemDevId,typeId){
	//重复调用初始化表格时需要销毁表格才能再次初始化
	$("#tb_judgeHistInfo").bootstrapTable('destroy'); 
	$('#tb_judgeHistInfo').bootstrapTable({
		url : '../historyDataJudge/getHistJudgeData.do',
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
		singleSelect   : false,// 单选checkbox
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
			field : 'PER',
			title : '百分比',
			formatter : function(value, row, index) {
				if(value==null){
					return value;
				}else{
					return value+"%";
				}
			}
		} ,{
			field : 'ABS',
			title : '绝对值'
		} ,{
			field : 'HIS_DAY',
			title : '历史天数',
			formatter : function(value, row, index) {
				if(value==null){
					return value;
				}else{
					return value+"天";
				}
			}
		} ,{
			field : 'PERCENT_IS_OPNE',
			title : '百分比是否开启',
			formatter : function(value, row, index) {
				if (value == '1') {
					return "<span style='color:green;'>是</span>";
				} else if (value == '0') {
					return "<span style='color:red;'>否</span>";
				} 
				return value;
			}
		} ,{
			field : 'ABSOLUTE_IS_OPEN',
			title : '绝对值是否开启',
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
function selectHistNameToId(idData){
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
$("#histGroupForType").change(function() {
       $("#tb_histTypeInfo").bootstrapTable('refresh');
});

/**
 * 清空历史判断类型模态框
 */
function cleanHistTypeForm() {
	$('#typeHistId').val('');
	$('#histTypeTextSelect').val('');
	$("#histGroupAddSelect").val('');
	$("#histGroupAddSelect").selectpicker('refresh');
	$("#histTypeTextSelect").selectpicker('refresh');
	$('#remarkTypeHist').val('');
	$('#isOpenTypeHist1').prop('checked', 'checked');

}

/**
 * 清空绝对值模态框
 */
function cleanAbsForm() {
	$('#absId').val('');
	$('#abs').val('');
	$('#absHistoryDay').val('');
	$('#absoluteIsOpen0').prop('checked', 'checked');
}
/**
 * 清空百分比模态框
 */
function cleanPerForm() {
	$('#perId').val('');
	$('#per').val('');
	$('#perHistoryDay').val('');
	$('#percentIsOpen0').prop('checked', 'checked');
}
/**
 * 清空编辑后百分比模态框
 */
function cleanEditPerForm() {
	$('#onlyPerId').val('');
	$('#editPer').val('');
	$('#editPerHistoryDay').val('');
	$('#editPercentIsOpen0').prop('checked', 'checked');
}
/**
 * 清空编辑后绝对值模态框
 */
function cleanEditAbsForm() {
	$('#onlyAbsId').val('');
	$('#editAbs').val('');
	$('#editAbsHistoryDay').val('');
	$('#absoluteIsOpen0').prop('checked', 'checked');
}
/**
 * 打开类型新增窗口
 */
function openHistAddType() {
	cleanHistTypeForm();
	$('#addHistTypeWin').modal();
}

/**
 * 打开类型编辑窗口
 */
function openHistEditType() {
	var row = $('#tb_histTypeInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个类型');
		return;
	}
	$('#typeHistId').val(row[0].ID);
	$('#histTypeTextSelect').val(row[0].TYPE_NAME);
	$("#histGroupAddSelect").val(row[0].GROUP_ID);
	$("#histGroupAddSelect").selectpicker('refresh');
	$("#histTypeTextSelect").selectpicker('refresh');
	$('#remarkTypeHist').val(row[0].REMARK);
	if (row[0].IS_OPEN == "1") {
		$('#isOpenTypeHist1').prop('checked', 'checked');
	}
	if (row[0].IS_OPEN == "0") {
		$('#isOpenTypeHist0').prop('checked', 'checked');
	}
	$('#addHistTypeWin').modal();
}

/**
 * 提交历史判断类型表单
 */
function submitHistTypeForm() {
	var data = JSON.stringify($("#addHistTypeForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../historyDataType/addHistTypeInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#addHistTypeWin').modal('hide');
				cleanHistTypeForm();
				refreshHistTypeTable();
			} else {
				toastr.error("提交失败，该分组的类型已存在！");
				$('#addHistTypeWin').modal('hide');
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
function refreshHistTypeTable() {
	//刷新类型表格
	$("#tb_histTypeInfo").bootstrapTable('refresh');
}
/**
 * 刷新规则表格
 */
function refreshHistJudgeTable() {
	//刷新类型表格
	$("#tb_judgeHistInfo").bootstrapTable('refresh');
}
/**
 * 刷新已添加类型项目表格
 */
function refreshHistAddedTable() {
	//刷新类型表格
	$("#tb_addedHistItemInfo").bootstrapTable('refresh');
}
/**
 * 刷新未添加项目表格
 */
function refreshHistBeforeAddTable() {
	$("#tb_beforeAddHistInfo").bootstrapTable('refresh');
}

/**
 *用于点击是否启用按钮修改类型的启用状态。
 */
function isOpenHistType(){
	var row = $('#tb_histTypeInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择需要改变状态的类型！');
		return;
	}
	//拿到选中的列的数据，取得需要构成后台对象的数据，拼成json字符串，
	var dataOpenState={
		"id" : row[0].ID,
		"groupId" : row[0].GROUP_ID,
		"isOpen" : row[0].IS_OPEN,
		"isDelete" : row[0].IS_DELETE,
		"remark" : row[0].REMARK,
		"typeName" : row[0].TYPE_NAME
	};
	//json字符串转为对象
	dataOpenState=JSON.stringify(dataOpenState);
	//把对象传到后台修改状态。
	$.ajax({
		type : "POST",
		url : "../historyDataType/exchangeHistTypeIsOpen.do",
		data :dataOpenState,
		async : false,
		dataType : "text",
		contentType : "application/json;charset=utf-8",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("修改开启状态成功！");
				refreshHistTypeTable();
			} else {
				toastr.error("修改失败！" );
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
function isOpenHistJudge(){
	var row = $('#tb_judgeHistInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择需要改变状态的规则！');
		return;
	}
	//把对象传到后台修改状态。
	$.ajax({
		type : "get",
		url : "../historyDataJudge/exchangeHistJudgeIsOpen.do",
		data :{
			"id" : row[0].ID
		},
		async : false,
		dataType : "text",
		contentType : "application/json;charset=utf-8",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("修改开启状态成功！");
				refreshHistJudgeTable();
			} else {
				toastr.error("修改开启状态失败,请先维护数据！" );
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}
/**
 * 删除类型
 */
function deleteHistType(){
	var typeRow = $('#tb_histTypeInfo').bootstrapTable('getSelections');
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
			url : "../historyDataType/deleteHistType.do",
			data :typeIdList,
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("删除类型成功！");
					refreshHistTypeTable();
					$("#tb_beforeAddHistInfo").bootstrapTable('destroy'); 
					$("#tb_addedHistItemInfo").bootstrapTable('destroy'); 
					$("#tb_judgeHistInfo").bootstrapTable('destroy'); 
				} else {
					toastr.error("删除失败！");
					refreshHistTypeTable();
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
}
/**
 * 批量选中项目添加到分类中
 */
function addHistTypeForItem(){
	var itemRow = $('#tb_beforeAddHistInfo').bootstrapTable('getSelections');
	console.log(itemRow);
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
			url : "../historyDataJudge/addHistItemToType.do",
			data :itemIdList,
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("添加项目成功！");
					refreshHistBeforeAddTable();
					//双击后设置未添加项目表格的标题
					initHistAddedItemTable(dbRowTypeId,itemRow[0].DEVID);
				} else {
					toastr.error("添加失败！" );
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
function AddHistJudgeForItem(){
	var addedItemRow = $('#tb_addedHistItemInfo').bootstrapTable('getSelections');
	if (addedItemRow.length <= 0) {
		toastr.warning('请选择需要添加规则的项目！');
		return;
	}
	//用于设置模态框要设置项目的id
	$('#perId').val(addedItemRow[0].ID);
	$('#absId').val(addedItemRow[0].ID);
	
	judgeItemId=addedItemRow[0].ID;
		
	//用于判断调用哪个模态框
	if(addedItemRow[0].TYPE_NAME=='绝对值'){
		$('#absTypeId').val(addedItemRow[0].TYPE_ID);
		$('#absTypeMark').val(addedItemRow[0].TYPE_MARK);
		openModalTypeId=addedItemRow[0].TYPE_ID;
		$("#absoluteIsOpen1").prop('checked', 'checked');
		$('#addAbsWin').modal();
	}
	if(addedItemRow[0].TYPE_NAME=='百分比'){
		$('#perTypeId').val(addedItemRow[0].TYPE_ID);
		$('#perTypeMark').val(addedItemRow[0].TYPE_MARK);
		openModalTypeId=addedItemRow[0].TYPE_ID;
		$("#percentIsOpen1").prop('checked', 'checked');
		$('#addPerWin').modal();
	}
}
/**
 * 打开修改判断规则的模态框
 */
$('#histEditButton').on("click", function() {
	var editItemRow = $('#tb_judgeHistInfo').bootstrapTable('getSelections');
	if (editItemRow.length <= 0) {
		toastr.warning('请选择需要修改的判断规则！');
		return;
	}
	if(editItemRow[0].ABSOLUTE_IS_OPEN==null&&editItemRow[0].PERCENT_IS_OPNE==null){
		toastr.warning('请先维护规则再进行修改！');
		return;
	}
	//用于判断调用哪个模态框
	if(editItemRow[0].ABSOLUTE_IS_OPEN!=null){
		$('#editAbs').val(editItemRow[0].ABS);
		$('#onlyAbsId').val(editItemRow[0].ID);
		$('#editAbsHistoryDay').val(editItemRow[0].HIS_DAY);
		if (editItemRow[0].ABSOLUTE_IS_OPEN == "1") {
			$('#editAbsoluteIsOpen1').prop('checked', 'checked');
		}
		if (editItemRow[0].ABSOLUTE_IS_OPEN == "0") {
			$('#editAbsoluteIsOpen0').prop('checked', 'checked');
		}
		$('#editAbsWin').modal();
	}
	if(editItemRow[0].PERCENT_IS_OPNE!=null){
		$('#editPer').val(editItemRow[0].PER);
		$('#editPerHistoryDay').val(editItemRow[0].HIS_DAY);
		$('#onlyPerId').val(editItemRow[0].ID);
		if (editItemRow[0].PERCENT_IS_OPNE == "1") {
			$('#editPercentIsOpen1').prop('checked', 'checked');
		}
		if (editItemRow[0].PERCENT_IS_OPNE == "0") {
			$('#editPercentIsOpen0').prop('checked', 'checked');
		}
		$('#editPerWin').modal();
	}
});
/**
 * 绝对值模态框的提交
 */
function submitAbsForm(){
	var modelData = JSON.stringify($("#addAbsForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../historyDataJudge/addHistInfo.do",
		data :modelData,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#addAbsWin').modal('hide');
				cleanAbsForm();
				initHistJudgeTable(judgeItemId,openModalTypeId);
				$('#tb_judgeHistInfo').bootstrapTable('hideColumn', 'PER');
			    $('#tb_judgeHistInfo').bootstrapTable('hideColumn', 'PERCENT_IS_OPNE');
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
 * 百分比模态框的提交
 */
function submitPerForm(){
	var modelData = JSON.stringify($("#addPerForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../historyDataJudge/addHistInfo.do",
		data :modelData,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#addPerWin').modal('hide');
				cleanPerForm();
				initHistJudgeTable(judgeItemId,openModalTypeId);
				$('#tb_judgeHistInfo').bootstrapTable('hideColumn', 'ABS');
			    $('#tb_judgeHistInfo').bootstrapTable('hideColumn', 'ABSOLUTE_IS_OPEN');
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
 * 删除当前类型所添加的项目
 */
$('#histDeleteButton').on("click", function() {// 删除按钮
	var a = $("#tb_addedHistItemInfo").bootstrapTable('getSelections');
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
			url : "../historyDataJudge/deleteAddedItem.do",
			async : true,
			data : deleteItem,
			dataType : "text",// 预期服务器返回的数据类型
			contentType : 'application/json;charset=utf-8',
			success : function(data, status) {
				if (status == "success") {
					$("#tb_beforeAddHistInfo").bootstrapTable('refresh');
					$("#tb_addedHistItemInfo").bootstrapTable('refresh');
					$("#tb_judgeHistInfo").bootstrapTable('destroy'); 
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
 * 百分比模态框修改后提交
 */
function submitEditPerForm(){
	var data = JSON.stringify($("#editPerForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../historyDataJudge/editHistInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#editPerWin').modal('hide');
				cleanEditPerForm();
				$("#tb_judgeHistInfo").bootstrapTable('refresh');
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
function submitEditAbsForm(){
	var modelData = JSON.stringify($("#editAbsForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../historyDataJudge/editHistInfo.do",
		data :modelData,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#editAbsWin').modal('hide');
				cleanEditAbsForm();
				$("#tb_judgeHistInfo").bootstrapTable('refresh');
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