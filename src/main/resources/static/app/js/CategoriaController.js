angular.module("app").controller("CategoriaController", function($rootScope, $scope, $http, $location) {
	$rootScope.activetab = $location.path();
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	function listar(){
		$http.get('http://localhost:8080/categoria/listar')
		.then((resposta)=>{
			$scope.categorias = resposta.data;
		});
	}
	listar();
	
	$scope.salvar = (form)=>{
		form.icone = 'https://picsum.photos/100';
		
		if($scope.operacao.alterar){
			$http.put('http://localhost:8080/categoria/alterar', form)
			.then((resposta)=>{
				$scope.categorias[form] = resposta.data;
				console.log(resposta.data);
			});
		}else{
			$http.post('http://localhost:8080/categoria/inserir', form)
			.then((resposta)=>{
				$scope.categorias.push(resposta.data);
				console.log(resposta.data);
			});
		}
		
		$scope.form = {};
		$scope.operacao = {
			alterar: false,
			btn: 'Cadastrar'
		}
	}
	
	$scope.consultar = (categoria)=>{
		$scope.form = categoria;
		$scope.operacao = {
			alterar: true,
			btn: 'Editar'
		}
	}
	
	$scope.excluir = (categoria)=>{
		$http.delete(`http://localhost:8080/categoria/deletar/${categoria.idCategoria}`)
		.then((resposta)=>{
			$scope.categorias.splice($scope.categorias.indexOf(categoria), 1);
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