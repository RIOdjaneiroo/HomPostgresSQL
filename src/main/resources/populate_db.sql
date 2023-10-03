
insert into levels (levels_id, levels_Name) values (1,'Trainee'), (2,'Junior'), (3,'Middle'), (4,'Senior');

insert into worker (id, name, birthday, levels_id, salary) values
(1, 'John Week', '1990-05-15', 3, 3000),
(2, 'Anna Karenina', '1988-11-20', 2, 1500),
(3, 'Michael Galustiyn', '1995-02-08', 1, 350),
(4, 'Brus Lee', '1992-12-25', 4, 6000),
(5, 'John Karter', '1990-07-18', 3, 4000),
(6, 'Jenifer Aniston', '1988-10-21', 2, 2000),
(7, 'Michal Jordan', '1995-04-08', 1, 700),
(8, 'Bruce Willis', '1985-10-25', 4, 7000),
(9, 'John Jones', '1983-05-15', 3, 5000),
(10, 'Izrail Karenin', '1988-12-22', 2, 2500),
(11, 'Micke Tison', '1975-03-08', 1, 800),
(12, 'Braun Wiscki', '1982-12-25', 4, 8000);

insert into client (id, name) values (1,'Taras'), (2,'Konsrantin'), (3,'Adesaniy'), (4,'Mr.Sergio'), (5,'Elton');

insert into project (id, client_id, start_date, finish_date) values
(1, 1, '2022-05-15', '2022-06-15'),
(2, 2, '2022-06-25', '2022-07-05'),
(3, 3, '2022-10-20', '2022-12-21'),
(4, 4, '2022-11-10', '2023-02-11'),
(5, 5, '2022-10-01', '2023-03-15'),
(6, 1, '2023-01-09', '2023-05-13'),
(7, 2, '2023-01-17', '2023-08-30'),
(8, 3, '2023-02-27', '2023-09-01'),
(9, 4, '2023-03-16', '2023-05-07'),
(10, 5, '2023-04-19', '2023-08-28');

insert into project_worker (project_id, worker_id) values
(1,1), (1,2), (1,3), (1,4), (1,5), (2,6), (2,7), (2,8), (2,9), (2,10), (3,11), (4,12),
(5,1), (5,3), (5,4), (5,5), (5,6), (6,7), (6,8), (6,9), (6,10), (7,11), (8,12),
(9,2), (9,3), (9,5), (9,6), (10,7), (10,8), (10,9), (10,11), (10,12);


