function ShowAllComments(){
	
	var tableComment = $("#tableComment");
    var tbodyComment = $("#tbodyComment");

    function showAllCommentsAdmin(){
	
        $.ajax({

            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/comment",
            success : function(result){
            	tableComment.show();
            	tbodyComment.empty();
                for(comment in result){
                	tbodyComment.append(
                    '<tr>'
						+'<td align="center">'+result[comment].idComment+'</td>'
                        +'<td align="center">'+result[comment].text+'</td>'
                        +'<td align="center">'+result[comment].timeStamp+'</td>'
						+'<td align="center">'+result[comment].isDeleted+'</td>'
						+'<td align="center">'+result[comment].idPost+'</td>'
                        +'<td align="center">'+result[comment].idUser+'</td>'
                        +'<td>'
							+'<button type="submit" class="btn btn-warning" style="margin-right: 5%;" onclick="editComment('+result[comment].idComment+')">UPDATE</button>'
	                        +'<button type="submit" class="btn btn-danger" onclick="deleteComment('+result[comment].idComment+')">DELETE</button>'
                        +'</td>'
                    +'</tr>'
                  
                    )};
                    
            },
            error :function(e){
                alert('There was some mistake!');
            }

        });
    }
    showAllCommentsAdmin();
    
}


function submitComment(){
	$('#btnAddComment').show();

    var error = "";
    var textInput = "";
	var postInput = "";
	var userInput = "";

    textInput = $("#textComment").val();
	postInput = $("#idPostComment").val();
	userInput = $("#idUserComment").val();
    var textError;
    

    if(textInput === ""){
    	textError = true;
        error += "\nEnter text!";
    }

    if(textError){
        alert(error);
    }
    else{
        var formData = {
            "text" : textInput,
			"idPost" : postInput,
			"idUser" : userInput
        }

        $.ajax({
            url : "http://localhost:8080/api/comment",
            type : "POST",
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(formData),
            success: function(){
                alert('Comment is succesfully added!');
				goBackFromAddingCommentRedditor();
				goBackFromAddingCommentAdmin();
            },
            error : function(e){
                alert('There was some mistake!');
                console.log("ERROR: ", e);
            }
        });
    }

}


function editComment(id){

	$('#tableComment').hide();
	$('#addCommentAdmin').show();
	$('#editComment').show();
	$('#btnAddCommentAdmin').hide();
	
    function showComments(){
        $.ajax({
            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/comment/" + id,

            success: function(result){
            	
                var idComment = $("#idComment");
                var textComment = $("#textComment");
				var idPostComment = $("#idPostComment");
				var idUserComment = $("#idUserComment");

                idComment.val(result.idComment);
                textComment.val(result.text);
                idPostComment.val(result.idPost);
				idUserComment.val(result.idUser)

            },
            error : function(e){
                alert('There was a mistake!')
                console.log("ERROR: ", e);
            }
        });
    }
    showComments();
}

function submitUpdateComment(){

    var id = $("#idComment").val();
    var textComment = $("#textComment").val();
	var idPostComment = $("#idPostComment").val();
	var idUserComment = $("#idUserComment").val();

    var formData = {
            "text" : textComment,
			"idPost" : idPostComment,
			"idUser" : idUserComment
    }
    $.ajax({

        url: "http://localhost:8080/api/comment/" + id,
        type: "PUT",
        contentType: 'application/json; charset=utf-8',
        data : JSON.stringify(formData),
        success: function(result){
            alert('Comment is succesfully changed!');
			showFormComments();
            ShowAllComments();
        },
        error : function(e){
            alert('There was an error!')
            console.log("ERROR: ", e);
        }
    });

}



function goBackFromAddingCommentRedditor(){
	$("#addComment").hide();
	$('#tableCommentsFromPostsFromCommunityRedditor').show();
}

function showFormAddComment(){
	$("#buttons").hide();
	$("#tableComment").hide();
	$("#addComment").show();
	$('#editComment').hide();
}

function showFormComments(){
	$("#buttons").hide();
	$("#tableComment").show();
	$("#addCommentAdmin").hide();
	$('#addingComment').show();
}//ADD COMMENT FORM
function showFormAddCommentAdmin(){
	$("#buttons").hide();
	$("#tableComment").hide();
	$("#addCommentAdmin").show();
}
function goBackFromAddingCommentAdmin(){
	$("#addCommentAdmin").hide();
	$('#tableComment').show();
}