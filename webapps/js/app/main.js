require
		.config({
			baseUrl :  'js/',
			paths : {
				jquery : 'lib/bower_components/jquery/dist/jquery.min',
				angular : 'lib/bower_components/angular/angular',
				angular_ui_grid : 'lib/bower_components/angular-ui-grid/ui-grid',
				angular_ui_select : 'lib/bower_components/angular-ui-select/dist/select.min',
				angular_ui_router : 'lib/bower_components/angular-ui-router/release/angular-ui-router',
				angular_ui_validate : 'lib/bower_components/angular-ui-validate/dist/validate',
				bootstrap : 'lib/bower_components/bootstrap/dist/js/bootstrap.min',
				moment : 'lib/bower_components/moment/moment',
				datetimepicker : 'lib/bower_components/angular-bootstrap-datetimepicker/src/js/datetimepicker',
				// weimeihui modules
				app_module : 'app/app-module',
			},
			shim : {
				angular : {
					exports : 'angular'
				},
				angular_resource : {
                    deps : [ 'angular' ]
                },
				angular_bootstrap : {
					deps : [ 'angular' ]
				},
				angular_ui_select : {
					deps : [ 'angular', 'angular_route', 'angular_resource',
							'jquery' ]
				},
				angular_ui_router : {
				    deps : [ 'angular' ],
				    exports : 'angular_ui_router'
				},
				angular_ui_validate : {
				    	deps : [ 'angular' ],
					exports : 'angular_ui_validate'
				},
				jquery : {
					exports : '$'
				},
				bootstrap : {
					deps : [ 'jquery' ],
					exports : 'bootstrap'
				},
				moment : {
					exports : 'moment'
				},
				datetimepicker : {
				    	deps : ['angular', 'moment'],
				    	exports : 'datetimepicker'
				}, 
				// weimeihui modules
				app_module : {
					deps : [ 'jquery', 'adminlte', //
					'angular', 'angular_messages', 'angular_resource',//
					'angular_bootstrap', 'angular_ui_router',//
					'angular_ui_util', 'angular_ui_grid', 'angular_sanitize', 'angular_ui_select', //
					'bootstrap' , 'moment', 'angular_ui_calendar', 'angular_ui_validate',
					'notification_module', 'job_module' ],
					exports : 'app_module'
				},
				notification_module : {
				    deps : [ 'angular', 'angular_bootstrap' ],
				    exports : 'notification_module'
				},
			}
		});

require([ 'bootstrap', 'ngFileUpload', 'daterangepicker', 'datetimepicker', 'ionSlider', 
		'iCheck', 'knob', 'sparkline', 'chart', 'flotChart', 'jvectormap',
		'jvectormapWorldMill', //

		'app_module', //
		'notification_module'//
],

function() {
	angular.bootstrap(document, [ 'weimeihui' ]);
});
