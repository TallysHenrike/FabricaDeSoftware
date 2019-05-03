angular.module("app").controller("ColaboradorController", function($rootScope, $scope, $http, $location) {
	$rootScope.activetab = $location.path();
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	function listar(){
		$http.get('http://localhost:8080/colaborador/listar')
		.then((resposta)=>{
			$scope.colaboradores = resposta.data;
		});
	}
	listar();
	
	$scope.salvar = (form)=>{
		form.icone = 'https://picsum.photos/100';
		
		if($scope.operacao.alterar){
			$http.put('http://localhost:8080/colaborador/alterar', form)
			.then((resposta)=>{
				$scope.colaboradores[form] = resposta.data;
				console.log(resposta.data);
			});
		}else{
			$http.post('http://localhost:8080/colaborador/inserir', form)
			.then((resposta)=>{
				$scope.colaboradores.push(resposta.data);
				console.log(resposta.data);
			});
		}
		
		$scope.form = {};
		$scope.operacao = {
			alterar: false,
			btn: 'Cadastrar'
		}
	}
	
	$scope.consultar = (colaborador)=>{
		$scope.form = colaborador;
		$scope.operacao = {
			alterar: true,
			btn: 'Editar'
		}
	}
	
	$scope.excluir = (colaborador)=>{
		$http.delete(`http://localhost:8080/colaborador/deletar/${colaborador.idcolaborador}`)
		.then((resposta)=>{
			$scope.colaboradores.splice($scope.colaboradores.indexOf(colaborador), 1);
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