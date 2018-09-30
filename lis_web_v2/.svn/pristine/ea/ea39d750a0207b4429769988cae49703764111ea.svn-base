$(function() {
	// 1.初始化Table
	var oTable = new TableInit();
	oTable.Init();

	// 2.初始化Button的点击事件
	var oButtonInit = new ButtonInit();
	oButtonInit.Init();

	$("#form_addHosp_data").bootstrapValidator({
						live : 'enabled',// 验证时机，enabled是内容有变化就验证（默认），disabled和submitted是提交再验证
						excluded : [ ':disabled', ':hidden', ':not(:visible)' ],// 排除无需验证的控件，比如被禁用的或者被隐藏的
						submitButtons : '#button-submit-hosp',// 指定提交按钮，如果验证失败则变成disabled，但我没试成功，反而加了这句话非submit按钮也会提交到action指定页面
						message : '验证不通过',// 好像从来没出现过
						feedbackIcons : {// 根据验证结果显示的各种图标
							valid : 'glyphicon glyphicon-ok',
							invalid : 'glyphicon glyphicon-remove',
							validating : 'glyphicon glyphicon-refresh'
						},
						fields : {
							hospCode : {
								validators : {
									notEmpty : {// 检测非空,radio也可用
										message : '机构代码不能为空'
									}
								}
							},
							hospName : {
								validators : {
									notEmpty : {
										message : '医院名称不能为空'
									}
								}
							},
							phoneNum : {
								validators : {
									regexp : {// 正则验证
										regexp : /^(0[0-9]{2,3}\-)?([2-9][0-9]{6,7})+(\-[0-9]{1,4})?$/,
										message : '您所输入的电话号码不合法'
									}
								}
							}
						}
					});
	$('#button-shutdown-hosp').click(function() {// 关闭模态框，重置数据
		$('#hospCode').val('');
		$('#hospName').val('');
		$('#hospSx').val('');
		$('#phoneNum').val('');
		$('#isUsed1').prop('checked', 'checked');
		$('#isUsed0').prop('checked', '');
		$('#isVisable1').prop('checked', 'checked');
		$('#isVisable0').prop('checked', '');
		$("#form_addHosp_data").data("bootstrapValidator").resetForm();
	});
	$('#btn_add_hosp').click(function() {// 新增打开模态框，重置数据
		$('#hospCode').val('');
		$('#hospName').val('');
		$('#hospSx').val('');
		$('#phoneNum').val('');
		$('#isUsed1').prop('checked', 'checked');
		$('#isUsed0').prop('checked', '');
		$('#isVisable1').prop('checked', 'checked');
		$('#isVisable0').prop('checked', '');
		$("#form_addHosp_data").data("bootstrapValidator").resetForm();
	});
	$("#button-submit-hosp").click(function() {// 非submit按钮点击后进行验证，如果是submit则无需此句直接验证
				$("#form_addHosp_data").bootstrapValidator('validate');// 提交验证
				if ($("#form_addHosp_data").data('bootstrapValidator').isValid()) {// 获取验证结果，如果成功，执行下面代码
					var hosInfo = JSON.stringify($("#form_addHosp_data").serializeObject())
					$.ajax({
						// 几个参数需要注意一下
						type : "POST",// 方法类型
						dataType : "text",// 预期服务器返回的数据类型
						url : "../hospital/addHosOrgInfo.do",// url
						async : true,
						data : hosInfo,
						contentType : 'application/json;charset=utf-8',
						success : function(data) {
							$('#addHospitalModal').modal('hide');
							toastr.success('保存成功');
							$("#tb_hospital").bootstrapTable('refresh');
							$("#form_addHosp_data").data("bootstrapValidator").resetForm();
						},
						error : function() {
							toastr.error('Error');
						}
					});
				}
			});
	adjustHeight();
});
var TableInit = function() {
	var oTableInit = new Object();
	// 初始化Table
	oTableInit.Init = function() {
		$('#tb_hospital').bootstrapTable({
			url : '../hospital/getHosOrgInfo.do', // 请求后台的URL（*）
			method : 'get', // 请求方式（*）
			toolbar : '#toolbar-hosp', // 工具按钮用哪个容器
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
			search : true, // 是否显示表格搜索，此搜索是客户端搜索，不会进服务端，所以，个人感觉意义不大
			strictSearch : true,
			showColumns : true, // 是否显示所有的列
			showRefresh : true, // 是否显示刷新按钮
			minimumCountColumns : 2, // 最少允许的列数
			clickToSelect : true, // 是否启用点击选中行
			uniqueId : "id", // 每一行的唯一标识，一般为主键列
			showToggle : true, // 是否显示详细视图和列表视图的切换按钮
			cardView : false, // 是否显示详细视图
			detailView : false, // 是否显示父子表
			columns : [ {
				checkbox : true
			}, {
				field : 'hospCode',
				title : '医院编码'
			}, {
				field : 'hospName',
				title : '医院名称'
			}, {
				field : 'hospSx',
				title : '医院简码'
			}, {
				field : 'isUsed',
				title : '是否使用',
				align : "center",
				formatter : function(value, row, index) {
					if (value == '1') {
						return "<span style='color:green;'>启用</span>";
					} else if (value == '0') {
						return "<span style='color:red;'>禁用</span>";
					}
					return value;
				}
			}, {
				field : 'isVisable',
				title : '是否显示',
				align : "center",
				formatter : function(value, row, index) {
					if (value == '1') {
						return "<span style='color:green;'>显示</span>";
					} else if (value == '0') {
						return "<span style='color:gray;'>不显示</span>";
					}
					return value;
				}
			}, {
				field : 'phoneNum',
				title : '电话号码'
			} ],
			onDblClickRow : function(row, obj) {//双击进行编辑
				$.ajax({
					type : "get",
					url : "../hospital/getHosOrgInfoByID.do",
					async : true,
					data : {
						'id' : row.id
					},
					dataType : "json",// 预期服务器返回的数据类型
					contentType : 'application/json;charset=utf-8',
					success : function(data, status) {
						if (status == "success") {
							$('#id-hosp').val(data.id);
							$('#hospCode').val(data.hospCode);
							$('#hospName').val(data.hospName);
							$('#hospSx').val(data.hospSx);
							$('#phoneNum').val(data.phoneNum);
							if (data.isUsed == "1") {
								$('#isUsed1').prop('checked', 'checked');
							}
							if (data.isUsed == "0") {
								$('#isUsed0').prop('checked', 'checked');
							}
							if (data.isVisable == "1") {
								$('#isVisable1').prop('checked', 'checked');
							}
							if (data.isVisable == "0") {
								$('#isVisable0').prop('checked', 'checked');
							}
						}
					},
					error : function() {
						toastr.error('Error');
					},
					complete : function() {
						$('#btn_edit_hosp').attr('data-target', '');
					}
				});
				$('#addHospitalModal').modal('show');
			}
		});
	};

	// 得到查询的参数
	oTableInit.queryParams = function(params) {
		var temp = { // 这里的键的名字和控制器的变量名必须一直，这边改动，控制器也需要改成一样的
			limit : params.limit, // 页面大小
			start : params.offset, // 页码
			hosName : params.search
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
		$('#btn_edit_hosp').on("click", function() {
			var a = $("#tb_hospital").bootstrapTable('getSelections');
			console.log(a);
			if (a.length <= 0 || a.length > 1) {
				toastr.warning('每次只能编辑一条数据,请选择有效数据,亲');
				return;
			}
			$('#btn_edit_hosp').attr('data-target', '#addHospitalModal');
			$.ajax({
				type : "get",
				url : "../hospital/getHosOrgInfoByID.do",
				async : true,
				data : {
					'id' : a[0].id
				},
				dataType : "json",// 预期服务器返回的数据类型
				contentType : 'application/json;charset=utf-8',
				success : function(data, status) {
					if (status == "success") {
						$('#id-hosp').val(data.id);
						$('#hospCode').val(data.hospCode);
						$('#hospName').val(data.hospName);
						$('#hospSx').val(data.hospSx);
						$('#phoneNum').val(data.phoneNum);
						if (data.isUsed == "1") {
							$('#isUsed1').prop('checked', 'checked');
						}
						if (data.isUsed == "0") {
							$('#isUsed0').prop('checked', 'checked');
						}
						if (data.isVisable == "1") {
							$('#isVisable1').prop('checked', 'checked');
						}
						if (data.isVisable == "0") {
							$('#isVisable0').prop('checked', 'checked');
						}
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
		$('#btn_delete_hosp').on("click", function() {// 删除按钮
			var a = $("#tb_hospital").bootstrapTable('getSelections');
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
					url : "../hospital/delHosOrgInfo.do",
					async : true,
					data : JSON.stringify(names),
					dataType : "text",// 预期服务器返回的数据类型
					contentType : 'application/json;charset=utf-8',
					success : function(data, status) {
						if (status == "success") {
							toastr.success('提交数据成功');
							$("#tb_hospital").bootstrapTable('refresh');
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
		/*
		 * $('#btn_add_hosp').on("click",function(){ $.ajax({ type : "get", url :
		 * "../dept/getDepts.do", contentType : "application/json;
		 * charset=UTF-8", dataType : "json", // data :
		 * JSON.stringify({'url_name':url_name}), timeout : 1000, cache : false,
		 * success : function(data) { var h = ""; $.each(data, function(key,
		 * value) {// 拼接option // console.log(value); h += "<option value='" +
		 * value.id + "'>" + value.departName + "</option>"; })
		 * $("#lisInspecDepartment").append(h);// append 添加进去并展示 } }) });
		 */
	};

	return oInit;
};

function getHospSx() {
	var sx = pinyin.getCamelChars($('#hospName').val());
	$('#hospSx').val(sx);
}
//页面加载完毕后  调整本页面panel高度
function adjustHeight(){
	var h = $('.contentPanel').height();
	$(".hospPanel").height(h);
}