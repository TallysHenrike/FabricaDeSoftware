appEventos.controller("NavegacaoController", function($rootScope, $scope, $http, $location, $timeout){
	$rootScope.navegacao = {}
	$scope.alerta = {abrir: false}
	
	$scope.fecharSessao = ()=>{
		localStorage.clear();
		$location.path('/acesso');
	}
	
	$rootScope.navegacao.perfil = JSON.parse(localStorage.getItem('perfil'));
	
	$rootScope.acessar = (usuario)=>{
		$http.post('http://localhost:8080/acesso/acessar', usuario)
		.then((resposta)=>{
			localStorage.setItem("perfil", JSON.stringify(resposta.data));
			
            $rootScope.navegacao.perfil = resposta.data;
            $location.path('/presenca');
			
			localStorage.setItem("token", resposta.data.acesso.token);
		}, (resposta)=>{
			localStorage.clear();
            console.log(resposta.data);
			$scope.alerta.mensagem = resposta.data.message;
			$scope.alerta.abrir = true;
			$timeout(function(){
				$scope.alerta.abrir = false;
			}, 2500);
		});
	}
});