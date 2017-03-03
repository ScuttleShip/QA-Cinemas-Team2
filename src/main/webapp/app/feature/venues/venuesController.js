(function(){
    var venueController = function(venueService)
    {
        var vm = this;

        function init() {
            venueService.getAllVenues().then(function (results) {
                console.log(results);
                vm.venues = results;
            }, function (error) {
                console.log("This is not working" + error);
                vm.error=true;
                vm.errorMessage = error;

            });
            }

            init()
    };
    angular.module('qaCinemas2').controller('venueController', ['venueService', venueController]);
}());