var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
 xhr.setRequestHeader(header, token);
});

$(document).ready(function() {
	var	dataTable = $('#listBuyer').DataTable({
				  "pagingType": "full_numbers",
				  "bInfo" : false,
				  "lengthMenu": [ [10, 25, 50, -1], [10, 25, 50, "Tất cả"] ],
			        "oLanguage": {
			        "sZeroRecords": "Không tìm thấy kết quả nào",
			        "sEmptyTable": "Chưa có dữ liệu",
			        "sInfo": "Đang hiển thị _START_ - _TOTAL_",
			        "sInfoEmpty": "Không có dữ liệu để hiển thị",
			        "sLengthMenu": "Số lượng hiển thị :  _MENU_",
			        "oPaginate": {
			            "sPrevious": "<",
			            "sNext": ">",
			            "sFirst": "Đầu",
			            "sLast": "Cuối"
			          }
			        },
			        "order": [[ 1, 'asc' ]],
					  "aoColumnDefs": [{
					      "bSortable": false, 
					      "aTargets": [0, 2,  3,4]
					    }
			    ,
					  ],
			});
});


$(document).ready(function () {
	var eventId = $('.eventType').attr('id');
	getChartByDateOfEvent(eventId);
});

var getChartByDateOfEvent = (function(eventId) {
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
	                 url: '/ticketevent-web/getTotalByDateOfEvent/'+eventId,
	                 success: function(jsondata) {
	                	 var abc = [
									["Ngày", "Doanh thu"]
	                	            ];
	                		 
	                		 for(var i = 0, length = jsondata.length; i < length; i++){
	                			 var dateData = jsondata[i][0];
			           	    	 var profit = jsondata[i][1];
			           	    	 abc[i+1] = [dateData, profit];
	                		 }
	                		 
	                    var data = google.visualization.arrayToDataTable(abc);

	                    var options = {
	                            title: 'DOANH THU VÉ BÁN',
	                            hAxis: {title: '',  titleTextStyle: {color: '#333'}},
	                            vAxis: {
	                            	title: "Đơn vị : Nghìn đồng",
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