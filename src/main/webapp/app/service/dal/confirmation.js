/**
 * Created by Amit on 01/03/2017.
 *//**
 */

"use strict";

(function () {

    angular.module("qaCinemas2").service("confirmationDal", ["dal", confirmationDal]);

    function confirmationDal (dal) {

        this.getBooking = function (booking_ID) {
            return dal.http.GET("rest/booking/json/" + booking_ID);
        };

        this.getShowing = function (booking_ID) {
            return dal.http.GET("rest/showing/json/" + booking_ID);
        }
    }
}());