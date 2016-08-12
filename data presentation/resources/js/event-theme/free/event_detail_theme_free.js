$(function() {
	var token = $("meta[name='_csrf']").attr("content");
	var header = $("meta[name='_csrf_header']").attr("content");
	$(document).ajaxSend(function(e, xhr, options) {
		xhr.setRequestHeader(header, token);
	});

	$('.btn-buy-ticket').click(function(e) {
		window.location.replace('/ticketevent-web/buy-ticket/' + $('#event-id').val());
	});
	
	$('.render-content').html($('#content-free').val());
	
	// map
	function convertVietnamese(str) {  
		str= str.toLowerCase();  
		str= str.replace(/à|á|ạ|ả|ã|â|ầ|ấ|ậ|ẩ|ẫ|ă|ằ|ắ|ặ|ẳ|ẵ/g,"a");  
		str= str.replace(/è|é|ẹ|ẻ|ẽ|ê|ề|ế|ệ|ể|ễ/g,"e");  
		str= str.replace(/ì|í|ị|ỉ|ĩ/g,"i");  
		str= str.replace(/ò|ó|ọ|ỏ|õ|ô|ồ|ố|ộ|ổ|ỗ|ơ|ờ|ớ|ợ|ở|ỡ/g,"o");  
		str= str.replace(/ù|ú|ụ|ủ|ũ|ư|ừ|ứ|ự|ử|ữ/g,"u");  
		str= str.replace(/ỳ|ý|ỵ|ỷ|ỹ/g,"y");  
		str= str.replace(/đ/g,"d");  
		return str;  
	}
	var geocoder = new google.maps.Geocoder();
	var place = $('#map-place').val();
	
	function init_map(mapAddress){
		geocoder.geocode( { 'address': convertVietnamese(mapAddress + ', Viet Nam')}, function(results, status) {
			if (status == google.maps.GeocoderStatus.OK) {
			    var latitude = results[0].geometry.location.lat();
			    var longitude = results[0].geometry.location.lng();

			    var myOptions = {
						zoom: 16,
						center: new google.maps.LatLng(latitude, longitude),
						mapTypeId: google.maps.MapTypeId.ROADMAP
					};
					map = new google.maps.Map(
						document.getElementById('gmap_canvas'),
						myOptions
					);
					marker = new google.maps.Marker({
						map: map,
						position: new google.maps.LatLng(latitude, longitude)
					});
					infowindow = new google.maps.InfoWindow({
						content: '<strong>Địa điểm</strong><br>' + mapAddress + '<br>'
					});
					google.maps.event.addListener(marker, 'click', function(){
					infowindow.open(map,marker);
				});
				infowindow.open(map,marker);
		    }else {
		    	console.log('error place');
		    }
		});
	};
	google.maps.event.addDomListener(window, 'load', init_map(place));
});