$(function() {
	eventId = $('#event-id').val();
	if (tinyMCE.get('create-event-free-style') != null) {
		tinyMCE.get('create-event-free-style').remove();
	}

	tinymce.init({
		selector: '#create-event-free-style',
		plugins: [
	                 'advlist autolink link image lists charmap preview hr anchor',
	                 'searchreplace wordcount visualblocks visualchars media',
	                 'save table contextmenu directionality paste textcolor'
	             ],
		a_plugin_option: true,
		language: lang,
		language_url: '/ticketevent-web/resources/js/lib/vi_VN.js',
		a_configuration_option: 400,
		height: 600,
		toolbar: 'undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify '
			+ '| bullist numlist outdent indent | link image | preview media fullpage | forecolor backcolor',
		plugin_preview_width: $('section').width(),
		plugin_preview_height: $(window).height() - 100
	});

	//Upload Image don't crop
	var uploadImageNotCrop = function(inputImage, ouputContainner, postImageFunction) {
		var URL = window.URL || window.webkitURL;

		if (URL) {
			inputImage.change(function() {
				var $ouputImage = createDisplayHTMLOutputImageUpload();
				ouputContainner.append($ouputImage);
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
									postImageFunction(reader.result, file.name, $ouputImage);
									$ouputImage.find('img').attr("src", reader.result);
								}
							})(file);
							reader.readAsDataURL(file);
						}
					}
					inputImage.val('');
				}
			});
		}
	}

	var postImageFunctionCreateThemeFreeStyle = (function(base64, imageName, outputImage) {
		var data = [base64, imageName, eventId];
		var statusUpload = outputImage.find('.message');
		var outputUrlImage = outputImage.find('.url');
		var btnCopyUrl = outputImage.find('.btn-copy-url');
		var btnDelete = outputImage.find('.free-cus-close');
		
		var removeImage = function() {
			btnCopyUrl.click(function(e) {
	 			e.preventDefault();
	 		});
	 		
	 		var timeoutClearOutPutImage = setTimeout(function() {
	 			outputImage.slideUp('slow', function(){
	 				$(this).remove();
	 			});
	 			clearTimeout(timeoutClearOutPutImage);
	 		}, 5000);
		}

		statusUpload.text('Đang tải...');
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/upload-file-free-style",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
		    data : JSON.stringify(data)
		})
		.done(function(data) {
		 	if (data === 'fileNullError') {
		 		statusUpload.css('color', 'red');
		 		statusUpload.text('Lỗi.');
		 		showDialogError('Server không nhận được file ảnh.', 5000);
		 		removeImage();
			}else if (data === 'eventNullError') {
				window.location.replace('/ticketevent-web/error/404');
			}else if (data === 'loginError') {
				if (eventId !== '' || eventId !== undefined) {
					window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
				}
				window.location.replace('/ticketevent-web/login/create-event');
			}else {
				statusUpload.css('color', 'green');
		 		statusUpload.text('Tải thành công.');
				outputUrlImage.text(data);
			 	btnCopyUrl.removeClass('disabled');
			 	btnCopyUrl.click(function(e) {
					e.preventDefault();
					copyToClipboard($(this).parent().find('.url'));
				});
			 	btnDelete.click(function(e) {
			 		deleteImageUpload(outputImage);
				});
			}
		})
		.fail(function(xhr) {
			statusUpload.css('color', 'red');
			statusUpload.text("Tải thất bại. Dung lượng ảnh không được quá 2MB!");
			removeImage();
			if (xhr.status === 404) {
				window.location.replace('/ticketevent-web/error/404');
			}else if (xhr.status === 403) {
				window.location.replace('/ticketevent-web/error/403');
			}
		
		});
	});

	var createDisplayHTMLOutputImageUpload = function() {
		var $outputImage = $('<div>');
		$outputImage.addClass('output-image');
		$outputImage.addClass('free-cus-output-image');
		
			var $btnClose = $('<button>');
			$btnClose.attr('type', 'button');
			$btnClose.addClass('close');
			$btnClose.addClass('free-cus-close');
			$btnClose.text('x');
			
			$outputImage.append($btnClose); // outputImage > btnClose
		
			var $image = $('<img>');
			$image.addClass('col-md-6');
			$image.attr('alt', 'Image upload');
			
			$outputImage.append($image); // outputImage > image
		
			var $infoLinkImage = $('<div>');
			$infoLinkImage.addClass('col-md-6 info-image');
			
			$outputImage.append($infoLinkImage); // outputImage > infoLinkImage
			
				var $span = $('<span>');
				$span.addClass('col-md-12');
				
				$infoLinkImage.append($span); // outputImage > infoLinkImage > span
				
					var $label = $('<label>');
					$label.addClass('message');
					$label.text('Đang tải ảnh lên ...');
					
					var $url = $('<span>');
					$url.addClass('url');
					$url.addClass('invisible');
					
					$span.append($label);
					$span.append(' ');
					$span.append($url); // outputImage > infoLinkImage > span > label + ' ' + url
					
				var $btnCopyUrl = $('<a>');
				$btnCopyUrl.addClass('col-md-12 btn btn-default btn-copy-url disabled disable-href');
				$btnCopyUrl.attr('title', 'Nhấn vào đây để copy đường dẫn.');
				$btnCopyUrl.attr('href', '');
				
				$infoLinkImage.append($btnCopyUrl); // outputImage > infoLinkImage > btnCopyUrl
				
					var $iconCopy = $('<i>');
					$iconCopy.addClass('fa fa-files-o');
					$iconCopy.attr('aria-hidden', 'true');
					
					$btnCopyUrl.append($iconCopy);
					$btnCopyUrl.append(' Copy đường dẫn'); // outputImage > infoLinkImage > btnCopyUrl > iconCopy + ' Copy đường dẫn'
					
		return $outputImage;
	}

	uploadImageNotCrop($('#input-image'), $('.upload-contain'), postImageFunctionCreateThemeFreeStyle);

	var copyToClipboard = function(element) {
		var $temp = $("<input>");
		$("body").append($temp);
		$temp.val(element.text()).select();
		document.execCommand("copy");
		$temp.remove();
	}

	var deleteImageUpload = function(elementImageContain) {
		loading.showPleaseWait();
		var url = elementImageContain.find('.url').text() === '' ? null : elementImageContain.find('.url').text();
		var data = [url, eventId === undefined ? null : eventId];
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/delete-file-free-style",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
		    data : JSON.stringify(data)
		})
		.done(function(data) {
			loading.hidePleaseWait();
			if (data === 'deleteFail') {
		 		showDialogError('Ảnh không xóa được.', 5000);
			}else if (data === 'eventNullError') {
				window.location.replace('/ticketevent-web/error/404');
			}else if (data === 'loginError') {
				if (eventId !== '') {
					window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
				}
				window.location.replace('/ticketevent-web/login/create-event');
			}else {
				showDialogSuccess('Xóa ảnh thành công!', 3000);
				elementImageContain.slideUp('slow', function(){
					$(this).remove();
				});
			}
		})
		.fail(function(xhr) {
			loading.hidePleaseWait();
			showDialogError('Server error.', 5000);
			if (xhr.status === 404) {
				window.location.replace('/ticketevent-web/error/404');
			}else if (xhr.status === 403) {
				window.location.replace('/ticketevent-web/error/403');
			}
		});
	}

	var createEventFreeLayout = function() {
		loading.showPleaseWait();
		var freeLayoutModel = {
			id: $('#free-id').val(),
			eventId: eventId === '' || eventId === undefined ? null : eventId,
			content: tinyMCE.get('create-event-free-style').getContent()
		}
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/create-event-free-layout",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
		    data : JSON.stringify(freeLayoutModel)
		})
		.done(function(data) {
			loading.hidePleaseWait();
			if (data === 'sendDataError') {
		 		showDialogError('Dữ liệu truyền lên không đúng.', 5000);
			}else if (data === 'notFound') {
				window.location.replace('/ticketevent-web/error/404');
			}else if (data === 'loginError') {
				if (eventId !== '' || eventId !== undefined) {
					window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
				}
				window.location.replace('/ticketevent-web/login/create-event');
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
			showDialogError('Server error.', 5000);
			if (xhr.status === 404) {
				window.location.replace('/ticketevent-web/error/404');
			}else if (xhr.status === 403) {
				window.location.replace('/ticketevent-web/error/403');
			}
		});
	}

	$('#save-free-layout').click(function(e) {
		createEventFreeLayout();
	});

	$('.free-cus-close').click(function(e) {
		deleteImageUpload($(this).parent());
	});

	$('.btn-copy-url').click(function(e) {
		copyToClipboard($(this).parent().find('.url'));
	});

	$('.disable-href').click(function(e) {
		e.preventDefault();
	})

});