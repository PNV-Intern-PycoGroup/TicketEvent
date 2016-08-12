var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
 xhr.setRequestHeader(header, token);
});


	$.ajax({
		contentType: 'application/json',
		type: 'GET',
		dataType: 'json',
		url:'/ticketevent-web/admin/getMailConfig',
		success: function (jsondata) {
			populate('#configForm', jsondata);
		}
	});

function populate(frm, data) {
	  $.each(data, function(key, value){
	    $('[name='+key+']', frm).val(value);
	  });
};
	
var count = 0;
$(document).ready(function() {
	$('#delete').hide(); // ẩn button khi load lên
	$('#selectAll').click(function() {
		if ($(this).is(":checked")) {
			count = $('.table tr').length - 1;
			$('.selectID').prop("checked", true);
			$('#delete').show('slow');
		} else {
			$('.selectID').prop("checked", false);
			$('#delete').hide();
			count = 0;
		}
	});

	$('.selectID').click(function() {
		$('#selectAll').prop("checked", false);
		if ($(this).is(':checked')) {
			count++;
			$('#delete').show('slow');
		}
		if ($(this).is(':checked') === false) {
			count--;
			if (count === 0) {
				$('#delete').hide();
			}
		}
	});
});


$(document).ready(function () {
	$('#delete').click(function(e) {
		e.preventDefault();
	var allVals = [];
    $('.selectID').each(function() {
    	if($(this).is(":checked")){
    		allVals.push($(this).val());
    	}
    });

	$.ajax({
        contentType : 'application/json',
        type: "POST",
        dataType : 'text',
        url: '/ticketevent-web/admin/deleteComments',
        data : JSON.stringify(allVals),
        success:  function() {
        	window.location.replace('');
		},
        error: function (callback) {
        	console.log(callback);
        }
    });
	});
});


$(document).ready(function(){
	$('.activeToggle').each(function () {
		if( $(this).attr('name') == 1){
			$(this).prop("checked", true);
		}else{
			$(this).prop("checked", false);
		}
	});
	
	var type = 0;
	$('.activeToggle').click(function () {
		var tar_id = $(this).attr("id");
		if($(this).is(":checked")){
			type = 1;
			$.ajax({
	            contentType : 'application/json',
	            type: "GET",
	            url: '/ticketevent-web/admin/setAccountActive/' + tar_id+'/'+type,
	            dataType : 'text',
	            
	            success:  function() {
	            	window.location.replace('');
				},
	            error: function (callback) {
	            	console.log(callback);
	            }
	        });
		}else{
			type = 0;
			$.ajax({
	            contentType : 'application/json',
	            type: "GET",
	            url: '/ticketevent-web/admin/setAccountActive/' + tar_id+'/'+type,
	            dataType : 'text',
	            
	            success:  function() {
	            	window.location.replace('');
				},
	            error: function (callback) {
	            	console.log(callback);
	            }
	        });
		}
	});
});


//Set Image Avatar for Admin Page
$(document).ready(function () {
	var abc = $('.user-image')[0].src;
	$('.userAvatar').attr('src', abc);
});



/// EVENT ADMIN MANAGEMENT ===================
var tar_id;
$('#handling').hide();
$('.action').click(function () {
	tar_id = $(this).attr('id');
	
	$('#'+tar_id).popover({
	    html: true, 
		placement: 'bottom',
		content: function() {
	          return $('#popover-content').html();
	    }
	}).parent().on('click', '#acceptDelete', function() {
		var content = $('#contentDelete').val();
		if(content == ''){
			showDialogError(' Vui lòng nhập lí do trước khi xóa', 1000);
		}else if(content.length < 10 || content.length > 200){
			showDialogError(' Nhập ít nhất 10 kí tự và nhiều nhất là 200', 1000);
		}else{
			$('#'+tar_id).popover({
			    html: true, 
				placement: 'bottom',
				content: function() {
			          return $('#popover-content').html();
			    }
			}).parent().off('click', '#acceptDelete');
			
			$('#handling').show();
			
			$.ajax({
	            contentType : 'application/json',
	            type: "GET",
	            url: '/ticketevent-web/admin/eventdelete/' + tar_id,
	            dataType : 'text',
	            
	            success:  function() {
	            	showDialogSuccess('Xóa sự kiện hoàn tất.', 2000);
	            	$.ajax({
	    	            contentType : 'application/json',
	    	            type: "GET",
	    	            url: '/ticketevent-web/admin/sendEmailNotAcceptEvent/' + content,
	    	            dataType : 'text',
	    	        });
	            	
	            	var end = setTimeout(function () {
						window.location.replace('');
						clearTimeout(start);
					}, 1500);
				},
	            error: function (callback) {
	            	console.log(callback);
	            }
	        });
		};
	});
	
	
	$('#'+tar_id).popover('show');
	
	$('body').on('click', function (e) {
        if ($(e.target).data('toggle') !== 'popover'
            && $(e.target).parents('[data-toggle="popover"]').length === 0
            && $(e.target).parents('.popover.in').length === 0) { 
            $('.action').popover('hide');
            tar_id = null;
        };
    });
	
});

