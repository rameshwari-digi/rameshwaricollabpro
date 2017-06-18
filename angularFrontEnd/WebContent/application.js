/**
 * 
 */


var app=angular.module('MyApplication',['ngRoute','regmodule','loginapp','ngCookies']);

app.constant('REST_URI','http://localhost:8090/collbarest/');

app.controller('HomeController',function($scope,$rootScope,$cookies){
	/*$rootScope.Userrole="home";*/
    this.message="this is home Controller";
})


app.config(function($routeProvider)
{
	
	$routeProvider
	.when("/home",{
		templateUrl:'index.html',
		controller :'HomeController',
		controllerAs:'home'
	})
	
	.when("/signup",
			
	{
		templateUrl :'./UserInfo/SignUp.html',
		controller : 'RegisterController',
		controllerAs:'regCtrl'
		
			
	})
		
	}		

)


