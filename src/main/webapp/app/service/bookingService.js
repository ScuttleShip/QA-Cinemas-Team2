/**
 * Created by Administrator on 02/03/2017.
 */
(function() {

    var bookingService = function (bookingDal) {

        this.saveBooking = function(bookingToSave) {
            return bookingDal.saveBooking(bookingToSave);
        }

    }

    angular.module("qaCinemas2").service("bookingService", ["bookingDal", bookingService]);

}());