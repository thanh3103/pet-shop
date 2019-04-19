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

function sendGetRequest(url, callback) {
	sendRequest(url, "", 'GET', callback);
};

function sendPostRequest(url, data, callback) {
	sendRequest(url, data, 'POST', callback);
};

function sendPutRequest(url, data, callback) {
	sendRequest(url, data, 'PUT', callback);
};

function sendDeleteRequest(url, callback) {
	sendRequest(url, "", 'DELETE', callback);
};

function addStudent() {
	location.href='addStudent';
}

function getStudent(id, mode) {
	location.href='getStudent?id=' + id + "&mode=" + mode;
};

function deleteStudent(id) {
	var r = confirm("Do you want to delete this student?");
	if (r == true) {
		sendDeleteRequest('./' + id, null);
		location.href='./';
	}	
};
