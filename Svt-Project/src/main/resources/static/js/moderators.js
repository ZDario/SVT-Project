function submitModerator(){
	
    var error = "";
    var userNameInput = "";
    var passwordInput = "";
    var emailInput = "";
    var avatarInput = "";
	var registrationDateInput = "";
	var communityInput = "";
    
    userNameInput = $("#userNameModerator").val();
    passwordInput = $("#passwordModerator").val();
    emailInput = $("#emailModerator").val();
    avatarInput = $("#avatarModerator").val();
	registrationDateInput = $("#registrationDateModerator").val();
	communityInput = $("#communityModerator").val();

    var userNameError;
    var passwordError;
    var emailError;
    var avatarError;
	var registrationDateError;
	var communityError;
    
    if(userNameInput === ""){
    	userNameError = true;
        error += "\nEnter username!";
    }
    if(passwordInput === ""){
    	passwordError = true;
        error += "\nEnter password!";
    }
    if(emailInput === ""){
    	emailError = true;
        error += "\nEnter email!";
    }
    if(avatarInput === ""){
    	avatarError = true;
        error += "\nEnter avatar!";
    }
    if(registrationDateInput === ""){
    	registrationDateError = true;
        error += "\nEnter registration date!";
    }
    if(communityInput === ""){
    	communityError = true;
        error += "\nEnter community!";
    }

    if(userNameError || passwordError || emailError || avatarError || registrationDateError || communityError){
        alert(error);
    }
    else{
        var formData = {
            "userNameModerator" : userNameInput,
            "passwordModerator" : passwordInput,
            "emailModerator" : emailInput,
            "avatarModerator" : avatarInput,
			"registrationDateModerator" : registrationDateInput,
			"communityModerator" : communityInput
        }

        $.ajax({
            url : "http://localhost:8080/api/moderator",
            type : "POST",
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(formData),
            success: function(){
                alert('Moderator is succesfulli added!');
            },
            error : function(e){
                alert('There was some mistake!');
                console.log("ERROR: ", e);
            }
        });
    }

}