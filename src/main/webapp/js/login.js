
$(".login").on("click", function() {

	let email = $("input[name=email]").val();
	let password = $("input[name=password]").val();

	$.ajax({
		method: "POST",
		url: "http://localhost:8080/CRM_02/api/login",
		data: { email: email, password: password }
	})
		.done(function(data) {
			console.log(data)
			alert( data.data  ? " login thành công" : "login thất bại")
		//	window.location.href= "http://localhost:8080/CRM_02/index";
		});

})











