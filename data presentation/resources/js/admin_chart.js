// TICKET EVENT CHART
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
 xhr.setRequestHeader(header, token);
});

var getChartByYear = (function(year) {
	$.ajax({
		  url: 'https://www.google.com/jsapi?callback',
		  cache: true,
		  dataType: 'script',
		  success: function(){
		    google.load('visualization', '1', {packages:['corechart'], 'callback' : function()
		      {
		            $.ajax({
		                 type: "GET",
		                 dataType: "json",
		                 url: '/ticketevent-web/admin/getTotal/'+year,
		                 success: function(jsondata) {
		                	 var abc = [
										["Tháng", "Doanh thu"],
										["Tháng 1", 0],
										["Tháng 2", 0],
										["Tháng 3", 0],
										["Tháng 4", 0],
										["Tháng 5", 0],
										["Tháng 6", 0],
										["Tháng 7", 0],
										["Tháng 8", 0],
										["Tháng 9", 0],
										["Tháng 10", 0],
										["Tháng 11", 0],
										["Tháng 12", 0]
		                	            ];
		                	 for(var a = 1; a < abc.length; a++){
		                		 var monthString = abc[a][0];
		                		 var month = monthString.substring(6, monthString.length);
		                		 
		                		 for(var i = 0, length = jsondata.length; i < length; i++){
		                			 var monthData = jsondata[i][0];
				           	    	 var profit = jsondata[i][1];
				           	    	 if(monthData == month){
				           	    		 abc[a] = ["Tháng "+month, profit];
				           	    	 }
		                		 }
		                	 }
		                    var data = google.visualization.arrayToDataTable(abc);

		                    var options = {
		                            title: 'DOANH THU VÉ BÁN THEO NĂM '+year,
		                            hAxis: {title: 'Năm '+year,  titleTextStyle: {color: '#333'}},
		                            vAxis: {
		                            	title: "Đơn vị : Triệu đồng",
		                            	minValue: 0}
		                          };

		                    var chart = new google.visualization.AreaChart(document.getElementById('areaChart'));
		                    chart.draw(data, options);
		                    $(window).resize(function(){
		                    	chart.draw(data, options);
		                    });
		                 }
		            });    
		      }
		    });
		    return true;
		  }
	});
});

var getTotalOfYear = (function (year) {
	$.ajax({
	    type: "GET",
	    dataType: "text",
	    url: '/ticketevent-web/admin/getTotalByYear/'+year,
	    success: function(jsondata) {
	       $('#totalOfYear').text(jsondata);
	    }
	});
});

var countEventOfYear = (function (year) {
	$.ajax({
	    type: "GET",
	    dataType: "text",
	    url: '/ticketevent-web/admin/counterEventOfYear/'+year,
	    success: function(jsondata) {
	       $('#countEventOfYear').text(jsondata);
	    }
	});
});

$(document).ready(function () {
	$.ajax({
	    type: "GET",
	    dataType: "json",
	    url: '/ticketevent-web/admin/getYear',
	    success: function(jsondata) {
	    	$.each(jsondata, function(i, value) {
	            $('#selectYear').append($('<option>').text('Năm '+value).attr('value', value));
	        });
	    	var year = $('#selectYear').val();
	    	getChartByYear(year);
	    	getTotalOfYear(year);
	    	countEventOfYear(year);
	    }
	});
	
	
	$('#selectYear').change(function () {
		var year = $(this).val();
		getChartByYear(year);
		getTotalOfYear(year);
		countEventOfYear(year);
	});
});