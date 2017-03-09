/**
 * Created by Amit on 27/02/2017.
 */
(function() {

    var confirmationController =  function(confirmationService)
    {
        var vm = this;



        // vm.booking = {booking_ID: "8", numberOfSeats: "3", customerEmail: "hello@gmail.com"};
        // vm.showing = {movie: "Mark's mum the Global Terror", screen: "3", date: "10-03-2017", startTime: "14:00", };

        function init() {

            var bookingID = parseInt(sessionStorage.getItem("bookingID"));

            confirmationService.getBooking(bookingID).then(function (results) {
                console.log("In confirmation controller about to return data to the client with results " + results);
                vm.booking = results;
                console.log(vm.booking);
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
                console.log(error);
            });

            var showingID = vm.booking.showing_ID;
            console.log(showingID);
/*
            confirmationService.getShowing(showingID).then(function (results) {
                console.log("In confirmation controller about to return data to the client with results " + results);
                vm.showing = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });*/
        }

        init();
    };
    angular.module('qaCinemas2').controller('confirmationController', ['confirmationService', confirmationController]);
}());