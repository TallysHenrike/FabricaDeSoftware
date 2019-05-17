angular.module("app").controller("PresencaController", function($rootScope, $scope, $http, $location) {
	$http.defaults.headers.common['Authorization'] = `Bearer ${sessionStorage.getItem('token')}`;
	
	if(sessionStorage.getItem('token')){
		$rootScope.navegacao.temAcesso = true;
	}else{
		sessionStorage.clear();
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$rootScope.activetab = $location.path();
});