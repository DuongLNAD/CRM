
console.log("Start Add user");


const APP = {

	EmailArray: [],


	getAllEmail: function() {
		const _this = this;
		$.ajax({
			method: "GET",
			url: "http://localhost:8082/CRM_02/api/user",
		})
			.done(function(data) {
				data.data.forEach(item => {

					_this.EmailArray.push(item.email);
				})
			});
		return this.EmailArray;
	},

	callPostAddUser: function() {
		let fullname = $("input[name=fullname]").val();
		let email = $("input[name=email]").val();
		let password = $("input[name=password]").val();
		let phone = $("input[name=phone]").val();
		let role = $('[name=role]').find(":selected").val();
		if(fullname == "" || email == "" || password == "" || phone =="" )	{
			alert("Khong duoc de trong " );
			return false;
		}
	
		$.ajax({
			method: "POST",
			url: "http://localhost:8082/CRM_02/api/user/add",
			data: {
				fullname: fullname,
				email: email,
				password: password,
				phone: phone,
				role: role
			}
		})
			.done(function(data) {
				APP.EmailArray.push(email);
				console.log(data)
				$("input").val("");
				$('select option[value="1"]').attr("selected", true);
				return true;
				
			});

	},

	addUser: function(emailArray) {
		let emailAdd = $("input[name=email").val();


		let isChecked = this.EmailArray.every(item => item != emailAdd)

		return isChecked;
	},

	handleAdd_User: function() {
		let check = APP.addUser(APP.EmailArray);
		console.log(check, "check in handleAdd");

		if (check) {
			APP.callPostAddUser();
			
		} else {
			alert("Email da ton tai trong he thong")
		}

		// Call API GET ALl email có sẵn trong DB ; 
		// Check xem email nhập vào có trùng email có sẵn không? 
		// Xài hàm filter trong JS 

		// Nếu trùng: báo lỗi
		// Nếu k trùng --> Chạy đoạn code ajax post thêm user : 
	},

	start: function() {
		this.getAllEmail();
		$(".add-user").on("click", APP.handleAdd_User);
	}
}

APP.start();

