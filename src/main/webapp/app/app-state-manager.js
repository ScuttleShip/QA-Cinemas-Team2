"use strict";

(function () {

    angular.module('qaCinemas2').config(function ($stateProvider, $urlRouterProvider) {

        $urlRouterProvider.otherwise("/home");

        $stateProvider
            .state(
                "booking",
                {
                    url: "/booking",
                    templateUrl:"app/feature/booking/booking-partial.html"
                }
            )
            .state(
                "confirmation",
                {
                    url: "/confirmation",
                    templateUrl:"app/feature/confirmation/confirmation.html"
                }
            )
            .state(
                "contact",
                {
                    url: "/contact",
                    templateUrl:"app/feature/contact/contact-partial.html"
                }
            )
            .state(
                "faqs",
                {
                    url: "/faqs",
                    templateUrl:"app/feature/faqs/faqs-partial.html"
                }
            )
            .state(
                "films",
                {
                    url: "/films",
                    templateUrl:"app/feature/films/films-partial.html"
                }
            )
            .state(
                "home",
                {
                    url: "/home",
                    templateUrl:"app/feature/home/home-partial.html"
                }
            )
            .state(
                "offers",
                {
                    url: "/offers",
                    templateUrl:"app/feature/offers/offers-partial.html"
                }
            )
            .state(
                "payments",
                {
                    url: "/payments",
                    templateUrl:"app/feature/payments/payments-partial.html"
                }
            )
            .state(
                "paymentSuccess",
                {
                    url: "/paymentSuccess",
                    templateUrl:"app/feature/paymentSuccess/paymentSuccess-partial.html"
                }
            )
            .state(
                "venues",
                {
                    url: "/venues",
                    templateUrl:"app/feature/venues/venues-partial.html"
                }
            );

    });
}());