(function() {
    var filmController = function(filmsService) {

        var vm = this;


        vm.showModal = function () {
            console.log("clicked on modal");
        }

        function init() {
            filmsService.getFilms().then(function (results) {
                console.log("The result of films is " + results);
                vm.films  = results;
            }, function (error) {

            });
        }

        init();

    }
    angular.module("qaCinemas2").controller('filmController', ['filmsService', filmController]);
}());