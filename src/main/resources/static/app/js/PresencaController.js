angular.module("app").controller("PresencaController", function($rootScope, $scope, $http, $location) {
	if(localStorage.getItem('sessao')){
		let sessao = JSON.parse(localStorage.getItem('sessao'));
		if(sessao.token && sessao.expiracao >= new Date().getTime()){
			$http.defaults.headers.common['Authorization'] = `Bearer ${sessao.token}`;
			$rootScope.navegacao.temAcesso = true;
		}else{
			localStorage.clear();
			$rootScope.navegacao.temAcesso = false;
			$location.path('/acesso');
		}
	}else{
		localStorage.clear();
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$rootScope.activetab = $location.path();
});