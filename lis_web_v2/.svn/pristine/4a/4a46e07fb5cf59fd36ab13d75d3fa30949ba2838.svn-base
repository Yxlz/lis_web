$(function() {
	
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

	// 2.初始化Button的点击事件
	var oButtonInit = new ButtonInit();
	oButtonInit.Init();
	adjustHeight();
});

var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tb_quality').bootstrapTable({
			url : '../aiqc/getAiQcInfo.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			toolbar : '#toolbar-quality', // 工具按钮用哪个容器
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
				field : 'ID',
				title : '项目Id',
				
				
			}, {
				field : 'DEV_NAME',
				title : '设备名字'
			}, {
				field : 'ITEM_NAME',
				title : '项目名字'
			}, {
				field : 'ITEM_NAME_CN',
				title : '项目中文名'
			}, {
				field : 'IS_QC',
				title : '是否判断质控',
				align : "center",
				pk: 1,
				editable: {
	                type: 'select',
	                source: [
	                    {value: 1, text: '是'},
	                    {value: 0, text: '否'},
	                ] ,
	                noeditFormatter: function (value,row,index) {
	                    var result={filed:"IS_QC",value:value,class:"badge",style:"background:#BEBEBE;padding:5px 10px;"};
	                    return result;
	                }

	            }
			}, {
				field : 'QC_STATE',
				title : '质控状态',
				align : "center",
				pk: 1,
				editable: {
	                type: 'select',
	                source: [
	                    {value: 1, text: '在控'},
	                    {value: 0, text: '失控'},
	                    {value: 2, text: '待检验'},
	                ],
	                noeditFormatter: function (value,row,index) {
	                    var result={filed:"QC_STATE",value:value,class:"badge",style:"background:#BEBEBE;padding:5px 10px;"};
	                    return result;
	                }
	            }
			}, {
				field : 'ADOPT',
				title : '审核状态',
				align : "center",
				pk: 1,
				editable: {
	            type: 'select',
	                source: [
	                    {value: 1, text: '审核通过'},
	                    {value: 0, text: '审核不通过'},
	                ],
	                noeditFormatter: function (value,row,index) {
	                    var result={filed:"ADOPT",value:value,class:"badge",style:"background:#BEBEBE;padding:5px 10px;"};
	                    return result;
	                }
	            }
			}
		]
		
	});
		
		$('.selectpicker').selectpicker({
			size: 4
		});
		
		//用于获取仪器名字 ， 后台传来的是数组对象  ，需转换为json对象。 liushijun
	    $.ajax({
            url : '../itemdev/getEquipmentInfo.do',
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
                    $("#equipment").html(programme_sel.join(' '));
                 // 缺一不可    加载bootstrap下拉框时必须。
                    $('#equipment').selectpicker('refresh');  
                    $('#equipment').selectpicker('render');  
                }
            },
            error : function() {
                alert('查询异常');
            }
        });
	};
	
	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit : params.limit, // 页面大小
			start : params.offset,// 页码
			aiQcName : String($("#equipment").val())
			
		};
		return temp;
	};
	
	//下拉框改变时刷新表格让下拉框加载到数据
	 $("#equipment").change(function() {
	        $("#tb_quality").bootstrapTable('refresh');
	    });
	return oTableInit;
};

var ButtonInit = function() {
	var oInit = new Object();

	oInit.Init = function() {
		//编辑后保存
		$('#btn_edit_quality').on("click", function() {
			var a = $("#tb_quality").bootstrapTable('getSelections');
			if (a.length <= 0 || a.length > 1) {
				toastr.warning('每次只能保存一条数据,请选择有效数据,亲');
				return;
			}
			$.ajax({
				type : "get",
				url : "../aiqc/saveAiQcInfo.do",
				async : true,
				data : {
					"id" : a[0].ID,
					"isQc" : a[0].IS_QC,
					"qcState" : a[0].QC_STATE,
					"adopt" : a[0].ADOPT
				},
				contentType : 'application/json;charset=utf-8',
				success : function(data, status) {
					if (status == "success") {
						toastr.success('提交数据成功');
						$("#tb_quality").bootstrapTable('refresh');
					}
				},
				error : function() {
					toastr.error('Error');
				},
				complete : function() {
					$('#btn_edit_hosp').attr('data-target', '');
				}
			});

		});
		
	};

	return oInit;
};

//页面加载完毕后  调整本页面panel高度
function adjustHeight(){
	var h = $('.contentPanel').height();
	$(".hospPanel").height(h);
}