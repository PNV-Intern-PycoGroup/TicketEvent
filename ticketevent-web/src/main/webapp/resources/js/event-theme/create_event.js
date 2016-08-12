var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});

var language = $('#lang').text();
var lang = 'vi_VN';
if (language === 'Languages') {
	lang = 'en';
}

/* step to create event */
var $stepOne = $('.header-control-step a[href="#ticket-info"]');
var $stepTwo = $('.header-control-step a[href="#ticket-layout"]');
var $lastStep = $('.header-control-step a[href="#ticket-setting"]');

var $outputLayoutStepOne = $('#ticket-info');
var $outputLayoutStepTwo = $('#ticket-layout');
var $outputLayoutLastStep = $('#ticket-setting');

var createEventStart = function(eventId) {
	loading.showPleaseWait();
	$.ajax({
	    type: 'GET',
	    url: "/ticketevent-web/create-event-step-one/" + eventId
	})
	.done(function(data) {
		loading.hidePleaseWait();
		hideAllTab();
		$stepOne.tab('show');
		$outputLayoutStepOne.html(data).fadeIn(500);
		window.scrollTo(0, 0);
		if (!$('.js-step-one').is(':empty')) {
			$('.js-step-one').remove();
		}
		$('body').append('<script class="js-step-one" src="/ticketevent-web/resources/js/event-theme/create_event_step_one.js"></script>');
	})
	.fail(function(xhr) {
		loading.hidePleaseWait();
		if (xhr.status === 404) {
			window.location.replace('/ticketevent-web/error/404');
		}else if (xhr.status === 403) {
			window.location.replace('/ticketevent-web/error/403');
		}
	});
};

var hideAllTab = function() {
	$outputLayoutStepOne.css('display', 'none');
	$outputLayoutStepTwo.css('display', 'none');
	$outputLayoutLastStep.css('display', 'none');
};

var openTab = function(tab) {
	$(tab.attr('href')).css('display', 'block');
}

var showDialogError = function(message, time) {
	$.notify(
		{icon: 'glyphicon glyphicon-warning-sign', message: message },
		{type: "danger", delay: time, z_index: 1100}
	);
};

var showDialogSuccess = function(message, time) {
	$.notify(
		{icon: 'glyphicon glyphicon-ok', message: message },
		{type: "success", delay: time, z_index: 1100}
	);
};
var loading;
loading = loading || (function () {
	var htmlPleaseWait="";
	htmlPleaseWait += "<div class=\"modal cus-modal fade bs-example-modal-sm\" id=\"myPleaseWait\" tabindex=\"-1\"";
	htmlPleaseWait += "    role=\"dialog\" aria-hidden=\"true\" data-backdrop=\"static\">";
	htmlPleaseWait += "    <div class=\"modal-dialog cus-modal-dialog modal-sm\">";
	htmlPleaseWait += "        <div class=\"modal-content\">";
	htmlPleaseWait += "            <div class=\"modal-header\">";
	htmlPleaseWait += "                <h4 class=\"modal-title\">";
	htmlPleaseWait += "                    <span class=\"glyphicon glyphicon-time\">";
	htmlPleaseWait += "                    <\/span>Please Wait";
	htmlPleaseWait += "                 <\/h4>";
	htmlPleaseWait += "            <\/div>";
	htmlPleaseWait += "            <div class=\"modal-body\">";
	htmlPleaseWait += "                <div class=\"progress\">";
	htmlPleaseWait += "                    <div class=\"progress-bar progress-bar-info";
	htmlPleaseWait += "                    progress-bar-striped active\"";
	htmlPleaseWait += "                    style=\"width: 100%\">";
	htmlPleaseWait += "                    <\/div>";
	htmlPleaseWait += "                <\/div>";
	htmlPleaseWait += "            <\/div>";
	htmlPleaseWait += "        <\/div>";
	htmlPleaseWait += "    <\/div>";
	htmlPleaseWait += "<\/div>";

    var pleaseWaitDiv = $(htmlPleaseWait);
    return {
        showPleaseWait: function() {
            pleaseWaitDiv.modal();
        },
        hidePleaseWait: function () {
            pleaseWaitDiv.modal('hide');
        },

    };
})();

var uploadImageAndCrop = function(image, inputImage, outputImage,
		defaultUrlImage, modal, cropWidth, cropHeight) {
	var URL = window.URL || window.webkitURL;
	var blobURL;
	var canvasData;

	image.cropper({
		viewMode : 3,
		dragMode : 'move',
		autoCropArea : 1,
		restore : false,
		modal : true,
		guides : false,
		highlight : false,
		cropBoxMovable : false,
		cropBoxResizable : false,
		responsive : true,
		crop : function(e) {
			canvasData = $(this).cropper('getCroppedCanvas', {
				width : cropWidth,
				height : cropHeight
			});
		}
	});

	if (URL) {
		inputImage.change(function() {
			var files = this.files;
			var file;
			if (files && files.length) {
				file = files[0];
				if (/^image\/\w+$/.test(file.type)) {
					if (file.size / 1048576 > 2) {
						showDialogError('Dung lượng ảnh không được vượt quá 2MB.', 10000);
					}else {
						modal.modal();
						blobURL = URL.createObjectURL(file);
						image.cropper('replace', blobURL);

						var reader = new FileReader();
						reader.onload = (function(theFile) {
							return function(e) {
								image.attr('src', reader.result);
								var img = new Image();
								img.onload = (function(e) {
									if (img.width === 1000 && img.height === 500) {
										modal.modal('toggle');
									}
								});
								img.src = reader.result;
							};
						})(file);
						reader.readAsDataURL(file);
					}
				} else {
					inputImage.val('');
				}
			}
		});
	}

	modal.find('#crop').click(function(e) {
		outputImage.find('img').attr('src', canvasData.toDataURL("image/jpeg", 0.9));
	});
	modal.on('hidden.bs.modal', function () {
		inputImage.val('');
	})
};

