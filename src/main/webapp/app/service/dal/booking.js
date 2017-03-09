/**
 * Created by Administrator on 02/03/2017.
 */
(function() {

    function bookingDal (dal) {

        this.saveBooking = function(bookingToSave) {
            return dal.http.POST("rest/booking/json", bookingToSave);
        }

    }

    angular.module("qaCinemas2").service("bookingDal", ["dal", bookingDal]);

}());