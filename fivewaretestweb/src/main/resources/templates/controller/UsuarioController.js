var app = angular.module('cadastro',['ui.bootstrap']);

app.filter('startFrom', function () {
	return function (input, start) {
		if (input) {
			start = +start;
			return input.slice(start);
		}
		return [];
	};
});

app.controller('crudCtrl', ['$scope','usuarioApi','filterFilter', function(scope,usuarioApi,filterFilter){
	scope.usuario={"id":-1,"userName":"","email":"","estadoCivil":"casado","sexo":"masculino"};
	scope.usuarios=[];
	scope.search="";

	scope.saveUsuario = function(){

        usuarioApi.updateUsuario(scope.usuario).success(
           function(data,status){
              loadUsers();
        });
    };

   scope.clear = function(user){
         scope.usuario={"id":-1,"userName":"","email":"","estadoCivil":"casado","sexo":"masculino"};
    };

    scope.updateUser = function(user){
         scope.usuario=user;
    };

    scope.removeUsuario = function(user){
        usuarioApi.removeUsuario(user).success(
           function(data,status){
              loadUsers();
        });
    };


    var loadUsers = function(){
        usuarioApi.findAll().success(
          function(data,status){
              builderGrid(data);
        });
    };


    var builderGrid =function(dados){
        scope.usuarios=dados;
        scope.currentPage = 1;
        scope.totalItems = dados.length;
        scope.entryLimit = 5; // items per page
        scope.noOfPages = Math.ceil(scope.totalItems / scope.entryLimit);

        // $watch search to update pagination
        scope.$watch('search', function (newVal, oldVal) {
            scope.filtered = filterFilter(dados, newVal);
            scope.totalItems = scope.filtered.length;
            scope.noOfPages = Math.ceil(scope.totalItems / scope.entryLimit);
            scope.currentPage = 1;
        }, true);

    };

    loadUsers();

}]);

