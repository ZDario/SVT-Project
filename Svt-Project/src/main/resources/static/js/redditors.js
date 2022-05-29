function submitRedditor(){
	
    var error = "";
    var userNameInput = "";
    var passwordInput = "";
    var emailInput = "";
    var avatarInput = "";
    
    userNameInput = $("#userNameRedditor").val();
    passwordInput = $("#passwordRedditor").val();
    emailInput = $("#emailRedditor").val();
    avatarInput = $("#avatarRedditor").val();

    var userNameError;
    var passwordError;
    var emailError;
    var avatarError;
    
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

    if(userNameError || passwordError || emailError || avatarError){
        alert(error);
    }
    else{
        var formData = {
            "userNameRedditor" : userNameInput,
            "passwordRedditor" : passwordInput,
            "emailRedditor" : emailInput,
            "avatarRedditor" : avatarInput,
        }

        $.ajax({
            url : "http://localhost:8080/api/redditor",
            type : "POST",
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(formData),
            success: function(){
                alert('Redditor is succesfulli added!');
				window.location.href = "index.html";
            },
            error : function(e){
                alert('There was some mistake!');
                console.log("ERROR: ", e);
            }
        });
    }

}