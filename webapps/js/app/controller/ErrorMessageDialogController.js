require([ 'notification_module' ], function(module) {
	return module.controller('ErrorMessageDialogController', //
	[ '$scope', '$modalInstance','title', 'statusCode', 'message',//
	function($scope, $modalInstance, title, statusCode, message) {//
		$scope.title = title;
		$scope.statusCode = statusCode;
		$scope.message = message;

		$scope.close = function() {
			$modalInstance.close();
		};
	} ]);
});
