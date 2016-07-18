$('.choose-layout').click(function(e) {
	var data = $('.select-layout:not(.btn-group)').val() == "" ? "none" : $('.select-layout:not(.btn-group)').val();
	
	var sendInfo = {
		layout : data
	};
	$.ajax({
	    type: 'POST',
	    url: "create-event-upload-image",
	    data : sendInfo
    })
    .done(function(data) {
    	if (data === 'error') {
    		showDialogMessage('Giao diện bạn chọn không đúng.');
    	}else {
    		$('#ticket-layout').hide().html(data).fadeIn(500);
    	}
	})
    .fail(function() {
    	$('.create-theme-make-error').hide().text("Hãy chọn một giao diện cho sự kiện của bạn").slideDown("slow");
	});
});

$('.selectpicker').selectpicker('refresh');
