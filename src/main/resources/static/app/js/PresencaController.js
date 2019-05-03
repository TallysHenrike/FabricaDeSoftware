angular.module("app").controller("PresencaController", function($rootScope, $scope, $http, $location) {
	$rootScope.activetab = $location.path();
});