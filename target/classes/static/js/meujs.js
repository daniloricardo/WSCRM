$(document).ready(function(){
	$("#maria").click(function(){
		var x = document.getElementsByName("ksu");
		var tamanho = x.length;
		for(i=0;i<tamanho;i++){
			if(x[i].value == ''){
				bootbox.alert("Existem campos em branco Verifique! ");
				
				return false;	
			}
		}
		bootbox.confirm("Voc&ecirc Confirma a Opera&ccedil&atildeo? ", function(result) {
			result ?
					document.form.submit()
					
					: false;				
		});	
	})
	$("#home").click(function(){
		document.location.href='/home';
	})
	function handleEnter (field, event) {
		var keyCode = event.keyCode ? event.keyCode : event.which ? event.which : event.charCode;
		if (keyCode == 13) {
			var i;
			for (i = 0; i < field.form.elements.length; i++)
				if (field == field.form.elements[i])
					break;
			i = (i + 1) % field.form.elements.length;
			field.form.elements[i].focus();
			return false;
		} 
		else
		return true;
	}      

})
               

	