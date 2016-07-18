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

//	$('#myrender').html(tinymce.activeEditor.getContent());

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
		$infoLinkImage.addClass('col-md-6 info-image');
		
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
