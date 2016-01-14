define([
// All controllers
'app/controller/ConfirmMessageDialogController',
'app/controller/WarningMessageDialogController',
'app/controller/ErrorMessageDialogController',
// All services
'app/service/NotificationDisplayService'//
], function() {
    var module = angular.module('vimcon.notification', [ 'ui.bootstrap' ]);
    return module;
});
