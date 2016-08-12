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

var newTicketOrderDetail;
newTicketOrderDetail = newTicketOrderDetail || (function () {

	var viewTicketOrderDetailHtml="";
	viewTicketOrderDetailHtml += "<div class=\"modal fade\" data-backdrop=\"static\" role=\"dialog\" aria-labelledby=\"modalLabel\" tabindex=\"-1\">";
	viewTicketOrderDetailHtml += "  <div class=\"modal-dialog modal-lg\" role=\"document\">";
	viewTicketOrderDetailHtml += "    <div class=\"modal-content\">";
	viewTicketOrderDetailHtml += "      <div class=\"modal-header\">";
	viewTicketOrderDetailHtml += "        <button type=\"button\" class=\"close crop-none\" data-dismiss=\"modal\" aria-label=\"Close\">";
	viewTicketOrderDetailHtml += "        	<span aria-hidden=\"true\">&times;<\/span>";
	viewTicketOrderDetailHtml += "    	<\/button>";
	viewTicketOrderDetailHtml += "        <h4 class=\"modal-title\" id=\"modalLabel\"><\/h4>";
	viewTicketOrderDetailHtml += "      <\/div>";
	viewTicketOrderDetailHtml += "      <div class=\"modal-body\">";
	viewTicketOrderDetailHtml += "			<table class=\"table table-hover\">";
	viewTicketOrderDetailHtml += "				<thead>";
	viewTicketOrderDetailHtml += "					<tr>";
	viewTicketOrderDetailHtml += "						<th>Loại vé<\/th>";
	viewTicketOrderDetailHtml += "						<th>Giá vé<\/th>";
	viewTicketOrderDetailHtml += "						<th>Số lượng<\/th>";
	viewTicketOrderDetailHtml += "						<th>Tổng tiền<\/th>";
	viewTicketOrderDetailHtml += "					<\/tr>";
	viewTicketOrderDetailHtml += "				<\/thead>";
	viewTicketOrderDetailHtml += "				<tbody id=\"listOrder\">";
	viewTicketOrderDetailHtml += "				<\/tbody>";
	viewTicketOrderDetailHtml += "			<\/table>";
	viewTicketOrderDetailHtml += "		<div class=\"clear\"><\/div>";
	viewTicketOrderDetailHtml += "      <\/div>";
	viewTicketOrderDetailHtml += "      <div class=\"modal-footer\">";
	viewTicketOrderDetailHtml += "        <button type=\"button\" class=\"btn btn-default crop-none\" data-dismiss=\"modal\">Ok<\/button>";
	viewTicketOrderDetailHtml += "      <\/div>";
	viewTicketOrderDetailHtml += "    <\/div>";
	viewTicketOrderDetailHtml += "  <\/div>";
	viewTicketOrderDetailHtml += "<\/div>";

	var loopTicketOrderDetail = "";
	loopTicketOrderDetail += "<tr>";
	loopTicketOrderDetail += "	<td><p class=\"ticket-name\">";
	loopTicketOrderDetail += "		<\/p><\/td>";
	loopTicketOrderDetail += "	<td><p class=\"ticket-price\">";
	loopTicketOrderDetail += "		<\/p><\/td>";
	loopTicketOrderDetail += "	<td><p class=\"ticket-quantity\">";
	loopTicketOrderDetail += "		<\/p><\/td>";
	loopTicketOrderDetail += "	<td><p class=\"ticket-total-price\">";
	loopTicketOrderDetail += "		<\/p><\/td>";
	loopTicketOrderDetail += "<\/tr>";
	var ticketOrderDetailModalDiv = $(viewTicketOrderDetailHtml);
	var titleModal = ticketOrderDetailModalDiv.find('#modalLabel');
	var listOrderContainer = ticketOrderDetailModalDiv.find('#listOrder');
	var table = ticketOrderDetailModalDiv.find('table');
	var loadingIcon = $('<tr><td></td><td><i class=\"fa fa-spinner fa-pulse fa-3x fa-fw\"></i></td><td></td></tr>')
	var resetValue = function() {
		titleModal.text('');
		listOrderContainer.empty();
		listOrderContainer.append(loadingIcon);
	}
	
	var dataTable;
	var	showTable = function() {
		if ($.fn.DataTable.isDataTable(table)) {
			dataTable.destroy();
		}
		
		dataTable= table.DataTable({
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
				  ],
		});
	};
	
	var getListOrderData = function(buyerId) {
		$.ajax({
		    type: 'GET',
		    url: "/ticketevent-web/api/get-list-order-ticket/" + buyerId
		})
		.done(function(data) {
			listOrderContainer.empty();
			$.each(data, function(key, order) {
				var item = $(loopTicketOrderDetail);
				var itemName = item.find('.ticket-name');
				var itemPrice = item.find('.ticket-price');
				var itemQuantity = item.find('.ticket-quantity');
				var itemTotalPrice = item.find('.ticket-total-price');
				itemName.text(order.ticket.name);
				itemPrice.text(order.ticket.price);
				itemQuantity.text(order.quantity);
				var numPrice = parseInt(order.ticket.price) == NaN ? 0 : parseInt(order.ticket.price);
				var numQuantity = parseInt(order.quantity) == NaN ? 0 : parseInt(order.quantity);
				var total = numPrice * numQuantity;
				itemTotalPrice.text(total);
				listOrderContainer.append(item);
				showTable();
			});
		})
		.fail(function(xhr) {
			if (xhr.status === 404) {
				window.location.replace('/ticketevent-web/error/404');
			}else if (xhr.status === 403) {
				window.location.replace('/ticketevent-web/error/403');
			}
		});
	}
	
    return {
        showTicketOrderDetailModal: function(title, buyerId) {
        	resetValue();
        	titleModal.text(title);
        	ticketOrderDetailModalDiv.modal();
        	getListOrderData(buyerId);
        }
    };
})();

$('.buyer-item').each(function(i) {
	$(this).click(function(e) {
		var a = $(this);
		var itemId = $(this).find('.buyer-id');
		var buyerId = itemId.val() === '' ? 0 : itemId.val();
		newTicketOrderDetail.showTicketOrderDetailModal('Đặt vé chi tiết.', buyerId);
	});
});