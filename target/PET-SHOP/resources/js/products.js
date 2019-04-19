$(document).ready(function(){
	var userEmail = $('#userEmail').val();
	$('#userEmail').keyup(function(){
		$.ajax({
			type: 'POST',
			url: '${pageContext.request.contextPath}/register/',
			success: function(result){
				$('#resultEmail').html(result);
			}
		});
	});
});

/*$(document).ready(function(){
	$("select").keyup(function(){
		$('#')
	});
});*/

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

function addProduct() {
	location.href='addProduct';
};

function getProduct(id, mode, name) {
	location.href='getProduct?id=' + id + "&mode=" + mode + "&name=" + name;
};

function deleteProduct(id) {
	var r = confirm("Do you want to delete this product?");
	if (r == true) {
		sendDeleteRequest('./' + id, null);
		location.href='./';
	}	
};

function addProductToCart(id){
	location.href='add?id=' + id;
};

function update(quantity, id){
	location.href='update?id=' + id + "&quantity=" + quantity;
};

//$(document).ready(function(){
//	$('#quantity_${cart.id}').keyup(function(){
//		location.href='update?id=' + id + "&quantity=" + quantity;
//	});
//});
