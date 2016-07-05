var btnAddEvent = document.querySelector("#btn-add-event");

window.onscroll = function() {hideElement(btnAddEvent)};

var hideElement = function(element){
//	btnAddEvent.
}

$(document).ready(function () {
	if($('.login-fail').length){
		$('#login-logout').modal();
	}
})

$(document).ready(function() {
    $('#btRegister').click(function (e) {
    	if($('#username').val() === ''){
    		$('#username').tooltip({title: "Username is required", animation: true,placement: "top"});
    		$('#username').tooltip('show');
    		e.preventDefault();
    	}
    	if($('#email').val() === ''){
    		$('#email').tooltip({title: "Email is required", animation: true,placement: "top"});
    		$('#email').tooltip('show');
    	}
	});
});