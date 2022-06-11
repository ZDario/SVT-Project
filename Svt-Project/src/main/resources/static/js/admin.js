function ShowProfileAdmin(){ 

    var tableAdmin = $("#tableAdmin");
    var tbodyAdmin = $("#tbodyAdmin");

    function showAdminProfile(){
        $.ajax({

            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/admin",
            success : function(result){
                tableAdmin.show();
                tbodyAdmin.empty();
                for(user in result){
                    tbodyAdmin.append(
                    '<tr>'
                			
                        +'<td align="center">'+result[user].idAdmin+'</td>'
                        +'<td align="center">'+result[user].userNameAdmin+'</td>'
                        +'<td class="hidetext" align="center">'+result[user].passwordAdmin+'</a>'+'</td>'
                        +'<td align="center">'+result[user].emailAdmin+'</td>'
                        +'<td align="center">'+result[user].avatarAdmin+'</td>'
						+'<td align="center">'+result[user].registrationDateAdmin+'</td>'
						+'<td align="center">'+result[user].userType+'</td>'
                        +'<td>'
							+'<button type="submit" class="btn btn-warning" style="margin-right: 5%;" onclick="changePassword('+result[user].idAdmin+')">CHANGE PASSWORD</button>'
                        +'</td>'
                    +'</tr>'
                    
                    )};
                    
            },
            error :function(e){
                alert('There was a mistake!');
            }


        });
    }
    showAdminProfile();

}

function changePassword(id){
	$('#passwordChange').show();
	$("#adminButtons").hide();
	$("#tableAdmin").hide();
	
	    function editPassword(){
        $.ajax({
            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/admin/" + id,

            success: function(result){
            	
                var idUser = $("#idUser");
                var userName = $("#userName");
                var password = $("#password");
                var email = $("#email");
				var avatar = $("#avatar");
				var registrationDate = $("#registrationDate");
				var userType = $("#userType");

                idUser.val(result.idAdmin);
                userName.val(result.userNameAdmin);
                password.val(result.passwordAdmin);
                email.val(result.emailAdmin);
				avatar.val(result.avatarAdmin)
                registrationDate.val(result.registrationDateAdmin);
                userType.val(result.userType);

            },
            error : function(e){
                alert('There was a mistake!')
                console.log("ERROR: ", e);
            }
        });
    }
    editPassword();
}

function submitUpdatePassword(){

    var id = $("#idUser").val();
    var userName = $("#userName").val();
    var password = $("#password").val();
    var email = $("#email").val();
	var avatar = $("#avatar").val();
	var registrationDate = $("#registrationDate").val();
	var userType = $("#userType").val();

    var formData = {
            "userNameAdmin" : userName,
            "passwordAdmin" : password,
            "emailAdmin" : email,
            "avatarAdmin" : avatar,
			"registrationDateAdmin" : registrationDate,
			"userType" : userType
    }

    $.ajax({

        url: "http://localhost:8080/api/admin/" + id,
        type: "PUT",
        contentType: 'application/json; charset=utf-8',
        data : JSON.stringify(formData),
        success: function(result){
            alert('Password is succesfully changed!');
			showFormProfile();
            ShowProfileAdmin();
        },
        error : function(e){
            alert('There was an error!')
            console.log("ERROR: ", e);
        }
    });

}



//GO BACK TO START ADMIN BUTTONS
function goBackToStartAdmin(){
	$('#tableCommunity').hide();
	$('#tableCommunityRedditor').hide();
	$('#tablePost').hide();
	$('#tableAdmin').hide();
	$('#tableComment').hide();
	$('#buttons').show();
	$('#passwordChange').hide();
}
//GO BACK TO START REDDITOR BUTTONS
function goBackToStartRedditor(){
	$('#tableCommunityRedditor').hide();
	$('#tablePost').show();
	$('#buttons').show();
}

function showFormProfile(){
	$("#buttons").hide();
	$("#tableAdmin").show();
	$("#passwordChange").hide();
}