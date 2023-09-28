/**
 * 
 */
const API = "http://localhost:8082/CRM_02/api/role-delete";
function handleDelete(id) {
	$.ajax({
		type: "POST",
		url: API,
		data: { id: id },
		success: function(data) {
			console.log(data)
		}
	});
}
function formUpdate(STT, name, desc) {
	let formUpdate = `
			<div class="formUpdate">
				
					<label>Role Name</label>
					<input name="name" value="${name}" />
				
				
				
					<label>Role Description</label>
					<input name="desc" value="${desc}" />
				
				<div>
					<button class="btn btn-info submitUpdate">Sửa</button>
					<button class="btn btn-danger cancelUpdate">Huỷ</button>
			</div>
				
       	`

	return formUpdate;
}

function handleUpdate(id) {
	$(".overlayy").addClass("show");
	let row = $(`#${id}`);

	let STT = row.find('td:eq(0)').text();
	let name = row.find('td:eq(1)').text();
	let desc = row.find('td:eq(2)').text();
	$(".overlayy").html(formUpdate(STT, name, desc))
	window.scrollTo({ top: 0, behavior: 'smooth' });
	new Promise(function(resolve, reject) {
		$(".submitUpdate").on("click", function() {
			resolve();
		}
		)
		$(".cancelUpdate").on("click", function() {
			reject()
		})

	})
		.then(function() {

			let newRoleName = $(".overlayy > .formUpdate > input[name='name']").val();
			let newRoleDesc = $(".overlayy > .formUpdate > input[name='desc']").val();
				console.log(newRoleName, newRoleDesc)
			$.ajax({
				type: 'POST',
				url: "http://localhost:8082/CRM_02/api/role-update",
				data: {id: id, name: newRoleName, desc: newRoleDesc }
			})
				.success(function(data) {
					console.log(data)
					 row.find('td:eq(1)').text(newRoleName);
					 desc = row.find('td:eq(2)').text(newRoleDesc);
					 $(".overlayy").removeClass("show");
				});
		})
		.catch(function() {
			 $(".overlayy").removeClass("show");
		})
}
















