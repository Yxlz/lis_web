/**
 * 带清空按钮的日期控件
 */

Ext.apply(Ext.DatePicker.prototype, {
    resetText : '清空',
    showReset : false,
    resetTip : '',
    selectReset : function(){
        if(this.resetBtn && !this.resetBtn.disabled)
        {
            this.setValue(new Date().clearTime());
            this.fireEvent('select', this, 'Selected');
        }
    },
    onRender : function(container, position){
        var m = [
             '<table cellspacing="0">',
                '<tr><td class="x-date-left"><a href="#" title="', this.prevText ,'"> </a></td><td class="x-date-middle" align="center"></td><td class="x-date-right"><a href="#" title="', this.nextText ,'"> </a></td></tr>',
                '<tr><td colspan="3"><table class="x-date-inner" cellspacing="0"><thead><tr>'],
                dn = Ext.DatePicker.prototype.dayNames,
                i;
        for(i = 0; i < 7; i++){
            var d = this.startDay+i;
            if(d > 6){
                d = d-7;
            }
            m.push('<th><span>', dn[d].substr(0,1), '</span></th>');
        }
        m[m.length] = '</tr></thead><tbody><tr>';
        for(i = 0; i < 42; i++) {
            if(i % 7 === 0 && i !== 0){
                m[m.length] = '</tr><tr>';
            }
            m[m.length] = '<td><a href="#" hidefocus="on" class="x-date-date" tabIndex="1"><em><span></span></em></a></td>';
        }
        m.push('</tr></tbody></table></td></tr>',
  
                this.showToday || this.showReset ? '<tr><td colspan="3" class="x-date-bottom" align="center"><div style="overflow:auto;width:78px;text-align:center;">' : "",
                this.showToday ? '<div class="x-date-bottom1" style="float:left;overflow:auto;"></div>' : '',
                this.showReset ? '<div class="x-date-bottom2" style="float:right;overflow:auto;"></div>' : '',
                this.showToday || this.showReset ? '</div></td></tr>' : "",
  
                '</table><div class="x-date-mp"></div>');
  
        var el = document.createElement('div');
  
  
  
        el.className = 'x-date-picker';
        el.innerHTML = m.join('');
  
        container.dom.insertBefore(el, position);
  
        this.el = Ext.get(el);
        this.eventEl = Ext.get(el.firstChild);
  
        this.prevRepeater = new Ext.util.ClickRepeater(this.el.child('td.x-date-left a'), {
            handler: this.showPrevMonth,
            scope: this,
            preventDefault:true,
            stopDefault:true
        });
  
        this.nextRepeater = new Ext.util.ClickRepeater(this.el.child('td.x-date-right a'), {
            handler: this.showNextMonth,
            scope: this,
            preventDefault:true,
            stopDefault:true
        });
  
        this.monthPicker = this.el.down('div.x-date-mp');
        this.monthPicker.enableDisplayMode('block');
  
        this.keyNav = new Ext.KeyNav(this.eventEl, {
            'left' : function(e){
                if(e.ctrlKey){
                    this.showPrevMonth();
                }else{
                    this.update(this.activeDate.add('d', -1));
                }
            },
  
            'right' : function(e){
                if(e.ctrlKey){
                    this.showNextMonth();
                }else{
                    this.update(this.activeDate.add('d', 1));
                }
            },
  
            'up' : function(e){
                if(e.ctrlKey){
                    this.showNextYear();
                }else{
                    this.update(this.activeDate.add('d', -7));
                }
            },
  
            'down' : function(e){
                if(e.ctrlKey){
                    this.showPrevYear();
                }else{
                    this.update(this.activeDate.add('d', 7));
                }
            },
  
            'pageUp' : function(e){
                this.showNextMonth();
            },
  
            'pageDown' : function(e){
                this.showPrevMonth();
            },
  
            'enter' : function(e){
                e.stopPropagation();
                return true;
            },
  
            scope : this
        });
  
        this.el.unselectable();
  
        this.cells = this.el.select('table.x-date-inner tbody td');
        this.textNodes = this.el.query('table.x-date-inner tbody span');
  
        this.mbtn = new Ext.Button({
            text: ' ',
            tooltip: this.monthYearText,
            renderTo: this.el.child('td.x-date-middle', true)
        });
        this.mbtn.el.child('em').addClass('x-btn-arrow');
  
        if(this.showToday){
            this.todayKeyListener = this.eventEl.addKeyListener(Ext.EventObject.SPACE, this.selectToday,  this);
            var today = (new Date()).dateFormat(this.format);
            this.todayBtn = new Ext.Button({
                renderTo: this.el.child('div.x-date-bottom1', true),
                text: String.format(this.todayText, today),
                tooltip: String.format(this.todayTip, today),
                handler: this.selectToday,
                scope: this
            });
        }
        if(this.showReset){
            //this.resetKeyListener = this.eventEl.addKeyListener(Ext.EventObject.SPACE, this.selectReset,  this);
            //var today = (new Date()).dateFormat(this.format);
            this.resetBtn = new Ext.Button({
                renderTo: this.el.child('div.x-date-bottom2', true),
                text: this.resetText,
                tooltip: this.resetTip,
                handler: this.selectReset,
                scope: this
            });
        }
        this.mon(this.eventEl, 'mousewheel', this.handleMouseWheel, this);
        this.mon(this.eventEl, 'click', this.handleDateClick,  this, {delegate: 'a.x-date-date'});
        this.mon(this.mbtn, 'click', this.showMonthPicker, this);
        this.onEnable(true);
    }
});
  
