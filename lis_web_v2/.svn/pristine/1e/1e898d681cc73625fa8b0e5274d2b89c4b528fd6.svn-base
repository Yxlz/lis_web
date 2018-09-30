/**
 * 分类管理
 */
$(document).ready(function() {
	initTypeTable();
	selectNameToId("groupForType");
	selectNameToId("groupAddSelect");
	var dbRowTypeId;
	//弹出添加判断的模态框时记录项目id
	var judgeItemId;
	//打开添加对应项目对应类型的判断时保存类型id
	var openModalTypeId;
	//禁用相关按钮
	$("#judgeButton").attr({"disabled":"disabled"});
	$("#addTypeButton").attr({"disabled":"disabled"});
	$("#isOpenButton").attr({"disabled":"disabled"});
});

/**
 * 初始化审核范围类型表格
 */
function initTypeTable() {
	$('#tb_typeInfo').bootstrapTable({
		url : '../referenceType/getReferenceTypeInfo.do',
		method : 'get', // 请求方式（*）
		striped : false, // 是否显示行间隔色
		cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
		sortable : false, // 是否启用排序
		queryParams : function(params) {
			return {
				start : params.offset,
				limit : params.limit,
				groupId:String($("#groupForType").val())
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
				$("#tb_beforeAddInfo").bootstrapTable('destroy'); 
				$("#tb_addedItemInfo").bootstrapTable('destroy'); 
				$("#tb_judgeInfo").bootstrapTable('destroy'); 
				//禁用相关按钮
				$("#judgeButton").attr({"disabled":"disabled"});
				$("#addTypeButton").attr({"disabled":"disabled"});
				$("#isOpenButton").attr({"disabled":"disabled"});
				return;
			}
			$("#tb_judgeInfo").bootstrapTable('destroy'); 
			$("#judgeButton").removeAttr("disabled");//将按钮可用
			$("#addTypeButton").removeAttr("disabled");//将按钮可用
			//双击后设置未添加项目表格的标题
			$("#BeforeAddTableName").text("未添加到<"+row.TYPE_NAME+">类型的项目");
			//双击类型行获取当前行类型id
			dbRowTypeId=row.ID;
			//双击表格列初始化未添加分类项目表格通过分类ID和分组ID
			initBeforeAddItemTable(row.ID,row.GROUP_ID);
			//双击表格列初始化已添加的分类项目表格
			initAddedItemTable(dbRowTypeId,row.GROUP_ID);
			
		}
	});
}

/**
 * 根据双击类型行，初始化为添加类型的该分组项目
 */
