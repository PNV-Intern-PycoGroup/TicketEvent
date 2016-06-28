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
