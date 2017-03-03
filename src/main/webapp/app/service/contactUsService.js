(function() {

    var contactUsService = function(contactUsDal) {

        this.sendEmail = function(emailToSend) {
            return contactUsDal.sendEmail(emailToSend);
        }

    }

    angular.module("qaCinemas2").service("contactUsService", ["contactUsDal", contactUsService]);

}());