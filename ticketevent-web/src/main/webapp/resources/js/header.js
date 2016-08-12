var btnAddEvent = $("#btn-add-event");

var lastScrollTop = 0;
$(window).scroll(function(event){
	var st = $(this).scrollTop();
	if ($(this).width() < 1100) {
		if (st > lastScrollTop){
			btnAddEvent.fadeOut(500);
		} else {
			btnAddEvent.fadeIn(500);
		}
		lastScrollTop = st;
	}else {
		btnAddEvent.fadeIn(500);
	}
});


var language = $.trim($('#language').text());
var lang = 'vi_VN';
if (language === 'Languages') {
	lang = 'en';
}

$(document).ready(function () {
	if($('.login-fail').length){
		$('#login-logout').modal();
	}
});

var convertVietnamese = function (str) {  
	str= str.toLowerCase();  
	str= str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g,"a");  
	str= str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g,"e");  
	str= str.replace(/ì|í|ị|ỉ|ĩ/g,"i");  
	str= str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g,"o");  
	str= str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g,"u");  
	str= str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g,"y");  
	str= str.replace(/đ/g,"d");  
	return str;  
}

$(document).ready(function () {
	if($('.confirm-success').length > 0){
		showDialogSuccess("Chúc mừng bạn đã trở thành thành viên của TicketEvent. Đăng nhập ngay !", 1500);
		var end = setTimeout(function () {
			$('#login-logout').modal('show');
			clearTimeout(start);
		}, 1500);
		
	}
});


$(document).ready(function () {
	if($('.confirm-error').length > 0){
		showDialogError("Xác nhận lỗi.", 1500);
	}
})

var app = angular.module('myApp', ['ui.bootstrap']);

//Check confirm password
app.directive('passwordMatch', [function () {
    return {
        restrict: 'A',
        scope:true,
        require: 'ngModel',
        link: function (scope, elem , attrs,control) {
            var checker = function () {
 
                //get the value of the first password
                var e1 = scope.$eval(attrs.ngModel); 
 
                //get the value of the other password  
                var e2 = scope.$eval(attrs.passwordMatch);
                return e1 == e2;
            };
            scope.$watch(checker, function (n) {
                //set the form control to valid if both 
                //passwords are the same, else invalid
                control.$setValidity("unique", n);
            });
        }
    };
}]);

app.controller('MainCtrl', function($scope, $http) {
	  $scope.user ;
	});

// Check exits username
app.directive('usernameAvailable', function($timeout, $q, $http) {
	  return {
	    restrict: 'AE',
	    scope:true,
	    require: '?ngModel',
	    link: function(scope, elm, attr, model) { 
	      model.$asyncValidators.usernameExists = function(modelValue, viewValue) {
	    	  var value = modelValue || viewValue;
	        return $http.get('/ticketevent-web/api/' + value).success(function(data){+
	          $timeout(function(){
	            model.$setValidity('usernameExists', data); 
	          }, 1000);
	        }); 
	      };
	    }
	  } 
	});


// AvatarUploadImage
$(document).ready(function(){
    $("#fileupload").on("click",function(){
       $("#avataUpload").click();
    });    
});

function readURL(input) {
    if (input.files && input.files[0]) {
        var reader = new FileReader();
       
        
        reader.onload = function (e) {
            $('#avatar').attr('src', e.target.result);
            $('#imageBase64').val(e.target.result);
        }
        
        reader.readAsDataURL(input.files[0]);
        
    }
}

$("#avataUpload").change(function(){
 	   var ext = this.value.match(/\.(.+)$/)[1];
 	    switch(ext)
 	    {
 	        case 'jpg':
 	        case 'bmp':
 	        case 'png':
 	        case 'tif':
 	        	readURL(this);
 	            break;
 	        default:
 	            alert('This file is not true format');
 	            this.value='';
  }
});
///////////////////////////////////////

// Change label to input


$(document).ready(function() {
	 $('#name').hide();
	 $('#emails').hide();
	 $('#phone').hide();
	 $('#address').hide();
	  $("#key a").click(function() {
	    var tar_id = $(this).attr("data-label");
	    $('#'+tar_id).show();
	    $("#dis label[for='"+tar_id+"']").hide();
	    
	    
	    $('#'+tar_id+' input').blur(function() {
	 	   var abc = $('#'+tar_id+' input').val();
	 	   $('#'+tar_id).hide();
	 	   $("#dis label[for='"+tar_id+"']").text(abc);
	 	   $("#dis label[for='"+tar_id+"']").show();
	 	 });
	  });
	});
/////////////////////////////////////

// Date Pịker
$(document).ready(function () {
    
    $('#example1').datepicker({
        format: "dd/mm/yyyy",
        language: lang
    });  

});

$(document).ready(function () {
	var show = 0;
	$('#userIf-more-hide').click(function () {
		if(show === 0){
			$('#caret-change').removeClass('fa fa-caret-down').addClass('fa fa-caret-up');
			show = 1;
		}else{
			$('#caret-change').removeClass('fa fa-caret-up').addClass('fa fa-caret-down');
			show = 0;
		}
	})
})

