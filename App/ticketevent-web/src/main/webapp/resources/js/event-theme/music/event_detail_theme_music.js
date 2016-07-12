$(function() {
	$('a.page-scroll').bind('click', function(event) {
		var $anchor = $(this);
		$('html, body').stop().animate({
			scrollTop : $($anchor.attr('href')).offset().top - 90
		}, 800, 'easeInQuint');
		event.preventDefault();
	});
	
	$('#famous-person-slider').carousel({
		interval : 10000
	});

	$('#library-image').carousel({
		interval : 3000
	});
	
	var textarea = document.querySelector('#autosize-textarea');
	textarea.addEventListener('focus', function(){
	    autosize(textarea);
	});
});