create table event_board (
ebNum int,
ebTitle varchar(100),
member_id varchar(20),
ebDate date,
ebContent varchar(2048),
ebAvailable int,
primary key (ebNum)
);

SELECT * FROM event_board;
