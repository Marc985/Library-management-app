CREATE TABLE IF NOT EXISTS book (
id_book varchar(60) not null primary key,
book_name varchar(50) not null,
page_numbers int not null,
release_date date not null,
topic varchar(30) check(topic='COMEDY' or topic='ROMANCE' or topic='OTHER') not null,
id_author varchar(50)  REFERENCES author(id_author),
id_visitor varchar(50) REFERENCES visitor(reference)
);

INSERT INTO book values
('1','prothetie',40,'2022-07-08','OTHER','1','STD22002'),
('2', 'Comedy Book', 100, '2022-08-15', 'COMEDY', '2','STD22001'),
('3', 'Romance Novel', 200, '2022-09-20', 'ROMANCE', '3','STD22000');