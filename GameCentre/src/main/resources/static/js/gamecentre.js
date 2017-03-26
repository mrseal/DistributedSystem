$(document).ready(function() {
	$('#go').click(function(event) {
		event.preventDefault();

		$.ajax({
			type: "GET",
			url: "/calculate24",
			data: {
				a: $.trim($('#a').val()),
				b: $.trim($('#b').val()),
				c: $.trim($('#c').val()),
				d: $.trim($('#d').val())
			},
			success: function(data, xhr) {
				$('#result').removeClass('alert-danger');
				$('#result').addClass('alert-info');
				$('#result').html(data.replace(/\n/g, "<br />"));
			},
			error: function (e, xhr) {
				$('#result').removeClass('alert-info');
				$('#result').addClass('alert-danger');
				$('#result').html("ERROR [" + e.status + "]: Calculate24 server response not received.");
				console.log(e);
			}
		})
	});
	
	$('#calc24 .form-control-single').click(function(event) {
		$('#result').removeClass('alert-danger');
		$('#result').addClass('alert-info');
		$('#result').html('');
	});
});
