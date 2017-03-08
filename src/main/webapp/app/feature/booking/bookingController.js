/**
 * Created by Administrator on 27/02/2017.
 */
(function() {

    var bookingController = function($scope, $state, bookingService, showingService) {

        var vm = this;

        vm.currentBooking = {};
        vm.newNumberOfSeats = 0;

        function init() {

            //setting test data
            sessionStorage.setItem("chosenVenue", 1);
            sessionStorage.setItem("chosenDate", "2017-09-23");
            sessionStorage.setItem("chosenShowingID", 1);
            sessionStorage.setItem("chosenNumberOfSeats", 2);

            //retrieve data from session storage
            vm.currentBooking.chosenVenue = sessionStorage.getItem("chosenVenue");
            vm.currentBooking.chosenDate = sessionStorage.getItem("chosenDate");
            vm.currentBooking.chosenShowingID = parseInt(sessionStorage.getItem("chosenShowingID"));
            vm.currentBooking.chosenNumberOfSeats = parseInt(sessionStorage.getItem("chosenNumberOfSeats"));
            vm.newNumberOfSeats = vm.currentBooking.chosenNumberOfSeats;
            updateOrderTotal();

            showingService.getMovieByShowingID(vm.currentBooking.chosenShowingID).then(function (results) {

                vm.movieForChosenShowing = results;

            }, function (error) {

                vm.error = true;
                vm.errorMessage = error;

            });

            $( function() {
                $( "#seatChooserDialog" ).dialog({
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

                $("#errorDialog").dialog({
                    autoOpen: false,
                    modal: true
                });

                $("#bookingErrorDialog").dialog({
                    autoOpen: false,
                    modal: true
                });

                $("#opener").click(function() {
                    $("#dialog").dialog("open");
                });
            } );

        }

        init();

        function updateOrderTotal() {
            vm.currentBooking.orderTotal = vm.currentBooking.chosenNumberOfSeats * 6.99;
        }

        function saveChanges() {
            vm.currentBooking.chosenNumberOfSeats = vm.newNumberOfSeats;
            updateOrderTotal();
            $scope.$apply();
        }

        vm.openSeatChooser = function() {

        };

        vm.openEmailError = function() {

        };

        vm.openBookingError = function() {

        };

        vm.openSeatChooserAlt = function () {
            $("#seatChooserDialog").dialog("open");
        };

        vm.saveBooking = function(bookingDetails) {

            if (bookingDetails.bookingEmail === bookingDetails.confirmBookingEmail) {
                console.log("They're the same!");

                var booking = {};
                booking.numberOfSeats = vm.currentBooking.chosenNumberOfSeats;
                booking.customerEmail = bookingDetails.bookingEmail;
                booking.orderTotal = vm.currentBooking.chosenNumberOfSeats * 6.99;
                booking.showing_ID = vm.currentBooking.chosenShowingID;

                bookingService.saveBooking(booking).then(function (results) {

                    vm.bookingMessage = results;
                    $state.go('confirmation');

                }, function (error) {

                    vm.error = true;
                    vm.errorMessage = error;
                    $("#bookingErrorDialog").dialog("open");

                });


            } else {
                $("#errorDialog").dialog("open");
            }

        };

    };

    angular.module("qaCinemas2").controller("bookingController", ['$scope', '$state', 'bookingService', 'showingService', bookingController]);

}());