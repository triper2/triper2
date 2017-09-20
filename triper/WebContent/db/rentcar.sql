create table product_list(
product_carno number not null,
product_carname varchar2(50) not null,
product_carcompany varchar2(50) not null,
product_carprice number not null,
product_carusepeople number not null,
product_carinfo varchar2(500) not null,
product_carimg varchar2(500) not null,
product_carcategory varchar2(10) not null,
 PRIMARY KEY (product_carno)
 );
 delete from product_list where	product_carno=22222;
 delete from product_list where	product_carno=123;
 delete from product_list where	product_carno=3434;
 delete from product_list where	product_carno=444;
 delete from product_list where	product_carno=15;
 delete from product_list where product_carno=234;
 delete from product_list where	product_carno=1000;
 delete from product_list where	product_carno=345345;
 select * from product_list;
 commit;
 insert into product_list values (?,?,?,?,?,?,?,?)
 insert into PRODUCT_LIST values(1,'아반테','현대',80000,4,'이 차량은 소형차량 입니다.','avante.jpg','Small');
 insert into PRODUCT_LIST values(2,'모닝','기아',70000,4,'이 차량은 소형차량 입니다.','morning.jpg','Small');
 insert into PRODUCT_LIST values(3,'k3','현대',80000,4,'이 차량은 소형차량 입니다.','k3.jpg','Small');
 insert into PRODUCT_LIST values(4,'코란도','쌍용',90000,4,'이 차량은 소형차량 입니다.','korando.jpg','Small');
 insert into PRODUCT_LIST values(101,'k5','기아',80000,4,'이 차량은 중형차량 입니다.','k5.jpg','Mid');
 insert into PRODUCT_LIST values(102,'말리부','쉐보레',90000,4,'이 차량은 중형차량 입니다.','malibu.jpg','Mid');
 insert into PRODUCT_LIST values(103,'bmw528i','BMW',130000,4,'이 차량은 중형차량 입니다.','bmw528i.jpg','Mid');
 insert into PRODUCT_LIST values(104,'k7','기아',90000,4,'이 차량은 중형차량 입니다.','k7.jpg','Mid');
 insert into PRODUCT_LIST values(201,'에쿠스','현대',150000,5,'이 차량은 대형차량 입니다.','equus.jpg','Big');
 insert into PRODUCT_LIST values(202,'그렌져','현대',140000,5,'이 차량은 대형차량 입니다.','grandeur.jpg','Big');
 insert into PRODUCT_LIST values(203,'카니발','기아',120000,9,'이 차량은 대형차량 입니다.','canival.jpg','Big');
 insert into PRODUCT_LIST values(204,'k9','기아',120000,4,'이 차량은 대형차량 입니다.','k9.jpg','Big');
 
 create table reserved_list (
 
 orderid number not null,
 product_carno number not null,
 reserved_product_count number(7) not null,
 reserved_carbegindate varchar2(30) not null,
 reserved_carenddate varchar2(30) not null,
 reserved_option_usein number(7) not null,
 reserved_option_carwifi number(7) not null,
 reserved_option_carnavi number(7) not null,
 reserved_option_carseat number(7) not null,
 memberphone varchar2(50) not null,
 memberpass varchar2(50) not null,
 totalprice number,
 calDateDays number
 );
 select * from reserved_list;
drop table reserved_list;
 select * from user_sequences;
 
 drop sequence order_seq;
 create sequence order_seq
start with 1 
increment BY 1 
maxvalue 999;
 
select * from RESERVED_LIST;

 select * from product_list natural join reserved_list  where 
sysdate > to_date(reserved_carbegindate  , 'YYYY-MM-DD') 
and memberphone='1234' and memberpass='234';


select * from product_list natural join reserved_list where 
sysdate < to_date(reserved_carbegindate , 'YYYY-MM-DD') 
and memberphone='qwe' and memberpass='qwe';


select * from reserved_list where orderid=4;


update reserved_list set reserved_product_count =3
 where orderid=5555 ;
 
 select * from reserved_list where memberpass='55555';
 
 delete from reserved_list  where orderid=10 and memberpass='12345';
 
 
 select * from reserved_list where orderid=123;
 
 select * from RESERVED_LIST where memberphone='qwe'; 
 
 