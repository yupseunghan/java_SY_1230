show databases;
show tables;
/*
#create : 생성
#alter : 수정
#drop : 삭제
#truncate : 테이블 초기화
*/
#데이터 베이스 생성
#create database [if not exists] DB명
# if not exists가 없으면 있는 db를 생성하려는 경우 쿼리에 에러가 발생
# => 이후 쿼리를 실행할 수 없음
create database if not exists student;
use student;
# 데이터베이스 문자 집합을 설정
#alter schema DB명 default character set 새characterset default collate 새collate;

#테이블 생성
/*
create table table명(
	컬럼명 타입[zerofill],[unique],[not null],[defualt 값],[primary key],[auto_increment],
    ...,
    [(constraint 제약조건명 생략가능) primary key(컬럼명),]
    [(constraint 제약조건명 생략가능) foreign key(컬럼명), references 참조테이블명(기본키명),]
    [(constraint 생략가능) check(논리식)]
);
zerofill
	-앞에 0으로 채울 떄 사용
    -5자리 숫자로 정하고, 1을 저장했을 떄 앞에 4자리를 0으로 채움alter
unique
	-컬럼들의 값들이 중복되면 안되는 경우 지정.(보통 대채키에)
not null
	-컬럼이 null 값을 가지면 안도리 떄 사용sys_configvariable

primary key
	-기본키
    -제약 조건으로 설정할 수도 있지만 컬럼명 옆에 지정할 수 있다
    -not null + unique
auto_increment
	-기본키에만 가능, 정수형 속성에 지정 가능
	-데이터를 추가할 때 기본키에 값을 지정하지 않으면 자동으로 1 증가되어서 추가 됨
defualt 값
	-
*/
create table student(
	St_key int primary key auto_increment,
    St_grade int not null default 1,
    St_class int not null default 1,
    St_num int not null default 1,
    St_name varchar(20) not null,
    check(St_grade >= 1),
    check(St_class >= 1),
    check(St_num>=1)
);
#테이블 수정 - 컬럼 추가
#alter table 테이블명 add 컬럼명 타입[...];
alter table student add St_test datetime default current_timestamp;
#테이블 수정 -컬럼 수정
#alter table 테이블명 change 기존 컬럼명 새컬럼명 타입[...]
alter table student change St_test test char(4) not null;
#테이블 수정 -컬럼 삭제
#alter table 테이블명 drop 컬럼명;
alter table student drop test;
#등록된 모든 check 제약 조건 확인
select * from information_schema.check_constraints;
#테이블 수정 - 제약 조건 추가
#alter table 테이블명 add constraint 제약조건명 제약조건
alter table student add constraint student_chk4 check(St_name !='');
#테이블 수정 - 제약 조건 삭제
#alter table 테이블명 drop constraint 제약조건명;
alter table student drop constraint student_chk4;
#테이블 초기화 : auto_increment 값을 1호 초기화 및 데이터 제거
#truncate table(테이블명);
insert into student.student(St_grade,St_class,St_num,St_name)
values(1,1,1,"홍길동"),(1,1,2,"임꺽정");

select* from student.student;

insert into student.student(St_grade,St_class,St_num,St_name)
values(1,1,3,"홍길동"),(1,1,4,"임꺽정");

truncate table student.student;