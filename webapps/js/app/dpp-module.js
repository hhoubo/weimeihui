define([ //
         'moment',
// All controllers
         'app/controller/OrderController',//
         'app/controller/ItemController',//
         // All services
         'app/service/OrderService', //
         'app/service/ItemService', //
         'app/service/CustomerService'//
], function(moment) {

	var module = angular.module('dpp', [ 'ui.router', 'ngResource', 'ngSanitize', 'ui.select',
			'ui.bootstrap', 'ui.bootstrap.tpls', 'ui.bootstrap.datetimepicker',//
			'ui.grid', 'ui.grid.selection', 'ui.grid.cellNav', 'ui.grid.resizeColumns', 
			'ui.grid.moveColumns', 'ui.grid.pagination', 'ui.utils', 'ui.calendar',//
			'ui.validate', 'daterangepicker',
			'vimcon.notification', 'vimcon.jobManager']);
	
	module.filter('ApplicationTypeFilter',['$rootScope', function($rootScope){
		if(!$rootScope.ApplicationType){
			//ApplicationType enum
			$rootScope.ApplicationType = {
					"SPARK_STREAM_WITH_KAFKA" : {description : 'Spark Stream with Apache Kafka'},
					"SPARK_BATCH" : {description : 'Spark Batch'},
					"NORMAL_BATCH" : {description : 'Normal Batch'},
					"LIGHTMAN_SERVER" : {description : 'Lightman Server'},
					"LIGHTMAN_TASK" : {description : 'Lightman Task'},
					"UNKNOWN" : {description : 'Unknow'}
			};
		}
		return function(applicationType){
		    if($rootScope.ApplicationType[applicationType]){
			return $rootScope.ApplicationType[applicationType].description;
		    }
		};
	}]);
	module.filter('TimeZoneFilter', ['$rootScope',  function($rootScope){
	    return function(dateTime){
		if(dateTime){
		    return moment(dateTime).format('YYYY-MM-DD HH:mm:ss (Z)');
		}else {
		    return "Unassigned";
		}
	    }
	}]);
	module.filter('TimeWithTimeZone', ['$rootScope',  function($rootScope){
	    return function(dateTime){
		if(dateTime){
		    return moment(dateTime).format('HH:mm (Z)');
		}
	    }
	}]);
	
	module.filter('ordinalSuffix', function() {
	    return function(input) {
	      var s=["th","st","nd","rd"],
	      v=input%100;
	      return (s[(v-20)%10]||s[v]||s[0]);
	    }
	});
	
	module.config([ '$stateProvider','$urlRouterProvider',//
	    function($stateProvider, $urlRouterProvider) {
		$stateProvider.state('dashboard', {
		    url : '/dashboard',
		    templateUrl : 'pages/dashboard/dashboard.html'
		})//
		.state('schedule', {
		    url : '/schedule',
		    templateUrl : 'pages/schedule-manager/schedule.html'
		})
		// go to application manager page.
		.state('apps-manager', {
		    url : '/apps-manager',
		    templateUrl : 'pages/application-manager/applications-manager.html'
		})//
		.state('resources-manager', {
		    url : '/resources-manager',
		    templateUrl : 'pages/resource-manager/resources-manager.html'
		})//
		.state('event-manager', {
		    url : '/event-manager',
		    templateUrl : 'pages/event-manager/event-manager.html'
		})//
		.state('scalability-setting', {
		    url : '/scalability-setting',
		    templateUrl : 'pages/scalability-setting/scalability-setting.html'
		})//
		.state('user-setting', {
		    url : '/user-setting',
		    templateUrl : 'pages/user-setting/user-setting.html'
		})//
		// ///////////////////////////resource manager sub pages
		.state('resources-manager-cassandra-monitor', {
		    url : '/resources-manager/cassandra-monitor',
		    templateUrl : 'pages/resource-manager/resource/cassandra-monitor.html'
		});//

		$urlRouterProvider.otherwise('/apps-manager');
	    } ])
	    .run(
		    [
			    "$rootScope",
			    function($rootScope) {
				$rootScope
					.$on(
						"$locationChangeSuccess",
						function(event, next,
							current) {
						    var currentPath = current
							    .substring(current
								    .lastIndexOf('/') + 1);
						    var nextPath = next
							    .substring(next
								    .lastIndexOf('/') + 1);
						});
			    } ]);
	return module;
});
