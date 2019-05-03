angular.module("app").controller("PatrocinadorController", function($rootScope, $scope, $http, $location) {
	$rootScope.activetab = $location.path();
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	function listar(){
		$http.get('http://localhost:8080/patrocinador/listar')
		.then((resposta)=>{
			$scope.patrocinadores = resposta.data;
		});
	}
	listar();
	
	$scope.salvar = (form)=>{
		form.icone = 'https://picsum.photos/100';
		
		if($scope.operacao.alterar){
			$http.put('http://localhost:8080/patrocinador/alterar', form)
			.then((resposta)=>{
				$scope.patrocinadores[form] = resposta.data;
				console.log(resposta.data);
			});
		}else{
			$http.post('http://localhost:8080/patrocinador/inserir', form)
			.then((resposta)=>{
				$scope.patrocinadores.push(resposta.data);
				console.log(resposta.data);
			});
		}
		
		$scope.form = {};
		$scope.operacao = {
			alterar: false,
			btn: 'Cadastrar'
		}
	}
	
	$scope.consultar = (patrocinador)=>{
		$scope.form = patrocinador;
		$scope.operacao = {
			alterar: true,
			btn: 'Editar'
		}
	}
	
	$scope.excluir = (patrocinador)=>{
		$http.delete(`http://localhost:8080/patrocinador/deletar/${patrocinador.idpatrocinador}`)
		.then((resposta)=>{
			$scope.patrocinadores.splice($scope.patrocinadores.indexOf(patrocinador), 1);
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