//////////// Ajax Edit Profile
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
 xhr.setRequestHeader(header, token);
});
$(document).ready(function() {

		$('#submitForm').submit(function(e) {
			var frm = $('#submitForm');
			$('#accountInfor').modal('hide');
			e.preventDefault();
			
		    var data = {}
		    var Form = this;
//
//		    //Gather Data also remove undefined keys(buttons)
		    $.each(this, function(i, v){
		            var input = $(v);
		        data[input.attr("name")] = input.val();
		        delete data["undefined"];
		    });
		    
		    var date = $('#example1').val();
		    var birthday = date.split("/").reverse().join("-");
		    data['birthday'] = birthday;
        $.ajax({
            contentType : 'application/json',
            type: "POST",
            url: frm.attr('action'),
            dataType : 'text',
            data : JSON.stringify(data),
            success:  function() {
            	showDialogSuccess('Cập nhật thông tin hoàn tất.', 2000);
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
	});

// register
$('#loading').hide();
$(document).ready(function() {
	$('#registerForm').submit(function(e) {
		var frm = $('#registerForm');
		e.preventDefault();
		$('#loading').show();
		
	    var data = {}
	    var Form = this;
//
//	    //Gather Data also remove undefined keys(buttons)
	    $.each(this, function(i, v){
	            var input = $(v);
	        data[input.attr("name")] = input.val();
	        delete data["undefined"];
	    });
    $.ajax({
        contentType : 'application/json',
        type: "POST",
        url: frm.attr('action'),
        dataType : 'text',
        data : JSON.stringify(data),
        success:  function() {
        	$('#login-logout').modal('hide');
        	showDialogSuccess('Đăng kí thành công. Vui lòng truy cập email để kích hoạt tài khoản', 2000);
        	///
        	$.ajax({
                contentType : 'application/json',
                type: "GET",
                url: 'sendEmailConfirmSigUp',
                dataType : 'text'
            });
        	///
        	var end = setTimeout(function () {
				window.location.replace('');
				clearTimeout(start);
			}, 1500);
		}
    });
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
Date.prototype.toString = function() {
  var result = (this.getDate() < 10 ? '0' : '') + this.getDate() + '/' + (this.getMonth() < 9 ? '0' : '') + (this.getMonth() + 1) + '/' + this.getFullYear() ;
  return result;
}
var loading;
loading = loading || (function () {
	var htmlPleaseWait="";
	htmlPleaseWait += "<div class=\"modal cus-modal fade bs-example-modal-sm\" id=\"myPleaseWait\" tabindex=\"-1\"";
	htmlPleaseWait += "    role=\"dialog\" aria-hidden=\"true\" data-backdrop=\"static\">";
	htmlPleaseWait += "    <div class=\"modal-dialog cus-modal-dialog modal-sm\">";
	htmlPleaseWait += "        <div class=\"modal-content\">";
	htmlPleaseWait += "            <div class=\"modal-header\">";
	htmlPleaseWait += "                <h4 class=\"modal-title\">";
	htmlPleaseWait += "                    <span class=\"glyphicon glyphicon-time\">";
	htmlPleaseWait += "                    <\/span>Please Wait";
	htmlPleaseWait += "                 <\/h4>";
	htmlPleaseWait += "            <\/div>";
	htmlPleaseWait += "            <div class=\"modal-body\">";
	htmlPleaseWait += "                <div class=\"progress\">";
	htmlPleaseWait += "                    <div class=\"progress-bar progress-bar-info";
	htmlPleaseWait += "                    progress-bar-striped active\"";
	htmlPleaseWait += "                    style=\"width: 100%\">";
	htmlPleaseWait += "                    <\/div>";
	htmlPleaseWait += "                <\/div>";
	htmlPleaseWait += "            <\/div>";
	htmlPleaseWait += "        <\/div>";
	htmlPleaseWait += "    <\/div>";
	htmlPleaseWait += "<\/div>";

    var pleaseWaitDiv = $(htmlPleaseWait);
    return {
        showPleaseWait: function() {
            pleaseWaitDiv.modal();
        },
        hidePleaseWait: function () {
            pleaseWaitDiv.modal('hide');
        },

    };
})();

var uploadImageAndCrop = function(image, inputImage, outputImage,
		defaultUrlImage, modal, cropWidth, cropHeight) {
	var URL = window.URL || window.webkitURL;
	var blobURL;
	var canvasData;

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
					if (file.size / 1048576 > 2) {
						showDialogError('Dung lượng ảnh không được vượt quá 2MB.', 10000);
					}else {
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
									}
								});
								img.src = reader.result;
							};
						})(file);
						reader.readAsDataURL(file);
					}
				} else {
					inputImage.val('');
				}
			}
		});
	}

	modal.find('#crop').click(function(e) {
		outputImage.find('img').attr('src', canvasData.toDataURL("image/jpeg", 0.9));
	});
	modal.on('hidden.bs.modal', function () {
		inputImage.val('');
	})
};

$('.btn-search').click(function(e) {
	e.preventDefault();
	var search = $('.search-event')
	window.location.replace('/ticketevent-web/search?n=' + convertVietnamese(search.val()));
});