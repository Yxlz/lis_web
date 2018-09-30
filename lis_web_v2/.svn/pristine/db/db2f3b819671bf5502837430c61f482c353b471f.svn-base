$(function() {
	adjustHeight();
	initItemTable();
	//禁用相关按钮
	$("#KWInfoIsAdopt").attr({"disabled":"disabled"});
});

//初始化项目展示表格
function initItemTable(){
		$('#tb_ICDItem').bootstrapTable({
			url : '../ICD/getItemInfo.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : function(params) {
				return {
					start : params.offset,
					limit : params.limit,
					groupId:$("#groupForKeyWords").val()
				};
			},// 传递参数（*）
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
			pageNumber : 1, // 初始化加载第一页，默认第一页
			pageSize : 10, // 每页的记录行数（*）
			pageList : [ 10, 25, 50, 100 ], // 可供选择的每页的行数（*）
			search : false, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			singleSelect : true,
			detailView : false, // 是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				title: '序号',//标题  
				formatter: function (value, row, index) {
						return index+1;
				}
			}, {
				field : 'ID',
				title : '项目id',
				visible : false
			}, {
				field : 'ITEM_CODE',
				title : '项目编码',
			}, {
				field : 'DEV_CODE',
				title : '组id',
				visible : false
			}, {
				field : 'DEV_NAME',
				title : '组名',
			},{
				field : 'ITEM_NAME_CN',
				title : '项目中文名'
			}, {
				field : 'ITEM_NAME',
				title : '项目英文名'
			}
		],
		onClickRow : function(row, tr) {	
			$("#tb_keyWords").bootstrapTable('destroy'); 
			$("#btn_edit_keyWords").removeAttr("disabled");//将按钮可用
			//获取当前行类型id
			var itemDevId=row.ID;
			//根据项目id初始化关键字表格
			initKeyWordsTable(itemDevId);
		}
	});
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
		                $("#groupForKeyWords").html(programme_sel.join(' '));
		             // 缺一不可    加载bootstrap下拉框时必须。
		                $("#groupForKeyWords").selectpicker('refresh');  
		                $("#groupForKeyWords").selectpicker('render');  
		            }
		        },
		        error : function() {
		            alert('查询异常');
		        }
		    });
}
//初始化关键字表格
function initKeyWordsTable(itemDevId){
	$("#KWInfoIsAdopt").removeAttr("disabled");//将按钮可用
	   $('#tb_keyWords').bootstrapTable({
			url : '../ICD/getICDInfo.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			striped : true, // 是否显示行间隔色
			cache : false, // 是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
			pagination : true, // 是否显示分页（*）
			sortable : false, // 是否启用排序
			sortOrder : "asc", // 排序方式
			queryParams : function(params) {
				return {
					start : params.offset,
					limit : params.limit,
					itemDevId : itemDevId
				};
			},// 传递参数（*）
			sidePagination : "server", // 分页方式：client客户端分页，server服务端分页（*）
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
			singleSelect : true,
			detailView : false, // 是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				title: '序号',//标题  
				formatter: function (value, row, index) {
						return index+1;
				}
			}, {
				field : 'ID',
				title : '唯一ID',
				visible : false
			}, {
				field : 'ITEM_DEV_ID',
				title : '项目id',
				visible : false
			}, {
				field : 'CRUX',
				title : '关键字'
			}, {
				field : 'LOGIC',
				title : '诊断逻辑'
			}, {
				field : 'CONTENT',
				title : '诊断内容'
			}, {
				field : 'ADOPT',
				title : '是否启用',
				formatter : function(value, row, index) {
					if (value == '1') {
						return "<span style='color:green;'>是</span>";
					} else if (value == '0') {
						return "<span style='color:red;'>否</span>";
					} 
					return value;
				}
			}
		]
		
	});
}
//下拉框改变时刷新表格让下拉框加载到数据
$("#groupForKeyWords").change(function() {
       $("#tb_ICDItem").bootstrapTable('refresh');
});

