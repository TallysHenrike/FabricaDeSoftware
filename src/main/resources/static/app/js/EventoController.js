angular.module("app").controller("EventoController", function($rootScope, $scope, $http, $location) {
	$rootScope.activetab = $location.path();
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	$http.get('http://localhost:8080/evento/listar')
	.then((resposta)=>{
		$scope.eventos = resposta.data;
	});
	
	$scope.salvar = (form)=>{
		form.icone = 'https://picsum.photos/100';
		
		if($scope.operacao.alterar){
			$http.put('http://localhost:8080/evento/alterar', form)
			.then((resposta)=>{
				$scope.eventos[form] = resposta.data;
				console.log(resposta.data);
			});
		}else{
			$http.post('http://localhost:8080/evento/inserir', form)
			.then((resposta)=>{
				$scope.eventos.push(resposta.data);
				console.log(resposta.data);
			});
		}
		
		$scope.form = {};
		$scope.operacao = {
			alterar: false,
			btn: 'Cadastrar'
		}
	}
	
	$scope.consultar = (evento)=>{
		$scope.form = evento;
		$scope.operacao = {
			alterar: true,
			btn: 'Editar'
		}
	}
	
	$scope.excluir = (evento)=>{
		$http.delete(`http://localhost:8080/evento/deletar/${evento.idEvento}`)
		.then((resposta)=>{
			$scope.eventos.splice($scope.eventos.indexOf(evento), 1);
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