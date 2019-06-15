appEventos.controller("NavegacaoController", function($rootScope, $scope, $http, $location, $timeout, Cookie){
	$rootScope.navegacao = {}
	$scope.alerta = {abrir: false}
	
	$scope.fecharSessao = ()=>{
		localStorage.clear();
        Cookie.delete('token');
		$location.path('/acesso');
	}
	
	$rootScope.navegacao.perfil = JSON.parse(localStorage.getItem('perfil'));
	
	if(Cookie.get('token') == null){
		$location.path('/acesso');
	}
	
	$rootScope.acessar = (usuario)=>{
		$http.post('./acesso/acessar', usuario)
		.then((resposta)=>{
			if(resposta.data.status == 500){
				$scope.alerta.mensagem = resposta.data.message;
                $scope.alerta.mensagem = resposta.data.message;
				$scope.alerta.abrir = true;
				$timeout(function(){
					$scope.alerta.abrir = false;
				}, 2500);
			}else{
                $rootScope.navegacao.temAcesso = true;
				localStorage.setItem("perfil", JSON.stringify(resposta.data));

				$rootScope.navegacao.perfil = resposta.data;
				$location.path('/presenca');

				//localStorage.setItem("token", resposta.data.acesso.token);
				Cookie.set('token', resposta.data.acesso.token, new Date(new Date().getTime() + (60 * 60 * 1000)));
			}
		}, (resposta)=>{
			console.log(resposta.data);
			$scope.alerta.mensagem = resposta.data.message;
			$scope.alerta.abrir = true;
			$timeout(function(){
				$scope.alerta.abrir = false;
			}, 2500);
		});
	}
});