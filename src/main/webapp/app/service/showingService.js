/**
 * Created by Administrator on 07/03/2017.
 */
(function() {

    var showingService = function (showingDal) {

        this.getMovieByShowingID = function (showingID) {
            return showingDal.getMovieByShowingID(showingID);
        }

    };

    angular.module("qaCinemas2").service('showingService', ['showingDal', showingService]);

}());