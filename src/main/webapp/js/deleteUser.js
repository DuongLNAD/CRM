


$(document).ready(function() {
	console.log("Hello user");
	$(".deleteUser").on("click", handleDelete)

})


function handleDelete(id) {
		const _this = $(this);
		
		console.log(_this,"this is this after get     ");
		
		
		$.ajax({
			method: "GET",
			url: `http://localhost:8080/CRM_02/api/user/delete?id=${id}`,
		})
			.done(function(data) {
				if(data.data) {
					$(`#${id}`).closest("tr").remove();
					
				}
				console.log(data)
			});
}




