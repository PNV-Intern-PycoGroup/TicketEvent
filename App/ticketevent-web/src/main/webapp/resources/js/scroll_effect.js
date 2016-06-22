$(function() {
	$('a.page-scroll').bind('click', function(event) {
		var $anchor = $(this);
		$('html, body').stop().animate({
			scrollTop : $($anchor.attr('href')).offset().top - 90
		}, 1500, 'easeOutCirc');
		event.preventDefault();
	});
	
	$('#famous-person-slider').carousel({
		interval : 10000
	});

	$('#library-image').carousel({
		interval : 3000
	});
	
	var ta = document.querySelector('#autosize-textarea');
	ta.addEventListener('focus', function(){
	    autosize(ta);
	});
});