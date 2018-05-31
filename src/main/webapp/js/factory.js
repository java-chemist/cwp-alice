function Factory() {
	this.createObject = function(type) {
		var factoryObject;

		if (type === "CUSTOM_FILTER") {
			factoryObject = new CustomCaseFilter();
		} else if (type === "OWNER_FILTER") {
			factoryObject = new OwnerCaseFilter();
		} else if (type === "DISPLAY_CASE") {
			factoryObject = new DisplayCaseFilter();
		} else if (type === "VIEW_APPOINTMENTS") {
			factoryObject = new ViewAppointmentsFilter();
		} else if (type === "LOGOUT_SCENE") {
			factoryObject = new LogoutSceneFilter();
		} else if (type === "UPDATE_CASE_STATUS_SCENE") {
			factoryObject = new UpdateCaseStatusFilter();
		}

		factoryObject.type = type;

		/*
		 * employee.say = function () { log.add(this.type + ": rate " +
		 * this.hourly + "/hour"); }
		 */

		/*
		 * factoryObject.perform = function(msg) {
		 *  }
		 */
		return factoryObject;
	}
}

function fetchChatBotHistory() {
	var currentConvObj = [];
	$('.app-content .item-container,.app-content .time-indicator').each(
			function(index) {
				if ($(this).hasClass('item-container-bot')) {
					console.log(index + " Bot: " + $(this).text());
					item = {};
					item["message"] = $(this).text();
					item["messageType"] = "ITEM_BOT";
					item["messageDataType"] = "TEXT";
					currentConvObj.push(item);
				} else if ($(this).hasClass('item-container-user')) {
					console.log(index + " User: " + $(this).text());
					item = {};
					item["message"] = $(this).text();
					item["messageType"] = "ITEM_USER";
					item["messageDataType"] = "TEXT";
					currentConvObj.push(item);
				} else if ($(this).hasClass('time-indicator')) {
					console.log(index + " Time: " + $(this).text());
					item = {};
					item["message"] = $(this).text();
					item["messageType"] = "TIME_INDICATOR";
					item["messageDataType"] = "DATE";
					currentConvObj.push(item);
				}
			});
	return currentConvObj;
}

var UpdateCaseStatusFilter = function() {
	return {
		execute : function(actingObject) {
			console.log('Executing for update case status filter logic');
			var currentConvObj = fetchChatBotHistory();
			$.ajax({
				method : "POST",
				url : "/CaseWorkerPortal/saveAliceConversation",
				data : JSON.stringify(currentConvObj),
				contentType : "application/json"
			}).done(function(msg) {
				console.log("success when alice conversation object created");
				window.location.href = '/CaseWorkerPortal/cwDashboard';
			});
		},
		filter : function(actingObject) {
			console.log('Executing filter for update case status logic');
			return true;
		}
	}
};

var CustomCaseFilter = function() {
	return {
		execute : function(actingObject) {
			console.log('Executing for display custom case filter logic');
			var currentConvObj = fetchChatBotHistory();
			$.ajax({
				method : "POST",
				url : "/CaseWorkerPortal/saveAliceConversation",
				data : JSON.stringify(currentConvObj),
				contentType : "application/json"
			}).done(function(msg) {
				// alert('success when alice conversation object created');
				console.log("success when alice conversation object created");
				window.location.href = '/CaseWorkerPortal/cwDashboard';
			});
		},
		filter : function(actingObject) {
			console
					.log('Executing filter for display custom case filter logic');
			$('#inputTabularData_filter input[type="search"]')
					.val(actingObject).triggerHandler('keyup');
			return true;
		}
	}
};

var OwnerCaseFilter = function() {
	return {
		execute : function(actingObject) {
			console.log('Executing for display owner case filter logic');
			var currentConvObj = fetchChatBotHistory();
			$.ajax({
				method : "POST",
				url : "/CaseWorkerPortal/saveAliceConversation",
				data : JSON.stringify(currentConvObj),
				contentType : "application/json"
			}).done(function(msg) {
				console.log("success when alice conversation object created");
				window.location.href = '/CaseWorkerPortal/cwDashboard';
				/*
				 * $.ajax({ method: "GET", url: "/CaseWorkerPortal/cwDashboard" })
				 * .done(function( msg ) { $('#inputTabularData_filter
				 * input[type="search"]').val(actingObject).triggerHandler('keydown');
				 * });
				 */
			});
		},
		filter : function(actingObject) {
			console.log('Executing filter for display owner case filter logic');
			$('#inputTabularData_filter input[type="search"]')
					.val(actingObject).triggerHandler('keyup');
			return true;
		}
	}
};

var DisplayCaseFilter = function() {
	return {
		execute : function(actingObject) {
			console.log('Executing for display case filter logic');
			var currentConvObj = fetchChatBotHistory();
			$
					.ajax({
						method : "POST",
						url : "/CaseWorkerPortal/saveAliceConversation",
						data : JSON.stringify(currentConvObj),
						contentType : "application/json"
					})
					.done(
							function(msg) {
								console
										.log("success when alice conversation object created");
								window.location.href = '/CaseWorkerPortal/openCase/'
										+ actingObject;
							});

			// Add final outcome to chat interface
		},
		filter : function(actingObject) {
			console.log('Executing filter for opening case logic');
			return true;
		}
	}
};

var ViewAppointmentsFilter = function() {
	return {
		execute : function(actingObject) {
			console.log('Executing for view appointment filter logic');
			var currentConvObj = fetchChatBotHistory();
			$.ajax({
				method : "POST",
				url : "/CaseWorkerPortal/saveAliceConversation",
				data : JSON.stringify(currentConvObj),
				contentType : "application/json"
			}).done(function(msg) {
				console.log("success when alice conversation object created");
				window.location.href = '/CaseWorkerPortal/cwAppointment';
			});

			// Add final outcome to chat interface
		},
		filter : function(actingObject) {
			console.log('Executing filter for opening appointment logic');
			return true;
		}
	}
};

var LogoutSceneFilter = function() {
	return {
		execute : function(actingObject) {
			console.log('Executing for logout logic');
			window.location.href = '/CaseWorkerPortal/logout';
		}
	}
};

// Trigger ALICE command for UI
function runAliceCommand(command) {
	var factory = new Factory();
	var factoryInfo = findFactory.extractInfo(command);
	if (factoryInfo !== undefined && factoryInfo !== "") {
		factory.createObject(factoryInfo.objName).execute(factoryInfo.objValue);
	}

}

// Trigger ALICE filter command for UI
function runAliceFilterCommand(command) {
	var factory = new Factory();
	var factoryInfo = findFactory.extractInfo(command);
	factory.createObject(factoryInfo.objName).filter(factoryInfo.objValue);

}

function findInParsed(html, selector) {
	var check = $(selector, html).get(0);
	if (check)
		return $(check);
	check = $(html).filter(selector).get(0)
	return (check) ? $(check) : false;
}