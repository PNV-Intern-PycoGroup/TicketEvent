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
        }
        
        reader.readAsDataURL(input.files[0]);
    }
}

$("#avataUpload").change(function(){
    readURL(this);
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
        format: "dd/mm/yyyy"
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
		    console.log(data);
        $.ajax({
            //contentType : 'application/json; charset=utf-8',
            type: "POST",
            url: frm.attr('action'),
            dataType : 'json',
            data : JSON.stringify(data),
            data : data,
            success:  function() {
				debugger;
			},
            error: function (callback) {
                console.log(callback);
            }
        });
		});
	});


