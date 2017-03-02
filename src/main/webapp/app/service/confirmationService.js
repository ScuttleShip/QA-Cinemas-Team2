/**
 * Created by Administrator on 02/03/2017.
 */
(function() {

    var confirmationService =  function(confirmationDal) {

        this.getConfirmation = function()
        {
            return confirmationDal.getConfirmation();
        };
    };

       angular.module("qaCinemas2").service("confirmationService", ["confirmationDal", confirmationService]);
}());