'use strict';

angular.module('myApp.view1', ['ngRoute', 'ngFileUpload'])

.config(['$routeProvider', function($routeProvider) {
  $routeProvider.when('/view1', {
    templateUrl: 'view1/view1.html',
    controller: 'View1Ctrl'
  });
}])

.controller('View1Ctrl', ['$scope', 'Upload', '$timeout', '$http', function ($scope, Upload, $timeout, $http) {
    $scope.uploadPic = function(file) {
    file.upload = Upload.upload({
      url: 'http://localhost:8080/pfcounter-rest/rest/fileupload',
      data: {file: file},
    });

    file.upload.then(function (response) {
      $timeout(function () {
    	  $scope.funcoes = response.data;
    	  $scope.getTotal();
      });
    });
    }
    
    $scope.total = 0;
    $scope.tipos = [{nome:'CE'}, {nome:'EE'},{nome:'SE'},{nome:'CRUD'} ];
    
    $scope.getClasse = function(funcao){
    	var conf = funcao.confianca * 100;
    	if(conf <= 20){
    		return "descarte";
    	} else if (conf > 20 && conf <= 45){
    		return "baixa";
    	} else if (conf > 45 && conf <= 85){
    		return "media";
    	} else {
    		return "alta";
    	}
    }
    
    $scope.getEstilo = function(funcao){
    	var conf = funcao.confianca * 100;
    	if(conf <= 20){
    		return "fa-trash";
    	} else if (conf > 20 && conf <= 45){
    		return "fa-thumbs-down";
    	} else if (conf > 45 && conf <= 85){
    		return "fa-exclamation";
    	} else {
    		return "fa-check";
    	}
    }
    
    $scope.getPercentualConfianca = function(funcao){
    	return  Math.trunc(funcao.confianca * 100) + "%";
    }
    
    $scope.getTotal = function(){
    	var total = 0;
    	var funcs = $scope.funcoes;
    	if (funcs == undefined){
    		return 0;
    	}
    	var i;
    	for (i = 0; i < funcs.length; i++) { 
    		total = total + parseInt(funcs[i].pontuacao, 10);
    	}
    	$scope.total = total;	
    }    
    
    $scope.atualizaValor = function(funcao){
    	if(funcao.tipo == 'SE'){
    		funcao.pontuacao = 5;
    	} else if (funcao.tipo == 'CRUD'){
    		funcao.pontuacao = 20;
    	} else if (funcao.tipo == 'DESCARTE'){
    		funcao.pontuacao = 0;
    	} else {
    		funcao.pontuacao = 4;
    	}
    	$scope.getTotal();
    }
    
    $scope.reclassify = function() {
    	var reclassify = $http.post('http://localhost:8080/pfcounter-rest/rest/reclassify', $scope.funcoes)
    	reclassify.then(function(result) {
    		$scope.funcoes = result.data;
    	});
        }
    
}]);
