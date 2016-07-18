var count = 0;
$(document).ready(function() {
	$('#delete').hide(); // ẩn button khi load lên
	$('#selectAll').click(function() {
		if ($(this).is(":checked")) {
			count = $('.table tr').length - 1;
			$('.selectID').prop("checked", true);
			$('#delete').show('slow');
		} else {
			$('.selectID').prop("checked", false);
			$('#delete').hide();
			count = 0;
		}
	});

	$('.selectID').click(function() {
		$('#selectAll').prop("checked", false);
	});

	$('.selectID').click(function() {
		if ($(this).is(':checked')) {
			count++;
			$('#delete').show('slow');
		}
		if ($(this).is(':checked') === false) {
			count--;
			if (count === 0) {
				$('#delete').hide();
			}
		}
	});
});


$(document).ready(function(){
	$('.activeToggle').each(function () {
		if( $(this).attr('name') == 1){
			$(this).prop("checked", true);
		}else{
			$(this).prop("checked", false);
		}
	})
	
	
	
	var type = 0;
	$('.activeToggle').click(function () {
		var tar_id = $(this).attr("id");
		if($(this).is(":checked")){
			type = 1;
			$.ajax({
	            contentType : 'application/json',
	            type: "GET",
	            url: '/ticketevent-web/setAccountActive/' + tar_id+'/'+type,
	            dataType : 'text',
	            async: true,
	            
	            success:  function() {
	            	window.location.replace('');
				},
	            error: function (callback) {
	            	console.log(callback);
	            }
	        });
		}else{
			type = 0;
			$.ajax({
	            contentType : 'application/json',
	            type: "GET",
	            url: '/ticketevent-web/setAccountActive/' + tar_id+'/'+type,
	            dataType : 'text',
	            async: true,
	            
	            success:  function() {
	            	window.location.replace('');
				},
	            error: function (callback) {
	            	console.log(callback);
	            }
	        });
		}
	})
})


//Set Image Avatar for Admin Page
$(document).ready(function () {
	var abc = $('.user-image')[0].src;
	$('.userAvatar').attr('src', abc);
});


$(document).ready(function () {
	var windowlink = window.location.href;
	var dk = windowlink.lastIndexOf('=');
	var firstPage = $('#firstPage').attr('href');
	var prevPage = $('#prevPage').attr('href');
	var nextPage = $('#nextPage').attr('href');
	var lastPage = $('#lastPage').attr('href');
	var curentPage = $('#curentPage a').attr('href');
	var curentPage2 = $('#curentPage a').attr('href');
	
	var num = windowlink.substring(dk + 1, windowlink.length);
	if(num == 1 || num == 2){
	if(num == $('#sel1').val()){
		$('#sel1').val(2);
		$('#firstPage').attr('href',firstPage+2);
		$('#prevPage').attr('href', prevPage+2);
		$('#nextPage').attr('href', nextPage+2);
		$('#lastPage').attr('href', lastPage+2);
		
		$('.page-link').mouseenter(function(){
			curentPage = $(this).attr('href');
			curentHoverpage = curentPage+2;
			$(this).attr('href',curentHoverpage);
			
		});
		$('.page-link').mouseleave(function(){
			$(this).attr('href',curentPage);
		});
		
		$('#curentPage a').hover(function () {
			$(this).attr('href', curentPage2+'&type=2')
		});
	}else {
		$('#sel1').val(1);
		$('#firstPage').attr('href',firstPage+1);
		$('#prevPage').attr('href', prevPage+1);
		$('#nextPage').attr('href', nextPage+1);
		$('#lastPage').attr('href', lastPage+1);
		$('.page-link').mouseenter(function(){
			curentPage = $(this).attr('href');
			curentHoverpage = curentPage+1;
			$(this).attr('href',curentHoverpage);
			
		});
		$('.page-link').mouseleave(function(){
			$(this).attr('href',curentPage);
		});
		
		$('#curentPage a').hover(function () {
			$(this).attr('href', curentPage2+'&type=1')
		});
	}}else{
		$('#sel1').val(2);
	}
	$('#sel1').change(function () {
	    var str = $( this ).val();
	    window.location.href="user-management?page=1&type="+str;
	});
});
