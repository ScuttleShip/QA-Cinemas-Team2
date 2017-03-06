/**
 * Created by Administrator on 27/02/2017.
 */
(function() {

    var bookingController = function(bookingService, $mdDialog) {

        var vm = this;

        vm.currentBooking = {};

        function init() {

            //setting test data
            sessionStorage.setItem("chosenVenue", 1);
            sessionStorage.setItem("chosenDate", "2017-09-23");
            sessionStorage.setItem("chosenShowing", 34);
            sessionStorage.setItem("chosenNumberOfSeats", 2);

            //retrieve data from session storage
            var chosenVenue = sessionStorage.getItem("chosenVenue");
            var chosenDate = sessionStorage.getItem("chosenDate");
            var chosenShowing = sessionStorage.getItem("chosenShowing");
            var chosenNumberOfSeats = sessionStorage.getItem("chosenNumberOfSeats");

            //assign paragraph elements for each location data belongs
            var venuePlace = document.getElementById("chosenVenue");
            var datePlace = document.getElementById("chosenDate");
            var showingPlace = document.getElementById("chosenShowing");
            var seatsPlace = document.getElementById("chosenNumberOfSeats");

            //assign data values to location
            venuePlace.innerHTML = chosenVenue;
            datePlace.innerHTML = chosenDate;
            showingPlace.innerHTML = chosenShowing;
            seatsPlace.innerHTML = chosenNumberOfSeats;

        }

        init();

        vm.saveBooking = function() {

            var booking = {};
            booking.numberOfSeats = sessionStorage.getItem("chosenNumberOfSeats");
            booking.customerEmail = sessionStorage.getItem("customerEmail");

            console.log(booking);
            bookingService.saveBooking(vm.currentBooking);

        };

        vm.editBooking = function(ev) {

            var parentThing = angular.element(document.body);
            $mdDialog.show({
                parent: parentThing,
                targetEvent: $event,
                template:
                '<md-dialog aria-label="Edit Number Of Seats">'+
                    '<md-dialog-content>'+
                    '<'+

            })

        };

        function DialogController($mdDialog) {

            var vm = this;

            vm.closeDialog = function () {
                $mdDialog.hide();
            }
        }

        vm.closeEdit = function() {

        };

        function update() {

        }

    };

    angular.module("qaCinemas2").controller("bookingController", ['bookingService', bookingController]);

}());