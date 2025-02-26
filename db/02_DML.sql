# CREATE   : 생성
# ALTER    : 수정
# DROP     : 삭제
# TRUNCATE : 테이블을 초기화
# []는 생략 가능

# 데이터베이스 생성
# CREATE DATABASE [IF NOT EXISTS] DB명 
# CREATE SCHEMA [IF NOT EXISTS] DB명 
# IF NOT EXISTS가 없으면 있는 DB를 생성하려는 경우 쿼리에 에러가 발생
# => 이후 쿼리를 실행할 수 없음
CREATE DATABASE IF NOT EXISTS STUDENT;

# 데이터베이스 삭제
# DROP DATABASE [IF EXISTS] DB명
# DROP SCHEMA [IF EXISTS] DB명
# DROP DATABASE IF EXISTS STUDENT;

# 데이터베이스 문자 집합을 설정
# ALTER SCHEMA DB명 DEFAULT CHARACTER SET 새CHARACTERSET DEFAULT COLLATE 새COLLATE;

# 테이블 생성 
/*
CREATE TABLE [IF NOT EXISTS] 테이블명(
	컬럼명 타입 [ZEROFILL] [UNIQUE] [NOT NULL] [DEFAULT 값] [PRIMARY KEY] [AUTO_INCREMENT],
    ...,
	[ CONSTRAINT 제약조건명 PRIMARY KEY(컬럼명),]
    [ PRIMARY KEY(컬럼명),]
    [ CONSTRAINT 제약조건명 FOREIGN KEY(컬럼명) REFERENCES 참조테이블명(기본키명),]
    [ FOREIGN KEY(컬럼명) REFERENCES 참조테이블명(기본키명),]
    [ CONSTRAINT 제약조건명 CHECK(논리식),]
    [ CHECK(논리식)]
);

ZEROFILL
  - 앞에 0으로 채울 때 사용
  - 5자리 숫자로 정하고, 1을 저장했을 때 앞에 4자리를 0으로 채움
UNIQUE
  - 컬럼들의 값들이 중복되면 안되는 경우 지정.(보통 대체키에) 
NOT NULL
  - 컬럼이 NULL값을 가지면 안될 때 사용 
PRIMARY KEY
  - 기본키 
  - 제약 조건으로 설정할 수도 있지만 컬럼명 옆에 지정할 수 있다 
  - NOT NULL + UNIQUE 
AUTO_INCREMENT
  - 기본키에만 가능, 정수형 속성에 지정 가능 
  - 데이터를 추가할 때 기본키에 값을 지정하지 않으면 자동으로 1 증가되어서 추가 됨 
*/
USE STUDENT;
CREATE TABLE IF NOT EXISTS STUDENT(
	ST_KEY INT PRIMARY KEY AUTO_INCREMENT, 
    ST_GRADE INT NOT NULL DEFAULT 1,
    ST_CLASS INT NOT NULL DEFAULT 1,
    ST_NUM INT NOT NULL DEFAULT 1,
    ST_NAME VARCHAR(20) NOT NULL,
    CHECK(ST_GRADE >= 1), 
    CHECK(ST_CLASS >= 1),
    CHECK(ST_NUM >= 1)
);

# 테이블 삭제 
# DROP TABLE [IF EXISTS] 테이블명;
# DROP TABLE STUDENT;

# 테이블 수정 - 컬럼 추가
# ALTER TABLE 테이블명 ADD 컬럼명 타입 [...];
ALTER TABLE STUDENT ADD ST_TEST DATETIME DEFAULT CURRENT_TIMESTAMP;

# 테이블 수정 - 컬럼 수정 
# ALTER TABLE 테이블명 CHANGE 기존컬럼명 새컬럼명 타입 [...];
ALTER TABLE STUDENT CHANGE ST_TEST TEST CHAR(3) NOT NULL;

# 테이블 수정 - 컬럼 삭제 
# ALTER TABLE 테이블명 DROP 컬럼명;
ALTER TABLE STUDENT DROP TEST;

# 등록된 모든 CHECK 제약 조건 확인
SELECT * FROM INFORMATION_SCHEMA.CHECK_CONSTRAINTS;

# 테이블 수정 - 제약 조건 추가 
# ALTER TABLE 테이블명 ADD CONSTRAINT 제약조건명 제약조건 
ALTER TABLE STUDENT ADD CONSTRAINT STUDENT_CHK4 CHECK(ST_NAME != '');

# 테이블 수정 - 제약 조건 삭제
# ALTER TABLE 테이블명 DROP CONSTRAINT 제약조건명;
ALTER TABLE STUDENT DROP CONSTRAINT STUDENT_CHK4;

# 테이블 초기화 : AUTO_INCREMENT 값을 1로 초기화 및 데이터 제거 
# TRUNCATE TABLE 테이블명;

INSERT INTO STUDENT.STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME)
VALUES(1,1,1, "홍길동"), (1,1,2,"임꺽정"); 

SELECT * FROM STUDENT.STUDENT;

