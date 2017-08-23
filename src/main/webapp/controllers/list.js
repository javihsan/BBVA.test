'use strict';

app
    .controller('ListCtrl',	function ($scope, bookService, NgTableParams) {

        $scope.load = function() {
        	bookService.list(null,function (list) {
        		$scope.list = list.data;
            });
        	 $scope.form = {};
        }

        $scope.search = function() {
        	bookService.list($scope.searchText,function (list) {
        		$scope.list = list.data;
            });
        }
        
        $scope.save = function() {
        	bookService.save($scope.form, function() {
        		alert('Saved');
        		$scope.load();
            });
        }

        $scope.remove = function(id) {
        	if (confirm('Are you sure')){
        		bookService.remove(id, function() {
        			$scope.load();
        		});
			}	
        }
        
        $scope.searchText = "";
        $scope.form = {};
        $scope.load();

        $scope.list = [];
        $scope.booksTable = new NgTableParams({}, { dataset: $scope.list });
        
        $scope.genres = ['EPICA', 'CUENTO', 'NOVELA', 'TRAGEDIA', 'COMEDIA', 'CRONICA', 'BIOGRAFIA', 'FABULA', 'ENSAYO', 'ROMANCE'];
        
    });
