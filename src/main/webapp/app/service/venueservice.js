(function(){

    var venueService = function(venueDal){
        this.getAllVenues = function()
        {
            return venueDal.getAllVenues();
        };
    };
    angular.module('qaCinemas2').service('venueService', ['venueDal', venueService]);
}());