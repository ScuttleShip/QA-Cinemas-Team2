insert into address(address_id, county, firstline, postcode, secondline, townorcity) values (1,'Exampleshire','11 Example Street','1TT1TT','Example','Exampleton');
insert into address(address_id, county, firstline, postcode, secondline, townorcity) values (2,'Exampleshire','22 Example Street','2TT2TT','Example','Testington');
insert into address(address_id, county, firstline, postcode, secondline, townorcity) values (3,'ManTester','33 Example Street','3TT3TT','Example','Testcaster');
insert into booking(booking_id, customeremail, numberofseats) values (1,'example@example.com',1);
insert into booking(booking_id, customeremail, numberofseats) values (2,'test@test.com',2);
insert into booking(booking_id, customeremail, numberofseats) values (3,'demo@demo.com',3);
insert into movie(movie_id, certification, description, duration, genre, title) values (1, 'PG', 'This is a film', '01:30:00', 'Animation', 'Example Film');
insert into movie(movie_id, certification, description, duration, genre, title) values (2, '12', 'This is another film', '02:00:00', 'Animation', 'Test Film');
insert into movie(movie_id, certification, description, duration, genre, title) values (3, '18', 'This is the third film', '01:50:00', 'Horror', 'Demo Film');
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