require([ 'notification_module' ], function(module) {
    //
    return module.controller('WarningMessageDialogController',
	    WarningMessageDialogController);
    //
    WarningMessageDialogController.$inject([ '$scope', '$modalInstance',
	    'title', 'message' ]);

    function WarningMessageDialogController($scope, $modalInstance, title,
	    message) {//
	var wd = this;

	wd.title = title;
	wd.message = message;
	wd.ok = ok;

	//////////
	function ok() {
	    $modalInstance.close();
	}
    }
});
