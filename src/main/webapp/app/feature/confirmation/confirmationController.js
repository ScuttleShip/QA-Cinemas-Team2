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
                vm.booking = results;

            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });

            confirmationService.getShowing(bookingID).then(function (results) {
                vm.showing = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });

            // console.log(showingID);
        }

        init();
    };
    angular.module('qaCinemas2').controller('confirmationController', ['confirmationService', confirmationController]);
}());