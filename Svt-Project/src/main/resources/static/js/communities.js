function ShowAllCommunities(){ 

    var tableCommunity = $("#tableCommunity");
    var tbodyCommunity = $("#tbodyCommunity");

    function showCommunities(){
        $.ajax({

            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/community",
            success : function(result){
                tableCommunity.show();
                tbodyCommunity.empty();
                for(community in result){
                    tbodyCommunity.append(
                    '<tr>'
                			
                        +'<td align="center">'+result[community].idCommunity+'</td>'
                        +'<td align="center">'+result[community].name+'</td>'
                        +'<td align="center">'+result[community].description+'</a>'+'</td>'
                        +'<td align="center">'+result[community].creationDate+'</td>'
                        +'<td align="center">'+result[community].rules+'</td>'
						+'<td align="center">'+result[community].isSuspended+'</td>'
						+'<td align="center">'+result[community].suspendedReason+'</td>'
                        +'<td>'
							+'<button type="submit" class="btn btn-warning" style="margin-right: 5%;" onclick="editCommunity('+result[community].idCommunity+')">UPDATE</button>'
	                        +'<button type="submit" class="btn btn-danger" onclick="deleteCommunity('+result[community].idCommunity+')">DELETE</button>'
                        +'</td>'
                    +'</tr>'
                    
                    )};
                    
            },
            error :function(e){
                alert('There was a mistake!');
            }


        });
    }
    showCommunities();

}

function ShowAllCommunitiesForRedditor(){ 

    var tableCommunity = $("#tableCommunityRedditor");
    var tbodyCommunity = $("#tbodyCommunityRedditor");

    function showCommunities(){
        $.ajax({

            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/community",
            success : function(result){
                tableCommunity.show();
                tbodyCommunity.empty();
                for(community in result){
                    tbodyCommunity.append(
                    '<tr>'
                			
                        +'<td align="center">'+result[community].idCommunity+'</td>'
                        +'<td align="center">'+result[community].name+'</td>'
                        +'<td align="center">'+result[community].description+'</a>'+'</td>'
                        +'<td align="center">'+result[community].creationDate+'</td>'
                        +'<td align="center">'+result[community].rules+'</td>'
						+'<td align="center">'+result[community].isSuspended+'</td>'
						+'<td align="center">'+result[community].suspendedReason+'</td>'
                        +'<td>'
							+'<button type="submit" class="btn btn-primary" style="margin-right: 5%;" onclick="showAllPostsFromCommunity('+result[community].idCommunity+')">POSTS</button>'
                        +'</td>'
                    +'</tr>'
                    
                    )};
                    
            },
            error :function(e){
                alert('There was a mistake!');
            }


        });
    }
    showCommunities();

}



function showAllPostsFromCommunity(id){

    var tablePostsFromCommunityRedditor = $("#tablePostsFromCommunityRedditor");
    var tbodyPostsFromCommunityRedditor = $("#tbodyPostsFromCommunityRedditor");

    function showAllPostsFromCommunityRedditor(){
	$('#tableCommunityRedditor').hide();
	$('#tablePostsFromCommunityRedditor').show();
	
        $.ajax({

            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/community/" + id + "/posts",
            success : function(result){
            	tablePostsFromCommunityRedditor.show();
            	tbodyPostsFromCommunityRedditor.empty();
                for(post in result){
                	tbodyPostsFromCommunityRedditor.append(
                    '<tr>'
                        +'<td align="center">'+result[post].title+'</td>'
                        +'<td align="center">'+result[post].text+'</a>'+'</td>'
                        +'<td align="center">'+result[post].creationDate+'</td>'
                        +'<td align="center">'+result[post].imagePath+'</td>'
						+'<td align="center">'+result[post].idCommunity+'</td>'
						+'<td align="center">'+result[post].idUser+'</td>'
                    +'</tr>'
                  
                    )};
                    
            },
            error :function(e){
                alert('There was some mistake!');
            }

        });
    }
    showAllPostsFromCommunityRedditor();
    
}






