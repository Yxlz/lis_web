/**
 * 主页面JS
 */
$(document).ready(function() {
	/*$('#container').load('modules/Right.html');*/
	var tabs;
	initTabs();
	initMainTree();
	getCurrentUser();
});
function initMenu(){
	$.ajax({
		type : "Post",
		url : "../login/loadTreeMenus.do",
		dataType : "json",
		async : false,
		success : function(res) {
			result = handleMenuData(res);
			var html = createMenu(res);
			$('#cssmenu').append(html);
			},
		error : function() {
			alert('菜单加载失败');
		}
	});
}
function createMenu(res){
	var html ="<ul>";
	for (var i = 0; i < res.length; i++) {
		var id = res[i].id;
		var name = res[i].name;
		var url = res[i].url;
		if (typeof(res[i].nodes)!='undefined') {
			html+="<li class='has-sub'><a href='javascript:void(0);' id='"+id+"' name='"+url+"'>"+name+"</a>";
			html+=createMenu(res[i].nodes);
		} else {
			html+="<li><a href='javascript:void(0);' id='"+id+"' name='"+url+"'  onClick='loadContent(this.id,this.name)'>"+name+"</a>";
		}
		
	}
	html+="</li></ul>";
	return html;
};
/**
 * 生成左侧菜单 请求菜单数据
 * 图标库 https://getbootstrap.com/docs/3.3/components/
 * 菜单树API http://www.jq22.com/jquery-info10461
 */
function initMainTree(){
	$.ajax({
		type : "Post",
		url : "../login/loadTreeMenus.do",
		dataType : "json",
		success : function(result) {
			handleMenuData(result);
			changeMenuColor(result);
			setIcon(result);//当异步请求成功 ，加载菜单的图标
			$('#leftMainMenu').treeview({
				data : result, // 数据源
				highlightSelected : true, // 是否高亮选中
				expandIcon : 'glyphicon glyphicon-chevron-right',//可展开的节点图标
				collapseIcon : 'glyphicon glyphicon-chevron-down',//可收起的节点图标
				nodeIcon : '', // 节点上的图标
				borderColor:'false',
				backColor: '#696969',//设置子节点背景色
				color:'#ffffff',//设置子节点文字颜色
				onhoverColor:'#1E90FF',//设置鼠标划过时颜色
				levels : 1,
				showBorder:  true,
				multiSelect : false, // 多选
				onNodeSelected : function(event, data) {
					var url = data.href;
					var text = data.text;
					var id = data.id;
					var reporturl = data.reporturl;
					if (typeof(data.nodes)=="undefined") {//没有子节点就打开TAB
						/*if ($("#tabContainer").data("tabs").find(text)) {//根据ID查找 是否有tab激活，没有则新增
							activeTab(text);
							return;
						}else{
							addTab(id,url,text);
						}*/
						window.url_name = text;
						window.report_url = reporturl;
						addTab(id,url,text);
					}else{//有子节点则展开或收起
						$('#leftMainMenu').treeview('toggleNodeSelected', [ data.nodeId, { silent: true } ]);
						$('#leftMainMenu').treeview('toggleNodeExpanded', [ data.nodeId, { silent: true } ]);
					}
				}
			});
		},
		error : function() {
			alert('菜单加载失败');
		}
	});
}
/**
 * 生成右边TAB
 * bootstrap-tab API https://github.com/bill1012/bootstrap-tab
 */
function initTabs(){
	 tabs = $("#tabContainer").nthTabs();
/*	$("#tabContainer").tabs({
		data : [ {
			id : 'index',
			text : '首页',
			url : "",
			closeable : false
		} ],
		showIndex : 0,
		loadAll : false
	})*/
	tabs.addTab({
		id:'index',
		title:'首页',
		content:'index.html',
	})
}
/**
 * 处理菜单树的JSON数据
 * @param result
 */
