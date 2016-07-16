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

//	$(".table-hover tr").not(':first').tooltip(
//			  function () {
//				  var tar_id = $(this).attr("id");
//				  var image = $('#'+tar_id+' #avatar')[0].src;
//				  //$('.table-hover #'+tar_id).tooltip({ content: '<img src="'+image+'" />' });
//				  $(this).tooltip({
//					    items: "tr",
//					    content: "My content :)"
//					});
//				  alert(image);
//			  }, 
//			  function () {
//				  
//			  });
$(document).ready(function () {
	var windowlink = window.location.href;
	var dk = windowlink.lastIndexOf('=');
	var num = windowlink.substring(dk + 1, windowlink.length);
	if(num == 1 || num == 2){
	if(num == $('#sel1').val()){
		$('#sel1').val(2);
	}else {
		$('#sel1').val(1);
	}}else{
		$('#sel1').val(2);
	}
	$('#sel1').change(function () {
	    var str = $( this ).val();
	    window.location.href="user-management?page=1&type="+str;
	});
});

