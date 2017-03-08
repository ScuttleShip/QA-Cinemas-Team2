/**
 * Created by Administrator on 27/02/2017.
 */
(function() {

    var bookingController = function($scope, $state, bookingService, showingService) {

        var vm = this;

        vm.currentBooking = {};
        vm.newNumberOfSeats = 0;
        vm.booking = {};
        vm.bookingTotal = 0;

        function init() {

            //setting test data
            sessionStorage.setItem("chosenVenue", 1);
            sessionStorage.setItem("chosenDate", "2017-09-23");
            sessionStorage.setItem("chosenShowingID", 34);
            sessionStorage.setItem("chosenNumberOfSeats", 2);

            //retrieve data from session storage
            vm.currentBooking.chosenVenue = sessionStorage.getItem("chosenVenue");
            vm.currentBooking.chosenDate = sessionStorage.getItem("chosenDate");
            vm.currentBooking.chosenShowingID = parseInt(sessionStorage.getItem("chosenShowingID"));
            vm.currentBooking.chosenNumberOfSeats = parseInt(sessionStorage.getItem("chosenNumberOfSeats"));
            vm.newNumberOfSeats = vm.currentBooking.chosenNumberOfSeats;
            vm.currentBooking.bookingTotal = vm.chosenNumberOfSeats * 6.99;

            showingService.getMovieByShowingID().then(function (results) {

                vm.movieForChosenShowing = results;

            }, function (error) {

                vm.error = true;
                vm.errorMessage = error;

            });

            // //assign paragraph elements for each location data belongs
            // var venuePlace = document.getElementById("chosenVenue");
            // var datePlace = document.getElementById("chosenDate");
            // var showingPlace = document.getElementById("chosenShowing");
            // var seatsPlace = document.getElementById("chosenNumberOfSeats");
            //
            // //assign data values to location
            // venuePlace.innerHTML = chosenVenue;
            // datePlace.innerHTML = chosenDate;
            // showingPlace.innerHTML = chosenShowing;
            // seatsPlace.innerHTML = chosenNumberOfSeats;

            $( function() {
                $( "#dialog" ).dialog({
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
                                saveChanges();
                            }
                        }
                    ]
                });

                $( "#opener" ).on( "click", function() {
                    $( "#dialog" ).dialog( "open" );
                });

                $("#errorDialog").dialog({
                    autoOpen: false,
                    modal: true
                });
            } );

        }

        init();

        function saveChanges() {
            vm.currentBooking.chosenNumberOfSeats = vm.newNumberOfSeats;
            $scope.$apply();
        }

        vm.saveBooking = function(bookingDetails) {

            if (bookingDetails.bookingEmail === bookingDetails.confirmBookingEmail) {
                console.log("They're the same!");

                var booking = {};
                booking.numberOfSeats = vm.chosenNumberOfSeats;
                booking.customerEmail = bookingDetails.bookingEmail;
                booking.orderTotal = vm.chosenNumberOfSeats * 6.99;
                booking.showing_ID = vm.chosenShowingID;

                var bookingJSON = JSON.stringify(booking);
                bookingService.saveBooking(bookingJSON).then(function (results) {

                    vm.bookingMessage = results;

                }, function (error) {

                    vm.error = true;
                    vm.errorMessage = error;

                });

                $state.go('confirmation');

            } else {
                $("#errorDialog").dialog("open");
            }

        };

    };

    angular.module("qaCinemas2").controller("bookingController", ['$scope', '$state', 'bookingService', 'showingService', bookingController]);

    angular.module("qaCinemas2").filter('num', (function() {
        return function(input) {
            return parseInt(input, 10);
        }
    }));

}());