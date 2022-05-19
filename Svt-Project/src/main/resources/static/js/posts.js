function ShowAllPosts(){ 

    var tablePost = $("#tablePost");
    var tbodyPost = $("#tbodyPost");

    function showPosts(){
    	$('#adding').show();
//   	$('#prijava').hide();
//    	$('#btnLogin').hide();
//		$('#DugmePrikazLogiina').hide();


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
						+'<td align="center">'+result[post].community+'</td>'
						+'<td align="center">'+result[post].user+'</td>'
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

function submitPost(){

    var error = "";
    var titleInput = "";
    var textInput = "";
    var creationDateInput = "";
    var imagePathInput = "";
	var communityInput = "";
	var userInput = "";

    titleInput = $("#title").val();
    textInput = $("#text").val();
    creationDateInput = $("#creationDate").val();
    imagePathInput = $("#imagePath").val();
    communityInput = $("#community").val();
    userInput = $("#user").val();


    var titleError;
    var textError;
    var creationDateError;
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
    if(creationDateInput === ""){
    	creationDateError = true;
        error += "\nEnter date!";
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

    if(titleError || textError || creationDateError || imagePathError || communityError || userError){
        alert(error);
    }
    else{
        var formData = {
            "title" : titleInput,
            "text" : textInput,
            "creationDate" : creationDateInput,
            "imagePath" : imagePathInput,
			"idCommunit" : communityInput,
			"idUser" : userInput
        }

        $.ajax({
            url : "http://localhost:8080/api/post",
            type : "POST",
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(formData),
            success: function(){
                alert('Post is succesfully added!');
                odrediPrikaz('allPosts');
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
                var creationDate = $("#creationDate");
				var imagePath = $("#imagePath");
				var community = $("#community");
				var user = $("#user");

                idPost.val(result.idPost);
                title.val(result.title);
                text.val(result.text);
                creationDate.val(result.creationDate);
				imagePath.val(resulrt.imagePath)
                community.val(result.community);
                user.val(result.user);

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
    var creationDate = $("#creationDate").val();
	var imagePath = $("#imagePath").val();
	var community = $("#cena").val();
	var user = $("#user").val();

    var formData = {
            "title" : title,
            "text" : text,
            "creationDate" : creationDate,
            "imagePath" : imagePath,
			"idCommunit" : community,
			"idUser" : user
    }

    $.ajax({

        url: "http://localhost:8080/api/post/" + id,
        type: "PUT",
        contentType: 'application/json; charset=utf-8',
        data : JSON.stringify(formData),
        success: function(result){
            alert('Post is succesfully changed!');
            odrediPrikaz('allPosts');
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
            odrediPrikaz('allPosts');
        },
        error : function(e){
            alert('There was an error!')
            console.log("ERROR: ", e);
        }
    });
}

function goBackToStartPost(){
	$('#tablePost').hide();
	$('#prijava').hide();
	$('#DugmePrikazLogiina').show();
	$('#ButtonShowPosts').show();
}

function goBackFromAddingUpdatePost(){
	$('#tablePost').show();
	$('#addPost').hide();
	$('#addingPost').show();
}