function initBeforeAddItemTable(typeId,groupId){
	//重复调用初始化表格时需要销毁表格才能再次初始化
	$("#tb_beforeAddInfo").bootstrapTable('destroy'); 
	$('#tb_beforeAddInfo').bootstrapTable({
		url : '../referenceType/getItemNotAdd.do',
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
function initAddedItemTable(typeId,groupId){
	//重复调用初始化表格时需要销毁表格才能再次初始化
	$("#tb_addedItemInfo").bootstrapTable('destroy'); 
	$('#tb_addedItemInfo').bootstrapTable({
		url : '../reference/getItemAdded.do',
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
			$("#tb_judgeInfo").bootstrapTable('destroy'); 
			$("#isOpenButton").removeAttr("disabled");//将按钮可用
			initJudgeTable(row.ID,row.TYPE_ID);
			//初始化后根据相应的类型隐藏一些不需要展示的列
			if(row.TYPE_NAME=='危急值'){
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SEX');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'AGE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'AGE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SPECIAL_ITEM');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SAMPLE_NAME');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'RANGE_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'ADOPT_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SITEM_IS_OPEN');
			}
			if(row.TYPE_NAME=='极限值范围'){
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'IS_CV');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SPECIAL_ITEM');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'ADOPT_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SITEM_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CV_IS_OPEN');
			}
			if(row.TYPE_NAME=='审核范围'){
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'IS_CV');
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SPECIAL_ITEM');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'RANGE_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SITEM_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CV_IS_OPEN');
			}
			if(row.TYPE_NAME=='特殊项目'){
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'IS_CV');
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SEX');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'AGE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'AGE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SAMPLE_NAME');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'RANGE_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'ADOPT_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CV_IS_OPEN');
			}
		}
	});
	//用于获取标本名字 ， 后台传来的是数组对象  ，需转换为json对象。 liushijun
    $.ajax({
        url : '../referenceType/getSampleInfo.do',
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
                $("#sampleName").html(programme_sel.join(' '));
                $("#limitSampleName").html(programme_sel.join(' '));
                $("#editAdoptSampleName").html(programme_sel.join(' '));
                $("#editLimitSampleName").html(programme_sel.join(' '));
                // 缺一不可    加载bootstrap下拉框时必须。
                $('#sampleName').selectpicker('refresh');  
                $('#sampleName').selectpicker('render');  
                // 缺一不可    加载bootstrap下拉框时必须。
                $('#limitSampleName').selectpicker('refresh');  
                $('#limitSampleName').selectpicker('render'); 
             // 缺一不可    加载bootstrap下拉框时必须。
                $('#editAdoptSampleName').selectpicker('refresh');  
                $('#editAdoptSampleName').selectpicker('render'); 
             // 缺一不可    加载bootstrap下拉框时必须。
                $('#editLimitSampleName').selectpicker('refresh');  
                $('#editLimitSampleName').selectpicker('render'); 
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
function initJudgeTable(itemDevId,typeId){
	//重复调用初始化表格时需要销毁表格才能再次初始化
	$("#tb_judgeInfo").bootstrapTable('destroy'); 
	$('#tb_judgeInfo').bootstrapTable({
		url : '../reference/getJudgeData.do',
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
		}, {
			field : 'IS_CV',
			title : '是否危急值',
			formatter : function(value, row, index) {
				if (value == '1') {
					return "<span style='color:green;'>是</span>";
				} else if (value == '0') {
					return "<span style='color:red;'>否</span>";
				}
				return value;
			}
		} ,{
			field : 'LIMIT_REFERENCE_L',
			title : '极限值范围低'
		} ,{
			field : 'LIMIT_REFERENCE_H',
			title : '极限值范围高'
		} ,{
			field : 'CHECK_L',
			title : '审核范围低'
		} ,{
			field : 'CHECK_H',
			title : '审核范围高'
		} ,{
			field : 'SEX',
			title : '性别',
			formatter : function(value, row, index) {
				if (value == '1') {
					return "<span style='color:green;'>男</span>";
				} else if (value == '0') {
					return "<span style='color:red;'>女</span>";
				} else if (value == '2') {
					return "<span style='color:red;'>无关</span>";
				}
				return value;
			}
		} ,{
			field : 'AGE_L',
			title : '年龄低'
		} ,{
			field : 'AGE_H',
			title : '年龄高'
		} ,{
			field : 'SPECIAL_ITEM',
			title : '特殊项目'
		} ,{
			field : 'SAMPLE_NAME',
			title : '标本名称'
		} ,{
			field : 'RANGE_IS_OPEN',
			title : '极限值范围是否开启',
			formatter : function(value, row, index) {
				if (value == '1') {
					return "<span style='color:green;'>是</span>";
				} else if (value == '0') {
					return "<span style='color:red;'>否</span>";
				}
				return value;
			}
		} , {
			field : 'CV_IS_OPEN',
			title : '危急值是否开启',
			formatter : function(value, row, index) {
				if (value == '1') {
					return "<span style='color:green;'>是</span>";
				} else if (value == '0') {
					return "<span style='color:red;'>否</span>";
				}
				return value;
			}
		} , {
			field : 'SITEM_IS_OPEN',
			title : '特殊项目是否开启',
			formatter : function(value, row, index) {
				if (value == '1') {
					return "<span style='color:green;'>是</span>";
				} else if (value == '0') {
					return "<span style='color:red;'>否</span>";
				}
				return value;
			}
		} , {
			field : 'ADOPT_IS_OPEN',
			title : '审核范围是否开启',
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
function selectNameToId(idData){
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
$("#groupForType").change(function() {
       $("#tb_typeInfo").bootstrapTable('refresh');
});

/**
 * 清空审核范围类型模态框
 */
function cleanTypeForm() {
	$('#id').val('');
	$('#typeTextSelect').val('');
	$("#groupAddSelect").val('');
	$("#groupAddSelect").selectpicker('refresh');
	$("#typeTextSelect").selectpicker('refresh');
	$('#remark').val('');
	$('#isOpen1').prop('checked', 'checked');

}

/**
 * 清空危急值模态框
 */
function cleanCvForm() {
	$('#cvId').val('');
	$('#cvIsOpen0').prop('checked', 'checked');
	$('#isCv0').prop('checked', 'checked');
}
/**
 * 清空极限值模态框
 */
function cleanLimitForm() {
	$('#limitId').val('');
	$('#limitReferenceL').val('');
	$('#limitReferenceH').val('');
	$('#limitSampleName').val('');
	$('#limitAgeH').val('');
	$('#limitAgeL').val('');
	$('#rangeIsOpen0').prop('checked', 'checked');
	$('#limitSex0').prop('checked', 'checked');
}
/**
 * 清空审核范围模态框
 */
function cleanRangeForm() {
	$('#rangeId').val('');
	$('#sampleName').val('');
	$('#ageH').val('');
	$('#ageL').val('');
	$('#checkL').val('');
	$('#checkH').val('');
	$('#adoptIsOpen0').prop('checked', 'checked');
	$('#sex0').prop('checked', 'checked');

}
/**
 * 清空特殊项目模态框
 */
function cleanSpcItemForm() {
	$('#spcItemId').val('');
	$('#specialItem').val('');
	$('#sitemIsOpen0').prop('checked', 'checked');
}
/**
 * 打开类型新增窗口
 */
function openAddType() {
	cleanTypeForm();
	$('#addTypeWin').modal();
}

/**
 * 打开类型编辑窗口
 */
function openEditType() {
	var row = $('#tb_typeInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择一个类型');
		return;
	}
	$('#id').val(row[0].ID);
	$('#typeTextSelect').val(row[0].TYPE_NAME);
	$("#groupAddSelect").val(row[0].GROUP_ID);
	$("#groupAddSelect").selectpicker('refresh');
	$("#typeTextSelect").selectpicker('refresh');
	$('#remark').val(row[0].REMARK);
	if (row[0].IS_OPEN == "1") {
		$('#isOpen1').prop('checked', 'checked');
	}
	if (row[0].IS_OPEN == "0") {
		$('#isOpen0').prop('checked', 'checked');
	}
	$('#addTypeWin').modal();
}
/**
 * 删除范围判断类型
 */
function deleteType(){
	var typeRow = $('#tb_typeInfo').bootstrapTable('getSelections');
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
			url : "../referenceType/deleteType.do",
			data :typeIdList,
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("删除类型成功！");
					refreshTypeTable();
				} else {
					toastr.error("删除失败！");
					refreshTypeTable();
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
}

/**
 * 提交审核范围类型表单
 */
function submitTypeForm() {
	var data = JSON.stringify($("#addTypeForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../referenceType/addReferenceTypeInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#addTypeWin').modal('hide');
				cleanTypeForm();
				refreshTypeTable();
			} else {
				toastr.error("提交失败，该分组的类型已存在！");
				$('#addTypeWin').modal('hide');
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
function refreshTypeTable() {
	//刷新类型表格
	$("#tb_typeInfo").bootstrapTable('refresh');
}
/**
 * 刷新规则表格
 */
function refreshJudgeTable() {
	//刷新类型表格
	$("#tb_judgeInfo").bootstrapTable('refresh');
}
/**
 * 刷新已添加类型项目表格
 */
function refreshAddedTable() {
	//刷新类型表格
	$("#tb_addedItemInfo").bootstrapTable('refresh');
}
/**
 * 刷新未添加项目表格
 */
function refreshBeforeAddTable() {
	$("#tb_beforeAddInfo").bootstrapTable('refresh');
}

/**
 *用于点击是否启用按钮修改类型的启用状态。
 */
function isOpenType(){
	var row = $('#tb_typeInfo').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择需要改变状态的类型！');
		return;
	}
	//拿到选中的列的数据，取得需要构成后台对象的数据，拼成json字符串，
	var dataOpenState={
		"id" : row[0].ID,
		"groupId" : row[0].GROUP_ID,
		"isDelete" : row[0].IS_DELETE,
		"isOpen" : row[0].IS_OPEN,
		"remark" : row[0].REMARK,
		"typeName" : row[0].TYPE_NAME
	};
	//json字符串转为对象
	dataOpenState=JSON.stringify(dataOpenState);
	//把对象传到后台修改状态。
	$.ajax({
		type : "POST",
		url : "../referenceType/exchangeIsOpen.do",
		data :dataOpenState,
		async : false,
		dataType : "text",
		contentType : "application/json;charset=utf-8",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("修改开启状态成功！");
				refreshTypeTable();
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
function isOpenJudge(){
	var row = $('#tb_judgeInfo').bootstrapTable('getSelections');
	if (row.length == 0||row.length>=2) {
		toastr.warning('请选择一条需要改变状态的规则！');
		return;
	}
	//把对象传到后台修改状态。
	$.ajax({
		type : "get",
		url : "../reference/exchangeJudgeIsOpen.do",
		data :{
			"id" : row[0].ID
		},
		async : false,
		dataType : "text",
		contentType : "application/json;charset=utf-8",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("修改开启状态成功！");
				refreshJudgeTable();
			} else {
				toastr.error("修改开启状态失败,请先维护规则！" );
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
function addTypeForItem(){
	var itemRow = $('#tb_beforeAddInfo').bootstrapTable('getSelections');
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
			url : "../reference/addItemToType.do",
			data :itemIdList,
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("添加项目成功！");
					refreshBeforeAddTable();
					//双击后设置未添加项目表格的标题
					initAddedItemTable(dbRowTypeId,itemRow[0].DEVID);
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
function AddJudgeForItem(){
	var addedItemRow = $('#tb_addedItemInfo').bootstrapTable('getSelections');
	if (addedItemRow.length <= 0) {
		toastr.warning('请选择需要添加规则的项目！');
		return;
	}
	//用于设置模态框要设置项目的id
	$('#spcItemId').val(addedItemRow[0].ID);
	$('#limitId').val(addedItemRow[0].ID);
	$('#cvId').val(addedItemRow[0].ID);
	$('#rangeId').val(addedItemRow[0].ID);
	
	judgeItemId=addedItemRow[0].ID;
		
	//用于判断调用哪个模态框
	if(addedItemRow[0].TYPE_NAME=='危急值'){
		$('#cvTypeId').val(addedItemRow[0].TYPE_ID);
		$('#cvTypeMark').val(addedItemRow[0].TYPE_MARK);
		openModalTypeId=addedItemRow[0].TYPE_ID;
		$('#addCvWin').modal();
	}
	if(addedItemRow[0].TYPE_NAME=='审核范围'){
		$('#rangeTypeId').val(addedItemRow[0].TYPE_ID);
		$('#rangeTypeMark').val(addedItemRow[0].TYPE_MARK);
		openModalTypeId=addedItemRow[0].TYPE_ID;
		$('#addRangeWin').modal();
	}
	if(addedItemRow[0].TYPE_NAME=='特殊项目'){
		$('#spcItemTypeId').val(addedItemRow[0].TYPE_ID);
		$('#spcItemTypeMark').val(addedItemRow[0].TYPE_MARK);
		openModalTypeId=addedItemRow[0].TYPE_ID;
		$('#addSpcItemWin').modal();
	}
	if(addedItemRow[0].TYPE_NAME=='极限值范围'){
		$('#limitTypeId').val(addedItemRow[0].TYPE_ID);
		$('#limitTypeMark').val(addedItemRow[0].TYPE_MARK);
		openModalTypeId=addedItemRow[0].TYPE_ID;
		$('#addLimitWin').modal();
	}
}

/**
 * 危急值模态框的提交
 */
function submitCvForm(){
	var modelData = JSON.stringify($("#addCvForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../reference/addReferenceInfo.do",
		data :modelData,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			console.log(data);
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#addCvWin').modal('hide');
				cleanCvForm();
				initJudgeTable(judgeItemId,openModalTypeId);
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SEX');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'AGE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'AGE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SPECIAL_ITEM');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SAMPLE_NAME');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'RANGE_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'ADOPT_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SITEM_IS_OPEN');
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
 * 极限范围模态框提交
 */
function submitLimitForm(){
	var data = JSON.stringify($("#addLimitForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../reference/addReferenceInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data) {
				toastr.success("提交成功");
				$('#addLimitWin').modal('hide');
				cleanLimitForm();
				initJudgeTable(judgeItemId,openModalTypeId);
				//用于隐藏某些列
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'IS_CV');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SPECIAL_ITEM');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'ADOPT_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SITEM_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CV_IS_OPEN');
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
 * 审核范围模态框提交
 */
function submitRangeForm(){
	var data = JSON.stringify($("#addRangeForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../reference/addReferenceInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data) {
				toastr.success("提交成功");
				$('#addRangeWin').modal('hide');
				cleanRangeForm();
				initJudgeTable(judgeItemId,openModalTypeId);
				//用于隐藏某些列
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'IS_CV');
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SPECIAL_ITEM');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'RANGE_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SITEM_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CV_IS_OPEN');
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
 *特殊项目模态框提交 
 */
function submitSpcItemForm(){
	var data = JSON.stringify($("#addSpcItemForm").serializeObject());
	console.log(data);
	$.ajax({
		type : "POST",
		url : "../reference/addReferenceInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data) {
				toastr.success("提交成功");
				$('#addSpcItemWin').modal('hide');
				cleanSpcItemForm();
				initJudgeTable(judgeItemId,openModalTypeId);
				//用于隐藏某些列
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'IS_CV');
				$('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'LIMIT_REFERENCE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CHECK_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SEX');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'AGE_L');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'AGE_H');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'SAMPLE_NAME');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'RANGE_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'ADOPT_IS_OPEN');
			    $('#tb_judgeInfo').bootstrapTable('hideColumn', 'CV_IS_OPEN');
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
$('#scopeJudgeDeleteButton').on("click", function() {// 删除按钮
	var a = $("#tb_addedItemInfo").bootstrapTable('getSelections');
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
			url : "../reference/deleteAddedItem.do",
			async : true,
			data : deleteItem,
			dataType : "text",// 预期服务器返回的数据类型
			contentType : 'application/json;charset=utf-8',
			success : function(data, status) {
				if (status == "success") {
					$("#tb_beforeAddInfo").bootstrapTable('refresh');
					$("#tb_addedItemInfo").bootstrapTable('refresh');
					$("#tb_judgeInfo").bootstrapTable('destroy'); 
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
$('#scopeEditButton').on("click", function() {
	var editItemRow = $('#tb_judgeInfo').bootstrapTable('getSelections');
	if (editItemRow.length <= 0) {
		toastr.warning('请选择需要修改的判断规则！');
		return;
	}
	if(editItemRow[0].RANGE_IS_OPEN==null&&editItemRow[0].CV_IS_OPEN==null&&editItemRow[0].ADOPT_IS_OPEN==null&&editItemRow[0].SITEM_IS_OPEN==null){
		toastr.warning('请先维护规则再进行修改！');
		return;
	}
	//用于判断调用哪个模态框
	if(editItemRow[0].CV_IS_OPEN!=null){
		$('#onlyCvId').val(editItemRow[0].ID);
		if (editItemRow[0].IS_CV == "1") {
			$('#editIsCv1').prop('checked', 'checked');
		}
		if (editItemRow[0].IS_CV == "0") {
			$('#editIsCv0').prop('checked', 'checked');
		}
		if (editItemRow[0].CV_IS_OPEN == "1") {
			$('#editCvIsOpen1').prop('checked', 'checked');
		}
		if (editItemRow[0].CV_IS_OPEN == "0") {
			$('#editCvIsOpen0').prop('checked', 'checked');
		}
		$('#editCvWin').modal();
	}
	if(editItemRow[0].RANGE_IS_OPEN!=null){
		$('#onlyRangeId').val(editItemRow[0].ID);
		$('#editLimitReferenceL').val(editItemRow[0].LIMIT_REFERENCE_L);
		$('#editLimitReferenceH').val(editItemRow[0].LIMIT_REFERENCE_H);
		$('#editLimitAgeL').val(editItemRow[0].AGE_L);
		$('#editLimitAgeH').val(editItemRow[0].AGE_H);
		$('#editLimitSampleName').val(editItemRow[0].SAMPLE_NAME);
		$('#onlyRangeId').val(editItemRow[0].ID);
		if (editItemRow[0].SEX == "1") {
			$('#editLimitSex1').prop('checked', 'checked');
		}
		if (editItemRow[0].SEX == "0") {
			$('#editLimitSex0').prop('checked', 'checked');
		}
		if (editItemRow[0].SEX == "2") {
			$('#editLimitSex2').prop('checked', 'checked');
		}
		if (editItemRow[0].RANGE_IS_OPEN == "1") {
			$('#editRangeIsOpen1').prop('checked', 'checked');
		}
		if (editItemRow[0].RANGE_IS_OPEN == "0") {
			$('#editRangeIsOpen0').prop('checked', 'checked');
		}
		$('#editLimitWin').modal();
	}
	if(editItemRow[0].ADOPT_IS_OPEN!=null){
		$('#onlyAdoptId').val(editItemRow[0].ID);
		$('#editAdoptCheckL').val(editItemRow[0].CHECK_L);
		$('#editAdoptCheckH').val(editItemRow[0].CHECK_H);
		$('#editAdoptAgeL').val(editItemRow[0].AGE_L);
		$('#editAdoptAgeH').val(editItemRow[0].AGE_H);
		$('#editAdoptSampleName').val(editItemRow[0].SAMPLE_NAME);
		$('#onlyRangeId').val(editItemRow[0].ID);
		if (editItemRow[0].SEX == "1") {
			$('#editAdoptSex1').prop('checked', 'checked');
		}
		if (editItemRow[0].SEX == "0") {
			$('#editAdoptSex0').prop('checked', 'checked');
		}
		if (editItemRow[0].SEX == "2") {
			$('#editAdoptSex2').prop('checked', 'checked');
		}
		if (editItemRow[0].ADOPT_IS_OPEN == "1") {
			$('#editAdoptIsOpen1').prop('checked', 'checked');
		}
		if (editItemRow[0].ADOPT_IS_OPEN == "0") {
			$('#editAdoptIsOpen0').prop('checked', 'checked');
		}
		$('#editAdoptWin').modal();
	}
	if(editItemRow[0].SITEM_IS_OPEN!=null){
		$('#onlySpcItemId').val(editItemRow[0].ID);
		$('#editSpecialItem').val(editItemRow[0].SPECIAL_ITEM);
		$('#onlySpcItemId').val(editItemRow[0].ID);
		if (editItemRow[0].SITEM_IS_OPEN == "1") {
			$('#editSitemIsOpen1').prop('checked', 'checked');
		}
		if (editItemRow[0].SITEM_IS_OPEN == "0") {
			$('#editSitemIsOpen0').prop('checked', 'checked');
		}
		$('#editSpcItemWin').modal();
	}
});

/**
 * 危急值模态框修改后提交
 */
function submitEditCvForm(){
	var data = JSON.stringify($("#editCvForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../reference/editCheckReferenceInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				cleanEditCvForm();
				$('#editCvWin').modal('hide');
				$("#tb_judgeInfo").bootstrapTable('refresh');
			} else {
				cleanEditCvForm();
				toastr.error("提交失败");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}
/**
 * 极限范围模态框修改后提交
 */
function submitEditLimitForm(){
	var data = JSON.stringify($("#editLimitForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../reference/editCheckReferenceInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				cleanEditLimitForm();
				$('#editLimitWin').modal('hide');
				$("#tb_judgeInfo").bootstrapTable('refresh');
			} else {
				cleanEditLimitForm();
				toastr.error("提交失败");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}
/**
 * 审核范围模态框修改后提交
 */
function submitEditAdoptForm(){
	var data = JSON.stringify($("#editAdoptForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../reference/editCheckReferenceInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				cleanEditRangeForm();
				$('#editAdoptWin').modal('hide');
				$("#tb_judgeInfo").bootstrapTable('refresh');
			} else {
				cleanEditRangeForm();
				toastr.error("提交失败");
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
}

/**
 * 特殊项目模态框修改后提交
 */
function submitEditSpcItemForm(){
	var data = JSON.stringify($("#editSpcItemForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../reference/editCheckReferenceInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				cleanEditSpcItemForm();
				$('#editSpcItemWin').modal('hide');
				$("#tb_judgeInfo").bootstrapTable('refresh');
			} else {
				cleanEditSpcItemForm();
				toastr.error("提交失败");
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
$('#scopeDeleteJudgeButton').on("click", function() {
	var judgeRow = $('#tb_judgeInfo').bootstrapTable('getSelections');
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
			url : "../reference/deleteCheckRefJudge.do",
			data :judgeIdList,
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("删除规则成功！");
					refreshJudgeTable();
					refreshAddedTable();
					refreshBeforeAddTable();
				} else {
					toastr.error("删除失败！");
					
					refreshJudgeTable();
					refreshAddedTable();
					refreshBeforeAddTable();
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
});

/**
 * 清空编辑后危急值模态框
 */
function cleanEditCvForm() {
	$('#onlyCvId').val('');
	$('#editCvIsOpen0').prop('checked', 'checked');
	$('#editIsCv0').prop('checked', 'checked');
}
/**
 * 清空编辑后极限值模态框
 */
function cleanEditLimitForm() {
	$('#onlyRangeId').val('');
	$('#editLimitSampleName').val('');
	$('#editLimitAgeH').val('');
	$('#editLimitAgeL').val('');
	$('#editLimitReferenceL').val('');
	$('#editLimitReferenceH').val('');
	$('#editRangeIsOpen0').prop('checked', 'checked');
	$('#editLimitSex2').prop('checked', 'checked');
}
/**
 * 清空编辑后审核范围模态框
 */
function cleanEditRangeForm() {
	$('#editAdoptCheckL').val('');
	$('#editAdoptCheckH').val('');
	$('#editAdoptAgeL').val('');
	$('#editAdoptAgeH').val('');
	$('#editAdoptSampleName').val('');
	$('#onlyAdoptId').val('');
	$('#editAdoptSex2').prop('checked', 'checked');
	$('#editAdoptIsOpen0').prop('checked', 'checked');

}
/**
 * 清空编辑后特殊项目模态框
 */
function cleanEditSpcItemForm() {
	$('#editSpecialItem').val('');
	$('#onlySpcItemId').val('');
	$('#editSitemIsOpen0').prop('checked', 'checked');
}