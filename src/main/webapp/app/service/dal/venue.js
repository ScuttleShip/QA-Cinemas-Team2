"use strict";

(function (){

    var venueDal = function (dal) {
        this.getAllVenues = function () {
            return dal.http.GET("rest/venue/json");
        };
    };

    angular.module("qaCinemas2").service("venueDal", ["dal", venueDal]);
}());