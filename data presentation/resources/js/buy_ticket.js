var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function(e, xhr, options) {
	xhr.setRequestHeader(header, token);
});

var buyerName = $('#buyer-name');
var buyerGender = $('#buyer-gender');
var buyerAddress = $('#buyer-address');
var buyerPhoneNumber = $('#buyer-phone-number');
var buyerDateOfBirth = $('#buyer-date-of-birth');
var containTicket = $('.contain-ticket');

var btnSaveBuyTicket = $('#btn-save-buy-ticket');

var formatDDMMYYYYToMMDDYYY = function(DDMMYYY) {
	var splitDate = DDMMYYY.split('/');
	if (splitDate.length !== 3) {
		return '';
	}
	return splitDate[1] + '/' + splitDate[0] + '/' + splitDate[2];
}

var language = $('.lang-footer').text();
var lang = 'vi_VN';
if (language === 'Languages') {
	lang = 'en';
}

var saveBuyTicket = function(buyerTicketData) {
	var url = window.location.href;
	var eventId = url.substring(url.lastIndexOf('/') + 1);
	$.ajax({
	    type: 'POST',
	    url: "/ticketevent-web/buy-ticket/" + eventId ,
	    contentType : 'application/json; charset=utf-8',
     	dataType : 'text',
	    data: JSON.stringify(buyerTicketData)
	})
	.done(function(data) {
		alert(data);
	})
	.fail(function(xhr) {
		if (xhr.status === 404) {
			window.location.replace('/ticketevent-web/error/404');
		}else if (xhr.status === 403) {
			window.location.replace('/ticketevent-web/error/403');
		}
	});
}
var listOrder = containTicket.find('.input-group');
listOrder.each(function (i) {
	var quantity = $(this).find('.ticket-quantity');
	var ticketPrice = $(this).find('.ticket-price');
	var ticketTotalPrice = $(this).find('.total-money-ticket');
	quantity.on('input', function(e) {
		var numQuantity = parseInt(quantity.val()) == NaN || parseInt(quantity.val()) < 0 ? 0 : parseInt(quantity.val());
		var numTicketPrice = parseInt(ticketPrice.val()) == NaN || parseInt(ticketPrice.val()) < 0 ? 0 : parseInt(ticketPrice.val());
		var numTotalPrice = numQuantity * numTicketPrice;
		ticketTotalPrice.text('Số lượng: ' + numTotalPrice + ' VNĐ');
	});
});
buyerDateOfBirth.datepicker({
	startView: 2,
	endDate: 'today',
	format: "dd/mm/yyyy",
	language: lang,
	autoclose: true
});

btnSaveBuyTicket.click(function(e) {
	var listTicketOrder = [];
	listOrder.each(function (i) {
		var quantity = $(this).find('.ticket-quantity').val();
		var ticketId = $(this).find('.ticket-id').val();
		if (quantity != '' || quantity != 0) {
			var item = {
				ticket: ticketId === '' ? null : {id: ticketId},
				quantity: quantity
			};
			listTicketOrder.push(item);
		}
	});
	var buyerTicketData = {
		name: buyerName.val() === '' ? null : buyerName.val(),
		address: buyerAddress.val() === '' ? null : buyerAddress.val(),
		phone: buyerPhoneNumber.val() === '' ? null : buyerPhoneNumber.val(),
		gender: buyerGender.val() === '' ? null : buyerGender.val(),
		dateOfBirth: buyerDateOfBirth.val() === '' ? null : new Date(formatDDMMYYYYToMMDDYYY(buyerDateOfBirth.val()) + ' 00:00'),
		listTicketOrder: listTicketOrder.length == 0 ? null : listTicketOrder
	};
	
	saveBuyTicket(buyerTicketData);
});