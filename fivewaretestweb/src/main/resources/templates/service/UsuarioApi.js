angular.module('cadastro').factory('usuarioApi',function($http){

    var _updateUsuario = function(usuario){
        return $http.post('api/v1/cadastrar',usuario);
    };

    var _findAll = function(){
        return $http.get('api/v1/usuarios');
    };
    var _removeUsuario = function(usuario){
        return $http.post('api/v1/remover', usuario);
    };

    return {
        updateUsuario: _updateUsuario,
        findAll: _findAll,
        removeUsuario:_removeUsuario
    };

});