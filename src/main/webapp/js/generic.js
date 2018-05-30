// Initialize Variables
document.addEventListener("DOMContentLoaded", function(event) {
	var button = $("#voice-icon");
	var overlay = $("#overlay");
    var popup = $("#popup");
    var minimize = $("#minimizeAlice");
    var close = $("#closeAlice");
    
	$(button).on('click', function(){
		$(overlay).css('display','block');
        $(popup).css('display','block');
        if($(".time-indicator-content").text() === undefined || $(".time-indicator-content").text() === ""){
        	triggerInitialConversation();
        }        
	});
	
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