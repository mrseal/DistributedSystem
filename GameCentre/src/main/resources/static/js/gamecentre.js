$(document).ready(function() {
	$('#go').click(function(event) {
		event.preventDefault();
		var nums = [];
		nums[0] = $.trim($('#a').val());
		nums[1] = $.trim($('#b').val());
		nums[2] = $.trim($('#c').val());
		nums[3] = $.trim($('#d').val());
		var calculate24 = "http://localhost:8090/calculate24/" + nums.join('/');

		$.ajax({
			url : calculate24
		}).then(function(data) {
			$('#result').text(data);
		});
	});
	
	$('#calc24 .form-control-single').click(function(event) {
		$('#result').text('');
	});
});