//点击按钮弹出模态框用于设置关键字判断条件
$("#btn_edit_keyWords").click(function(){
	var tbData = $('#tb_ICDItem').bootstrapTable('getSelections');
	if (tbData.length <= 0) {
		toastr.warning('请选择一条数据！');
		return;
	}
	$("#cRUX").val('');
	$("#iCDTextSelect").val('');
	$("#content").val('');
	$("#adopt0").prop('checked', 'checked');
	$("#id").val(tbData[0].ID);
	$("#iCDTextSelect").selectpicker('refresh');
	$('#setICDWin').modal();
});

/**
 * 编辑关键词
 */
$("#KeyWordsEdit").click(function(){
	var tbEditData = $('#tb_keyWords').bootstrapTable('getSelections');
	if (tbEditData.length <= 0) {
		toastr.warning('请选择一条数据！');
		return;
	}
	$("#cRUX").val(tbEditData[0].CRUX);
	$("#iCDTextSelect").val(tbEditData[0].LOGIC);
	$("#content").val(tbEditData[0].CONTENT);
	if (tbEditData[0].ADOPT == "1") {
		$('#adopt1').prop('checked', 'checked');
	}
	$("#id").val(tbEditData[0].ITEM_DEV_ID);
	$("#primaryId").val(tbEditData[0].ID);
	$("#iCDTextSelect").selectpicker('refresh');
	$('#setICDWin').modal();
});

/**
 *用于点击是否通过审核按钮，修改关键字数据的审核状态
 */
$("#KWInfoIsAdopt").click(function(){
	var row = $('#tb_keyWords').bootstrapTable('getSelections');
	if (row.length == 0) {
		toastr.warning('请选择需要改变审核状态的数据！');
		return;
	}
	//把对象传到后台修改状态。
	$.ajax({
		type : "GET",
		url : "../ICD/exchangeAdoptICDInfo.do",
		data :{
			id : row[0].ID
		},
		async : false,
		dataType : "text",
		contentType : "application/json;charset=utf-8",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("修改审核状态成功！");
				$("#tb_keyWords").bootstrapTable('refresh');
			} else {
				toastr.error("修改失败！" );
			}
		},
		error : function(jqXHR, textStatus, errorThrown) {
			toastr.error("网络异常:" + errorThrown);
		}
	});
});
//提交模态框时
function submitICDForm(){
	var data = JSON.stringify($("#setICDForm").serializeObject());
	$.ajax({
		type : "POST",
		url : "../ICD/saveICDInfo.do",
		data :data,
		async : false,
		dataType : "text",
		contentType : "application/json",
		success : function(data) {
			if (data=="{success:true}") {
				toastr.success("提交成功");
				$('#setICDWin').modal('hide');
				//刷新类型表格
				$("#tb_keyWords").bootstrapTable('refresh');
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
 * 删除关键词
 */
$("#KeyWordsDelete").click(function(){
	var keyWordsRow = $('#tb_keyWords').bootstrapTable('getSelections');
	if (keyWordsRow.length <= 0) {
		toastr.warning('请选择需要删除关键字规则！');
		return;
	}
	Ewin.confirm({
		message : "确认要删除这条数据吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
		//把对象传到后台修改状态。
		$.ajax({
			type : "get",
			url : "../ICD/deleteKeyWords.do",
			data :{id : keyWordsRow[0].ID},
			async : false,
			dataType : "text",
			contentType : "application/json;charset=utf-8",
			success : function(data) {
				if (data=="{success:true}") {
					toastr.success("删除关键词数据成功！");
					//刷新表格
					$("#tb_keyWords").bootstrapTable('refresh');
				} else {
					toastr.error("删除失败！");
					//刷新表格
					$("#tb_keyWords").bootstrapTable('refresh');
				}
			},
			error : function(jqXHR, textStatus, errorThrown) {
				toastr.error("网络异常:" + errorThrown);
			}
		});
	});
});
//页面加载完毕后  调整本页面panel高度
function adjustHeight(){
	var h = $('.contentPanel').height();
	$(".hospPanel").height(h);
}