
create table levels(
levels_id int primary key,
levels_name varchar(10)
);

create table worker (
	id bigint primary key,
	name varchar not null check (length(name::text) >= 2 AND length(name::text) <= 1000),
	birthday date not null check (extract(year from birthday)>1900),
	levels_id integer not null,
	salary integer not null check (salary >=100 AND salary <=100000)
);

alter table worker add constraint worker_levels_fk foreign key (levels_id) references levels(levels_id);

create table profiles (
worker_id bigint primary key,
second_name varchar (100),
adres varchar(255),
description varchar(255),
sex varchar(25)
);

alter table profiles
add constraint worker_profiles_fk
foreign key (worker_id)
references worker(id) on delete cascade;

create table client (
	id bigint primary key,
	name varchar not null check (length(name::text) >= 2 AND length(name::text) <= 1000)
);

create table project (
id bigint primary key,
client_id bigint not null,
start_date date not null,
finish_date date not null
);

alter table project add constraint project_client_fk foreign key (client_id)references client(id);

create table project_worker(
project_id bigint not null,
worker_id bigint not null,
primary key (project_id, worker_id),
foreign key (project_id) references project(id),
foreign key (worker_id) references worker(id)
);




