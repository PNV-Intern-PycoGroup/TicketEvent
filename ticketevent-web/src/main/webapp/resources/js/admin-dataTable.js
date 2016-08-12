
// User Management

$(document).ready(function() {
	var	dataTable = $('#myDatatable').dataTable({
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
			            "sFirst":"Đầu",
			            "sLast": "Cuối"
			          }
			        },
			    "order": [[ 2, 'asc' ]],
			    "aoColumnDefs": [{
					      "bSortable": false, 
					      "aTargets": [0, 1, 5, 6]
					    }
			    ,
					    {
			                "targets": [ 3 ],
			                "visible": false,
			            }
					  ],
			});

	 $("#usermanage-search").on("keyup search input paste cut", function() {
		 dataTable.fnFilter(this.value);
	});
	 dataTable.fnFilter( '2', 3 );
  $('#sel1').change( function() { dataTable.fnFilter( $(this).val(), 3 ); } );
});




//Comment Management
$(document).ready(function() {
  var dataTable = $('#myDataComment').DataTable({
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
            "sFirst":"Đầu",
            "sLast": "Cuối"
          }
        },
        "order": [[ 3, 'asc' ]],
		  "aoColumnDefs": [{
		      "bSortable": false, 
		      "aTargets": [0, 1, 2, 4, 6]
		    }],
    });
  $("#comment-search").on("keyup search input paste cut", function() {
	   dataTable.search(this.value).draw();
});
} );


// Event Management
$(document).ready(function() {
	  var dataTable = $('#myEventTable').DataTable({
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
	            "sFirst":"Đầu",
	            "sLast": "Cuối"
	          }
	        },
	        "order": [[ 4, 'asc' ]],
			  "aoColumnDefs": [{
			      "bSortable": false, 
			      "aTargets": [0, 2, 3, 5, 7]
			    }],
	    });
	  $("#event-search").on("keyup search input paste cut", function() {
		   dataTable.search(this.value).draw();
	});
} );

