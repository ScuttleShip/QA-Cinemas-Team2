(function() {
    var filmController = function(filmsService) {

        var vm = this;


        vm.showModal = function () {
        }

        function init() {
            filmsService.getFilms().then(function (results) {
                vm.films  = results;
            }, function (error) {

            });
        }

        init();

    }
    angular.module("qaCinemas2").controller('filmController', ['filmsService', filmController]);
}());