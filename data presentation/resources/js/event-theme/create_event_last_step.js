var pathLastStep =  $('#path-last-step');
var btnCopyPath = $('#copy-path');

if (tinyMCE.get('send-email') != null) {
	tinyMCE.get('send-email').remove();
}

tinymce.init({
	selector: '#send-email',
	plugins: [
                 'advlist autolink link image lists charmap preview hr anchor',
                 'searchreplace wordcount visualblocks visualchars media',
                 'save table contextmenu directionality paste textcolor'
             ],
	a_plugin_option: true,
	language: lang,
	language_url: '/ticketevent-web/resources/js/lib/vi_VN.js',
	a_configuration_option: 400,
	height: 300,
	toolbar: 'undo redo | styleselect | bold italic | alignleft aligncenter alignright alignjustify '
		+ '| bullist numlist outdent indent | link image | preview media fullpage | forecolor backcolor',
		plugin_preview_width: $('section').width(),
		plugin_preview_height: $(window).height() - 100
});

var createEventFinish = function() {
	loading.showPleaseWait();
	var id = eventId === '' || eventId === undefined ? null : eventId;
	var path = pathLastStep.val();
	var isPublic = $('input[name="isPrivate"]:checked').val();
	var confirmEmail = tinyMCE.get('send-email').getContent();
	var event = {
		id: id,
		path: path === '' ? null : path,
		isPublic: isPublic === '' ? null : isPublic,
		confirmEmail: confirmEmail === '' ? null : confirmEmail
	}
	debugger;
	$.ajax({
	    type: 'POST',
	    url: "/ticketevent-web/create-event-finish",
	    contentType : 'application/json; charset=utf-8',
     	dataType : 'text',
	    data : JSON.stringify(event)
	})
	.done(function(data) {
		loading.hidePleaseWait();
		if (data === 'notPermission') {
			window.location.replace('/ticketevent-web/error/403');
		}else if (data === 'loginError') {
			if (eventId !== '' || eventId !== undefined) {
				window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
			}
			window.location.replace('/ticketevent-web/login/create-event');
		}else if (data === 'existPathError') {
			showDialogError('Đường dẫn đến sự kiện của bạn đã tồn tại.', 5000);
			showDialogSuccess('Cài đặt của bạn đã được tạm lưu.', 5000);
		}else if (data === 'createEventlastStepSuccess') {
			showDialogError('Hãy điền đầy đủ thông tin.', 5000);
			showDialogSuccess('Cài đặt của bạn đã được tạm lưu.', 5000);
		}else {
			showDialogSuccess('Sự kiện của bạn đã được tạo thành công. Vui lòng chờ phản hồi xác nhận sự kiện của bạn qua email của chúng tôi trong vòng 24h tới.', 15000);
		}
	})
	.fail(function(xhr) {
		loading.hidePleaseWait();
		showDialogError('Server error.', 5000);
		if (xhr.status === 404) {
			window.location.replace('/ticketevent-web/error/404');
		}else if (xhr.status === 403) {
			window.location.replace('/ticketevent-web/error/403');
		}
	});
}

$('#create-event-finish').click(function(e) {
	createEventFinish();
});

$('.contain-radio').on('click', function(e) {
	$(this).find('input[type=radio]').prop('checked', true);
});

btnCopyPath.click(function(e) {
	var $temp = $("<input>");
	$("body").append($temp);
	$temp.val('https://ticketevent.vn/event/' + pathLastStep.val()).select();
	document.execCommand("copy");
	$temp.remove();
});

// create ticket
var addTicket = $('#add-ticket');
var containTicket = $('.contain-ticket');

