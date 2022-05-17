function ShowAllCommunities(){ 

    var tableCommunity = $("#tableCommunity");
    var tbodyCommunity = $("#tbodyCommunity");

    function showCommunities(){
    	$('#adding').show();
	   	$('#prijava').hide();
    	$('#btnLogin').hide();
		$('#DugmePrikazLogiina').hide();


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

function submitCommunity(){

    var error = "";
    var nameInput = "";
    var descriptionInput = "";
    var creationDateInput = "";
    var rulesInput = "";
	var suspendedReason ="";

    nameInput = $("#nameCommunity").val();
    descriptionInput = $("#descriptionCommunity").val();
    creationDateInput = $("#creationDateCommunity").val();
    rulesInput = $("#rulesCommunity").val();
	suspendedReasonInput = $("#suspendedReasonCommunity").val();


    var nameInputError;
    var descriptionInputError;
    var creationDateError;
	var rulesInputError;
	var suspendedReasonInputError;
    
    if(nameInput === ""){
    	nameInputError = true;
        error += "\nEnter name!";
    }
    if(descriptionInput === ""){
    	descriptionInputError = true;
        error += "\nEnter description!";
    }
    if(creationDateInput === ""){
    	creationDateError = true;
        error += "\nEnter date!";
    }
    if(rulesInput === ""){
    	rulesInputError = true;
        error += "\nEnter rules!";
    }
    if(suspendedReasonInput === ""){
    	suspendedReasonInputError = true;
        error += "\nEnter suspended reasons!";
    }


    if(nameInputError || descriptionInputError || creationDateError || rulesInputError || suspendedReasonInputError){
        alert(error);
    }
    else{
        var formData = {
            "nameCommunity" : nameInput,
            "descriptionCommunity" : descriptionInput,
            "creationDateCommunity" : creationDateInput,
            "rulesCommunity" : rulesInput,
			"suspendedReasonCommunity" : suspendedReasonInput,
        }

        $.ajax({
            url : "http://localhost:8080/api/community",
            type : "POST",
            contentType: 'application/json; charset=utf-8',
            data : JSON.stringify(formData),
            success: function(){
                alert('Community is succesfully added!');
                odrediPrikaz('allCommunities');
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
	
    function showCommunities(){
        $.ajax({
            type: "GET",
            contentType : 'application/json; charset=utf-8',
            url : "http://localhost:8080/api/community/" + id,

            success: function(result){

                var idCommunity = $("#idCommunity");
                var name = $("#nameCommunity");
                var description = $("#descriptionCommunity");
                var creationDate = $("#creationDateCommunity");
				var rules = $("#rulesCommunity");
				var isSuspended = $("#isSuspendedCommunity");
				var suspendedReason = $("#suspendedReasonCommunity");

                idCommunity.val(result.idCommunity);
                name.val(result.name);
                description.val(result.description);
                creationDate.val(result.creationDate);
                rules.val(result.rules);
                isSuspended.val(result.isSuspended);
				suspendedReason.val(result.suspendedReason);

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
    var name = $("#nameCommunity").val();
    var description = $("#descriptionCommunity").val();
    var creationDate = $("#creationDateCommunity").val();
	var rules = $("#rulesCommunity").val();
	var isSuspended = $("#isSuspendedCommunity").val();
	var suspendedReason = $("#suspendedReasonCommunity").val();

    var formData = {
            "nameCommunity" : name,
            "descriptionCommunity" : description,
            "creationDateCommunity" : creationDate,
            "rulesCommunity" : rules,
			"isSuspendedCommunity" : isSuspended,
			"suspendedReasonCommunity" : suspendedReason
    }

    $.ajax({

        url: "http://localhost:8080/api/community/" + id,
        type: "PUT",
        contentType: 'application/json; charset=utf-8',
        data : JSON.stringify(formData),
        success: function(result){
            alert('Community is succesfully changed!');
            odrediPrikaz('allCommunities');
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
            odrediPrikaz('allCommunities');
        },
        error : function(e){
            alert('There was an error!')
            console.log("ERROR: ", e);
        }
    });
}

function goBackToStartCommunity(){
	$('#tableallCommunitiy').hide();
	$('#prijava').hide();
	$('#DugmePrikazLogiina').show();
	$('#ButtonShowCommunities').show();
}

function goBackFromAddingUpdateCommunity(){
	$('#tableCommunitiy').show();
	$('#addCommunitiy').hide();
	$('#addingCommunitiy').show();
}