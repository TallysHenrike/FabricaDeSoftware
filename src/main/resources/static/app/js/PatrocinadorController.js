angular.module("app").controller("PatrocinadorController", function($rootScope, $scope, $http, $location, $routeParams, $timeout) {
	if(localStorage.getItem('sessao')){
		let sessao = JSON.parse(localStorage.getItem('sessao'));
		if(sessao.token && sessao.expiracao >= new Date().getTime()){
			$http.defaults.headers.common['Authorization'] = `Bearer ${sessao.token}`;
			$rootScope.navegacao.temAcesso = true;
		}else{
			localStorage.clear();
			$rootScope.navegacao.temAcesso = false;
			$location.path('/acesso');
		}
	}else{
		localStorage.clear();
		$rootScope.navegacao.temAcesso = false;
		$location.path('/acesso');
	}
	
	let idEvento = $routeParams.idEvento;
	
	$rootScope.activetab = $location.path();
	
	$scope.form = {};
	$scope.alerta = {abrir: false}
	
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
	
	$http.get(`http://localhost:8080/restrito/patrocinador/listar/${idEvento}`)
	.then((resposta)=>{
		$scope.patrocinadores = resposta.data;
	}, (resposta)=>{
		console.log(resposta.data);
		$scope.alerta.mensagem = resposta.data.message;
		$scope.alerta.abrir = true;
		$timeout(function(){
			$scope.alerta.abrir = false;
		}, 2500);
	});
	
	$scope.salvar = (form)=>{
		if($scope.operacao.alterar){
			$http.put('http://localhost:8080/restrito/patrocinador/alterar', form)
			.then((resposta)=>{
				$scope.patrocinadores[form] = resposta.data;
				console.log(resposta.data);
			}, (resposta)=>{
				console.log(resposta.data);
				$scope.alerta.mensagem = resposta.data.message;
				$scope.alerta.abrir = true;
				$timeout(function(){
					$scope.alerta.abrir = false;
				}, 2500);
			});
		}else{
			$http.post(`http://localhost:8080/restrito/patrocinador/inserir/${idEvento}`, form)
			.then((resposta)=>{
				$scope.patrocinadores.push(resposta.data);
				console.log(resposta.data);
			}, (resposta)=>{
				console.log(resposta.data);
				$scope.alerta.mensagem = resposta.data.message;
				$scope.alerta.abrir = true;
				$timeout(function(){
					$scope.alerta.abrir = false;
				}, 2500);
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
		$http.delete(`http://localhost:8080/restrito/patrocinador/deletar/${patrocinador.idPatrocinador}`)
		.then((resposta)=>{
			$scope.patrocinadores.splice($scope.patrocinadores.indexOf(patrocinador), 1);
			console.log(resposta.data);
		}, (resposta)=>{
			console.log(resposta.data);
			$scope.alerta.mensagem = resposta.data.message;
			$scope.alerta.abrir = true;
			$timeout(function(){
				$scope.alerta.abrir = false;
			}, 2500);
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