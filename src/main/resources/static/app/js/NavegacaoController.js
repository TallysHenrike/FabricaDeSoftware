angular.module("app").controller("NavegacaoController", function($rootScope, $scope, $http, $location){
	$rootScope.navegacao = {
		perfil: {
			foto: '',
			nome: '',
			usuario: ''
		},
		temAcesso: false
	}
	
	if(!sessionStorage.getItem('temAcesso')){
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$scope.fecharSessao = ()=>{
		sessionStorage.removeItem('temAcesso');
		//$rootScope.navegacao.temAcesso = false;
	}
	
	$rootScope.navegacao = sessionStorage.getItem('temAcesso') ?
		JSON.parse(sessionStorage.getItem('temAcesso'))
		:
		{
			perfil: {
				foto: '',
				nome: '',
				usuario: ''
			},
			temAcesso: false
		};
	
	$rootScope.acessar = (usuario)=>{
		$http.post('http://localhost:8080/administrador/acessar', usuario)
		.then((resposta)=>{
			
			sessionStorage.setItem("token", resposta.data.token);
			
			if(resposta.data != ""){
				$rootScope.navegacao.perfil = resposta.data;
				$rootScope.navegacao.temAcesso = true;
				$location.path('/presenca');
			}else{
				$rootScope.navegacao.temAcesso = false;
			}
			
			sessionStorage.setItem('temAcesso', JSON.stringify($rootScope.navegacao));
		}, (resposta)=>{
			console.log(resposta.data);
		});
	}
});