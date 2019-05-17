angular.module("app").controller("NavegacaoController", function($rootScope, $scope, $http, $location){
	$rootScope.navegacao = {
		perfil: {
			foto: '',
			nome: '',
			usuario: ''
		},
		temAcesso: false
	}
	
	$scope.fecharSessao = ()=>{
		$rootScope.navegacao.temAcesso = false;
	}
	
	$rootScope.acessar = (usuario)=>{
		$http.post('http://localhost:8080/administrador/acessar', usuario)
		.then((resposta)=>{
			
			sessionStorage.setItem("token", resposta.data.acesso.token);
			
            $rootScope.navegacao.perfil = resposta.data;
            $rootScope.navegacao.temAcesso = true;
            $location.path('/presenca');
		}, (resposta)=>{
            console.log(resposta.data);
			$rootScope.navegacao.temAcesso = false;
            $location.path('/');
		});
	}
});