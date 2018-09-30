var keys = document.querySelectorAll('#calculator span');
var input = document.querySelector('.screen'); ;

for(var i = 0; i < keys.length; i++) {
	if(keys[i].innerHTML.length<20){
		keys[i].onclick = function(e) {
			var inputVal = input.innerText;
			var btnVal = this.innerText;
	
			if(btnVal == 'C') {
				input.innerText = '';
			}else if(btnVal == '设置'){
				$("#logicalOperator").val(input.innerText);
			}
			else {
				input.innerText += btnVal;
			}
			e.preventDefault();
		} 
	}
}

$("#itemSelectData").change(function() {
	input.innerText += "["+$("#itemSelectData").val()+"]";
	$("#itemSelectData").val('');
	$("#itemSelectData").options[0].selected = true;
});