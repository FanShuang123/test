//
//
//
// Using the core $.ajax() method
// $.ajax({
// 
//    // The URL for the request
//    url: "post.php",
// 
//    // The data to send (will be converted to a query string)
//    data: {
//        id: 123
//    },
// 
//    // Whether this is a POST or GET request
//    type: "GET",
// 
//    // The type of data we expect back
//    dataType : "json",
//})
//  // Code to run if the request succeeds (is done);
//  // The response is passed to the function
//  .done(function( json ) {
//     $( "<h1>" ).text( json.title ).appendTo( "body" );
//     $( "<div class=\"content\">").html( json.html ).appendTo( "body" );
//  })
//  // Code to run if the request fails; the raw request and
//  // status codes are passed to the function
//  .fail(function( xhr, status, errorThrown ) {
//    alert( "Sorry, there was a problem!" );
//    console.log( "Error: " + errorThrown );
//    console.log( "Status: " + status );
//    console.dir( xhr );
//  })
//  // Code to run regardless of success or failure;
//  .always(function( xhr, status ) {
//    alert( "The request is complete!" );
//  });
$(function(){

//	先展示所有的等级名称
	showGradeName();
	
	$("#save").click(function(){
		
		addMember();
	});

	
	
	
	
});


/**
 * 先展示所有的等级名称
 */
function showGradeName(){

	$.ajax({
	    url: "../../showGradeName",
//	    data: data,
	    type: "post",
	    dataType :"json",
	})

	  .done(function( json ) {
		 
		  var arr= [];
	   for (var i = 0; i < json.length; i++) {
		   arr.push("<option value="+json[i].gradeName+">"+json[i].gradeName+"</option>");

	   }
//		  <option value="默认等级">默认等级</option>
//        <option value="初始等级">初始等级</option>
		  
	   $("#opt").html(arr);
	  })
	
	
}
/**
 * add添加方法
 */
function addMember(){
	
	var data = $("#form1").serialize();
	$.ajax({
	    url: "../../addMember",
	    data: data,
	    type: "post",
	    dataType :"text",
	})

	  .done(function( json ) {
		  alert("添加成功");
	   
	  })

//	  .fail(function( xhr, status, errorThrown ) {
//	    alert( "Sorry, there was a problem!" );
//	    console.log( "Error: " + errorThrown );
//	    console.log( "Status: " + status );
//	    console.dir( xhr );
//	  
//
//	  });	
	
	
}