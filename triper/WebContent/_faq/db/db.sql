create table service_board(
service_id number primary key, 			-- num service_id ��ȣ
member_id varchar2(20) NOT NULL, 		-- writer member_id ���̵�
service_title varchar2(100) NOT NULL, 	-- subject service_tilte ����
service_email varchar2(40),				-- email service_email ����
service_content clob NOT NULL,			-- content service_content ����
service_pwd varchar2(10) NOT NULL,		-- passwd service_pwd ��й�ȣ
service_reg_date TIMESTAMP NOT NULL,	-- reg_date service_reg_date ��¥
service_readcount number(4) DEFAULT 0,	-- readcount service_readcount ��ȸ��
service_ip varchar2(20) NOT NULL,		-- ip service_ip ������
service_img varchar2(40),				-- image service_img �̹��� ����
service_ref  number  not null, 			-- �׷�( �ۿ� ����...)
service_re_step number not null,		-- �׷� ����
service_level  number not null);			-- �׷� ����
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
	service_id number(7) not null,		-- ���������� ó���� �۹�ȣ 
	member_id varchar2(20) not null,		--�ۼ���, ȸ�� ���̵�
	service_email varchar2(30) ,			-- ����
	service_tilte varchar2(50) not null,		 -- ����
	service_pwd varchar2(12) not null,   	 -- ��й�ȣ
	service_reg_date  date not null, 		 -- �۾� ��¥   
	service_readcount   number(3) default 0,	  -- ��ȸ��
	service_ref  number  not null, 		-- �׷�( �ۿ� ����...)
	service_re_step number not null,		-- �׷� ����
	service_level  number not null,		-- �׷� ����
	service_content  nvarchar2(2000) not null,	-- �۳���
	service_ip varchar2(20)  not null,   		--�� �� ���� ������
	service_img	varchar2(4000),					-- ���� ����
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
    START WITH   1         --���۹�ȣ, 0~9�� �׽�Ʈ �Ϸ� ��ȣ
    INCREMENT BY 1         --������
    MAXVALUE     9999999   --�ִ밪
    CACHE        2         --������ ����� ���� update�Ǵ� ���� �����ϱ����� ĳ�ð�
    NOCYCLE;   



create table free_board (
	free_id varchar2(20) not null,		-- ���������� ó���� �۹�ȣ
	member_id varchar2(20) not null		-- ȸ�� ���̵�
	free_tilte  varchar2(50) not null,		 -- ����
	free_content varchar2(2000) not null,   	 -- �� ����
	free_img   varchar2(50)	  				-- �̹���
	constraint  free_id_pk  primary key(free_id)
);

CREATE SEQUENCE free_board_seq
    START WITH   1         --���۹�ȣ, 0~9�� �׽�Ʈ �Ϸ� ��ȣ
    INCREMENT BY 1         --������
    MAXVALUE     9999999   --�ִ밪
    CACHE        2         --������ ����� ���� update�Ǵ� ���� �����ϱ����� ĳ�ð�
    NOCYCLE;   

create table service_board (
	service_id number(20) not null,		-- ���������� ó���� �۹�ȣ 
	member_id varchar2(20) not null,		--�ۼ���(ȸ�� ���̵�)
	service_tilte varchar2(50) not null,		 -- ����
	service_pwd number(20) not null,   	 -- ��й�ȣ
	service_content  nvarchar2(2000) not null,	-- �۳���
	service_img varchar2(50),				-- �̹���
	service_ref  number  not null, 		-- �׷�( �ۿ� ����...)
	service_re_step number not null,		-- �׷� ����
	service_level  number not null,		-- �׷� ����
	constraint  service_id_pk  primary key(service_id)
) SEGMENT creation IMMEDIATE ;

CREATE SEQUENCE service_board_seq
    START WITH   1         --���۹�ȣ, 0~9�� �׽�Ʈ �Ϸ� ��ȣ
    INCREMENT BY 1         --������
    MAXVALUE     9999999   --�ִ밪
    CACHE        2         --������ ����� ���� update�Ǵ� ���� �����ϱ����� ĳ�ð�
    NOCYCLE;   

insert into service_board(num, name, text, email, faq_date, url)
     values(faq_seq.nextval, 'ha2', 'hihihihi', 'hasd@asd.com', sysdate, 'http://google.com');    
     
insert into faq(num, name, text, email, faq_date, url)
     values(faq_seq.nextval, 'ha2', 'hihihihi', 'hasd@asd.com', sysdate, 'http://google.com');      
select * from service_board;    
desc faq;

drop table service_board;
drop sequence service_board_seq; 
    

�Ѽ�����
------------------------------------
service_board   ���̺��
------------------------------------
service_id, member_id, service_tilte, service_content, service_img, service_pwd, service_ref,
service_re_step, service_level

------------------------------------
free_board   ���̺��
------------------------------------
free_id, member_id, free_tilte, free_content, free_img
