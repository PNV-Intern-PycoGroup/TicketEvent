// REQUIRE 
// resources/css/cropper.min.css
// http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css
// https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js
// resources/js/cropper.min.js

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});
// Upload image
var uploadImageAndCrop = function(image, inputImage, outputImage,
		defaultCanvasImage, modal, cropWidth, cropHeight, postImage) {
	var URL = window.URL || window.webkitURL;
	var blobURL;
	var canvasData;

	outputImage.html(defaultCanvasImage);
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
									postDemoImage(reader.result);
									var timeoutInitImage = setTimeout(
											function() {
												outputImage.html(canvasData);
												clearTimeout(timeoutInitImage);
											}, 0);
								}
							});
							img.src = reader.result;
						};
					})(file);
					reader.readAsDataURL(file);
				} else {
					inputImage.val('');
				}
			}
		});
	}

	modal.find('#crop').click(function(e) {
		outputImage.html(canvasData);
		var base64 = canvasData.toDataURL("image/jpeg", 0.9);
		postImage(base64);
	});

	modal.find('.crop-none').click(function(e) {
		inputImage.val('');
		outputImage.find('canvas').remove();
		outputImage.html(defaultCanvasImage);
	});
};

// Upload Image don't crop
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

					var reader = new FileReader();

					reader.onload = (function(theFile) {
						return function(e) {
							postImageFunction(reader.result, $ouputImage);
							$ouputImage.find('img').attr("src", reader.result);
						}
					})(file);
					reader.readAsDataURL(file);
				}
				inputImage.val('');
			}
		});
	}
}

var postImageFunctionCreateThemeFreeStyle = (function(base64, outputImage) {
	var sendInfo = {
		file : base64
	};
	var outputUrlImage = outputImage.find('.url');
	var btnCopyUrl = outputImage.find('.btn-copy-url');
	
	$.ajax({
	    type: 'POST',
	    url: "upload-file-free-style",
	    data : sendInfo
    })
    .done(function(data) {
    	outputUrlImage.text(data);
    	btnCopyUrl.removeClass('disabled');
    	btnCopyUrl.click(function(e) {
			e.preventDefault();
			copyToClipboard($(this).parent().find('.url'));
		});
	})
    .fail(function() {
    	outputUrlImage.css('color', 'red');
    	outputUrlImage.text("Tải lên thất bại. Vì dung lượng ảnh tải lên vượt quá 2MB!");
		btnCopyUrl.click(function(e) {
			e.preventDefault();
		});
		
		var timeoutClearOutPutImage = setTimeout(function() {
			outputImage.slideUp('slow', function(){
				$(this).remove();
			});
			clearTimeout(timeoutClearOutPutImage);
		}, 5000);

	});
});

var createDisplayHTMLOutputImageUpload = function() {
	var $outputImage = $('<div>');
	$outputImage.addClass('output-image');
	
		var $image = $('<img>');
		$image.addClass('col-md-6');
		$image.attr('alt', 'Image upload');
		
		$outputImage.append($image); // outputImage > image
	
		var $infoLinkImage = $('<div>');
		$infoLinkImage.addClass('col-md-6 info-link-image');
		
		$outputImage.append($infoLinkImage); // outputImage > infoLinkImage
		
			var $span = $('<span>');
			$span.addClass('col-md-12');
			
			$infoLinkImage.append($span); // outputImage > infoLinkImage > span
			
				var $label = $('<label>');
				$label.text('Link: ');
				
				var $url = $('<span>');
				$url.addClass('url');
				$url.text('Đang tải ảnh lên ...');
				
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

$('.btn-copy-url').click(function(e) {
	copyToClipboard($(this).parent().find('.url'));
});

$('.disable-href').click(function(e) {
	e.preventDefault();
})


/*
var defaultImage = document.createElement('canvas');
defaultImage.width = 1000;
defaultImage.height = 500;
var ctx = defaultImage.getContext("2d");
ctx.font = "48px arial";
ctx.fillText("Đăng ảnh của bạn", 10, 50);*/

/*var postDemoImage = (function(base64) {
	var sendInfo = {
		file : base64
	};
	$.ajax({
		type : "POST",
		url : "upload-file",
		dataType : "json",
		success : function(msg) {
		},
		data : sendInfo
	});
});*/

// importImage($('#image'), $('#input-image'), $('#output-image'), defaultImage,
// $('#modal'), 1000, 500, postDemoImage);
