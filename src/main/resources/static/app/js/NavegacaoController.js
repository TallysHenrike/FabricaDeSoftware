angular.module("app").controller("NavegacaoController", function($rootScope, $scope, $http, $location, $timeout){
	$rootScope.navegacao = {}
	$scope.alerta = {abrir: false}
	
	if(sessionStorage.getItem('sessao')){
		let sessao = JSON.parse(sessionStorage.getItem('sessao'));
		if(sessao.token && sessao.expiracao >= new Date().getTime()){
			$rootScope.navegacao.temAcesso = true;
		}else{
			sessionStorage.clear();
			$rootScope.navegacao.temAcesso = false;
			$location.path('/acesso');
		}
	}
	
	$scope.fecharSessao = ()=>{
		sessionStorage.clear();
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$rootScope.navegacao.perfil = JSON.parse(sessionStorage.getItem('perfil'));
	
	$rootScope.acessar = (usuario)=>{
		$http.post('http://localhost:8080/acesso/acessar', usuario)
		.then((resposta)=>{
			sessionStorage.setItem("perfil", JSON.stringify(resposta.data));
			
            $rootScope.navegacao.perfil = resposta.data;
            $rootScope.navegacao.temAcesso = true;
            $location.path('/presenca');
			
			sessionStorage.setItem("sessao", JSON.stringify({
				token: resposta.data.acesso.token,
				//expiracao: new Date().getTime() + 60 * 60
				expiracao: new Date().getTime() + 60 * 60 * 1000
			}));
		}, (resposta)=>{
			sessionStorage.clear();
            console.log(resposta.data);
			$scope.alerta.mensagem = resposta.data.message;
			$scope.alerta.abrir = true;
			$timeout(function(){
				$scope.alerta.abrir = false;
			}, 2500);
		});
	}
});