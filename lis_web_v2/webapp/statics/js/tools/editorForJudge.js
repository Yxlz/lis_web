var keys1= document.querySelectorAll('#calculatorForJudge span');
var input1 = document.querySelector('.screen1'); 
for(var i = 0; i < keys1.length; i++) {
	if(keys1[i].innerHTML.length<20){
		keys1[i].onclick = function(e) {
			var inputVal = input.innerText;
			var btnVal = this.innerText;
	
			if(btnVal == 'C') {
				input1.innerText = '';
			}else if(btnVal == '设置'){
				$("#editLogicalOperator").val(input1.innerText);
			}
			else {
				input1.innerText += btnVal;
			}
			e.preventDefault();
		} 
	}
}

$("#itemSelectDataForJudge").change(function() {
	input1.innerText += "["+$("#itemSelectDataForJudge").val()+"]";
	$("#itemSelectDataForJudge").val('');
	$("#itemSelectDataForJudge").options[0].selected = true;
});