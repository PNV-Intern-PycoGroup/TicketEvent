var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});

var timer;

var select = function() {
	$('div.type-event').find('[data-optgroup=1]').click(function(e) {
		setTimeout(function() {
			if(!$('div.type-event').find('[data-optgroup=1]').hasClass('selected')){
				$('#place-event').prop('disabled', true);
				$('.type-event').selectpicker('deselectAll');
			}
			else{
				$('#place-event').prop('disabled', false);
			}
			$('.type-event').selectpicker('refresh');
		}, 100);
	});
	clearTimeout(timer);
	timer = setTimeout(select, 100);
}

timer = setTimeout(select, 100);

var language = $('#lang').text();

var lang = 'vi_VN';

if (language === 'Languages') {
	lang = 'en_GB';
}

tinymce.init({
	selector: '#text-editor',
	plugins: [
                 'advlist autolink link image lists charmap preview hr anchor',
                 'searchreplace wordcount visualblocks visualchars media',
                 'save table contextmenu directionality paste textcolor'
             ],
	a_plugin_option: true,
	language: lang,
	language_url: $('#context-path').val() + '/resources/js/lib/vi_VN.js',
	a_configuration_option: 400,
	height: 600,
	toolbar: 'undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify '
		+ '| bullist numlist outdent indent | link image | preview media fullpage | forecolor backcolor',
		plugin_preview_width: $('section').width(),
		plugin_preview_height: $(window).height() - 100
});

$('.contain-radio').on('click', function(e) {
	$(this).find('input[type=radio]').prop('checked', true);
});

var createEventStepTwo = (function(outputLayout) {
	var sendInfo = {
		file : "abc"
	};
	$.ajax({
	    type: 'POST',
	    url: "create-event-step-two",
	    data : sendInfo
 }).done(function(data) {
		outputLayout.html(data);
	}).fail(function() {
	});
});

createEventStepTwo($('#ticket-layout'));
