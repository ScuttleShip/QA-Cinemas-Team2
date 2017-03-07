(function(){

    var homeService = function(homeDal){
        this.getAllMovies = function()
        {
            return homeDal.getAllMovies();
        };
    };
    angular.module('qaCinemas2').service('homeService', ['homeDal', homeService]);
}());