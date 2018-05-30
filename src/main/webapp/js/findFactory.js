var compareObj = (function () {
    var comparisonResultObj = {"result":false,resultVerified:""};
	comparisonResultObj.result = Boolean(false);
	//console.log('comparisonResultObj2='+comparisonResultObj.result);
	
    return {		
        compare: function (msg, comparatorSet) {			
			//console.log('comparisonResultObj1='+comparisonResultObj.result);
			comparisonResultObj.result=comparatorSet.some(function(v) {
				if((msg.match(v) || []).length > 0){
					comparisonResultObj.resultValue = msg.split(v)[1];
					return true;
				}
				return Boolean.false;
			});	
			
			//console.log('comparisonResultObj='+comparisonResultObj.result);
			return comparisonResultObj;
		}
    }
})();


// finding factory
var findFactory = (function () {
    var factory = {"objName":"","objValue":""};
	
    return {		
        extractInfo: function (msg) {
			var customCaseFilterSet = ['filtering results for case worker ','filtering results for case ', 'Filtering the table for case '];
			var ownerCaseFilterSet = ['showing cases assigned to ', 'Filtering the table to show all your cases '];
			var caseDisplaySet = ['displaying case ', 'Opening details for case '];
			var viewAppointmentSet = ['view all my appointments for today'];
			var logoutSet = ['It was great working with you. See you next time!'];
			var currentExecutionObj = "";
			if (true == (function(){var resultObj = compareObj.compare(msg, customCaseFilterSet);
					currentExecutionObj = resultObj.resultValue; return resultObj.result})()) {
				factory.objName = "CUSTOM_FILTER";
				factory.objValue = currentExecutionObj;
				return factory;
			} else if (true == (function(){var resultObj = compareObj.compare(msg, ownerCaseFilterSet);
							currentExecutionObj = resultObj.resultValue; return resultObj.result})()) {
				factory.objName = "OWNER_FILTER";
				factory.objValue = currentExecutionObj;
				return factory;
			} else if (true == (function(){var resultObj = compareObj.compare(msg, caseDisplaySet);
							currentExecutionObj = resultObj.resultValue; return resultObj.result})()) {
				factory.objName = "DISPLAY_CASE";
				factory.objValue = currentExecutionObj;
				return factory;
			} else if (true == (function(){var resultObj = compareObj.compare(msg, viewAppointmentSet);
							currentExecutionObj = resultObj.resultValue; return resultObj.result})()) {
				factory.objName = "VIEW_APPOINTMENTS";
				factory.objValue = currentExecutionObj;
				return factory;
			} else if (true == (function(){var resultObj = compareObj.compare(msg, logoutSet);
							currentExecutionObj = resultObj.resultValue; return resultObj.result})()) {
				factory.objName = "LOGOUT_SCENE";
				factory.objValue = currentExecutionObj;
				return factory;
			}			
		}
    }
})();
