function ShowAllPosts(){ 

    var tablePost = $("#tablePost");
    var tbodyPost = $("#tbodyPost");

    function showPosts(){
        $.ajax({

            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/post",
            success : function(result){
                tablePost.show();
                tbodyPost.empty();
                for(post in result){
                    tbodyPost.append(
                    '<tr>'
                			
                        +'<td align="center">'+result[post].idPost+'</td>'
                        +'<td align="center">'+result[post].title+'</td>'
                        +'<td align="center">'+result[post].text+'</a>'+'</td>'
                        +'<td align="center">'+result[post].creationDate+'</td>'
                        +'<td align="center">'+result[post].imagePath+'</td>'
						+'<td align="center">'+result[post].name+'</td>'
						+'<td align="center">'+result[post].userName+'</td>'
                        +'<td>'
							+'<button type="submit" class="btn btn-warning" style="margin-right: 5%;" onclick="editPost('+result[post].idPost+')">UPDATE</button>'
	                        +'<button type="submit" class="btn btn-danger" onclick="deletePost('+result[post].idPost+')">DELETE</button>'
                        +'</td>'
                    +'</tr>'
                    
                    )};
                    
            },
            error :function(e){
                alert('There was a mistake!');
            }


        });
    }
    showPosts();

}

function ShowAllPostsHomePage(){ 

    var tablePost = $("#tablePost");
    var tbodyPost = $("#tbodyPost");

    function showPosts(){
        $.ajax({

            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/post",
            success : function(result){
                tablePost.show();
                tbodyPost.empty();
                for(post in result){
                    tbodyPost.append(
                    '<tr>'
                        +'<td align="center">'+result[post].title+'</td>'
                        +'<td align="center">'+result[post].text+'</a>'+'</td>'
                        +'<td align="center">'+result[post].creationDate+'</td>'
                        +'<td align="center">'+result[post].imagePath+'</td>'
						+'<td align="center">'+result[post].name+'</td>'
						+'<td align="center">'+result[post].userName+'</td>'
                    +'</tr>'
                    
                    )};
                    
            },
            error :function(e){
                alert('There was a mistake!');
            }


        });
    }
    showPosts();
}

function submitPost(){
	
	$('#editPost').hide();
	$('#btnAddPost').show();

    var error = "";
    var titleInput = "";
    var textInput = "";
    var imagePathInput = "";
	var communityInput = "";
	var userInput = "";

    titleInput = $("#title").val();
    textInput = $("#text").val();
    imagePathInput = $("#imagePath").val();
    communityInput = $("#community").val();
    userInput = $("#user").val();


    var titleError;
    var textError;
	var imagePathError;
	var communityError;
	var userError;
    
    if(titleInput === ""){
    	titleError = true;
        error += "\nEnter title!";
    }
    if(textInput === ""){
    	textError = true;
        error += "\nEnter text!";
    }
    if(imagePathInput === ""){
    	imagePathError = true;
        error += "\nEnter image path!";
    }
    if(communityInput === ""){
    	communityError = true;
        error += "\nEnter community!";
    }
    if(userInput === ""){
    	userError = true;
        error += "\nEnter user!";
    }

    if(titleError || textError || imagePathError || communityError || userError){
        alert(error);
    }
    else{
        var formData = {
            "title" : titleInput,
            "text" : textInput,
            "imagePath" : imagePathInput,
			"idCommunity" : communityInput,
			"idUser" : userInput
        }

        $.ajax({
            url : "http://localhost:8080/api/post",
            type : "POST",
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(formData),
            success: function(){
                alert('Post is succesfully added!');
				goBackFromAddingPost()
            },
            error : function(e){
                alert('There was some mistake!');
                console.log("ERROR: ", e);
            }
        });
    }

}

function editPost(id){

	$('#tablePost').hide();
	$('#addPost').show();
	$('#editPost').show();
	$('#btnAddPost').hide();
	
    function showPosts(){
        $.ajax({
            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/post/" + id,

            success: function(result){
            	
                var idPost = $("#idPost");
                var title = $("#title");
                var text = $("#text");
				var imagePath = $("#imagePath");
				var community = $("#community");
				var user = $("#user");

                idPost.val(result.idPost);
                title.val(result.title);
                text.val(result.text);
				imagePath.val(result.imagePath)
                community.val(result.idCommunity);
                user.val(result.idUser);

            },
            error : function(e){
                alert('There was a mistake!')
                console.log("ERROR: ", e);
            }
        });
    }
    showPosts();
}

function submitUpdatePost(){

    var id = $("#idPost").val();
    var title = $("#title").val();
    var text = $("#text").val();
	var imagePath = $("#imagePath").val();
	var community = $("#community").val();
	var user = $("#user").val();

    var formData = {
            "title" : title,
            "text" : text,
            "imagePath" : imagePath,
			"idCommunity" : community,
			"idUser" : user
    }

    $.ajax({

        url: "http://localhost:8080/api/post/" + id,
        type: "PUT",
        contentType: 'application/json; charset=utf-8',
        data : JSON.stringify(formData),
        success: function(result){
            alert('Post is succesfully changed!');
			showFormPosts();
            ShowAllPosts();
        },
        error : function(e){
            alert('There was an error!')
            console.log("ERROR: ", e);
        }
    });

}

function deletePost(id){ 
    $.ajax({
        url:'http://localhost:8080/api/post/' + id,
        type: 'DELETE',
        contentType: 'application/json; charset=utf-8',
        success: function(result){
            alert("Post is deleted!");
            ShowAllPosts();
        },
        error : function(e){
            alert('There was an error!')
            console.log("ERROR: ", e);
        }
    });
}



function goBackToStartPost(){
	$('#tablePost').hide();
	$('#ButtonShowPosts').show();
}


//GO BACK TO TABLE POST
function goBackFromAddingUpdatePost(){
	$('#tablePost').show();
	$('#addPost').hide();
}//GO BACK FROM ADDING POST TO POST LIST - REDDITOR
function goBackFromAddingPost(){
	$('#tablePostsFromCommunityRedditor').show();
	$('#addPost').hide();
}
//FORM LIST POST
function showFormPosts(){
	$("#buttons").hide();
	$("#tablePost").show();
	$("#addPost").hide();
	$('#addingPost').show();
}//ADD POST FORM
function showFormAddPost(){
	$("#buttons").hide();
	$("#tablePost").hide();
	$("#addPost").show();
	$('#tablePostsFromCommunityRedditor').hide();
	$('#tableCommentsFromPostsFromCommunityRedditor').hide();
	$('#addComment').hide();
}

function goBackFromAddingPostRedditor(){
	$("#addPost").hide();
	$('#tablePostsFromCommunityRedditor').show();
}