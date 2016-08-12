var eventId = $('#event-id').val();
$(function() {
	// Validation
	var eventOrganization = $('#organization-file-input');
	var eventImageThumbnail = $('#event-image-thumbnail-input');
	var thumbnailOutputImage = $('#thumbnail-output-image');
	var defaultUrlThumbnail = '';
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
	$(function() {

		var validEmty = function(element, message) {
			if (element.val() == '') {
				element.addClass('border-error');
				showDialogError(message, 8000);
			}
		}
		var validEmtySelect = function(element, message) {
			if (element.val() == '') {
				element.parent().addClass('border-error');
				showDialogError(message, 8000);
			}
		}
		
		var getNullIfEmtyvalue = function(str) {
			var result = $.trim(str) === '' ? null : str;
			return result;
		}
		
		var formatDDMMYYYYToMMDDYYY = function(DDMMYYY) {
			var splitDate = DDMMYYY.split('/');
			if (splitDate.length !== 3) {
				return '';
			}
			return splitDate[1] + '/' + splitDate[0] + '/' + splitDate[2];
		}
		
		var createEventStepOne = function() {
			loading.showPleaseWait();
			var dateStartDate = eventStartDate.val() === '' || eventStartHours.val() === '' ? null : new Date(formatDDMMYYYYToMMDDYYY(eventStartDate.val()) + ' ' + eventStartHours.val() + ':00');
			var dateEndDate = eventEndDate.val() === '' || eventEndHours.val() === '' ? null : new Date(formatDDMMYYYYToMMDDYYY(eventEndDate.val()) + ' ' + eventEndHours.val() + ':00');
			var eventTypeRelate = eventType.parent().find('li.selected');
			
			var place = eventAddress.val() === '' || eventCity.val() === '' ? null : eventAddress.val() + ', '  + eventCity.val();
			
			var imageThumbnail = thumbnailOutputImage.find('img').attr('src') === defaultUrlThumbnail ? null : thumbnailOutputImage.find('img').attr('src');
			
			var prepareImageOrganization = eventOrganization.parent().find('img').attr('src');
			var imageOrganization = prepareImageOrganization === '' ? null : prepareImageOrganization;
			
			var event = {
				id: getNullIfEmtyvalue(eventId.val()),
				name: getNullIfEmtyvalue(eventName.val()),
				introduction: getNullIfEmtyvalue(eventInfo.val()),
				eventType: ($.trim(eventTypeRelate.find('span.text').text()) === '') ? null : ({id: eventTypeRelate.attr('data-original-index'), name: eventTypeRelate.find('span.text').text()}),
				startDate: dateStartDate,
				endDate: dateEndDate,
				place: place,
				organizeName: getNullIfEmtyvalue(eventOrganizeName.val()),
				email: getNullIfEmtyvalue(eventOrganizeEmail.val()),
				phoneNumber: getNullIfEmtyvalue(eventOrganizePhoneNumber.val()),
				organizeInfo: getNullIfEmtyvalue(eventOrganizeInfo.val())
			};
			var eventContext = {
				eventModel: event,
				imageThumbnail: imageThumbnail,
				imageOrganization: imageOrganization
			}
			$.ajax({
			    type: 'POST',
			    url: "/ticketevent-web/create-event-step-two",
			    contentType : 'application/json; charset=utf-8',
		     	dataType : 'text',
	            data : JSON.stringify(eventContext)
			})
			.done(function(data) {
			 	if (data.indexOf('error|') > -1) {
					var eventId = data.split('|')[1];
					hideAllTab();
					$stepOne.tab('show');
					createEventStart(eventId);
					showDialogError('Bạn chưa điền đầy đủ thông tin sự kiện.', 5000);
					showDialogSuccess('Sự kiện của bạn đã được tạm lưu.', 5000);
				}else if(data === 'loginError') {
					if (eventId !== '') {
						window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
					}
					window.location.replace('/ticketevent-web/login/create-event');
				}else if (data === 'eventNull') {
					window.location.replace('/ticketevent-web/error/404');
				}else {
					loading.hidePleaseWait();
					$('#event-id').remove();
					showDialogSuccess('Thông tin sự kiện đã được lưu thành công.', 5000);
					hideAllTab();
					$stepTwo.tab('show');
					$outputLayoutStepTwo.html(data).fadeIn(500);
					window.scrollTo(0, 0);
					if (!$('.js-step-two').is(':empty')) {
						$('.js-step-two').remove();
					}
					$('body').append('<script class="js-step-two" src="/ticketevent-web/resources/js/event-theme/create_event_step_two.js"></script>');
				}
			}).fail(function(xhr) {
				loading.hidePleaseWait();
				if (xhr.status === 404) {
					window.location.replace('/ticketevent-web/error/404');
				}else if (xhr.status === 403) {
					window.location.replace('/ticketevent-web/error/403');
				}
			});
		};
		if (eventId.val() !== '') {
			var Valid = function(element, message, isSelect) {
				this.element = element;
				this.message = message;
				this.isSelect = isSelect;
			}
			
			var data = [];
			data.push(new Valid(eventName, 'Bạn chưa nhập tên sự kiện.', false));
			data.push(new Valid(eventType, 'Bạn chưa nhập loại sự kiện.', true));
			data.push(new Valid(eventAddress, 'Bạn chưa nhập địa chỉ.', false));
			data.push(new Valid(eventCity, 'Bạn hãy chọn tỉnh hặc thành phố đăng ký sự kiện', true));
			data.push(new Valid(eventStartDate, 'Sự kiện chưa có thời gian bắt đầu.', false));
			data.push(new Valid(eventStartHours, 'Sự kiện chưa có giờ bắt đầu.', true));
			data.push(new Valid(eventEndDate, 'Sự kiện chưa có thời gian kết thúc.', false));
			data.push(new Valid(eventEndHours, 'Sự kiện chưa có giờ kết thúc.', true));
			data.push(new Valid(eventInfo, 'Bạn chưa nhập lời giới thiệu sự kiện.', false));
			data.push(new Valid(eventOrganizeName, 'Bạn chưa nhập tên nhà tổ chức.', false));
			data.push(new Valid(eventOrganizeInfo, 'Bạn chưa nhập thông tin nhà tổ chức.', false));
			data.push(new Valid(eventOrganizePhoneNumber, 'Bạn chưa nhập số điện thoại nhà tổ chức.', false));
			data.push(new Valid(eventOrganizeEmail, 'Bạn chưa nhập email của nhà tổ chức.', false));
			
			var count = 0;
			var interval = setInterval(function() {
				var valid = data[count];
				if (valid.isSelect) {
					validEmtySelect(valid.element, valid.message);
				}else{
					validEmty(valid.element, valid.message);
				}
				count ++;
				if (data.length == count) {
					clearInterval(interval);
				}
			}, 2000);
		}
		btnSaveStepOne.click(createEventStepOne);
	});
	// End validation
	// upload organization logo

	$(function() {
		eventOrganization.change(function(e) {
			var files = this.files;
			uploadFileStepOne(files, $(this));
		});

		var uploadFileStepOne = function(files, element) {
			if (files && files.length) {
				var file = files[0];
				if (/^image\/\w+$/.test(file.type)) {
					if (file.size / 1048576 > 2) {
						showDialogError('Dung lượng ảnh không được vượt quá 2MB.', 10000);
					}else {
						var reader = new FileReader();
						reader.onload = (function(theFile) {
							return function(e) {
								element.parent().find('.ouput-image').attr('src', reader.result);
							};
						})(file);
						reader.readAsDataURL(file);
					}
				} else {
					$(this).val('');
					showDialogError('Vui lòng chọn tệp loại ảnh.', 10000);
				}
			}
		}
		uploadImageAndCrop($('#thumbnail-image'), eventImageThumbnail, thumbnailOutputImage, defaultUrlThumbnail, $('#crop-thumbnail-modal'), 1100, 400);
	});

	// End upload organization logo

	var isCheckDateValid = function() {
		var hourEnd = eventEndHours.val();
		var dateEnd = eventEndDate.val();
		var hourStart = eventStartHours.val();
		var dateStart = eventStartDate.val();
		if (hourEnd === '' || hourStart === '') {
			return true;
		}
		if (dateEnd === dateStart && hourEnd < hourStart) {
			showDialogError('Thời gian kết thúc không thể trước thời gian bắt đầu sự kiện.<br>'
							+ '--- Bắt đầu ngày: ' + dateStart + ' ' + hourStart + '<br>'
							+ '--- Kết thúc ngày: ' + dateEnd + ' ' + hourEnd, 10000);
			return false;
		}
		return true;
	}
	//Date Pịker
	eventStartDate.datepicker({
	  format: "dd/mm/yyyy",
	  language: lang,
	  autoclose: true,
	  startDate: new Date()
	});
	eventEndDate.datepicker({
	  format: "dd/mm/yyyy",
	  language: lang,
	  autoclose: true,
	  startDate: new Date()
	});
	eventStartDate.datepicker().on('changeDate', function(e) {
		eventEndDate.datepicker('setStartDate', e.date);
		if(!isCheckDateValid()){
			eventStartDate.val('');
		}
	});
	eventEndDate.datepicker().on('changeDate', function(e) {
		eventStartDate.datepicker('setEndDate', e.date);
		if(!isCheckDateValid()){
			eventEndDate.val('');
		}
	});

	// Select picker
	$('.selectpicker').selectpicker('refresh');
	eventStartHours.on('hidden.bs.select', function (e) {
		if(!isCheckDateValid()){
			$(this).val('');
			$(this).selectpicker('refresh');
		}
	});
	eventEndHours.on('hidden.bs.select', function (e) {
		if(!isCheckDateValid()){
			$(this).val('');
			$(this).selectpicker('refresh');
		}
	});
	eventCity.on('hidden.bs.select', function (e) {
		var geocoder = new google.maps.Geocoder();
		var place = (eventAddress.val() === '' || eventCity.val() === '' ? eventCity.val() : eventAddress.val() + ', '  + eventCity.val()) + ', Viet Nam';
		var checkMap = function(address) {
			geocoder.geocode( { 'address': convertVietnamese(address)}, function(results, status) {
				if (status != google.maps.GeocoderStatus.OK) {
					showDialogError('Địa điểm --' + place + '-- không phù hợp cho google map.', 5000);
					eventAddress.val('');
					eventCity.val('');
					eventCity.selectpicker('refresh');
			    }
			});
		}
		google.maps.event.addDomListener(window, 'load', checkMap(place));
	});
	
	var convertVietnamese = function (str) {  
		str= str.toLowerCase();  
		str= str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g,"a");  
		str= str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g,"e");  
		str= str.replace(/ì|í|ị|ỉ|ĩ/g,"i");  
		str= str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g,"o");  
		str= str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g,"u");  
		str= str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g,"y");  
		str= str.replace(/đ/g,"d");  
		return str;  
	}
	
});