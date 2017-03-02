/**
 * Created by Amit on 01/03/2017.
 *//**
 */

"use strict";

(function () {

    angular.module("qaCinemas2").service("confirmationDal", ["dal", confirmationDal]);

    function confirmationDal (dal) {

        this.getConfirmation = function (cid) {
            return dal.http.GET("rest/showing/json" + cid);
        };
    }
}());