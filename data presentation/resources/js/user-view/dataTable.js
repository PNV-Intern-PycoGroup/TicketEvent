$(document).ready(function() {
	var	dataTable = $('#myEventTable').DataTable({
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
					      "aTargets": [0, 2,  3]
					    }
			    ,
//					    {
//			                "targets": [ 4 ],
//			                "visible": false,
//			            },
			            {
			                "targets": [ 5 ],
			                "visible": false,
			            }
					  ],
			});

	
	dataTable
	  .search( '' )
	  .columns(5).search( '1' )
	  .draw();
	 $('#btnEventNotAccept').click( function() {
		 dataTable.search( '' ).columns().search( '' ).draw();
		 dataTable
		  .search( '' )
		  .columns(5).search( '0' )
		  .draw();
	 } );
	 $('#btnEventPassed').click( function(e) { 
		 dataTable.search( '' ).columns().search( '' ).draw();
		 dataTable
		  .search( '' )
		  .columns(5).search( '1' )
		  .draw();
		 } );
});



$.ajax({
	contentType: 'application/json',
	type: 'GET',
	dataType: 'text',
	url:'/ticketevent-web/getEventPassed',
	success: function (jsondata) {
		var btText = $('#btnEventPassed').text();
		$('#btnEventPassed').text(btText + ' ('+jsondata+')');
	}
});


$.ajax({
	contentType: 'application/json',
	type: 'GET',
	dataType: 'text',
	url:'/ticketevent-web/getEventNotAcceptByUser',
	success: function (jsondata) {
		var btText = $('#btnEventNotAccept').text();
		$('#btnEventNotAccept').text(btText + ' ('+jsondata+')');
	}
});



var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
 xhr.setRequestHeader(header, token);
});
