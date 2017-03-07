insert into address(address_id, county, firstline, postcode, secondline, townorcity) values (1,'Exampleshire','11 Example Street','1TT1TT','Example','Exampleton');
insert into address(address_id, county, firstline, postcode, secondline, townorcity) values (2,'Exampleshire','22 Example Street','2TT2TT','Example','Testington');
insert into address(address_id, county, firstline, postcode, secondline, townorcity) values (3,'ManTester','33 Example Street','3TT3TT','Example','Testcaster');


insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (1, '12A', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanitys survival', '02:30:00', 'Space', 'Interstellar', 'imgs/interstellar.jpg');
insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (2, '12A', 'Three decades after the defeat of the Galactic Empire, a new threat arises. The First Order attempts to rule the galaxy and only a ragtag group of heroes can stop them, along with the help of the Resistance.', '02:30:00', 'Space', 'Star Wars : The Force Awakens', 'imgs\star_wars_the_force_awakens_main_characters_105940_1920x1080.jpg');
insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (3, '12A', 'Two astronauts work together to survive after an accident which leaves them alone in space.', '02:30:00', 'Space', 'Gravity', 'imgs/gravity.jpg');
insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (4, '12A', 'A new theme park, built on the original site of Jurassic Park, creates a genetically modified hybrid dinosaur, which escapes containment and goes on a killing spree.', '02:30:00', 'Dinosaur', 'Jurassic World', 'imgs\chris_pratt_jurassic_world-1920x1080.jpg');
insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (5, '12A', 'Earths mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.', '02:30:00', 'Superhero', 'Marvel Avengers Assemble', 'imgs\maxresdefault.jpg');

insert into venue(venue_id, name, venueimg, address_address_id) values(1,'Exampleshire','myimg',1);
insert into venue(venue_id, name, venueimg, address_address_id) values(2,'Exampleshire Arena','myimg',2);
insert into venue(venue_id, name, venueimg, address_address_id) values(3,'ManTester','myimg',3);

insert into screen(screen_id, numberofseats, screennumber, venue_id) values (1,100,1,1);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (2,100,2,1);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (3,100,1,2);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (4,100,2,2);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (5,100,1,3);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (6,100,2,3);

insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (1, '2018-01-02', 100, '17:00:00', 1, 1);
insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (2, '2018-01-02', 100, '19:00:00', 1, 1);
insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (3, '2018-01-02', 100, '17:00:00', 2, 2);
insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (4, '2018-01-02', 100, '14:00:00', 2, 1);

insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (5, '2018-01-02', 100, '17:00:00', 1, 3);
insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (6, '2018-01-02', 100, '19:00:00', 2, 3);
insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (7, '2018-01-02', 100, '17:00:00', 3, 4);
insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (8, '2018-01-02', 100, '17:00:00', 1, 4);

insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (9, '2018-01-02', 100, '17:00:00', 1, 5);
insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (10, '2018-01-02', 100, '17:00:00', 1, 6);
insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (11, '2018-01-02', 100, '19:00:00', 3, 6);
insert into showing(showing_id, date, seatsremaining, starttime, movie_id, screen_id) values (12, '2018-01-02', 100, '21:00:00', 3, 6);

insert into booking(booking_id, customeremail, numberofseats, showing_id) values (1,'example@example.com',1,1);
insert into booking(booking_id, customeremail, numberofseats, showing_id) values (2,'test@test.com',2,2);