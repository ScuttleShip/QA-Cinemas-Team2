"use strict";

(function (){

    angular.module("qaCinemas2").service("filmsDal", ["dal", FilmsDal]);

    function FilmsDal (dal) {

        this.getFilms = function () {
            return dal.http.GET("rest/movie/json");
        };

        this.getFilmById = function (filmId) {
            return dal.http.GET("rest/movie/json/" + filmId)
        }

        this.getFilmsByVenue = function(venueId){
            return dal.http.GET("rest/showing/json/venue/" + venueId);
        };
        
       this.getFilmsByVenueAndDate = function (chosenVenueId, dateSelected) {
            return dal.http.GET("rest/showing/json/venue/" + chosenVenueId + "/" + dateSelected);
        };

        this.getFilmsImage = function (paramObj) {
            return dal.http.GET("http://www.omdbapi.com/?t=" + paramObj);
        };
        
        this.getFilmByTitle = function (filmTitle) {
            return dal.http.GET("rest/movie/json/title/" + filmTitle);
        }
    }
}());