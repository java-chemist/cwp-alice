var AppUtils = (function () {
    return {		
    	findInParsed: function (html, selector) {
    		var check = $(selector, html).get(0);
    	    if(check)
    	        return $(check);
    	    check = $(html).filter(selector).get(0)
    	    return (check)? $(check) : false;
		},
		triggerCaseTablePopulation: function (data, selector){
			$(selector)
			.DataTable({
				processing : true,
				"data" : data,
				"columns" : [
						{
							"data" : "id",
							"render" : function(
									data, type,
									row, meta) {
								if (type === 'display') {
									data = '<a href="openCase/' + data + '">'
											+ data
											+ '</a>';
								}

								return data;
							}
						},
						{
							"data" : "assignedCwName"
						}, {
							"data" : "date"
						}, {
							"data" : "desc"
						}, {
							"data" : "status"
						} ],
				responsive : true
			});
		},
		showSpinner: function(){
			$('#mySpinner').addClass('spinner');
			$('#mySpinnerBackdrop').removeClass('hide');
			$('#mySpinnerBackdrop').addClass('show');
		},
		hideSpinner: function(){
			$('#mySpinner').removeClass('spinner');
			$('#mySpinnerBackdrop').removeClass('show');
			$('#mySpinnerBackdrop').addClass('hide');
		}
		
    }
})();
