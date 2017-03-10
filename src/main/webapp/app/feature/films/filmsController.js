(function() {

    var filmsController = function($scope, $state, filmsService, venueService) {

        var vm = this;
        vm.filmsByVenueAndDate = [];

        function init() {
            vm.requestedNumberOfSeats = 0;
            vm.numberOfSeats = 0;

            var chosenVenueID = sessionStorage.getItem("chosenVenue");
            var chosenDate = sessionStorage.getItem("chosenDate");
            var venuePlace = document.getElementById("venuePlace");

            venueService.getVenueByID(chosenVenueID).then(function (results) {
                venuePlace.innerHTML = "Films on at QA Cinemas: " + results.name;
            }, function (error) {
                venuePlace.innerHTML = "Oops something went wrong!";
                vm.error = true;
                vm.errorMessage = error;
            });

            filmsService.getFilmsByVenueAndDate(chosenVenueID, chosenDate).then(function (results) {
                vm.filmsByVenueAndDate = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });

            $(function() {
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

            });
        }

        function submitSeatChooser() {
            vm.numberOfSeats = vm.requestedNumberOfSeats;
            console.log(vm.numberOfSeats + "number of seats in the thingssss");
            console.log(vm.newNumberOfSeats + "hopefully what is in the input");
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
            console.log(showing);
            sessionStorage.setItem('chosenShowingID', showing.showing_ID);
            var chosenShowingID = sessionStorage.getItem('chosenShowingID');
            console.log(chosenShowingID);
            var venuePlace = document.getElementById("seatsRemaining");
            venuePlace.innerHTML = "Seats Remaining: " + showing.seatsRemaining;

            $("#seatChooser").dialog("open");

        }

        vm.convertKeyToJSON = function (objectToConvert) {

            vm.currentMovie = JSON.parse(objectToConvert);
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