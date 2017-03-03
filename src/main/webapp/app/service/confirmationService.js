/**
 * Created by Administrator on 02/03/2017.
 */
(function() {

    var confirmationService =  function(confirmationDal) {

        this.getBooking = function() {
            return confirmationDal.getBooking(1);

        };

        this.getShowing = function() {
            return confirmationDal.getShowing(1);

        };
    };

       angular.module("qaCinemas2").service("confirmationService", ["confirmationDal", confirmationService]);
}());