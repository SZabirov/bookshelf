INSERT INTO client(nickname, email, firstname, surname, city, hashpassword)
VALUES('Ivan', 'ivan@mail.ru', 'Ivan', 'Ivanov', 'Kazan', '202cb962ac59075b964b07152d234b70');

INSERT INTO client(nickname, email, firstname, surname, city, hashpassword)
VALUES('Masha', 'masha@mail.ru', 'Maria', 'Ivanova', 'Kazan', '202cb962ac59075b964b07152d234b70');

insert into author (firstname, surname, middlename) values ('Лев', 'Толстой', 'Николаевич');

insert into author_bookname (author_id, bookname, verified) values (1, 'Война и Мир', true);

INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (1, 'ЭКСМО', '2000', 'Good book', true);

INSERT into client_having(client_id, book_id) VALUES (1, 1);

INSERT into client_wish(client_id, author_bookname_id) VALUES (1, 1);


insert into author (firstname, surname) values ('Николай', 'Гоголь');

insert into author_bookname (author_id, bookname, verified) values (2, 'Мертвые души', true);

INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
 VALUES (2, 'ЭКСМО', '2010', 'Very good book', true);

INSERT into client_wish(client_id, author_bookname_id) VALUES (1, 2);

insert into author (firstname, surname) values ('Иван', 'Тургенев');
insert into author (firstname, surname) values ('Александр', 'Пушкин');
insert into author (firstname, surname) values ('Федор', 'Достоевский');
insert into author (firstname, surname) values ('Джек', 'Лондон');
insert into author (firstname, surname) values ('Марк', 'Твен');

insert into author_bookname (author_id, bookname, verified) values (3, 'Отцы и дети', true);
insert into author_bookname (author_id, bookname, verified) values (3, 'Дворянское гнездо', true);
insert into author_bookname (author_id, bookname, verified) values (4, 'Дубровский', true);
insert into author_bookname (author_id, bookname, verified) values (4, 'Пиковая дама', true);
insert into author_bookname (author_id, bookname, verified) values (4, 'Евгений Онегин', true);
insert into author_bookname (author_id, bookname, verified) values (4, 'Медный всадник', true);
insert into author_bookname (author_id, bookname, verified) values (5, 'Преступление и наказание', true);
insert into author_bookname (author_id, bookname, verified) values (5, 'Идиот', true);
insert into author_bookname (author_id, bookname, verified) values (5, 'Братья Карамазовы', true);
insert into author_bookname (author_id, bookname, verified) values (6, 'Мартин Иден', true);
insert into author_bookname (author_id, bookname, verified) values (6, 'Белый клык', true);
insert into author_bookname (author_id, bookname, verified) values (7, 'Принц и нищий', true);
insert into author_bookname (author_id, bookname, verified) values (7, 'Приключения Тома Сойера', true);

INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (3, 'ЭКСМО', '2000', 'В отличном состоянии', true);
INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (4, 'АСТ', '1993', 'В очень хорошом состоянии', true);
INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (5, 'ЭКСМО', '2013', 'Книга в хорошем состоянии', true);
INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (6, 'АСТ', '2001', 'В хорошем состоянии', true);
INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (7, 'ЭКСМО', '1998', 'Отличное состояние', true);
INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (8, 'ЭКСМО', '2010', 'Новая книга', true);
INSERT into book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (9, 'АСТ', '2012', 'Новая книга', true);


INSERT into client_having(client_id, book_id) VALUES (1, 3);
INSERT into client_wish(client_id, author_bookname_id) VALUES (1, 14);

INSERT into client_having(client_id, book_id) VALUES (2, 1);
INSERT into client_wish(client_id, author_bookname_id) VALUES (2, 15);

INSERT into client_having(client_id, book_id) VALUES (2, 5);
INSERT into client_wish(client_id, author_bookname_id) VALUES (2, 8);

INSERT into client_having(client_id, book_id) VALUES (2, 2);

INSERT into client_having(client_id, book_id) VALUES (2, 3);
INSERT into client_wish(client_id, author_bookname_id) VALUES (2, 11);

INSERT into message(sender_id, receiver_id, having_book_id, wish_book_id) VALUES (1, 2, 3, 1);

INSERT INTO token(client_id, token) VALUES (1, 'tkn');