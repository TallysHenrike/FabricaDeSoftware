angular.module("app").controller("PresencaController", function($rootScope, $scope, $http, $location) {
	if(!sessionStorage.getItem('temAcesso')){
		$rootScope.navegacao.temAcesso = false;
		$location.path('/');
	}
	
	$rootScope.activetab = $location.path();
});