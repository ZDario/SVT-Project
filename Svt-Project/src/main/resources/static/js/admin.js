function logout(){
	window.location.href = "/";
}

//FORM LIST POST
function showFormPosts(){
	$("#adminButtons").hide();
	$("#tablePost").show();
	$("#addPost").hide();
}//ADD POST FORM
function showFormAddPost(){
	$("#adminButtons").hide();
	$("#tablePost").hide();
	$("#addPost").show();
}

//FROM LIST COMMUNITY
function showFormCommunities(){
	$("#adminButtons").hide();
	$("#tableCommunity").show();
	$("#addCommunity").hide();
}//ADD COMMUNITY FORM
function showFormAddCommunity(){
	$("#adminButtons").hide();
	$("#tableCommunity").hide();
	$("#addCommunity").show();
}


//GO BACK TO START ADMIN BUTTONS
function goBackToStartAdmin(){
	$('#tableCommunity').hide();
	$('#tablePost').hide();
	$('#adminButtons').show();
}
//GO BACK TO TABLE POST
function goBackFromAddingUpdatePost(){
	$('#tablePost').show();
	$('#addPost').hide();
}
//GO BACK TO TABLE COMMUNITY
function goBackFromAddingUpdateCommunity(){
	$('#tableCommunity').show();
	$('#addCommunity').hide();
}