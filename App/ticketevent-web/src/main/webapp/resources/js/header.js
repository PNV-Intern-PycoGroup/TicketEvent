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


$('#edit').click(function() {
	 var text = $('.text-info').text();
	 var input = $('<input id="attribute" type="text" value="' + text + '" />')
	 $('.text-info').text('').append(input);
	 input.select();

	 input.blur(function() {
	   var text = $('#attribute').val();
	   $('#attribute').parent().text(text);
	   $('#attribute').remove();
	 });
	});


$(document).ready(function() {
	  $("a").click(function() {
	    var tar_id = $(this).attr("data-label");
	    var tar = $("label[for='"+tar_id+"']");
	    var val = tar.text();
	    tar.replaceWith("<input type='text' name='"+tar_id+"' id='"+tar_id+"' value='"+val+"' />");
	  });
	});