function handleMenuData(result) {
	//删除空的子节点
	for (var i = 0; i < result.length; i++) {
		var sonNodeList = result[i].nodes;// 子节点List
		if (sonNodeList.length != 0) {// 判断子节点是否为空
			handleMenuData(sonNodeList);// 不为空 递归继续处理子节点
		} else {
			delete result[i].nodes;// 删除子节点为空的nodes属性 以免菜单上出现加号
		}
	}
}
/**
 * 改变菜单的颜色
 */
function changeMenuColor(result){
	for (var i = 0; i < result.length; i++) {
		result[i].color = '#ffffff';
		result[i].backColor = '#7c899d';
	}
}

/**
 * 增加TAB方法 如果存在 则切换到当前TAB页
 * @param href 页面地址
 * @param text 标题
 */
function addTab(id, url, text) {
	var list = tabs.getTabList();
	var flag = 0;
	for (var i = 0; i < list.length; i++) {
		var listid = list[i].id.replace("#","");
		if (listid == id) {
			tabs.setActTab(id);
			tabs.locationTab();
			flag = 1;
			return;
		}
	}
	if (flag=='0') {
		tabs.addTab({
			id:id,
			title:text,
			content:url,
		});
		tabs.setActTab(id);
		tabs.locationTab();
	}

}
/**
 * 激活TAB方法
 * 
 */
function activeTab(id){
	$("#tabContainer").data("tabs").showTab(id);
}
//将表单序列化  并转换成JSON对象
$.fn.serializeObject = function() {
	var o = {};
	var a = this.serializeArray();
	$.each(a, function() {
		if (o[this.name]) {
			if (!o[this.name].push) {
				o[this.name] = [ o[this.name] ];
			}
			o[this.name].push(this.value || '');
		} else {
			o[this.name] = this.value || '';
		}
	});
	return o;
}
function loadContent(id,url){
	var name = $('#'+id).text();
	window.url_name=name;
	$('#container').load(url);
}
function getCurrentUser(){
	$.ajax({
		type : "Post",
		url : "../login/getCurrUser.do",
		dataType : "json",
		success : function(result) {
				$('#currUser').append(result.msg);
			},
		});
}
/**
 * 用于判断该节点名字 设置对应图标的方法
 * @param source 图标的节点的资源
 * @param str   我们需要判断的节点名字
 * @param iconStr  我们要设置的节点图标名字
 */
function setIconByNodeText(source,str,iconStr){
	if($.trim(source.text) == $.trim(str)){
		source.icon=iconStr;
	}
}
/**
 * 用于设置菜单的图标
 * @param result 获取的菜单节点数据。
 * lsj
 */
