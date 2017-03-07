(function() {
    var filmsController = function(filmsService, venueService) {

        var vm = this;
        vm.filmsByVenueAndDate = [];

       function init() {

           var chosenVenueID = sessionStorage.getItem("chosenVenue");
           var chosenDate = sessionStorage.getItem("chosenDate");
           var venuePlace = document.getElementById("venuePlace");

           venueService.getVenueByID(chosenVenueID).then(function (results) {
               venuePlace.innerHTML = "Films on at QA Cinemas: " + results.name;
           }, function (error) {
               venuePlace.innerHTML = "Oops something went wrong!";
           });

           filmsService.getFilmsByVenueAndDate(chosenVenueID, chosenDate).then(function (results) {
               console.log("The films displayed" + results);
              vm.filmsByVenueAndDate = results;
              console.log("This is the value of the venue and date ");
              console.log(vm.filmsByVenueAndDate);

           }, function (error) {
               console.log("error occured" + error);
               vm.error = true;
               vm.errorMessage = error;
           });
       }

       vm.convertKeyToJSON = function (objectToConvert) {
           return JSON.parse(objectToConvert);
       };

       vm.trimTime = function (timeToTrim) {
           var firstPart = timeToTrim.toString().substr(0, 5);
           var secondPart = timeToTrim.toString().substr(9, 10);
           return firstPart + " " + secondPart;
       }

        init();
    }
    angular.module("qaCinemas2").controller('filmsController', ['filmsService', 'venueService', filmsController]);
}());