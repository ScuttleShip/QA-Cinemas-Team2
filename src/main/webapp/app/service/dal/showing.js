/**
 * Created by Administrator on 07/03/2017.
 */
(function() {

    var showingDal = function(dal) {

        this.getMovieByShowingID = function(showingID) {
            return dal.http.GET("rest/showing/movie/" + showingID);
        }

    };

    angular.module('qaCinemas2').controller('showingDal', ['dal', showingDal]);

}());