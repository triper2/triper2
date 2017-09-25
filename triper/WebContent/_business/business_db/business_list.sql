create table business_list(
business_id varchar2(100),
business_name varchar2(100),
business_address varchar2(200),
business_tel varchar2(100),
business_x varchar2(100),
business_y varchar2(100),
member_id varchar2(30),
primary key (business_id),
foreign Key (member_id) REFERENCES member_list (member_id)
);