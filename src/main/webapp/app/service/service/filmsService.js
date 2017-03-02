(function() {

    var FilmsService =  function(filmsDal) {

        this.getFilms = function() {
            return filmsDal.getFilms();
        };

        this.getFilmsByVenue = function (venueId) {
            return filmsDal.getFilmsByVenue(venueId);
        }

        this.getFilmsByVenueAndDate = function (chosenVenueID, chosenDate) {
            return filmsDal.getFilmsByVenueAndDate(chosenVenueID, chosenDate);
        }
    };

    angular.module('qaCinemas2').service('filmsService', ['filmsDal', FilmsService]);
}());