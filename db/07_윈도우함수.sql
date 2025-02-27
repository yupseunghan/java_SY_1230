DROP DATABASE IF EXISTS WINDOW_FUNC;
CREATE DATABASE WINDOW_FUNC;
USE WINDOW_FUNC;
CREATE TABLE TEAM_SCORE(
	TS_TEAM CHAR(1) PRIMARY KEY,
    TS_SCORE INT NOT NULL default 0
);
#윈도우 함수
#테이블의 행과 행 사이의 관계를 정의하는 함수
#OVER절이 들어간 함수
# 순위를 표현할 때 사용
# A : 10, B : 5, C : 10,D : 10,E : 10, F : 9, G : 8
INSERT INTO TEAM_SCORE VALUES("A",10),("B",5),("C",10),("D",10),("E",9),("F",9),("G",8);
# ROW_NUMBER() OVER(ORDER BY 속성 정렬방법)
# - 값이 같더라도 다른 번호를 부여
SELECT row_number() over(order by TS_SCORE) AS 순위,TEAM_SCORE. * FROM TEAM_SCORE;

#RANK() OVER(ORDER BY 속성정렬방법)
# 값이 같으면 같은 등수로 표시. 다음 등수는 같은 등수가 있는 개수만큼 건너 뜀
SELECT RANK() OVER(ORDER BY TS_SCORE DESC) AS 순위, TEAM_SCORE. * FROM TEAM_SCORE;

#DENSE_RANK() OVER(ORDER BY 속성정렬방법)
# 값이 같으면 같은 등수로 표시. 다음 등수는 건너뛰지 않고 이어서 진행
SELECT DENSE_RANK() OVER(ORDER BY TS_SCORE DESC) AS 순위, TEAM_SCORE. * FROM TEAM_SCORE;
#NTILE(그룹수) OVER(ORDER BY 속성 정렬방법)
#결과 전체를 지정된 그룹수만큼 분할하여 번호를 할당
SELECT NTILE(2) OVER(ORDER BY TS_SCORE DESC) AS 순위,TEAM_SCORE.*FROM TEAM_SCORE;
