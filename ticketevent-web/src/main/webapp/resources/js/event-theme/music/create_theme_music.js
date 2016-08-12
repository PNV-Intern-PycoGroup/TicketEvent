$(function() {
	eventId = $('#event-id').val();
	var musicId = $('#music-id').val();
	var addMusicBanner = $('#add-music-banner-image');
	var outputBannerImage = $('#output-banner-image');
	var addMusicPlace = $('#add-music-place-image');
	var outputPlaceImage = $('#output-place-image');
	var addMusicImageLib = $('#add-music-image-lib');
	var containerImageLib = $('#container-image-lib');
	var musicLinkHighlight = $('#music-link-highlight');
	var containerFamousPerson = $('#contain-famous-person');
	var btnAddFamousPerson = $('#add-famous-person');
	var btnSaveMusic = $('#btn-save-music');
	var URL = window.URL || window.webkitURL;

	var libImage = '<figure class="col-md-3"><img alt="Library image upload" /></figure>';
	Date.prototype.toString = function() {
	  var result = (this.getDate() < 10 ? '0' : '') + this.getDate() + '/' + (this.getMonth() < 9 ? '0' : '') + (this.getMonth() + 1) + '/' + this.getFullYear() ;
	  return result;
	}

	var uploadMusicFile = function(base64, nameFile, outputImage) {
		loading.showPleaseWait();
		var status = outputImage.parent().find('span.status');
		status.css('color', 'blue');
		status.text('Đang tải ảnh lên...');
		var data = [base64, nameFile, eventId === '' ? null : eventId];
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/upload-file-music",
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

	var uploadMusicImageLib = function(base64, fileName) {
		loading.showPleaseWait();
		var data = [base64, fileName, eventId === '' ? null : eventId];
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/upload-image-lib-music",
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

	addMusicBanner.change(function() {
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
								'img-container-1500x500',
								'Cắt ảnh banner cho sự kiện.',
								blobURL,
								1500,
								500,
								function() {
									var imageCropBase64 = cropModal.getImageDataBase64();
									uploadMusicFile(imageCropBase64, 'banner', outputBannerImage);
								},
								function() {
									addMusicBanner.val('');
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

	addMusicPlace.change(function() {
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
								'img-container-1500x600',
								'Cắt ảnh nơi tổ chức cho sự kiện.',
								blobURL,
								1500,
								600,
								function() {
									var imageCropBase64 = cropModal.getImageDataBase64();
									uploadMusicFile(imageCropBase64, 'place', outputPlaceImage);
								},
								function() {
									addMusicPlace.val('');
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

	addMusicImageLib.change(function() {
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
								'img-container-1500x500',
								'Cắt ảnh thư viện ảnh cho sự kiện.',
								blobURL,
								1500,
								500,
								function() {
									var imageCropBase64 = cropModal.getImageDataBase64();
									uploadMusicImageLib(imageCropBase64, file.name);
								},
								function() {
									addMusicImageLib.val('');
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

	var newFamousPerson;
	newFamousPerson = newFamousPerson || (function () {

		var newFamousPersonHtml="";
		newFamousPersonHtml += "<div class=\"modal fade\" id=\"new-famous-person-modal\" data-backdrop=\"static\" role=\"dialog\" aria-labelledby=\"modalLabel\" tabindex=\"-1\">";
		newFamousPersonHtml += "  <div class=\"modal-dialog modal-lg\" role=\"document\">";
		newFamousPersonHtml += "    <div class=\"modal-content\">";
		newFamousPersonHtml += "      <div class=\"modal-header\">";
		newFamousPersonHtml += "        <button type=\"button\" class=\"close crop-none\" data-dismiss=\"modal\" aria-label=\"Close\">";
		newFamousPersonHtml += "        	<span aria-hidden=\"true\">&times;<\/span>";
		newFamousPersonHtml += "    	<\/button>";
		newFamousPersonHtml += "        <h4 class=\"modal-title\" id=\"modalLabel\"><\/h4>";
		newFamousPersonHtml += "      <\/div>";
		newFamousPersonHtml += "      <div class=\"modal-body\">";
		newFamousPersonHtml += "        <div class=\"col-md-12\">";
		newFamousPersonHtml += "			<figure id=\"contain-famous-person-image\" class=\"col-md-3\">";
		newFamousPersonHtml += "				<input type=\"file\" id=\"input-famous-person-image\" class=\"hidden-file input-image\"\/>";
		newFamousPersonHtml += "				<img id=\"output-famous-person-image\" alt=\"famous person\" src=\"\"\/>";
		newFamousPersonHtml += "			<\/figure>";
		newFamousPersonHtml += "			<div class=\"col-md-9\">";
		newFamousPersonHtml += "				<div class=\"input-group col-md-12 cus-input-group-theme-music\">";
		newFamousPersonHtml += "					<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music\">Nghệ danh<\/span>";
		newFamousPersonHtml += "					<input id=\"name-famous-person\" type=\"text\" class=\"form-control cus-form-control-theme-study\" \/>";
		newFamousPersonHtml += "				<\/div>";
		newFamousPersonHtml += "				<div class=\"input-group col-md-12 cus-input-group-theme-music\">";
		newFamousPersonHtml += "					<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music\">Ngày sinh<\/span>";
		newFamousPersonHtml += "					<input id=\"date-of-birth-famous-person\" type=\"text\" class=\"form-control cus-form-control-theme-music\" \/>";
		newFamousPersonHtml += "				<\/div>";
		newFamousPersonHtml += "				<div class=\"cus-event-info-theme-music\">";
		newFamousPersonHtml += "					<span class=\"label-event-info cus-input-group-addon-create-event\">Giới thiệu hoặc mô tả đôi nét về diễn giả<\/span>";
		newFamousPersonHtml += "					<textarea id=\"introduction-famous-person\" class=\"textarea-event-info\" ><\/textarea>";
		newFamousPersonHtml += "				<\/div>";
		newFamousPersonHtml += "			<\/div>";
		newFamousPersonHtml += "		<\/div>";
		newFamousPersonHtml += "		<div class=\"clear\"><\/div>";
		newFamousPersonHtml += "      <\/div>";
		newFamousPersonHtml += "      <div class=\"modal-footer\">";
		newFamousPersonHtml += "        <button id=\"save-famous-person\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Save<\/button>";
		newFamousPersonHtml += "        <button type=\"button\" class=\"btn btn-default crop-none\" data-dismiss=\"modal\">Close<\/button>";
		newFamousPersonHtml += "        <input type=\"hidden\" id=\"famous-person-id\" \/>";
		newFamousPersonHtml += "      <\/div>";
		newFamousPersonHtml += "    <\/div>";
		newFamousPersonHtml += "  <\/div>";
		newFamousPersonHtml += "<\/div>";

		var famousPersonModalDiv = $(newFamousPersonHtml);
		var titleModal = famousPersonModalDiv.find('#modalLabel');
		var inputFamousPersonImage = famousPersonModalDiv.find('#input-famous-person-image');
		var outputFamousPersonImage = famousPersonModalDiv.find('#output-famous-person-image');
		var nameFamousPerson = famousPersonModalDiv.find('#name-famous-person');
		var dateOfBirthFamousPerson = famousPersonModalDiv.find('#date-of-birth-famous-person');
		var introductionFamousPerson = famousPersonModalDiv.find('#introduction-famous-person');
		var famousPersonId = famousPersonModalDiv.find('#famous-person-id');
		var saveFamousPerson = famousPersonModalDiv.find('#save-famous-person');

		var width = 1500;
		var height = 500;
		
		var resetValue = function() {
			titleModal.text('');
			inputFamousPersonImage.val('');
			outputFamousPersonImage.attr('src', '');
			nameFamousPerson.val('');
			dateOfBirthFamousPerson.val('');
			introductionFamousPerson.val('');
			famousPersonId.val('');
		}
		
		inputFamousPersonImage.change(function(e) {
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
									'img-container-1500x500',
									'Cắt ảnh thư viện ảnh cho sự kiện.',
									blobURL,
									width,
									height,
									function() {
										var imageCropBase64 = cropModal.getImageDataBase64();
										outputFamousPersonImage.attr('src', imageCropBase64);
									},
									function() {
										inputFamousPersonImage.val('');
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
		
		var convertDateDDMMYYYToMMDDYYY = function(dateString) {
			var tempSplit = dateString.split('/');
			var result = tempSplit[1] + '/' + tempSplit[0] + '/' + tempSplit[2];
			return result;
		}
		var canvasImage = document.createElement('canvas');
			$(canvasImage).width(width).height(height);
			var imgCanvas = new Image();
		    var ctxCanvas;
		var data;
	    var session = false;
	    return {
	        addFamousPersonModal: function(title, funcSaveCallBack, funcHiddenModalCallBack) {
	        	resetValue();
	        	titleModal.text(title);
	        	dateOfBirthFamousPerson.datepicker({
	        		startView: 2,
	        		endDate: 'today',
	        		format: "dd/mm/yyyy",
	        		language: lang,
	        		autoclose: true
	        	});
	        	
	        	var eventSaveFamousPerson = function(e) {
	        		if (session) {
	        		    data = {
	    		    		id: famousPersonId.val() === '' ? null : famousPersonId.val(),
	    		    		musicLayout: musicId === '' ? null : {id: musicId, eventId: eventId === '' ? null : eventId},
	    		    		image: outputFamousPersonImage.attr('src') === '' ? null : outputFamousPersonImage.attr('src'),
	    		    		name: nameFamousPerson.val() === '' ? null : nameFamousPerson.val(),
	    		    		dateOfBirth: dateOfBirthFamousPerson.val() === '' ? null : new Date(convertDateDDMMYYYToMMDDYYY(dateOfBirthFamousPerson.val())),
	    		    		introduction: introductionFamousPerson.val() === '' ? null : introductionFamousPerson.val()
	    		    	}
	        			funcSaveCallBack();
	            		session = false;
					}
		        	saveFamousPerson.unbind('click', eventSaveFamousPerson);
	        	}
	        	saveFamousPerson.bind('click', eventSaveFamousPerson);
	        	
	        	var eventHideModal = function () {
	        		funcHiddenModalCallBack();
	        		session = false;
		        	famousPersonModalDiv.unbind('hidden.bs.modal', eventHideModal);
	        	}
	        	famousPersonModalDiv.bind('hidden.bs.modal', eventHideModal);
	        	
	        	var eventShowModal = function () {
	            	session = true;
		        	famousPersonModalDiv.unbind('shown.bs.modal', eventShowModal);
	        	}
	        	famousPersonModalDiv.bind('shown.bs.modal', eventShowModal);
	        	return famousPersonModalDiv;
	        },
	        editFamousPersonModal: function(famousPerson, title, funcSaveCallBack, funcHiddenModalCallBack) {
	        	famousPersonId.val(famousPerson.id);
	        	outputFamousPersonImage.attr('src', famousPerson.image);
	        	nameFamousPerson.val(famousPerson.name);
	        	dateOfBirthFamousPerson.val(famousPerson.dateOfBirth);
	        	introductionFamousPerson.val(famousPerson.introduction);
	        	titleModal.text(title);
	        	dateOfBirthFamousPerson.datepicker({
	        		startView: 2,
	        		format: "dd/mm/yyyy",
	        		language: lang,
	        		autoclose: true
	        	});
	        	

	        	var eventSaveFamousPerson = function(e) {
	        		if (session) {
	        		    data = {
	    		    		id: famousPersonId.val() === '' ? null : famousPersonId.val(),
	    		    		musicLayout: musicId === '' ? null : {id: musicId, eventId: eventId === '' ? null : eventId},
	    		    		image: outputFamousPersonImage.attr('src') === '' ? null : outputFamousPersonImage.attr('src'),
	    		    		name: nameFamousPerson.val() === '' ? null : nameFamousPerson.val(),
	    		    		dateOfBirth: dateOfBirthFamousPerson.val() === '' ? null : new Date(convertDateDDMMYYYToMMDDYYY(dateOfBirthFamousPerson.val())),
	    		    		introduction: introductionFamousPerson.val() === '' ? null : introductionFamousPerson.val()
	    		    	}
	        			funcSaveCallBack();
	            		session = false;
					}
		        	saveFamousPerson.unbind('click', eventSaveFamousPerson);
	        	}
	        	saveFamousPerson.bind('click', eventSaveFamousPerson);
	        	
	        	var eventHideModal = function () {
	        		funcHiddenModalCallBack();
	        		session = false;
		        	famousPersonModalDiv.unbind('hidden.bs.modal', eventHideModal);
	        	}
	        	famousPersonModalDiv.bind('hidden.bs.modal', eventHideModal);
	        	
	        	var eventShowModal = function () {
	            	session = true;
		        	famousPersonModalDiv.unbind('shown.bs.modal', eventShowModal);
	        	}
	        	famousPersonModalDiv.bind('shown.bs.modal', eventShowModal);
	        	return famousPersonModalDiv;
	        },
	        getData: function() {
				return data;
			}
	    };
	})();
	var renderFamousPersonFactory;
	renderFamousPersonFactory = renderFamousPersonFactory || (function () {

		var childFamousPersonHtml="";
		childFamousPersonHtml += "<div class=\"col-md-12\">";
		childFamousPersonHtml += "	<figure class=\"col-md-3\">";
		childFamousPersonHtml += "		<img class=\"render-famous-person-image\" alt=\"famous person\" src=\"\">";
		childFamousPersonHtml += "	<\/figure>";
		childFamousPersonHtml += "	<div class=\"col-md-9\">";
		childFamousPersonHtml += "		<div class=\"input-group col-md-12 cus-input-group-theme-music\">";
		childFamousPersonHtml += "			<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music\">Nghệ danh<\/span>";
		childFamousPersonHtml += "			<span class=\"form-control cus-form-control-theme-study render-famous-person-name\" ><\/span>";
		childFamousPersonHtml += "		<\/div>";
		childFamousPersonHtml += "		<div class=\"input-group col-md-12 cus-input-group-theme-music\">";
		childFamousPersonHtml += "			<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-music\">Ngày sinh<\/span>";
		childFamousPersonHtml += "			<span class=\"form-control cus-form-control-theme-music render-famous-person-dob\" ><\/span>";
		childFamousPersonHtml += "		<\/div>";
		childFamousPersonHtml += "		<div class=\"cus-event-info-theme-music\">";
		childFamousPersonHtml += "			<span class=\"label-event-info cus-input-group-addon-create-event\">Giới thiệu hoặc mô tả đôi nét về diễn giả<\/span>";
		childFamousPersonHtml += "			<p class=\"textarea-event-info render-famous-person-introduction\" ><\/p>";
		childFamousPersonHtml += "		<\/div>";
		childFamousPersonHtml += "	<\/div>";
		childFamousPersonHtml += "	<input class=\"render-famous-person-id\" type=\"hidden\" \/>";
		childFamousPersonHtml += "	<div class=\"clear\"><\/div>";
		childFamousPersonHtml += "	<hr class=\"divider\">";
		childFamousPersonHtml += "<\/div>";
	    return {
	        getRenderFamousPerson: function(famousPerson) {
	        	var famousPersonDiv = $(childFamousPersonHtml);
	        	var renderImage = famousPersonDiv.find('.render-famous-person-image');
	        	var renderName = famousPersonDiv.find('.render-famous-person-name');
	        	var renderDOB = famousPersonDiv.find('.render-famous-person-dob');
	        	var renderIntroduction = famousPersonDiv.find('.render-famous-person-introduction');
	        	var renderId = famousPersonDiv.find('.render-famous-person-id');
	        	
	        	renderId.val(famousPerson.id);
	        	renderImage.attr('src', '/ticketevent-web/resources/images/' + famousPerson.image);
	        	renderName.text(famousPerson.name);
	        	renderDOB.text(new Date(famousPerson.dateOfBirth).toString());
	        	console.log(new Date(famousPerson.dateOfBirth).toString());
	        	renderIntroduction.text(famousPerson.introduction);
	        	return famousPersonDiv;
	        }
	    };
	})();

	var addFamousPersonIntoData = function(famousPerson) {
		loading.showPleaseWait();
		var musicLayoutFamousPerson = famousPerson;
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/create-famous-person-music",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
		    data : JSON.stringify(musicLayoutFamousPerson)
		})
		.done(function(data) {
		 	loading.hidePleaseWait();
		 	if (data === 'dataSendError') {
		 		showDialogError('Dữ liệu gửi bị lỗi. Nguyên nhân có thể do bạn nhập chưa đủ thông tin', 5000);
			}else if (data === 'notFound') {
				window.location.replace('/ticketevent-web/error/404');
			}else if (data === 'loginError') {
				if (eventId !== '' || eventId !== undefined) {
					window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
				}
				window.location.replace('/ticketevent-web/login/create-event');
			}else if (data === 'convertJsonError') {
				showDialogError('Server lỗi', 5000);
			}else {
				var famousPersonGetData = JSON.parse(data);
				var childFamousPerson = renderFamousPersonFactory.getRenderFamousPerson(famousPersonGetData);
				containerFamousPerson.append(childFamousPerson);
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

	var validMusic = function() {
		outputBannerImage.parent().removeClass('border-error');
		outputPlaceImage.parent().removeClass('border-error');
		btnAddFamousPerson.removeClass('border-error');
		addMusicImageLib.parent().removeClass('border-error');
		musicLinkHighlight.removeClass('border-error');
		if (outputBannerImage.attr('src') === '') {
			outputBannerImage.parent().addClass('border-error');
			showDialogError('Ảnh banner của bạn chưa được tải lên.', 8000);
		}
		if (outputPlaceImage.attr('src') === '') {
			outputPlaceImage.parent().addClass('border-error');
			showDialogError('Ảnh nơi tổ chức sự kiện của bạn chưa được tải lên.', 8000);
		}
		if (containerFamousPerson.find('figure').length == 0) {
			btnAddFamousPerson.addClass('border-error');
			showDialogError('Bạn hãy thêm ít nhất một nhân vật nỗi bật cho sự kiện của bạn.', 8000);
		}
		if (containerImageLib.find('figure').length == 0) {
			addMusicImageLib.parent().addClass('border-error');
			showDialogError('Bạn hãy thêm ít nhất một ảnh cho thư viện ảnh của bạn.', 8000);
		}
		if (musicLinkHighlight.val() === '') {
			musicLinkHighlight.addClass('border-error');
			showDialogError('Bạn chưa nhập đường dẫn video trên youtube cho điểm nỗi bật của sự kiện của bạn.', 8000);
		}
	}

	var createEventMusicLayout = function() {
		loading.showPleaseWait();
		var musicLayout = {
			id: musicId === '' ? null : musicId,
			eventId: eventId === '' ? null : eventId,
			linkHighlight: musicLinkHighlight.val() === '' ? null : musicLinkHighlight.val()
		};
		$.ajax({
		    type: 'POST',
		    url: "/ticketevent-web/create-event-music-layout",
		    contentType : 'application/json; charset=utf-8',
	     	dataType : 'text',
		    data : JSON.stringify(musicLayout)
		})
		.done(function(data) {
		 	loading.hidePleaseWait();
		 	if (data === 'sendDataError') {
		 		validMusic();
		 		showDialogError('Dữ liệu gửi bị lỗi.', 5000);
			}else if (data === 'notFound') {
				window.location.replace('/ticketevent-web/error/404');
			}else if (data === 'loginError') {
				if (eventId !== '' || eventId !== undefined) {
					window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
				}
				window.location.replace('/ticketevent-web/login/create-event');
			}else if (data === 'notEnough') {
				validMusic();
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

	btnAddFamousPerson.click(function(e) {
		e.preventDefault();
		newFamousPerson.addFamousPersonModal(
			'Thêm người nổi tiếng.',
			function() {
				addFamousPersonIntoData(newFamousPerson.getData());
			},
			function() {
				
			}).modal();
	});

	btnSaveMusic.click(function(e) {
		createEventMusicLayout();
	});
});