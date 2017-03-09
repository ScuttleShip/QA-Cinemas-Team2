/**
 * Created by Administrator on 07/03/2017.
 */
(function() {

    var showingDal = function(dal) {

        this.getMovieByShowingID = function(showingID) {
            return dal.http.GET("rest/showing/movie/" + showingID);
        }

        this.getShowingByShowingID = function (showingID) {
            return dal.http.GET("rest/showing/" + showingID);
        }

    };

    angular.module('qaCinemas2').service('showingDal', ['dal', showingDal]);

}());