/**
 * Created by Amit on 01/03/2017.
 *//**
 */

"use strict";

(function () {

    angular.module("qaCinemas2").service("confirmationDal", ["dal", ConfirmationDal]);

    function ConfirmationDal (dal) {

        this.getConfirmation = function (cid) {
            return dal.http.GET("rest/showing/json" + cid);
        };
    }
}());