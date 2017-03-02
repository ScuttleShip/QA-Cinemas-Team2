(function(){
    var venueController = function(venueService) {
        var vm = this;

         function init() {
            venueService.getVenue().then(function (results) {
                console.log("This is working" + results);
                vm.venues = results;
            }, function (error) {
                console.log("This is not working" + error);
                vm.error = true;
                vm.errorMessage = error;
            });
         }
      init();

    };
    angular.module('qaCinemas2').controller('venueController', ['venueService', venueController]);
}());