(function(){
    var rdapp = angular.module('rdapp', ['ngRoute']);

    rdapp.config(function($routeProvider) {
        $routeProvider
        .when("/search", {
          templateUrl: "search.html"
        })
        .when("/create", {
          templateUrl: "create.html"
        })
        .when("/stack", {
          templateUrl: "stack.html"
        })
        .when("/resume", {
          templateUrl: "resume.html"
        })
        .otherwise({
            templateUrl: "main.html"
        });
      });
})()