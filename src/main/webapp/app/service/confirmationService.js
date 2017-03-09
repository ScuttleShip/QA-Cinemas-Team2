/**
 * Created by Administrator on 02/03/2017.
 */
(function() {

    var confirmationService =  function(confirmationDal) {

        this.getBooking = function(bookingID) {
            return confirmationDal.getBooking(bookingID);

        };

        this.getShowing = function(showingID) {
            return confirmationDal.getShowing(showingID);

        };
    };

       angular.module("qaCinemas2").service("confirmationService", ["confirmationDal", confirmationService]);
}());