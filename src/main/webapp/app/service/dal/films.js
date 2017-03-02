"use strict";

(function (){

    angular.module("qaCinemas2").service("filmsDal", ["dal", FilmsDal]);

    function FilmsDal (dal) {

        this.getFilms = function () {
            return dal.http.GET("rest/movie/json");
        };

        this.getFilmsByVenue = function(venueId){
            return dal.http.GET("rest/showing/json/venue/" + venueId);
        };
        
        this.getFilmsByVenueAndDate = function (chosenVenueId, dateSelected) {
            return dal.http.GET("rest/showing/json/venue/" + venueId + "/" + dateSelected);
        }

    }
}());