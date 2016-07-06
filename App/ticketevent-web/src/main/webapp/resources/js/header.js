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



