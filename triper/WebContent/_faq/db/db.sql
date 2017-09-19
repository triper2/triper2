create table service_board(
service_id number primary key, 			-- num service_id 번호
member_id varchar2(20) NOT NULL, 		-- writer member_id 아이디
service_title varchar2(100) NOT NULL, 	-- subject service_tilte 제목
service_email varchar2(40),				-- email service_email 메일
service_content clob NOT NULL,			-- content service_content 내용
service_pwd varchar2(10) NOT NULL,		-- passwd service_pwd 비밀번호
service_reg_date TIMESTAMP NOT NULL,	-- reg_date service_reg_date 날짜
service_readcount number(4) DEFAULT 0,	-- readcount service_readcount 조회수
service_ip varchar2(20) NOT NULL,		-- ip service_ip 아이피
service_img varchar2(40),				-- image service_img 이미지 저장
service_ref  number  not null, 			-- 그룹( 글에 대한...)
service_re_step number not null,		-- 그룹 스텝
service_level  number not null);			-- 그룹 레벨
create sequence service_board_seq;

select * from service_board;

drop table service_board;
drop sequence service_board_seq; 

insert into service_board(service_id, member_id, service_title, service_email, service_content, service_pwd, service_reg_date, service_readcount, service_ip, service_ref, service_re_step, service_level) 
		values(service_board_seq.nextval, 'b', 'b', 'b', 'b', '1', sysdate, 1, '127.0.0.1', 1, 1, 1);    

insert into album(num, writer, subject, email, content, passwd, reg_date, readcount, ip, service_ref, service_re_step, service_level) 
		values(album_seq.nextval, 'b', 'b', 'b', 'b', '1', sysdate, 1, '127.0.0.1', 1, 1, 1);    

select * from album;

desc faq;

drop table service_board;
drop sequence board_service_id; 

create table service_board (
	service_id number(7) not null,		-- 내부적으로 처리될 글번호 
	member_id varchar2(20) not null,		--작성자, 회원 아이디
	service_email varchar2(30) ,			-- 메일
	service_tilte varchar2(50) not null,		 -- 제목
	service_pwd varchar2(12) not null,   	 -- 비밀번호
	service_reg_date  date not null, 		 -- 글쓴 날짜   
	service_readcount   number(3) default 0,	  -- 조회수
	service_ref  number  not null, 		-- 그룹( 글에 대한...)
	service_re_step number not null,		-- 그룹 스텝
	service_level  number not null,		-- 그룹 레벨
	service_content  nvarchar2(2000) not null,	-- 글내용
	service_ip varchar2(20)  not null,   		--글 쓴 곳의 아이피
	service_img	varchar2(4000),					-- 파일 저장
	constraint  board_service_id_pk  primary key(service_id)
	) SEGMENT creation IMMEDIATE ;
	
	create sequence board_service_id;	
	
insert into service_board(service_id, member_id, service_tilte,  service_pwd, service_reg_date, service_readcount, service_ref, 
service_re_step, service_level, service_content, service_ip) value(
service_board_seq.nextval, 'hi', 'hi', '1234', sysdate, 1, 1, 1, 1, 'hi', '3434');

insert into service_board(service_id, member_id, service_tilte, service_email, service_content, service_pwd, service_reg_date, service_ref, service_re_step, service_level, service_ip) 
		values(board_service_id.nextval, 'b', 'b', 'b', 'b', 'b', sysdate, 1, 1, 1, 1);     

select * from service_board;  


CREATE SEQUENCE service_board_seq
    START WITH   1         --시작번호, 0~9는 테스트 일련 번호
    INCREMENT BY 1         --증가값
    MAXVALUE     9999999   --최대값
    CACHE        2         --시쿼스 변경시 자주 update되는 것을 방지하기위한 캐시값
    NOCYCLE;   



create table free_board (
	free_id varchar2(20) not null,		-- 내부적으로 처리될 글번호
	member_id varchar2(20) not null		-- 회원 아이디
	free_tilte  varchar2(50) not null,		 -- 제목
	free_content varchar2(2000) not null,   	 -- 글 내용
	free_img   varchar2(50)	  				-- 이미지
	constraint  free_id_pk  primary key(free_id)
);

CREATE SEQUENCE free_board_seq
    START WITH   1         --시작번호, 0~9는 테스트 일련 번호
    INCREMENT BY 1         --증가값
    MAXVALUE     9999999   --최대값
    CACHE        2         --시쿼스 변경시 자주 update되는 것을 방지하기위한 캐시값
    NOCYCLE;   

create table service_board (
	service_id number(20) not null,		-- 내부적으로 처리될 글번호 
	member_id varchar2(20) not null,		--작성자(회원 아이디)
	service_tilte varchar2(50) not null,		 -- 제목
	service_pwd number(20) not null,   	 -- 비밀번호
	service_content  nvarchar2(2000) not null,	-- 글내용
	service_img varchar2(50),				-- 이미지
	service_ref  number  not null, 		-- 그룹( 글에 대한...)
	service_re_step number not null,		-- 그룹 스텝
	service_level  number not null,		-- 그룹 레벨
	constraint  service_id_pk  primary key(service_id)
) SEGMENT creation IMMEDIATE ;

CREATE SEQUENCE service_board_seq
    START WITH   1         --시작번호, 0~9는 테스트 일련 번호
    INCREMENT BY 1         --증가값
    MAXVALUE     9999999   --최대값
    CACHE        2         --시쿼스 변경시 자주 update되는 것을 방지하기위한 캐시값
    NOCYCLE;   

insert into service_board(num, name, text, email, faq_date, url)
     values(faq_seq.nextval, 'ha2', 'hihihihi', 'hasd@asd.com', sysdate, 'http://google.com');    
     
insert into faq(num, name, text, email, faq_date, url)
     values(faq_seq.nextval, 'ha2', 'hihihihi', 'hasd@asd.com', sysdate, 'http://google.com');      
select * from service_board;    
desc faq;

drop table service_board;
drop sequence service_board_seq; 
    

한수형님
------------------------------------
service_board   테이블명
------------------------------------
service_id, member_id, service_tilte, service_content, service_img, service_pwd, service_ref,
service_re_step, service_level

------------------------------------
free_board   테이블명
------------------------------------
free_id, member_id, free_tilte, free_content, free_img
