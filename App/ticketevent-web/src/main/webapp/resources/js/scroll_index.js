var lastScrollTop = 0;
$(window).scroll(function(e) {
    var body = $("body")[0],
        scrollTop = body.scrollTop;
    
    if (scrollTop > lastScrollTop) {
        if (scrollTop <= 5) {
        	$("html, body").animate({ scrollTop: $('#top-event').offset().top - 90 }, "slow");
        }
    }
     lastScrollTop = scrollTop;
});