create table TB_Author (
	authorId LONG not null primary key,
	name VARCHAR(75) null,
	birthDate VARCHAR(75) null
);

create table TB_Book (
	bookId LONG not null primary key,
	genreId LONG,
	publisherId LONG,
	authorId LONG,
	name VARCHAR(75) null,
	releaseDate VARCHAR(75) null
);

create table TB_Genre (
	genreId LONG not null primary key,
	name VARCHAR(75) null
);

create table TB_Publisher (
	publisherId LONG not null primary key,
	name VARCHAR(75) null
);