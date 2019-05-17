angular.module("app").controller("NavegacaoController", function($rootScope, $scope, $http, $location, $timeout){
	$rootScope.navegacao = {}
	$scope.alerta = {abrir: false}
	
	if(sessionStorage.getItem('token')){
		$rootScope.navegacao.temAcesso = true;
	}else{
		sessionStorage.clear();
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$scope.fecharSessao = ()=>{
		sessionStorage.clear();
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$rootScope.navegacao.perfil = JSON.parse(sessionStorage.getItem('perfil'));
	
	$rootScope.acessar = (usuario)=>{
		$http.post('http://localhost:8080/administrador/acessar', usuario)
		.then((resposta)=>{
			sessionStorage.setItem("token", resposta.data.acesso.token);
			sessionStorage.setItem("perfil", JSON.stringify(resposta.data));
			
            $rootScope.navegacao.perfil = resposta.data;
            $rootScope.navegacao.temAcesso = true;
            $location.path('/presenca');
		}, (resposta)=>{
			sessionStorage.clear();
            console.log(resposta.data);
			$scope.alerta.mensagem = resposta.data.message;
			$scope.alerta.abrir = true;
			$timeout(function(){
				$scope.alerta.abrir = false;
			}, 2000);
		});
	}
});