/* reset datefield component */
Ext.ux.ResetDateField = Ext.extend(Ext.form.DateField, {
    isStart: true,
    showReset: true,
    reset_trg_class: 'x-form-clear-trigger',
    initComponent: function() {
        this.triggerConfig = { 
            tag:'span', cls:'x-form-twin-triggers', cn:[ 
            {tag: "img", src: Ext.BLANK_IMAGE_URL, cls: "x-form-trigger x-form-date-trigger"}//,
            //{tag: "img", src: Ext.BLANK_IMAGE_URL, cls: "x-form-trigger " + this.reset_trg_class}
        ]}; 
        Ext.ux.ResetDateField.superclass.initComponent.call(this);
    },
    getTrigger: Ext.form.TwinTriggerField.prototype.getTrigger, 
    initTrigger: Ext.form.TwinTriggerField.prototype.initTrigger,
    onTriggerClick :function(){
        if(this.disabled){
            return;
        }
        if(this.menu == null){
            this.menu = new Ext.menu.DateMenu({
                hideOnClick: false,
                focusOnSelect: false,
                showReset:true
            });
        }
        this.onFocus();
        Ext.apply(this.menu.picker,  {
            minDate : this.minValue,
            maxDate : this.maxValue,
            disabledDatesRE : this.disabledDatesRE,
            disabledDatesText : this.disabledDatesText,
            disabledDays : this.disabledDays,
            disabledDaysText : this.disabledDaysText,
            format : this.format,
            showToday : this.showToday,
            startDay: this.startDay,
            showReset: this.showReset,
            minText : String.format(this.minText, this.formatDate(this.minValue)),
            maxText : String.format(this.maxText, this.formatDate(this.maxValue))
        });
        this.menu.picker.setValue(this.getValue() || new Date());
        this.menu.show(this.el, "tl-bl?");
        this.menuEvents('on');
    },
    onTrigger1Click:function(){
        if(this.disabled){
            return;
        }
        if(this.menu == null){
            this.menu = new Ext.menu.DateMenu({
                hideOnClick: false,
                focusOnSelect: false,
                showReset:true
            });
        }
        this.onFocus();
        Ext.apply(this.menu.picker,  {
            minDate : this.minValue,
            maxDate : this.maxValue,
            disabledDatesRE : this.disabledDatesRE,
            disabledDatesText : this.disabledDatesText,
            disabledDays : this.disabledDays,
            disabledDaysText : this.disabledDaysText,
            format : this.format,
            showToday : this.showToday,
            startDay: this.startDay,
            showReset: this.showReset,
            minText : String.format(this.minText, this.formatDate(this.minValue)),
            maxText : String.format(this.maxText, this.formatDate(this.maxValue))
        });
        this.menu.picker.setValue(this.getValue() || new Date());
        this.menu.show(this.el, "tl-bl?");
        this.menuEvents('on');
    },
    onTrigger2Click: function(e){ 
        this.reset( );
    }
    
});
Ext.reg('ResetDateField', Ext.ux.ResetDateField);