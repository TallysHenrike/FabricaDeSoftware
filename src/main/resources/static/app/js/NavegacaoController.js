appEventos.controller("NavegacaoController", function($rootScope, $scope, $http, $location, $timeout, Cookie){
	$rootScope.navegacao = {}
	$scope.alerta = {abrir: false}
	
	$scope.fecharSessao = ()=>{
		localStorage.clear();
		$location.path('/acesso');
	}
	
	$rootScope.navegacao.perfil = JSON.parse(localStorage.getItem('perfil'));
	
	if(Cookie.get('token') == null){
		$location.path('/acesso');
	}
	
	$rootScope.acessar = (usuario)=>{
		$http.post('./acesso/acessar', usuario)
		.then((resposta)=>{
			if(resposta.data.error){
				$scope.alerta.mensagem = resposta.data.message;
				$scope.alerta.abrir = true;
				$timeout(function(){
					$scope.alerta.abrir = false;
				}, 2500);
			}else{
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