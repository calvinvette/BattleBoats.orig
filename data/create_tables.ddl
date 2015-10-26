create schema BattleBoats;
drop table BattleBoats.Navy;
drop table BattleBoats.Player;

create table BattleBoats.Player (
	id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	username VARCHAR(40) NOT NULL,
	password VARCHAR(40),	
	email VARCHAR(128),
	subscription_level INTEGER,
	display_name VARCHAR(25),
	location VARCHAR(50),
	ranking INTEGER,
	age INTEGER,
	gender VARCHAR(12),
	avatar BLOB(2048000)
);

create table BattleBoats.Navy (
	id INTEGER NOT NULL PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
	budget DECIMAL,
	player INTEGER,
	CONSTRAINT playerFK
		FOREIGN KEY (player) REFERENCES BattleBoats.Player (id)
);

