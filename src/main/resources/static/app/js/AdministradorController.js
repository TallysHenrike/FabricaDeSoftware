angular.module("app").controller("AdministradorController", function($rootScope, $scope, $http, $location) {
	if(!sessionStorage.getItem('temAcesso')){
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$rootScope.activetab = $location.path();
	$scope.form = {};
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	function listar(){
		$http.get('http://localhost:8080/administrador/listar')
		.then((resposta)=>{
			$scope.administradores = resposta.data;
		});
	}
	listar();
	
	$scope.salvar = (form)=>{
		if($scope.operacao.alterar){
			$http.put('http://localhost:8080/administrador/alterar', form)
			.then((resposta)=>{
				$scope.administradores[form] = resposta.data;
				console.log(resposta.data);
			});
		}else{
			$http.post('http://localhost:8080/administrador/inserir', form)
			.then((resposta)=>{
				$scope.administradores.push(resposta.data);
				console.log(resposta.data);
			});
		}
		
		$scope.form = {};
		$scope.operacao = {
			alterar: false,
			btn: 'Cadastrar'
		}
	}
	
	$scope.consultar = (administrador)=>{
		$scope.form = administrador;
		$scope.operacao = {
			alterar: true,
			btn: 'Editar'
		}
	}
	
	$scope.excluir = (administrador)=>{
		$http.delete(`http://localhost:8080/administrador/deletar/${administrador.idAdministrador}`)
		.then((resposta)=>{
			$scope.administradores.splice($scope.administradores.indexOf(administrador), 1);
			console.log(resposta.data);
		});
	}
	
	$scope.resetForm = ()=>{
		$scope.form = {};
		$scope.operacao = {
			alterar: false,
			btn: 'Cadastrar'
		}
	}
});