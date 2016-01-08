require(
	[ 'notification_module' ],
	function(module) {
	    // NotificationDisplayService
	    return module.factory('NotificationDisplayService',
		    NotificationDisplayService);

	    NotificationDisplayService.$inject = [ '$modal' ];

	    function NotificationDisplayService($modal) {

		var service = {
		    showConfirmMessageDialog : showConfirmMessageDialog,
		    showWarningMessageDialog : showWarningMessageDialog,
		    showErrorMessageDialog : showErrorMessageDialog
		};

		return service;

		// private
		function showConfirmMessageDialog(title, message, data) {
		    return $modal
			    .open({
				templateUrl : 'pages/confirm-message-modal.html',
				size : 'md',
				controller : 'ConfirmMessageDialogController as confirmDialog',
				resolve : {
				    title : function() {
					return title;
				    },
				    message : function() {
					return message;
				    },
				    resolveData : function() {
					return data;
				    }

				}
			    });
		}

		function showWarningMessageDialog(title, message) {
		    return $modal.open({
			templateUrl : 'pages/warning-message-modal.html',
			size : 'md',
			controller : 'warningMessageDialogController as wd',
			resolve : {
			    title : function() {
				return title;
			    },
			    message : function() {
				return message;
			    }

			}
		    });
		}

		function showErrorMessageDialog(response, title, message) {
		    return $modal
			    .open({
				templateUrl : 'pages/error-message-modal.html',
				size : 'lg',
				controller : 'ErrorMessageDialogController',
				backdrop : 'static',
				keyboard : false,
				resolve : {
				    title : function() {
					return title;
				    },
				    statusCode : function() {
					return (response && response.status) ? response.status
						: '';
				    },
				    message : function() {
					    if (angular.isFunction(message)) {
					        return message();
					    } else {
					        if (response && response.data) {
					            return response.data.message || response.data;
					        } else {
					            return response || ''; 
					        }
					    }
				    }
				}
			});
		}

	    }
	});