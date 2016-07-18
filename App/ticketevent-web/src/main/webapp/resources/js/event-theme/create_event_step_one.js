$stepOne.click(function(e) {
	createEventStart();
});
// Validation

$(function() {
	var isExistEventInfo = $('#is-exist-event-info');
	var eventId = $('#event-id');
	var eventName = $('#event-name');
	var eventType = $('#event-type');
	var eventAddress = $('#event-address');
	var eventCity = $('#event-city');
	var eventStartDate = $('#event-start-date');
	var eventStartHours = $('#event-start-hours');
	var eventEndDate = $('#event-end-date');
	var eventEndHours = $('#event-end-hours');
	var eventInfo = $('#event-info');
	var eventOrganizeName = $('#event-organize-name');
	var eventOrganizeInfo = $('#event-organize-info');
	var eventOrganizePhoneNumber = $('#event-organize-phone-number');
	var eventOrganizeEmail = $('#event-organize-email');
	var btnSaveStepOne = $('#btn-save-step-one');
	
	var validEmty = function(element) {
		if (element.val() == '') {
			element.addClass('border-error');
		}
	}
	
	var formatDDMMYYYYToMMDDYYY = function(DDMMYYY) {
		var splitDate = DDMMYYY.split('/');
		if (splitDate.length !== 3) {
			return '';
		}
		return splitDate[1] + '/' + splitDate[0] + '/' + splitDate[2];
	}
	var dateStartDate = new Date(formatDDMMYYYYToMMDDYYY(eventStartDate.val()) + ' ' + eventStartHours.val() + ':00');
	
	var dateEndDate = new Date(formatDDMMYYYYToMMDDYYY(eventEndDate.val()) + ' ' + eventEndHours.val() + ':00');
	
	var event = {
		id: eventId.val(),
		name: eventName.val(),
		introduction: eventInfo.text(),
		eventType: {id: eventType.val(), name: eventType.find('option[selected]').text()},
		startDate: null, //dateStartDate.toString(),
		endDate: null, //dateEndDate.toString(),
		place: eventAddress.val() + ', ' + eventCity.find('option[selected]').val(),
		organizeName: eventOrganizeName.val(),
		email: eventOrganizeEmail.val(),
		phoneNumber: eventOrganizePhoneNumber.val(),
		organizeInfo: eventOrganizeInfo.text(),
		imageThumbnail: ''
	};
	var createEventStepOne = (function() {
		$.ajax({
		    type: 'POST',
		    url: "create-event-step-two",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
            data : JSON.stringify(event)
		})
		.done(function(data) {
		 	if (data === 'error') {
		 		hideAllTab();
				$stepOne.tab('show');
		 		createEventStart();
		 		showDialogError('Bạn chưa nhập đầy đủ thông tin sự kiện.', 10000);
			}else {
				hideAllTab();
				$stepTwo.tab('show');
				$outputLayoutStepTwo.html(data).fadeIn(500);
			}
		}).fail(function() {
			showDialogError('Lỗi đường truyền.', 10000);
		});
	});
	
	if (isExistEventInfo.val() !== '') {
		showDialogError('Thông tin sự kiện bạn điền chưa đầy đủ.', 10000);
		validEmty(eventName);
		validEmty(eventType);
		validEmty(eventAddress);
		validEmty(eventCity);
		validEmty(eventStartDate);
		validEmty(eventStartHours);
		validEmty(eventEndDate);
		validEmty(eventEndHours);
		validEmty(eventInfo);
		validEmty(eventOrganizeName);
		validEmty(eventOrganizeInfo);
		validEmty(eventOrganizePhoneNumber);
		validEmty(eventOrganizeEmail);
		
		btnSaveStepOne.click(createEventStepOne);
	}
});
// End validation

//Date Pịker

$('.date-select').datepicker({
  format: "dd/mm/yyyy",
  language: 'vi'
});

$('.selectpicker').selectpicker('refresh');