var newTicket;
newTicket = newTicket || (function () {

	var newTicketHtml="";
	newTicketHtml += "<div class=\"modal fade\" id=\"new-content-modal\" data-backdrop=\"static\" role=\"dialog\" aria-labelledby=\"modalLabel\" tabindex=\"-1\">";
	newTicketHtml += "  <div class=\"modal-dialog modal-lg\" role=\"document\">";
	newTicketHtml += "    <div class=\"modal-content\">";
	newTicketHtml += "      <div class=\"modal-header\">";
	newTicketHtml += "        <button type=\"button\" class=\"close crop-none\" data-dismiss=\"modal\" aria-label=\"Close\">";
	newTicketHtml += "        	<span aria-hidden=\"true\">&times;<\/span>";
	newTicketHtml += "    	<\/button>";
	newTicketHtml += "        <h4 class=\"modal-title\" id=\"modalLabel\"><\/h4>";
	newTicketHtml += "      <\/div>";
	newTicketHtml += "      <div class=\"modal-body\">";
	newTicketHtml += "        	<div>";
	newTicketHtml += "        		<div class=\"col-md-6\">";
	newTicketHtml += "					<div class=\"input-group cus-input-group contain-radio cus-input-group-vertical-padding\">";
	newTicketHtml += "						<span class=\"input-group-addon cus-input-group-addon-create-event\">Tên vé<\/span>";
	newTicketHtml += "						<input type=\"text\" id=\"ticket-name\" class=\"form-control\" \/>";
	newTicketHtml += "					<\/div>";
	newTicketHtml += "				<\/div>";
	newTicketHtml += "				<div class=\"col-md-6\">";
	newTicketHtml += "					<div class=\"input-group cus-input-group contain-radio cus-input-group-vertical-padding\">";
	newTicketHtml += "						<span class=\"input-group-addon cus-input-group-addon-create-event\">Giá vé (VND)<\/span>";
	newTicketHtml += "						<input type=\"number\" id=\"ticket-price\" class=\"form-control\" \/>";
	newTicketHtml += "						<span class=\"input-group-addon cus-input-group-addon-create-event\">";
	newTicketHtml += "							<input id=\"ticket-is-free\" type=\"checkbox\" name=\"isFree\" \/>  Miễn phí<\/span>";
	newTicketHtml += "					<\/div>";
	newTicketHtml += "				<\/div>";
	newTicketHtml += "			<\/div>";
	newTicketHtml += "			<div class=\"col-md-12\">";
	newTicketHtml += "				<span class=\"label-event-info cus-input-group-addon-create-event\">Mô tả về vé<\/span>";
	newTicketHtml += "				<textarea id=\"ticket-description\" class=\"textarea-event-info\" ><\/textarea>";
	newTicketHtml += "			<\/div>";
	newTicketHtml += "			<div class=\"clear\"><\/div>";
	newTicketHtml += "      <\/div>";
	newTicketHtml += "      <div class=\"modal-footer\">";
	newTicketHtml += "        	<button id=\"save-ticket\" type=\"button\" class=\"btn btn-default\" data-dismiss=\"modal\">Save<\/button>";
	newTicketHtml += "       	<button type=\"button\" class=\"btn btn-default crop-none\" data-dismiss=\"modal\">Close<\/button>";
	newTicketHtml += "       	<input type=\"hidden\" id=\"ticket-id\" \/>";
	newTicketHtml += "      <\/div>";
	newTicketHtml += "    <\/div>";
	newTicketHtml += "  <\/div>";
	newTicketHtml += "<\/div>";

	var ticketModalDiv = $(newTicketHtml);
	var titleModal = ticketModalDiv.find('#modalLabel');
	var ticketName = ticketModalDiv.find('#ticket-name');
	var ticketPrice = ticketModalDiv.find('#ticket-price');
	var ticketDescription = ticketModalDiv.find('#ticket-description');
	var ticketIsFree = ticketModalDiv.find('#ticket-is-free');
	var btnSaveTicket = ticketModalDiv.find('#save-ticket');
	var ticketId = ticketModalDiv.find('#ticket-id');

	var resetValue = function() {
		titleModal.text('');
		ticketName.val('');
		ticketId.val('');
		ticketDescription.val('');
		ticketPrice.val('');
		ticketIsFree.attr('checked', false);
	}
	var data;
    var session = false;
    return {
        addTicketModal: function(title, funcSaveCallBack, funcHiddenModalCallBack) {
        	resetValue();
        	titleModal.text(title);

        	var eventSaveTicket = function(e) {
        		if (session) {
        		    data = {
    		    		id: ticketId.val() === '' ? null : ticketId.val(),
	    				event: eventId === '' ? null : {id: eventId},
	    				name: ticketName.val() === '' ? null : ticketName.val(),
						price: ticketIsFree.is(':checked') ? 0 : (ticketPrice.val() === '' ? 0 : ticketPrice.val()),
						description: ticketDescription.val() === '' ? null : ticketDescription.val(),
						isFree: ticketIsFree.is(':checked') ? 1 : 0
        		    }
        			funcSaveCallBack();
            		session = false;
				}
            	btnSaveTicket.unbind('click', eventSaveTicket);
        	}
        	btnSaveTicket.bind('click', eventSaveTicket);
        	
        	var eventHideModal = function () {
        		funcHiddenModalCallBack();
        		session = false;
            	ticketModalDiv.unbind('hidden.bs.modal', eventHideModal);
        	}
        	ticketModalDiv.bind('hidden.bs.modal', eventHideModal);
        	
        	var eventShowModal = function () {
            	session = true;
            	ticketModalDiv.unbind('shown.bs.modal', eventShowModal);
        	}
        	ticketModalDiv.bind('shown.bs.modal', eventShowModal);
        	return ticketModalDiv;
        },
        editTicketModal: function(ticket, title, funcSaveCallBack, funcHiddenModalCallBack) {
        	ticketId.val(ticket.id);
        	ticketName.val(ticket.name);
        	ticketPrice.val(ticket.price);
        	ticketDescription.val(ticket.description);
        	if (ticket.isFree == 1) {
        		ticketIsFree.attr('checked', true);
			}else {
				ticketIsFree.attr('checked', false);
			}
        	titleModal.text(title);

        	var eventSaveTicket = function(e) {
        		if (session) {
        		    data = {
    		    		id: ticketId.val() === '' ? null : ticketId.val(),
	    				event: eventId === '' ? null : {id: eventId},
	    				name: ticketName.val() === '' ? null : ticketName.val(),
						price: ticketIsFree.is(':checked') ? 0 : (ticketPrice.val() === '' ? 0 : ticketPrice.val()),
						description: ticketDescription.val() === '' ? null : ticketDescription.val(),
						isFree: ticketIsFree.is(':checked') ? 1 : 0
        		    }
        			funcSaveCallBack();
            		session = false;
				}
            	btnSaveTicket.unbind('click', eventSaveTicket);
        	}
        	btnSaveTicket.bind('click', eventSaveTicket);
        	
        	var eventHideModal = function () {
        		funcHiddenModalCallBack();
        		session = false;
            	ticketModalDiv.unbind('hidden.bs.modal', eventHideModal);
        	}
        	ticketModalDiv.bind('hidden.bs.modal', eventHideModal);
        	
        	var eventShowModal = function () {
            	session = true;
            	ticketModalDiv.unbind('shown.bs.modal', eventShowModal);
        	}
        	ticketModalDiv.bind('shown.bs.modal', eventShowModal);
        	return ticketModalDiv;
        },
        getData: function() {
			return data;
		}
    };
})();

