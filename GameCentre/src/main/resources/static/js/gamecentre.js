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
			url : calculate24,
			success: function(data, xhr) {
				$('#resultPanel').removeClass('alert-danger');
				$('#resultPanel').addClass('alert-info');
				$('#result').text(data);
			},    
			error: function (e, xhr) {
				$('#resultPanel').removeClass('alert-info');
				$('#resultPanel').addClass('alert-danger');
				$('#result').text("ERROR : Calculate24 server response not received.");
				console.log(e);
			}
		})
	});
	
	$('#calc24 .form-control-single').click(function(event) {
		$('#resultPanel').removeClass('alert-danger');
		$('#resultPanel').addClass('alert-info');
		$('#result').text('');
	});
});