var showDialogError = (function(message, time) {
	$.notify(
		{icon: 'glyphicon glyphicon-warning-sign', message: message },
		{type: "danger", delay: time}
	);
});

var showDialogSuccess = (function(message, time) {
	$.notify(
		{icon: 'glyphicon glyphicon-ok', message: message },
		{type: "success", delay: time}
	);
});

$('.acception').click(function () {
	var eventId = $(this).attr('id');
	$(this).off('click');
	$.ajax({
        contentType : 'application/json',
        type: "GET",
        url: '/ticketevent-web/admin/acceptEvent/' + eventId,
        dataType : 'text',
        
        success:  function() {
        	showDialogSuccess('Sự kiện được chấp nhận.', 2000);
        	var end = setTimeout(function () {
				window.location.replace('');
				clearTimeout(start);
			}, 1500);
		},
        error: function (callback) {
        	console.log(callback);
        }
    });
});

$('.deleteEvent').click(function () {
	var eventId = $(this).attr('id');
	$(this).off('click');
	$.ajax({
        contentType : 'application/json',
        type: "GET",
        url: '/ticketevent-web/admin/deleteEvent/' + eventId,
        dataType : 'text',
        
        success:  function() {
        	showDialogSuccess('Sự kiện đã được xóa.', 2000);
        	var end = setTimeout(function () {
				window.location.replace('');
				clearTimeout(start);
			}, 1500);
		},
        error: function (callback) {
        	console.log(callback);
        }
    });
});
// ==============================================================

// COMMENT MANAGEMENT ========================
$('.commentDelete').click(function () {
	var commentId = $(this).attr('id');
	$(this).off('click');
	$.ajax({
        contentType : 'application/json',
        type: "POST",
        url: '/ticketevent-web/admin/deleteComment',
        dataType : 'text',
        data : JSON.stringify(commentId),
        success:  function() {
        	showDialogSuccess('Bình luận đã được xóa.', 2000);
        	var end = setTimeout(function () {
				window.location.replace('');
				clearTimeout(start);
			}, 1500);
		},
        error: function (callback) {
        	console.log(callback);
        }
    });
});



// CONFIG SYSTEM EMAIL
$(document).ready(function () {
	$('#configForm').submit(function(e) {
		var frm = $('#configForm');
		e.preventDefault();
		
	    var data = {}
	    var Form = this;
	    $.each(this, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });
	    var emailTo = $('#emailTo').val();
	    var content = $('textarea#contentTest').val();
    $.ajax({
        contentType : 'application/json',
        type: "POST",
        url: 'config-system',
        dataType : 'text',
        data : JSON.stringify(data),
        success:  function() {
        	showDialogSuccess('Cập nhật thông tin hoàn tất.', 1000);
        	sentmailTest(emailTo, content);
        	var end = setTimeout(function () {
				window.location.replace('');
				clearTimeout(start);
			}, 1500);
		}
    });
	});
});

var sentmailTest = (function(mailTo, content){
	var data = [];
		data.push(mailTo);
		data.push(content);
	$.ajax({
        contentType : 'application/json',
        type: "POST",
        url: 'sendTestEmail',
        dataType : 'text',
        data : JSON.stringify(data)
    });
});

//add new Admin
$('#loading').hide();
$(document).ready(function() {
	$('#createAccount').submit(function(e) {
		e.preventDefault();
		//$('#loading').show();
		
	    var data = {}
	    var useName = $('#username').val();
	    var email = $('#email').val();
	    var password = $('#uPassword').val();
	    
	    data['userName'] = useName;
	    data['email'] = email;
	    data['password'] = password;
    $.ajax({
        contentType : 'application/json',
        type: "POST",
        url: 'addAdmin',
        dataType : 'text',
        data : JSON.stringify(data),
        success:  function() {
        	$('#newAccount').modal('hide');
        	showDialogSuccess('Tạo tài khoản thành công.', 2000);
        	var end = setTimeout(function () {
				window.location.replace('');
				clearTimeout(start);
			}, 1500);
		}
    });
	});
});


