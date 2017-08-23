'use strict';

app
    .controller('DetailCtrl',	function ($scope, $routeParams, $location, bookService) {

        $scope.load = function() {
        	bookService.get($routeParams.id,function (result) {
        		$scope.data = result.data;
            });
        }
       
        $scope.goToList = function() {
        	$location.path('/');
        }
        
        $scope.load();

        $scope.data = {};
              
    });
