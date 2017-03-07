"use strict";

(function (){

    var homeDal = function (dal) {
        this.getAllMovies = function () {
            return dal.http.GET("rest/movie/json");
        };
    };

    angular.module("qaCinemas2").service("homeDal", ["dal", homeDal]);
}());