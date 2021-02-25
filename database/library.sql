CREATE DATABASE library;
CREATE table patrons (
	patron_id int primary key auto_increment,
    first_name varchar(50) not null,
    last_name varchar(50) not null,
    username_name varchar(50) not null,
    pass varchar(50) not null,
    account_frozen boolean  not null
);
describe patrons;

CREATE table books (
	isbn int primary key auto_increment,
    title varchar(50) not null,
    descr varchar(50) not null,
    rented boolean not null,
    added_to_library date not null
);
describe books;

CREATE table book_checkouts (
	checkout_id int primary key auto_increment,
    patron_id int not null,
    isbn int not null,
    FOREIGN KEY (patron_id) REFERENCES patrons(patron_id),
    FOREIGN KEY (isbn) REFERENCES books(isbn),
    checkedout date not null,
    due_date date not null,
    returned date
);
describe book_checkouts;

CREATE table librarians (
	librarian_id int primary key auto_increment,
    username varchar(50) not null,
    pass varchar(50) not null
);
describe librarians;