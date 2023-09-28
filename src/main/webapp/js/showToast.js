/**
 * 
 */

let isDone = $( ".status ").attr("isSuccess");

console.log(isDone)

if(  isDone == "true" ) {

 $( ".status" ).addClass("show success");

 let timeout = setTimeout(function() { 
         $( ".status" ).removeClass("show ");
       
    }, 2000);

}else if(isDone == "null") {
	console.log("k lam gi")
}else if( isDone == "false" ) {
	 $( ".status" ).addClass("show failed");
	 let timeout = setTimeout(function() { 
         $( ".status" ).removeClass("show " );
       
    }, 2000);
}

$( ".btn-success" ).on("click", function() {
	
	$( ".form-control-line" ).value="";
	
})













