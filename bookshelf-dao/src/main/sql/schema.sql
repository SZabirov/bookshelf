CREATE TABLE avatar (
  id SERIAL PRIMARY KEY,
  avatar_url VARCHAR(255)
);

CREATE TABLE bookshelf_user (
  id SERIAL PRIMARY KEY,
  nickname VARCHAR(255) CONSTRAINT uk_nickname UNIQUE,
  firstname VARCHAR(255),
  surname VARCHAR(255),
  city VARCHAR(255),
  hashpassword VARCHAR(255),
  avatar_id INT,

  FOREIGN KEY (avatar_id) REFERENCES avatar(id)
);

CREATE TABLE token (
  id SERIAL PRIMARY KEY,
  bookshelf_user_id INT,
  token VARCHAR(255)CONSTRAINT uk_token UNIQUE,

  FOREIGN KEY (bookshelf_user_id) REFERENCES bookshelf_user(id)
);

CREATE TABLE author (
  id SERIAL PRIMARY KEY,
  author_firstname VARCHAR(255),
  author_surname VARCHAR(255),
  author_middlename VARCHAR(255)
);

CREATE TABLE book_name (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE author_book_name (
  id SERIAL PRIMARY KEY,
  author_id INT,
  book_name_id INT,
  verified BOOLEAN,

  FOREIGN KEY (author_id) REFERENCES author(id),
  FOREIGN KEY (book_name_id) REFERENCES book_name(id)
);

CREATE TABLE photo (
  id SERIAL PRIMARY KEY,
  photo_url VARCHAR(255)
);

CREATE TABLE book (
  id SERIAL PRIMARY KEY,
  author_book_name_id INT,
  pubhouse  VARCHAR(255),
  pub_year VARCHAR(4),
  description VARCHAR(1000),
  photo_id INT,
  verified BOOLEAN,
  creator_id INT,

  FOREIGN KEY (creator_id) REFERENCES bookshelf_user(id),
  FOREIGN KEY (author_book_name_id) REFERENCES author_book_name(id),
  FOREIGN KEY (photo_id) REFERENCES photo(id)
);

CREATE TABLE bookshelf_user_wish(
  id SERIAL PRIMARY KEY,
  bookshelf_user_id INT,
  author_book_name_id INT,

  FOREIGN KEY (author_book_name_id) REFERENCES author_book_name(id),
  FOREIGN KEY (bookshelf_user_id) REFERENCES bookshelf_user(id)
);

CREATE TABLE bookshelf_user_having(
  id SERIAL PRIMARY KEY,
  bookshelf_user_id INT,
  book_id INT,

  FOREIGN KEY (bookshelf_user_id) REFERENCES bookshelf_user(id),
  FOREIGN KEY (book_id) REFERENCES book(id)
);
