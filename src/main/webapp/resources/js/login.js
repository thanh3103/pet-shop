//function checkUserName() {
//
//	var data = {
//		userName : $('#userName').val(),
//		passWord : $('#passWord').val()
//	};
//	
//	$.ajax({
//		url : 'login',
//		type : 'GET',
//		data : data,
//		contentType : 'application/json',
//		success : function(result) {
////			alert("success");
//			$('#userValidate').html(result);
//		},
//		error : function(request, msg, error) {
////			alert("error");
//			$('#userValidate').html(result);
//		}
//	});
//};

function sendRequest(url, data, method, callback) {
	$.ajax({
		url : url,
		type : method,
		data : data,
		contentType : 'application/json',
		success : function(result) {
			callback(result);
		},
		error : function(request, msg, error) {
			// handle failure
		}
	});
};