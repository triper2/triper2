CREATE TABLE MEMBER_LIST(
    member_id varchar2(30),
    member_name varchar2(30),
    member_pwd varchar2(30),
    member_phone varchar2(30), 
    member_email varchar2(30), 
    member_img varchar2(30),
    PRIMARY KEY(member_id)
);

create sequence member_num;
drop sequence member_num;
drop table MEMBER_LIST;
SELECT * FROM MEMBER_LIST;
DESC MEMBER_LIST;