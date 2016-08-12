//// Home Page
var getTotalOfYear = (function (year) {
	$.ajax({
	    type: "GET",
	    dataType: "text",
	    url: '/ticketevent-web/admin/getTotalByYear/'+year,
	    success: function(jsondata) {
	       $('#totalOfYearHome').text(jsondata);
	    }
	});
});

var countEventOfYear = (function (year) {
	$.ajax({
	    type: "GET",
	    dataType: "text",
	    url: '/ticketevent-web/admin/counterEventOfYear/'+year,
	    success: function(jsondata) {
	       $('#countEventOfYearHome').text(jsondata);
	    }
	});
});
$(document).ready(function () {
	var d = new Date();
	var n = d.getFullYear();
	countEventOfYear(n);
	getTotalOfYear(n);
})