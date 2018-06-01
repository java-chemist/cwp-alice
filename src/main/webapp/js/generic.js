// Initialize Variables
document.addEventListener("DOMContentLoaded", function(event) {
	var button = $("#voice-icon");
	var overlay = $("#overlay");
    var popup = $("#popup");
    var minimize = $("#minimizeAlice");
    var close = $("#closeAlice");
    
	$(minimize).on('click', function(){
		$(overlay).css('display','none');
        $(popup).css('display','none');
        $(button).css('display','block');
	});
	
	$(close).on('click', function(){
		$(overlay).css('display','none');
        $(popup).css('display','none');
        $(button).css('display','block');
        $('.app-content').html('<div class="time-indicator"><div class="time-indicator-content"></div><hr /></div>');        
	});
		
});

function navigateURL(url){
	var currentConvObj = fetchChatBotHistory();
	$.ajax({
		method: "POST",
		url: "/CaseWorkerPortal/saveAliceConversation",
		data: JSON.stringify(currentConvObj),
		contentType:"application/json"
	})
	.done(function( msg ) {
		console.log("success when alice conversation object created");
		window.location.href = '/CaseWorkerPortal/'+url;
	});
}