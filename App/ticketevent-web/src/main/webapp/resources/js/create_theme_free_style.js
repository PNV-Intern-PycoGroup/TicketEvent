tinymce.init({
	selector: '#create-event-free-style',
	plugins: [
                 'advlist autolink link image lists charmap preview hr anchor',
                 'searchreplace wordcount visualblocks visualchars media',
                 'save table contextmenu directionality paste textcolor'
             ],
	a_plugin_option: true,
	language: lang,
	language_url: '/ticketevent-web/resources/js/vi_VN.js',
	a_configuration_option: 400,
	height: 600,
	toolbar: 'undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify '
		+ '| bullist numlist outdent indent | link image | preview media fullpage | forecolor backcolor',
	plugin_preview_width: $('section').width(),
	plugin_preview_height: $(window).height() - 100
});

var get_editor_content = function () {
	$('#myrender').html(tinymce.activeEditor.getContent());
}