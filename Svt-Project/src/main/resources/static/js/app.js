function pokaziLogin(){
	$('#login').show();
	$('#btnRegistration').show();
	$('#btnLogin').hide();
}


function login(){
		
    var error = "";
    var userNameInput = "";
    var passwordInput = "";
    
    userNameInput = $("#inputUserName").val();
    passwordInput = $("#inputPassword").val();

    var userNameError = false;
    var passwordError = false;

    if(userNameInput === ""){
        userNameError = true;
        error += "\nYou need to enter userName!";
    }

    if(passwordInput === ""){
        passwordError = true;
        error += "\nYou need to enter password!";
    }

    if(userNameError || passwordError){
        alert(error);
    }
    else{
        var formData = {
                "userName" : userNameInput,
                "password" : passwordInput
        }

        $.ajax({
        	url: "http://localhost:8080/api/user/login",
            type: "POST",
            contentType: "application/json; charset=utf-8",  
            data : JSON.stringify(formData),
            success: function (response) {

            	if(response.isBanned === true){
            		alert("User is banned!");
            	}else if(response.userType === "REDDITOR"){
        			window.location.href = "redditor.html";
        		}else if(response.userType === "MODERATOR"){
        			window.location.href = "moderator.html";
        		    console.log("USER: " + response);
        		}else if(response.userType === "ADMIN"){
        			window.location.href = "admin.html";
        		}           	
        		              
            },
            error: function () {
                alert("You have entered wrong credentials!");
            }

        });
    }
}


//----------------- ZA REGISTRACIJU --------------------------------------------------------------

function showFormRedditor(){
	$("#addRedditor").show();
	$("#addModerator").hide();
	$("#registration").hide();
}

function showFormModerator(){
	$("#addRedditor").hide();	
	$("#addModerator").show();
	$("#registration").hide();
}

//------------------------------------------------------------------------------------------------
