var app = angular.module('startrek', [ 'ngResource', 'myApp' ]);

// Create a controller with name placesListController to bind to the grid section.
app.controller('startrekController', function($scope, $rootScope,$http, $sce) {
	
	$scope.saveData = function() {
		//alert('a');
		
		//get type places
	    $http({ 
	    	method: 'GET',
	    	url: 'service/star-trek/x/' + $scope.x + '/y/' + $scope.y
	    }).
	    success(function(data) {
	  	
	        //$scope.mapa = data;
	        //console.log(data);
	        
	        $scope.thisCanBeusedInsideNgBindHtml = $sce.trustAsHtml(data);
	    });
		
	}
	
	
});