function submitCommunity(){
	
	$('#editCommunity').hide();
	$('#btnAddCommunity').show();

    var error = "";
    var nameInput = "";
    var descriptionInput = "";
    var rulesInput = "";

    nameInput = $("#nameCommunity").val();
    descriptionInput = $("#descriptionCommunity").val();
    rulesInput = $("#rulesCommunity").val();


    var nameInputError;
    var descriptionInputError;
	var rulesInputError;
    
    if(nameInput === ""){
    	nameInputError = true;
        error += "\nEnter name!";
    }
    if(descriptionInput === ""){
    	descriptionInputError = true;
        error += "\nEnter description!";
    }
    if(rulesInput === ""){
    	rulesInputError = true;
        error += "\nEnter rules!";
    }


    if(nameInputError || descriptionInputError || rulesInputError){
        alert(error);
    }
    else{
        var formData = {
            "name" : nameInput,
            "description" : descriptionInput,
            "rules" : rulesInput,
        }

        $.ajax({
            url : "http://localhost:8080/api/community",
            type : "POST",
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(formData),
            success: function(){
                alert('Community is succesfully added!');
                goBackFromAddingUpdateCommunity();
            	ShowAllCommunities();
				ShowAllCommunitiesForRedditor();
            },
            error : function(e){
                alert('There was some mistake!');
                console.log("ERROR: ", e);
            }
        });
    }

}

function editCommunity(id){

	$('#tableCommunity').hide();
	$('#addCommunity').show();
	$('#editCommunity').show();
	$('#btnAddCommunity').hide();
	$('#nameCommunity').hide();
	$('#nameCommunityLabel').hide();
	
    function showCommunities(){
        $.ajax({
            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/community/" + id,

            success: function(result){

                var idCommunity = $("#idCommunity");
                var description = $("#descriptionCommunity");
				var rules = $("#rulesCommunity");

                idCommunity.val(result.idCommunity);
                description.val(result.description);
                rules.val(result.rules);

            },
            error : function(e){
                alert('There was a mistake!')
                console.log("ERROR: ", e);
            }
        });
    }
    showCommunities();
}

function submitUpdateCommunity(){

    var id = $("#idCommunity").val();
    var description = $("#descriptionCommunity").val();
	var rules = $("#rulesCommunity").val();

    var formData = {
            "description" : description,
            "rules" : rules,
    }

    $.ajax({

        url: "http://localhost:8080/api/community/" + id,
        type: "PUT",
        contentType: 'application/json; charset=utf-8',
        data : JSON.stringify(formData),
        success: function(result){
            alert('Community is succesfully changed!');
			goBackFromAddingUpdateCommunity();
            ShowAllCommunities();
        },
        error : function(e){
            alert('There was an error!')
            console.log("ERROR: ", e);
        }
    });

}

function deleteCommunity(id){ 
    $.ajax({
        url:'http://localhost:8080/api/community/' + id,
        type: 'DELETE',
        contentType: 'application/json; charset=utf-8',
        success: function(result){
            alert("Community is deleted!");
            ShowAllCommunities();
        },
        error : function(e){
            alert('There was an error!')
            console.log("ERROR: ", e);
        }
    });
}

//GO BACK TO TABLE COMMUNITY FROM ADD/UPDATE COMMUNITY - ADMIN
function goBackFromAddingUpdateCommunity(){
	$('#tableCommunity').show();
	$('#tableCommunityRedditor').show();
	$('#addCommunity').hide();
}//GO BACK TO TABLE COMMUNITY FROM POSTS TABLE - REDDITOR
function goBackToCommunitiesListRedditor(){
	$('#tablePostsFromCommunityRedditor').hide();
	$('#tableCommunityRedditor').show();
}

//FORM LIST COMMUNITY Redditor
function showFormCommunitiesRedditor(){
	$("#buttons").hide();
	$("#tableCommunityRedditor").show();
	$("#addCommunity").hide();
	$('#tablePost').hide();
}//FORM LIST COMMUNITY Admin
function showFormCommunities(){
	$("#buttons").hide();
	$("#tableCommunity").show();
	$("#addCommunity").hide();
}

//ADD COMMUNITY FORM
function showFormAddCommunity(){
	$("#buttons").hide();
	$("#tableCommunity").hide();
	$("#addCommunity").show();
	$('#tableCommunityRedditor').hide();
}