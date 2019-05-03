angular.module('app').config(function($routeProvider){
	$routeProvider
	.when('/categoria', {
		templateUrl: 'templates/categoria.html',
		controller: 'CategoriaController'
	}).when('/listar-categorias', {
		templateUrl: 'templates/listar-categorias.html',
		controller: 'CategoriaController'
	}).when('/evento', {
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
	})*/.otherwise({ redirectTo: '/presenca' });
});