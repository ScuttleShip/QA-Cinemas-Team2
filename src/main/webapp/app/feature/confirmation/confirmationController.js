/**
 * Created by Amit on 27/02/2017.
 */
(function() {

    var confirmationController =  function(confirmationService)
    {
        var vm = this;

        function init() {
            console.log("helloooooo");
            confirmationService.getConfirmation().then(function (results) {
                console.log("In confirmation controller about to return data to the client with results " + results);
                vm.confirmation  = results;
            }, function (error) {
                vm.error = true;
                vm.errorMessage = error;
            });
        }

        init();
    };
    angular.module('qaCinemas2').controller('confirmationController', ['confirmationService', confirmationController]);
}());