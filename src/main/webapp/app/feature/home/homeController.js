/**
 * Created by Administrator on 27/02/2017.
 */
(function() {

    var homeController = function(venueService, homeService) {

        var vm = this;

        vm.venues = [];
        vm.movies = [];

        vm.saveVenueDate = function() {

            var venueChooser = document.getElementById("myVenue");

            var dateChooser = document.getElementById("selectedDate");

            sessionStorage.setItem("chosenVenue", venueChooser.value);
            sessionStorage.setItem("chosenDate", dateChooser.value);

            console.log(sessionStorage.getItem("chosenVenue"));
            console.log(sessionStorage.getItem("chosenDate"));



        }

        function init() {

            vm.assignSlideMovies = function (slide1_movieID, slide2_movieID, slide3_movieID, slide4_movieID, slide5_movieID) {
                vm.slideMovie_ID1 = slide1_movieID - 1;
                vm.slideMovie_ID2 = slide2_movieID -1;
                vm.slideMovie_ID3 = slide3_movieID - 1;
                vm.slideMovie_ID4 = slide4_movieID - 1;
                vm.slideMovie_ID5 = slide5_movieID - 1;

            };
            vm.assignSlideMovies(1,2,3,4,5);


            homeService.getAllMovies().then(function (results) {
                console.log(results);
                vm.movies = results;
            });


            venueService.getAllVenues().then(function (results) {
                console.log(results);
                vm.venues = results;
            }, function (error) {
                console.log("This is not working" + error);
                vm.error=true;
                vm.errorMessage = error;

            });


            $('#myCarousel').carousel({
                interval: 5000
            });

            $('#carousel-text').html($('#slide-content-0').html());

            //Handles the carousel thumbnails
            $('[id^=carousel-selector-]').click( function(){
                var id = this.id.substr(this.id.lastIndexOf("-") + 1);
                var id = parseInt(id);
                $('#myCarousel').carousel(id);
            });


            // When the carousel slides, auto update the text
            $('#myCarousel').on('slid.bs.carousel', function (e) {
                var id = $('.item.active').data('slide-number');
                $('#carousel-text').html($('#slide-content-'+id).html());
            });
        }

        init();

    }

    angular.module("qaCinemas2").controller("homeController", ['venueService', 'homeService', homeController]);

}());