var ticketFactory;
ticketFactory = ticketFactory || (function() {
	var ticketFactoryHtml="";
	ticketFactoryHtml += "<div class=\"ticket\">";
	ticketFactoryHtml += "	<div class=\"col-md-6\">";
	ticketFactoryHtml += "		<div class=\"input-group cus-input-group contain-radio cus-input-group-vertical-padding\">";
	ticketFactoryHtml += "			<span class=\"input-group-addon\">Tên vé<\/span>";
	ticketFactoryHtml += "			<span class=\"form-control ticket-name\" ><\/span>";
	ticketFactoryHtml += "		<\/div>";
	ticketFactoryHtml += "	<\/div>";
	ticketFactoryHtml += "	<div class=\"col-md-6\">";
	ticketFactoryHtml += "		<div class=\"input-group cus-input-group contain-radio cus-input-group-vertical-padding\">";
	ticketFactoryHtml += "			<span class=\"input-group-addon cus-input-group-addon-create-event\">Giá vé (VND)<\/span>";
	ticketFactoryHtml += "			<label class=\"form-control ticket-price\"><\/label>";
	ticketFactoryHtml += "		<\/div>";
	ticketFactoryHtml += "	<\/div>";
	ticketFactoryHtml += "	<div class=\"col-md-12\">";
	ticketFactoryHtml += "		<span class=\"label-event-info\">Mô tả về vé<\/span>";
	ticketFactoryHtml += "		<p class=\"textarea-event-info ticket-description\" ><\/p>";
	ticketFactoryHtml += "	<\/div>";
	ticketFactoryHtml += "	<input type=\"hidden\" class=\"ticket-id\" \/>";
	ticketFactoryHtml += "	<div class=\"clear\"><\/div>";
	ticketFactoryHtml += "	<hr class=\"divider\">";
	ticketFactoryHtml += "<\/div>";

	return {
		getTicketFactory: function(ticket) {
			var ticketFactoryDiv = $(ticketFactoryHtml);
			var ticketName = ticketFactoryDiv.find('.ticket-name');
			var ticketPrice = ticketFactoryDiv.find('.ticket-price');
			var ticketDescription = ticketFactoryDiv.find('.ticket-description');
			var ticketId = ticketFactoryDiv.find('.ticket-id');

			var prepareTicketPrice = ticket.isFree == 1 ? 0 : ticket.price;
			ticketName.text(ticket.name);
			ticketPrice.text(prepareTicketPrice);
			ticketDescription.text(ticket.description);
			ticketId.text(ticket.id);
			
			return ticketFactoryDiv;
		}
	};
})();

var createTicket = function(ticket) {
	$.ajax({
	    type: 'POST',
	    url: "/ticketevent-web/create-ticket",
	    contentType : 'application/json; charset=utf-8',
     	dataType : 'text',
	    data : JSON.stringify(ticket)
	})
	.done(function(data) {
		loading.hidePleaseWait();
		if (data === 'notPermission') {
			window.location.replace('/ticketevent-web/error/403');
		}else if (data === 'loginError') {
			if (eventId !== '' || eventId !== undefined) {
				window.location.replace('/ticketevent-web/login/edit-event+' + eventId);
			}
			window.location.replace('/ticketevent-web/login/create-event');
		}else if (data === 'notFound') {
			window.location.replace('/ticketevent-web/error/404');
		}else if (data === 'sendDataError') {
			showDialogError('Dữ liệu gửi lên bị lỗi, Bạn hãy điền đầy đủ thông tin.', 5000);
		}else {
			var ticketFactoryDiv = ticketFactory.getTicketFactory(JSON.parse(data));
			containTicket.append(ticketFactoryDiv);
		}
	})
	.fail(function(xhr) {
		loading.hidePleaseWait();
		showDialogError('Server error.', 5000);
		if (xhr.status === 404) {
			window.location.replace('/ticketevent-web/error/404');
		}else if (xhr.status === 403) {
			window.location.replace('/ticketevent-web/error/403');
		}
	});
}

addTicket.click(function(e) {
	e.preventDefault();
	newTicket.addTicketModal('new ticket', function() {
		createTicket(newTicket.getData());
	}, function() {}).modal();
});