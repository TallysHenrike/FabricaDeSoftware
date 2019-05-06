angular.module("app").controller("ColaboradorController", function($rootScope, $scope, $http, $location, $routeParams) {
	if(!sessionStorage.getItem('temAcesso')){
		$rootScope.navegacao.temAcesso = false;
		$location.path('/');
	}
	
	let idEvento = $routeParams.idEvento;
	
	$rootScope.activetab = $location.path();
	
	$scope.form = {};
	
	function handleFileSelect(evt) {
		let f = evt.target.files[0];
		let reader = new FileReader();
		
		reader.onload = (function(theFile) {
			return function(e) {
				let binaryData = e.target.result;
				let base64String = window.btoa(binaryData);
				
				$scope.form.imagem = base64String;
				console.log($scope.form);
			};
		})(f);
		
		reader.readAsBinaryString(f);
	}
	document.getElementById("imagem-colaborador").addEventListener("change", handleFileSelect, false);
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	$http.get('http://localhost:8080/colaborador/listar')
	.then((resposta)=>{
		$scope.colaboradores = resposta.data;
	});
	
	$scope.salvar = (form)=>{
		if($scope.operacao.alterar){
			$http.put('http://localhost:8080/colaborador/alterar', form)
			.then((resposta)=>{
				$scope.colaboradores[form] = resposta.data;
				console.log(resposta.data);
			});
		}else{
			$http.post(`http://localhost:8080/colaborador/inserir/${idEvento}`, form)
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
		$http.delete(`http://localhost:8080/colaborador/deletar/${colaborador.idColaborador}`)
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