CREATE TABLE avatar (
  id SERIAL PRIMARY KEY,
  avatar_url VARCHAR(255)
);

CREATE TABLE users (
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
  users_id INT,
  token VARCHAR(255)CONSTRAINT uk_token UNIQUE,

  FOREIGN KEY (users_id) REFERENCES users(id)
);

CREATE TABLE author (
  id SERIAL PRIMARY KEY,
  author_firstname VARCHAR(255),
  author_surname VARCHAR(255),
  author_middlename VARCHAR(255)
);

CREATE TABLE true_book (
  id SERIAL PRIMARY KEY,
  name VARCHAR(255)
);

CREATE TABLE author_true_book (
  id SERIAL PRIMARY KEY,
  author_id INT,
  true_book_id INT,
  verified BOOLEAN,

  FOREIGN KEY (author_id) REFERENCES author(id),
  FOREIGN KEY (true_book_id) REFERENCES true_book(id)
);

CREATE TABLE photo (
  id SERIAL PRIMARY KEY,
  photo_url VARCHAR(255)
);

CREATE TABLE book (
  id SERIAL PRIMARY KEY,
  author_true_book_id INT,
  pubhouse  VARCHAR(255),
  pub_year VARCHAR(4),
  description VARCHAR(1000),
  photo_id INT,
  verified BOOLEAN,
  creator_id INT,

  FOREIGN KEY (creator_id) REFERENCES users(id),
  FOREIGN KEY (author_true_book_id) REFERENCES author_true_book(id),
  FOREIGN KEY (photo_id) REFERENCES photo(id)
);

CREATE TABLE users_wish_books(
  id SERIAL PRIMARY KEY,
  users_id INT,
  author_true_book_id INT,

  FOREIGN KEY (author_true_book_id) REFERENCES author_true_book(id),
  FOREIGN KEY (users_id) REFERENCES users(id)
);

CREATE TABLE users_has_books(
  id SERIAL PRIMARY KEY,
  users_id INT,
  book_id INT,

  FOREIGN KEY (users_id) REFERENCES users(id),
  FOREIGN KEY (book_id) REFERENCES book(id)
);
