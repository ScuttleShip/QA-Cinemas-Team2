(function(){

    var venueService = function(venueDal){
        this.getAllVenues = function() {
            return venueDal.getAllVenues();
        };

        this.getVenueByID = function(venue_ID) {
            return venueDal.getVenueByID(venue_ID);
        }
    };

    angular.module('qaCinemas2').service('venueService', ['venueDal', venueService]);

}());