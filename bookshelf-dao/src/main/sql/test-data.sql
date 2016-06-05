INSERT INTO client(nickname, email, firstname, surname, city, hashpassword, phone)
VALUES('Aig', 'aygul@mail.ru', 'Aygul', 'Mardanova', 'Kazan', '202cb962ac59075b964b07152d234b70', '891782828282');

INSERT INTO client(nickname, email, firstname, surname, city, hashpassword, phone)
VALUES('Aig1711', 'aig17@mail.ru', 'Aigul', 'Mardanova', 'Kazan', '202cb962ac59075b964b07152d234b70', '898772727272');

INSERT INTO client(nickname, email, firstname, surname, city, hashpassword, phone)
VALUES('Masha', 'masha@mail.ru', 'Maria', 'Ivanova', 'Kazan', '202cb962ac59075b964b07152d234b70', '891728282828');

INSERT INTO client(nickname, email, firstname, surname, city, hashpassword, phone)
VALUES('Ivan', 'ivan@mail.ru', 'Ivan', 'Ivanov', 'Kazan', '202cb962ac59075b964b07152d234b70', '891818181818');

INSERT INTO author (firstname, surname, middlename) VALUES ('Лев', 'Толстой', 'Николаевич');

INSERT INTO author_bookname (author_id, bookname, verified) VALUES (1, 'Война и Мир', true);

INSERT INTO book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (1, 'ЭКСМО', '2000', 'Good book', true);

INSERT INTO client_having(client_id, book_id) VALUES (1, 1);

INSERT INTO client_wish(client_id, author_bookname_id) VALUES (1, 1);

INSERT INTO author (firstname, surname, middlename) VALUES ('Николай', 'Гоголь', 'Васильевич');

INSERT INTO author_bookname (author_id, bookname, verified) VALUES (2, 'Мертвые души', true);

INSERT INTO book (author_bookname_id, pubhouse, pub_year, description, verified)
 VALUES (2, 'ЭКСМО', '2010', 'Very good book', true);

INSERT INTO client_wish(client_id, author_bookname_id) VALUES (1, 2);

INSERT INTO author (firstname, surname, middlename) VALUES ('Иван', 'Тургенев', 'Сергеевич');
INSERT INTO author (firstname, surname, middlename) VALUES ('Александр', 'Пушкин', 'Сергеевич');
INSERT INTO author (firstname, surname, middlename) VALUES ('Федор', 'Достоевский', 'Иванович');
INSERT INTO author (firstname, surname) VALUES ('Джек', 'Лондон');
INSERT INTO author (firstname, surname) VALUES ('Марк', 'Твен');

INSERT INTO author_bookname (author_id, bookname, verified) VALUES (3, 'Отцы и дети', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (3, 'Дворянское гнездо', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (4, 'Дубровский', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (4, 'Пиковая дама', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (4, 'Евгений Онегин', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (4, 'Медный всадник', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (5, 'Преступление и наказание', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (5, 'Идиот', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (5, 'Братья Карамазовы', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (6, 'Мартин Иден', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (6, 'Белый клык', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (7, 'Принц и нищий', true);
INSERT INTO author_bookname (author_id, bookname, verified) VALUES (7, 'Приключения Тома Сойера', true);

INSERT INTO book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (3, 'ЭКСМО', '2000', 'В отличном состоянии', true);
INSERT INTO book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (4, 'АСТ', '1993', 'В очень хорошом состоянии', true);
INSERT INTO book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (5, 'ЭКСМО', '2013', 'Книга в хорошем состоянии', true);
INSERT INTO book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (6, 'АСТ', '2001', 'В хорошем состоянии', true);
INSERT INTO book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (7, 'ЭКСМО', '1998', 'Отличное состояние', true);
INSERT INTO book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (8, 'ЭКСМО', '2010', 'Новая книга', true);
INSERT INTO book (author_bookname_id, pubhouse, pub_year, description, verified)
VALUES (9, 'АСТ', '2012', 'Новая книга', true);

INSERT INTO client_having(client_id, book_id) VALUES (1, 3);
INSERT INTO client_wish(client_id, author_bookname_id) VALUES (1, 14);

INSERT INTO client_having(client_id, book_id) VALUES (2, 1);
INSERT INTO client_wish(client_id, author_bookname_id) VALUES (2, 15);

INSERT INTO client_having(client_id, book_id) VALUES (2, 5);
INSERT INTO client_wish(client_id, author_bookname_id) VALUES (2, 8);

INSERT INTO client_having(client_id, book_id) VALUES (2, 2);

INSERT INTO client_having(client_id, book_id) VALUES (2, 3);
INSERT INTO client_wish(client_id, author_bookname_id) VALUES (2, 11);

INSERT INTO client_having(client_id, book_id) VALUES (4, 6);
INSERT INTO client_wish(client_id, author_bookname_id) VALUES (4, 2);

INSERT INTO client_having(client_id, book_id) VALUES (4, 1);
INSERT INTO client_wish(client_id, author_bookname_id) VALUES (4, 4);