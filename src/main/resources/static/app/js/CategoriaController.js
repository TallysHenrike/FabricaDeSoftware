angular.module("app").controller("CategoriaController", function($rootScope, $scope, $http, $location) {
	$http.defaults.headers.common['Authorization'] = `Bearer ${sessionStorage.getItem('token')}`;
    
    $rootScope.activetab = $location.path();
	$scope.form = {};
	
	function handleFileSelect(evt) {
		let f = evt.target.files[0];
		let reader = new FileReader();
		
		reader.onload = (function(theFile) {
			return function(e) {
				let binaryData = e.target.result;
				let base64String = window.btoa(binaryData);
				
				$scope.form.icone = base64String;
				console.log($scope.form);
			};
		})(f);
		
		reader.readAsBinaryString(f);
	}
	document.getElementById("icone").addEventListener("change", handleFileSelect, false);
	
	$scope.operacao = {
		alterar: false,
		btn: 'Cadastrar'
	}
	
	$http.get('http://localhost:8080/restrito/categoria/listar')
	.then((resposta)=>{
		$scope.categorias = resposta.data;
	}, (resposta)=>{
		console.log(resposta.data);
	});
	
	$scope.salvar = (form)=>{
		form.token = sessionStorage.getItem("token");
		form.idAdministrador = $rootScope.navegacao.perfil.idAdministrador;
		
		if($scope.operacao.alterar){
			$http.put(`http://localhost:8080/restrito/categoria/alterar`, form)
			.then((resposta)=>{
				$scope.categorias[form] = resposta.data;
				console.log(resposta.data);
			}, (resposta)=>{
				console.log(resposta.data);
			});
		}else{
			$http.post(`http://localhost:8080/restrito/categoria/inserir`, form)
			.then((resposta)=>{
				$scope.categorias.push(resposta.data);
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
	
	$scope.consultar = (categoria)=>{
		$scope.form = categoria;
		$scope.operacao = {
			alterar: true,
			btn: 'Editar'
		}
	}
	
	$scope.excluir = (categoria)=>{
		$http.delete(`http://localhost:8080/restrito/categoria/deletar/${categoria.idCategoria}`)
		.then((resposta)=>{
			$scope.categorias.splice($scope.categorias.indexOf(categoria), 1);
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