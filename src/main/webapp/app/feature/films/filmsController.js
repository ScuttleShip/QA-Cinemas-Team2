(function() {
    var filmsController = function(filmsService) {
        // We can attach model to $scope.

        var vm = this;



        vm.filmsByVenueAndDate = [];

        vm.venues = [
            { 'id': 1, 'name': 'Manchester' },
            { 'id': 2, 'name': 'London' }
        ];


       function init() {

           var chosenVenueID = sessionStorage.getItem("chosenVenue");
           var chosenDate = sessionStorage.getItem("chosenDate");

           filmsService.getFilmsByVenueAndDate(chosenVenueID, chosenDate).then(function (results) {
               console.log("The films displayed" + results);

                /*console.log("All " + results);
                console.log("Key " + results.key);
                console.log("Key at 0" + results[0]);
               console.log("Key at 1" + results[1]);*/


               vm.filmsByVenueAndDate = results;
              console.log("This is the value of the venue and date ");
              console.log(vm.filmsByVenueAndDate);

           }, function (error) {
               console.log("error occured" + error);
               vm.error = true;
               vm.errorMessage = error;
           });
       }

       /*vm.getVenue = function(venueSelected){
            vm.getFilmsByVenue = filmsService.getFilmsByVenue(venueSelected.id).then(onVenueComplete, onError);
        }

        var onVenueComplete = function(results){
            vm.filmsByVenueAndDate = results;
            console.log(results);
        }

        var onError = function(error){
            console.log("skdsjfkdsfds");
        }*/

        init();
    }

    angular.module("qaCinemas2").controller('filmsController', ['filmsService', filmsController]);
}());