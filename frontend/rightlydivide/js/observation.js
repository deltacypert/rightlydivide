/**
 * Creates a new angular js module named 'movieapp' 
 * we need at least one module to store all of our business logic
 * wrapped in an IIFE- immediately invoked function expression
 */

(function(){
    var rdapp = angular.module('rdapp', ['ngRoute']);

    rdapp.config(function($routeProvider) {
        $routeProvider
        .when("/search", {
            templateUrl: "search.html",
            controller: "searchController"
        })
        .when("/create", {
            templateUrl: "create.html",
            controller: "createController"
        })
        .when("/info", {
            templateUrl: "info.html",
        })
        .when("/update/:observationId", {
            templateUrl: "update.html",
            controller: "updateController"
        })
        .otherwise({
            templateUrl : "main.html"
        });
      });
})()