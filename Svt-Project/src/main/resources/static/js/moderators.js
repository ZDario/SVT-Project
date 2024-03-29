function submitModerator(){
	
    var error = "";
    var userNameInput = "";
    var passwordInput = "";
    var emailInput = "";
    var avatarInput = "";
	var communityInput = "";
    
    userNameInput = $("#userNameModerator").val();
    passwordInput = $("#passwordModerator").val();
    emailInput = $("#emailModerator").val();
    avatarInput = $("#avatarModerator").val();
	communityInput = $("#communityModerator").val();

    var userNameError;
    var passwordError;
    var emailError;
    var avatarError;
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
    if(communityInput === ""){
    	communityError = true;
        error += "\nEnter community!";
    }

    if(userNameError || passwordError || emailError || avatarError || communityError){
        alert(error);
    }
    else{
        var formData = {
            "userNameModerator" : userNameInput,
            "passwordModerator" : passwordInput,
            "emailModerator" : emailInput,
            "avatarModerator" : avatarInput,
			"idCommunity" : communityInput
        }

        $.ajax({
            url : "http://localhost:8080/api/moderator",
            type : "POST",
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(formData),
            success: function(){
                alert('Moderator is succesfulli added!');
				window.location.href = "index.html";
            },
            error : function(e){
                alert('There was an error!');
                console.log("ERROR: ", e);
            }
        });
    }

}