/**
 * Created by Administrator on 27/02/2017.
 */
(function() {

    var bookingController = function(bookingService) {

        var vm = this;

        function init() {

            sessionStorage.setItem("chosenVenue", "Venue1");
            sessionStorage.setItem("chosenDate", "2017-09-21");
            sessionStorage.setItem("chosenShowing", "1");
            sessionStorage.setItem("chosenNumberOfSeats", "3");

            var chosenVenue = sessionStorage.getItem("chosenVenue");
            var chosenDate = sessionStorage.getItem("chosenDate");
            var chosenShowing = sessionStorage.getItem("chosenShowing");
            var chosenNumberOfSeats = sessionStorage.getItem("chosenNumberOfSeats");

            var venuePlace = document.getElementById("chosenVenue");
            var datePlace = document.getElementById("chosenDate");
            var showingPlace = document.getElementById("chosenShowing");
            var seatsPlace = document.getElementById("chosenNumberOfSeats");

            venuePlace.innerHTML = chosenVenue;
            datePlace.innerHTML = chosenDate;
            showingPlace.innerHTML = chosenShowing;
            seatsPlace.innerHTML = chosenNumberOfSeats;

        }

        init();

        vm.saveBooking = function() {

            var booking = {};
            booking.numberOfSeats = sessionStorage.getItem("chosenNumberOfSeats");
            booking.customerEmail =

            bookingService.saveBooking();

        }

    };

    angular.module("qaCinemas2").controller("bookingController", ['bookingService', bookingController]);

}());