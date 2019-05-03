angular.module("app").controller("NavegacaoController", function($rootScope, $scope, $http, $location){
	$scope.temAcesso = true;
	
	$scope.navegacao = {
		perfil: {
			foto: '',
			nome: '',
			usuario: ''
		}
	}
	
	$http.get('http://localhost:8080/administrador/buscar/2')
	.then((resposta)=>{
		$scope.navegacao.perfil = resposta.data;
		$scope.navegacao.perfil.foto = 'http://agbrands.com.br/wp-content/uploads/2017/01/perfil.jpg';
	});
});