// Example uploadImageAndCrop($('#image'), $('#input-image'), $('#output-image'), defaultImage, $('#modal'), 1000, 500, postDemoImage);

var cropModal;
cropModal = cropModal || (function () {

	var cropHtml="";
	cropHtml += "<div class=\"modal fade\" id=\"crop-modal\" data-backdrop=\"static\" role=\"dialog\" aria-labelledby=\"modalLabel\" tabindex=\"-1\">";
	cropHtml += "	<div class=\"modal-dialog modal-lg\" role=\"document\" >";
	cropHtml += "		<div class=\"modal-content\">";
	cropHtml += "			<div class=\"modal-header\">";
	cropHtml += "				<button type=\"button\" class=\"close crop-none\" data-dismiss=\"modal\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;<\/span><\/button>";
	cropHtml += "				<h4 class=\"modal-title\" id=\"modalLabel\"><\/h4>";
	cropHtml += "			<\/div>";
	cropHtml += "			<div class=\"modal-body\">";
	cropHtml += "				<div id=\"crop-size\" class=\"\">";
	cropHtml += "				    <img id=\"crop-image\" src=\"\"\/>";
	cropHtml += "				<\/div>";
	cropHtml += "			<\/div>";
	cropHtml += "			<div class=\"modal-footer\">";
	cropHtml += "				<button id=\"crop\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Crop<\/button>";
	cropHtml += "				<button type=\"button\" class=\"btn btn-default crop-none\" data-dismiss=\"modal\">Close<\/button>";
	cropHtml += "			<\/div>";
	cropHtml += "		<\/div>";
	cropHtml += "	<\/div>";
	cropHtml += "<\/div>";

    var cropDiv = $(cropHtml);
    var imageCropContain = cropDiv.find('#crop-size');
    var image = cropDiv.find('img#crop-image');
    var titleCrop = cropDiv.find('#modalLabel');
    var btnCrop = cropDiv.find('#crop');
    var canvasData;
    var imgBase64;
    var session = false;
    return {
        getCropModal: function(classCropSize, title, blobURLImageCrop, cropWidth, cropHeight, funcCropCallBack, funcHiddenModalCallBack) {
        	imageCropContain.removeClass();
        	imageCropContain.addClass(classCropSize);
        	titleCrop.text(title);
        	image.cropper({
        		viewMode : 3,
        		dragMode : 'move',
        		autoCropArea : 1,
        		restore : false,
        		modal : true,
        		guides : false,
        		highlight : false,
        		cropBoxMovable : false,
        		cropBoxResizable : false,
        		responsive : true,
        		crop : function(e) {
        			canvasData = $(this).cropper('getCroppedCanvas', {
        				width : cropWidth,
        				height : cropHeight
        			});
            		imgBase64 = canvasData.toDataURL("image/jpeg", 0.9);
        		}
        	});
        	var eventCrop = function(e) {
        		if (session) {
        			funcCropCallBack();
            		session = false;
				}
            	btnCrop.unbind("click", eventCrop);
        	};
        	btnCrop.bind("click", eventCrop);
        	var hideModal = function () {
        		funcHiddenModalCallBack();
        		session = false;
            	cropDiv.unbind('hidden.bs.modal', hideModal);
        	}
        	cropDiv.bind('hidden.bs.modal', hideModal);
        	
        	var showModal = function () {
        		image.cropper('replace', blobURLImageCrop);
            	session = true;
            	cropDiv.unbind('shown.bs.modal', showModal);
        	}
        	cropDiv.bind('shown.bs.modal', showModal);
        	return cropDiv;
        },
        
        getImageDataBase64 : function() {
			return imgBase64;
		}
    };
})();

$(function() {
	var url = window.location.href;
	if (url.includes('create-event')) {
		createEventStart('');
	}else {
		var subUrl = url.split('/edit-event/')[1];
		createEventStart(subUrl);
	}
	
	var showStepOne = function() {
		var stepOneTimeout = setTimeout(function() {
			hideAllTab();
			$stepOne.tab('show');
			openTab($stepOne);
			clearTimeout(stepOneTimeout);
		}, 0);
	}
	
	var showStepTwo = function() {
		var stepTwoTimeout = setTimeout(function() {
			hideAllTab();
			$stepTwo.tab('show');
			openTab($stepTwo);
			clearTimeout(stepTwoTimeout);
		}, 0);
	}
	
	var showLastStep = function() {
		var lastStepTimeout = setTimeout(function() {
			hideAllTab();
			$lastStep.tab('show');
			openTab($lastStep);
			clearTimeout(lastStepTimeout);
		}, 0);
	}
	
	$stepOne.click(function(e) {
		showStepOne();
	});
	
	$stepTwo.click(function(e) {
		if ($.trim($outputLayoutStepTwo.text()) === '') {
			showStepOne();
			showDialogError('Hãy hoàn thành từng bước một.', 10000);
		}else {
			showStepTwo();
		}
	});
	
	$lastStep.click(function(e) {
		if ($.trim($outputLayoutLastStep.text()) === '') {
			showStepOne();
			showDialogError('Hãy hoàn thành từng bước một.', 10000);
		}else {
			showLastStep();
		}
	});
	
	if ($(window).width() < 768) {
		$('article').html($('<br><br><p>Xin lỗi quý khách hàng. Hệ thống chúng tôi không thể tạo sự kiện trên thiết bị di động. Chúng tôi sẽ sớm ra mắt chức năng này.<\/p>'));
	}
});