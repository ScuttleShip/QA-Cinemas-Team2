/**
 * Created by Administrator on 02/03/2017.
 */
(function() {

    var confirmationService =  function(confirmationDal) {

        this.getBooking = function() {
            return confirmationDal.getBooking();

        };

        this.getShowing = function() {
            return confirmationDal.getShowing();

        };
    };

       angular.module("qaCinemas2").service("confirmationService", ["confirmationDal", confirmationService]);
}());