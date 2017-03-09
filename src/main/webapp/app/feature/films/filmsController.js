(function() {

    var filmsController = function($scope, $state, filmsService, venueService) {

        var vm = this;
        vm.filmsByVenueAndDate = [];

        function init() {
            vm.numberOfSeats = 3;
            vm.newNumberOfSeats = 3;

            var chosenVenueID = sessionStorage.getItem("chosenVenue");
            var chosenDate = sessionStorage.getItem("chosenDate");
            var venuePlace = document.getElementById("venuePlace");


            venueService.getVenueByID(chosenVenueID).then(function (results) {
                venuePlace.innerHTML = "Films on at QA Cinemas: " + results.name;
            }, function (error) {
                venuePlace.innerHTML = "Oops something went wrong!";
            });

            filmsService.getFilmsByVenueAndDate(chosenVenueID, chosenDate).then(function (results) {
                vm.filmsByVenueAndDate = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });

            $("#seatChooser").dialog({
                autoOpen: false,
                modal: true,
                buttons: [
                    {
                        text: "Cancel",
                        icons: {
                            primary: ""
                        },
                        click: function() {
                            $(this).dialog("close");
                        }
                    },
                    {
                        text: "Save",
                        icons: {
                            primary: ""
                        },
                        click: function() {
                            $(this).dialog("close");
                            submitSeatChooser();
                            saveSeatNumberAndGo();
                        }
                    }
                ]
            });

        }

        function submitSeatChooser() {
            vm.numberOfSeats = vm.newNumberOfSeats;
            $scope.$apply();
            console.log(vm.numberOfSeats + "number of seats in the thingssss");
            console.log(vm.newNumberOfSeats + "hopefully what is in the input");
        }

        function saveSeatNumberAndGo() {
            sessionStorage.setItem("chosenNumberOfSeats", vm.numberOfSeats);
            console.log(vm.numberOfSeats + "Farhaads Page");
            console.log(sessionStorage.getItem("chosenNumberOfSeats") + "Farhaads Page");
            $state.go("booking");
        }

        vm.showSeatChooser = function (showing) {

            var chosenShowingID = sessionStorage.setItem('chosenShowingID', showing.showing_ID);
            var venuePlace = document.getElementById("seatsRemaining");
            venuePlace.innerHTML = "Seats Remaining: " + showing.seatsRemaining;

            $("#seatChooser").dialog("open");

        }

        vm.convertKeyToJSON = function (objectToConvert) {

            console.log(JSON.parse(objectToConvert));
            vm.currentMovie = JSON.parse(objectToConvert);
            console.log(vm.currentMovie.filmImg);
            return vm.currentMovie;

        };

        vm.trimTime = function (timeToTrim) {

            var firstPart = timeToTrim.toString().substr(0, 5);
            var secondPart = timeToTrim.toString().substr(9, 10);
            return firstPart + " " + secondPart;

        }

        init();

    }

    angular.module("qaCinemas2").controller('filmsController', ['$scope', '$state', 'filmsService', 'venueService', filmsController]);

}());