function setIcon(result){
	for (var i = 0; i < result.length; i++) {
		setIconByNodeText(result[i],"系统管理","glyphicon glyphicon-user");
		setIconByNodeText(result[i],"统计","glyphicon glyphicon-equalizer");
		setIconByNodeText(result[i],"数据维护","glyphicon glyphicon-stats");
		setIconByNodeText(result[i],"耐药菌监测","glyphicon glyphicon-eye-open");
		setIconByNodeText(result[i],"质量控制指标统计","glyphicon glyphicon-equalizer");
		setIconByNodeText(result[i],"主任管理","glyphicon glyphicon-home");
		setIconByNodeText(result[i],"智能审核","glyphicon glyphicon-edit");
		for(var j = 0;j < result[i].nodes.length; j++){
			setIconByNodeText(result[i].nodes[j],"角色管理","glyphicon glyphicon-user");
			setIconByNodeText(result[i].nodes[j],"用户管理","glyphicon glyphicon-user");
			setIconByNodeText(result[i].nodes[j],"菜单管理","glyphicon glyphicon-th-list");
			setIconByNodeText(result[i].nodes[j],"医疗机构维护","glyphicon glyphicon-plus");
			setIconByNodeText(result[i].nodes[j],"检验全过程质量指标","glyphicon glyphicon-exclamation-sign");
			setIconByNodeText(result[i].nodes[j],"条码生成规则维护","glyphicon glyphicon-barcode");
			setIconByNodeText(result[i].nodes[j],"检验项目维护","glyphicon glyphicon-tint");
			setIconByNodeText(result[i].nodes[j],"标本容器维护","glyphicon glyphicon-glass");
			setIconByNodeText(result[i].nodes[j],"医院抗生素分析","glyphicon glyphicon-filter");
			setIconByNodeText(result[i].nodes[j],"医院感染监控","glyphicon glyphicon-eye-open");
			setIconByNodeText(result[i].nodes[j],"实验室质量控制","glyphicon glyphicon-filter");
			setIconByNodeText(result[i].nodes[j],"耐药菌株流行情况统计","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"医院耐药机制","glyphicon glyphicon-alert");
			setIconByNodeText(result[i].nodes[j],"标本错误率统计","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"血培养污染率","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"检验前周转时间","glyphicon glyphicon-dashboard");
			setIconByNodeText(result[i].nodes[j],"室内质控项目开展率统计","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"室内质控项目变异系数不合格率","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"室内质评项目不合格率","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"实验室间比对率","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"实验室内周转时间","glyphicon glyphicon-dashboard");
			setIconByNodeText(result[i].nodes[j],"检验报告不正确率","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"危急值通报率","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"危急值通报及时率","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"危急值提醒","glyphicon glyphicon-exclamation-sign");
			setIconByNodeText(result[i].nodes[j],"质控管理","glyphicon glyphicon-wrench");
			setIconByNodeText(result[i].nodes[j],"范围判断","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"历史数据对比判断","glyphicon glyphicon-dashboard");
			setIconByNodeText(result[i].nodes[j],"逻辑运算","glyphicon glyphicon-stats");
			setIconByNodeText(result[i].nodes[j],"关键字判断","glyphicon glyphicon-exclamation-sign");
			if(typeof(result[i].nodes[j].nodes)!="undefined"){
				for(var k = 0; k < result[i].nodes[j].nodes.length; k++){
					result[i].nodes[j].nodes[k].icon='glyphicon glyphicon-stats';
				}
			}
		}
	}
}
//递归
/*function setIcon(result){
	$.each(result,function(index,item1){
		  console.log(item1)
		  if(item1.nodes){
		    $.each(item1.nodes,function(index,item2){
		      console.log(item2)
		      if(item2.nodes){
		        $.each(item2.nodes,function(index,item3){
		         console.log(item3)
		        })
		      }
		    })
		  }
	 })
}*/
//用户登出
function logout() {
	Ewin.confirm({
		message : "确认要登出当前账户吗？"
	}).on(function(e) {
		if (!e) {
			return;
		}
		$.ajax({
			type : "Post",
			url : "../login/logout.do",
			dataType : "json",
			success : function(result) {
				if (result.code == "0") {
					window.location.reload();
				}
			},
		});
	})
}
//加载报表页面
function loadIframeContent(iframeName) {
	$("#" + iframeName + " iframe").html('加载中...');
	var url_name = window.url_name;// 获取全局变量
	var report_url = window.report_url;
	// 判断地址是否为空 ，为空的话去数据库lis_customsetting表查询
	if (!report_url) {
		$.ajax({
			type : "post",
			url : "../statistics/getUrl.do",
			contentType : "application/json; charset=UTF-8",
			dataType : "text",
			data : JSON.stringify({
				'url_name' : url_name
			}),
			timeout : 3000,
			cache : false,
			error : function() {
				alert("发生错误，无法加载报表")
			}, // 错误执行方法
			success : function(url) {
				console.log(url);
				$("#" + iframeName + " iframe").attr("src", url);
			}// 成功执行方法
		})
	} else {
		$("#" + iframeName + " iframe").attr("src", report_url);
	}
}