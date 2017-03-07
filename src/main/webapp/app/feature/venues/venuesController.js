(function(){
    var venueController = function(venueService)
    {
        var vm = this;

        //vm.venues = [{title:""},{title:""},{title:""}];

        function init() {

            console.log("Initialising");

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