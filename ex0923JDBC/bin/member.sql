create table big_member(
	id varchar2(500) primary key,
	pw varchar2(500) not null,
	nick varchar2(500) not null,
	phone varchar2(500) not null
)

insert into big_member values('admin','1234','������','010-2230-0158');

select * from BIG_MEMBER;

id�� admin ����� ��ȭ��ȣ�� 010-1111-2222

update big_member
set phone = '010-1111-2222'
where id = 'admin'

id�� admin�� ����� �����͸� �����Ͻÿ�.

delete from big_member
where id = 'admin'