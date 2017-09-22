create table product_ski_list(
product_skino number not null,
product_skiname varchar2(50) not null,
product_skiprice number not null,
product_skiinfo clob not null,
product_skiimg varchar2(500) not null,
 PRIMARY KEY (product_skino)
 );
 
 create table product_board_list(
product_boardno number not null,
product_boardname varchar2(50) not null,
product_boardprice number not null,
product_boardinfo clob not null,
product_boardimg varchar2(500) not null,
 PRIMARY KEY (product_boardno)
 );
 create table product_boardcloth_list(
 product_boardclothno number not null,
product_boardclothname varchar2(50) not null,
product_boardclothprice number not null,
product_boardclothinfo clob not null,
product_boardclothimg varchar2(500) not null,
 PRIMARY KEY (product_boardclothno)
 
 );
 
 create table product_skicloth_list(
product_skiclothno number not null,
product_skiclothname varchar2(50) not null,
product_skiclothprice number not null,
product_skiclothinfo clob not null,
product_skiclothimg varchar2(500) not null,
 PRIMARY KEY (product_skiclothno)
 );
 select * from PRODUCT_SKI_LIST;
 select * from product_skicloth_list;
 select * from PRODUCT_board_LIST;
  insert into product_skicloth_list values(1,'SPYDER M LEADER J/K 001',10000,'ski_cloth_info1.PNG','ski_cloth1.PNG');
 insert into product_skicloth_list values(2,'SPYDER M LEADER J/K 002',30000,'ski_cloth_info2.PNG','ski_cloth2.PNG');
 insert into product_skicloth_list values(3,'SPYDER M LEADER J/K 003',10000,'ski_cloth_info3.PNG','ski_cloth3.PNG');
 insert into product_skicloth_list values(4,'SPYDER M LEADER J/K 004',20000,'ski_cloth_info4.PNG','ski_cloth4.PNG');
 insert into product_skicloth_list values(5,' GOLDWIN DEMO JKT 2',20000,'ski_cloth_info5.PNG','ski_cloth5.PNG');

 commit;
 insert into PRODUCT_SKI_LIST values(1,'REDSTER MX',20000,'ski1_info.PNG','ski1.PNG');
 insert into PRODUCT_SKI_LIST values(2,'REDSTER XTI',30000,'ski2_info.PNG','ski2.PNG');
 insert into PRODUCT_SKI_LIST values(3,'REDSTER MX2',40000,'ski3_info.PNG','ski3.PNG');
 insert into PRODUCT_SKI_LIST values(4,'살로몬 W MAX 6',30000,'ski4_info.PNG','ski4.PNG');
 insert into PRODUCT_SKI_LIST values(5,'살로몬 W-MAX 8',30000,'ski5_info.PNG','ski5.PNG');
 insert into PRODUCT_SKI_LIST values(6,'살로몬 W MAX 12',40000,'ski6_info.PNG','ski6.PNG');

 drop table PRODUCT_SKI_LIST;
 drop table product_boardcloth_list;
 drop table product_skicloth_list;
commit;
 

 insert into product_board_list values(1,'DESCENDANT',20000,'board1_info.PNG','board1.PNG');
 insert into product_board_list values(2,'PROCESS OFF-AXIS',30000,'board2_info.PNG','board2.PNG');
 insert into product_board_list values(3,'CUSTOM X',40000,'board3_info.PNG','board3.PNG');
 insert into product_board_list values(4,'DEJA VU FLYING V',30000,'board4_info.PNG','board4.PNG');
 insert into product_board_list values(5,'FEEL GOOD FLYING V',30000,'board5_info.PNG','board5.PNG');
 
 
   insert into product_boardcloth_list values(1,'BURTON BOYS’ MINISHRED STRIKER',10000,'board_cloth_info1.PNG','board_cloth1.PNG');
 insert into product_boardcloth_list values(2,'BURTON GIRLS’ MINISHRED ILLUSION',30000,'board_cloth_info2.PNG','board_cloth2.PNG');
 insert into product_boardcloth_list values(3,'BURTON DUNMORE JACKET',10000,'board_cloth_info3.PNG','board_cloth3.PNG');
 insert into product_boardcloth_list values(4,'BURTON MATCHSTICK JACKET',20000,'board_cloth_info4.PNG','board_cloth4.PNG');
 insert into product_boardcloth_list values(5,'BURTON ANALOG 3LS FOXHOLE JACKET',20000,'board_cloth_info5.PNG','board_cloth5.PNG');

 

 create table reserve_boardcloth(
 bc_orderid number not null,
 boardclothbeginday varchar2(50) not null,
 boardclothendnday varchar2(50) not null,
 boardclothsize varchar2(50) not null,
 product_boardclothno number not null,
 product_boardclothname varchar2(50) not null,
 product_boardclothprice number not null,
 product_boardclothimg varchar2(50) not null,
 memberphone varchar2(50) not null,
 memberpass varchar2(50) not null
 );
 select * from reserve_skicloth;

 
  create sequence bc_orderid_seq
start with 1 
increment BY 1 
maxvalue 999;

create table reserve_ski(
 s_orderid number not null,
 skibeginday varchar2(50) not null,
 skiendday varchar2(50) not null,
 skisize varchar2(50) not null,
 product_skino number not null,
 product_skiname varchar2(50) not null,
 product_skiprice number not null,
 product_skiimg varchar2(50) not null,
 memberphone varchar2(50) not null,
 memberpass varchar2(50) not null
 );
   create sequence s_orderid_seq
start with 1 
increment BY 1 
maxvalue 999;

select * from reserve_ski;
select * from reserve_board;

 create table reserve_board(
 b_orderid number not null,
 boardbeginday varchar2(50) not null,
 boardendday varchar2(50) not null,
 boardsize varchar2(50) not null,
 product_boardno number not null,
 product_boardname varchar2(50) not null,
 product_boardprice number not null,
 product_boardimg varchar2(50) not null,
 memberphone varchar2(50) not null,
 memberpass varchar2(50) not null
 );
 create sequence sc_orderid_seq
start with 1 
increment BY 1 
maxvalue 999;

 create table reserve_skicloth(
 sc_orderid number not null,
 skiclothbeginday varchar2(50) not null,
 skiclothendday varchar2(50) not null,
 skiclothsize varchar2(50) not null,
 product_skiclothno number not null,
 product_skiclothname varchar2(50) not null,
 product_skiclothprice number not null,
 product_skiclothimg varchar2(50) not null,
 memberphone varchar2(50) not null,
 memberpass varchar2(50) not null
 );	
 select * from reserve_skicloth where sc_orderid=?
  select * from reserve_skicloth natural join reserve_board where memberphone = 1 and memberpass = 1;
  
  select * from reserve_ski ;
  select * from reserved_ski where s_orderid='64';
  update reserve_ski set skibeginday ='2017-09-25',skiendday ='2017-09-27',skisize =260 where s_orderid=64 and memberpass='skrlvkf';
  