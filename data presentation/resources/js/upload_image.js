// REQUIRE 
// resources/css/cropper.min.css
// http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css
// https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js
// resources/js/cropper.min.js

// Upload image
var uploadImageAndCrop = function(image, inputImage, outputImage,
		defaultCanvasImage, modal, cropWidth, cropHeight) {
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
	});

	modal.find('.crop-none').click(function(e) {
		inputImage.val('');
		outputImage.find('canvas').remove();
		outputImage.html(defaultCanvasImage);
	});
};

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
