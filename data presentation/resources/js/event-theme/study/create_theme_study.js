eventId = $('#event-id').val();
var courseId = $('#course-id').val();

var addCourseBanner = $('#add-course-banner-image');
var outputBannerImage = $('#output-banner-image');
var addCoursePlace = $('#add-course-place-image');
var outputPlaceImage = $('#output-place-image');
var addSpeaker = $('#add-speaker');
var containSpeaker = $('#contain-speaker');
var addContent = $('#add-content');
var containContent = $('#contain-content');
var btnSaveCourseLayout = $('#save-course-layout');

var uploadCourseFile = function(base64, nameFile, outputImage) {
	loading.showPleaseWait();
	var status = outputImage.parent().find('span.status');
	status.css('color', 'blue');
	status.text('Đang tải ảnh lên...');
	var data = [base64, nameFile, eventId === '' ? null : eventId];
	$.ajax({
	    type: 'POST',
	    url: "/ticketevent-web/upload-file-course",
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


addCourseBanner.change(function() {
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
								uploadCourseFile(imageCropBase64, 'banner', outputBannerImage);
							},
							function() {
								addCourseBanner.val('');
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

addCoursePlace.change(function() {
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
								uploadCourseFile(imageCropBase64, 'place', outputPlaceImage);
							},
							function() {
								addCoursePlace.val('');
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

var newSpeaker;
newSpeaker = newSpeaker || (function () {

	var newSpeakerHtml="";
	newSpeakerHtml += "<div class=\"modal fade\" id=\"new-speaker-modal\" data-backdrop=\"static\" role=\"dialog\" aria-labelledby=\"modalLabel\" tabindex=\"-1\">";
	newSpeakerHtml += "  <div class=\"modal-dialog modal-lg\" role=\"document\">";
	newSpeakerHtml += "    <div class=\"modal-content\">";
	newSpeakerHtml += "      <div class=\"modal-header\">";
	newSpeakerHtml += "        <button type=\"button\" class=\"close crop-none\" data-dismiss=\"modal\" aria-label=\"Close\">";
	newSpeakerHtml += "        	<span aria-hidden=\"true\">&times;<\/span>";
	newSpeakerHtml += "    	<\/button>";
	newSpeakerHtml += "        <h4 class=\"modal-title\" id=\"modalLabel\"><\/h4>";
	newSpeakerHtml += "      <\/div>";
	newSpeakerHtml += "      <div class=\"modal-body\">";
	newSpeakerHtml += "        <div class=\"col-md-12\">";
	newSpeakerHtml += "			<figure id=\"contain-speaker-image\" class=\"col-md-3\">";
	newSpeakerHtml += "				<input type=\"file\" id=\"input-speaker-image\" class=\"hidden-file input-image\"\/>";
	newSpeakerHtml += "				<img id=\"output-speaker-image\" alt=\"famous person\" src=\"\"\/>";
	newSpeakerHtml += "			<\/figure>";
	newSpeakerHtml += "			<div class=\"col-md-9\">";
	newSpeakerHtml += "				<div class=\"input-group col-md-12 cus-input-group-theme-study\">";
	newSpeakerHtml += "					<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study\">Tên diễn giả<\/span>";
	newSpeakerHtml += "					<input id=\"name-speaker\" type=\"text\" class=\"form-control cus-form-control-theme-study\" \/>";
	newSpeakerHtml += "				<\/div>";
	newSpeakerHtml += "				<div class=\"input-group col-md-12 cus-input-group-theme-study\">";
	newSpeakerHtml += "					<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study\">Lĩnh vực<\/span>";
	newSpeakerHtml += "					<input id=\"field-speaker\" type=\"text\" class=\"form-control cus-form-control-theme-study\" \/>";
	newSpeakerHtml += "				<\/div>";
	newSpeakerHtml += "				<div class=\"cus-event-info-theme-study\">";
	newSpeakerHtml += "					<span class=\"label-event-info cus-input-group-addon-create-event\">Giới thiệu hoặc mô tả đôi nét về diễn giả<\/span>";
	newSpeakerHtml += "					<textarea id=\"history-speaker\" class=\"textarea-event-info\" ><\/textarea>";
	newSpeakerHtml += "				<\/div>";
	newSpeakerHtml += "			<\/div>";
	newSpeakerHtml += "		<\/div>";
	newSpeakerHtml += "		<div class=\"clear\"><\/div>";
	newSpeakerHtml += "      <\/div>";
	newSpeakerHtml += "      <div class=\"modal-footer\">";
	newSpeakerHtml += "        <button id=\"save-speaker\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Save<\/button>";
	newSpeakerHtml += "        <button type=\"button\" class=\"btn btn-default crop-none\" data-dismiss=\"modal\">Close<\/button>";
	newSpeakerHtml += "        <input type=\"hidden\" id=\"speaker-id\" \/>";
	newSpeakerHtml += "      <\/div>";
	newSpeakerHtml += "    <\/div>";
	newSpeakerHtml += "  <\/div>";
	newSpeakerHtml += "<\/div>";

	var speakerModalDiv = $(newSpeakerHtml);
	var titleModal = speakerModalDiv.find('#modalLabel');
	var inputSpeakerImage = speakerModalDiv.find('#input-speaker-image');
	var outputSpeakerImage = speakerModalDiv.find('#output-speaker-image');
	var nameSpeaker = speakerModalDiv.find('#name-speaker');
	var fieldSpeaker = speakerModalDiv.find('#field-speaker');
	var historySpeaker = speakerModalDiv.find('#history-speaker');
	var speakerId = speakerModalDiv.find('#speaker-id');
	var saveSpeaker = speakerModalDiv.find('#save-speaker');

	var width = 1500;
	var height = 500;
	
	var resetValue = function() {
		titleModal.text('');
		inputSpeakerImage.val('');
		outputSpeakerImage.attr('src', '');
		nameSpeaker.val('');
		fieldSpeaker.val('');
		historySpeaker.val('');
		speakerId.val('');
	}
	
	inputSpeakerImage.change(function(e) {
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
									outputSpeakerImage.attr('src', imageCropBase64);
								},
								function() {
									inputSpeakerImage.val('');
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
	var canvasImage = document.createElement('canvas');
		$(canvasImage).width(width).height(height);
		var imgCanvas = new Image();
	    var ctxCanvas;
	var data;
    var session = false;
    return {
        addSpeakerModal: function(title, funcSaveCallBack, funcHiddenModalCallBack) {
        	resetValue();
        	titleModal.text(title);

        	var eventSaveSpeaker = function(e) {
        		if (session) {
        		    data = {
    		    		id: speakerId.val() === '' ? null : speakerId.val(),
    		    		courseLayout: courseId === '' ? null : {id: courseId, eventId: eventId === '' ? null : eventId},
    		    		image: outputSpeakerImage.attr('src') === '' ? null : outputSpeakerImage.attr('src'),
    		    		name: nameSpeaker.val() === '' ? null : nameSpeaker.val(),
    		    		field: fieldSpeaker.val() === '' ? null : fieldSpeaker.val(),
    		    		history: historySpeaker.val() === '' ? null : historySpeaker.val()
    		    	}
        			funcSaveCallBack();
            		session = false;
				}
            	saveSpeaker.unbind('click', eventSaveSpeaker);
        	}
        	saveSpeaker.bind('click', eventSaveSpeaker);
        	
        	var eventHideModal = function () {
        		funcHiddenModalCallBack();
        		session = false;
            	speakerModalDiv.unbind('hidden.bs.modal', eventHideModal);
        	}
        	speakerModalDiv.bind('hidden.bs.modal', eventHideModal);
        	
        	var eventShowModal = function () {
            	session = true;
            	speakerModalDiv.unbind('shown.bs.modal', eventShowModal);
        	}
        	speakerModalDiv.bind('shown.bs.modal', eventShowModal);
        	return speakerModalDiv;
        },
        editSpeakerModal: function(speaker, title, funcSaveCallBack, funcHiddenModalCallBack) {
        	speakerId.val(speaker.id);
        	outputSpeakerImage.attr('src', speaker.image);
        	nameSpeaker.val(speaker.name);
        	fieldSpeaker.val(speaker.field);
        	historySpeaker.val(speaker.history);
        	titleModal.text(title);

        	var eventSaveSpeaker = function(e) {
        		if (session) {
        			ctx = canvasImage.getContext("2d");
        		    ctx.drawImage(outputSpeakerImage, 0, 0, width, height);
        		    data = {
    		    		id: speakerId.val() === '' ? null : speakerId.val(),
    		    		courseLayout: courseId === '' ? null : {id: courseId, eventId: eventId === '' ? null : eventId},
    		    		image: outputSpeakerImage.attr('src') === '' ? null : outputSpeakerImage.attr('src'),
    		    		name: nameSpeaker.val() === '' ? null : nameSpeaker.val(),
    		    		field: fieldSpeaker.val() === '' ? null : fieldSpeaker.val(),
    		    		history: historySpeaker.val() === '' ? null : historySpeaker.val()
    		    	}
        			funcSaveCallBack();
            		session = false;
				}
            	saveSpeaker.unbind('click', eventSaveSpeaker);
        	}
        	saveSpeaker.bind('click', eventSaveSpeaker);
        	
        	var eventHideModal = function () {
        		funcHiddenModalCallBack();
        		session = false;
            	speakerModalDiv.unbind('hidden.bs.modal', eventHideModal);
        	}
        	speakerModalDiv.bind('hidden.bs.modal', eventHideModal);
        	
        	var eventShowModal = function () {
            	session = true;
            	speakerModalDiv.unbind('shown.bs.modal', eventShowModal);
        	}
        	speakerModalDiv.bind('shown.bs.modal', eventShowModal);
        	return speakerModalDiv;
        },
        getData: function() {
			return data;
		}
    };
})();
var renderSpeakerFactory;
renderSpeakerFactory = renderSpeakerFactory || (function () {

	var childSpeakerHtml="";
	childSpeakerHtml += "<div class=\"col-md-12\">";
	childSpeakerHtml += "	<figure class=\"col-md-3\">";
	childSpeakerHtml += "		<img class=\"render-speaker-image\" alt=\"famous person\" src=\"\">";
	childSpeakerHtml += "	<\/figure>";
	childSpeakerHtml += "	<div class=\"col-md-9\">";
	childSpeakerHtml += "		<div class=\"input-group col-md-12 cus-input-group-theme-study\">";
	childSpeakerHtml += "			<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study\">Tên diễn giả<\/span>";
	childSpeakerHtml += "			<span class=\"form-control cus-form-control-theme-study render-speaker-name\" ><\/span>";
	childSpeakerHtml += "		<\/div>";
	childSpeakerHtml += "		<div class=\"input-group col-md-12 cus-input-group-theme-study\">";
	childSpeakerHtml += "			<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study\">Lĩnh vực<\/span>";
	childSpeakerHtml += "			<span class=\"form-control cus-form-control-theme-study render-speaker-field\" ><\/span>";
	childSpeakerHtml += "		<\/div>";
	childSpeakerHtml += "		<div class=\"cus-event-info-theme-study\">";
	childSpeakerHtml += "			<span class=\"label-event-info cus-input-group-addon-create-event\">Giới thiệu hoặc mô tả đôi nét về diễn giả<\/span>";
	childSpeakerHtml += "			<p class=\"textarea-event-info render-speaker-introduction\" ><\/p>";
	childSpeakerHtml += "		<\/div>";
	childSpeakerHtml += "	<\/div>";
	childSpeakerHtml += "	<input class=\"render-speaker-id\" type=\"hidden\" \/>";
	childSpeakerHtml += "	<div class=\"clear\"><\/div>";
	childSpeakerHtml += "	<hr class=\"divider\">";
	childSpeakerHtml += "<\/div>";
    return {
        getRenderSpeaker: function(speaker) {
        	var speakerDiv = $(childSpeakerHtml);
        	var renderImage = speakerDiv.find('.render-speaker-image');
        	var renderName = speakerDiv.find('.render-speaker-name');
        	var renderField = speakerDiv.find('.render-speaker-field');
        	var renderHistory = speakerDiv.find('.render-speaker-introduction');
        	var renderId = speakerDiv.find('.render-speaker-id');
        	
        	renderId.val(speaker.id);
        	renderImage.attr('src', '/ticketevent-web/resources/images/' + speaker.image);
        	renderName.text(speaker.name);
        	renderField.text(speaker.field);
        	renderHistory.text(speaker.history);
        	return speakerDiv;
        }
    };
})();

var addSpeakerIntoData = function(speaker) {
	loading.showPleaseWait();
	var courseLayoutSpeaker = speaker;
	$.ajax({
	    type: 'POST',
	    url: "/ticketevent-web/create-speaker-course",
	    contentType : 'application/json; charset=utf-8',
     	dataType : 'text',
	    data : JSON.stringify(courseLayoutSpeaker)
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
			var speakerGetData = JSON.parse(data);
			var childSpeaker = renderSpeakerFactory.getRenderSpeaker(speakerGetData);
			containSpeaker.append(childSpeaker);
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

addSpeaker.click(function(e) {
	e.preventDefault();
	newSpeaker.addSpeakerModal(
		'Thêm người diễn giả.',
		function() {
			addSpeakerIntoData(newSpeaker.getData());
		},
		function() {
			
		}).modal();
});

var newContent;
newContent = newContent || (function () {

	var newContentHtml="";
	newContentHtml += "<div class=\"modal fade\" id=\"new-content-modal\" data-backdrop=\"static\" role=\"dialog\" aria-labelledby=\"modalLabel\" tabindex=\"-1\">";
	newContentHtml += "  <div class=\"modal-dialog modal-lg\" role=\"document\">";
	newContentHtml += "    <div class=\"modal-content\">";
	newContentHtml += "      <div class=\"modal-header\">";
	newContentHtml += "        <button type=\"button\" class=\"close crop-none\" data-dismiss=\"modal\" aria-label=\"Close\">";
	newContentHtml += "        	<span aria-hidden=\"true\">&times;<\/span>";
	newContentHtml += "    	<\/button>";
	newContentHtml += "        <h4 class=\"modal-title\" id=\"modalLabel\"><\/h4>";
	newContentHtml += "      <\/div>";
	newContentHtml += "      <div class=\"modal-body\">";
	newContentHtml += "        <div class=\"col-md-12\">";
	newContentHtml += "				<div class=\"input-group col-md-12 cus-input-group-theme-study\">";
	newContentHtml += "					<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study\">Tiêu đề bài giảng<\/span>";
	newContentHtml += "					<input id=\"content-title\" type=\"text\" class=\"form-control cus-form-control-theme-study\" \/>";
	newContentHtml += "				<\/div>";
	newContentHtml += "				<div class=\"cus-event-info-theme-study\">";
	newContentHtml += "					<span class=\"label-event-info cus-input-group-addon-create-event\">Mô tả về nội dung bài giảng<\/span>";
	newContentHtml += "					<textarea id=\"content-body\" class=\"textarea-event-info\" ><\/textarea>";
	newContentHtml += "				<\/div>";
	newContentHtml += "		<\/div>";
	newContentHtml += "		<div class=\"clear\"><\/div>";
	newContentHtml += "      <\/div>";
	newContentHtml += "      <div class=\"modal-footer\">";
	newContentHtml += "        <button id=\"save-content\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Save<\/button>";
	newContentHtml += "        <button type=\"button\" class=\"btn btn-default crop-none\" data-dismiss=\"modal\">Close<\/button>";
	newContentHtml += "        <input type=\"hidden\" id=\"content-id\" \/>";
	newContentHtml += "      <\/div>";
	newContentHtml += "    <\/div>";
	newContentHtml += "  <\/div>";
	newContentHtml += "<\/div>";

	var contentModalDiv = $(newContentHtml);
	var titleModal = contentModalDiv.find('#modalLabel');
	var contentTitle = contentModalDiv.find('#content-title');
	var contentBody = contentModalDiv.find('#content-body');
	var contentId = contentModalDiv.find('#content-id');
	var saveContent = contentModalDiv.find('#save-content');

	var resetValue = function() {
		titleModal.text('');
		contentTitle.val('');
		contentBody.val('');
		contentId.val('');
	}
	var data;
    var session = false;
    return {
        addContentModal: function(title, funcSaveCallBack, funcHiddenModalCallBack) {
        	resetValue();
        	titleModal.text(title);

        	var eventSaveContent = function(e) {
        		if (session) {
        		    data = {
    		    		id: contentId.val() === '' ? null : contentId.val(),
    		    		courseLayout: courseId === '' ? null : {id: courseId, eventId: eventId === '' ? null : eventId},
    		    		title: contentTitle.val() === '' ? null : contentTitle.val(),
    		    		content: contentBody.val() === '' ? null : contentBody.val()
    		    	}
        			funcSaveCallBack();
            		session = false;
				}
            	saveContent.unbind('click', eventSaveContent);
        	}
        	saveContent.bind('click', eventSaveContent);
        	
        	var eventHideModal = function () {
        		funcHiddenModalCallBack();
        		session = false;
            	contentModalDiv.unbind('hidden.bs.modal', eventHideModal);
        	}
        	contentModalDiv.bind('hidden.bs.modal', eventHideModal);
        	
        	var eventShowModal = function () {
            	session = true;
            	contentModalDiv.unbind('shown.bs.modal', eventShowModal);
        	}
        	contentModalDiv.bind('shown.bs.modal', eventShowModal);
        	return contentModalDiv;
        },
        editContentModal: function(content, title, funcSaveCallBack, funcHiddenModalCallBack) {
        	contentId.val(content.id);
        	contentTitle.val(content.title);
        	contentBody.val(content.content);
        	titleModal.text(title);

        	var eventSaveContent = function(e) {
        		if (session) {
        		    data = {
    		    		id: contentId.val() === '' ? null : contentId.val(),
    		    		courseLayout: courseId === '' ? null : {id: courseId, eventId: eventId === '' ? null : eventId},
    		    		title: contentTitle.val() === '' ? null : contentTitle.val(),
    		    		content: contentBody.val() === '' ? null : contentBody.val()
    		    	}
        			funcSaveCallBack();
            		session = false;
				}
            	saveContent.unbind('click', eventSaveContent);
        	}
        	saveContent.bind('click', eventSaveContent);
        	
        	var eventHideModal = function () {
        		funcHiddenModalCallBack();
        		session = false;
            	contentModalDiv.unbind('hidden.bs.modal', eventHideModal);
        	}
        	contentModalDiv.bind('hidden.bs.modal', eventHideModal);
        	
        	var eventShowModal = function () {
            	session = true;
            	contentModalDiv.unbind('shown.bs.modal', eventShowModal);
        	}
        	contentModalDiv.bind('shown.bs.modal', eventShowModal);
        	return contentModalDiv;
        },
        getData: function() {
			return data;
		}
    };
})();
var renderContentFactory;
renderContentFactory = renderContentFactory || (function () {

	var childContentHtml="";
	childContentHtml += "<div class=\"col-md-12\">";
	childContentHtml += "	<div class=\"input-group col-md-12 cus-input-group-theme-study\">";
	childContentHtml += "		<span class=\"input-group-addon cus-input-group-addon-create-event cus-input-group-addon-theme-study\">Tiêu đề bài giảng<\/span>";
	childContentHtml += "		<span class=\"form-control cus-form-control-theme-study render-content-title\" ><\/span>";
	childContentHtml += "	<\/div>";
	childContentHtml += "	<div class=\"cus-event-info-theme-study\">";
	childContentHtml += "		<span class=\"label-event-info cus-input-group-addon-create-event\">Mô tả về nội dung bài giảng<\/span>";
	childContentHtml += "		<p class=\"textarea-event-info render-content-body\" ><\/p>";
	childContentHtml += "	<\/div>";
	childContentHtml += "	<input class=\"render-content-id\" type=\"hidden\" \/>";
	childContentHtml += "	<div class=\"clear\"><\/div>";
	childContentHtml += "	<hr class=\"divider\">";
	childContentHtml += "<\/div>";
    return {
        getRenderContent: function(content) {
        	var contentDiv = $(childContentHtml);
        	var renderTitle = contentDiv.find('.render-content-title');
        	var renderContent = contentDiv.find('.render-content-body');
        	var renderId = contentDiv.find('.render-content-id');
        	
        	renderId.val(content.id);
        	renderTitle.text(content.title);
        	renderContent.text(content.content);
        	return contentDiv;
        }
    };
})();

var addContentIntoData = function(content) {
	loading.showPleaseWait();
	var courseLayoutContent = content;
	$.ajax({
	    type: 'POST',
	    url: "/ticketevent-web/create-content-course",
	    contentType : 'application/json; charset=utf-8',
     	dataType : 'text',
	    data : JSON.stringify(courseLayoutContent)
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
			var contentGetData = JSON.parse(data);
			var childContent = renderContentFactory.getRenderContent(contentGetData);
			containContent.append(childContent);
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

addContent.click(function(e) {
	e.preventDefault();
	newContent.addContentModal(
		'Thêm nội dung bài giảng.',
		function() {
			addContentIntoData(newContent.getData());
		},
		function() {
			
		}).modal();
});

var validCourse = function() {
	outputBannerImage.parent().removeClass('border-error');
	outputPlaceImage.parent().removeClass('border-error');
	addSpeaker.removeClass('border-error');
	addContent.removeClass('border-error');
	if (outputBannerImage.val() === '') {
		outputBannerImage.parent().addClass('border-error');
	}
	if (outputPlaceImage.val() === '') {
		outputPlaceImage.parent().addClass('border-error');
	}
	if (containSpeaker.find('figure').length == 0) {
		addSpeaker.addClass('border-error');
	}
	if (containContent.find('span').length == 0) {
		addContent.addClass('border-error');
	}
}

var createEventCourseLayout = function() {
	loading.showPleaseWait();
	var courseLayout = {
		id: courseId === '' ? null : courseId,
		eventId: eventId === '' ? null : eventId
	};
	$.ajax({
	    type: 'POST',
	    url: "/ticketevent-web/create-event-course-layout",
	    contentType : 'application/json; charset=utf-8',
     	dataType : 'text',
	    data : JSON.stringify(courseLayout)
	})
	.done(function(data) {
	 	loading.hidePleaseWait();
	 	if (data === 'sendDataError') {
	 		validCourse();
	 		showDialogError('Dữ liệu gửi bị lỗi.', 5000);
		}else if (data === 'notFound') {
			window.location.replace('/ticketevent-web/error/404');
		}else if (data === 'loginError') {
			if (eventId !== '' || eventId !== undefined) {
				window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
			}
			window.location.replace('/ticketevent-web/login/create-event');
		}else if (data === 'notEnough') {
			validCourse();
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

btnSaveCourseLayout.click(function(e) {
	createEventCourseLayout();
});