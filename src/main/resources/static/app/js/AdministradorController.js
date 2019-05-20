angular.module("app").controller("AdministradorController", function($rootScope, $scope, $http, $location, $timeout) {
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
				
				$scope.form.foto = base64String;
				console.log($scope.form);
			};
		})(f);
		
		reader.readAsBinaryString(f);
	}
	document.getElementById("foto").addEventListener("change", handleFileSelect, false);
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	$http.get('http://localhost:8080/restrito/administrador/listar')
	.then((resposta)=>{
		$scope.administradores = resposta.data;
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
			$http.put(`http://localhost:8080/restrito/administrador/alterar`, form)
			.then((resposta)=>{
				$scope.administradores[form] = resposta.data;
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
			$http.post(`http://localhost:8080/restrito/administrador/inserir`, form)
			.then((resposta)=>{
				$scope.administradores.push(resposta.data);
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
	
	$scope.consultar = (administrador)=>{
		$scope.form = administrador;
		$scope.operacao = {
			alterar: true,
			btn: 'Editar'
		}
	}
	
	$scope.excluir = (administrador)=>{
		$http.delete(`http://localhost:8080/restrito/administrador/deletar/${administrador.idAdministrador}`)
		.then((resposta)=>{
			$scope.administradores.splice($scope.administradores.indexOf(administrador), 1);
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