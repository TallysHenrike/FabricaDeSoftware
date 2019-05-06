angular.module('app').config(function($routeProvider){
	$routeProvider
	.when('/', {
		templateUrl: 'templates/acesso.html',
		controller: 'NavegacaoController'
	})
	.when('/categoria', {
		templateUrl: 'templates/categoria.html',
		controller: 'CategoriaController'
	})
	.when('/evento', {
		templateUrl: 'templates/evento.html',
		controller: 'EventoController'
	})
    .when('/ver-evento/:idEvento', {
		templateUrl: 'templates/ver-evento.html'
	})
	.when('/presenca', {
		templateUrl: 'templates/presenca.html',
		controller: 'PresencaController'
	})/*
	.when('/', {
		templateUrl: 'templates/',
		controller: 'Controller'
	})*/.otherwise({ redirectTo: '/' });
});