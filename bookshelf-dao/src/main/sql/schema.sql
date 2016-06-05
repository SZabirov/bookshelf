CREATE TABLE client (
  id           SERIAL PRIMARY KEY,
  nickname     VARCHAR(255) NOT NULL CONSTRAINT uk_nickname UNIQUE,
  email        VARCHAR(255) NOT NULL CONSTRAINT uk_email UNIQUE,
  firstname    VARCHAR(255),
  surname      VARCHAR(255),
  city         VARCHAR(255),
  phone        VARCHAR(255),
  hashpassword VARCHAR(255) NOT NULL,
  avatar       VARCHAR(255)
);

CREATE TABLE token (
  id        SERIAL PRIMARY KEY,
  client_id INT,
  token     VARCHAR(255) NOT NULL CONSTRAINT uk_token UNIQUE,

  FOREIGN KEY (client_id) REFERENCES client (id)
);

CREATE TABLE author (
  id         SERIAL PRIMARY KEY,
  firstname  VARCHAR(255) NOT NULL,
  surname    VARCHAR(255) NOT NULL,
  middlename VARCHAR(255) NOT NULL,

  CONSTRAINT uk_firstname_surname_middlename UNIQUE (firstname, surname, middlename)
);

CREATE TABLE author_bookname (
  id        SERIAL PRIMARY KEY,
  author_id INT          NOT NULL,
  bookname  VARCHAR(255) NOT NULL,
  verified  BOOLEAN,

  FOREIGN KEY (author_id) REFERENCES author (id),
  CONSTRAINT uk_author_id_bookname UNIQUE (author_id, bookname)
);

CREATE TABLE book (
  id                 SERIAL PRIMARY KEY,
  author_bookname_id INT NOT NULL,
  pubhouse           VARCHAR(255),
  pub_year           VARCHAR(4),
  description        VARCHAR(1000),
  photo              VARCHAR(255),
  verified           BOOLEAN,

  FOREIGN KEY (author_bookname_id) REFERENCES author_bookname (id)
);

CREATE TABLE client_wish (
  id                 SERIAL PRIMARY KEY,
  client_id          INT NOT NULL,
  author_bookname_id INT NOT NULL,

  FOREIGN KEY (author_bookname_id) REFERENCES author_bookname (id),
  FOREIGN KEY (client_id) REFERENCES client (id),
  CONSTRAINT uk_client_id_author_bookname_id UNIQUE (client_id, author_bookname_id)
);

CREATE TABLE client_having (
  id        SERIAL PRIMARY KEY,
  client_id INT NOT NULL,
  book_id   INT NOT NULL,

  FOREIGN KEY (client_id) REFERENCES client (id),
  FOREIGN KEY (book_id) REFERENCES book (id),
  CONSTRAINT uk_client_id_book_id UNIQUE (client_id, book_id)
);

CREATE TABLE message (
  id             SERIAL PRIMARY KEY,
  sender_id      INT NOT NULL,
  receiver_id    INT NOT NULL,
  having_book_id INT NOT NULL,
  wish_book_id   INT NOT NULL,
  status         VARCHAR(255),

  FOREIGN KEY (sender_id) REFERENCES client (id),
  FOREIGN KEY (receiver_id) REFERENCES client (id),
  FOREIGN KEY (having_book_id) REFERENCES book (id),
  FOREIGN KEY (wish_book_id) REFERENCES book (id),
  CONSTRAINT uk_sender_id_receiver_id_having_book_id_wish_book_id UNIQUE (sender_id, receiver_id, having_book_id, wish_book_id)
);
