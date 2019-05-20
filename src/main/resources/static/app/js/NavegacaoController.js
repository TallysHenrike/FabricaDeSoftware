angular.module("app").controller("NavegacaoController", function($rootScope, $scope, $http, $location, $timeout){
	$rootScope.navegacao = {}
	$scope.alerta = {abrir: false}
	
	if(localStorage.getItem('sessao')){
		let sessao = JSON.parse(localStorage.getItem('sessao'));
		if(sessao.token && sessao.expiracao >= new Date().getTime()){
			$rootScope.navegacao.temAcesso = true;
		}else{
			sessionStorage.clear();
			$rootScope.navegacao.temAcesso = false;
			$location.path('/acesso');
		}
	}else{
		sessionStorage.clear();
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$scope.fecharSessao = ()=>{
		localStorage.clear();
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$rootScope.navegacao.perfil = JSON.parse(localStorage.getItem('perfil'));
	
	$rootScope.acessar = (usuario)=>{
		$http.post('http://localhost:8080/acesso/acessar', usuario)
		.then((resposta)=>{
			localStorage.setItem("perfil", JSON.stringify(resposta.data));
			
            $rootScope.navegacao.perfil = resposta.data;
            $rootScope.navegacao.temAcesso = true;
            $location.path('/presenca');
			
			localStorage.setItem("sessao", JSON.stringify({
				token: resposta.data.acesso.token,
				//expiracao: new Date().getTime() + 60 * 60
				expiracao: new Date().getTime() + 60 * 60 * 1000
			}));
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