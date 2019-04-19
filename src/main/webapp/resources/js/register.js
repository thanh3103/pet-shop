function validateEmail() {

	var data = {
		email : $('#email').val(),
	};

	$.ajax({
		url : 'register',
		type : 'GET',
		data : data,
		contentType : 'application/json',
		success : function(result) {
			if (result == "This email already exists"
					|| result == "Invalid email"
					|| result == "Please input email")
				$('#emailValidate').html(result);
			else
				(result == "You can use this email" || result == "")
			$('#emailValidate').html(result);
		},
	});
};

function validateUser() {
	var data = {
		userName : $('#userName').val(),
	}
	$.ajax({
		url : 'register',
		type : 'GET',
		data : data,
		contentType : 'application/json',
		success : function(result) {
			if (result == "This username already exists"
					|| result == "Please input username")
				$('#userValidate').html(result);
			else
				(result == "You can use this username" || result == "")
			$('#userValidate').html(result);
		},
	});
}

function validateFirstName() {
	var data = {
		firstName : $('#firstName').val(),
	}
	$.ajax({
		url : 'register',
		type : 'GET',
		data : data,
		contentType : 'application/json',
		success : function(result) {
			if (result == "Please input first name")
				$('#firstNameValidate').html(result);
			else
				(result == "")
			$('#firstNameValidate').html(result);
		},
	});
}

function validateLastName() {
	var data = {
		lastName : $('#lastName').val(),
	}
	$.ajax({
		url : 'register',
		type : 'GET',
		data : data,
		contentType : 'application/json',
		success : function(result) {
			if (result == "Please input last name")
				$('#lastNameValidate').html(result);
			else
				(result == "")
			$('#lastNameValidate').html(result);
		},
	});
}

function validatePassWord() {
	var data = {
		passWord : $('#passWord').val(),
	}
	$.ajax({
		url : 'register',
		type : 'GET',
		data : data,
		contentType : 'application/json',
		success : function(result) {
			if (result == "Please input password")
				$('#passValidate').html(result);
			else
				(result == "")
			$('#passValidate').html(result);
		},
	});
}

function validateAge() {
	var data = {
		age : $('#age').val(),
	}
	$.ajax({
		url : 'register',
		type : 'GET',
		data : data,
		contentType : 'application/json',
		success : function(result) {
			if (result == "Please input age between 6 and 100"
					|| result == "Please input age" || result == "Invalid age")
				$('#ageValidate').html(result);
			else
				(result == "")
			$('#ageValidate').html(result);
		},
	});
}

function validatePhoneNo() {
	var data = {
		phoneNo : $('#phoneNo').val(),
	}
	$.ajax({
		url : 'register',
		type : 'GET',
		data : data,
		contentType : 'application/json',
		success : function(result) {
			if (result == "Wrong phone number"
					|| result == "Please input phone number"
					|| result == "Invalid phone number")
				$('#phoneNoValidate').html(result);
			else
				(result == "")
			$('#phoneNoValidate').html(result);
		},
	});
}

function sendRequest(url, data, method, callback) {
	$.ajax({
		url : url,
		type : method,
		data : data,
		contentType : 'application/json',
		success : callback,
		error : function(request, msg, error) {
			// handle failure
		}
	});
};