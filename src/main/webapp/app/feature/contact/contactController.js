//You should create the validator only after the definition of the HTML form

(function() {

    var contactController = function(contactUsService) {

        var frmvalidator  = new Validator("myform");
        frmvalidator.addValidation("FirstName","req","Please enter your First Name");
        frmvalidator.addValidation("FirstName","maxlen=20",	"Max length for FirstName is 20");
        frmvalidator.addValidation("FirstName","alpha","Alphabetic chars only");

        frmvalidator.addValidation("LastName","req","Please enter your Last Name");
        frmvalidator.addValidation("LastName","maxlen=20","Max length is 20");

        frmvalidator.addValidation("Email","maxlen=50");
        frmvalidator.addValidation("Email","req");
        frmvalidator.addValidation("Email","email");

        frmvalidator.addValidation("Phone","maxlen=11");
        frmvalidator.addValidation("Phone","numeric");

        var venues = [];

        function init() {

        }

        vm.sendEmail = function(emailToSend) {
            var emailToJson = JSON.stringify(emailToSend);
            contactUsService.sendEmail(emailToJson);
        }

    }

    angular.module("qaCinemas2").controller("contactController", ["contactUsService", contactController]);

}());