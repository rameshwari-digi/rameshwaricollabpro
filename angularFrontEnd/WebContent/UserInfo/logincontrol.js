var loginapp=angular.module('loginapp',[]);
loginapp.controller('LoginController',function(LoginService,$location,$rootScope,$cookies,$route){
	
	this.message='this is login controller';
	var logCtrl=this;
	logCtrl.user={};
	$rootScope.authenticated=$cookies.get('authenticated');
	
	this.logintest=function()
	{
		alert('heolooo')
		console.log(logCtrl.user);
		LoginService.login(logCtrl.user).then
		(
			function(response)
			{
				console.log(response);
				if(response.status=='200')
					{
					   $cookies.put('authenticated',true);
					   $rootScope.authenticated=$cookies.get('authenticated');
					}
			},
			function(error)
			{
				console.log(error);
			}
		)
		
	}
});

loginapp.service('LoginService',function($http,REST_URI,$q){
	
	this.login=function(user)
	{
		console.log(user);
		var deffered=$q.defer();
		
		$http.post(REST_URI+'login/',user).then(
				function(response)
				{
					console.log(response);
					deffered.resolve(response);
				},function(error)
				{
					console.log(error);
					deffered.reject(error);
				}
		)
		
		
		
	return deffered.promise;
	}
	
})

