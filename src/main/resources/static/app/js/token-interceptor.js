appEventos.factory('tokenInterceptor', function($location, $rootScope){
	return {
		'request': function(config){
			
			$rootScope.navegacao.temAcesso = true;
			config.headers['Authorization'] = `Bearer ${localStorage.getItem('token')}`
			
			return config;
		},
		'responseError': function(rejection){
			
			if(rejection.status==401){
				$rootScope.navegacao.temAcesso = false;
				$location.path('/acesso');
			}
			
			return rejection;
			//return $q.reject(rejection);
		}
	}
})