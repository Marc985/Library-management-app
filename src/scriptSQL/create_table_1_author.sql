CREATE TABLE IF NOT EXISTS author(
id_author varchar(50) primary key,
name varchar(50),
sex varchar(1) check (sex='M' or sex='F')
);

INSERT INTO author VALUES
('1','Jean Dixon','F'),
('2', 'Paul Smith', 'M'),
('3', 'Alice Johnson', 'F');