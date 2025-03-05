# INSERT : 데이터 추가
# SELECT : 데이터 조회
# UPDATE : 데이터 수정
# DELETE : 데이터 삭제

# 데이터 추가
# INSERT INTO 테이블명 VALUE(값1, ..., 값N) 
#   - 값들 순서는 속성 순서에 맞게 넣어 주어야 함.  
#   - 테이블명 대신 DB명.테이블명으로 해도 됨
#   - DB명.테이블명으로 쓰면 선택된 DB와 상관없이 실행.
#   - 테이블명만 쓰면 선택된 DB에 따라 동작되지 않을 수 있음. 
USE STUDENT;
INSERT INTO STUDENT (ST_GRADE, ST_CLASS, ST_NUM, ST_NAME)VALUE(1, 1, 1, "홍길동");
select* from student where ST_GRADE =3 and ST_CLASS=3 and ST_NUM=11;
# INSERT INTO 테이블명(속성1, ..., 속성N) VALUE(값1, ..., 값N)
#   - 일부 속성 값을 생략할 때 사용
#   - 생략할 수 있는 속성들
#     1. NULL 허용인 속성들 
#     2. NOT NULL이지만 DEFAULT를 이용하여 기본값을 지정한 속성들 
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUE(1, 1, 2, "임꺽정");
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUE(3, "고길동");

# INSERT INTO 테이블명(속성1, ..., 속성N) VALUES(값1, ..., 값N), (값1, ..., 값N), ...; 
INSERT INTO STUDENT(ST_NUM, ST_NAME) VALUES(4, "둘리"), (5, "하니");

# INSERT INTO 테이블명(속성1, ..., 속성N) SELECT 값1, 값2, ..., 속성A FROM 테이블명 WHERE 조건
#   - 테이블에서 검색된 값을 이용하여 추가할 때 사용 
#   - 여기서 값1, 값2.. 들은 지정된 값이고, 속성A는 검색 결과 값 


# 데이터 수정
# UPDATE 테이블명 SET 속성1 = 값1, ..., 속성N = 값N WHERE 조건 
# 조건에서 같다는 =, 같지 않다는 != 또는 <> 
# NULL과 같다는 IS NULL, NULL과 같지 않다는 IS NOT NULL 
# 1학년 1반 1번 학생의 이름을 홍길동A로 수정하는 쿼리 
UPDATE STUDENT 
SET 
    ST_NAME = '홍길동'
WHERE
    ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1;
    
# 데이터 삭제
# DELETE FROM 테이블명 WHERE 조건;
# 1학년 1반 2번 학생의 데이터를 삭제하는 쿼리
DELETE FROM STUDENT 
WHERE
    ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 2;

# 학생들 샘플 데이터 추가 
INSERT INTO STUDENT(ST_GRADE, ST_CLASS, ST_NUM, ST_NAME) VALUES
(2, 1, 1, "김길동"), (2, 1, 2, "가길동"),(2, 1, 3, "나길동"),
(2, 2, 1, "이길동"), (2, 2, 2, "박길동"),(2, 2, 3, "하길동"),
(2, 3, 1, "하니"), (2, 3, 2, "가니"),(2, 3, 3, "김둘리"),

(3, 1, 1, "김길동"), (3, 1, 2, "가길동"),(3, 1, 3, "나길동"),
(3, 2, 1, "이길동"), (3, 2, 2, "박길동"),(3, 2, 3, "하길동"),
(3, 3, 1, "하니"), (3, 3, 2, "가니"),(3, 3, 3, "김둘리");
select* from student.student;
select* from student.subject;
select* from student.score;
# 과목 샘플 데이터를 추가 
INSERT INTO STUDENT.SUBJECT(SJ_GRADE, SJ_SEMESTER, SJ_NAME) VALUES
(1, 1, "국어"), (1, 1, "영어"), (1, 1, "수학"), 
(1, 2, "국어"), (1, 2, "영어"), (1, 2, "수학"), 
(2, 1, "국어"), (2, 1, "영어"), (2, 1, "수학"), 
(2, 2, "국어"), (2, 2, "영어"), (2, 2, "수학"), 
(3, 1, "국어"), (3, 1, "영어"), (3, 1, "수학"), 
(3, 2, "국어"), (3, 2, "영어"), (3, 2, "수학");
# 성적 샘플 데이터를 추가 
INSERT INTO STUDENT.SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE) VALUES
(1, 1, 100), (1, 2, 100), (1, 3, 100), # 1학년 1반 1번 학생 1학년 1학기 국영수 성적
(3, 1, 90), (3, 2, 80), (3, 3, 70), # 1학년 1반 3번 학생 1학년 1학기 국영수 성적
(4, 1, 90), (4, 2, 10), (4, 3, 100), # 1학년 1반 4번 학생 1학년 1학기 국영수 성적
(5, 1, 90), (5, 2, 100), (5, 3, 10), # 1학년 1반 5번 학생 1학년 1학기 국영수 성적
(6, 4, 100), (6, 5, 0), (6, 6, 100), # 2학년 1반 1번 학생 1학년 2학기 국영수 성적;
(7, 4, 50), (7, 5, 30), (7, 6, 80), # 2학년 1반 2번 학생 1학년 2학기 국영수 성적;
(8, 4, 40), (8, 5, 55), (8, 6, 99), # 2학년 1반 3번 학생 1학년 2학기 국영수 성적;
(9, 4, 10), (9, 5, 84), (9, 6, 55), # 2학년 2반 1번 학생 1학년 2학기 국영수 성적;
(10, 4, 75), (10, 5, 66), (10, 6, 74), # 2학년 2반 2번 학생 1학년 2학기 국영수 성적;
(11, 4, 32), (11, 5, 44), (11, 6, 65), # 2학년 2반 3번 학생 1학년 2학기 국영수 성적;
(12, 4, 77), (12, 5, 88), (12, 6, 55), # 2학년 3반 1번 학생 1학년 2학기 국영수 성적;
(13, 4, 88), (13, 5, 12), (13, 6, 12), # 2학년 3반 2번 학생 1학년 2학기 국영수 성적;
(14, 4, 0), (14, 5, 0), (14, 6, 0), # 2학년 3반 3번 학생 2학년 1학기 국영수 성적;
(15, 7, 100), (15, 8, 100), (15, 9, 100); # 3학년 1반 1번 학생 2학년 1학기 국영수 성적;
# 1학년 1반 1번의 1학년 2학기 국어 성적을 100으로 추가할 때 쿼리 
SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1;
SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어";
SELECT ST_KEY,SJ_NUM
FROM STUDENT 
JOIN SUBJECT
WHERE 
	ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1
    AND SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어";

SELECT ST_KEY,SJ_NUM
FROM (SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1) AS T1
JOIN (SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어") AS T2;
# 1학년 1반 1번의 1학년 2학기 국어 성적을 100으로 추가할 때 쿼리
INSERT INTO SCORE(SC_ST_KEY, SC_SJ_NUM, SC_SCORE)
SELECT ST_KEY,SJ_NUM, 100
	FROM (SELECT ST_KEY FROM STUDENT WHERE ST_GRADE = 1 AND ST_CLASS = 1 AND ST_NUM = 1) AS T1
	JOIN (SELECT SJ_NUM FROM SUBJECT WHERE SJ_GRADE = 1 AND SJ_SEMESTER = 2 AND SJ_NAME = "국어") AS T2;