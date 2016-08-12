$(function() {
	eventId = $('#event-id').val();
	var selectLayout = $('#select-layout');
	var btnSelectLayout = $('.choose-layout');

	btnSelectLayout.click(function(e) {
		loading.showPleaseWait();
		var layoutId = selectLayout.val() === '' ? 0 : selectLayout.val();
		var data = [layoutId, eventId];
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/create-event-layout",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
		    data : JSON.stringify(data)
	    })
	    .done(function(data) {
	    	loading.hidePleaseWait();
	    	if (data === 'error') {
	    		showDialogError('Giao diện bạn chọn không đúng.', 5000);
	    	}else if (data === 'sendDataError') {
	    		showDialogError('Dữ liệu gửi đi không tốt.', 5000);
			}else {
	    		$('#ticket-layout').hide().html(data).fadeIn(500);
				window.scrollTo(0, 0);
	    	}
		})
	    .fail(function(xhr) {
	    	loading.hidePleaseWait();
	    	showDialogError('Hãy chọn giao diện cho sự kiện của bạn.', 5000);
	    	if (xhr.status === 404) {
				window.location.replace('/ticketevent-web/error/404');
			}else if (xhr.status === 403) {
				window.location.replace('/ticketevent-web/error/403');
			}
		});
	});

	$('.selectpicker').selectpicker('refresh');

});