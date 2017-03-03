/**
 * Created by Administrator on 03/03/2017.
 */
(function() {

    var contactUsDal = function(dal) {

        this.sendEmail = function(emailToSend) {
            return dal.http.POST("rest/contact/json", emailToSend);
        }

    }

    angular.module("qaCinemas2").service("contactUsDal", ["dal", contactUsDal]);

}());