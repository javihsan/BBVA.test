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
        	if (validateForm()){
	        	bookService.save($scope.form, function() {
	        		alert('Saved');
	        		$scope.load();
	            });
        	}	
        }

        function validateForm() {
            var result = true;
            
            if (!$scope.form.name || $scope.form.name.length==0) {
            	alert ('Name empty');
            	result = false;
            } else if (!$scope.form.author || $scope.form.author.length==0) {
            	alert ('Author empty');
            	result = false;
            } else if (!$scope.form.yearPub || $scope.form.yearPub.toString().length!=4 || !isNumeric($scope.form.yearPub)) {
            	alert ('Year empty or invalid');
            	result = false;
            } else if (!$scope.form.genre || $scope.form.genre.length==0) {
            	alert ('Genre not select');
            	result = false;
            }
            return result;
        };
        
        function isNumeric(n) {
          return !isNaN(parseFloat(n)) && isFinite(n);
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
