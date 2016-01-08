require([ 'notification_module' ], function(module) {
    //
    return module.controller('ConfirmMessageDialogController',
	    ConfirmMessageDialogController);
    //
    ConfirmMessageDialogController.$inject([ '$scope', '$modalInstance',
	    'title', 'message', 'resolveData' ]);

    function ConfirmMessageDialogController($scope, $modalInstance, title,
	    message, resolveData) {//
	var confirmDialog = this;

	confirmDialog.title = title;
	confirmDialog.message = message;
	confirmDialog.action = action;
	confirmDialog.close = close;

	//////////
	function action() {
	    $modalInstance.close(resolveData);
	}

	function close() {
	    $modalInstance.close();
	}
    }
});
