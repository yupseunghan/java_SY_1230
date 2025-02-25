create database comunity;
use comunity;
create table board(
	Bo_num int primary key auto_increment,
	Bo_title varchar(50) not null,
    Bo_content longtext not null,
    Bo_writer varchar(15) not null,
    Bo_date datetime not null default current_timestamp,
    Bo_view	int not null default 0
);
select* from board;
insert into board(Bo_title,Bo_content,Bo_writer) value("인사","안녕하세요","abc123");

#1번 게시글을 클릭해서 게시글 내용을 조회할 떄 필요한 쿼리
#조회수 증가, 게시글 내용을 조회
#조회수 증가
update board
set
	Bo_view = Bo_view + 1
where
	Bo_num=1;
#abc123 회원이 1번 게시글을 삭제할 떄 쿼리
delete from board where Bo_num=1;
truncate table board;

#2025년 2월 25일에 작성된 게시글을 조회하는 쿼리
select* from board where Bo_date between "2025-02-25" and "2025-02-25 23:59:59";
#제목이나 내용에 "안녕"을 포함하는 게시글을 조회하는 쿼리
select* from board where Bo_content or Bo_title  like '%안녕%';