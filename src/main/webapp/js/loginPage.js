/*  Author: amitkumar466 
	Purpose: Client-side logic for login-page of DCM
	Date: 11/11/2017
*/
$(document).ready(function(){
	$('#mySpinner').removeClass('spinner');
	$('#mySpinnerBackdrop').removeClass('show');
	$('#mySpinnerBackdrop').addClass('hide');
	$('#getStarted').on('click',function(){
		$('#mySpinner').addClass('spinner');
		$('#mySpinnerBackdrop').removeClass('hide');
		$('#mySpinnerBackdrop').addClass('show');
	});			
});	