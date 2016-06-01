INSERT INTO users(nickname, email, firstname, surname, city, hashpassword)
VALUES('Ivan', 'ivan@mail.ru', 'Ivan', 'Ivanov', 'Kazan', '202cb962ac59075b964b07152d234b70');

INSERT INTO users(nickname, email, firstname, surname, city, hashpassword)
VALUES('Masha', 'masha@mail.ru', 'Maria', 'Ivanova', 'Kazan', '202cb962ac59075b964b07152d234b70');

insert into author (firstname, surname) values ('Лев', 'Толстой');

insert into author_bookname (author_id, bookname, verified) values (1, 'Война и Мир', true);

INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (1, 'ЭКСМО', '2000', 'Good book', true);

INSERT into users_having(users_id, book_id) VALUES (1, 1);

INSERT into users_wish(users_id, author_bookname_id) VALUES (1, 1);


insert into author (firstname, surname) values ('Николай', 'Гоголь');

insert into author_bookname (author_id, bookname, verified) values (2, 'Мертвые души', true);

INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
 VALUES (2, 'ЭКСМО', '2010', 'Very good book', true);

 INSERT into users_wish(users_id, author_bookname_id) VALUES (1, 2);
