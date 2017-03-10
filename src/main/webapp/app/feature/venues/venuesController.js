(function(){
    var venueController = function(venueService)
    {
        var vm = this;

        //vm.venues = [{title:""},{title:""},{title:""}];

        function init() {

            venueService.getAllVenues().then(function (results) {
                vm.venues = results;
            }, function (error) {
                vm.error=true;
                vm.errorMessage = error;
            });
            }

            init()
    };
    angular.module('qaCinemas2').controller('venueController', ['venueService', venueController]);
}());