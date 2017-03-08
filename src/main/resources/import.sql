insert into address(address_id, county, firstline, postcode, secondline, townorcity) values (1,'Northumberland','2nd Floor','NE1 4AD','1 St James Gate','Newcastle');
insert into address(address_id, county, firstline, postcode, secondline, townorcity) values (2,'West Yorkshire','Islington House','LS12 6BD','Brown Lane West','Leeds');
insert into address(address_id, county, firstline, postcode, secondline, townorcity) values (3,'Lancashire','8th Floor, St James Buildings','M1 6FQ','61-95 Oxford Street','Manchester');



insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (1, '12A', 'A team of explorers travel through a wormhole in space in an attempt to ensure humanitys survival', '02:30:00', 'Space', 'Interstellar', 'imgs/interstellar.jpg');
insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (2, '12A', 'Three decades after the defeat of the Galactic Empire, a new threat arises. The First Order attempts to rule the galaxy and only a ragtag group of heroes can stop them, along with the help of the Resistance.', '02:30:00', 'Space', 'Star Wars : The Force Awakens', 'imgs\star_wars_the_force_awakens_main_characters_105940_1920x1080.jpg');
insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (3, '12A', 'Two astronauts work together to survive after an accident which leaves them alone in space.', '02:30:00', 'Space', 'Gravity', 'imgs/gravity.jpg');
insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (4, '12A', 'A new theme park, built on the original site of Jurassic Park, creates a genetically modified hybrid dinosaur, which escapes containment and goes on a killing spree.', '02:30:00', 'Dinosaur', 'Jurassic World', 'imgs\chris_pratt_jurassic_world-1920x1080.jpg');
insert into movie(movie_id, certification, description, duration, genre, title, filmImg) values (5, '12A', 'Earths mightiest heroes must come together and learn to fight as a team if they are to stop the mischievous Loki and his alien army from enslaving humanity.', '02:30:00', 'Superhero', 'Marvel Avengers Assemble', 'imgs\maxresdefault.jpg');

insert into venue(venue_id, name, venueimg, venue_address_id) values(1,'QA Newcastle','imgs/venue1.jpg',1);
insert into venue(venue_id, name, venueimg, venue_address_id) values(2,'QA Leeds','imgs/venue2.jpg',2);
insert into venue(venue_id, name, venueimg, venue_address_id) values(3,'QA Manchester','imgs/venue3.jpg',3);

insert into screen(screen_id, numberofseats, screennumber, venue_id) values (1,100,1,1);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (2,100,2,1);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (3,100,1,2);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (4,100,2,2);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (5,100,1,3);
insert into screen(screen_id, numberofseats, screennumber, venue_id) values (6,100,2,3);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (1, '2017-03-10', 1, 100, '12:00:00', 1);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (2, '2017-03-10', 1, 100, '15:30:00', 2);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (3, '2017-03-10', 1, 100, '19:00:00', 1);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (4, '2017-03-10', 1, 100, '22:30:00', 3);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (5, '2017-03-10', 2, 100, '12:30:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (6, '2017-03-10', 2, 100, '16:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (7, '2017-03-10', 2, 100, '19:30:00', 5);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (8, '2017-03-10', 2, 100, '23:00:00', 5);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (9, '2017-03-10', 3, 100, '12:00:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (10, '2017-03-10', 3, 100, '19:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (11, '2017-03-10', 3, 100, '17:00:00', 2);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (12, '2017-03-10', 3, 100, '17:00:00', 1);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (13, '2017-03-10', 4, 100, '12:00:00', 5);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (14, '2017-03-10', 4, 100, '19:00:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (15, '2017-03-10', 4, 100, '17:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (16, '2017-03-10', 4, 100, '17:00:00', 2);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (17, '2017-03-10', 5, 100, '12:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (18, '2017-03-10', 5, 100, '19:00:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (19, '2017-03-10', 5, 100, '17:00:00', 5);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (20, '2017-03-10', 5, 100, '17:00:00', 1);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (21, '2017-03-10', 6, 100, '12:00:00', 2);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (22, '2017-03-10', 6, 100, '19:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (23, '2017-03-10', 6, 100, '17:00:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (24, '2017-03-10', 6, 100, '17:00:00', 5);


insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (25, '2017-03-11', 1, 100, '12:00:00', 1);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (26, '2017-03-11', 1, 100, '15:30:00', 2);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (27, '2017-03-11', 1, 100, '19:00:00', 1);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (28, '2017-03-11', 1, 100, '22:30:00', 3);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (29, '2017-03-11', 2, 100, '12:30:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (30, '2017-03-11', 2, 100, '16:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (31, '2017-03-11', 2, 100, '19:30:00', 5);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (32, '2017-03-11', 2, 100, '23:00:00', 5);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (33, '2017-03-11', 3, 100, '12:00:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (34, '2017-03-11', 3, 100, '19:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (35, '2017-03-11', 3, 100, '17:00:00', 2);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (36, '2017-03-11', 3, 100, '17:00:00', 1);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (37, '2017-03-11', 4, 100, '12:00:00', 5);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (38, '2017-03-11', 4, 100, '19:00:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (39, '2017-03-11', 4, 100, '17:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (40, '2017-03-11', 4, 100, '17:00:00', 2);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (41, '2017-03-11', 5, 100, '12:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (42, '2017-03-11', 5, 100, '19:00:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (43, '2017-03-11', 5, 100, '17:00:00', 5);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (44, '2017-03-11', 5, 100, '17:00:00', 1);

insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (45, '2017-03-11', 6, 100, '12:00:00', 2);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (46, '2017-03-11', 6, 100, '19:00:00', 3);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (47, '2017-03-11', 6, 100, '17:00:00', 4);
insert into showing(showing_id, date, screen_id, seatsremaining, starttime, showing_movie_id) values (48, '2017-03-11', 6, 100, '17:00:00', 5);


insert into booking(booking_id, customeremail, numberofseats, showing_id) values (1,'example@example.com',1,1);
insert into booking(booking_id, customeremail, numberofseats, showing_id) values (2,'test@test.com',2,2);