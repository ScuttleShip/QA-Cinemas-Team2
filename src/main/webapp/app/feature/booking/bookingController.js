/**
 * Created by Administrator on 27/02/2017.
 */
(function() {

    var bookingController = function($scope, bookingService) {

        var vm = this;

        vm.currentBooking = {};
        vm.newNumberOfSeats = 0;

        function init() {

            //setting test data
            sessionStorage.setItem("chosenVenue", 1);
            sessionStorage.setItem("chosenDate", "2017-09-23");
            sessionStorage.setItem("chosenShowing", 34);
            sessionStorage.setItem("chosenNumberOfSeats", 2);

            //retrieve data from session storage
            vm.currentBooking.chosenVenue = sessionStorage.getItem("chosenVenue");
            vm.currentBooking.chosenDate = sessionStorage.getItem("chosenDate");
            vm.currentBooking.chosenShowing = sessionStorage.getItem("chosenShowing");
            vm.currentBooking.chosenNumberOfSeats = parseInt(sessionStorage.getItem("chosenNumberOfSeats"));
            vm.newNumberOfSeats = 15;

            console.log(vm.newNumberOfSeats);

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
                                vm.saveChanges();
                            }
                        }
                    ]
                });

                $( "#opener" ).on( "click", function() {
                    $( "#dialog" ).dialog( "open" );
                });
            } );

        }

        init();

        function saveChanges2() {
            vm.saveChanges();
        }

        vm.saveChanges = function() {
            console.log(vm.newNumberOfSeats);
        }

        vm.saveBooking = function() {

            var booking = {};
            booking.numberOfSeats = sessionStorage.getItem("chosenNumberOfSeats");
            booking.customerEmail = sessionStorage.getItem("customerEmail");

            console.log(booking);
            bookingService.saveBooking(vm.currentBooking);

        };

    };

    angular.module("qaCinemas2").controller("bookingController", ['$scope', 'bookingService', bookingController]);

    angular.module("qaCinemas2").filter('num', (function() {
        return function(input) {
            return parseInt(input, 10);
        }
    }));

}());