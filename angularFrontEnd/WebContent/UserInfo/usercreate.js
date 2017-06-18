var regapp=angular.module('regmodule',[]);

regapp.controller('RegisterController',function(RegisterService,$location,$route,$cookies){
	
	this.message='this is reg controller';
	
	var regCtrl=this;
	regCtrl.regfail=$cookies.get("regfail");
	regCtrl.user={};
	this.regUser=function()
	{
		
		console.log(regCtrl.user);
		RegisterService.registerUser(regCtrl.user).then
		(
			function(response)
			{
				console.log(response);
				if(response.status=='201')
					{
					   $location.path("/");
					   
					}
				else
					{
					 $cookies.put("regfail",true);
					 $route.reload();
					}
			},
			function(error)
			{
				console.log(error);
				$cookies.put("regfail",true);
				 $route.reload();
			}
		)
		
	}
});


regapp.service('RegisterService',function($http,REST_URI,$q)
		{
	
	this.registerUser=function(user)
	{
		console.log(user);
		var deffered=$q.defer();
		
		$http.post(REST_URI+'useradd/',user).then(
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

