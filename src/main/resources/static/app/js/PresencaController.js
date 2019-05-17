angular.module("app").controller("PresencaController", function($rootScope, $scope, $http, $location) {
	if(!sessionStorage.getItem('token')){
		$location.path('/acesso');
	}
	
	$rootScope.activetab = $location.path();
});