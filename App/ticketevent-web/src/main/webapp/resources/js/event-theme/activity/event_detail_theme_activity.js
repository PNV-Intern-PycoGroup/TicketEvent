$(function() {
	
	var textarea = document.querySelector('#autosize-textarea');
	textarea.addEventListener('focus', function(){
	    autosize(textarea);
	});
});