INSERT INTO STUDENT.STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME)
VALUES(1,1,3, "홍길동"), (1,1,4,"임꺽정"); 

SELECT * FROM STUDENT.STUDENT;

# TRUNCATE TABLE STUDENT.STUDENT;
DELETE FROM STUDENT.STUDENT;

INSERT INTO STUDENT.STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME)
VALUES(1,1,1, "홍길동"), (1,1,2,"임꺽정"); 

update student.student set St_name="고길홍" where St_key=3;
SELECT * FROM STUDENT.STUDENT;
#성이 홍씨인 학생들을 조회하는 쿼리
select* from student.student where St_name like '홍%';
select* from student.student where St_name like concat('홍','%');
#이름에 길이 들어가는 학생들을 조회하는 쿼리
select* from student.student where St_name like '%길%';
#성이 홍씨이고 이름이 3글자인 학생들을 조회하는 쿼리
select* from student.student where St_name like '홍__';
insert into student.student(St_grade,St_class,St_num,St_name) values
(2,1,2,"김길동"),(2,1,1,"가길동"),(2,1,3,"나길동"),(2,2,1,"이길동"),(2,2,2,"박길동"),
(2,2,3,"하길동"),(2,3,1,"하니"),(2,3,2,"가니"),(2,3,3,"둘리"),
(3,1,2,"김길동"),(3,1,1,"가길동"),(3,1,3,"나길동"),(3,2,1,"이길동"),(3,2,2,"박길동"),
(3,2,3,"하길동"),(3,3,1,"하니"),(3,3,2,"가니"),(3,3,3,"둘리");
insert into student.subject(Sj_grade,Sj_semster,Sj_name) values
(1,1,"국어"),(1,1,"영어"),(1,1,"수학"),
(1,2,"국어"),(1,2,"영어"),(1,2,"수학"),
(2,1,"국어"),(2,1,"영어"),(2,1,"수학"),
(2,2,"국어"),(2,2,"영어"),(2,2,"수학"),
(3,1,"국어"),(3,1,"영어"),(3,1,"수학"),
(3,2,"국어"),(3,2,"영어"),(3,2,"수학");
select*from student.score;
insert into student.score(Sc_St_key,Sc_Sj_num,Sc_score) values
(1,1,100),(1,2,100),(1,3,100), #1학년 1반 1번 학생 국영수 성적
(3,1,90),(3,2,80),(3,3,70),
(2,1,10),(2,2,40),(2,3,60),
(5,1,100),(5,2,100),(5,3,100),
(6,4,100),(6,5,100),(6,6,100),
(7,4,100),(7,5,100),(7,6,100),
(8,4,100),(8,5,100),(8,6,100),
(9,4,100),(9,5,100),(9,6,100),
(10,4,100),(10,5,100),(10,6,100),
(11,4,100),(11,5,100),(11,6,100);
#3학년, 2학년, 1학년 순으로 조회하고 학년이 같은 경우 1반 2반 순 조화 , 반이 같은경우 1번 2번 순 조회
select* from student order by St_grade desc ,St_class,St_num;

#3학년 학생들을 이름순으로 정렬하고, 이름이 같으면 반, 번호,순으로 오름차순으로 정렬하는 쿼리
select* from student where St_grade=3 order by St_name,St_class,St_num;

#3학년 학생중 번호가 2에 가까운 학생 순으로 정렬
select* ,ABS(St_num -2) as num from student where St_grade=3 order by num,St_num;

#한 페이지에 학생 3명의 정보를 조회하는 페이지가 있고, 학생 등록순으로 조회를 한다.
#이 때 3페이지에서 조회 가능한 학생들을 선택하는 쿼리
select* from student /*order 생략 가능 by St_key*/ limit 6,3;
#1학년 1반의 학생수를 조회
select count(*) as"1학년 1반 하생 수" from student where St_grade=1 and St_class=1;
# 각학년 각반의 학생수를 조회
select St_grade,St_class,count(St_key) as"학생수"
 from student group by St_grade,St_class;
#각학년별 학생수 조회
select St_grade,count(*) as "학생수" from student group by St_grade;
#학생수가 5명 이상인 학년들을 조회
select St_grade,count(*) as `학생수` from student group by St_grade having`학생수` >= 5;

#group by가 있는 쿼리에서 조건이 필요하면 무조건 having절에 써야한다 : xxxxxxxxxxxxxxxx
#조건에 집계함수가 없으면 where절, 있으면 having절
drop database if exists student;
create database if not exists student;
select* from student.subject;
create table student.subject(
	Sj_num int primary key auto_increment,
    Sj_grade int not null default 1,
    Sj_semster enum("1","2") not null default "1",
    Sj_name varchar(10) not null,
    check(Sj_grade in(1,2,3))
);

create table student.score(
	Sc_num int primary key auto_increment,
    Sc_St_key int not null,
    Sc_Sj_num int not null,
    Sc_score int not null default 0,
    check(Sc_score between 0 and 100),
    foreign key(Sc_St_key) references student.student(St_key),
    foreign key(Sc_Sj_num) references student.subject(Sj_num)
);
