/**
 * 多选combobox 当选择全部选项时,输入框显示All selected，这里替换成中文
 */

if (Ext.ux && Ext.ux.MultiCombo) {
	Ext.apply(Ext.ux.MultiCombo.prototype, {
				allSelectedText : '全部'
			});
}
Ext.Ajax.on('requestexception', function(con, resp, opt) {
			if (!opt.failure && !opt.callback) {
				Ext.Msg.tip('错误', resp.status + ':' + resp.statusText);
			}
		});

/**
 * 覆盖BasicForm setValues 方法，支持第二层次的值设置 e.g. 值={v:{v1:0}},items=[{name:'v.v1'}]
 */
Ext.override(Ext.form.BasicForm, {
			setValues : function(values) {
				if (Ext.isArray(values)) { // array of objects
					for (var i = 0, len = values.length; i < len; i++) {
						var v = values[i];
						var f = this.findField(v.id);
						if (f) {
							f.setValue(v.value);
							if (this.trackResetOnLoad) {
								f.originalValue = f.getValue();
							}
						}
					}
				} else { // object hash
					var field, id;
					for (id in values) {
						if (Ext.isObject(values[id])) {
							for (var iid in values[id]) {
								if (field = this.findField(id + '.' + iid)) {
									field.setValue(values[id][iid]);
									// 这里只设置了值
								}
							}
							continue;
						}

						if (!Ext.isFunction(values[id]) && (field = this.findField(id))) {
							field.setValue(values[id]);
							if (this.trackResetOnLoad) {
								field.originalValue = field.getValue();
							}
						}
					}
				}
				return this;
			}
		});
var msgCt;
Ext.apply(Ext.Msg, {
			tip : function(title, format) {
				format = format || '未知错误.';
				if (!msgCt) {
					msgCt = Ext.DomHelper.insertFirst(document.body, {
								id : 'msg-div'
							}, true);
				}
				msgCt.alignTo(document, 't-t');
				var m = Ext.DomHelper.append(msgCt, {
							html : ['<div class="msg">', '<div class="x-box-tl"><div class="x-box-tr"><div class="x-box-tc"></div></div></div>',
									'<div class="x-box-ml"><div class="x-box-mr"><div class="x-box-mc"><h3>', title, '</h3>', format, '</div></div></div>',
									'<div class="x-box-bl"><div class="x-box-br"><div class="x-box-bc"></div></div></div>', '</div>'].join('')
						}, true);
				m.slideIn('t').pause(Math.ceil(format.length * 150 / 1000)).ghost("t", {
							remove : true
						});
			}
		});