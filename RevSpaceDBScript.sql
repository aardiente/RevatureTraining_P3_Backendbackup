-----------------------------------------------
--DROPPERS--

	drop table if exists credentials;

drop table if exists likes;
	drop table if exists posts;
		drop table if exists users;

-----------------------------------------------
--CREATORS--

create table if not exists users (
	user_id serial primary key,
	email varchar(100) unique not null,
	first_name varchar(50) not null,
	last_name varchar(50) not null,
	birthday bigint default null,
	revature_join_date bigint default null,
	github_username varchar(50) not null default '',
	title varchar(100) not null default '',
	location varchar(500) not null default '',
	aboutme varchar(1000) not null default ''
);

create table if not exists credentials (
	credentials_id serial primary KEY,
	user_id int references users(user_id) UNIQUE NOT NULL,
	password varchar(64) not null
);


create table posts (
	post_id serial primary key,
	creator_id int references users(user_id),
	body varchar,
	image varchar,
	date bigint,
	comment boolean,
	parent_post int references posts(post_id)
);

create table likes (
	like_id serial primary key,
	user_id int references users(user_id),
	post_id int references posts(post_id)
);


-----------------------------------------------
--POPULATORS--

	--REFERENCE TABLES--

	--MEAT TABLES--

	--TEST DATA--
insert into users values
	(default, 'username@email.com', 'Charles', 'Mann', 0, 0, 'userGit', 'someTitle', 'someTown', 'someThing');

insert into credentials values
	(default, 1, 'Password1');
	
	
