angular.module("app").controller("EventoController", function($rootScope, $scope, $http, $location) {
	if(!sessionStorage.getItem('temAcesso')){
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	$rootScope.activetab = $location.path();
	$scope.form = {};
	
	function handleFileSelect(evt) {
		let f = evt.target.files[0];
		let reader = new FileReader();
		
		reader.onload = (function(theFile) {
			return function(e) {
				let binaryData = e.target.result;
				let base64String = window.btoa(binaryData);
				
				$scope.form.imagemPrincipal = base64String;
				console.log($scope.form);
			};
		})(f);
		
		reader.readAsBinaryString(f);
	}
	document.getElementById("imagem-principal").addEventListener("change", handleFileSelect, false);
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	$http.get('http://localhost:8080/evento/listar')
	.then((resposta)=>{
		$scope.eventos = resposta.data;
	});
	
	$http.get('http://localhost:8080/categoria/listar')
	.then((resposta)=>{
		$scope.categorias = resposta.data;
	});
	
	$scope.salvar = (form)=>{
		console.log(form)
		
		if($scope.operacao.alterar){
			$http.put('http://localhost:8080/evento/alterar', form)
			.then((resposta)=>{
				$scope.eventos[form] = resposta.data;
				console.log(resposta.data);
			});
		}else{
			let idAdministrador = $rootScope.navegacao.perfil.idAdministrador;
			
			$http.post(`http://localhost:8080/evento/inserir/${idAdministrador}`, form)
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