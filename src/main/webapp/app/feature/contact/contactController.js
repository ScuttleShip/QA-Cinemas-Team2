(function() {

    var contactController = function(contactUsService) {

        var vm = this;

        var venues = [];

        var erm = [];

        function init() {

        }

        vm.sendEmail = function(emailToSend) {
            erm = emailToSend;
            contactUsService.sendEmail(emailToSend);
        };

        vm.doSomething = function() {
            window.location.href = 'index.html';
        };

        vm.validateBox = function(){
            /*var frmvalidator  = new Validator("myform");

            /*frmvalidator.addValidation("FirstName","req","Please enter your First Name");

            frmvalidator.addValidation("FirstName","maxlen=20",	"Max length for FirstName is 20");
            frmvalidator.addValidation("FirstName","alpha","Alphabetic chars only");

            frmvalidator.addValidation("LastName","req","Please enter your Last Name");
            frmvalidator.addValidation("LastName","maxlen=20","Max length is 20");

            frmvalidator.addValidation("Email","maxlen=50");
            frmvalidator.addValidation("Email","req");
            frmvalidator.addValidation("Email","email");
            */
            /*
            frmvalidator.addValidation("Phone","maxlen=11");
            frmvalidator.addValidation("Phone","numeric");
            */



        }

    };

    angular.module("qaCinemas2").controller("contactController", ["contactUsService", contactController]);

}());