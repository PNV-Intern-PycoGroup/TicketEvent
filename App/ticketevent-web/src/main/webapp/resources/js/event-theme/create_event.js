var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});

var language = $('#lang').text();
var lang = 'vi_VN';
if (language === 'Languages') {
	lang = 'en_GB';
}

/* step to create event */
var $stepOne = $('.header-control-step a[href="#ticket-info"]');
var $stepTwo = $('.header-control-step a[href="#ticket-layout"]');
var $lastStep = $('.header-control-step a[href="#ticket-setting"]');

var $outputLayoutStepOne = $('#ticket-info');
var $outputLayoutStepTwo = $('#ticket-layout');
var $outputLayoutLastStep = $('#ticket-setting');

var createEventStart = (function() {
	$.ajax({
	    type: 'GET',
	    url: "create-event-step-one"
	})
	.done(function(data) {
		hideAllTab();
		$stepOne.tab('show');
		$outputLayoutStepOne.html(data).fadeIn(500);
	})
	.fail(function() {
		showDialogError('Lỗi đường truyền.', 10000);
	});
});

var createEventStepTwo = (function() {
	if (false) {//step2 === 'error') {
 		createEventStepOne();
 		hideAllTab();
		$stepOne.tab('show');
		showDialogError('Bạn chưa nhập đầy đủ thông tin sự kiện.', 10000);
	}else{
		var sendInfo = {
			file : "abc"
		};
		$.ajax({
		    type: 'POST',
		    url: "create-event-last-step",
		    data : sendInfo
		})
		.done(function(data) {
		 	if (data === 'error') {
		 		createEventStepOne();
		 		hideAllTab();
				$stepTwo.tab('show');
				showDialogError('Giao diện cho sự kiện của bạn chưa hoàn tất.', 10000);
			}else {
				hideAllTab();
				$lastStep.tab('show');
				$outputLayoutLastStep.html(data).fadeIn(500);
			}
		}).fail(function() {
			showDialogError('Lỗi đường truyền.', 10000);
		});
	}
});

var createEventLastStep = (function() {
	var sendInfo = {
		file : "abc"
	};
	$.ajax({
	    type: 'POST',
	    url: "create-event-finish",
	    data : sendInfo
	})
	.done(function(data) {
	 	if (data === 'error') {
	 		createEventStepTwo();
	 		showDialogError('Cài đặt cho sự kiện của bạn chưa hoàn tất.', 10000);
		}else {
			showDialogError('Xin cảm ơn. Sự kiện của bạn đã được tạo thành công!'
							+ ' Xin chờ email xác nhận từ phía ticketevent.vn trong vòng 24h tới.', 10000);
		}
	}).fail(function() {
		showDialogError('Lỗi đường truyền.', 10000);
	});
});

var hideAllTab = (function() {
	$outputLayoutStepOne.css('display', 'none');
	$outputLayoutStepTwo.css('display', 'none');
	$outputLayoutLastStep.css('display', 'none');
});

var showDialogError = (function(message, time) {
	$.notify(
		{icon: 'glyphicon glyphicon-warning-sign', message: message },
		{type: "danger", delay: time}
	);
});

createEventStart();
//$stepTwo.click(function(e) {
//	createEventStepOne();
//});
//$lastStep.click(function(e) {
//	createEventStepTwo();
//});
