//You should create the validator only after the definition of the HTML form

(function() {

    var contactController = function(contactUsService) {

        var vm = this;

        var venues = [];

        var erm = [];

        function init() {

        }

        vm.sendEmail = function(emailToSend) {
            console.log(emailToSend);
            erm = emailToSend;
            var emailToJson = JSON.stringify(erm);
            console.log(emailToJson);
            contactUsService.sendEmail(emailToSend);
        }

        vm.doSomething = function() {
            console.log("did something");
        }

    }

    angular.module("qaCinemas2").controller("contactController", ["contactUsService", contactController]);

}());