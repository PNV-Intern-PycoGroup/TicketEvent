$(function() {
	var containEventThumbnail = $('#contain-event-thumbnail');
	var btnEventPre = $('.btn-event-pre');
	var btnEventNext = $('.btn-event-next');
	var btnEventCurrent = $('.btn-event-current');
	var searchEvent = $('.search-event');
	var ulShowSearch = $('.show-search');
	var eventThumbnail;
	eventThumbnail = eventThumbnail || (function() {
		var thumbnailEventHtml="";
		thumbnailEventHtml += "<div class=\"col-sm-6 event-fix event-thumbnail\">";
		thumbnailEventHtml += "		<div class=\"event-child\">";
		thumbnailEventHtml += "			<a class=\"href-event-to-detail\" href=\"\"><img class=\"image-thumbnail\" alt=\"image thumbnail\" src=\"\"><\/a>";
		thumbnailEventHtml += "			<div class=\"event-detail\">";
		thumbnailEventHtml += "				<div class=\"event-title event-name\"><\/div>";
		thumbnailEventHtml += "				<div class=\"event-infor\">";
		thumbnailEventHtml += "					<div class=\"event-price\"><\/div>";
		thumbnailEventHtml += "					<div class=\"event-action\">";
		thumbnailEventHtml += "						<div class=\"event-location table-cell\"><\/div>";
		thumbnailEventHtml += "						<div class=\"event-category table-cell\">";
		thumbnailEventHtml += "							<i class=\"fa fa-th\" aria-hidden=\"true\"><\/i> <span class=\"event-type\"><\/span>";
		thumbnailEventHtml += "						<\/div>";
		thumbnailEventHtml += "						<div class=\"table-cell\"><a href=\"\"><span class=\"event-comment-count\"><\/span> <i class=\"fa fa-commenting\" aria-hidden=\"true\"><\/i><\/a><\/div>";
		thumbnailEventHtml += "					<\/div>";
		thumbnailEventHtml += "					<div class=\"ribbon-wrapper\">";
		thumbnailEventHtml += "						<div class=\"ribbon-month calendar-month\"><\/div>";
		thumbnailEventHtml += "						<div class=\"ribbon-date calendar-date\"><\/div>";
		thumbnailEventHtml += "						<div class=\"ribbon-dayofweek calendar-day-on-week\"><\/div>";
		thumbnailEventHtml += "					<\/div>";
		thumbnailEventHtml += "				<\/div>";
		thumbnailEventHtml += "			<\/div>";
		thumbnailEventHtml += "		<\/div>";
		thumbnailEventHtml += "	<\/div>";
		
		return {
			eventThumbnail: function(event) {
				var eventThumbnail = $(thumbnailEventHtml);
				var hrefEventToDetail = eventThumbnail.find('.href-event-to-detail');
				var imageThumbnail = eventThumbnail.find('.image-thumbnail');
				var eventName = eventThumbnail.find('.event-name');
				var eventPrice = eventThumbnail.find('.event-price');
				var eventLocation = eventThumbnail.find('.event-location');
				var eventType = eventThumbnail.find('.event-type');
				var eventCommentCount = eventThumbnail.find('.event-comment-count');
				var calendarMonth = eventThumbnail.find('.calendar-month');
				var calendarDate = eventThumbnail.find('.calendar-date');
				var calendarDayOnWeek = eventThumbnail.find('.calendar-day-on-week');
				
				hrefEventToDetail.attr('href', '/ticketevent-web/event/' + event.path);
				imageThumbnail.attr('src', '/ticketevent-web/resources/images/' + event.imageThumbnail);
				eventName.text(event.name);
				eventPrice.text(); // need TODO ========================================
				eventLocation.text(event.place.split(', ')[1]);
				eventType.text(event.eventType.name);
				eventCommentCount.text(event.listComment == null ? 0 : event.listComment.length);
				eventCommentCount.parent().attr('href', '/ticketevent-web/event/' + event.path);
				var eventDate = new Date(event.startDate);
				calendarMonth.text($.fn.datepicker.dates[lang].months[eventDate.getMonth()]);
				calendarDate.text(eventDate.getDate());
				calendarDayOnWeek.text($.fn.datepicker.dates[lang].days[eventDate.getDay()]);
				return eventThumbnail;
			}
		};
	})();
	
	var countCourse = function() {
		var count = 0;
		for ( var i = 0; i < allEvent.length; i++) {
			if (allEvent[i].eventType.name === 'Khóa Học') {
				count ++;
			}
		}
		return count;
	}
	
	var countActivity = function() {
		var count = 0;
		for ( var i = 0; i < allEvent.length; i++) {
			if (allEvent[i].eventType.name === 'Hoạt Động') {
				count ++;
			}
		}
		return count;
	}
	
	var countMusic = function() {
		var count = 0;
		for ( var i = 0; i < allEvent.length; i++) {
			if (allEvent[i].eventType.name === 'Âm Nhạc') {
				count ++;
			}
		}
		return count;
	}
	var showCategory = function() {
		$('#course-count').text(countCourse());
		$('#activity-count').text(countActivity());
		$('#music-count').text(countMusic());
	}
	// page
	var currentPage = 1;
	var allEvent;
	
	$.ajax({
	    type: 'GET',
	    url: "/ticketevent-web/api/get-all-event",
	    contentType : 'application/json; charset=utf-8',
	 	dataType : 'text'
	})
	.done(function(data) {
	 	if (data !== '') {
	 		allEvent = JSON.parse(data);
	 		currentPage = 1;
	 		showEvent();
	 		showCategory();
	 		
	 	}else {
	 		$('.event-container').html($('<p>Không có sự kiện nào vào thời điểm sắp tới.<\/p>'))
	 	}
	})
	.fail(function(xhr) {
		if (xhr.status === 404) {
			window.location.replace('/ticketevent-web/error/404');
		}else if (xhr.status === 403) {
			window.location.replace('/ticketevent-web/error/403');
		}
	});
	
	var getPageEventData = function(pageIndex) {
		var result = [];
		var eventNumberEachPage = 10;
		var minIndex = (pageIndex - 1) * eventNumberEachPage;
		var maxIndex = pageIndex * eventNumberEachPage;
		if (minIndex > allEvent.length - 1 || pageIndex <= 0) {
			return null;
		}
		if (maxIndex > allEvent.length) {
			maxIndex = allEvent.length;
		}
		for (var index = minIndex; index < maxIndex; index++) {
			result.push(allEvent[index]);
		}
		return result;
	}
	
	var showEvent = function() {
		btnEventCurrent.text(currentPage);
		var jsonListEvent = getPageEventData(currentPage);
		if (getPageEventData(currentPage + 1) === null) {
			btnEventNext.addClass('disabled');
		}else {
			btnEventNext.removeClass('disabled');
		}
		if (getPageEventData(currentPage - 1) === null) {
			btnEventPre.addClass('disabled');
		}else {
			btnEventPre.removeClass('disabled');
		}
		if (jsonListEvent != null) {
			var index;
			for (index = 0; index < jsonListEvent.length; index++) {
	 			var event = jsonListEvent[index];
	 			var blockEvent = eventThumbnail.eventThumbnail(event);
	 			if (containEventThumbnail.find('.event-thumbnail').length > index + 1) {
	 				containEventThumbnail.find('.event-thumbnail')[0].remove();
				}
	 			blockEvent.hide();
	 			containEventThumbnail.append(blockEvent);
	 			blockEvent.fadeIn(500);
	 		}
			if (containEventThumbnail.find('.event-thumbnail').length > index) {
				for (var i = index; i < containEventThumbnail.find('.event-thumbnail').length; i++) {
	 				containEventThumbnail.find('.event-thumbnail')[0].remove();
				}
			}
		}
	}
	
	btnEventPre.click(function(e) {
		if (!$(this).hasClass('disabled')) {
			currentPage = currentPage - 1;
			showEvent();
		}
	});
	
	btnEventNext.click(function(e) {
		if (!$(this).hasClass('disabled')) {
			currentPage = currentPage + 1;
			showEvent();
		}
	});
	
	var searchNameEvent = function(nameEvent) {
		var result = [];
		if (nameEvent !== '') {
			var length = allEvent.length;
			for (var index = 0; index < length; index++) {
				var event = allEvent[index];
				if (convertVietnamese(event.name).indexOf(convertVietnamese(nameEvent)) > -1) {
					result.push(event);
				}
				if (result.length === 10) {
					break;
				}
			}
		}
		return result;
	}
	
	var itemSearch;
	itemSearch = itemSearch || (function() {
		var itemSearchHtml="";
		itemSearchHtml += "<li>";
		itemSearchHtml += "	<a href=\"\">";
		itemSearchHtml += "		<label><\/label><br>";
		itemSearchHtml += "		<span class=\"organization\"><\/span><br>";
		itemSearchHtml += "		<span class=\"place-and-time\"><\/span>";
		itemSearchHtml += "	<\/a>";
		itemSearchHtml += "	<hr class=\"search-divider\">";
		itemSearchHtml += "<\/li>";

		return {
			createItemSearch: function(event) {
				var itemSearchLi = $(itemSearchHtml);
				var eventHref = itemSearchLi.find('a');
				var eventName = itemSearchLi.find('label');
				var eventOrganization = itemSearchLi.find('.organization');
				var eventPlaceAndTime = itemSearchLi.find('.place-and-time');
				var eventDate = new Date(event.startDate);
				var time = (eventDate.getHours() < 10 ? '0' : '') + eventDate.getHours() + ':' + (eventDate.getMinutes() < 10 ? '0' : '') + eventDate.getMinutes()
				
				eventHref.attr('href', '/ticketevent-web/event/' + event.path);
				eventName.text(event.name);
				eventOrganization.text(event.organizeName);
				eventPlaceAndTime.text(time + ' ' + eventDate.toString());
				
				return itemSearchLi;
			}
		};
	})();
	
	var headerSearch = function() {
		ulShowSearch.remove('.not-found');
		ulShowSearch.css('display', 'block');
		var query = searchEvent.val();
		if (query !== '') {
			var jsonListEvent = searchNameEvent(query);
			if (jsonListEvent.length !== 0) {
				var index;
				for (index = 0; index < jsonListEvent.length; index++) {
		 			var event = jsonListEvent[index];
		 			var itemSearchLi = itemSearch.createItemSearch(event);
		 			if (ulShowSearch.find('li').length > index + 1) {
		 				ulShowSearch.find('li')[0].remove();
					}
		 			itemSearchLi.hide();
		 			ulShowSearch.append(itemSearchLi);
		 			itemSearchLi.fadeIn(500);
		 		}
				if (ulShowSearch.find('li').length > index) {
					for (var i = index; i < ulShowSearch.find('li').length; i++) {
						ulShowSearch.find('li')[0].remove();
					}
				}
			}else {
				while (ulShowSearch.find('li').length !== 0) {
					ulShowSearch.find('li')[0].remove();
				}
				ulShowSearch.append($('<li class=\"not-found\"><a><span>Không tìm thấy sự kiện phù hợp.<\/span><\/a><\/li>'));
			}
		}else {
			while (ulShowSearch.find('li').length !== 0) {
				ulShowSearch.find('li')[0].remove();
			}
			ulShowSearch.append($('<li class=\"not-found\"><a><span>Không tìm thấy sự kiện phù hợp.<\/span><\/a><\/li>'));
		}
	}
	searchEvent.keyup(function(e) {
		headerSearch();
	})
	.focusin(function(e) {
		headerSearch();
	})
	$('body').click(function(e) {
		if ($(e.target).closest(searchEvent).length === 0 && $(e.target).closest(ulShowSearch).length === 0) {
			ulShowSearch.css('display', 'none');
	    }
	});
});