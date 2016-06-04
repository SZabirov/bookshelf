CREATE TABLE client (
  id SERIAL PRIMARY KEY,
  nickname VARCHAR(255) CONSTRAINT uk_nickname UNIQUE,
  email VARCHAR(255) NOT NULL,
  firstname VARCHAR(255),
  surname VARCHAR(255),
  city VARCHAR(255),
  phone VARCHAR(15),
  hashpassword VARCHAR(255),
  avatar VARCHAR(255)
);

CREATE TABLE token (
  id SERIAL PRIMARY KEY,
  client_id INT,
  token VARCHAR(255)CONSTRAINT uk_token UNIQUE,

  FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE author (
  id SERIAL PRIMARY KEY,
  firstname VARCHAR(255),
  surname VARCHAR(255),
  middlename VARCHAR(255)
);

CREATE TABLE author_bookname (
  id SERIAL PRIMARY KEY,
  author_id INT,
  bookname VARCHAR(255),
  verified BOOLEAN,

  FOREIGN KEY (author_id) REFERENCES author(id)
);

CREATE TABLE book (
  id SERIAL PRIMARY KEY,
  author_bookname_id INT,
  pubhouse  VARCHAR(255),
  pub_year VARCHAR(4),
  description VARCHAR(1000),
  photo VARCHAR(255),
  verified BOOLEAN,

  FOREIGN KEY (author_bookname_id) REFERENCES author_bookname(id)
);

CREATE TABLE client_wish(
  id SERIAL PRIMARY KEY,
  client_id INT,
  author_bookname_id INT,

  FOREIGN KEY (author_bookname_id) REFERENCES author_bookname(id),
  FOREIGN KEY (client_id) REFERENCES client(id)
);

CREATE TABLE client_having(
  id SERIAL PRIMARY KEY,
  client_id INT,
  book_id INT,

  FOREIGN KEY (client_id) REFERENCES client(id),
  FOREIGN KEY (book_id) REFERENCES book(id)
);

CREATE TABLE message (
  id SERIAL PRIMARY KEY,
  sender_id INT,
  receiver_id INT,
  having_book_id INT,
  wish_book_id INT,
  status VARCHAR(255),

  FOREIGN KEY (sender_id) REFERENCES client(id),
  FOREIGN KEY (receiver_id) REFERENCES client(id),
  FOREIGN KEY (having_book_id) REFERENCES book(id),
  FOREIGN KEY (wish_book_id) REFERENCES book(id)
);
