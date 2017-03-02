/**
 * Created by Administrator on 27/02/2017.
 */
(function() {

    var homeController = function(venueService) {

        var vm = this;

        vm.venues = [];

        vm.saveVenueDate = function() {

            var venueChooser = document.getElementById("myVenue");

            var dateChooser = document.getElementById("selectedDate");

            sessionStorage.setItem("chosenVenue", venueChooser.value);
            sessionStorage.setItem("chosenDate", dateChooser.value);

            console.log(sessionStorage.getItem("chosenVenue"));
            console.log(sessionStorage.getItem("chosenDate"));



        }

        function init() {
            venueService.getAllVenues().then(function (results) {
                console.log(results);
                vm.venues = results;
            }, function (error) {
                console.log("This is not working" + error);
                vm.error=true;
                vm.errorMessage = error;

            });
        }

        init();

    }

    angular.module("qaCinemas2").controller("homeController", ['venueService', homeController]);

}());