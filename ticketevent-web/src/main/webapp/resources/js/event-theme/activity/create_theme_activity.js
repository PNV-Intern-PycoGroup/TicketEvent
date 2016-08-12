$(function() {

	eventId = $('#event-id').val();
	var addActivityBackground = $('#add-activity-background-image');
	var outputBackgroudImage = $('#output-background-image');
	var addActivityLogo = $('#add-activity-logo-image');
	var outputLogo = $('#output-logo');
	var addActivityImageLib = $('#add-activity-image-lib');
	var containerImageLib = $('#container-image-lib');
	var activitySologan = $('#activity-sologan');
	var btnSaveActivity = $('#btn-save-activity');
	var URL = window.URL || window.webkitURL;

	var libImage = '<figure class="col-md-3"><img alt="Library image upload" /></figure>';

	var uploadActivityFile = function(base64, nameFile, outputImage) {
		loading.showPleaseWait();
		var status = outputImage.parent().find('span.status');
		status.css('color', 'blue');
		status.text('Đang tải ảnh lên...');
		var data = [base64, nameFile, eventId === '' ? null : eventId];
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/upload-file-activity",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
		    data : JSON.stringify(data)
		})
		.done(function(data) {
		 	loading.hidePleaseWait();
		 	if (data === 'fileNullError') {
		 		var status = outputImage.parent().find('span.status');
				status.css('color', 'red');
				status.text('Tải lên lỗi');
		 		showDialogError('Dữ liệu gửi bị lỗi hoặc file đã tồn tại.', 5000);
			}else if (data === 'eventNullError') {
				window.location.replace('/ticketevent-web/error/404');
			}else if (data === 'loginError') {
				if (eventId !== '' || eventId !== undefined) {
					window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
				}
				window.location.replace('/ticketevent-web/login/create-event');
			}else {
				var status = outputImage.parent().find('span.status');
				status.css('color', 'green');
				status.text('Tải lên thành công');
				outputImage.attr('src', '/ticketevent-web/resources/images/' + data);
			}
		})
		.fail(function(xhr) {
			var status = outputImage.parent().find('span.status');
			status.css('color', 'red');
			status.text('Tải lên lỗi');
			loading.hidePleaseWait();
			if (xhr.status === 404) {
				window.location.replace('/ticketevent-web/error/404');
			}else if (xhr.status === 403) {
				window.location.replace('/ticketevent-web/error/403');
			}
		});
	}

	var uploadActivityImageLib = function(base64, fileName) {
		loading.showPleaseWait();
		var data = [base64, fileName, eventId === '' ? null : eventId];
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/upload-image-lib-activity",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
		    data : JSON.stringify(data)
		})
		.done(function(data) {
		 	loading.hidePleaseWait();
		 	if (data === 'fileNullError') {
		 		showDialogError('Dữ liệu gửi bị lỗi hoặc file đã tồn tại.', 5000);
			}else if (data === 'eventNullError') {
				window.location.replace('/ticketevent-web/error/404');
			}else if (data === 'loginError') {
				if (eventId !== '' || eventId !== undefined) {
					window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
				}
				window.location.replace('/ticketevent-web/login/create-event');
			}else {
				var childImage = $(libImage);
				childImage.find('img').attr('src', '/ticketevent-web/resources/images/' + data);
				containerImageLib.append(childImage);
			}
		})
		.fail(function(xhr) {
			loading.hidePleaseWait();
			if (xhr.status === 404) {
				window.location.replace('/ticketevent-web/error/404');
			}else if (xhr.status === 403) {
				window.location.replace('/ticketevent-web/error/403');
			}
		});
	}

	var validActivity = function() {
		outputBackgroudImage.parent().removeClass('border-error');
		outputLogo.parent().removeClass('border-error');
		activitySologan.removeClass('border-error');
		containerImageLib.removeClass('border-error');
		if (outputBackgroudImage.attr('src') === '') {
			outputBackgroudImage.parent().addClass('border-error');
			showDialogError('Ảnh nền của bạn chưa được tải lên.', 8000);
		}
		if (outputLogo.attr('src') === '') {
			outputLogo.parent().addClass('border-error');
			showDialogError('Ảnh logo của bạn chưa được tải lên.', 8000);
		}
		if (activitySologan.val() === '') {
			activitySologan.addClass('border-error');
			showDialogError('Sologan không được để trống.', 8000);
		}
		if (containerImageLib.find('img') === undefined) {
			containerImageLib.addClass('border-error');
			showDialogError('Thư viện ảnh của bạn phải có từ 1 đến 20 ảnh.', 8000);
		}
	}

	var createEventActivityLayout = function() {
		loading.showPleaseWait();
		var activityId = $('#activity-id');
		var data = {
			id: activityId.val() === '' ? null : activityId.val(),
			eventId: eventId === '' ? null : eventId,
			sologan: activitySologan.val() === '' ? null : activitySologan.val()
		};
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/create-event-activity-layout",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
		    data : JSON.stringify(data)
		})
		.done(function(data) {
		 	loading.hidePleaseWait();
		 	if (data === 'sendDataError') {
		 		showDialogError('Dữ liệu gửi bị lỗi.', 5000);
			}else if (data === 'notFound') {
				window.location.replace('/ticketevent-web/error/404');
			}else if (data === 'loginError') {
				if (eventId !== '' || eventId !== undefined) {
					window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
				}
				window.location.replace('/ticketevent-web/login/create-event');
			}else if (data === 'notEnough') {
				validActivity();
			}else {
				showDialogSuccess('Giao diện được lưu thành công!', 3000);
				hideAllTab();
				$lastStep.tab('show');
				$outputLayoutLastStep.html(data).fadeIn(500);
				window.scrollTo(0, 0);
				if (!$('.js-last-step').is(':empty')) {
					$('.js-last-step').remove();
				}
				$('body').append('<script class="js-last-step" src="/ticketevent-web/resources/js/event-theme/create_event_last_step.js"></script>');
			}
		})
		.fail(function(xhr) {
			loading.hidePleaseWait();
			if (xhr.status === 404) {
				window.location.replace('/ticketevent-web/error/404');
			}else if (xhr.status === 403) {
				window.location.replace('/ticketevent-web/error/403');
			}
		});
	}

	addActivityBackground.change(function() {
		var files = this.files;
		var file;
		if (files && files.length) {
			file = files[0];
			if (/^image\/\w+$/.test(file.type)) {
				if (file.size / 1048576 > 2) {
					showDialogError('Dung lượng ảnh không được vượt quá 2MB.', 10000);
				}else {
					var reader = new FileReader();
					reader.onload = (function(theFile) {
						return function(e) {
							var blobURL = URL.createObjectURL(file);
							var crop = cropModal.getCropModal(
								'img-container-1500x1000',
								'Cắt ảnh nền cho sự kiện.',
								blobURL,
								1500,
								1000,
								function() {
									var imageCropBase64 = cropModal.getImageDataBase64();
									uploadActivityFile(imageCropBase64, 'background', outputBackgroudImage);
								},
								function() {
									addActivityBackground.val('');
								});
							crop.modal();
						}
					})(file);
					reader.readAsDataURL(file);
				}
			}
			$(this).val('');
		}
	});

	addActivityLogo.change(function() {
		var files = this.files;
		var file;
		if (files && files.length) {
			file = files[0];
			if (/^image\/\w+$/.test(file.type)) {
				if (file.size / 1048576 > 2) {
					showDialogError('Dung lượng ảnh không được vượt quá 2MB.', 10000);
				}else {
					var reader = new FileReader();
					reader.onload = (function(theFile) {
						return function(e) {
							var blobURL = URL.createObjectURL(file);
							var crop = cropModal.getCropModal(
								'img-container-500x500',
								'Cắt ảnh nền cho sự kiện.',
								blobURL,
								500,
								500,
								function() {
									var imageCropBase64 = cropModal.getImageDataBase64();
									uploadActivityFile(imageCropBase64, 'logo', outputLogo);
								},
								function() {
									addActivityLogo.val('');
								});
							crop.modal();
						}
					})(file);
					reader.readAsDataURL(file);
				}
			}
			$(this).val('');
		}
	});

	addActivityImageLib.change(function() {
		var files = this.files;
		var file;
		if (files && files.length) {
			file = files[0];
			if (/^image\/\w+$/.test(file.type)) {
				if (file.size / 1048576 > 2) {
					showDialogError('Dung lượng ảnh không được vượt quá 2MB.', 10000);
				}else {
					var reader = new FileReader();
					reader.onload = (function(theFile) {
						return function(e) {
							var blobURL = URL.createObjectURL(file);
							var crop = cropModal.getCropModal(
								'img-container-800x400',
								'Cắt ảnh nền cho sự kiện.',
								blobURL,
								800,
								400,
								function() {
									var imageCropBase64 = cropModal.getImageDataBase64();
									uploadActivityImageLib(imageCropBase64, file.name);
								},
								function() {
									addActivityImageLib.val('');
								});
							crop.modal();
						}
					})(file);
					reader.readAsDataURL(file);
				}
			}
			$(this).val('');
		}
	});

	btnSaveActivity.click(function(e) {
		createEventActivityLayout();
	});
});