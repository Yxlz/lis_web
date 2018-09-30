/**
 * 树形下拉框
 * 
 * @author lixying
 */
Ext.ns('Ext.ux');
Ext.ux.ComboBoxTree = Ext.extend(Ext.form.TriggerField, {
			constructor : function(config) {
				Ext.apply(this, config);
				this.height = this.height || 200;
				this.width = this.width || 120;
				Ext.ux.ComboBoxTree.superclass.constructor.call(this);
			},
			onRender : function(ct, position) {
				Ext.ux.ComboBoxTree.superclass.onRender.call(this, ct, position);
				this.doc = Ext.isIE ? Ext.getBody() : Ext.getDoc();
				if (!this.layer) {
					this.initLayer();
				}

				if (this.hiddenName) {
					this.hiddenField = this.el.insertSibling({
								tag : 'input',
								type : 'hidden',
								name : this.hiddenName,
								id : (this.hiddenId || Ext.id())
							}, 'before', true);

					this.el.dom.setAttribute('name', '');
				}

				this.doc.on('mousedown', this.hideTree, this);
			},
			onTriggerClick : function(a, b, c) {
				if (!this.tree) {
					this.initTree();
				}
				if (!this.isExpanded()) {
					this.restrictHeight();
				} else {
					this.hideTree(a, b, c);
				}
			},
			isExpanded : function() {
				return this.layer && this.layer.isVisible();
			},
			hideTree : function(evt, b, c) {
				var p = Ext.fly(evt.target).findParent('div.x-combobox-tree');
				if (!p) {
					this.layer.hide();
					this.doSetValue();
				}
			},
			initLayer : function() {
				var cls = 'x-combo-list', parent = Ext.getDom(document.body || Ext.getBody());
				this.layer = new Ext.Layer({
							parentEl : parent,
							shadow : 'sides',
							cls : [cls, ' x-combobox-tree'].join(' '),
							constrain : false,
							zindex : 10000
						});

				this.layer.setSize(this.width, 0);
				this.innerList = this.layer.createChild({
							cls : cls + '-inner'
						});
				this.innerList.setWidth(this.width - this.layer.getFrameWidth('lr'));
			},
			initTree : function() {
				this.tree = new Ext.tree.TreePanel({
							renderTo : this.innerList,
							useArrows : false,
							autoScroll : true,
							height : this.height,
							animate : true,
							enableDD : false,
							containerScroll : true,
							border : false,
							loader : new Ext.tree.TreeLoader({
										dataUrl : this.dataUrl
									}),
							root : {},
							rootVisible : false
						});
			},

			getValue : function() {
				if (this.valueField) {
					return Ext.isDefined(this.value) ? this.value : '';
				} else {
					return Ext.ux.ComboBoxTree.superclass.getValue.call(this);
				}
			},
			getName : function() {
				var hf = this.hiddenField;
				return hf && hf.name ? hf.name : this.hiddenName || Ext.ux.ComboBoxTree.superclass.getName.call(this);
			},

			setValue : function(v, ckt) {
				if (!Ext.isArray(v)) {
					return;
				}
				if (ckt !== true) {// 如果是手动点击的树节点，这里肯定是true，树节点已经是选中
					var vs = {};
					for (var i = 0; i < v.length; i++) {
						vs[v[i]] = 1;
					}
					if (!this.tree) {
						this.initTree();
						this.tree.getLoader().on("load", function(e, n, o) {
									this.setTreeChecked(vs, this.tree.getRootNode());
									this.doSetValue();
								}, this, v);
					} else {
						this.setTreeChecked(vs, this.tree.getRootNode());
						this.doSetValue();
					}
					return;
				}
				var display = '', value = '';
				if (v.length) {
					for (var i = 0; i < v.length; i++) {
						var n = v[i];
						display += n.text + ',';
						value += n.id + ',';
					}
				}
				this.setRawValue(display.substr(0, display.length - 1));
				this.value = value.substr(0, value.length - 1);
				if (this.hiddenField) {
					this.hiddenField.value = Ext.value(this.value, '');
				}

			},
			doSetValue : function() {
				if (!this.tree) {
					return;
				}
				var cks = this.tree.getChecked();
				if (cks)
					this.setValue(cks, true);
			},
			setTreeChecked : function(vs, node) {
				if (!this.tree) {
					return;
				}
				if (!node.loaded) {
					node.expand();
				}
				if (node.attributes.checked != undefined) {
					if (node.id in vs) {
						node.getUI().checkbox.checked = true;
						node.attributes.checked = true;
					} else {
						node.getUI().checkbox.checked = false;
						node.attributes.checked = false;
					}
				}
				if (node.hasChildNodes()) {
					node.eachChild(function(n) {
								this.setTreeChecked(vs, n);
							}, this);
				}

			},
			restrictHeight : function() {
				this.innerList.dom.style.height = '';
				var inner = this.innerList.dom, pad = this.layer.getFrameWidth('tb'), h = Math.max(inner.clientHeight, inner.offsetHeight, inner.scrollHeight);

				this.innerList.setHeight(h);
				this.layer.beginUpdate();
				this.layer.setHeight(h + pad);
				this.layer.alignTo.apply(this.layer, [this.el].concat(this.layerAlign));
				this.layer.show();
				this.layer.endUpdate();
			}

		});
Ext.reg('combotree', Ext.ux.ComboBoxTree);