$(function() {
	
	var $form = $('#save').closest('#inputForm');
	$('.control-group .controls select[class~="required"]').after('&nbsp;<span><font color="red">*</font></span>')
	$('.control-group .controls input[class="required"]').after('&nbsp;<span><font color="red">*</font></span>')
	$('#save').click(function() {
		var url = $form.attr('action');
		var data = $form.serialize();

		if ($form.valid()) {
			$.post(url, data, function(data) {
				alert(data.data);
				if(data.status){
					window.history.go(-1);
				}
			});
		}
	})
})