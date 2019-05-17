angular.module("app").controller("PatrocinadorController", function($rootScope, $scope, $http, $location, $routeParams) {
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
	document.getElementById("imagem-patrocinador").addEventListener("change", handleFileSelect, false);
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	$http.get(`http://localhost:8080/patrocinador/listar/${idEvento}`)
	.then((resposta)=>{
		$scope.patrocinadores = resposta.data;
	}, (resposta)=>{
		console.log(resposta.data);
	});
	
	$scope.salvar = (form)=>{
		if($scope.operacao.alterar){
			$http.put('http://localhost:8080/patrocinador/alterar', form)
			.then((resposta)=>{
				$scope.patrocinadores[form] = resposta.data;
				console.log(resposta.data);
			}, (resposta)=>{
				console.log(resposta.data);
			});
		}else{
			$http.post(`http://localhost:8080/patrocinador/inserir/${idEvento}`, form)
			.then((resposta)=>{
				$scope.patrocinadores.push(resposta.data);
				console.log(resposta.data);
			}, (resposta)=>{
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
		$http.delete(`http://localhost:8080/patrocinador/deletar/${patrocinador.idPatrocinador}`)
		.then((resposta)=>{
			$scope.patrocinadores.splice($scope.patrocinadores.indexOf(patrocinador), 1);
			console.log(resposta.data);
		}, (resposta)=>{
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