"use strict";

(function (){

    var venueDal = function (dal) {
        this.getAllVenues = function () {
            return dal.http.GET("rest/venue/json");
        };

        this.getVenueByID = function (venue_ID) {
            return dal.http.GET("rest/venue/json/" + venue_ID);
        }
    };

    angular.module("qaCinemas2").service("venueDal", ["dal", venueDal]);
}());