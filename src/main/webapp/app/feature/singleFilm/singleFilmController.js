(function() {
    var singleFilmController = function(filmsService, $stateParams) {

        var vm = this;
        vm.singleFilm = "";
        vm.certImage = "";

        console.log($stateParams.film_ID);
        var singleFilmName = document.getElementById("singleFilmName");

        function init() {
            filmsService.getFilmById($stateParams.film_ID).then(function (results) {

                if(results != null){
                    console.log("The result of film search is " + results.title);
                    singleFilmName.innerHTML = "Movie: " + results.title;
                    vm.singleFilm = results;

                    var certImg = "";
                    var cert =  results.certification;

                    switch(cert) {
                        case "12A":
                            certImg = "imgs/12A_Rating.png";
                            break;
                        case "PG":
                            certImg = "imgs/PG.jpg";
                            break;
                        case "15":
                            certImg = "imgs/15.jpg";
                            break;
                    }

                    vm.certImage = certImg;

                }else{
                    singleFilmName.innerHTML = "No Film was found!";
                }

            }, function (error) {
                singleFilmName.innerHTML = "No film was found!";
            });
        };

        init();

    };
    angular.module("qaCinemas2").controller('singleFilmController', ['filmsService', '$stateParams', singleFilmController]);
}());